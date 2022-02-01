package com.tencent.mobileqq.activity.photo.album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import bdlg;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.activity.photo.LocalMediaInfo;>;
import java.util.Map;

public class QAlbumBaseUtil
{
  public static int CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 0;
  protected static final String IMAGE_ORDER_BY = "_id DESC";
  private static final int MAX_PHOTO_HEIGHT_OF_CACHE = 65535;
  private static final int MAX_PHOTO_WIDTH_OF_CACHE = 65535;
  protected static final String TAG = "QAlbumUtil";
  public static final int TYPE_SLIDESHOW = 1;
  private static String[] VIDEO_COLUMNS;
  public static String[] columns;
  private static Map<String, Integer> pathWHMap;
  public static boolean sAlbumQueryFailReport = false;
  private static long sLastModify;
  
  static
  {
    CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 10485760;
    if (Build.VERSION.SDK_INT >= 16)
    {
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" };
      if (Build.VERSION.SDK_INT < 16) {
        break label207;
      }
    }
    label207:
    for (columns = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size", "width", "height" };; columns = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size" })
    {
      pathWHMap = new HashMap();
      return;
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
      break;
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
  
  /* Error */
  public static void fixVideoInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +134 -> 135
    //   4: aload_0
    //   5: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMediaType	I
    //   8: iconst_1
    //   9: if_icmpne +126 -> 135
    //   12: aload_0
    //   13: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifeq +17 -> 35
    //   21: aload_0
    //   22: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   25: ifle +10 -> 35
    //   28: aload_0
    //   29: getfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   32: ifgt +103 -> 135
    //   35: new 115	android/media/MediaMetadataRetriever
    //   38: dup
    //   39: invokespecial 116	android/media/MediaMetadataRetriever:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: aload_2
    //   46: aload_0
    //   47: getfield 119	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   50: invokevirtual 122	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   59: lconst_0
    //   60: lcmp
    //   61: ifne +18 -> 79
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: aload_2
    //   68: bipush 9
    //   70: invokevirtual 126	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   73: invokestatic 132	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   76: putfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   85: ifgt +18 -> 103
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: aload_2
    //   92: bipush 19
    //   94: invokevirtual 126	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   97: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   100: putfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   109: ifgt +18 -> 127
    //   112: aload_2
    //   113: astore_1
    //   114: aload_0
    //   115: aload_2
    //   116: bipush 18
    //   118: invokevirtual 126	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   121: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: putfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   135: return
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   145: aload_2
    //   146: astore_1
    //   147: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +33 -> 183
    //   153: aload_2
    //   154: astore_1
    //   155: ldc 151
    //   157: iconst_2
    //   158: new 153	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   165: ldc 156
    //   167: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: getfield 119	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   174: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload_2
    //   184: ifnull -49 -> 135
    //   187: aload_2
    //   188: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   191: return
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore_0
    //   206: goto -11 -> 195
    //   209: astore_3
    //   210: goto -71 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramLocalMediaInfo	LocalMediaInfo
    //   44	156	1	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   42	146	2	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   136	6	3	localException1	java.lang.Exception
    //   209	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   35	43	136	java/lang/Exception
    //   35	43	192	finally
    //   45	53	205	finally
    //   55	64	205	finally
    //   66	79	205	finally
    //   81	88	205	finally
    //   90	103	205	finally
    //   105	112	205	finally
    //   114	127	205	finally
    //   141	145	205	finally
    //   147	153	205	finally
    //   155	183	205	finally
    //   45	53	209	java/lang/Exception
    //   55	64	209	java/lang/Exception
    //   66	79	209	java/lang/Exception
    //   81	88	209	java/lang/Exception
    //   90	103	209	java/lang/Exception
    //   105	112	209	java/lang/Exception
    //   114	127	209	java/lang/Exception
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
    //   1: astore 19
    //   3: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 17
    //   11: iconst_2
    //   12: ldc 176
    //   14: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: ldc 181
    //   19: aload_1
    //   20: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +125 -> 148
    //   26: aload_0
    //   27: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 197	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   33: getstatic 63	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   36: aconst_null
    //   37: aconst_null
    //   38: ldc 11
    //   40: invokevirtual 203	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 16
    //   45: aload 16
    //   47: astore 17
    //   49: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 16
    //   54: if_icmplt +47 -> 101
    //   57: iconst_1
    //   58: istore 15
    //   60: aload 16
    //   62: astore 17
    //   64: aload_0
    //   65: aload 16
    //   67: aconst_null
    //   68: iload_3
    //   69: aload 4
    //   71: iload 15
    //   73: lload 10
    //   75: invokestatic 207	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSystemAndAppVideoList	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/ArrayList;
    //   78: astore 18
    //   80: aload 18
    //   82: astore_0
    //   83: aload_0
    //   84: astore_1
    //   85: aload 16
    //   87: ifnull +12 -> 99
    //   90: aload 16
    //   92: invokeinterface 212 1 0
    //   97: aload_0
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: iconst_0
    //   102: istore 15
    //   104: goto -44 -> 60
    //   107: astore 18
    //   109: aconst_null
    //   110: astore 16
    //   112: aload 16
    //   114: astore 17
    //   116: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +17 -> 136
    //   122: aload 16
    //   124: astore 17
    //   126: ldc 17
    //   128: iconst_2
    //   129: ldc 214
    //   131: aload 18
    //   133: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload 16
    //   138: ifnull +10 -> 148
    //   141: aload 16
    //   143: invokeinterface 212 1 0
    //   148: aload 19
    //   150: astore 16
    //   152: aload 4
    //   154: ifnull +42 -> 196
    //   157: aload 19
    //   159: astore 16
    //   161: aload 4
    //   163: invokevirtual 223	com/tencent/mobileqq/activity/photo/MediaFileFilter:showImage	()Z
    //   166: ifeq +30 -> 196
    //   169: iload 12
    //   171: iconst_1
    //   172: if_icmpne +226 -> 398
    //   175: aload_0
    //   176: aload_1
    //   177: aload_2
    //   178: iload_3
    //   179: aload 4
    //   181: iload 5
    //   183: iload 6
    //   185: iload 7
    //   187: aload 8
    //   189: iload 9
    //   191: invokestatic 227	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSlideShowAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   194: astore 16
    //   196: aload 4
    //   198: ifnull +573 -> 771
    //   201: aload 4
    //   203: invokevirtual 230	com/tencent/mobileqq/activity/photo/MediaFileFilter:showVideo	()Z
    //   206: ifeq +565 -> 771
    //   209: aload_0
    //   210: aload_1
    //   211: aload_2
    //   212: iload_3
    //   213: aload 4
    //   215: lload 10
    //   217: invokestatic 234	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumVideos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   220: astore_0
    //   221: ldc 236
    //   223: aload_1
    //   224: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +62 -> 289
    //   230: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
    //   233: lstore 10
    //   235: aload 16
    //   237: ifnull +8 -> 245
    //   240: aload 16
    //   242: invokestatic 247	java/util/Collections:sort	(Ljava/util/List;)V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokestatic 247	java/util/Collections:sort	(Ljava/util/List;)V
    //   253: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +33 -> 289
    //   259: ldc 17
    //   261: iconst_2
    //   262: new 153	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   269: ldc 249
    //   271: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
    //   277: lload 10
    //   279: lsub
    //   280: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +72 -> 364
    //   295: new 153	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   302: ldc 254
    //   304: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: astore_2
    //   308: aload 16
    //   310: ifnull +112 -> 422
    //   313: aload 16
    //   315: invokeinterface 260 1 0
    //   320: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: astore_1
    //   324: aload_2
    //   325: aload_1
    //   326: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: ldc_w 269
    //   332: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: astore_2
    //   336: aload_0
    //   337: ifnull +92 -> 429
    //   340: aload_0
    //   341: invokeinterface 260 1 0
    //   346: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: astore_1
    //   350: ldc 17
    //   352: iconst_2
    //   353: aload_2
    //   354: aload_1
    //   355: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_0
    //   365: ifnull +12 -> 377
    //   368: aload_0
    //   369: invokeinterface 272 1 0
    //   374: ifeq +62 -> 436
    //   377: aload 16
    //   379: areturn
    //   380: astore_0
    //   381: aconst_null
    //   382: astore 17
    //   384: aload 17
    //   386: ifnull +10 -> 396
    //   389: aload 17
    //   391: invokeinterface 212 1 0
    //   396: aload_0
    //   397: athrow
    //   398: aload_0
    //   399: aload_1
    //   400: aload_2
    //   401: iload_3
    //   402: aload 4
    //   404: iload 5
    //   406: iload 6
    //   408: iload 7
    //   410: aload 8
    //   412: iload 9
    //   414: invokestatic 275	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   417: astore 16
    //   419: goto -223 -> 196
    //   422: ldc_w 277
    //   425: astore_1
    //   426: goto -102 -> 324
    //   429: ldc_w 277
    //   432: astore_1
    //   433: goto -83 -> 350
    //   436: aload_0
    //   437: astore_1
    //   438: aload 16
    //   440: ifnull -341 -> 99
    //   443: aload_0
    //   444: astore_1
    //   445: aload 16
    //   447: invokeinterface 272 1 0
    //   452: ifne -353 -> 99
    //   455: aload 16
    //   457: invokeinterface 260 1 0
    //   462: istore 5
    //   464: iconst_0
    //   465: istore 6
    //   467: iconst_0
    //   468: istore 12
    //   470: iload 12
    //   472: aload_0
    //   473: invokeinterface 260 1 0
    //   478: if_icmpge +266 -> 744
    //   481: aload_0
    //   482: iload 12
    //   484: invokeinterface 281 2 0
    //   489: checkcast 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   492: astore_1
    //   493: aload 16
    //   495: iload 5
    //   497: iconst_1
    //   498: isub
    //   499: invokeinterface 281 2 0
    //   504: checkcast 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   507: astore_2
    //   508: aload_1
    //   509: getfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   512: aload_2
    //   513: getfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   516: lcmp
    //   517: ifgt +95 -> 612
    //   520: iload_3
    //   521: iconst_m1
    //   522: if_icmpne +39 -> 561
    //   525: iload 12
    //   527: aload_0
    //   528: invokeinterface 260 1 0
    //   533: if_icmpge +211 -> 744
    //   536: aload 16
    //   538: aload_0
    //   539: iload 12
    //   541: invokeinterface 281 2 0
    //   546: invokeinterface 287 2 0
    //   551: pop
    //   552: iload 12
    //   554: iconst_1
    //   555: iadd
    //   556: istore 12
    //   558: goto -33 -> 525
    //   561: aload_0
    //   562: invokeinterface 260 1 0
    //   567: iload 12
    //   569: isub
    //   570: iload_3
    //   571: iload 5
    //   573: isub
    //   574: invokestatic 293	java/lang/Math:min	(II)I
    //   577: istore 5
    //   579: iconst_0
    //   580: istore_3
    //   581: iload_3
    //   582: iload 5
    //   584: if_icmpge +160 -> 744
    //   587: aload 16
    //   589: aload_0
    //   590: iload_3
    //   591: iload 12
    //   593: iadd
    //   594: invokeinterface 281 2 0
    //   599: invokeinterface 287 2 0
    //   604: pop
    //   605: iload_3
    //   606: iconst_1
    //   607: iadd
    //   608: istore_3
    //   609: goto -28 -> 581
    //   612: iload 6
    //   614: istore 13
    //   616: iload 13
    //   618: iload 5
    //   620: if_icmpge +136 -> 756
    //   623: aload 16
    //   625: iload 13
    //   627: invokeinterface 281 2 0
    //   632: checkcast 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   635: astore_2
    //   636: aload_1
    //   637: getfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   640: aload_2
    //   641: getfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   644: lcmp
    //   645: ifgt +12 -> 657
    //   648: iload 13
    //   650: iconst_1
    //   651: iadd
    //   652: istore 13
    //   654: goto -38 -> 616
    //   657: aload 16
    //   659: iload 13
    //   661: aload_1
    //   662: invokeinterface 296 3 0
    //   667: iload_3
    //   668: iconst_m1
    //   669: if_icmpeq +24 -> 693
    //   672: aload 16
    //   674: invokeinterface 260 1 0
    //   679: iload_3
    //   680: if_icmple +13 -> 693
    //   683: aload 16
    //   685: iload 5
    //   687: invokeinterface 299 2 0
    //   692: pop
    //   693: aload 16
    //   695: invokeinterface 260 1 0
    //   700: istore 14
    //   702: iload 5
    //   704: istore 6
    //   706: iload 5
    //   708: iload 14
    //   710: if_icmpeq +7 -> 717
    //   713: iload 14
    //   715: istore 6
    //   717: iload 13
    //   719: iconst_1
    //   720: iadd
    //   721: istore 5
    //   723: iload 12
    //   725: iconst_1
    //   726: iadd
    //   727: istore 12
    //   729: iload 6
    //   731: istore 13
    //   733: iload 5
    //   735: istore 6
    //   737: iload 13
    //   739: istore 5
    //   741: goto -271 -> 470
    //   744: aload 16
    //   746: areturn
    //   747: astore_0
    //   748: goto -364 -> 384
    //   751: astore 18
    //   753: goto -641 -> 112
    //   756: iload 5
    //   758: istore 13
    //   760: iload 6
    //   762: istore 5
    //   764: iload 13
    //   766: istore 6
    //   768: goto -45 -> 723
    //   771: aconst_null
    //   772: astore_0
    //   773: goto -552 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	paramContext	Context
    //   0	776	1	paramString1	String
    //   0	776	2	paramString2	String
    //   0	776	3	paramInt1	int
    //   0	776	4	paramMediaFileFilter	MediaFileFilter
    //   0	776	5	paramInt2	int
    //   0	776	6	paramInt3	int
    //   0	776	7	paramBoolean1	boolean
    //   0	776	8	paramArrayList	ArrayList<String>
    //   0	776	9	paramBoolean2	boolean
    //   0	776	10	paramLong	long
    //   0	776	12	paramInt4	int
    //   614	151	13	i	int
    //   700	14	14	j	int
    //   58	45	15	bool	boolean
    //   43	702	16	localObject1	Object
    //   47	343	17	localObject2	Object
    //   78	3	18	localArrayList	ArrayList
    //   107	25	18	localException1	java.lang.Exception
    //   751	1	18	localException2	java.lang.Exception
    //   1	157	19	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   26	45	107	java/lang/Exception
    //   26	45	380	finally
    //   49	57	747	finally
    //   64	80	747	finally
    //   116	122	747	finally
    //   126	136	747	finally
    //   49	57	751	java/lang/Exception
    //   64	80	751	java/lang/Exception
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
    //   1: ifnull +12 -> 13
    //   4: ldc 236
    //   6: aload_1
    //   7: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +16 -> 26
    //   13: aload_0
    //   14: sipush 210
    //   17: iload_3
    //   18: aload 4
    //   20: lload 5
    //   22: invokestatic 326	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryRecentVideos	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   25: areturn
    //   26: new 328	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 329	java/util/ArrayList:<init>	()V
    //   33: astore 8
    //   35: new 153	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 310
    //   45: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 312
    //   55: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   66: getstatic 197	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   69: getstatic 63	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   72: aload_1
    //   73: aconst_null
    //   74: ldc 11
    //   76: invokevirtual 203	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   85: bipush 16
    //   87: if_icmplt +35 -> 122
    //   90: iconst_1
    //   91: istore 7
    //   93: aload_1
    //   94: astore_0
    //   95: aload_1
    //   96: aload 8
    //   98: iload_3
    //   99: aload 4
    //   101: iload 7
    //   103: lload 5
    //   105: invokestatic 333	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   108: pop
    //   109: aload_1
    //   110: ifnull +76 -> 186
    //   113: aload_1
    //   114: invokeinterface 212 1 0
    //   119: aload 8
    //   121: areturn
    //   122: iconst_0
    //   123: istore 7
    //   125: goto -32 -> 93
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: astore_0
    //   133: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +14 -> 150
    //   139: aload_1
    //   140: astore_0
    //   141: ldc 17
    //   143: iconst_2
    //   144: ldc 214
    //   146: aload_2
    //   147: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_1
    //   151: ifnull +35 -> 186
    //   154: aload_1
    //   155: invokeinterface 212 1 0
    //   160: aload 8
    //   162: areturn
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +9 -> 176
    //   170: aload_0
    //   171: invokeinterface 212 1 0
    //   176: aload_1
    //   177: athrow
    //   178: astore_1
    //   179: goto -13 -> 166
    //   182: astore_2
    //   183: goto -52 -> 131
    //   186: aload 8
    //   188: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramContext	Context
    //   0	189	1	paramString1	String
    //   0	189	2	paramString2	String
    //   0	189	3	paramInt	int
    //   0	189	4	paramMediaFileFilter	MediaFileFilter
    //   0	189	5	paramLong	long
    //   91	33	7	bool	boolean
    //   33	154	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   62	80	128	java/lang/Exception
    //   62	80	163	finally
    //   82	90	178	finally
    //   95	109	178	finally
    //   133	139	178	finally
    //   141	150	178	finally
    //   82	90	182	java/lang/Exception
    //   95	109	182	java/lang/Exception
  }
  
  private static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    getImageList(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramMediaFileFilter, null, false);
  }
  
  public static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean1, MediaFileFilter paramMediaFileFilter, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    Object localObject1;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int n;
    if (paramCursor.getCount() > 0)
    {
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      i3 = paramCursor.getColumnIndexOrThrow("_id");
      i4 = paramCursor.getColumnIndexOrThrow("_data");
      i5 = paramCursor.getColumnIndexOrThrow("orientation");
      i6 = paramCursor.getColumnIndexOrThrow("date_added");
      i7 = paramCursor.getColumnIndexOrThrow("date_modified");
      i8 = paramCursor.getColumnIndexOrThrow("mime_type");
      i9 = paramCursor.getColumnIndexOrThrow("_size");
      i10 = paramCursor.getColumnIndexOrThrow("latitude");
      i11 = paramCursor.getColumnIndexOrThrow("longitude");
      if (!paramBoolean1) {
        break label1305;
      }
      n = paramCursor.getColumnIndexOrThrow("width");
    }
    for (int m = paramCursor.getColumnIndexOrThrow("height");; m = 0)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      if (QLog.isColorLevel()) {
        QLog.i("QAlbumUtil", 2, "getImageList imageCursor count:" + paramCursor.getCount());
      }
      int k = 0;
      int i = 0;
      int j = 0;
      for (;;)
      {
        String str;
        label252:
        Object localObject2;
        if (paramCursor.moveToNext())
        {
          str = paramCursor.getString(i4);
          if (!fileExistsAndNotEmpty(str))
          {
            if (str == null)
            {
              i1 = j;
              j = i + 1;
              i = i1;
              if (!QLog.isColorLevel()) {
                break label1290;
              }
              localObject2 = new StringBuilder().append("getImageList file not exists:");
              if (str == null) {
                break label328;
              }
            }
            label328:
            for (paramList = str;; paramList = "null")
            {
              QLog.i("QAlbumUtil", 2, paramList);
              i1 = j;
              j = i;
              i = i1;
              break;
              i1 = j + 1;
              j = i;
              i = i1;
              break label252;
            }
          }
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramList = paramArrayList.iterator();
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
            } while (!str.contains((String)paramList.next()));
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label1288;
          }
          localObject2 = paramCursor.getString(i8);
          paramList = (List<LocalMediaInfo>)localObject2;
          if (paramMediaFileFilter != null)
          {
            paramList = (List<LocalMediaInfo>)localObject2;
            if (paramMediaFileFilter.filter((String)localObject2))
            {
              if ((!"*/*".equals(localObject2)) && (!"image/*".equals(localObject2))) {
                break label972;
              }
              if ((str.indexOf(".jpg") == -1) && (str.indexOf(".jpeg") == -1)) {
                break label868;
              }
              paramList = "image/jpeg";
            }
          }
          label469:
          long l1 = paramCursor.getLong(i6);
          long l2 = paramCursor.getLong(i7);
          if (sLastModify < l2) {
            sLastModify = l2;
          }
          int i2 = 0;
          i1 = i2;
          if (paramBoolean1)
          {
            i1 = i2;
            if (paramCursor.getInt(n) == 0) {
              i1 = 1;
            }
          }
          long l3 = paramCursor.getLong(i3);
          if ((paramInt1 > 0) && ((!paramBoolean1) || (i1 != 0)))
          {
            getWHByPath(str, localOptions, arrayOfInt);
            if ((arrayOfInt[0] < paramInt1) && (arrayOfInt[1] < paramInt1)) {
              break label1281;
            }
            localObject2 = new LocalMediaInfo();
            ((LocalMediaInfo)localObject2)._id = l3;
            ((LocalMediaInfo)localObject2).path = str;
            ((LocalMediaInfo)localObject2).addedDate = l1;
            ((LocalMediaInfo)localObject2).modifiedDate = l2;
            ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i5);
            ((LocalMediaInfo)localObject2).mMimeType = paramList;
            ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i9);
            ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
            ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
            ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i10) * 1000000.0D));
            ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i11) * 1000000.0D));
            if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
              QLog.i("QAlbumUtil", 2, "no size " + str);
            }
            ((List)localObject1).add(localObject2);
            k += 1;
          }
          label1281:
          for (;;)
          {
            if ((paramInt2 > 0) && (k >= paramInt2))
            {
              if (!sAlbumQueryFailReport)
              {
                if ((i > 0) || (j > 0))
                {
                  paramCursor = new StringBuffer();
                  paramCursor.append("imagePathNullCount:");
                  paramCursor.append(i);
                  paramCursor.append(" imagePathFileNotExistCount:");
                  paramCursor.append(j);
                  paramCursor = paramCursor.toString();
                  if (i > 0) {
                    bdlg.a("Album_Query_File_Path_Null", paramCursor);
                  }
                  if (j > 0) {
                    bdlg.a("Album_Query_File_Not_Exist", paramCursor);
                  }
                }
                sAlbumQueryFailReport = true;
              }
              return;
              label868:
              if (str.indexOf(".gif") != -1)
              {
                paramList = "image/gif";
                break label469;
              }
              if (str.indexOf(".bmp") != -1)
              {
                paramList = "image/bmp";
                break label469;
              }
              if (str.indexOf(".png") != -1)
              {
                paramList = "image/png";
                break label469;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("QAlbumUtil", 2, "Filter mime type:" + (String)localObject2 + ", path is " + str);
              break;
              label972:
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("QAlbumUtil", 2, "Filter unknown " + (String)localObject2 + ", path is " + str);
              break;
              localObject2 = new LocalMediaInfo();
              ((LocalMediaInfo)localObject2)._id = l3;
              ((LocalMediaInfo)localObject2).path = str;
              ((LocalMediaInfo)localObject2).addedDate = paramCursor.getLong(i6);
              ((LocalMediaInfo)localObject2).modifiedDate = paramCursor.getLong(i7);
              ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i5);
              ((LocalMediaInfo)localObject2).mMimeType = paramList;
              ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i9);
              ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i10) * 1000000.0D));
              ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i11) * 1000000.0D));
              if (paramBoolean1)
              {
                ((LocalMediaInfo)localObject2).mediaWidth = paramCursor.getInt(n);
                ((LocalMediaInfo)localObject2).mediaHeight = paramCursor.getInt(m);
              }
              if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0))
              {
                getWHByPath(str, localOptions, arrayOfInt);
                ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
                ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
              }
              if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
                QLog.i("QAlbumUtil", 2, "no size " + str);
              }
              ((List)localObject1).add(localObject2);
              k += 1;
              continue;
            }
            break;
          }
        }
        label1288:
        continue;
        label1290:
        i1 = j;
        j = i;
        i = i1;
      }
      label1305:
      n = 0;
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> getSlideShowAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 328	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 329	java/util/ArrayList:<init>	()V
    //   7: astore 13
    //   9: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 17
    //   17: iconst_2
    //   18: ldc_w 304
    //   21: invokestatic 482	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: astore 12
    //   27: new 153	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   34: astore 14
    //   36: iconst_0
    //   37: istore 10
    //   39: aload_2
    //   40: ifnull +12 -> 52
    //   43: ldc 236
    //   45: aload_1
    //   46: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +6 -> 55
    //   52: iconst_1
    //   53: istore 10
    //   55: iload 10
    //   57: ifeq +18 -> 75
    //   60: iload_3
    //   61: ifgt +55 -> 116
    //   64: new 484	java/lang/IllegalArgumentException
    //   67: dup
    //   68: ldc_w 486
    //   71: invokespecial 487	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: aload 14
    //   77: new 153	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 310
    //   87: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 312
    //   97: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 489
    //   112: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   119: bipush 16
    //   121: if_icmplt +515 -> 636
    //   124: iconst_1
    //   125: istore 11
    //   127: iload 11
    //   129: ifeq +313 -> 442
    //   132: iload 7
    //   134: ifeq +194 -> 328
    //   137: aload 14
    //   139: new 153	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 491
    //   149: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   155: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: ldc_w 493
    //   161: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 59
    //   166: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 495
    //   172: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 59
    //   177: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 497
    //   183: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc 61
    //   188: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 495
    //   194: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 61
    //   199: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 499
    //   205: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 61
    //   210: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 501
    //   216: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 59
    //   221: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 503
    //   227: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 61
    //   232: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 501
    //   238: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 59
    //   243: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 505
    //   249: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_0
    //   260: aload 14
    //   262: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: iconst_3
    //   266: anewarray 43	java/lang/String
    //   269: dup
    //   270: iconst_0
    //   271: iload 5
    //   273: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: iload 6
    //   281: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   284: aastore
    //   285: dup
    //   286: iconst_2
    //   287: iload 6
    //   289: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   292: aastore
    //   293: iload_3
    //   294: invokestatic 510	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   297: astore_0
    //   298: aload_0
    //   299: aload 13
    //   301: iload 6
    //   303: iload_3
    //   304: iload 11
    //   306: aload 4
    //   308: aload 8
    //   310: iload 9
    //   312: invokestatic 338	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   315: aload_0
    //   316: ifnull +9 -> 325
    //   319: aload_0
    //   320: invokeinterface 212 1 0
    //   325: aload 13
    //   327: areturn
    //   328: aload 14
    //   330: new 153	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 491
    //   340: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   346: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc_w 493
    //   352: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 59
    //   357: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 495
    //   363: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc 59
    //   368: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc_w 512
    //   374: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc 61
    //   379: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc_w 495
    //   385: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc 61
    //   390: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 514
    //   396: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: goto -147 -> 259
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_0
    //   412: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +14 -> 429
    //   418: ldc 17
    //   420: iconst_2
    //   421: aload_1
    //   422: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   425: aload_1
    //   426: invokestatic 519	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload_0
    //   430: ifnull -105 -> 325
    //   433: aload_0
    //   434: invokeinterface 212 1 0
    //   439: aload 13
    //   441: areturn
    //   442: iload 5
    //   444: ifle +114 -> 558
    //   447: aload 14
    //   449: new 153	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 521
    //   459: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 5
    //   464: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc_w 523
    //   470: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: ldc 57
    //   475: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 525
    //   481: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   487: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   490: ldc_w 527
    //   493: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc 47
    //   498: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: getstatic 530	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   511: invokevirtual 536	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   514: astore_1
    //   515: aload_1
    //   516: ldc_w 538
    //   519: iload_3
    //   520: bipush 6
    //   522: imul
    //   523: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   526: invokevirtual 544	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   529: pop
    //   530: aload_1
    //   531: invokevirtual 548	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   534: astore_1
    //   535: aload_0
    //   536: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   539: aload_1
    //   540: getstatic 71	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:columns	[Ljava/lang/String;
    //   543: aload 14
    //   545: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: aconst_null
    //   549: ldc 11
    //   551: invokevirtual 203	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   554: astore_0
    //   555: goto -257 -> 298
    //   558: aload 14
    //   560: new 153	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 550
    //   570: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   576: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   579: ldc_w 527
    //   582: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc 47
    //   587: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: goto -89 -> 508
    //   600: astore_0
    //   601: aload 12
    //   603: astore_1
    //   604: aload_1
    //   605: ifnull +9 -> 614
    //   608: aload_1
    //   609: invokeinterface 212 1 0
    //   614: aload_0
    //   615: athrow
    //   616: astore_2
    //   617: aload_0
    //   618: astore_1
    //   619: aload_2
    //   620: astore_0
    //   621: goto -17 -> 604
    //   624: astore_2
    //   625: aload_0
    //   626: astore_1
    //   627: aload_2
    //   628: astore_0
    //   629: goto -25 -> 604
    //   632: astore_1
    //   633: goto -221 -> 412
    //   636: iconst_0
    //   637: istore 11
    //   639: goto -512 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	paramContext	Context
    //   0	642	1	paramString1	String
    //   0	642	2	paramString2	String
    //   0	642	3	paramInt1	int
    //   0	642	4	paramMediaFileFilter	MediaFileFilter
    //   0	642	5	paramInt2	int
    //   0	642	6	paramInt3	int
    //   0	642	7	paramBoolean1	boolean
    //   0	642	8	paramArrayList	ArrayList<String>
    //   0	642	9	paramBoolean2	boolean
    //   37	19	10	i	int
    //   125	513	11	bool	boolean
    //   25	577	12	localObject	Object
    //   7	433	13	localArrayList	ArrayList
    //   34	525	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   137	259	409	java/lang/Exception
    //   259	298	409	java/lang/Exception
    //   328	406	409	java/lang/Exception
    //   447	508	409	java/lang/Exception
    //   508	555	409	java/lang/Exception
    //   558	597	409	java/lang/Exception
    //   137	259	600	finally
    //   259	298	600	finally
    //   328	406	600	finally
    //   447	508	600	finally
    //   508	555	600	finally
    //   558	597	600	finally
    //   298	315	616	finally
    //   412	429	624	finally
    //   298	315	632	java/lang/Exception
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
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static List<LocalMediaInfo> getVideoList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 342 1 0
    //   6: istore 7
    //   8: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc 17
    //   16: iconst_2
    //   17: new 153	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 597
    //   27: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload 7
    //   32: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iload 7
    //   43: ifgt +7 -> 50
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: aload_1
    //   51: astore 22
    //   53: aload_1
    //   54: ifnonnull +12 -> 66
    //   57: new 328	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 329	java/util/ArrayList:<init>	()V
    //   64: astore 22
    //   66: aload_0
    //   67: ldc 45
    //   69: invokeinterface 345 2 0
    //   74: istore 11
    //   76: aload_0
    //   77: ldc 47
    //   79: invokeinterface 345 2 0
    //   84: istore 12
    //   86: aload_0
    //   87: ldc 51
    //   89: invokeinterface 345 2 0
    //   94: istore 13
    //   96: aload_0
    //   97: ldc 53
    //   99: invokeinterface 345 2 0
    //   104: istore 14
    //   106: aload_0
    //   107: ldc 49
    //   109: invokeinterface 345 2 0
    //   114: istore 15
    //   116: aload_0
    //   117: ldc 55
    //   119: invokeinterface 345 2 0
    //   124: istore 16
    //   126: aload_0
    //   127: ldc 57
    //   129: invokeinterface 345 2 0
    //   134: istore 17
    //   136: iconst_0
    //   137: istore 8
    //   139: iconst_0
    //   140: istore 7
    //   142: iload 4
    //   144: ifeq +23 -> 167
    //   147: aload_0
    //   148: ldc 59
    //   150: invokeinterface 345 2 0
    //   155: istore 8
    //   157: aload_0
    //   158: ldc 61
    //   160: invokeinterface 345 2 0
    //   165: istore 7
    //   167: iconst_0
    //   168: istore 9
    //   170: aconst_null
    //   171: astore 24
    //   173: aload_0
    //   174: invokeinterface 356 1 0
    //   179: ifeq +421 -> 600
    //   182: aload_0
    //   183: iload 12
    //   185: invokeinterface 359 2 0
    //   190: astore 25
    //   192: aload 25
    //   194: invokestatic 601	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +18 -> 215
    //   200: new 84	java/io/File
    //   203: dup
    //   204: aload 25
    //   206: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: invokevirtual 91	java/io/File:exists	()Z
    //   212: ifne +57 -> 269
    //   215: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -45 -> 173
    //   221: new 153	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 603
    //   231: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: astore 23
    //   236: aload 25
    //   238: ifnull +24 -> 262
    //   241: aload 25
    //   243: astore_1
    //   244: ldc 17
    //   246: iconst_2
    //   247: aload 23
    //   249: aload_1
    //   250: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -86 -> 173
    //   262: ldc_w 277
    //   265: astore_1
    //   266: goto -22 -> 244
    //   269: aload_0
    //   270: iload 16
    //   272: invokeinterface 359 2 0
    //   277: astore 23
    //   279: aload_3
    //   280: ifnull +70 -> 350
    //   283: aload_3
    //   284: aload 23
    //   286: invokevirtual 384	com/tencent/mobileqq/activity/photo/MediaFileFilter:filter	(Ljava/lang/String;)Z
    //   289: ifeq +61 -> 350
    //   292: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq -122 -> 173
    //   298: aload 24
    //   300: astore_1
    //   301: aload 24
    //   303: ifnonnull +11 -> 314
    //   306: new 153	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   313: astore_1
    //   314: aload_1
    //   315: ldc_w 475
    //   318: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 23
    //   323: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 477
    //   329: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 25
    //   334: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 605
    //   340: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: astore 24
    //   347: goto -174 -> 173
    //   350: aload_0
    //   351: iload 13
    //   353: invokeinterface 401 2 0
    //   358: lstore 18
    //   360: aload_0
    //   361: iload 14
    //   363: invokeinterface 401 2 0
    //   368: lstore 20
    //   370: new 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   373: dup
    //   374: invokespecial 412	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   377: astore 26
    //   379: aload 26
    //   381: aload_0
    //   382: iload 11
    //   384: invokeinterface 401 2 0
    //   389: putfield 414	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   392: aload 26
    //   394: aload 25
    //   396: putfield 119	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   399: aload 26
    //   401: aload 23
    //   403: putfield 422	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   406: aload 26
    //   408: lload 18
    //   410: putfield 417	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   413: aload 26
    //   415: lload 20
    //   417: putfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   420: aload 26
    //   422: aload_0
    //   423: iload 15
    //   425: invokeinterface 401 2 0
    //   430: putfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   433: aload 26
    //   435: aload_0
    //   436: iload 17
    //   438: invokeinterface 401 2 0
    //   443: putfield 425	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   446: iload 4
    //   448: ifeq +243 -> 691
    //   451: aload 26
    //   453: aload_0
    //   454: iload 8
    //   456: invokeinterface 407 2 0
    //   461: putfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   464: aload 26
    //   466: aload_0
    //   467: iload 7
    //   469: invokeinterface 407 2 0
    //   474: putfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   477: aload 26
    //   479: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   482: lconst_0
    //   483: lcmp
    //   484: ifne +50 -> 534
    //   487: new 115	android/media/MediaMetadataRetriever
    //   490: dup
    //   491: invokespecial 116	android/media/MediaMetadataRetriever:<init>	()V
    //   494: astore 23
    //   496: aload 23
    //   498: astore_1
    //   499: aload 23
    //   501: aload 25
    //   503: invokevirtual 122	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   506: aload 23
    //   508: astore_1
    //   509: aload 26
    //   511: aload 23
    //   513: bipush 9
    //   515: invokevirtual 126	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   518: invokestatic 132	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   521: putfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   524: aload 23
    //   526: ifnull +8 -> 534
    //   529: aload 23
    //   531: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   534: lload 5
    //   536: lconst_0
    //   537: lcmp
    //   538: ifle +14 -> 552
    //   541: aload 26
    //   543: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   546: lload 5
    //   548: lcmp
    //   549: ifgt -376 -> 173
    //   552: aload 22
    //   554: aload 26
    //   556: invokeinterface 287 2 0
    //   561: pop
    //   562: iload 9
    //   564: iconst_1
    //   565: iadd
    //   566: istore 10
    //   568: getstatic 403	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sLastModify	J
    //   571: lload 20
    //   573: lcmp
    //   574: ifge +8 -> 582
    //   577: lload 20
    //   579: putstatic 403	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sLastModify	J
    //   582: iload 10
    //   584: istore 9
    //   586: iload_2
    //   587: ifle -414 -> 173
    //   590: iload 10
    //   592: istore 9
    //   594: iload 10
    //   596: iload_2
    //   597: if_icmplt -424 -> 173
    //   600: aload 22
    //   602: astore_0
    //   603: aload 24
    //   605: ifnull -557 -> 48
    //   608: aload 22
    //   610: astore_0
    //   611: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq -566 -> 48
    //   617: ldc 17
    //   619: iconst_2
    //   620: aload 24
    //   622: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 22
    //   630: areturn
    //   631: astore 25
    //   633: aconst_null
    //   634: astore 23
    //   636: aload 23
    //   638: astore_1
    //   639: aload 25
    //   641: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   644: aload 23
    //   646: astore_1
    //   647: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +15 -> 665
    //   653: aload 23
    //   655: astore_1
    //   656: ldc 17
    //   658: iconst_2
    //   659: ldc_w 607
    //   662: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload 23
    //   667: ifnull -133 -> 534
    //   670: aload 23
    //   672: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   675: goto -141 -> 534
    //   678: astore_0
    //   679: aconst_null
    //   680: astore_1
    //   681: aload_1
    //   682: ifnull +7 -> 689
    //   685: aload_1
    //   686: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   689: aload_0
    //   690: athrow
    //   691: new 115	android/media/MediaMetadataRetriever
    //   694: dup
    //   695: invokespecial 116	android/media/MediaMetadataRetriever:<init>	()V
    //   698: astore_1
    //   699: aload_1
    //   700: aload 25
    //   702: invokevirtual 122	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   705: aload_1
    //   706: bipush 18
    //   708: invokevirtual 126	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   711: astore 23
    //   713: aload_1
    //   714: bipush 19
    //   716: invokevirtual 126	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   719: astore 25
    //   721: aload_1
    //   722: invokevirtual 141	android/media/MediaMetadataRetriever:release	()V
    //   725: aload 26
    //   727: aload 23
    //   729: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   732: putfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   735: aload 26
    //   737: aload 25
    //   739: invokestatic 138	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   742: putfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   745: goto -211 -> 534
    //   748: astore_1
    //   749: aload 26
    //   751: iconst_0
    //   752: putfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   755: aload 26
    //   757: iconst_0
    //   758: putfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   761: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   764: ifeq -230 -> 534
    //   767: ldc 17
    //   769: iconst_2
    //   770: ldc_w 609
    //   773: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: goto -242 -> 534
    //   779: astore_0
    //   780: goto -99 -> 681
    //   783: astore 25
    //   785: goto -149 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	paramCursor	Cursor
    //   0	788	1	paramList	List<LocalMediaInfo>
    //   0	788	2	paramInt	int
    //   0	788	3	paramMediaFileFilter	MediaFileFilter
    //   0	788	4	paramBoolean	boolean
    //   0	788	5	paramLong	long
    //   6	462	7	i	int
    //   137	318	8	j	int
    //   168	425	9	k	int
    //   566	32	10	m	int
    //   74	309	11	n	int
    //   84	100	12	i1	int
    //   94	258	13	i2	int
    //   104	258	14	i3	int
    //   114	310	15	i4	int
    //   124	147	16	i5	int
    //   134	303	17	i6	int
    //   358	51	18	l1	long
    //   368	210	20	l2	long
    //   51	578	22	localObject1	Object
    //   234	494	23	localObject2	Object
    //   171	450	24	localList	List<LocalMediaInfo>
    //   190	312	25	str1	String
    //   631	70	25	localException1	java.lang.Exception
    //   719	19	25	str2	String
    //   783	1	25	localException2	java.lang.Exception
    //   377	379	26	localLocalMediaInfo	LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   487	496	631	java/lang/Exception
    //   487	496	678	finally
    //   725	745	748	java/lang/NumberFormatException
    //   499	506	779	finally
    //   509	524	779	finally
    //   639	644	779	finally
    //   647	653	779	finally
    //   656	665	779	finally
    //   499	506	783	java/lang/Exception
    //   509	524	783	java/lang/Exception
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
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        pathWHMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
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
  
  private static Cursor queryImages(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
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
  
  /* Error */
  private static List<LocalMediaInfo> queryImages(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 328	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 329	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 510	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 41	android/os/Build$VERSION:SDK_INT	I
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
    //   42: invokestatic 640	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 212 1 0
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
    //   71: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +17 -> 91
    //   77: aload_0
    //   78: astore 5
    //   80: ldc 17
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: aload_1
    //   88: invokestatic 519	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_0
    //   92: ifnull -37 -> 55
    //   95: aload_0
    //   96: invokeinterface 212 1 0
    //   101: aload 7
    //   103: areturn
    //   104: astore_1
    //   105: aload 5
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +9 -> 118
    //   112: aload_0
    //   113: invokeinterface 212 1 0
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
  public static List<LocalMediaInfo> queryRecentImages(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, boolean paramBoolean1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 9
    //   5: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 17
    //   13: iconst_2
    //   14: new 153	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 643
    //   24: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 9
    //   29: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 12
    //   41: new 328	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 329	java/util/ArrayList:<init>	()V
    //   48: astore 13
    //   50: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 16
    //   55: if_icmplt +339 -> 394
    //   58: iconst_1
    //   59: istore 8
    //   61: iload 8
    //   63: ifeq +148 -> 211
    //   66: iload 4
    //   68: ifeq +135 -> 203
    //   71: ldc_w 645
    //   74: astore 11
    //   76: aload_0
    //   77: aload 11
    //   79: iconst_3
    //   80: anewarray 43	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: iload 5
    //   87: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: iload_1
    //   94: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: iload_1
    //   101: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: aastore
    //   105: iload_2
    //   106: invokestatic 510	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   109: astore_0
    //   110: aload_0
    //   111: aload 13
    //   113: iload_1
    //   114: iload_2
    //   115: iload 8
    //   117: aload_3
    //   118: aload 6
    //   120: iload 7
    //   122: invokestatic 338	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   125: aload_0
    //   126: ifnull +9 -> 135
    //   129: aload_0
    //   130: invokeinterface 212 1 0
    //   135: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +62 -> 200
    //   141: new 153	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 647
    //   151: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
    //   157: lload 9
    //   159: lsub
    //   160: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   163: ldc_w 649
    //   166: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: astore_3
    //   170: aload 13
    //   172: ifnull +191 -> 363
    //   175: aload 13
    //   177: invokeinterface 260 1 0
    //   182: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: astore_0
    //   186: ldc 17
    //   188: iconst_2
    //   189: aload_3
    //   190: aload_0
    //   191: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload 13
    //   202: areturn
    //   203: ldc_w 651
    //   206: astore 11
    //   208: goto -132 -> 76
    //   211: iload 5
    //   213: ifle +93 -> 306
    //   216: new 153	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 521
    //   226: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 5
    //   231: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 653
    //   237: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 47
    //   242: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore 11
    //   250: getstatic 530	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   253: invokevirtual 536	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   256: astore 14
    //   258: iload_2
    //   259: ifle +19 -> 278
    //   262: aload 14
    //   264: ldc_w 538
    //   267: iload_2
    //   268: bipush 6
    //   270: imul
    //   271: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   274: invokevirtual 544	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   277: pop
    //   278: aload 14
    //   280: invokevirtual 548	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   283: astore 14
    //   285: aload_0
    //   286: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   289: aload 14
    //   291: getstatic 71	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:columns	[Ljava/lang/String;
    //   294: aload 11
    //   296: aconst_null
    //   297: ldc 11
    //   299: invokevirtual 203	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   302: astore_0
    //   303: goto -193 -> 110
    //   306: ldc_w 655
    //   309: astore 11
    //   311: goto -61 -> 250
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_0
    //   317: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +14 -> 334
    //   323: ldc 17
    //   325: iconst_2
    //   326: aload_3
    //   327: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   330: aload_3
    //   331: invokestatic 519	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload_0
    //   335: ifnull -200 -> 135
    //   338: aload_0
    //   339: invokeinterface 212 1 0
    //   344: goto -209 -> 135
    //   347: astore_0
    //   348: aload 12
    //   350: astore_3
    //   351: aload_3
    //   352: ifnull +9 -> 361
    //   355: aload_3
    //   356: invokeinterface 212 1 0
    //   361: aload_0
    //   362: athrow
    //   363: ldc_w 277
    //   366: astore_0
    //   367: goto -181 -> 186
    //   370: astore 6
    //   372: aload_0
    //   373: astore_3
    //   374: aload 6
    //   376: astore_0
    //   377: goto -26 -> 351
    //   380: astore 6
    //   382: aload_0
    //   383: astore_3
    //   384: aload 6
    //   386: astore_0
    //   387: goto -36 -> 351
    //   390: astore_3
    //   391: goto -74 -> 317
    //   394: iconst_0
    //   395: istore 8
    //   397: goto -336 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	paramContext	Context
    //   0	400	1	paramInt1	int
    //   0	400	2	paramInt2	int
    //   0	400	3	paramMediaFileFilter	MediaFileFilter
    //   0	400	4	paramBoolean1	boolean
    //   0	400	5	paramInt3	int
    //   0	400	6	paramArrayList	ArrayList<String>
    //   0	400	7	paramBoolean2	boolean
    //   59	337	8	bool	boolean
    //   3	155	9	l	long
    //   74	236	11	str	String
    //   39	310	12	localObject1	Object
    //   48	153	13	localArrayList	ArrayList
    //   256	34	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   76	110	314	java/lang/Exception
    //   216	250	314	java/lang/Exception
    //   250	258	314	java/lang/Exception
    //   262	278	314	java/lang/Exception
    //   278	303	314	java/lang/Exception
    //   76	110	347	finally
    //   216	250	347	finally
    //   250	258	347	finally
    //   262	278	347	finally
    //   278	303	347	finally
    //   110	125	370	finally
    //   317	334	380	finally
    //   110	125	390	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentVideos(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 17
    //   13: iconst_2
    //   14: new 153	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 658
    //   24: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 6
    //   29: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 9
    //   41: new 328	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 329	java/util/ArrayList:<init>	()V
    //   48: astore 11
    //   50: getstatic 197	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 536	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 10
    //   58: iload_2
    //   59: ifle +19 -> 78
    //   62: aload 10
    //   64: ldc_w 538
    //   67: iload_2
    //   68: bipush 6
    //   70: imul
    //   71: invokestatic 507	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: invokevirtual 544	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   77: pop
    //   78: aload 10
    //   80: invokevirtual 548	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   83: astore 10
    //   85: aload_0
    //   86: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   89: aload 10
    //   91: getstatic 63	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   94: ldc_w 655
    //   97: aconst_null
    //   98: ldc 11
    //   100: invokevirtual 203	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_0
    //   104: aload_0
    //   105: astore 9
    //   107: aload 9
    //   109: astore_0
    //   110: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   113: bipush 16
    //   115: if_icmplt +188 -> 303
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
    //   134: invokestatic 333	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   137: pop
    //   138: aload 9
    //   140: ifnull +10 -> 150
    //   143: aload 9
    //   145: invokeinterface 212 1 0
    //   150: invokestatic 562	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   153: invokestatic 568	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +212 -> 370
    //   161: aload_0
    //   162: iconst_1
    //   163: bipush 100
    //   165: invokevirtual 572	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +200 -> 370
    //   173: aload_0
    //   174: invokevirtual 368	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   177: astore_0
    //   178: aload_0
    //   179: invokeinterface 373 1 0
    //   184: ifeq +186 -> 370
    //   187: aload_0
    //   188: invokeinterface 377 1 0
    //   193: checkcast 574	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   196: astore 9
    //   198: new 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   201: dup
    //   202: invokespecial 412	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   205: astore 10
    //   207: aload 10
    //   209: aload 9
    //   211: getfield 577	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   214: i2l
    //   215: putfield 414	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   218: aload 10
    //   220: aload 9
    //   222: getfield 579	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   225: putfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   228: aload 10
    //   230: aload 9
    //   232: getfield 580	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   235: putfield 425	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   238: aload 10
    //   240: aload 9
    //   242: getfield 581	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   245: putfield 119	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   248: aload 10
    //   250: aload 9
    //   252: getfield 582	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   255: putfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   258: aload 10
    //   260: aload 9
    //   262: getfield 585	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   265: putfield 422	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   268: aload 10
    //   270: iconst_0
    //   271: putfield 588	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   274: aload_3
    //   275: ifnull +15 -> 290
    //   278: aload_3
    //   279: aload 9
    //   281: getfield 585	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   284: invokevirtual 384	com/tencent/mobileqq/activity/photo/MediaFileFilter:filter	(Ljava/lang/String;)Z
    //   287: ifne -109 -> 178
    //   290: aload 11
    //   292: aload 10
    //   294: invokeinterface 287 2 0
    //   299: pop
    //   300: goto -122 -> 178
    //   303: iconst_0
    //   304: istore 8
    //   306: goto -185 -> 121
    //   309: astore 10
    //   311: aconst_null
    //   312: astore 9
    //   314: aload 9
    //   316: astore_0
    //   317: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +19 -> 339
    //   323: aload 9
    //   325: astore_0
    //   326: ldc 17
    //   328: iconst_2
    //   329: aload 10
    //   331: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: aload 10
    //   336: invokestatic 519	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload 9
    //   341: ifnull -191 -> 150
    //   344: aload 9
    //   346: invokeinterface 212 1 0
    //   351: goto -201 -> 150
    //   354: astore_0
    //   355: aload 9
    //   357: astore_3
    //   358: aload_3
    //   359: ifnull +9 -> 368
    //   362: aload_3
    //   363: invokeinterface 212 1 0
    //   368: aload_0
    //   369: athrow
    //   370: aload 11
    //   372: invokestatic 247	java/util/Collections:sort	(Ljava/util/List;)V
    //   375: new 328	java/util/ArrayList
    //   378: dup
    //   379: invokespecial 329	java/util/ArrayList:<init>	()V
    //   382: astore_3
    //   383: iload_2
    //   384: ifle +44 -> 428
    //   387: iload_2
    //   388: aload 11
    //   390: invokeinterface 260 1 0
    //   395: invokestatic 293	java/lang/Math:min	(II)I
    //   398: istore_1
    //   399: iconst_0
    //   400: istore_2
    //   401: iload_2
    //   402: iload_1
    //   403: if_icmpge +36 -> 439
    //   406: aload_3
    //   407: aload 11
    //   409: iload_2
    //   410: invokeinterface 281 2 0
    //   415: invokeinterface 287 2 0
    //   420: pop
    //   421: iload_2
    //   422: iconst_1
    //   423: iadd
    //   424: istore_2
    //   425: goto -24 -> 401
    //   428: aload 11
    //   430: invokeinterface 260 1 0
    //   435: istore_1
    //   436: goto -37 -> 399
    //   439: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +62 -> 504
    //   445: new 153	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   452: ldc_w 660
    //   455: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
    //   461: lload 6
    //   463: lsub
    //   464: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   467: ldc_w 662
    //   470: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: astore 9
    //   475: aload_3
    //   476: ifnull +30 -> 506
    //   479: aload_3
    //   480: invokeinterface 260 1 0
    //   485: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   488: astore_0
    //   489: ldc 17
    //   491: iconst_2
    //   492: aload 9
    //   494: aload_0
    //   495: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload_3
    //   505: areturn
    //   506: ldc_w 277
    //   509: astore_0
    //   510: goto -21 -> 489
    //   513: astore 9
    //   515: aload_0
    //   516: astore_3
    //   517: aload 9
    //   519: astore_0
    //   520: goto -162 -> 358
    //   523: astore 10
    //   525: goto -211 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	paramContext	Context
    //   0	528	1	paramInt1	int
    //   0	528	2	paramInt2	int
    //   0	528	3	paramMediaFileFilter	MediaFileFilter
    //   0	528	4	paramLong	long
    //   3	459	6	l	long
    //   119	186	8	bool	boolean
    //   39	454	9	localObject1	Object
    //   513	5	9	localObject2	Object
    //   56	237	10	localObject3	Object
    //   309	26	10	localException1	java.lang.Exception
    //   523	1	10	localException2	java.lang.Exception
    //   48	381	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	58	309	java/lang/Exception
    //   62	78	309	java/lang/Exception
    //   78	104	309	java/lang/Exception
    //   50	58	354	finally
    //   62	78	354	finally
    //   78	104	354	finally
    //   110	118	513	finally
    //   124	138	513	finally
    //   317	323	513	finally
    //   326	339	513	finally
    //   110	118	523	java/lang/Exception
    //   124	138	523	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil
 * JD-Core Version:    0.7.0.1
 */