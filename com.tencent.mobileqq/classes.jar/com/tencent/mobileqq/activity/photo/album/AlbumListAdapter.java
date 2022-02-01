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
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.Builder;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumListAdapter
  extends BaseAdapter
{
  public static final String BUCKET_ORDER_BY = "date_modified DESC";
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
  static String[] columns = { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" };
  private boolean hasAddQzoneAlbum = false;
  AlbumListLogic.IalbumListAdapterCallBack mAlbumListCallback;
  private List<QQAlbumInfo> mCommonAlbums;
  int mCoverHeight;
  int mCoverWidth;
  private List<QQAlbumInfo> mDataInfos = new ArrayList();
  boolean mIsShowVideoAlbum;
  private QQAlbumInfo mLocalVideoAlbum;
  private QQAlbumInfo mRecentAlbum;
  Resources mResources;
  Drawable.ConstantState mRightArrow;
  Handler mUiHandler = new Handler();
  
  static
  {
    BUCKET_SELECTION_FOR_SLIDESHOW = "_size>0 and ( _size < " + QAlbumUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (" + "width" + ">= 240 or " + "width" + " IS NULL) and (" + "height" + ">= 240 or " + "height" + " IS NULL )  and " + "height" + "  * 1.0 / " + "width" + ">= 0.45 and " + "height" + "  * 1.0 / " + "width" + "<= 2.2 and (" + "mime_type" + "='" + "image/jpeg" + "' or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpeg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.bmp%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.png%' )  or " + "mime_type" + " LIKE'%" + "bmp" + "%' or " + "mime_type" + " LIKE'%" + "bitmap" + "%' or " + "mime_type" + "='" + "image/png" + "'";
    VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
    VIDEO_PROJECTION_BUCKET = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
    if (Build.VERSION.SDK_INT >= 16)
    {
      columns = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };
      return;
    }
  }
  
  public AlbumListAdapter(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    this.mAlbumListCallback = paramAbstractAlbumListFragment.mAlbumListLogic.mAlbumListAdapterCallBack;
    this.mResources = paramAbstractAlbumListFragment.getResources();
    this.mRightArrow = this.mResources.getDrawable(2130839419).getConstantState();
    this.mCoverWidth = this.mResources.getDimensionPixelSize(2131296488);
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
  
  private int getPhotoInfo(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, BitmapFactory.Options paramOptions, int[] paramArrayOfInt, int paramInt4, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    if ((paramInt1 > 0) && ((!paramBoolean1) || (paramBoolean2)))
    {
      getWHByPath(paramString2, paramOptions, paramArrayOfInt);
      int i;
      if (paramArrayOfInt[0] < paramInt1)
      {
        i = paramInt4;
        if (paramArrayOfInt[1] < paramInt1) {}
      }
      else
      {
        paramOptions = new LocalMediaInfo();
        paramOptions.path = paramString2;
        paramOptions.modifiedDate = paramLong;
        paramOptions.orientation = paramCursor.getInt(paramInt2);
        paramOptions.mMimeType = paramString1;
        paramOptions.fileSize = paramCursor.getLong(paramInt3);
        paramList.add(paramOptions);
        i = paramInt4 + 1;
      }
      return i;
    }
    paramOptions = new LocalMediaInfo();
    paramOptions.path = paramString2;
    paramOptions.modifiedDate = paramLong;
    paramOptions.orientation = paramCursor.getInt(paramInt2);
    paramOptions.mMimeType = paramString1;
    paramOptions.fileSize = paramCursor.getLong(paramInt3);
    paramList.add(paramOptions);
    return paramInt4 + 1;
  }
  
  /* Error */
  private void getSystemVideoInfo(Context paramContext, QQAlbumInfo paramQQAlbumInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 306	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   6: astore_3
    //   7: aload_1
    //   8: invokevirtual 312	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   11: aload_3
    //   12: getstatic 176	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:VIDEO_COLUMNS	[Ljava/lang/String;
    //   15: ldc_w 314
    //   18: aconst_null
    //   19: ldc 29
    //   21: invokevirtual 320	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: iconst_2
    //   28: invokestatic 326	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +15 -> 50
    //   38: aload_3
    //   39: astore_1
    //   40: aload_0
    //   41: aload_3
    //   42: iconst_m1
    //   43: aload 5
    //   45: invokevirtual 330	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:getVideoList	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +50 -> 102
    //   55: aload_3
    //   56: astore_1
    //   57: aload 4
    //   59: invokeinterface 334 1 0
    //   64: ifne +38 -> 102
    //   67: aload_3
    //   68: astore_1
    //   69: aload_2
    //   70: aload_2
    //   71: getfield 339	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   74: aload 4
    //   76: invokeinterface 343 1 0
    //   81: iadd
    //   82: putfield 339	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   85: aload_3
    //   86: astore_1
    //   87: aload_2
    //   88: aload 4
    //   90: iconst_0
    //   91: invokeinterface 347 2 0
    //   96: checkcast 263	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   99: putfield 351	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   102: aload_3
    //   103: ifnull +9 -> 112
    //   106: aload_3
    //   107: invokeinterface 354 1 0
    //   112: return
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_1
    //   118: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +16 -> 137
    //   124: aload_3
    //   125: astore_1
    //   126: ldc 34
    //   128: iconst_2
    //   129: aload_2
    //   130: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   133: aload_2
    //   134: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload_3
    //   138: ifnull -26 -> 112
    //   141: aload_3
    //   142: invokeinterface 354 1 0
    //   147: return
    //   148: astore_2
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +9 -> 161
    //   155: aload_1
    //   156: invokeinterface 354 1 0
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: goto -13 -> 151
    //   167: astore_2
    //   168: goto -52 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	AlbumListAdapter
    //   0	171	1	paramContext	Context
    //   0	171	2	paramQQAlbumInfo	QQAlbumInfo
    //   6	136	3	localObject	Object
    //   1	88	4	localList	List
    //   31	13	5	localMediaFileFilter	MediaFileFilter
    // Exception table:
    //   from	to	target	type
    //   3	25	113	java/lang/Exception
    //   3	25	148	finally
    //   27	33	163	finally
    //   40	50	163	finally
    //   57	67	163	finally
    //   69	85	163	finally
    //   87	102	163	finally
    //   118	124	163	finally
    //   126	137	163	finally
    //   27	33	167	java/lang/Exception
    //   40	50	167	java/lang/Exception
    //   57	67	167	java/lang/Exception
    //   69	85	167	java/lang/Exception
    //   87	102	167	java/lang/Exception
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
  
  private void queryPhotoInfo(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, BitmapFactory.Options paramOptions, int[] paramArrayOfInt, int paramInt9)
  {
    int i;
    do
    {
      do
      {
        String str3;
        String str1;
        do
        {
          do
          {
            String str2;
            do
            {
              if (!paramCursor.moveToNext()) {
                return;
              }
              str2 = paramCursor.getString(paramInt6);
              str3 = paramCursor.getString(paramInt3);
              str1 = str2;
              if (paramMediaFileFilter == null) {
                break;
              }
              str1 = str2;
              if (!paramMediaFileFilter.filter(str2)) {
                break;
              }
            } while (!"*/*".equals(str2));
            str1 = QAlbumBaseUtil.fixMimeType(str3, str2);
          } while (str1 == null);
        } while ((TextUtils.isEmpty(str3)) || (!new File(str3).exists()));
        long l = paramCursor.getLong(paramInt5);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramBoolean)
        {
          bool1 = bool2;
          if (paramCursor.getInt(paramInt8) == 0) {
            bool1 = true;
          }
        }
        i = getPhotoInfo(paramCursor, paramList, paramInt1, paramBoolean, paramInt4, paramInt7, paramOptions, paramArrayOfInt, paramInt9, bool1, str1, str3, l);
        paramInt9 = i;
      } while (paramInt2 <= 0);
      paramInt9 = i;
    } while (i < paramInt2);
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
    if (paramCursor.getCount() <= 0) {
      return;
    }
    int j = paramCursor.getColumnIndexOrThrow("_data");
    int k = paramCursor.getColumnIndexOrThrow("orientation");
    int m = paramCursor.getColumnIndexOrThrow("date_modified");
    int n = paramCursor.getColumnIndexOrThrow("mime_type");
    int i1 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    if (paramBoolean) {
      i = paramCursor.getColumnIndexOrThrow("width");
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    queryPhotoInfo(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramMediaFileFilter, j, k, m, n, i1, i, localOptions, new int[2], 0);
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
    View localView = this.mAlbumListCallback.getView(paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
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
        QLog.e("AlbumListAdapter", 1, "getWHByPath error.", paramString);
      }
      catch (OutOfMemoryError paramString)
      {
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
          for (;;)
          {
            i = 0;
            j = k;
          }
        }
        try
        {
          localHashMap.put(paramString, Integer.valueOf(paramOptions.outWidth << 16 & 0xFFFF0000 | paramOptions.outHeight & 0xFFFF));
          j = k;
          i = m;
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
          return;
        }
        catch (OutOfMemoryError paramString)
        {
          i = m;
          j = k;
          break label135;
        }
        paramString = paramString;
        j = 0;
        i = 0;
      }
      label135:
      continue;
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
  
  QQAlbumInfo queryAllVideoBucket(Context paramContext)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$VideoAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
    localQQAlbumInfo.mMediaFileCount = 0;
    getSystemVideoInfo(paramContext, localQQAlbumInfo);
    paramContext = MediaScanner.getInstance(BaseApplication.getContext()).getMediaScannerInfos(false, -1);
    if ((paramContext != null) && (!paramContext.isEmpty()))
    {
      localQQAlbumInfo.mMediaFileCount += paramContext.size();
      paramContext = (MediaScannerInfo)paramContext.get(0);
      if ((localQQAlbumInfo.mCoverInfo == null) || (localQQAlbumInfo.mCoverInfo.modifiedDate < paramContext.modifiedDate))
      {
        localQQAlbumInfo.mCoverInfo = new LocalMediaInfo();
        localQQAlbumInfo.mCoverInfo._id = paramContext.id;
        localQQAlbumInfo.mCoverInfo.mDuration = paramContext.duration;
        localQQAlbumInfo.mCoverInfo.fileSize = paramContext.fileSize;
        localQQAlbumInfo.mCoverInfo.path = paramContext.path;
        localQQAlbumInfo.mCoverInfo.modifiedDate = paramContext.modifiedDate;
        localQQAlbumInfo.mCoverInfo.mMimeType = paramContext.mimeType;
        localQQAlbumInfo.mCoverInfo.isSystemMeidaStore = false;
      }
    }
    return localQQAlbumInfo;
  }
  
  /* Error */
  public List<QQAlbumInfo> queryImageBuckets(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +62 -> 63
    //   4: getstatic 383	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 12
    //   9: aload_1
    //   10: invokevirtual 312	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 12
    //   15: getstatic 94	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:PROJECTION_BUCKET	[Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 213	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:mAlbumListCallback	Lcom/tencent/mobileqq/activity/photo/album/AlbumListLogic$IalbumListAdapterCallBack;
    //   22: invokeinterface 647 1 0
    //   27: aconst_null
    //   28: ldc 8
    //   30: invokevirtual 320	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   52: invokeinterface 354 1 0
    //   57: aload_1
    //   58: astore 13
    //   60: aload 13
    //   62: areturn
    //   63: getstatic 383	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   66: invokevirtual 389	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   69: astore 12
    //   71: aload 12
    //   73: ldc_w 391
    //   76: iload_2
    //   77: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   80: invokevirtual 401	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   83: pop
    //   84: aload 12
    //   86: invokevirtual 405	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   89: astore 12
    //   91: goto -82 -> 9
    //   94: aload 12
    //   96: astore 13
    //   98: new 649	java/util/LinkedList
    //   101: dup
    //   102: invokespecial 650	java/util/LinkedList:<init>	()V
    //   105: astore_1
    //   106: aload 12
    //   108: astore 13
    //   110: aload 12
    //   112: ldc 78
    //   114: invokeinterface 653 2 0
    //   119: istore_2
    //   120: aload 12
    //   122: astore 13
    //   124: aload 12
    //   126: ldc 80
    //   128: invokeinterface 653 2 0
    //   133: istore_3
    //   134: aload 12
    //   136: astore 13
    //   138: aload 12
    //   140: ldc 86
    //   142: invokeinterface 653 2 0
    //   147: istore 4
    //   149: aload 12
    //   151: astore 13
    //   153: aload 12
    //   155: ldc 84
    //   157: invokeinterface 653 2 0
    //   162: istore 5
    //   164: aload 12
    //   166: astore 13
    //   168: aload 12
    //   170: ldc 170
    //   172: invokeinterface 653 2 0
    //   177: istore 6
    //   179: aload 12
    //   181: astore 13
    //   183: aload 12
    //   185: ldc 88
    //   187: invokeinterface 653 2 0
    //   192: istore 7
    //   194: aload 12
    //   196: astore 13
    //   198: aload 12
    //   200: ldc 90
    //   202: invokeinterface 653 2 0
    //   207: istore 8
    //   209: aload 12
    //   211: astore 13
    //   213: aload 12
    //   215: ldc_w 655
    //   218: invokeinterface 653 2 0
    //   223: istore 9
    //   225: aload 12
    //   227: astore 13
    //   229: aload 12
    //   231: invokeinterface 410 1 0
    //   236: ifeq +326 -> 562
    //   239: aload 12
    //   241: astore 13
    //   243: aload 12
    //   245: iload_2
    //   246: invokeinterface 413 2 0
    //   251: astore 16
    //   253: aload 12
    //   255: astore 13
    //   257: aload 12
    //   259: iload_3
    //   260: invokeinterface 413 2 0
    //   265: astore 17
    //   267: aload 12
    //   269: astore 13
    //   271: aload 16
    //   273: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   276: ifne -51 -> 225
    //   279: aload 12
    //   281: astore 13
    //   283: aload 17
    //   285: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne -63 -> 225
    //   291: aload 12
    //   293: astore 13
    //   295: aload 12
    //   297: iload 4
    //   299: invokeinterface 413 2 0
    //   304: astore 14
    //   306: aload 12
    //   308: astore 13
    //   310: aload 12
    //   312: iload 5
    //   314: invokeinterface 285 2 0
    //   319: lstore 10
    //   321: aload 12
    //   323: astore 13
    //   325: new 336	com/tencent/mobileqq/data/QQAlbumInfo
    //   328: dup
    //   329: invokespecial 594	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   332: astore 15
    //   334: aload 12
    //   336: astore 13
    //   338: aload 15
    //   340: aload 17
    //   342: putfield 607	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   345: aload 12
    //   347: astore 13
    //   349: aload 15
    //   351: aload 16
    //   353: putfield 599	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   356: aload 12
    //   358: astore 13
    //   360: aload 15
    //   362: lload 10
    //   364: putfield 658	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   367: aload 12
    //   369: astore 13
    //   371: aload 15
    //   373: getfield 351	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   376: astore 16
    //   378: aload 12
    //   380: astore 13
    //   382: aload 16
    //   384: aload 14
    //   386: putfield 267	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   389: aload 12
    //   391: astore 13
    //   393: aload 16
    //   395: aload 12
    //   397: iload 6
    //   399: invokeinterface 285 2 0
    //   404: putfield 472	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   407: aload 12
    //   409: astore 13
    //   411: aload 16
    //   413: lload 10
    //   415: putfield 271	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   418: aload 12
    //   420: astore 13
    //   422: aload 16
    //   424: aload 12
    //   426: iload 7
    //   428: invokeinterface 276 2 0
    //   433: putfield 278	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   436: aload 12
    //   438: astore 13
    //   440: aload 16
    //   442: aload 12
    //   444: iload 8
    //   446: invokeinterface 413 2 0
    //   451: putfield 281	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   454: aload 12
    //   456: astore 13
    //   458: ldc 138
    //   460: aload 16
    //   462: getfield 281	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   465: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +15 -> 483
    //   471: aload 12
    //   473: astore 13
    //   475: aload 16
    //   477: ldc_w 660
    //   480: putfield 281	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   483: aload 12
    //   485: astore 13
    //   487: aload 15
    //   489: aload 12
    //   491: iload 9
    //   493: invokeinterface 276 2 0
    //   498: putfield 339	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   501: aload 12
    //   503: astore 13
    //   505: aload_1
    //   506: aload 15
    //   508: invokeinterface 294 2 0
    //   513: pop
    //   514: goto -289 -> 225
    //   517: astore 14
    //   519: aload 12
    //   521: astore 13
    //   523: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +19 -> 545
    //   529: aload 12
    //   531: astore 13
    //   533: ldc_w 662
    //   536: iconst_2
    //   537: ldc_w 664
    //   540: aload 14
    //   542: invokestatic 666	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: aload_1
    //   546: astore 13
    //   548: aload 12
    //   550: ifnull -490 -> 60
    //   553: aload 12
    //   555: invokeinterface 354 1 0
    //   560: aload_1
    //   561: areturn
    //   562: aload_1
    //   563: astore 13
    //   565: aload 12
    //   567: ifnull -507 -> 60
    //   570: aload 12
    //   572: invokeinterface 354 1 0
    //   577: aload_1
    //   578: areturn
    //   579: astore_1
    //   580: aconst_null
    //   581: astore 13
    //   583: aload 13
    //   585: ifnull +10 -> 595
    //   588: aload 13
    //   590: invokeinterface 354 1 0
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
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    paramArrayList = this.mAlbumListCallback.queryRecentImageList(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if ((paramInt2 != -1) && (localQQAlbumInfo.mMediaFileCount >= paramInt2)) {
      return localQQAlbumInfo;
    }
    paramContext = QAlbumUtil.queryRecentVideos(paramContext, 0, paramInt2, paramMediaFileFilter, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if ((localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) || (paramInt2 == -1)) {}
    for (localQQAlbumInfo.mMediaFileCount += paramContext.size();; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  QQAlbumInfo queryRecentMediaBucket(AbstractAlbumListFragment paramAbstractAlbumListFragment, QQAlbumInfo paramQQAlbumInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAlbumInfo localQQAlbumInfo = paramQQAlbumInfo;
    if (paramQQAlbumInfo == null) {
      localQQAlbumInfo = new QQAlbumInfo();
    }
    localQQAlbumInfo.mMediaFileCount = paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.videoCount;
    if (paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.firstVideoInfo == null)
    {
      paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.createFilterListener();
      paramQQAlbumInfo = new MediaQueryHelper.Builder().setEachCount(3).needImage(paramBoolean1).needVideo(paramBoolean2).setListener(paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.filterListener).build(paramAbstractAlbumListFragment.getActivity());
      while ((!paramQQAlbumInfo.mTraversalDone) && (paramQQAlbumInfo.mediaList.isEmpty())) {
        paramQQAlbumInfo.queryNext();
      }
      if (!paramQQAlbumInfo.mediaList.isEmpty()) {
        paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.firstVideoInfo = ((LocalMediaInfo)paramQQAlbumInfo.mediaList.get(0));
      }
      paramQQAlbumInfo.close();
    }
    if (paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.firstVideoInfo != null)
    {
      localQQAlbumInfo.mCoverInfo = paramAbstractAlbumListFragment.mAlbumListLogic.mPhotoCommonData.firstVideoInfo;
      localQQAlbumInfo.coverDate = localQQAlbumInfo.mCoverInfo.modifiedDate;
    }
    return localQQAlbumInfo;
  }
  
  /* Error */
  QQAlbumInfo queryRecentVideoBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 336	com/tencent/mobileqq/data/QQAlbumInfo
    //   9: dup
    //   10: invokespecial 594	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc_w 671
    //   20: putfield 599	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   23: aload 8
    //   25: getstatic 674	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:RECENT_ALBUM_NAME	Ljava/lang/String;
    //   28: putfield 607	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   31: iload_3
    //   32: ifle +142 -> 174
    //   35: getstatic 306	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   38: invokevirtual 389	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   41: astore 5
    //   43: aload 5
    //   45: ldc_w 391
    //   48: iload_3
    //   49: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 401	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   55: pop
    //   56: aload 5
    //   58: invokevirtual 405	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   61: astore 5
    //   63: aload_1
    //   64: invokevirtual 312	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: aload 5
    //   69: getstatic 176	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:VIDEO_COLUMNS	[Ljava/lang/String;
    //   72: ldc_w 314
    //   75: aconst_null
    //   76: ldc 29
    //   78: invokevirtual 320	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_1
    //   82: aload 4
    //   84: ifnull +16 -> 100
    //   87: aload_1
    //   88: astore 5
    //   90: aload_0
    //   91: aload_1
    //   92: iload_3
    //   93: aload 4
    //   95: invokevirtual 330	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:getVideoList	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   98: astore 6
    //   100: aload 6
    //   102: ifnull +59 -> 161
    //   105: aload_1
    //   106: astore 5
    //   108: aload 6
    //   110: invokeinterface 334 1 0
    //   115: ifne +46 -> 161
    //   118: aload_1
    //   119: astore 5
    //   121: aload 6
    //   123: invokeinterface 343 1 0
    //   128: istore_2
    //   129: aload_1
    //   130: astore 5
    //   132: aload 8
    //   134: iload_2
    //   135: putfield 339	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   138: iload_2
    //   139: ifle +22 -> 161
    //   142: aload_1
    //   143: astore 5
    //   145: aload 8
    //   147: aload 6
    //   149: iconst_0
    //   150: invokeinterface 347 2 0
    //   155: checkcast 263	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   158: putfield 351	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   161: aload_1
    //   162: ifnull +9 -> 171
    //   165: aload_1
    //   166: invokeinterface 354 1 0
    //   171: aload 8
    //   173: areturn
    //   174: getstatic 306	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   177: astore 5
    //   179: goto -116 -> 63
    //   182: astore 4
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: astore 5
    //   189: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +19 -> 211
    //   195: aload_1
    //   196: astore 5
    //   198: ldc 34
    //   200: iconst_2
    //   201: aload 4
    //   203: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   206: aload 4
    //   208: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_1
    //   212: ifnull -41 -> 171
    //   215: aload_1
    //   216: invokeinterface 354 1 0
    //   221: aload 8
    //   223: areturn
    //   224: astore_1
    //   225: aload 7
    //   227: astore 4
    //   229: aload 4
    //   231: ifnull +10 -> 241
    //   234: aload 4
    //   236: invokeinterface 354 1 0
    //   241: aload_1
    //   242: athrow
    //   243: astore_1
    //   244: aload 5
    //   246: astore 4
    //   248: goto -19 -> 229
    //   251: astore 4
    //   253: goto -67 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	AlbumListAdapter
    //   0	256	1	paramContext	Context
    //   0	256	2	paramInt1	int
    //   0	256	3	paramInt2	int
    //   0	256	4	paramMediaFileFilter	MediaFileFilter
    //   41	204	5	localObject1	Object
    //   4	144	6	localList	List
    //   1	225	7	localObject2	Object
    //   13	209	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   35	63	182	java/lang/Exception
    //   63	82	182	java/lang/Exception
    //   174	179	182	java/lang/Exception
    //   35	63	224	finally
    //   63	82	224	finally
    //   174	179	224	finally
    //   90	100	243	finally
    //   108	118	243	finally
    //   121	129	243	finally
    //   132	138	243	finally
    //   145	161	243	finally
    //   189	195	243	finally
    //   198	211	243	finally
    //   90	100	251	java/lang/Exception
    //   108	118	251	java/lang/Exception
    //   121	129	251	java/lang/Exception
    //   132	138	251	java/lang/Exception
    //   145	161	251	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> queryVideoBuckets(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +49 -> 50
    //   4: getstatic 306	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 312	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 178	com/tencent/mobileqq/activity/photo/album/AlbumListAdapter:VIDEO_PROJECTION_BUCKET	[Ljava/lang/String;
    //   16: ldc 38
    //   18: aconst_null
    //   19: ldc 8
    //   21: invokevirtual 320	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   39: invokeinterface 354 1 0
    //   44: aload_1
    //   45: astore 12
    //   47: aload 12
    //   49: areturn
    //   50: getstatic 306	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 389	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore_3
    //   57: aload_3
    //   58: ldc_w 391
    //   61: iload_2
    //   62: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   65: invokevirtual 401	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   68: pop
    //   69: aload_3
    //   70: invokevirtual 405	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   73: astore_3
    //   74: goto -66 -> 8
    //   77: aload_3
    //   78: astore 12
    //   80: new 649	java/util/LinkedList
    //   83: dup
    //   84: invokespecial 650	java/util/LinkedList:<init>	()V
    //   87: astore_1
    //   88: aload_3
    //   89: astore 12
    //   91: aload_3
    //   92: ldc 78
    //   94: invokeinterface 653 2 0
    //   99: istore_2
    //   100: aload_3
    //   101: astore 12
    //   103: aload_3
    //   104: ldc 170
    //   106: invokeinterface 653 2 0
    //   111: istore 4
    //   113: aload_3
    //   114: astore 12
    //   116: aload_3
    //   117: ldc 80
    //   119: invokeinterface 653 2 0
    //   124: istore 5
    //   126: aload_3
    //   127: astore 12
    //   129: aload_3
    //   130: ldc 86
    //   132: invokeinterface 653 2 0
    //   137: istore 6
    //   139: aload_3
    //   140: astore 12
    //   142: aload_3
    //   143: ldc 84
    //   145: invokeinterface 653 2 0
    //   150: istore 7
    //   152: aload_3
    //   153: astore 12
    //   155: aload_3
    //   156: ldc 90
    //   158: invokeinterface 653 2 0
    //   163: istore 8
    //   165: aload_3
    //   166: astore 12
    //   168: aload_3
    //   169: ldc_w 655
    //   172: invokeinterface 653 2 0
    //   177: istore 9
    //   179: aload_3
    //   180: astore 12
    //   182: aload_3
    //   183: invokeinterface 410 1 0
    //   188: ifeq +245 -> 433
    //   191: aload_3
    //   192: astore 12
    //   194: aload_3
    //   195: iload_2
    //   196: invokeinterface 413 2 0
    //   201: astore 14
    //   203: aload_3
    //   204: astore 12
    //   206: aload_3
    //   207: iload 5
    //   209: invokeinterface 413 2 0
    //   214: astore 15
    //   216: aload_3
    //   217: astore 12
    //   219: aload 14
    //   221: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne -45 -> 179
    //   227: aload_3
    //   228: astore 12
    //   230: aload 15
    //   232: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne -56 -> 179
    //   238: aload_3
    //   239: astore 12
    //   241: aload_3
    //   242: iload 7
    //   244: invokeinterface 285 2 0
    //   249: lstore 10
    //   251: aload_3
    //   252: astore 12
    //   254: new 336	com/tencent/mobileqq/data/QQAlbumInfo
    //   257: dup
    //   258: invokespecial 594	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   261: astore 13
    //   263: aload_3
    //   264: astore 12
    //   266: aload 13
    //   268: aload 15
    //   270: putfield 607	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   273: aload_3
    //   274: astore 12
    //   276: aload 13
    //   278: aload 14
    //   280: putfield 599	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   283: aload_3
    //   284: astore 12
    //   286: aload 13
    //   288: lload 10
    //   290: putfield 658	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   293: aload_3
    //   294: astore 12
    //   296: aload 13
    //   298: getfield 351	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   301: astore 14
    //   303: aload_3
    //   304: astore 12
    //   306: aload 14
    //   308: aload_3
    //   309: iload 6
    //   311: invokeinterface 413 2 0
    //   316: putfield 267	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: aload_3
    //   320: astore 12
    //   322: aload 14
    //   324: aload_3
    //   325: iload 4
    //   327: invokeinterface 285 2 0
    //   332: putfield 472	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   335: aload_3
    //   336: astore 12
    //   338: aload 14
    //   340: lload 10
    //   342: putfield 271	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   345: aload_3
    //   346: astore 12
    //   348: aload 14
    //   350: aload_3
    //   351: iload 8
    //   353: invokeinterface 413 2 0
    //   358: putfield 281	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   361: aload_3
    //   362: astore 12
    //   364: aload 13
    //   366: aload_3
    //   367: iload 9
    //   369: invokeinterface 276 2 0
    //   374: putfield 339	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   377: aload_3
    //   378: astore 12
    //   380: aload_1
    //   381: aload 13
    //   383: invokeinterface 294 2 0
    //   388: pop
    //   389: goto -210 -> 179
    //   392: astore 13
    //   394: aload_3
    //   395: astore 12
    //   397: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +18 -> 418
    //   403: aload_3
    //   404: astore 12
    //   406: ldc_w 662
    //   409: iconst_2
    //   410: ldc_w 749
    //   413: aload 13
    //   415: invokestatic 666	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: astore 12
    //   421: aload_3
    //   422: ifnull -375 -> 47
    //   425: aload_3
    //   426: invokeinterface 354 1 0
    //   431: aload_1
    //   432: areturn
    //   433: aload_1
    //   434: astore 12
    //   436: aload_3
    //   437: ifnull -390 -> 47
    //   440: aload_3
    //   441: invokeinterface 354 1 0
    //   446: aload_1
    //   447: areturn
    //   448: astore_1
    //   449: aconst_null
    //   450: astore 12
    //   452: aload 12
    //   454: ifnull +10 -> 464
    //   457: aload 12
    //   459: invokeinterface 354 1 0
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
  
  void setData()
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