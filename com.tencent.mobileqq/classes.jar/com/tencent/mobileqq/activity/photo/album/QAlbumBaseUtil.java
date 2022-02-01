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
  public static int CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 10485760;
  protected static final String IMAGE_ORDER_BY = "date_modified DESC, date_added DESC";
  private static final int MAX_PHOTO_HEIGHT_OF_CACHE = 65535;
  private static final int MAX_PHOTO_WIDTH_OF_CACHE = 65535;
  protected static final String TAG = "QQAlbum";
  public static final int TYPE_SLIDESHOW = 1;
  private static String[] VIDEO_COLUMNS;
  protected static String[] columns = { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size" };
  private static Map<String, Integer> pathWHMap = new HashMap();
  public static boolean sAlbumQueryFailReport = false;
  private static long sLastModify;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" };
    } else {
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
    }
    if (Build.VERSION.SDK_INT >= 16)
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
    int i;
    if (paramCursor.getInt(paramInt9) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    long l3 = paramCursor.getLong(paramInt2);
    if ((paramInt1 > 0) && (i != 0))
    {
      getWHByPath(paramString1, paramOptions, paramArrayOfInt);
      if ((paramArrayOfInt[0] < paramInt1) && (paramArrayOfInt[1] < paramInt1)) {
        return paramInt11;
      }
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
    }
    else
    {
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
    }
    return paramInt11 + 1;
  }
  
  private static void addVideoToMediaList(int paramInt, List<LocalMediaInfo> paramList1, List<LocalMediaInfo> paramList2)
  {
    int j = paramList1.size();
    int i2 = 0;
    int i = 0;
    int n;
    for (int k = 0; i < paramList2.size(); k = n)
    {
      LocalMediaInfo localLocalMediaInfo1 = (LocalMediaInfo)paramList2.get(i);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)paramList1.get(j - 1);
      if (localLocalMediaInfo1.modifiedDate <= localLocalMediaInfo2.modifiedDate)
      {
        if (paramInt == -1) {
          while (i < paramList2.size())
          {
            paramList1.add(paramList2.get(i));
            i += 1;
          }
        }
        j = Math.min(paramList2.size() - i, paramInt - j);
        paramInt = i2;
        while (paramInt < j)
        {
          paramList1.add(paramList2.get(paramInt + i));
          paramInt += 1;
        }
      }
      int m = k;
      for (;;)
      {
        i1 = j;
        n = k;
        if (m >= j) {
          break label274;
        }
        localLocalMediaInfo2 = (LocalMediaInfo)paramList1.get(m);
        if (localLocalMediaInfo1.modifiedDate > localLocalMediaInfo2.modifiedDate) {
          break;
        }
        m += 1;
      }
      paramList1.add(m, localLocalMediaInfo1);
      if ((paramInt != -1) && (paramList1.size() > paramInt)) {
        paramList1.remove(j);
      }
      n = paramList1.size();
      k = j;
      if (j != n) {
        k = n;
      }
      n = m + 1;
      int i1 = k;
      label274:
      i += 1;
      j = i1;
    }
  }
  
  private static void checkWidthAndHeight(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if (((paramLocalMediaInfo.mediaWidth <= 0) || (paramLocalMediaInfo.mediaHeight <= 0)) && (QLog.isColorLevel()))
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("no size ");
      paramLocalMediaInfo.append(paramString);
      QLog.i("QQAlbum", 2, paramLocalMediaInfo.toString());
    }
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  public static String fixMimeType(String paramString1, String paramString2)
  {
    if ((paramString1.indexOf(".jpg") == -1) && (paramString1.indexOf(".jpeg") == -1))
    {
      if (paramString1.indexOf(".gif") != -1) {
        return "image/gif";
      }
      if (paramString1.indexOf(".bmp") != -1) {
        return "image/bmp";
      }
      if (paramString1.indexOf(".png") != -1) {
        return "image/png";
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Filter mime type:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", path is ");
        localStringBuilder.append(paramString1);
        QLog.i("QQAlbum", 2, localStringBuilder.toString());
      }
      return null;
    }
    return "image/jpeg";
  }
  
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong)
  {
    return getAlbumMedias(paramContext, paramString1, paramString2, paramInt1, paramMediaFileFilter, paramInt2, paramInt3, paramBoolean1, paramArrayList, paramBoolean2, paramLong, -1);
  }
  
  /* Error */
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 17
    //   8: iconst_2
    //   9: ldc 241
    //   11: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: ldc 246
    //   16: aload_1
    //   17: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: istore 13
    //   22: aconst_null
    //   23: astore 17
    //   25: aconst_null
    //   26: astore 14
    //   28: iload 13
    //   30: ifeq +129 -> 159
    //   33: aload_0
    //   34: invokevirtual 255	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   37: getstatic 261	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   40: getstatic 66	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: ldc 11
    //   47: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 15
    //   52: aload 15
    //   54: astore 14
    //   56: aload_0
    //   57: aload 15
    //   59: aconst_null
    //   60: iload_3
    //   61: aload 4
    //   63: iconst_1
    //   64: lload 10
    //   66: invokestatic 271	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSystemAndAppVideoList	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/ArrayList;
    //   69: astore 16
    //   71: aload 15
    //   73: ifnull +10 -> 83
    //   76: aload 15
    //   78: invokeinterface 274 1 0
    //   83: aload 16
    //   85: areturn
    //   86: astore 16
    //   88: goto +15 -> 103
    //   91: astore_0
    //   92: aload 14
    //   94: astore_1
    //   95: goto +52 -> 147
    //   98: astore 16
    //   100: aconst_null
    //   101: astore 15
    //   103: aload 15
    //   105: astore 14
    //   107: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +18 -> 128
    //   113: aload 15
    //   115: astore 14
    //   117: ldc 17
    //   119: iconst_2
    //   120: ldc_w 276
    //   123: aload 16
    //   125: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload 15
    //   130: ifnull +29 -> 159
    //   133: aload 15
    //   135: invokeinterface 274 1 0
    //   140: goto +19 -> 159
    //   143: astore_0
    //   144: aload 14
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 274 1 0
    //   157: aload_0
    //   158: athrow
    //   159: aload 4
    //   161: ifnull +65 -> 226
    //   164: aload 4
    //   166: invokevirtual 285	com/tencent/mobileqq/activity/photo/MediaFileFilter:showImage	()Z
    //   169: ifeq +57 -> 226
    //   172: iload 12
    //   174: iconst_1
    //   175: if_icmpne +27 -> 202
    //   178: aload_0
    //   179: aload_1
    //   180: aload_2
    //   181: iload_3
    //   182: aload 4
    //   184: iload 5
    //   186: iload 6
    //   188: iload 7
    //   190: aload 8
    //   192: iload 9
    //   194: invokestatic 289	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSlideShowAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   197: astore 8
    //   199: goto +30 -> 229
    //   202: aload_0
    //   203: aload_1
    //   204: aload_2
    //   205: iload_3
    //   206: aload 4
    //   208: iload 5
    //   210: iload 6
    //   212: iload 7
    //   214: aload 8
    //   216: iload 9
    //   218: invokestatic 292	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   221: astore 8
    //   223: goto +6 -> 229
    //   226: aconst_null
    //   227: astore 8
    //   229: aload 17
    //   231: astore 14
    //   233: aload 4
    //   235: ifnull +28 -> 263
    //   238: aload 17
    //   240: astore 14
    //   242: aload 4
    //   244: invokevirtual 295	com/tencent/mobileqq/activity/photo/MediaFileFilter:showVideo	()Z
    //   247: ifeq +16 -> 263
    //   250: aload_0
    //   251: aload_1
    //   252: aload_2
    //   253: iload_3
    //   254: aload 4
    //   256: lload 10
    //   258: invokestatic 299	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumVideos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   261: astore 14
    //   263: aload_1
    //   264: aload 8
    //   266: aload 14
    //   268: invokestatic 303	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sortMedias	(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   271: iload_3
    //   272: aload 8
    //   274: aload 14
    //   276: invokestatic 307	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:limitPhotosAndVideos	(ILjava/util/List;Ljava/util/List;)Ljava/util/List;
    //   279: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramContext	Context
    //   0	280	1	paramString1	String
    //   0	280	2	paramString2	String
    //   0	280	3	paramInt1	int
    //   0	280	4	paramMediaFileFilter	MediaFileFilter
    //   0	280	5	paramInt2	int
    //   0	280	6	paramInt3	int
    //   0	280	7	paramBoolean1	boolean
    //   0	280	8	paramArrayList	ArrayList<String>
    //   0	280	9	paramBoolean2	boolean
    //   0	280	10	paramLong	long
    //   0	280	12	paramInt4	int
    //   20	9	13	bool	boolean
    //   26	249	14	localObject1	Object
    //   50	84	15	localCursor	Cursor
    //   69	15	16	localArrayList	ArrayList
    //   86	1	16	localException1	java.lang.Exception
    //   98	26	16	localException2	java.lang.Exception
    //   23	216	17	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	71	86	java/lang/Exception
    //   33	52	91	finally
    //   33	52	98	java/lang/Exception
    //   56	71	143	finally
    //   107	113	143	finally
    //   117	128	143	finally
  }
  
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    return getAlbumMedias(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter, 0, -1, false, null, false, paramLong);
  }
  
  public static List<LocalMediaInfo> getAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "getAlbumPhotos");
    }
    if ((paramString2 != null) && (!"$RecentAlbumId".equals(paramString1)))
    {
      paramString2 = new StringBuilder();
      paramString2.append("bucket_id='");
      paramString2.append(paramString1);
      paramString2.append("'");
      paramContext = queryImages(paramContext, paramString2.toString(), paramInt1, paramMediaFileFilter);
      if ((paramContext != null) && (QLog.isColorLevel()))
      {
        paramString1 = new StringBuilder();
        paramString1.append("photo list size is:");
        paramString1.append(paramContext.size());
        QLog.d("QQAlbum", 2, paramString1.toString());
      }
      return paramContext;
    }
    return queryRecentImages(paramContext, paramInt3, paramInt1, paramMediaFileFilter, paramBoolean1, paramInt2, paramArrayList, paramBoolean2);
  }
  
  /* Error */
  public static List<LocalMediaInfo> getAlbumVideos(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +195 -> 196
    //   4: ldc_w 314
    //   7: aload_1
    //   8: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +6 -> 17
    //   14: goto +182 -> 196
    //   17: new 334	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 335	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: new 175	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 316
    //   38: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: aload_1
    //   44: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 318
    //   52: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 9
    //   62: aconst_null
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_0
    //   67: invokevirtual 255	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   70: getstatic 261	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   73: getstatic 66	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   76: aload 9
    //   78: aconst_null
    //   79: ldc 11
    //   81: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_0
    //   85: getstatic 44	android/os/Build$VERSION:SDK_INT	I
    //   88: bipush 16
    //   90: if_icmplt +121 -> 211
    //   93: iconst_1
    //   94: istore 7
    //   96: goto +3 -> 99
    //   99: aload_0
    //   100: aload 8
    //   102: iload_3
    //   103: aload 4
    //   105: iload 7
    //   107: lload 5
    //   109: invokestatic 339	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   112: pop
    //   113: aload 8
    //   115: astore_1
    //   116: aload_0
    //   117: ifnull +92 -> 209
    //   120: aload_0
    //   121: invokeinterface 274 1 0
    //   126: aload 8
    //   128: areturn
    //   129: astore_2
    //   130: goto +54 -> 184
    //   133: astore_2
    //   134: goto +14 -> 148
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: goto +44 -> 184
    //   143: astore_1
    //   144: aload_2
    //   145: astore_0
    //   146: aload_1
    //   147: astore_2
    //   148: aload_0
    //   149: astore_1
    //   150: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +15 -> 168
    //   156: aload_0
    //   157: astore_1
    //   158: ldc 17
    //   160: iconst_2
    //   161: ldc_w 276
    //   164: aload_2
    //   165: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload 8
    //   170: astore_1
    //   171: aload_0
    //   172: ifnull +37 -> 209
    //   175: aload_0
    //   176: invokeinterface 274 1 0
    //   181: aload 8
    //   183: areturn
    //   184: aload_0
    //   185: ifnull +9 -> 194
    //   188: aload_0
    //   189: invokeinterface 274 1 0
    //   194: aload_2
    //   195: athrow
    //   196: aload_0
    //   197: sipush 210
    //   200: iload_3
    //   201: aload 4
    //   203: lload 5
    //   205: invokestatic 343	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryRecentVideos	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   208: astore_1
    //   209: aload_1
    //   210: areturn
    //   211: iconst_0
    //   212: istore 7
    //   214: goto -115 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	Context
    //   0	217	1	paramString1	String
    //   0	217	2	paramString2	String
    //   0	217	3	paramInt	int
    //   0	217	4	paramMediaFileFilter	MediaFileFilter
    //   0	217	5	paramLong	long
    //   94	119	7	bool	boolean
    //   24	158	8	localArrayList	ArrayList
    //   60	17	9	str	String
    // Exception table:
    //   from	to	target	type
    //   85	93	129	finally
    //   99	113	129	finally
    //   85	93	133	java/lang/Exception
    //   99	113	133	java/lang/Exception
    //   66	85	137	finally
    //   150	156	137	finally
    //   158	168	137	finally
    //   66	85	143	java/lang/Exception
  }
  
  private static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    getImageList(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramMediaFileFilter, null, false);
  }
  
  protected static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean1, MediaFileFilter paramMediaFileFilter, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    if (paramCursor.getCount() > 0)
    {
      if (paramList == null) {
        paramList = new ArrayList();
      }
      int k = paramCursor.getColumnIndexOrThrow("_id");
      int m = paramCursor.getColumnIndexOrThrow("_data");
      int n = paramCursor.getColumnIndexOrThrow("orientation");
      int i1 = paramCursor.getColumnIndexOrThrow("date_added");
      int i2 = paramCursor.getColumnIndexOrThrow("date_modified");
      int i3 = paramCursor.getColumnIndexOrThrow("mime_type");
      int i4 = paramCursor.getColumnIndexOrThrow("_size");
      int i5 = paramCursor.getColumnIndexOrThrow("latitude");
      int i6 = paramCursor.getColumnIndexOrThrow("longitude");
      int i;
      int j;
      if (paramBoolean1)
      {
        i = paramCursor.getColumnIndexOrThrow("width");
        j = paramCursor.getColumnIndexOrThrow("height");
      }
      else
      {
        i = 0;
        j = 0;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getImageList imageCursor count:");
        localStringBuilder.append(paramCursor.getCount());
        QLog.i("QQAlbum", 2, localStringBuilder.toString());
      }
      queryImageList(paramCursor, paramList, paramInt1, paramInt2, paramBoolean1, paramMediaFileFilter, paramArrayList, k, m, n, i1, i2, i3, i4, i5, i6, i, j, localOptions, arrayOfInt, 0);
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> getSlideShowAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 334	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 335	java/util/ArrayList:<init>	()V
    //   7: astore 12
    //   9: new 175	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   16: astore 13
    //   18: aload_2
    //   19: ifnull +22 -> 41
    //   22: ldc_w 314
    //   25: aload_1
    //   26: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +6 -> 35
    //   32: goto +9 -> 41
    //   35: iconst_0
    //   36: istore 10
    //   38: goto +6 -> 44
    //   41: iconst_1
    //   42: istore 10
    //   44: iload 10
    //   46: ifeq +21 -> 67
    //   49: iload_3
    //   50: ifle +6 -> 56
    //   53: goto +63 -> 116
    //   56: new 370	java/lang/IllegalArgumentException
    //   59: dup
    //   60: ldc_w 372
    //   63: invokespecial 373	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   66: athrow
    //   67: new 175	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   74: astore_2
    //   75: aload_2
    //   76: ldc_w 316
    //   79: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_2
    //   84: aload_1
    //   85: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: ldc_w 318
    //   93: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 13
    //   99: aload_2
    //   100: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 13
    //   109: ldc_w 375
    //   112: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aconst_null
    //   117: astore_2
    //   118: aconst_null
    //   119: astore 11
    //   121: iload 7
    //   123: ifeq +252 -> 375
    //   126: aload 11
    //   128: astore_1
    //   129: new 175	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   136: astore 14
    //   138: aload 11
    //   140: astore_1
    //   141: aload 14
    //   143: ldc_w 377
    //   146: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 11
    //   152: astore_1
    //   153: aload 14
    //   155: getstatic 379	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   158: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 11
    //   164: astore_1
    //   165: aload 14
    //   167: ldc_w 381
    //   170: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 11
    //   176: astore_1
    //   177: aload 14
    //   179: ldc 62
    //   181: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 11
    //   187: astore_1
    //   188: aload 14
    //   190: ldc_w 383
    //   193: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 11
    //   199: astore_1
    //   200: aload 14
    //   202: ldc 62
    //   204: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 11
    //   210: astore_1
    //   211: aload 14
    //   213: ldc_w 385
    //   216: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 11
    //   222: astore_1
    //   223: aload 14
    //   225: ldc 64
    //   227: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 11
    //   233: astore_1
    //   234: aload 14
    //   236: ldc_w 383
    //   239: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 11
    //   245: astore_1
    //   246: aload 14
    //   248: ldc 64
    //   250: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 11
    //   256: astore_1
    //   257: aload 14
    //   259: ldc_w 387
    //   262: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 11
    //   268: astore_1
    //   269: aload 14
    //   271: ldc 64
    //   273: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 11
    //   279: astore_1
    //   280: aload 14
    //   282: ldc_w 389
    //   285: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 11
    //   291: astore_1
    //   292: aload 14
    //   294: ldc 62
    //   296: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 11
    //   302: astore_1
    //   303: aload 14
    //   305: ldc_w 391
    //   308: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 11
    //   314: astore_1
    //   315: aload 14
    //   317: ldc 64
    //   319: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 11
    //   325: astore_1
    //   326: aload 14
    //   328: ldc_w 389
    //   331: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 11
    //   337: astore_1
    //   338: aload 14
    //   340: ldc 62
    //   342: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 11
    //   348: astore_1
    //   349: aload 14
    //   351: ldc_w 393
    //   354: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 11
    //   360: astore_1
    //   361: aload 13
    //   363: aload 14
    //   365: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: goto +157 -> 529
    //   375: aload 11
    //   377: astore_1
    //   378: new 175	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   385: astore 14
    //   387: aload 11
    //   389: astore_1
    //   390: aload 14
    //   392: ldc_w 377
    //   395: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 11
    //   401: astore_1
    //   402: aload 14
    //   404: getstatic 379	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   407: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 11
    //   413: astore_1
    //   414: aload 14
    //   416: ldc_w 381
    //   419: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 11
    //   425: astore_1
    //   426: aload 14
    //   428: ldc 62
    //   430: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 11
    //   436: astore_1
    //   437: aload 14
    //   439: ldc_w 383
    //   442: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 11
    //   448: astore_1
    //   449: aload 14
    //   451: ldc 62
    //   453: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 11
    //   459: astore_1
    //   460: aload 14
    //   462: ldc_w 395
    //   465: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 11
    //   471: astore_1
    //   472: aload 14
    //   474: ldc 64
    //   476: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 11
    //   482: astore_1
    //   483: aload 14
    //   485: ldc_w 383
    //   488: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 11
    //   494: astore_1
    //   495: aload 14
    //   497: ldc 64
    //   499: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 11
    //   505: astore_1
    //   506: aload 14
    //   508: ldc_w 397
    //   511: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 11
    //   517: astore_1
    //   518: aload 13
    //   520: aload 14
    //   522: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 11
    //   531: astore_1
    //   532: aload_0
    //   533: aload 13
    //   535: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: iconst_3
    //   539: anewarray 46	java/lang/String
    //   542: dup
    //   543: iconst_0
    //   544: iload 5
    //   546: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: iload 6
    //   554: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   557: aastore
    //   558: dup
    //   559: iconst_2
    //   560: iload 6
    //   562: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   565: aastore
    //   566: iload_3
    //   567: invokestatic 404	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   570: astore_0
    //   571: aload_0
    //   572: aload 12
    //   574: iload 6
    //   576: iload_3
    //   577: iconst_1
    //   578: aload 4
    //   580: aload 8
    //   582: iload 9
    //   584: invokestatic 348	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   587: aload_0
    //   588: ifnull +64 -> 652
    //   591: aload_0
    //   592: invokeinterface 274 1 0
    //   597: aload 12
    //   599: areturn
    //   600: astore_2
    //   601: aload_0
    //   602: astore_1
    //   603: aload_2
    //   604: astore_0
    //   605: goto +50 -> 655
    //   608: astore_2
    //   609: goto +12 -> 621
    //   612: astore_0
    //   613: goto +42 -> 655
    //   616: astore_1
    //   617: aload_2
    //   618: astore_0
    //   619: aload_1
    //   620: astore_2
    //   621: aload_0
    //   622: astore_1
    //   623: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +16 -> 642
    //   629: aload_0
    //   630: astore_1
    //   631: ldc 17
    //   633: iconst_2
    //   634: aload_2
    //   635: invokevirtual 407	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   638: aload_2
    //   639: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   642: aload_0
    //   643: ifnull +9 -> 652
    //   646: aload_0
    //   647: invokeinterface 274 1 0
    //   652: aload 12
    //   654: areturn
    //   655: aload_1
    //   656: ifnull +9 -> 665
    //   659: aload_1
    //   660: invokeinterface 274 1 0
    //   665: aload_0
    //   666: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	paramContext	Context
    //   0	667	1	paramString1	String
    //   0	667	2	paramString2	String
    //   0	667	3	paramInt1	int
    //   0	667	4	paramMediaFileFilter	MediaFileFilter
    //   0	667	5	paramInt2	int
    //   0	667	6	paramInt3	int
    //   0	667	7	paramBoolean1	boolean
    //   0	667	8	paramArrayList	ArrayList<String>
    //   0	667	9	paramBoolean2	boolean
    //   36	9	10	i	int
    //   119	411	11	localObject	Object
    //   7	646	12	localArrayList	ArrayList
    //   16	518	13	localStringBuilder1	StringBuilder
    //   136	385	14	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   571	587	600	finally
    //   571	587	608	java/lang/Exception
    //   129	138	612	finally
    //   141	150	612	finally
    //   153	162	612	finally
    //   165	174	612	finally
    //   177	185	612	finally
    //   188	197	612	finally
    //   200	208	612	finally
    //   211	220	612	finally
    //   223	231	612	finally
    //   234	243	612	finally
    //   246	254	612	finally
    //   257	266	612	finally
    //   269	277	612	finally
    //   280	289	612	finally
    //   292	300	612	finally
    //   303	312	612	finally
    //   315	323	612	finally
    //   326	335	612	finally
    //   338	346	612	finally
    //   349	358	612	finally
    //   361	372	612	finally
    //   378	387	612	finally
    //   390	399	612	finally
    //   402	411	612	finally
    //   414	423	612	finally
    //   426	434	612	finally
    //   437	446	612	finally
    //   449	457	612	finally
    //   460	469	612	finally
    //   472	480	612	finally
    //   483	492	612	finally
    //   495	503	612	finally
    //   506	515	612	finally
    //   518	529	612	finally
    //   532	571	612	finally
    //   623	629	612	finally
    //   631	642	612	finally
    //   129	138	616	java/lang/Exception
    //   141	150	616	java/lang/Exception
    //   153	162	616	java/lang/Exception
    //   165	174	616	java/lang/Exception
    //   177	185	616	java/lang/Exception
    //   188	197	616	java/lang/Exception
    //   200	208	616	java/lang/Exception
    //   211	220	616	java/lang/Exception
    //   223	231	616	java/lang/Exception
    //   234	243	616	java/lang/Exception
    //   246	254	616	java/lang/Exception
    //   257	266	616	java/lang/Exception
    //   269	277	616	java/lang/Exception
    //   280	289	616	java/lang/Exception
    //   292	300	616	java/lang/Exception
    //   303	312	616	java/lang/Exception
    //   315	323	616	java/lang/Exception
    //   326	335	616	java/lang/Exception
    //   338	346	616	java/lang/Exception
    //   349	358	616	java/lang/Exception
    //   361	372	616	java/lang/Exception
    //   378	387	616	java/lang/Exception
    //   390	399	616	java/lang/Exception
    //   402	411	616	java/lang/Exception
    //   414	423	616	java/lang/Exception
    //   426	434	616	java/lang/Exception
    //   437	446	616	java/lang/Exception
    //   449	457	616	java/lang/Exception
    //   460	469	616	java/lang/Exception
    //   472	480	616	java/lang/Exception
    //   483	492	616	java/lang/Exception
    //   495	503	616	java/lang/Exception
    //   506	515	616	java/lang/Exception
    //   518	529	616	java/lang/Exception
    //   532	571	616	java/lang/Exception
  }
  
  private static ArrayList<LocalMediaInfo> getSystemAndAppVideoList(Context paramContext, Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    paramContext = new ArrayList();
    paramCursor = (ArrayList)getVideoList(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean, paramLong);
    if (paramCursor != null) {
      paramContext.addAll(paramCursor);
    }
    if (QLog.isColorLevel())
    {
      paramCursor = new StringBuilder();
      paramCursor.append("getSystemAndAppVideoList listsize=");
      paramCursor.append(paramContext.size());
      QLog.e("QQAlbum", 2, paramCursor.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoList videoCursor count:");
      localStringBuilder.append(i);
      QLog.i("QQAlbum", 2, localStringBuilder.toString());
    }
    if (i <= 0) {
      return null;
    }
    if (paramList == null) {
      paramList = new ArrayList();
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_added");
    int i1 = paramCursor.getColumnIndexOrThrow("date_modified");
    int i2 = paramCursor.getColumnIndexOrThrow("duration");
    int i3 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i4 = paramCursor.getColumnIndexOrThrow("_size");
    int j;
    if (paramBoolean)
    {
      i = paramCursor.getColumnIndexOrThrow("width");
      j = paramCursor.getColumnIndexOrThrow("height");
    }
    else
    {
      i = 0;
      j = 0;
    }
    qureyVideoList(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean, paramLong, k, m, n, i1, i2, i3, i4, i, j);
    return paramList;
  }
  
  /* Error */
  public static void getWHByPath(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: getstatic 39	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:pathWHMap	Ljava/util/Map;
    //   3: aload_0
    //   4: invokeinterface 492 2 0
    //   9: checkcast 494	java/lang/Integer
    //   12: astore 7
    //   14: aload 7
    //   16: ifnonnull +131 -> 147
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic 500	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   24: pop
    //   25: aload_1
    //   26: getfield 503	android/graphics/BitmapFactory$Options:outWidth	I
    //   29: istore_3
    //   30: aload_1
    //   31: getfield 506	android/graphics/BitmapFactory$Options:outHeight	I
    //   34: istore 6
    //   36: iload_3
    //   37: istore 4
    //   39: iload 6
    //   41: istore 5
    //   43: iload_3
    //   44: ldc 13
    //   46: if_icmpgt +126 -> 172
    //   49: iload_3
    //   50: istore 4
    //   52: iload 6
    //   54: istore 5
    //   56: iload 6
    //   58: ldc 13
    //   60: if_icmpgt +112 -> 172
    //   63: aload_1
    //   64: getfield 503	android/graphics/BitmapFactory$Options:outWidth	I
    //   67: istore 4
    //   69: aload_1
    //   70: getfield 506	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 5
    //   75: getstatic 39	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:pathWHMap	Ljava/util/Map;
    //   78: aload_0
    //   79: iload 5
    //   81: ldc 13
    //   83: iand
    //   84: iload 4
    //   86: bipush 16
    //   88: ishl
    //   89: ldc_w 507
    //   92: iand
    //   93: ior
    //   94: invokestatic 510	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokeinterface 514 3 0
    //   102: pop
    //   103: iload_3
    //   104: istore 4
    //   106: iload 6
    //   108: istore 5
    //   110: goto +62 -> 172
    //   113: astore_0
    //   114: iload 6
    //   116: istore 5
    //   118: goto +13 -> 131
    //   121: astore_0
    //   122: goto +6 -> 128
    //   125: astore_0
    //   126: iconst_0
    //   127: istore_3
    //   128: iconst_0
    //   129: istore 5
    //   131: ldc 17
    //   133: iconst_1
    //   134: ldc_w 516
    //   137: aload_0
    //   138: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: iload_3
    //   142: istore 4
    //   144: goto +28 -> 172
    //   147: aload 7
    //   149: invokevirtual 519	java/lang/Integer:intValue	()I
    //   152: istore_3
    //   153: aload 7
    //   155: invokevirtual 519	java/lang/Integer:intValue	()I
    //   158: ldc 13
    //   160: iand
    //   161: istore 5
    //   163: iload_3
    //   164: bipush 16
    //   166: ishr
    //   167: ldc 13
    //   169: iand
    //   170: istore 4
    //   172: aload_2
    //   173: iconst_0
    //   174: iload 4
    //   176: iastore
    //   177: aload_2
    //   178: iconst_1
    //   179: iload 5
    //   181: iastore
    //   182: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   0	183	1	paramOptions	BitmapFactory.Options
    //   0	183	2	paramArrayOfInt	int[]
    //   29	138	3	i	int
    //   37	138	4	j	int
    //   41	139	5	k	int
    //   34	81	6	m	int
    //   12	142	7	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   63	103	113	java/lang/OutOfMemoryError
    //   30	36	121	java/lang/OutOfMemoryError
    //   19	30	125	java/lang/OutOfMemoryError
  }
  
  private static boolean ignorePath(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (paramString.contains((String)paramArrayList.next()))
        {
          i = 1;
          break label48;
        }
      }
      int i = 0;
      label48:
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  private static List<LocalMediaInfo> limitPhotosAndVideos(int paramInt, List<LocalMediaInfo> paramList1, List<LocalMediaInfo> paramList2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAlbumMedias,mediaList size:");
      String str = "null";
      if (paramList1 != null) {
        localObject = Integer.valueOf(paramList1.size());
      } else {
        localObject = "null";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(" videoList size:");
      Object localObject = str;
      if (paramList2 != null) {
        localObject = Integer.valueOf(paramList2.size());
      }
      localStringBuilder.append(localObject);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    if (paramList2 != null)
    {
      if (paramList2.isEmpty()) {
        return paramList1;
      }
      if (paramList1 != null)
      {
        if (paramList1.isEmpty()) {
          return paramList2;
        }
        addVideoToMediaList(paramInt, paramList1, paramList2);
        return paramList1;
      }
      return paramList2;
    }
    return paramList1;
  }
  
  private static void queryImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter, ArrayList<String> paramArrayList, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, BitmapFactory.Options paramOptions, int[] paramArrayOfInt, int paramInt14)
  {
    int i = 0;
    int k = 0;
    int j = paramInt14;
    paramInt14 = k;
    int m;
    for (;;)
    {
      Object localObject1 = paramCursor;
      Object localObject2 = paramMediaFileFilter;
      k = i;
      m = paramInt14;
      if (!paramCursor.moveToNext()) {
        break;
      }
      String str1 = ((Cursor)localObject1).getString(paramInt4);
      if (!fileExistsAndNotEmpty(str1))
      {
        if (str1 == null)
        {
          k = i + 1;
          m = paramInt14;
        }
        else
        {
          m = paramInt14 + 1;
          k = i;
        }
        i = k;
        paramInt14 = m;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getImageList file not exists:");
          if (str1 != null) {
            localObject1 = str1;
          } else {
            localObject1 = "null";
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("QQAlbum", 2, ((StringBuilder)localObject2).toString());
          i = k;
          paramInt14 = m;
        }
      }
      else if (!ignorePath(paramArrayList, str1))
      {
        String str2 = ((Cursor)localObject1).getString(paramInt8);
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (((MediaFileFilter)localObject2).filter(str2))
          {
            if ((!"*/*".equals(str2)) && (!"image/*".equals(str2)))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Filter unknown ");
              ((StringBuilder)localObject1).append(str2);
              ((StringBuilder)localObject1).append(", path is ");
              ((StringBuilder)localObject1).append(str1);
              QLog.i("QQAlbum", 2, ((StringBuilder)localObject1).toString());
              continue;
            }
            localObject2 = fixMimeType(str1, str2);
            localObject1 = localObject2;
            if (localObject2 == null) {
              continue;
            }
          }
        }
        j = addPhotoInfo(paramCursor, paramList, paramInt1, paramBoolean, paramInt3, paramInt5, paramInt6, paramInt7, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramOptions, paramArrayOfInt, j, str1, (String)localObject1);
        if ((paramInt2 > 0) && (j >= paramInt2))
        {
          k = i;
          m = paramInt14;
          break;
        }
      }
    }
    reportFail(k, m);
  }
  
  private static Cursor queryImages(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    Object localObject;
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
      localObject = ((Uri.Builder)localObject).build();
    }
    else
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }
    return paramContext.getContentResolver().query((Uri)localObject, columns, paramString, paramArrayOfString, "date_modified DESC, date_added DESC");
  }
  
  /* Error */
  private static List<LocalMediaInfo> queryImages(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: new 334	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 335	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 404	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 44	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +104 -> 132
    //   31: iconst_1
    //   32: istore 4
    //   34: goto +3 -> 37
    //   37: aload_0
    //   38: aload 7
    //   40: iconst_m1
    //   41: iload_2
    //   42: iload 4
    //   44: aload_3
    //   45: invokestatic 594	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   48: aload_0
    //   49: ifnull +66 -> 115
    //   52: aload_0
    //   53: invokeinterface 274 1 0
    //   58: aload 7
    //   60: areturn
    //   61: astore_1
    //   62: aload_0
    //   63: astore 5
    //   65: aload_1
    //   66: astore_0
    //   67: goto +51 -> 118
    //   70: astore_1
    //   71: goto +11 -> 82
    //   74: astore_0
    //   75: goto +43 -> 118
    //   78: astore_1
    //   79: aload 6
    //   81: astore_0
    //   82: aload_0
    //   83: astore 5
    //   85: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +17 -> 105
    //   91: aload_0
    //   92: astore 5
    //   94: ldc 17
    //   96: iconst_2
    //   97: aload_1
    //   98: invokevirtual 407	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: aload_1
    //   102: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_0
    //   106: ifnull +9 -> 115
    //   109: aload_0
    //   110: invokeinterface 274 1 0
    //   115: aload 7
    //   117: areturn
    //   118: aload 5
    //   120: ifnull +10 -> 130
    //   123: aload 5
    //   125: invokeinterface 274 1 0
    //   130: aload_0
    //   131: athrow
    //   132: iconst_0
    //   133: istore 4
    //   135: goto -98 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramContext	Context
    //   0	138	1	paramString	String
    //   0	138	2	paramInt	int
    //   0	138	3	paramMediaFileFilter	MediaFileFilter
    //   32	102	4	bool	boolean
    //   13	111	5	localContext	Context
    //   10	70	6	localObject	Object
    //   7	109	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   23	31	61	finally
    //   37	48	61	finally
    //   23	31	70	java/lang/Exception
    //   37	48	70	java/lang/Exception
    //   15	23	74	finally
    //   85	91	74	finally
    //   94	105	74	finally
    //   15	23	78	java/lang/Exception
  }
  
  /* Error */
  private static void queryOnHighVer(Cursor paramCursor, int paramInt1, int paramInt2, String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload 4
    //   2: aload_0
    //   3: iload_1
    //   4: invokeinterface 90 2 0
    //   9: putfield 119	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   12: aload 4
    //   14: aload_0
    //   15: iload_2
    //   16: invokeinterface 90 2 0
    //   21: putfield 122	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   24: aload 4
    //   26: getfield 457	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   29: lconst_0
    //   30: lcmp
    //   31: ifne +103 -> 134
    //   34: new 599	android/media/MediaMetadataRetriever
    //   37: dup
    //   38: invokespecial 600	android/media/MediaMetadataRetriever:<init>	()V
    //   41: astore_0
    //   42: aload_0
    //   43: astore 5
    //   45: aload_0
    //   46: aload_3
    //   47: invokevirtual 603	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: astore 5
    //   53: aload 4
    //   55: aload_0
    //   56: bipush 9
    //   58: invokevirtual 606	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   61: invokestatic 612	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   64: putfield 457	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   67: goto +49 -> 116
    //   70: astore_3
    //   71: goto +13 -> 84
    //   74: astore_0
    //   75: aconst_null
    //   76: astore 5
    //   78: goto +44 -> 122
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: astore 5
    //   87: aload_3
    //   88: invokevirtual 615	java/lang/Exception:printStackTrace	()V
    //   91: aload_0
    //   92: astore 5
    //   94: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +15 -> 112
    //   100: aload_0
    //   101: astore 5
    //   103: ldc 17
    //   105: iconst_2
    //   106: ldc_w 617
    //   109: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_0
    //   113: ifnull +21 -> 134
    //   116: aload_0
    //   117: invokevirtual 620	android/media/MediaMetadataRetriever:release	()V
    //   120: return
    //   121: astore_0
    //   122: aload 5
    //   124: ifnull +8 -> 132
    //   127: aload 5
    //   129: invokevirtual 620	android/media/MediaMetadataRetriever:release	()V
    //   132: aload_0
    //   133: athrow
    //   134: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramCursor	Cursor
    //   0	135	1	paramInt1	int
    //   0	135	2	paramInt2	int
    //   0	135	3	paramString	String
    //   0	135	4	paramLocalMediaInfo	LocalMediaInfo
    //   43	85	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   45	50	70	java/lang/Exception
    //   53	67	70	java/lang/Exception
    //   34	42	74	finally
    //   34	42	81	java/lang/Exception
    //   45	50	121	finally
    //   53	67	121	finally
    //   87	91	121	finally
    //   94	100	121	finally
    //   103	112	121	finally
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
      label48:
      break label48;
    }
    paramLocalMediaInfo.mediaWidth = 0;
    paramLocalMediaInfo.mediaHeight = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QQAlbum", 2, "Video size is not number format...");
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentImages(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, boolean paramBoolean1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 633	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 8
    //   5: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +40 -> 48
    //   11: new 175	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   18: astore 10
    //   20: aload 10
    //   22: ldc_w 635
    //   25: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 10
    //   31: lload 8
    //   33: invokevirtual 638	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 17
    //   39: iconst_2
    //   40: aload 10
    //   42: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: new 334	java/util/ArrayList
    //   57: dup
    //   58: invokespecial 335	java/util/ArrayList:<init>	()V
    //   61: astore 13
    //   63: iload 4
    //   65: ifeq +199 -> 264
    //   68: ldc_w 640
    //   71: astore 12
    //   73: goto +3 -> 76
    //   76: aload_0
    //   77: aload 12
    //   79: iconst_3
    //   80: anewarray 46	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: iload 5
    //   87: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: iload_1
    //   94: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: iload_1
    //   101: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: aastore
    //   105: iload_2
    //   106: invokestatic 404	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   109: astore_0
    //   110: aload_0
    //   111: astore 11
    //   113: aload_0
    //   114: astore 10
    //   116: aload_0
    //   117: aload 13
    //   119: iload_1
    //   120: iload_2
    //   121: iconst_1
    //   122: aload_3
    //   123: aload 6
    //   125: iload 7
    //   127: invokestatic 348	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   130: aload_0
    //   131: ifnull +50 -> 181
    //   134: goto +41 -> 175
    //   137: astore_0
    //   138: goto +112 -> 250
    //   141: astore_0
    //   142: aload 10
    //   144: astore 11
    //   146: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +18 -> 167
    //   152: aload 10
    //   154: astore 11
    //   156: ldc 17
    //   158: iconst_2
    //   159: aload_0
    //   160: invokevirtual 407	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aload_0
    //   164: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload 10
    //   169: ifnull +12 -> 181
    //   172: aload 10
    //   174: astore_0
    //   175: aload_0
    //   176: invokeinterface 274 1 0
    //   181: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +63 -> 247
    //   187: new 175	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   194: astore_0
    //   195: aload_0
    //   196: ldc_w 642
    //   199: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_0
    //   204: invokestatic 633	android/os/SystemClock:uptimeMillis	()J
    //   207: lload 8
    //   209: lsub
    //   210: invokevirtual 638	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_0
    //   215: ldc_w 644
    //   218: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_0
    //   223: aload 13
    //   225: invokeinterface 150 1 0
    //   230: invokestatic 510	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokevirtual 533	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 17
    //   239: iconst_2
    //   240: aload_0
    //   241: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload 13
    //   249: areturn
    //   250: aload 11
    //   252: ifnull +10 -> 262
    //   255: aload 11
    //   257: invokeinterface 274 1 0
    //   262: aload_0
    //   263: athrow
    //   264: ldc_w 646
    //   267: astore 12
    //   269: goto -193 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   0	272	1	paramInt1	int
    //   0	272	2	paramInt2	int
    //   0	272	3	paramMediaFileFilter	MediaFileFilter
    //   0	272	4	paramBoolean1	boolean
    //   0	272	5	paramInt3	int
    //   0	272	6	paramArrayList	ArrayList<String>
    //   0	272	7	paramBoolean2	boolean
    //   3	205	8	l	long
    //   18	155	10	localObject1	Object
    //   52	204	11	localObject2	Object
    //   71	197	12	str	String
    //   61	187	13	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   76	110	137	finally
    //   116	130	137	finally
    //   146	152	137	finally
    //   156	167	137	finally
    //   76	110	141	java/lang/Exception
    //   116	130	141	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentVideos(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 633	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +40 -> 48
    //   11: new 175	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   18: astore 9
    //   20: aload 9
    //   22: ldc_w 649
    //   25: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 9
    //   31: lload 6
    //   33: invokevirtual 638	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 17
    //   39: iconst_2
    //   40: aload 9
    //   42: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 334	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 335	java/util/ArrayList:<init>	()V
    //   55: astore 12
    //   57: aconst_null
    //   58: astore 10
    //   60: aconst_null
    //   61: astore 11
    //   63: aload 11
    //   65: astore 9
    //   67: getstatic 261	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   70: invokevirtual 580	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   73: astore 13
    //   75: iload_2
    //   76: ifle +23 -> 99
    //   79: aload 11
    //   81: astore 9
    //   83: aload 13
    //   85: ldc_w 582
    //   88: iload_2
    //   89: bipush 6
    //   91: imul
    //   92: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   95: invokevirtual 588	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   98: pop
    //   99: aload 11
    //   101: astore 9
    //   103: aload 13
    //   105: invokevirtual 592	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   108: astore 13
    //   110: aload 11
    //   112: astore 9
    //   114: aload_0
    //   115: invokevirtual 255	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   118: aload 13
    //   120: getstatic 66	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   123: ldc_w 651
    //   126: aconst_null
    //   127: ldc 11
    //   129: invokevirtual 267	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   132: astore_0
    //   133: getstatic 44	android/os/Build$VERSION:SDK_INT	I
    //   136: bipush 16
    //   138: if_icmplt +128 -> 266
    //   141: iconst_1
    //   142: istore 8
    //   144: goto +3 -> 147
    //   147: aload_0
    //   148: aload 12
    //   150: iload_2
    //   151: aload_3
    //   152: iload 8
    //   154: lload 4
    //   156: invokestatic 339	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   159: pop
    //   160: aload_0
    //   161: ifnull +78 -> 239
    //   164: aload_0
    //   165: invokeinterface 274 1 0
    //   170: goto +69 -> 239
    //   173: astore 9
    //   175: aload_0
    //   176: astore_3
    //   177: aload 9
    //   179: astore_0
    //   180: goto +74 -> 254
    //   183: astore 10
    //   185: goto +19 -> 204
    //   188: astore_0
    //   189: aload 9
    //   191: astore_3
    //   192: goto +62 -> 254
    //   195: astore 9
    //   197: aload 10
    //   199: astore_0
    //   200: aload 9
    //   202: astore 10
    //   204: aload_0
    //   205: astore 9
    //   207: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +19 -> 229
    //   213: aload_0
    //   214: astore 9
    //   216: ldc 17
    //   218: iconst_2
    //   219: aload 10
    //   221: invokevirtual 407	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   224: aload 10
    //   226: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   229: aload_0
    //   230: ifnull +9 -> 239
    //   233: aload_0
    //   234: invokeinterface 274 1 0
    //   239: aload_3
    //   240: aload 12
    //   242: invokestatic 655	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryThirdPartyVideo	(Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/List;)V
    //   245: iload_2
    //   246: lload 6
    //   248: aload 12
    //   250: invokestatic 659	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sortAndLimitVideoList	(IJLjava/util/List;)Ljava/util/List;
    //   253: areturn
    //   254: aload_3
    //   255: ifnull +9 -> 264
    //   258: aload_3
    //   259: invokeinterface 274 1 0
    //   264: aload_0
    //   265: athrow
    //   266: iconst_0
    //   267: istore 8
    //   269: goto -122 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   0	272	1	paramInt1	int
    //   0	272	2	paramInt2	int
    //   0	272	3	paramMediaFileFilter	MediaFileFilter
    //   0	272	4	paramLong	long
    //   3	244	6	l	long
    //   142	126	8	bool	boolean
    //   18	95	9	localObject1	Object
    //   173	17	9	localObject2	Object
    //   195	6	9	localException1	java.lang.Exception
    //   205	10	9	localContext	Context
    //   58	1	10	localObject3	Object
    //   183	15	10	localException2	java.lang.Exception
    //   202	23	10	localException3	java.lang.Exception
    //   61	50	11	localObject4	Object
    //   55	194	12	localArrayList	ArrayList
    //   73	46	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   133	141	173	finally
    //   147	160	173	finally
    //   133	141	183	java/lang/Exception
    //   147	160	183	java/lang/Exception
    //   67	75	188	finally
    //   83	99	188	finally
    //   103	110	188	finally
    //   114	133	188	finally
    //   207	213	188	finally
    //   216	229	188	finally
    //   67	75	195	java/lang/Exception
    //   83	99	195	java/lang/Exception
    //   103	110	195	java/lang/Exception
    //   114	133	195	java/lang/Exception
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
    int j = 0;
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2 = paramMediaFileFilter;
      if (!paramCursor.moveToNext()) {
        break;
      }
      String str = paramCursor.getString(paramInt3);
      Object localObject3;
      int i;
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        localObject3 = paramCursor.getString(paramInt7);
        if ((localObject2 != null) && (((MediaFileFilter)localObject2).filter((String)localObject3)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new StringBuilder();
            }
            ((StringBuilder)localObject2).append("Filter mime type:");
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append(", path is ");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append("\n");
            localObject1 = localObject2;
            continue;
          }
          i = j;
        }
        else
        {
          long l1 = paramCursor.getLong(paramInt4);
          long l2 = paramCursor.getLong(paramInt5);
          localObject2 = new LocalMediaInfo();
          ((LocalMediaInfo)localObject2)._id = paramCursor.getLong(paramInt2);
          ((LocalMediaInfo)localObject2).path = str;
          ((LocalMediaInfo)localObject2).mMimeType = ((String)localObject3);
          ((LocalMediaInfo)localObject2).addedDate = l1;
          ((LocalMediaInfo)localObject2).modifiedDate = l2;
          ((LocalMediaInfo)localObject2).mDuration = paramCursor.getLong(paramInt6);
          ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(paramInt8);
          queryOnHighVer(paramCursor, paramInt9, paramInt10, str, (LocalMediaInfo)localObject2);
          if ((paramLong > 0L) && (((LocalMediaInfo)localObject2).mDuration > paramLong))
          {
            i = j;
          }
          else
          {
            paramList.add(localObject2);
            j += 1;
            if (sLastModify < l2) {
              sLastModify = l2;
            }
            i = j;
            if (paramInt1 > 0)
            {
              i = j;
              if (j >= paramInt1) {
                break;
              }
            }
          }
        }
      }
      else
      {
        i = j;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getVideoList file not exists:");
          if (str != null) {
            localObject2 = str;
          } else {
            localObject2 = "null";
          }
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.i("QQAlbum", 2, ((StringBuilder)localObject3).toString());
          i = j;
        }
      }
      j = i;
    }
    if ((localObject1 != null) && (QLog.isColorLevel())) {
      QLog.d("QQAlbum", 2, localObject1.toString());
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
    if (paramInt > 0) {
      paramInt = Math.min(paramInt, paramList.size());
    } else {
      paramInt = paramList.size();
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("queryRecentVideos cost: ");
      paramList.append(SystemClock.uptimeMillis() - paramLong);
      paramList.append(" resultVideoList size:");
      paramList.append(Integer.valueOf(localArrayList.size()));
      QLog.d("QQAlbum", 2, paramList.toString());
    }
    return localArrayList;
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
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getAlbumMedias-sort recent cost: ");
        paramString.append(SystemClock.uptimeMillis() - l);
        QLog.d("QQAlbum", 2, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil
 * JD-Core Version:    0.7.0.1
 */