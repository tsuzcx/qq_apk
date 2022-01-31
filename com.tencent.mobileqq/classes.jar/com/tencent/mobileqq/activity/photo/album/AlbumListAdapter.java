package com.tencent.mobileqq.activity.photo.album;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumListAdapter
  extends BaseAdapter
{
  static final String BUCKET_ORDER_BY = "date_modified DESC";
  static final String BUCKET_SELECTION = "_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png'";
  public static final String BUCKET_SELECTION_END = ")) GROUP BY (1";
  static final String BUCKET_SELECTION_FILTER_GIF = "_size>0 and (mime_type='image/jpeg' or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png')) GROUP BY (1";
  public static final String BUCKET_SELECTION_FOR_HEIF = " or mime_type='image/heif' or mime_type='image/heic'";
  static final String BUCKET_SELECTION_FOR_SLIDESHOW;
  public static final String BUCKET_SELECTION_FOR_WEBP = " or mime_type='image/webp'";
  static final ColorDrawable COLOR_DRAWABLE = new ColorDrawable(-2141891243);
  static final String IMAGE_ORDER_BY = "_id DESC";
  static final String[] PROJECTION_BUCKET = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static final String TAG = "AlbumListAdapter";
  static final String VIDEO_BUCKET_ORDER_BY = "date_modified DESC";
  static final String VIDEO_BUCKET_SELECTION = "_size>0 and mime_type='video/mp4') GROUP BY (1";
  static final String[] VIDEO_COLUMNS;
  static final String VIDEO_ORDER_BY = "_id DESC";
  static final String[] VIDEO_PROJECTION_BUCKET;
  static String[] columns;
  private boolean hasAddQzoneAlbum = false;
  AlbumListLogic.IalbumListAdapterCallBack mAlbumListCallback;
  private List<QQAlbumInfo> mCommonAlbums;
  public int mCoverHeight;
  public int mCoverWidth;
  private List<QQAlbumInfo> mDataInfos = new ArrayList();
  boolean mIsShowVideoAlbum;
  private QQAlbumInfo mLocalVideoAlbum;
  private QQAlbumInfo mRecentAlbum;
  public Resources mResources;
  Drawable.ConstantState mRightArrow;
  Handler mUiHandler = new Handler();
  
  static
  {
    BUCKET_SELECTION_FOR_SLIDESHOW = "_size>0 and ( _size < " + QAlbumUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (" + "width" + ">= 240 or " + "width" + " IS NULL) and (" + "height" + ">= 240 or " + "height" + " IS NULL )  and " + "height" + "  * 1.0 / " + "width" + ">= 0.45 and " + "height" + "  * 1.0 / " + "width" + "<= 2.2 and (" + "mime_type" + "='" + "image/jpeg" + "' or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpeg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.bmp%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.png%' )  or " + "mime_type" + " LIKE'%" + "bmp" + "%' or " + "mime_type" + " LIKE'%" + "bitmap" + "%' or " + "mime_type" + "='" + "image/png" + "'";
    if (Build.VERSION.SDK_INT >= 16) {}
    for (columns = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; columns = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      VIDEO_PROJECTION_BUCKET = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public AlbumListAdapter(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    this.mAlbumListCallback = paramAbstractAlbumListFragment.mAlbumListLogic.mAlbumListAdapterCallBack;
    this.mResources = paramAbstractAlbumListFragment.getResources();
    this.mRightArrow = this.mResources.getDrawable(2130839103).getConstantState();
    this.mCoverWidth = this.mResources.getDimensionPixelSize(2131296381);
    this.mCoverHeight = this.mCoverWidth;
  }
  
  public static String getFileDirectoryOf(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i < 0);
    return paramString.substring(0, i + 1);
  }
  
  static boolean isCameraDir(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  static Cursor queryImages(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, columns, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  public int getCount()
  {
    return this.mDataInfos.size();
  }
  
  protected List<QQAlbumInfo> getDataInfos()
  {
    return this.mDataInfos;
  }
  
  protected List<QQAlbumInfo> getDefaultAlbums()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mRecentAlbum != null) {
      localArrayList.add(this.mRecentAlbum);
    }
    if (this.mLocalVideoAlbum != null) {
      localArrayList.add(this.mLocalVideoAlbum);
    }
    if (this.mCommonAlbums != null) {
      localArrayList.addAll(this.mCommonAlbums);
    }
    return localArrayList;
  }
  
  LocalMediaInfo getFirstPhotoInfo(Cursor paramCursor, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    int i = paramCursor.getColumnIndexOrThrow("_data");
    int j = paramCursor.getColumnIndexOrThrow("_id");
    int k = paramCursor.getColumnIndexOrThrow("date_modified");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int[] arrayOfInt = new int[2];
    for (;;)
    {
      String str;
      long l;
      if (paramCursor.moveToNext())
      {
        str = paramCursor.getString(i);
        l = paramCursor.getLong(j);
        if ((str == null) || (str.length() <= 0)) {
          continue;
        }
        File localFile = new File(str);
        if ((!localFile.exists()) || (!localFile.isFile())) {
          break label210;
        }
        if (paramInt <= 0) {
          break label180;
        }
        getWHByPath(str, localOptions, arrayOfInt);
        if ((arrayOfInt[0] >= paramInt) || (arrayOfInt[1] >= paramInt))
        {
          localLocalMediaInfo._id = l;
          localLocalMediaInfo.path = str;
          localLocalMediaInfo.modifiedDate = paramCursor.getLong(k);
        }
      }
      return localLocalMediaInfo;
      label180:
      localLocalMediaInfo._id = l;
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.modifiedDate = paramCursor.getLong(k);
      return localLocalMediaInfo;
      label210:
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListAdapter", 2, "image does not exist,imagePath is:" + str);
      }
    }
  }
  
  void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {}
    int i1;
    int i2;
    int i4;
    int j;
    BitmapFactory.Options localOptions;
    int[] arrayOfInt;
    int k;
    label101:
    Object localObject2;
    String str;
    Object localObject1;
    do
    {
      return;
      break label101;
      break label101;
      int n;
      int i3;
      while (!paramCursor.moveToNext())
      {
        n = paramCursor.getColumnIndexOrThrow("_data");
        i1 = paramCursor.getColumnIndexOrThrow("orientation");
        i2 = paramCursor.getColumnIndexOrThrow("date_modified");
        i3 = paramCursor.getColumnIndexOrThrow("mime_type");
        i4 = paramCursor.getColumnIndexOrThrow("_size");
        j = 0;
        if (paramBoolean) {
          j = paramCursor.getColumnIndexOrThrow("width");
        }
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        arrayOfInt = new int[2];
        k = 0;
      }
      localObject2 = paramCursor.getString(i3);
      str = paramCursor.getString(n);
      localObject1 = localObject2;
      if (paramMediaFileFilter == null) {
        break;
      }
      localObject1 = localObject2;
      if (!paramMediaFileFilter.filter((String)localObject2)) {
        break;
      }
    } while (!"*/*".equals(localObject2));
    label191:
    long l;
    if ((str.indexOf(".jpg") != -1) || (str.indexOf(".jpeg") != -1))
    {
      localObject1 = "image/jpeg";
      if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
        break label447;
      }
      l = paramCursor.getLong(i2);
      int m = 0;
      i = m;
      if (paramBoolean)
      {
        i = m;
        if (paramCursor.getInt(j) == 0) {
          i = 1;
        }
      }
      if ((paramInt1 <= 0) || ((paramBoolean) && (i == 0))) {
        break label449;
      }
      getWHByPath(str, localOptions, arrayOfInt);
      if (arrayOfInt[0] < paramInt1)
      {
        i = k;
        if (arrayOfInt[1] < paramInt1) {}
      }
      else
      {
        localObject2 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject2).path = str;
        ((LocalMediaInfo)localObject2).modifiedDate = l;
        ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i1);
        ((LocalMediaInfo)localObject2).mMimeType = ((String)localObject1);
        ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i4);
        paramList.add(localObject2);
      }
    }
    for (int i = k + 1;; i = k + 1)
    {
      k = i;
      if (paramInt2 <= 0) {
        break;
      }
      k = i;
      if (i < paramInt2) {
        break;
      }
      return;
      if (str.indexOf(".gif") != -1)
      {
        localObject1 = "image/gif";
        break label191;
      }
      if (str.indexOf(".bmp") != -1)
      {
        localObject1 = "image/bmp";
        break label191;
      }
      if (str.indexOf(".png") == -1) {
        break;
      }
      localObject1 = "image/png";
      break label191;
      label447:
      break label101;
      label449:
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).path = str;
      ((LocalMediaInfo)localObject2).modifiedDate = l;
      ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i1);
      ((LocalMediaInfo)localObject2).mMimeType = ((String)localObject1);
      ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i4);
      paramList.add(localObject2);
    }
  }
  
  public QQAlbumInfo getItem(int paramInt)
  {
    return (QQAlbumInfo)this.mDataInfos.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.mDataInfos.get(paramInt)).mCoverInfo);
  }
  
  List<LocalMediaInfo> getVideoList(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label297;
            }
            str1 = paramCursor.getString(i2);
            if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.filter(str1))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AlbumListAdapter", 2, "Filter mime type:" + str1);
            }
          }
          str2 = paramCursor.getString(m);
        } while ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()));
        long l = paramCursor.getLong(n);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo._id = paramCursor.getLong(k);
        localLocalMediaInfo.path = str2;
        localLocalMediaInfo.mMimeType = str1;
        localLocalMediaInfo.modifiedDate = l;
        localLocalMediaInfo.mDuration = paramCursor.getLong(i1);
        localLocalMediaInfo.fileSize = paramCursor.getLong(i3);
        localArrayList.add(localLocalMediaInfo);
        j = i + 1;
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    label297:
    return localArrayList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.mAlbumListCallback.getView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
  
  void getWHByPath(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    HashMap localHashMap = new HashMap();
    Integer localInteger = (Integer)localHashMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        SafeBitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = 0;
        continue;
      }
      try
      {
        m = paramOptions.outHeight;
        i = m;
        j = k;
        if (k <= 65535)
        {
          i = m;
          j = k;
          if (m > 65535) {}
        }
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = k;
        continue;
      }
      try
      {
        localHashMap.put(paramString, Integer.valueOf(paramOptions.outWidth << 16 & 0xFFFF0000 | paramOptions.outHeight & 0xFFFF));
        j = k;
        i = m;
      }
      catch (OutOfMemoryError paramString)
      {
        i = m;
        j = k;
        continue;
      }
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  public void postData()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setData();
      return;
    }
    this.mUiHandler.post(new AlbumListAdapter.1(this));
  }
  
  /* Error */
  QQAlbumInfo queryAllVideoBucket(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 455	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 553	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 555
    //   16: putfield 557	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   19: aload 4
    //   21: getstatic 562	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:VIDEO_ALBUM_NAME	Ljava/lang/String;
    //   24: putfield 565	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   27: aload 4
    //   29: iconst_0
    //   30: putfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   33: getstatic 571	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 303	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_2
    //   42: getstatic 183	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:VIDEO_COLUMNS	[Ljava/lang/String;
    //   45: ldc_w 573
    //   48: aconst_null
    //   49: ldc 29
    //   51: invokevirtual 309	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: iconst_2
    //   58: invokestatic 577	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   61: astore 5
    //   63: aload 5
    //   65: ifnull +14 -> 79
    //   68: aload_2
    //   69: astore_1
    //   70: aload_0
    //   71: aload_2
    //   72: iconst_m1
    //   73: aload 5
    //   75: invokevirtual 579	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:getVideoList	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   78: astore_3
    //   79: aload_2
    //   80: astore_1
    //   81: invokestatic 585	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   84: invokestatic 591	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   87: iconst_0
    //   88: iconst_m1
    //   89: invokevirtual 595	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   92: astore 5
    //   94: aload_3
    //   95: ifnull +50 -> 145
    //   98: aload_2
    //   99: astore_1
    //   100: aload_3
    //   101: invokeinterface 597 1 0
    //   106: ifne +39 -> 145
    //   109: aload_2
    //   110: astore_1
    //   111: aload 4
    //   113: aload 4
    //   115: getfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   118: aload_3
    //   119: invokeinterface 316 1 0
    //   124: iadd
    //   125: putfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   128: aload_2
    //   129: astore_1
    //   130: aload 4
    //   132: aload_3
    //   133: iconst_0
    //   134: invokeinterface 453 2 0
    //   139: checkcast 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   142: putfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   145: aload 5
    //   147: ifnull +181 -> 328
    //   150: aload_2
    //   151: astore_1
    //   152: aload 5
    //   154: invokevirtual 598	java/util/ArrayList:isEmpty	()Z
    //   157: ifne +171 -> 328
    //   160: aload_2
    //   161: astore_1
    //   162: aload 4
    //   164: aload 4
    //   166: getfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   169: aload 5
    //   171: invokevirtual 599	java/util/ArrayList:size	()I
    //   174: iadd
    //   175: putfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   178: aload_2
    //   179: astore_1
    //   180: aload 5
    //   182: iconst_0
    //   183: invokevirtual 600	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   186: checkcast 602	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   189: astore_3
    //   190: aload_2
    //   191: astore_1
    //   192: aload 4
    //   194: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   197: ifnull +21 -> 218
    //   200: aload_2
    //   201: astore_1
    //   202: aload 4
    //   204: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   207: getfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   210: aload_3
    //   211: getfield 603	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   214: lcmp
    //   215: ifge +113 -> 328
    //   218: aload_2
    //   219: astore_1
    //   220: aload 4
    //   222: new 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   225: dup
    //   226: invokespecial 340	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   229: putfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   232: aload_2
    //   233: astore_1
    //   234: aload 4
    //   236: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   239: aload_3
    //   240: getfield 606	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   243: i2l
    //   244: putfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   247: aload_2
    //   248: astore_1
    //   249: aload 4
    //   251: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   254: aload_3
    //   255: getfield 608	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   258: putfield 477	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   261: aload_2
    //   262: astore_1
    //   263: aload 4
    //   265: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   268: aload_3
    //   269: getfield 609	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   272: putfield 436	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   275: aload_2
    //   276: astore_1
    //   277: aload 4
    //   279: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   282: aload_3
    //   283: getfield 610	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   286: putfield 383	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   289: aload_2
    //   290: astore_1
    //   291: aload 4
    //   293: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   296: aload_3
    //   297: getfield 603	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   300: putfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   303: aload_2
    //   304: astore_1
    //   305: aload 4
    //   307: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   310: aload_3
    //   311: getfield 613	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   314: putfield 433	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   317: aload_2
    //   318: astore_1
    //   319: aload 4
    //   321: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   324: iconst_0
    //   325: putfield 616	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   328: aload_2
    //   329: ifnull +9 -> 338
    //   332: aload_2
    //   333: invokeinterface 619 1 0
    //   338: aload 4
    //   340: areturn
    //   341: astore_3
    //   342: aconst_null
    //   343: astore_2
    //   344: aload_2
    //   345: astore_1
    //   346: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +16 -> 365
    //   352: aload_2
    //   353: astore_1
    //   354: ldc 34
    //   356: iconst_2
    //   357: aload_3
    //   358: invokevirtual 622	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   361: aload_3
    //   362: invokestatic 626	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: aload_2
    //   366: ifnull -28 -> 338
    //   369: aload_2
    //   370: invokeinterface 619 1 0
    //   375: aload 4
    //   377: areturn
    //   378: astore_2
    //   379: aconst_null
    //   380: astore_1
    //   381: aload_1
    //   382: ifnull +9 -> 391
    //   385: aload_1
    //   386: invokeinterface 619 1 0
    //   391: aload_2
    //   392: athrow
    //   393: astore_2
    //   394: goto -13 -> 381
    //   397: astore_3
    //   398: goto -54 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	AlbumListAdapter
    //   0	401	1	paramContext	Context
    //   36	334	2	localObject1	Object
    //   378	14	2	localObject2	Object
    //   393	1	2	localObject3	Object
    //   1	310	3	localObject4	Object
    //   341	21	3	localException1	java.lang.Exception
    //   397	1	3	localException2	java.lang.Exception
    //   9	367	4	localQQAlbumInfo	QQAlbumInfo
    //   61	120	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	55	341	java/lang/Exception
    //   33	55	378	finally
    //   57	63	393	finally
    //   70	79	393	finally
    //   81	94	393	finally
    //   100	109	393	finally
    //   111	128	393	finally
    //   130	145	393	finally
    //   152	160	393	finally
    //   162	178	393	finally
    //   180	190	393	finally
    //   192	200	393	finally
    //   202	218	393	finally
    //   220	232	393	finally
    //   234	247	393	finally
    //   249	261	393	finally
    //   263	275	393	finally
    //   277	289	393	finally
    //   291	303	393	finally
    //   305	317	393	finally
    //   319	328	393	finally
    //   346	352	393	finally
    //   354	365	393	finally
    //   57	63	397	java/lang/Exception
    //   70	79	397	java/lang/Exception
    //   81	94	397	java/lang/Exception
    //   100	109	397	java/lang/Exception
    //   111	128	397	java/lang/Exception
    //   130	145	397	java/lang/Exception
    //   152	160	397	java/lang/Exception
    //   162	178	397	java/lang/Exception
    //   180	190	397	java/lang/Exception
    //   192	200	397	java/lang/Exception
    //   202	218	397	java/lang/Exception
    //   220	232	397	java/lang/Exception
    //   234	247	397	java/lang/Exception
    //   249	261	397	java/lang/Exception
    //   263	275	397	java/lang/Exception
    //   277	289	397	java/lang/Exception
    //   291	303	397	java/lang/Exception
    //   305	317	397	java/lang/Exception
    //   319	328	397	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> queryImageBuckets(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +62 -> 63
    //   4: getstatic 275	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 12
    //   9: aload_1
    //   10: invokevirtual 303	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 12
    //   15: getstatic 94	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:PROJECTION_BUCKET	[Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 213	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:mAlbumListCallback	Lcom/tencent/mobileqq/activity/photo/album/AlbumListLogic$IalbumListAdapterCallBack;
    //   22: invokeinterface 631 1 0
    //   27: aconst_null
    //   28: ldc 8
    //   30: invokevirtual 309	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 12
    //   35: aload 12
    //   37: ifnonnull +57 -> 94
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_1
    //   43: astore 13
    //   45: aload 12
    //   47: ifnull +13 -> 60
    //   50: aload 12
    //   52: invokeinterface 619 1 0
    //   57: aload_1
    //   58: astore 13
    //   60: aload 13
    //   62: areturn
    //   63: getstatic 275	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   66: invokevirtual 281	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   69: astore 12
    //   71: aload 12
    //   73: ldc_w 283
    //   76: iload_2
    //   77: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   80: invokevirtual 293	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   83: pop
    //   84: aload 12
    //   86: invokevirtual 297	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   89: astore 12
    //   91: goto -82 -> 9
    //   94: aload 12
    //   96: astore 13
    //   98: new 633	java/util/LinkedList
    //   101: dup
    //   102: invokespecial 634	java/util/LinkedList:<init>	()V
    //   105: astore_1
    //   106: aload 12
    //   108: astore 13
    //   110: aload 12
    //   112: ldc 78
    //   114: invokeinterface 637 2 0
    //   119: istore_2
    //   120: aload 12
    //   122: astore 13
    //   124: aload 12
    //   126: ldc 80
    //   128: invokeinterface 637 2 0
    //   133: istore_3
    //   134: aload 12
    //   136: astore 13
    //   138: aload 12
    //   140: ldc 86
    //   142: invokeinterface 637 2 0
    //   147: istore 4
    //   149: aload 12
    //   151: astore 13
    //   153: aload 12
    //   155: ldc 84
    //   157: invokeinterface 637 2 0
    //   162: istore 5
    //   164: aload 12
    //   166: astore 13
    //   168: aload 12
    //   170: ldc 175
    //   172: invokeinterface 637 2 0
    //   177: istore 6
    //   179: aload 12
    //   181: astore 13
    //   183: aload 12
    //   185: ldc 88
    //   187: invokeinterface 637 2 0
    //   192: istore 7
    //   194: aload 12
    //   196: astore 13
    //   198: aload 12
    //   200: ldc 90
    //   202: invokeinterface 637 2 0
    //   207: istore 8
    //   209: aload 12
    //   211: astore 13
    //   213: aload 12
    //   215: ldc_w 639
    //   218: invokeinterface 637 2 0
    //   223: istore 9
    //   225: aload 12
    //   227: astore 13
    //   229: aload 12
    //   231: invokeinterface 352 1 0
    //   236: ifeq +326 -> 562
    //   239: aload 12
    //   241: astore 13
    //   243: aload 12
    //   245: iload_2
    //   246: invokeinterface 355 2 0
    //   251: astore 16
    //   253: aload 12
    //   255: astore 13
    //   257: aload 12
    //   259: iload_3
    //   260: invokeinterface 355 2 0
    //   265: astore 17
    //   267: aload 12
    //   269: astore 13
    //   271: aload 16
    //   273: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   276: ifne -51 -> 225
    //   279: aload 12
    //   281: astore 13
    //   283: aload 17
    //   285: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne -63 -> 225
    //   291: aload 12
    //   293: astore 13
    //   295: aload 12
    //   297: iload 4
    //   299: invokeinterface 355 2 0
    //   304: astore 14
    //   306: aload 12
    //   308: astore 13
    //   310: aload 12
    //   312: iload 5
    //   314: invokeinterface 359 2 0
    //   319: lstore 10
    //   321: aload 12
    //   323: astore 13
    //   325: new 455	com/tencent/mobileqq/data/QQAlbumInfo
    //   328: dup
    //   329: invokespecial 553	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   332: astore 15
    //   334: aload 12
    //   336: astore 13
    //   338: aload 15
    //   340: aload 17
    //   342: putfield 565	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   345: aload 12
    //   347: astore 13
    //   349: aload 15
    //   351: aload 16
    //   353: putfield 557	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   356: aload 12
    //   358: astore 13
    //   360: aload 15
    //   362: lload 10
    //   364: putfield 642	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   367: aload 12
    //   369: astore 13
    //   371: aload 15
    //   373: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   376: astore 16
    //   378: aload 12
    //   380: astore 13
    //   382: aload 16
    //   384: aload 14
    //   386: putfield 383	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   389: aload 12
    //   391: astore 13
    //   393: aload 16
    //   395: aload 12
    //   397: iload 6
    //   399: invokeinterface 359 2 0
    //   404: putfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   407: aload 12
    //   409: astore 13
    //   411: aload 16
    //   413: lload 10
    //   415: putfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   418: aload 12
    //   420: astore 13
    //   422: aload 16
    //   424: aload 12
    //   426: iload 7
    //   428: invokeinterface 428 2 0
    //   433: putfield 430	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   436: aload 12
    //   438: astore 13
    //   440: aload 16
    //   442: aload 12
    //   444: iload 8
    //   446: invokeinterface 355 2 0
    //   451: putfield 433	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   454: aload 12
    //   456: astore 13
    //   458: ldc 138
    //   460: aload 16
    //   462: getfield 433	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   465: invokevirtual 412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +15 -> 483
    //   471: aload 12
    //   473: astore 13
    //   475: aload 16
    //   477: ldc_w 644
    //   480: putfield 433	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   483: aload 12
    //   485: astore 13
    //   487: aload 15
    //   489: aload 12
    //   491: iload 9
    //   493: invokeinterface 428 2 0
    //   498: putfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   501: aload 12
    //   503: astore 13
    //   505: aload_1
    //   506: aload 15
    //   508: invokeinterface 327 2 0
    //   513: pop
    //   514: goto -289 -> 225
    //   517: astore 14
    //   519: aload 12
    //   521: astore 13
    //   523: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +19 -> 545
    //   529: aload 12
    //   531: astore 13
    //   533: ldc_w 646
    //   536: iconst_2
    //   537: ldc_w 648
    //   540: aload 14
    //   542: invokestatic 650	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: aload_1
    //   546: astore 13
    //   548: aload 12
    //   550: ifnull -490 -> 60
    //   553: aload 12
    //   555: invokeinterface 619 1 0
    //   560: aload_1
    //   561: areturn
    //   562: aload_1
    //   563: astore 13
    //   565: aload 12
    //   567: ifnull -507 -> 60
    //   570: aload 12
    //   572: invokeinterface 619 1 0
    //   577: aload_1
    //   578: areturn
    //   579: astore_1
    //   580: aconst_null
    //   581: astore 13
    //   583: aload 13
    //   585: ifnull +10 -> 595
    //   588: aload 13
    //   590: invokeinterface 619 1 0
    //   595: aload_1
    //   596: athrow
    //   597: astore_1
    //   598: goto -15 -> 583
    //   601: astore 14
    //   603: aconst_null
    //   604: astore 12
    //   606: aconst_null
    //   607: astore_1
    //   608: goto -89 -> 519
    //   611: astore 14
    //   613: aconst_null
    //   614: astore_1
    //   615: goto -96 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	AlbumListAdapter
    //   0	618	1	paramContext	Context
    //   0	618	2	paramInt	int
    //   133	127	3	i	int
    //   147	151	4	j	int
    //   162	151	5	k	int
    //   177	221	6	m	int
    //   192	235	7	n	int
    //   207	238	8	i1	int
    //   223	269	9	i2	int
    //   319	95	10	l	long
    //   7	598	12	localObject1	Object
    //   43	546	13	localObject2	Object
    //   304	81	14	str1	String
    //   517	24	14	localException1	java.lang.Exception
    //   601	1	14	localException2	java.lang.Exception
    //   611	1	14	localException3	java.lang.Exception
    //   332	175	15	localQQAlbumInfo	QQAlbumInfo
    //   251	225	16	localObject3	Object
    //   265	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   110	120	517	java/lang/Exception
    //   124	134	517	java/lang/Exception
    //   138	149	517	java/lang/Exception
    //   153	164	517	java/lang/Exception
    //   168	179	517	java/lang/Exception
    //   183	194	517	java/lang/Exception
    //   198	209	517	java/lang/Exception
    //   213	225	517	java/lang/Exception
    //   229	239	517	java/lang/Exception
    //   243	253	517	java/lang/Exception
    //   257	267	517	java/lang/Exception
    //   271	279	517	java/lang/Exception
    //   283	291	517	java/lang/Exception
    //   295	306	517	java/lang/Exception
    //   310	321	517	java/lang/Exception
    //   325	334	517	java/lang/Exception
    //   338	345	517	java/lang/Exception
    //   349	356	517	java/lang/Exception
    //   360	367	517	java/lang/Exception
    //   371	378	517	java/lang/Exception
    //   382	389	517	java/lang/Exception
    //   393	407	517	java/lang/Exception
    //   411	418	517	java/lang/Exception
    //   422	436	517	java/lang/Exception
    //   440	454	517	java/lang/Exception
    //   458	471	517	java/lang/Exception
    //   475	483	517	java/lang/Exception
    //   487	501	517	java/lang/Exception
    //   505	514	517	java/lang/Exception
    //   4	9	579	finally
    //   9	35	579	finally
    //   63	91	579	finally
    //   98	106	597	finally
    //   110	120	597	finally
    //   124	134	597	finally
    //   138	149	597	finally
    //   153	164	597	finally
    //   168	179	597	finally
    //   183	194	597	finally
    //   198	209	597	finally
    //   213	225	597	finally
    //   229	239	597	finally
    //   243	253	597	finally
    //   257	267	597	finally
    //   271	279	597	finally
    //   283	291	597	finally
    //   295	306	597	finally
    //   310	321	597	finally
    //   325	334	597	finally
    //   338	345	597	finally
    //   349	356	597	finally
    //   360	367	597	finally
    //   371	378	597	finally
    //   382	389	597	finally
    //   393	407	597	finally
    //   411	418	597	finally
    //   422	436	597	finally
    //   440	454	597	finally
    //   458	471	597	finally
    //   475	483	597	finally
    //   487	501	597	finally
    //   505	514	597	finally
    //   523	529	597	finally
    //   533	545	597	finally
    //   4	9	601	java/lang/Exception
    //   9	35	601	java/lang/Exception
    //   63	91	601	java/lang/Exception
    //   98	106	611	java/lang/Exception
  }
  
  QQAlbumInfo queryRecentImageBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    paramArrayList = this.mAlbumListCallback.queryRecentImageList(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = QAlbumUtil.queryRecentVideos(paramContext, 0, paramInt2, paramMediaFileFilter, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) {}
    for (localQQAlbumInfo.mMediaFileCount += paramContext.size();; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  QQAlbumInfo queryRecentMediaBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (paramMediaFileFilter == null) {
      return null;
    }
    if (paramMediaFileFilter.showImage()) {
      return queryRecentImageBucket(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    }
    return queryRecentVideoBucket(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
  }
  
  /* Error */
  QQAlbumInfo queryRecentVideoBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 681	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 683
    //   17: invokespecial 684	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 455	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 553	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 655
    //   35: putfield 557	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   38: aload 8
    //   40: getstatic 658	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:RECENT_ALBUM_NAME	Ljava/lang/String;
    //   43: putfield 565	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   46: iload_3
    //   47: ifle +142 -> 189
    //   50: getstatic 571	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 281	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 283
    //   63: iload_3
    //   64: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 293	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 297	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   76: astore 5
    //   78: aload_1
    //   79: invokevirtual 303	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: aload 5
    //   84: getstatic 183	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:VIDEO_COLUMNS	[Ljava/lang/String;
    //   87: ldc_w 573
    //   90: aconst_null
    //   91: ldc 29
    //   93: invokevirtual 309	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore_1
    //   97: aload 4
    //   99: ifnull +16 -> 115
    //   102: aload_1
    //   103: astore 5
    //   105: aload_0
    //   106: aload_1
    //   107: iload_3
    //   108: aload 4
    //   110: invokevirtual 579	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:getVideoList	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   113: astore 6
    //   115: aload 6
    //   117: ifnull +59 -> 176
    //   120: aload_1
    //   121: astore 5
    //   123: aload 6
    //   125: invokeinterface 597 1 0
    //   130: ifne +46 -> 176
    //   133: aload_1
    //   134: astore 5
    //   136: aload 6
    //   138: invokeinterface 316 1 0
    //   143: istore_2
    //   144: aload_1
    //   145: astore 5
    //   147: aload 8
    //   149: iload_2
    //   150: putfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   153: iload_2
    //   154: ifle +22 -> 176
    //   157: aload_1
    //   158: astore 5
    //   160: aload 8
    //   162: aload 6
    //   164: iconst_0
    //   165: invokeinterface 453 2 0
    //   170: checkcast 339	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   173: putfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   176: aload_1
    //   177: ifnull +9 -> 186
    //   180: aload_1
    //   181: invokeinterface 619 1 0
    //   186: aload 8
    //   188: areturn
    //   189: getstatic 571	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   192: astore 5
    //   194: goto -116 -> 78
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: astore 5
    //   204: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +19 -> 226
    //   210: aload_1
    //   211: astore 5
    //   213: ldc 34
    //   215: iconst_2
    //   216: aload 4
    //   218: invokevirtual 622	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aload 4
    //   223: invokestatic 626	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: ifnull -41 -> 186
    //   230: aload_1
    //   231: invokeinterface 619 1 0
    //   236: aload 8
    //   238: areturn
    //   239: astore_1
    //   240: aload 7
    //   242: astore 4
    //   244: aload 4
    //   246: ifnull +10 -> 256
    //   249: aload 4
    //   251: invokeinterface 619 1 0
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload 5
    //   261: astore 4
    //   263: goto -19 -> 244
    //   266: astore 4
    //   268: goto -67 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	AlbumListAdapter
    //   0	271	1	paramContext	Context
    //   0	271	2	paramInt1	int
    //   0	271	3	paramInt2	int
    //   0	271	4	paramMediaFileFilter	MediaFileFilter
    //   56	204	5	localObject1	Object
    //   4	159	6	localList	List
    //   1	240	7	localObject2	Object
    //   28	209	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   50	78	197	java/lang/Exception
    //   78	97	197	java/lang/Exception
    //   189	194	197	java/lang/Exception
    //   50	78	239	finally
    //   78	97	239	finally
    //   189	194	239	finally
    //   105	115	258	finally
    //   123	133	258	finally
    //   136	144	258	finally
    //   147	153	258	finally
    //   160	176	258	finally
    //   204	210	258	finally
    //   213	226	258	finally
    //   105	115	266	java/lang/Exception
    //   123	133	266	java/lang/Exception
    //   136	144	266	java/lang/Exception
    //   147	153	266	java/lang/Exception
    //   160	176	266	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> queryVideoBuckets(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +49 -> 50
    //   4: getstatic 571	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 303	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 185	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:VIDEO_PROJECTION_BUCKET	[Ljava/lang/String;
    //   16: ldc 38
    //   18: aconst_null
    //   19: ldc 8
    //   21: invokevirtual 309	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +51 -> 77
    //   29: aconst_null
    //   30: astore_1
    //   31: aload_1
    //   32: astore 12
    //   34: aload_3
    //   35: ifnull +12 -> 47
    //   38: aload_3
    //   39: invokeinterface 619 1 0
    //   44: aload_1
    //   45: astore 12
    //   47: aload 12
    //   49: areturn
    //   50: getstatic 571	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 281	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore_3
    //   57: aload_3
    //   58: ldc_w 283
    //   61: iload_2
    //   62: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   65: invokevirtual 293	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   68: pop
    //   69: aload_3
    //   70: invokevirtual 297	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   73: astore_3
    //   74: goto -66 -> 8
    //   77: aload_3
    //   78: astore 12
    //   80: new 633	java/util/LinkedList
    //   83: dup
    //   84: invokespecial 634	java/util/LinkedList:<init>	()V
    //   87: astore_1
    //   88: aload_3
    //   89: astore 12
    //   91: aload_3
    //   92: ldc 78
    //   94: invokeinterface 637 2 0
    //   99: istore_2
    //   100: aload_3
    //   101: astore 12
    //   103: aload_3
    //   104: ldc 175
    //   106: invokeinterface 637 2 0
    //   111: istore 4
    //   113: aload_3
    //   114: astore 12
    //   116: aload_3
    //   117: ldc 80
    //   119: invokeinterface 637 2 0
    //   124: istore 5
    //   126: aload_3
    //   127: astore 12
    //   129: aload_3
    //   130: ldc 86
    //   132: invokeinterface 637 2 0
    //   137: istore 6
    //   139: aload_3
    //   140: astore 12
    //   142: aload_3
    //   143: ldc 84
    //   145: invokeinterface 637 2 0
    //   150: istore 7
    //   152: aload_3
    //   153: astore 12
    //   155: aload_3
    //   156: ldc 90
    //   158: invokeinterface 637 2 0
    //   163: istore 8
    //   165: aload_3
    //   166: astore 12
    //   168: aload_3
    //   169: ldc_w 639
    //   172: invokeinterface 637 2 0
    //   177: istore 9
    //   179: aload_3
    //   180: astore 12
    //   182: aload_3
    //   183: invokeinterface 352 1 0
    //   188: ifeq +245 -> 433
    //   191: aload_3
    //   192: astore 12
    //   194: aload_3
    //   195: iload_2
    //   196: invokeinterface 355 2 0
    //   201: astore 14
    //   203: aload_3
    //   204: astore 12
    //   206: aload_3
    //   207: iload 5
    //   209: invokeinterface 355 2 0
    //   214: astore 15
    //   216: aload_3
    //   217: astore 12
    //   219: aload 14
    //   221: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne -45 -> 179
    //   227: aload_3
    //   228: astore 12
    //   230: aload 15
    //   232: invokestatic 425	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne -56 -> 179
    //   238: aload_3
    //   239: astore 12
    //   241: aload_3
    //   242: iload 7
    //   244: invokeinterface 359 2 0
    //   249: lstore 10
    //   251: aload_3
    //   252: astore 12
    //   254: new 455	com/tencent/mobileqq/data/QQAlbumInfo
    //   257: dup
    //   258: invokespecial 553	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   261: astore 13
    //   263: aload_3
    //   264: astore 12
    //   266: aload 13
    //   268: aload 15
    //   270: putfield 565	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   273: aload_3
    //   274: astore 12
    //   276: aload 13
    //   278: aload 14
    //   280: putfield 557	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   283: aload_3
    //   284: astore 12
    //   286: aload 13
    //   288: lload 10
    //   290: putfield 642	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   293: aload_3
    //   294: astore 12
    //   296: aload 13
    //   298: getfield 463	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   301: astore 14
    //   303: aload_3
    //   304: astore 12
    //   306: aload 14
    //   308: aload_3
    //   309: iload 6
    //   311: invokeinterface 355 2 0
    //   316: putfield 383	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: aload_3
    //   320: astore 12
    //   322: aload 14
    //   324: aload_3
    //   325: iload 4
    //   327: invokeinterface 359 2 0
    //   332: putfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   335: aload_3
    //   336: astore 12
    //   338: aload 14
    //   340: lload 10
    //   342: putfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   345: aload_3
    //   346: astore 12
    //   348: aload 14
    //   350: aload_3
    //   351: iload 8
    //   353: invokeinterface 355 2 0
    //   358: putfield 433	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   361: aload_3
    //   362: astore 12
    //   364: aload 13
    //   366: aload_3
    //   367: iload 9
    //   369: invokeinterface 428 2 0
    //   374: putfield 568	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   377: aload_3
    //   378: astore 12
    //   380: aload_1
    //   381: aload 13
    //   383: invokeinterface 327 2 0
    //   388: pop
    //   389: goto -210 -> 179
    //   392: astore 13
    //   394: aload_3
    //   395: astore 12
    //   397: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +18 -> 418
    //   403: aload_3
    //   404: astore 12
    //   406: ldc_w 646
    //   409: iconst_2
    //   410: ldc_w 688
    //   413: aload 13
    //   415: invokestatic 650	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: astore 12
    //   421: aload_3
    //   422: ifnull -375 -> 47
    //   425: aload_3
    //   426: invokeinterface 619 1 0
    //   431: aload_1
    //   432: areturn
    //   433: aload_1
    //   434: astore 12
    //   436: aload_3
    //   437: ifnull -390 -> 47
    //   440: aload_3
    //   441: invokeinterface 619 1 0
    //   446: aload_1
    //   447: areturn
    //   448: astore_1
    //   449: aconst_null
    //   450: astore 12
    //   452: aload 12
    //   454: ifnull +10 -> 464
    //   457: aload 12
    //   459: invokeinterface 619 1 0
    //   464: aload_1
    //   465: athrow
    //   466: astore_1
    //   467: goto -15 -> 452
    //   470: astore 13
    //   472: aconst_null
    //   473: astore_3
    //   474: aconst_null
    //   475: astore_1
    //   476: goto -82 -> 394
    //   479: astore 13
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -89 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	AlbumListAdapter
    //   0	486	1	paramContext	Context
    //   0	486	2	paramInt	int
    //   0	486	3	paramMediaFileFilter	MediaFileFilter
    //   111	215	4	i	int
    //   124	84	5	j	int
    //   137	173	6	k	int
    //   150	93	7	m	int
    //   163	189	8	n	int
    //   177	191	9	i1	int
    //   249	92	10	l	long
    //   32	426	12	localObject1	Object
    //   261	121	13	localQQAlbumInfo	QQAlbumInfo
    //   392	22	13	localException1	java.lang.Exception
    //   470	1	13	localException2	java.lang.Exception
    //   479	1	13	localException3	java.lang.Exception
    //   201	148	14	localObject2	Object
    //   214	55	15	str	String
    // Exception table:
    //   from	to	target	type
    //   91	100	392	java/lang/Exception
    //   103	113	392	java/lang/Exception
    //   116	126	392	java/lang/Exception
    //   129	139	392	java/lang/Exception
    //   142	152	392	java/lang/Exception
    //   155	165	392	java/lang/Exception
    //   168	179	392	java/lang/Exception
    //   182	191	392	java/lang/Exception
    //   194	203	392	java/lang/Exception
    //   206	216	392	java/lang/Exception
    //   219	227	392	java/lang/Exception
    //   230	238	392	java/lang/Exception
    //   241	251	392	java/lang/Exception
    //   254	263	392	java/lang/Exception
    //   266	273	392	java/lang/Exception
    //   276	283	392	java/lang/Exception
    //   286	293	392	java/lang/Exception
    //   296	303	392	java/lang/Exception
    //   306	319	392	java/lang/Exception
    //   322	335	392	java/lang/Exception
    //   338	345	392	java/lang/Exception
    //   348	361	392	java/lang/Exception
    //   364	377	392	java/lang/Exception
    //   380	389	392	java/lang/Exception
    //   4	8	448	finally
    //   8	25	448	finally
    //   50	74	448	finally
    //   80	88	466	finally
    //   91	100	466	finally
    //   103	113	466	finally
    //   116	126	466	finally
    //   129	139	466	finally
    //   142	152	466	finally
    //   155	165	466	finally
    //   168	179	466	finally
    //   182	191	466	finally
    //   194	203	466	finally
    //   206	216	466	finally
    //   219	227	466	finally
    //   230	238	466	finally
    //   241	251	466	finally
    //   254	263	466	finally
    //   266	273	466	finally
    //   276	283	466	finally
    //   286	293	466	finally
    //   296	303	466	finally
    //   306	319	466	finally
    //   322	335	466	finally
    //   338	345	466	finally
    //   348	361	466	finally
    //   364	377	466	finally
    //   380	389	466	finally
    //   397	403	466	finally
    //   406	418	466	finally
    //   4	8	470	java/lang/Exception
    //   8	25	470	java/lang/Exception
    //   50	74	470	java/lang/Exception
    //   80	88	479	java/lang/Exception
  }
  
  protected void setData()
  {
    this.mDataInfos.clear();
    this.mDataInfos.addAll(getDefaultAlbums());
    notifyDataSetChanged();
  }
  
  void updateCommonAlbums(List<QQAlbumInfo> paramList)
  {
    this.mCommonAlbums = paramList;
  }
  
  public void updateRecentAlbum(QQAlbumInfo paramQQAlbumInfo)
  {
    this.mRecentAlbum = paramQQAlbumInfo;
  }
  
  void updateVideoAlbum(QQAlbumInfo paramQQAlbumInfo)
  {
    this.mLocalVideoAlbum = paramQQAlbumInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */