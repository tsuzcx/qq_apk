package com.tencent.mobileqq.activity.photo.album;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QAlbumBaseUtil
{
  public static int CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 0;
  protected static final String IMAGE_ORDER_BY = "date_modified DESC, date_added DESC";
  private static final int MAX_PHOTO_HEIGHT_OF_CACHE = 65535;
  private static final int MAX_PHOTO_WIDTH_OF_CACHE = 65535;
  protected static final String TAG = "QAlbumUtil";
  public static final int TYPE_SLIDESHOW = 1;
  private static String[] VIDEO_COLUMNS;
  protected static String[] columns = { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size" };
  private static Map<String, Integer> pathWHMap;
  public static boolean sAlbumQueryFailReport = false;
  private static long sLastModify;
  
  static
  {
    CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 10485760;
    pathWHMap = new HashMap();
    if (Build.VERSION.SDK_INT >= 16) {}
    for (VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" }; Build.VERSION.SDK_INT >= 16; VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" })
    {
      columns = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size", "width", "height" };
      return;
    }
  }
  
  private static int addPhotoInfo(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, BitmapFactory.Options paramOptions, int[] paramArrayOfInt, int paramInt11, String paramString1, String paramString2)
  {
    long l1 = paramCursor.getLong(paramInt4);
    long l2 = paramCursor.getLong(paramInt5);
    if (sLastModify < l2) {
      sLastModify = l2;
    }
    int i = 0;
    if (paramCursor.getInt(paramInt9) == 0) {
      i = 1;
    }
    long l3 = paramCursor.getLong(paramInt2);
    if ((paramInt1 > 0) && (i != 0))
    {
      getWHByPath(paramString1, paramOptions, paramArrayOfInt);
      if (paramArrayOfInt[0] < paramInt1)
      {
        paramInt2 = paramInt11;
        if (paramArrayOfInt[1] < paramInt1) {}
      }
      else
      {
        paramOptions = new LocalMediaInfo();
        paramOptions._id = l3;
        paramOptions.path = paramString1;
        paramOptions.addedDate = l1;
        paramOptions.modifiedDate = l2;
        paramOptions.orientation = paramCursor.getInt(paramInt3);
        paramOptions.mMimeType = paramString2;
        paramOptions.fileSize = paramCursor.getLong(paramInt6);
        paramOptions.mediaWidth = paramArrayOfInt[0];
        paramOptions.mediaHeight = paramArrayOfInt[1];
        paramOptions.latitude = ((int)(paramCursor.getDouble(paramInt7) * 1000000.0D));
        paramOptions.longitude = ((int)(paramCursor.getDouble(paramInt8) * 1000000.0D));
        checkWidthAndHeight(paramString1, paramOptions);
        paramList.add(paramOptions);
        paramInt2 = paramInt11 + 1;
      }
      return paramInt2;
    }
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo._id = l3;
    localLocalMediaInfo.path = paramString1;
    localLocalMediaInfo.addedDate = paramCursor.getLong(paramInt4);
    localLocalMediaInfo.modifiedDate = paramCursor.getLong(paramInt5);
    localLocalMediaInfo.orientation = paramCursor.getInt(paramInt3);
    localLocalMediaInfo.mMimeType = paramString2;
    localLocalMediaInfo.fileSize = paramCursor.getLong(paramInt6);
    localLocalMediaInfo.latitude = ((int)(paramCursor.getDouble(paramInt7) * 1000000.0D));
    localLocalMediaInfo.longitude = ((int)(paramCursor.getDouble(paramInt8) * 1000000.0D));
    localLocalMediaInfo.mediaWidth = paramCursor.getInt(paramInt9);
    localLocalMediaInfo.mediaHeight = paramCursor.getInt(paramInt10);
    if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0))
    {
      getWHByPath(paramString1, paramOptions, paramArrayOfInt);
      localLocalMediaInfo.mediaWidth = paramArrayOfInt[0];
      localLocalMediaInfo.mediaHeight = paramArrayOfInt[1];
    }
    checkWidthAndHeight(paramString1, localLocalMediaInfo);
    paramList.add(localLocalMediaInfo);
    return paramInt11 + 1;
  }
  
  private static void addVideoToMediaList(int paramInt, List<LocalMediaInfo> paramList1, List<LocalMediaInfo> paramList2)
  {
    int n = 0;
    int i = paramList1.size();
    int k = 0;
    int j = 0;
    int m;
    if (k < paramList2.size())
    {
      LocalMediaInfo localLocalMediaInfo1 = (LocalMediaInfo)paramList2.get(k);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)paramList1.get(i - 1);
      if (localLocalMediaInfo1.modifiedDate <= localLocalMediaInfo2.modifiedDate)
      {
        if (paramInt == -1) {
          while (k < paramList2.size())
          {
            paramList1.add(paramList2.get(k));
            k += 1;
          }
        }
        i = Math.min(paramList2.size() - k, paramInt - i);
        paramInt = n;
        while (paramInt < i)
        {
          paramList1.add(paramList2.get(paramInt + k));
          paramInt += 1;
        }
      }
      m = j;
      while (m < i)
      {
        localLocalMediaInfo2 = (LocalMediaInfo)paramList1.get(m);
        if (localLocalMediaInfo1.modifiedDate <= localLocalMediaInfo2.modifiedDate)
        {
          m += 1;
        }
        else
        {
          paramList1.add(m, localLocalMediaInfo1);
          if ((paramInt != -1) && (paramList1.size() > paramInt)) {
            paramList1.remove(i);
          }
          int i1 = paramList1.size();
          j = i;
          if (i != i1) {
            j = i1;
          }
          i = m + 1;
        }
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      i = m;
      break;
      return;
      m = i;
      i = j;
      j = m;
    }
  }
  
  private static void checkWidthAndHeight(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if (((paramLocalMediaInfo.mediaWidth <= 0) || (paramLocalMediaInfo.mediaHeight <= 0)) && (QLog.isColorLevel())) {
      QLog.i("QAlbumUtil", 2, "no size " + paramString);
    }
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static String fixMimeType(String paramString1, String paramString2)
  {
    if ((paramString1.indexOf(".jpg") != -1) || (paramString1.indexOf(".jpeg") != -1)) {
      return "image/jpeg";
    }
    if (paramString1.indexOf(".gif") != -1) {
      return "image/gif";
    }
    if (paramString1.indexOf(".bmp") != -1) {
      return "image/bmp";
    }
    if (paramString1.indexOf(".png") != -1) {
      return "image/png";
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAlbumUtil", 2, "Filter mime type:" + paramString2 + ", path is " + paramString1);
    }
    return null;
  }
  
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong)
  {
    return getAlbumMedias(paramContext, paramString1, paramString2, paramInt1, paramMediaFileFilter, paramInt2, paramInt3, paramBoolean1, paramArrayList, paramBoolean2, paramLong, -1);
  }
  
  /* Error */
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 16
    //   3: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 17
    //   11: iconst_2
    //   12: ldc 245
    //   14: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: ldc 250
    //   19: aload_1
    //   20: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +98 -> 121
    //   26: aload_0
    //   27: invokevirtual 259	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 265	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   33: getstatic 70	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   36: aconst_null
    //   37: aconst_null
    //   38: ldc 11
    //   40: invokevirtual 271	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 14
    //   45: aload 14
    //   47: astore 13
    //   49: aload_0
    //   50: aload 14
    //   52: aconst_null
    //   53: iload_3
    //   54: aload 4
    //   56: iconst_1
    //   57: lload 10
    //   59: invokestatic 275	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSystemAndAppVideoList	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/ArrayList;
    //   62: astore 15
    //   64: aload 14
    //   66: ifnull +10 -> 76
    //   69: aload 14
    //   71: invokeinterface 278 1 0
    //   76: aload 15
    //   78: areturn
    //   79: astore 15
    //   81: aconst_null
    //   82: astore 14
    //   84: aload 14
    //   86: astore 13
    //   88: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +18 -> 109
    //   94: aload 14
    //   96: astore 13
    //   98: ldc 17
    //   100: iconst_2
    //   101: ldc_w 280
    //   104: aload 15
    //   106: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload 14
    //   111: ifnull +10 -> 121
    //   114: aload 14
    //   116: invokeinterface 278 1 0
    //   121: aload 16
    //   123: astore 13
    //   125: aload 4
    //   127: ifnull +42 -> 169
    //   130: aload 16
    //   132: astore 13
    //   134: aload 4
    //   136: invokevirtual 289	com/tencent/mobileqq/activity/photo/MediaFileFilter:showImage	()Z
    //   139: ifeq +30 -> 169
    //   142: iload 12
    //   144: iconst_1
    //   145: if_icmpne +82 -> 227
    //   148: aload_0
    //   149: aload_1
    //   150: aload_2
    //   151: iload_3
    //   152: aload 4
    //   154: iload 5
    //   156: iload 6
    //   158: iload 7
    //   160: aload 8
    //   162: iload 9
    //   164: invokestatic 293	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSlideShowAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   167: astore 13
    //   169: aload 4
    //   171: ifnull +89 -> 260
    //   174: aload 4
    //   176: invokevirtual 296	com/tencent/mobileqq/activity/photo/MediaFileFilter:showVideo	()Z
    //   179: ifeq +81 -> 260
    //   182: aload_0
    //   183: aload_1
    //   184: aload_2
    //   185: iload_3
    //   186: aload 4
    //   188: lload 10
    //   190: invokestatic 300	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumVideos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   193: astore_0
    //   194: aload_1
    //   195: aload 13
    //   197: aload_0
    //   198: invokestatic 304	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sortMedias	(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   201: iload_3
    //   202: aload 13
    //   204: aload_0
    //   205: invokestatic 308	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:limitPhotosAndVideos	(ILjava/util/List;Ljava/util/List;)Ljava/util/List;
    //   208: areturn
    //   209: astore_0
    //   210: aconst_null
    //   211: astore 13
    //   213: aload 13
    //   215: ifnull +10 -> 225
    //   218: aload 13
    //   220: invokeinterface 278 1 0
    //   225: aload_0
    //   226: athrow
    //   227: aload_0
    //   228: aload_1
    //   229: aload_2
    //   230: iload_3
    //   231: aload 4
    //   233: iload 5
    //   235: iload 6
    //   237: iload 7
    //   239: aload 8
    //   241: iload 9
    //   243: invokestatic 311	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   246: astore 13
    //   248: goto -79 -> 169
    //   251: astore_0
    //   252: goto -39 -> 213
    //   255: astore 15
    //   257: goto -173 -> 84
    //   260: aconst_null
    //   261: astore_0
    //   262: goto -68 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramContext	Context
    //   0	265	1	paramString1	String
    //   0	265	2	paramString2	String
    //   0	265	3	paramInt1	int
    //   0	265	4	paramMediaFileFilter	MediaFileFilter
    //   0	265	5	paramInt2	int
    //   0	265	6	paramInt3	int
    //   0	265	7	paramBoolean1	boolean
    //   0	265	8	paramArrayList	ArrayList<String>
    //   0	265	9	paramBoolean2	boolean
    //   0	265	10	paramLong	long
    //   0	265	12	paramInt4	int
    //   47	200	13	localObject1	Object
    //   43	72	14	localCursor	Cursor
    //   62	15	15	localArrayList	ArrayList
    //   79	26	15	localException1	java.lang.Exception
    //   255	1	15	localException2	java.lang.Exception
    //   1	130	16	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	45	79	java/lang/Exception
    //   26	45	209	finally
    //   49	64	251	finally
    //   88	94	251	finally
    //   98	109	251	finally
    //   49	64	255	java/lang/Exception
  }
  
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    return getAlbumMedias(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter, 0, -1, false, null, false, paramLong);
  }
  
  public static List<LocalMediaInfo> getAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAlbumUtil", 2, "getAlbumPhotos");
    }
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1))) {
      paramContext = queryRecentImages(paramContext, paramInt3, paramInt1, paramMediaFileFilter, paramBoolean1, paramInt2, paramArrayList, paramBoolean2);
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = queryImages(paramContext, "bucket_id='" + paramString1 + "'", paramInt1, paramMediaFileFilter);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("QAlbumUtil", 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  /* Error */
  public static List<LocalMediaInfo> getAlbumVideos(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: ldc_w 318
    //   7: aload_1
    //   8: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: sipush 210
    //   18: iload_3
    //   19: aload 4
    //   21: lload 5
    //   23: invokestatic 340	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryRecentVideos	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   26: areturn
    //   27: new 342	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 343	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: new 179	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 324
    //   46: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 326
    //   56: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 259	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: getstatic 265	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   70: getstatic 70	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   73: aload_1
    //   74: aconst_null
    //   75: ldc 11
    //   77: invokevirtual 271	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: getstatic 48	android/os/Build$VERSION:SDK_INT	I
    //   86: bipush 16
    //   88: if_icmplt +35 -> 123
    //   91: iconst_1
    //   92: istore 7
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: aload 8
    //   99: iload_3
    //   100: aload 4
    //   102: iload 7
    //   104: lload 5
    //   106: invokestatic 347	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   109: pop
    //   110: aload_1
    //   111: ifnull +77 -> 188
    //   114: aload_1
    //   115: invokeinterface 278 1 0
    //   120: aload 8
    //   122: areturn
    //   123: iconst_0
    //   124: istore 7
    //   126: goto -32 -> 94
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: astore_0
    //   134: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +15 -> 152
    //   140: aload_1
    //   141: astore_0
    //   142: ldc 17
    //   144: iconst_2
    //   145: ldc_w 280
    //   148: aload_2
    //   149: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_1
    //   153: ifnull +35 -> 188
    //   156: aload_1
    //   157: invokeinterface 278 1 0
    //   162: aload 8
    //   164: areturn
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +9 -> 178
    //   172: aload_0
    //   173: invokeinterface 278 1 0
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: goto -13 -> 168
    //   184: astore_2
    //   185: goto -53 -> 132
    //   188: aload 8
    //   190: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramContext	Context
    //   0	191	1	paramString1	String
    //   0	191	2	paramString2	String
    //   0	191	3	paramInt	int
    //   0	191	4	paramMediaFileFilter	MediaFileFilter
    //   0	191	5	paramLong	long
    //   92	33	7	bool	boolean
    //   34	155	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   63	81	129	java/lang/Exception
    //   63	81	165	finally
    //   83	91	180	finally
    //   96	110	180	finally
    //   134	140	180	finally
    //   142	152	180	finally
    //   83	91	184	java/lang/Exception
    //   96	110	184	java/lang/Exception
  }
  
  private static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    getImageList(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramMediaFileFilter, null, false);
  }
  
  protected static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean1, MediaFileFilter paramMediaFileFilter, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    if (paramCursor.getCount() > 0)
    {
      if (paramList != null) {
        break label240;
      }
      paramList = new ArrayList();
    }
    label240:
    for (;;)
    {
      int k = paramCursor.getColumnIndexOrThrow("_id");
      int m = paramCursor.getColumnIndexOrThrow("_data");
      int n = paramCursor.getColumnIndexOrThrow("orientation");
      int i1 = paramCursor.getColumnIndexOrThrow("date_added");
      int i2 = paramCursor.getColumnIndexOrThrow("date_modified");
      int i3 = paramCursor.getColumnIndexOrThrow("mime_type");
      int i4 = paramCursor.getColumnIndexOrThrow("_size");
      int i5 = paramCursor.getColumnIndexOrThrow("latitude");
      int i6 = paramCursor.getColumnIndexOrThrow("longitude");
      int i = 0;
      int j = 0;
      if (paramBoolean1)
      {
        i = paramCursor.getColumnIndexOrThrow("width");
        j = paramCursor.getColumnIndexOrThrow("height");
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      if (QLog.isColorLevel()) {
        QLog.i("QAlbumUtil", 2, "getImageList imageCursor count:" + paramCursor.getCount());
      }
      queryImageList(paramCursor, paramList, paramInt1, paramInt2, paramBoolean1, paramMediaFileFilter, paramArrayList, k, m, n, i1, i2, i3, i4, i5, i6, i, j, localOptions, arrayOfInt, 0);
      return;
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> getSlideShowAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 342	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 343	java/util/ArrayList:<init>	()V
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 11
    //   15: new 179	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   22: astore 14
    //   24: iconst_0
    //   25: istore 10
    //   27: aload_2
    //   28: ifnull +13 -> 41
    //   31: ldc_w 318
    //   34: aload_1
    //   35: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifeq +6 -> 44
    //   41: iconst_1
    //   42: istore 10
    //   44: iload 10
    //   46: ifeq +18 -> 64
    //   49: iload_3
    //   50: ifgt +55 -> 105
    //   53: new 374	java/lang/IllegalArgumentException
    //   56: dup
    //   57: ldc_w 376
    //   60: invokespecial 377	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: aload 14
    //   66: new 179	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 324
    //   76: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 326
    //   86: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 14
    //   98: ldc_w 379
    //   101: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: iload 7
    //   107: ifeq +199 -> 306
    //   110: aload 12
    //   112: astore_1
    //   113: aload 14
    //   115: new 179	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 381
    //   125: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   131: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: ldc_w 383
    //   137: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 66
    //   142: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 385
    //   148: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 66
    //   153: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 387
    //   159: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 68
    //   164: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 385
    //   170: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 68
    //   175: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 389
    //   181: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 68
    //   186: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 391
    //   192: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 66
    //   197: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 393
    //   203: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 68
    //   208: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 391
    //   214: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 66
    //   219: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 395
    //   225: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 12
    //   237: astore_1
    //   238: aload_0
    //   239: aload 14
    //   241: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: iconst_3
    //   245: anewarray 50	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: iload 5
    //   252: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: iload 6
    //   260: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   263: aastore
    //   264: dup
    //   265: iconst_2
    //   266: iload 6
    //   268: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   271: aastore
    //   272: iload_3
    //   273: invokestatic 402	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   276: astore_0
    //   277: aload_0
    //   278: aload 13
    //   280: iload 6
    //   282: iload_3
    //   283: iconst_1
    //   284: aload 4
    //   286: aload 8
    //   288: iload 9
    //   290: invokestatic 352	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   293: aload_0
    //   294: ifnull +9 -> 303
    //   297: aload_0
    //   298: invokeinterface 278 1 0
    //   303: aload 13
    //   305: areturn
    //   306: aload 12
    //   308: astore_1
    //   309: aload 14
    //   311: new 179	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 381
    //   321: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   327: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc_w 383
    //   333: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc 66
    //   338: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 385
    //   344: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc 66
    //   349: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 404
    //   355: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc 68
    //   360: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: ldc_w 385
    //   366: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc 68
    //   371: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc_w 406
    //   377: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: goto -152 -> 235
    //   390: astore_2
    //   391: aload 11
    //   393: astore_0
    //   394: aload_0
    //   395: astore_1
    //   396: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +16 -> 415
    //   402: aload_0
    //   403: astore_1
    //   404: ldc 17
    //   406: iconst_2
    //   407: aload_2
    //   408: invokevirtual 409	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   411: aload_2
    //   412: invokestatic 411	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   415: aload_0
    //   416: ifnull -113 -> 303
    //   419: aload_0
    //   420: invokeinterface 278 1 0
    //   425: aload 13
    //   427: areturn
    //   428: astore_2
    //   429: aload_1
    //   430: astore_0
    //   431: aload_2
    //   432: astore_1
    //   433: aload_0
    //   434: ifnull +9 -> 443
    //   437: aload_0
    //   438: invokeinterface 278 1 0
    //   443: aload_1
    //   444: athrow
    //   445: astore_1
    //   446: goto -13 -> 433
    //   449: astore_2
    //   450: goto -56 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramContext	Context
    //   0	453	1	paramString1	String
    //   0	453	2	paramString2	String
    //   0	453	3	paramInt1	int
    //   0	453	4	paramMediaFileFilter	MediaFileFilter
    //   0	453	5	paramInt2	int
    //   0	453	6	paramInt3	int
    //   0	453	7	paramBoolean1	boolean
    //   0	453	8	paramArrayList	ArrayList<String>
    //   0	453	9	paramBoolean2	boolean
    //   25	20	10	i	int
    //   13	379	11	localObject1	Object
    //   10	297	12	localObject2	Object
    //   7	419	13	localArrayList	ArrayList
    //   22	288	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   113	235	390	java/lang/Exception
    //   238	277	390	java/lang/Exception
    //   309	387	390	java/lang/Exception
    //   113	235	428	finally
    //   238	277	428	finally
    //   309	387	428	finally
    //   396	402	428	finally
    //   404	415	428	finally
    //   277	293	445	finally
    //   277	293	449	java/lang/Exception
  }
  
  private static ArrayList<LocalMediaInfo> getSystemAndAppVideoList(Context paramContext, Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    paramContext = new ArrayList();
    paramCursor = (ArrayList)getVideoList(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean, paramLong);
    if (paramCursor != null) {
      paramContext.addAll(paramCursor);
    }
    if (QLog.isColorLevel()) {
      QLog.e("QAlbumUtil", 2, "getSystemAndAppVideoList listsize=" + paramContext.size());
    }
    paramCursor = MediaScanner.getInstance(BaseApplication.getContext());
    if (paramCursor != null)
    {
      paramCursor = paramCursor.getMediaScannerInfos(false, -1);
      if (paramCursor != null)
      {
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          paramList = (MediaScannerInfo)paramCursor.next();
          paramMediaFileFilter = new LocalMediaInfo();
          paramMediaFileFilter._id = paramList.id;
          paramMediaFileFilter.mDuration = paramList.duration;
          paramMediaFileFilter.fileSize = paramList.fileSize;
          paramMediaFileFilter.path = paramList.path;
          paramMediaFileFilter.modifiedDate = paramList.modifiedDate;
          paramMediaFileFilter.mMimeType = paramList.mimeType;
          paramMediaFileFilter.isSystemMeidaStore = false;
          paramContext.add(paramMediaFileFilter);
        }
      }
    }
    Collections.sort(paramContext);
    return paramContext;
  }
  
  @TargetApi(10)
  private static List<LocalMediaInfo> getVideoList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    int i = paramCursor.getCount();
    if (QLog.isColorLevel()) {
      QLog.i("QAlbumUtil", 2, "getVideoList videoCursor count:" + i);
    }
    if (i <= 0) {
      return null;
    }
    if (paramList == null) {
      paramList = new ArrayList();
    }
    for (;;)
    {
      int k = paramCursor.getColumnIndexOrThrow("_id");
      int m = paramCursor.getColumnIndexOrThrow("_data");
      int n = paramCursor.getColumnIndexOrThrow("date_added");
      int i1 = paramCursor.getColumnIndexOrThrow("date_modified");
      int i2 = paramCursor.getColumnIndexOrThrow("duration");
      int i3 = paramCursor.getColumnIndexOrThrow("mime_type");
      int i4 = paramCursor.getColumnIndexOrThrow("_size");
      i = 0;
      int j = 0;
      if (paramBoolean)
      {
        i = paramCursor.getColumnIndexOrThrow("width");
        j = paramCursor.getColumnIndexOrThrow("height");
      }
      qureyVideoList(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean, paramLong, k, m, n, i1, i2, i3, i4, i, j);
      return paramList;
    }
  }
  
  public static void getWHByPath(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)pathWHMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        SafeBitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
        QLog.e("QAlbumUtil", 1, "getWHByPath error. ", paramString);
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
          i = paramOptions.outWidth;
          j = paramOptions.outHeight;
          pathWHMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
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
          break label126;
        }
        paramString = paramString;
        j = 0;
        i = 0;
      }
      label126:
      continue;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  private static boolean ignorePath(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
      } while (!paramString.contains((String)paramArrayList.next()));
    }
    for (int i = 1;; i = 0) {
      return i != 0;
    }
  }
  
  private static List<LocalMediaInfo> limitPhotosAndVideos(int paramInt, List<LocalMediaInfo> paramList1, List<LocalMediaInfo> paramList2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("getAlbumMedias,mediaList size:");
      if (paramList1 == null) {
        break label93;
      }
      localObject = Integer.valueOf(paramList1.size());
      localStringBuilder = localStringBuilder.append(localObject).append(" videoList size:");
      if (paramList2 == null) {
        break label100;
      }
    }
    label93:
    label100:
    for (Object localObject = Integer.valueOf(paramList2.size());; localObject = "null")
    {
      QLog.d("QAlbumUtil", 2, localObject);
      if ((paramList2 != null) && (!paramList2.isEmpty())) {
        break label107;
      }
      return paramList1;
      localObject = "null";
      break;
    }
    label107:
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return paramList2;
    }
    addVideoToMediaList(paramInt, paramList1, paramList2);
    return paramList1;
  }
  
  private static void queryImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter, ArrayList<String> paramArrayList, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, BitmapFactory.Options paramOptions, int[] paramArrayOfInt, int paramInt14)
  {
    int k = 0;
    int i = 0;
    int j = paramInt14;
    paramInt14 = k;
    for (;;)
    {
      String str;
      label60:
      Object localObject2;
      if (paramCursor.moveToNext())
      {
        str = paramCursor.getString(paramInt4);
        if (!fileExistsAndNotEmpty(str))
        {
          if (str == null)
          {
            k = i + 1;
            i = paramInt14;
            paramInt14 = k;
            if (!QLog.isColorLevel()) {
              break label335;
            }
            localObject2 = new StringBuilder().append("getImageList file not exists:");
            if (str == null) {
              break label138;
            }
          }
          label138:
          for (localObject1 = str;; localObject1 = "null")
          {
            QLog.i("QAlbumUtil", 2, (String)localObject1);
            k = paramInt14;
            paramInt14 = i;
            i = k;
            break;
            k = paramInt14 + 1;
            paramInt14 = i;
            i = k;
            break label60;
          }
        }
        if (ignorePath(paramArrayList, str)) {
          continue;
        }
        localObject2 = paramCursor.getString(paramInt8);
        Object localObject1 = localObject2;
        if (paramMediaFileFilter != null)
        {
          localObject1 = localObject2;
          if (paramMediaFileFilter.filter((String)localObject2))
          {
            if ((!"*/*".equals(localObject2)) && (!"image/*".equals(localObject2))) {
              break label289;
            }
            localObject1 = fixMimeType(str, (String)localObject2);
            if (localObject1 == null) {
              continue;
            }
          }
        }
        k = addPhotoInfo(paramCursor, paramList, paramInt1, paramBoolean, paramInt3, paramInt5, paramInt6, paramInt7, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramOptions, paramArrayOfInt, j, str, (String)localObject1);
        j = k;
        if (paramInt2 <= 0) {
          continue;
        }
        j = k;
        if (k < paramInt2) {
          continue;
        }
      }
      else
      {
        reportFail(i, paramInt14);
        return;
      }
      label289:
      if (QLog.isColorLevel())
      {
        QLog.i("QAlbumUtil", 2, "Filter unknown " + (String)localObject2 + ", path is " + str);
        continue;
        label335:
        k = paramInt14;
        paramInt14 = i;
        i = k;
      }
    }
  }
  
  private static Cursor queryImages(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, columns, paramString, paramArrayOfString, "date_modified DESC, date_added DESC");
    }
  }
  
  /* Error */
  private static List<LocalMediaInfo> queryImages(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 342	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 343	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 402	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 48	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 4
    //   34: aload_0
    //   35: aload 7
    //   37: iconst_m1
    //   38: iload_2
    //   39: iload 4
    //   41: aload_3
    //   42: invokestatic 596	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 278 1 0
    //   55: aload 7
    //   57: areturn
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -27 -> 34
    //   64: astore_1
    //   65: aload 6
    //   67: astore_0
    //   68: aload_0
    //   69: astore 5
    //   71: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +17 -> 91
    //   77: aload_0
    //   78: astore 5
    //   80: ldc 17
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 409	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: aload_1
    //   88: invokestatic 411	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_0
    //   92: ifnull -37 -> 55
    //   95: aload_0
    //   96: invokeinterface 278 1 0
    //   101: aload 7
    //   103: areturn
    //   104: astore_1
    //   105: aload 5
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +9 -> 118
    //   112: aload_0
    //   113: invokeinterface 278 1 0
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -13 -> 108
    //   124: astore_1
    //   125: goto -57 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString	String
    //   0	128	2	paramInt	int
    //   0	128	3	paramMediaFileFilter	MediaFileFilter
    //   32	28	4	bool	boolean
    //   1	105	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	89	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	104	finally
    //   71	77	104	finally
    //   80	91	104	finally
    //   23	31	120	finally
    //   34	45	120	finally
    //   23	31	124	java/lang/Exception
    //   34	45	124	java/lang/Exception
  }
  
  /* Error */
  private static void queryOnHighVer(Cursor paramCursor, int paramInt1, int paramInt2, String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload 4
    //   2: aload_0
    //   3: iload_1
    //   4: invokeinterface 94 2 0
    //   9: putfield 123	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   12: aload 4
    //   14: aload_0
    //   15: iload_2
    //   16: invokeinterface 94 2 0
    //   21: putfield 126	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   24: aload 4
    //   26: getfield 459	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   29: lconst_0
    //   30: lcmp
    //   31: ifne +49 -> 80
    //   34: new 601	android/media/MediaMetadataRetriever
    //   37: dup
    //   38: invokespecial 602	android/media/MediaMetadataRetriever:<init>	()V
    //   41: astore 5
    //   43: aload 5
    //   45: astore_0
    //   46: aload 5
    //   48: aload_3
    //   49: invokevirtual 605	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   52: aload 5
    //   54: astore_0
    //   55: aload 4
    //   57: aload 5
    //   59: bipush 9
    //   61: invokevirtual 608	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   64: invokestatic 614	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   67: putfield 459	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   70: aload 5
    //   72: ifnull +8 -> 80
    //   75: aload 5
    //   77: invokevirtual 617	android/media/MediaMetadataRetriever:release	()V
    //   80: return
    //   81: astore 4
    //   83: aconst_null
    //   84: astore_3
    //   85: aload_3
    //   86: astore_0
    //   87: aload 4
    //   89: invokevirtual 620	java/lang/Exception:printStackTrace	()V
    //   92: aload_3
    //   93: astore_0
    //   94: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +14 -> 111
    //   100: aload_3
    //   101: astore_0
    //   102: ldc 17
    //   104: iconst_2
    //   105: ldc_w 622
    //   108: invokestatic 194	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_3
    //   112: ifnull -32 -> 80
    //   115: aload_3
    //   116: invokevirtual 617	android/media/MediaMetadataRetriever:release	()V
    //   119: return
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 617	android/media/MediaMetadataRetriever:release	()V
    //   131: aload_3
    //   132: athrow
    //   133: astore_3
    //   134: goto -11 -> 123
    //   137: astore 4
    //   139: aload 5
    //   141: astore_3
    //   142: goto -57 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramCursor	Cursor
    //   0	145	1	paramInt1	int
    //   0	145	2	paramInt2	int
    //   0	145	3	paramString	String
    //   0	145	4	paramLocalMediaInfo	LocalMediaInfo
    //   41	99	5	localMediaMetadataRetriever	MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   34	43	81	java/lang/Exception
    //   34	43	120	finally
    //   46	52	133	finally
    //   55	70	133	finally
    //   87	92	133	finally
    //   94	100	133	finally
    //   102	111	133	finally
    //   46	52	137	java/lang/Exception
    //   55	70	137	java/lang/Exception
  }
  
  private static void queryOnLowVer(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(18);
    String str = localMediaMetadataRetriever.extractMetadata(19);
    localMediaMetadataRetriever.release();
    try
    {
      paramLocalMediaInfo.mediaWidth = Integer.parseInt(paramString);
      paramLocalMediaInfo.mediaHeight = Integer.parseInt(str);
      return;
    }
    catch (NumberFormatException paramString)
    {
      do
      {
        paramLocalMediaInfo.mediaWidth = 0;
        paramLocalMediaInfo.mediaHeight = 0;
      } while (!QLog.isColorLevel());
      QLog.i("QAlbumUtil", 2, "Video size is not number format...");
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentImages(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, boolean paramBoolean1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 635	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 8
    //   5: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 17
    //   13: iconst_2
    //   14: new 179	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 637
    //   24: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 8
    //   29: invokevirtual 640	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 10
    //   41: aconst_null
    //   42: astore 12
    //   44: new 342	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 343	java/util/ArrayList:<init>	()V
    //   51: astore 13
    //   53: iload 4
    //   55: ifeq +134 -> 189
    //   58: ldc_w 642
    //   61: astore 11
    //   63: aload_0
    //   64: aload 11
    //   66: iconst_3
    //   67: anewarray 50	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: iload 5
    //   74: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: iload_1
    //   81: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: iload_1
    //   88: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   91: aastore
    //   92: iload_2
    //   93: invokestatic 402	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   96: astore_0
    //   97: aload_0
    //   98: aload 13
    //   100: iload_1
    //   101: iload_2
    //   102: iconst_1
    //   103: aload_3
    //   104: aload 6
    //   106: iload 7
    //   108: invokestatic 352	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   111: aload_0
    //   112: ifnull +9 -> 121
    //   115: aload_0
    //   116: invokeinterface 278 1 0
    //   121: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +62 -> 186
    //   127: new 179	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 644
    //   137: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokestatic 635	android/os/SystemClock:uptimeMillis	()J
    //   143: lload 8
    //   145: lsub
    //   146: invokevirtual 640	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc_w 646
    //   152: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: astore_3
    //   156: aload 13
    //   158: ifnull +95 -> 253
    //   161: aload 13
    //   163: invokeinterface 154 1 0
    //   168: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: astore_0
    //   172: ldc 17
    //   174: iconst_2
    //   175: aload_3
    //   176: aload_0
    //   177: invokevirtual 533	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload 13
    //   188: areturn
    //   189: ldc_w 648
    //   192: astore 11
    //   194: goto -131 -> 63
    //   197: astore_3
    //   198: aload 12
    //   200: astore_0
    //   201: aload_0
    //   202: astore 10
    //   204: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +17 -> 224
    //   210: aload_0
    //   211: astore 10
    //   213: ldc 17
    //   215: iconst_2
    //   216: aload_3
    //   217: invokevirtual 409	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: aload_3
    //   221: invokestatic 411	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_0
    //   225: ifnull -104 -> 121
    //   228: aload_0
    //   229: invokeinterface 278 1 0
    //   234: goto -113 -> 121
    //   237: astore_3
    //   238: aload 10
    //   240: astore_0
    //   241: aload_0
    //   242: ifnull +9 -> 251
    //   245: aload_0
    //   246: invokeinterface 278 1 0
    //   251: aload_3
    //   252: athrow
    //   253: ldc_w 540
    //   256: astore_0
    //   257: goto -85 -> 172
    //   260: astore_3
    //   261: goto -20 -> 241
    //   264: astore_3
    //   265: goto -64 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramContext	Context
    //   0	268	1	paramInt1	int
    //   0	268	2	paramInt2	int
    //   0	268	3	paramMediaFileFilter	MediaFileFilter
    //   0	268	4	paramBoolean1	boolean
    //   0	268	5	paramInt3	int
    //   0	268	6	paramArrayList	ArrayList<String>
    //   0	268	7	paramBoolean2	boolean
    //   3	141	8	l	long
    //   39	200	10	localContext	Context
    //   61	132	11	str	String
    //   42	157	12	localObject	Object
    //   51	136	13	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   63	97	197	java/lang/Exception
    //   63	97	237	finally
    //   204	210	237	finally
    //   213	224	237	finally
    //   97	111	260	finally
    //   97	111	264	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentVideos(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 635	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 17
    //   13: iconst_2
    //   14: new 179	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 651
    //   24: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 6
    //   29: invokevirtual 640	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: new 342	java/util/ArrayList
    //   41: dup
    //   42: invokespecial 343	java/util/ArrayList:<init>	()V
    //   45: astore 11
    //   47: aconst_null
    //   48: astore 9
    //   50: getstatic 265	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 582	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 10
    //   58: iload_2
    //   59: ifle +19 -> 78
    //   62: aload 10
    //   64: ldc_w 584
    //   67: iload_2
    //   68: bipush 6
    //   70: imul
    //   71: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: invokevirtual 590	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   77: pop
    //   78: aload 10
    //   80: invokevirtual 594	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   83: astore 10
    //   85: aload_0
    //   86: invokevirtual 259	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   89: aload 10
    //   91: getstatic 70	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   94: ldc_w 653
    //   97: aconst_null
    //   98: ldc 11
    //   100: invokevirtual 271	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_0
    //   104: aload_0
    //   105: astore 9
    //   107: aload 9
    //   109: astore_0
    //   110: getstatic 48	android/os/Build$VERSION:SDK_INT	I
    //   113: bipush 16
    //   115: if_icmplt +50 -> 165
    //   118: iconst_1
    //   119: istore 8
    //   121: aload 9
    //   123: astore_0
    //   124: aload 9
    //   126: aload 11
    //   128: iload_2
    //   129: aload_3
    //   130: iload 8
    //   132: lload 4
    //   134: invokestatic 347	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   137: pop
    //   138: aload 9
    //   140: ifnull +10 -> 150
    //   143: aload 9
    //   145: invokeinterface 278 1 0
    //   150: aload_3
    //   151: aload 11
    //   153: invokestatic 657	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryThirdPartyVideo	(Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/List;)V
    //   156: iload_2
    //   157: lload 6
    //   159: aload 11
    //   161: invokestatic 661	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sortAndLimitVideoList	(IJLjava/util/List;)Ljava/util/List;
    //   164: areturn
    //   165: iconst_0
    //   166: istore 8
    //   168: goto -47 -> 121
    //   171: astore 10
    //   173: aconst_null
    //   174: astore 9
    //   176: aload 9
    //   178: astore_0
    //   179: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +19 -> 201
    //   185: aload 9
    //   187: astore_0
    //   188: ldc 17
    //   190: iconst_2
    //   191: aload 10
    //   193: invokevirtual 409	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: aload 10
    //   198: invokestatic 411	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload 9
    //   203: ifnull -53 -> 150
    //   206: aload 9
    //   208: invokeinterface 278 1 0
    //   213: goto -63 -> 150
    //   216: astore_0
    //   217: aload 9
    //   219: astore_3
    //   220: aload_3
    //   221: ifnull +9 -> 230
    //   224: aload_3
    //   225: invokeinterface 278 1 0
    //   230: aload_0
    //   231: athrow
    //   232: astore 9
    //   234: aload_0
    //   235: astore_3
    //   236: aload 9
    //   238: astore_0
    //   239: goto -19 -> 220
    //   242: astore 10
    //   244: goto -68 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramContext	Context
    //   0	247	1	paramInt1	int
    //   0	247	2	paramInt2	int
    //   0	247	3	paramMediaFileFilter	MediaFileFilter
    //   0	247	4	paramLong	long
    //   3	155	6	l	long
    //   119	48	8	bool	boolean
    //   48	170	9	localContext	Context
    //   232	5	9	localObject1	Object
    //   56	34	10	localObject2	Object
    //   171	26	10	localException1	java.lang.Exception
    //   242	1	10	localException2	java.lang.Exception
    //   45	115	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	58	171	java/lang/Exception
    //   62	78	171	java/lang/Exception
    //   78	104	171	java/lang/Exception
    //   50	58	216	finally
    //   62	78	216	finally
    //   78	104	216	finally
    //   110	118	232	finally
    //   124	138	232	finally
    //   179	185	232	finally
    //   188	201	232	finally
    //   110	118	242	java/lang/Exception
    //   124	138	242	java/lang/Exception
  }
  
  private static void queryThirdPartyVideo(MediaFileFilter paramMediaFileFilter, List<LocalMediaInfo> paramList)
  {
    Object localObject = MediaScanner.getInstance(BaseApplication.getContext());
    if (localObject != null)
    {
      localObject = ((MediaScanner)localObject).getMediaScannerInfos(true, 100);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MediaScannerInfo localMediaScannerInfo = (MediaScannerInfo)((Iterator)localObject).next();
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          localLocalMediaInfo._id = localMediaScannerInfo.id;
          localLocalMediaInfo.mDuration = localMediaScannerInfo.duration;
          localLocalMediaInfo.fileSize = localMediaScannerInfo.fileSize;
          localLocalMediaInfo.path = localMediaScannerInfo.path;
          localLocalMediaInfo.modifiedDate = localMediaScannerInfo.modifiedDate;
          localLocalMediaInfo.mMimeType = localMediaScannerInfo.mimeType;
          localLocalMediaInfo.isSystemMeidaStore = false;
          if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.filter(localMediaScannerInfo.mimeType))) {
            paramList.add(localLocalMediaInfo);
          }
        }
      }
    }
  }
  
  private static void qureyVideoList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    int i = 0;
    Object localObject1 = null;
    int j;
    do
    {
      do
      {
        Object localObject2;
        long l2;
        do
        {
          String str;
          Object localObject3;
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label361;
            }
            str = paramCursor.getString(paramInt3);
            if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("getVideoList file not exists:");
                if (str != null) {}
                for (localObject2 = str;; localObject2 = "null")
                {
                  QLog.i("QAlbumUtil", 2, (String)localObject2);
                  break;
                }
              }
            }
            else
            {
              localObject3 = paramCursor.getString(paramInt7);
              if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.filter((String)localObject3))) {
                break;
              }
              if (QLog.isColorLevel())
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new StringBuilder();
                }
                ((StringBuilder)localObject2).append("Filter mime type:").append((String)localObject3).append(", path is ").append(str).append("\n");
                localObject1 = localObject2;
              }
            }
          }
          long l1 = paramCursor.getLong(paramInt4);
          l2 = paramCursor.getLong(paramInt5);
          localObject2 = new LocalMediaInfo();
          ((LocalMediaInfo)localObject2)._id = paramCursor.getLong(paramInt2);
          ((LocalMediaInfo)localObject2).path = str;
          ((LocalMediaInfo)localObject2).mMimeType = ((String)localObject3);
          ((LocalMediaInfo)localObject2).addedDate = l1;
          ((LocalMediaInfo)localObject2).modifiedDate = l2;
          ((LocalMediaInfo)localObject2).mDuration = paramCursor.getLong(paramInt6);
          ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(paramInt8);
          queryOnHighVer(paramCursor, paramInt9, paramInt10, str, (LocalMediaInfo)localObject2);
        } while ((paramLong > 0L) && (((LocalMediaInfo)localObject2).mDuration > paramLong));
        paramList.add(localObject2);
        j = i + 1;
        if (sLastModify < l2) {
          sLastModify = l2;
        }
        i = j;
      } while (paramInt1 <= 0);
      i = j;
    } while (j < paramInt1);
    label361:
    if ((localObject1 != null) && (QLog.isColorLevel())) {
      QLog.d("QAlbumUtil", 2, localObject1.toString());
    }
  }
  
  private static void reportFail(int paramInt1, int paramInt2)
  {
    if (!sAlbumQueryFailReport)
    {
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        Object localObject = new StringBuffer();
        ((StringBuffer)localObject).append("imagePathNullCount:");
        ((StringBuffer)localObject).append(paramInt1);
        ((StringBuffer)localObject).append(" imagePathFileNotExistCount:");
        ((StringBuffer)localObject).append(paramInt2);
        localObject = ((StringBuffer)localObject).toString();
        if (paramInt1 > 0) {
          RichMediaBugReport.a("Album_Query_File_Path_Null", (String)localObject);
        }
        if (paramInt2 > 0) {
          RichMediaBugReport.a("Album_Query_File_Not_Exist", (String)localObject);
        }
      }
      sAlbumQueryFailReport = true;
    }
  }
  
  private static List<LocalMediaInfo> sortAndLimitVideoList(int paramInt, long paramLong, List<LocalMediaInfo> paramList)
  {
    Collections.sort(paramList);
    ArrayList localArrayList = new ArrayList();
    if (paramInt > 0) {}
    for (paramInt = Math.min(paramInt, paramList.size());; paramInt = paramList.size())
    {
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(paramList.get(i));
        i += 1;
      }
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("queryRecentVideos cost: ").append(SystemClock.uptimeMillis() - paramLong).append(" resultVideoList size:");
      if (localArrayList == null) {
        break label141;
      }
    }
    label141:
    for (paramList = Integer.valueOf(localArrayList.size());; paramList = "null")
    {
      QLog.d("QAlbumUtil", 2, paramList);
      return localArrayList;
    }
  }
  
  private static void sortMedias(String paramString, List<LocalMediaInfo> paramList1, List<LocalMediaInfo> paramList2)
  {
    if ("$RecentAlbumId".equals(paramString))
    {
      long l = SystemClock.uptimeMillis();
      if (paramList1 != null) {
        Collections.sort(paramList1);
      }
      if (paramList2 != null) {
        Collections.sort(paramList2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QAlbumUtil", 2, "getAlbumMedias-sort recent cost: " + (SystemClock.uptimeMillis() - l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil
 * JD-Core Version:    0.7.0.1
 */