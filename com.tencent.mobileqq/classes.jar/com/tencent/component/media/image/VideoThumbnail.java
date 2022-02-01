package com.tencent.component.media.image;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.tencent.component.media.MediaFile;
import com.tencent.component.media.MediaFile.MediaFileType;
import java.io.File;

public class VideoThumbnail
{
  private static final String FILE_URL_PREFIX = "file://";
  private static final String[] PROJECTION_VIDEO = { "DISTINCT _id", "_data" };
  private static final String TAG = "VideoThumbnail";
  
  private static Bitmap createVideoThumbnail(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return getFirstKeyFrame(paramString);
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static Bitmap getFirstKeyFrame(String paramString)
  {
    // Byte code:
    //   0: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 10
    //   5: if_icmple +162 -> 167
    //   8: new 47	android/media/MediaMetadataRetriever
    //   11: dup
    //   12: invokespecial 48	android/media/MediaMetadataRetriever:<init>	()V
    //   15: astore 6
    //   17: aload 6
    //   19: aload_0
    //   20: invokevirtual 52	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload 6
    //   25: ldc2_w 53
    //   28: iconst_2
    //   29: invokevirtual 58	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   32: astore_0
    //   33: aload_0
    //   34: astore 5
    //   36: aload_0
    //   37: ifnull +67 -> 104
    //   40: aload_0
    //   41: invokevirtual 64	android/graphics/Bitmap:getWidth	()I
    //   44: istore_2
    //   45: aload_0
    //   46: invokevirtual 67	android/graphics/Bitmap:getHeight	()I
    //   49: istore_3
    //   50: iload_2
    //   51: iload_3
    //   52: invokestatic 73	java/lang/Math:max	(II)I
    //   55: istore 4
    //   57: aload_0
    //   58: astore 5
    //   60: iload 4
    //   62: sipush 512
    //   65: if_icmple +39 -> 104
    //   68: ldc 74
    //   70: iload 4
    //   72: i2f
    //   73: fdiv
    //   74: fstore_1
    //   75: aload_0
    //   76: iload_2
    //   77: i2f
    //   78: fload_1
    //   79: fmul
    //   80: invokestatic 78	java/lang/Math:round	(F)I
    //   83: fload_1
    //   84: iload_3
    //   85: i2f
    //   86: fmul
    //   87: invokestatic 78	java/lang/Math:round	(F)I
    //   90: iconst_1
    //   91: invokestatic 82	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   94: astore 5
    //   96: goto +8 -> 104
    //   99: astore 5
    //   101: goto +27 -> 128
    //   104: aload 6
    //   106: invokevirtual 85	android/media/MediaMetadataRetriever:release	()V
    //   109: aload 5
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 88	java/lang/RuntimeException:printStackTrace	()V
    //   117: aload 5
    //   119: areturn
    //   120: astore_0
    //   121: goto +29 -> 150
    //   124: astore 5
    //   126: aconst_null
    //   127: astore_0
    //   128: aload 5
    //   130: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   133: aload 6
    //   135: invokevirtual 85	android/media/MediaMetadataRetriever:release	()V
    //   138: goto +10 -> 148
    //   141: astore 5
    //   143: aload 5
    //   145: invokevirtual 88	java/lang/RuntimeException:printStackTrace	()V
    //   148: aload_0
    //   149: areturn
    //   150: aload 6
    //   152: invokevirtual 85	android/media/MediaMetadataRetriever:release	()V
    //   155: goto +10 -> 165
    //   158: astore 5
    //   160: aload 5
    //   162: invokevirtual 88	java/lang/RuntimeException:printStackTrace	()V
    //   165: aload_0
    //   166: athrow
    //   167: aconst_null
    //   168: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   74	10	1	f	float
    //   44	33	2	i	int
    //   49	36	3	j	int
    //   55	16	4	k	int
    //   34	61	5	localObject	Object
    //   99	19	5	localThrowable1	Throwable
    //   124	5	5	localThrowable2	Throwable
    //   141	3	5	localRuntimeException1	java.lang.RuntimeException
    //   158	3	5	localRuntimeException2	java.lang.RuntimeException
    //   15	136	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   40	57	99	java/lang/Throwable
    //   68	96	99	java/lang/Throwable
    //   104	109	112	java/lang/RuntimeException
    //   17	33	120	finally
    //   40	57	120	finally
    //   68	96	120	finally
    //   128	133	120	finally
    //   17	33	124	java/lang/Throwable
    //   133	138	141	java/lang/RuntimeException
    //   150	155	158	java/lang/RuntimeException
  }
  
  public static BitmapReference getThumb(Context paramContext, String paramString)
  {
    try
    {
      localBitmap2 = createVideoThumbnail(paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null) {}
    }
    catch (Throwable paramContext)
    {
      label20:
      label22:
      break label20;
    }
    try
    {
      localBitmap1 = queryVideoThumbnail(paramContext, paramString);
    }
    catch (Throwable paramContext)
    {
      localBitmap1 = localBitmap2;
      break label22;
    }
    localBitmap1 = null;
    return BitmapReference.getBitmapReference(localBitmap1);
  }
  
  public static boolean isVideo(String paramString)
  {
    paramString = MediaFile.getFileType(paramString);
    return (paramString != null) && (MediaFile.isVideoFileType(paramString.fileType));
  }
  
  private static String processPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (paramString.startsWith("file://")) {
      str = paramString.substring(7);
    }
    paramString = str;
    if (!str.startsWith(File.separator))
    {
      paramString = new StringBuilder();
      paramString.append(File.separator);
      paramString.append(str);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private static Bitmap queryVideoThumbnail(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramContext != null)
    {
      if (Build.VERSION.SDK_INT < 5) {
        return null;
      }
      try
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("_data='");
        ((StringBuilder)localObject3).append(processPath(paramString));
        ((StringBuilder)localObject3).append("' COLLATE NOCASE");
        paramString = ((StringBuilder)localObject3).toString();
        localObject3 = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, paramString, null, null);
        paramString = localObject2;
        if (localObject3 != null)
        {
          paramString = localObject2;
          try
          {
            if (((Cursor)localObject3).getCount() > 0)
            {
              int i = ((Cursor)localObject3).getColumnIndexOrThrow("_id");
              paramString = localObject2;
              if (((Cursor)localObject3).moveToFirst())
              {
                long l = ((Cursor)localObject3).getLong(i);
                paramString = MediaStore.Video.Thumbnails.getThumbnail(paramContext.getContentResolver(), l, 1, null);
              }
            }
          }
          finally
          {
            paramContext = (Context)localObject3;
            break label170;
          }
        }
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        return paramString;
      }
      finally
      {
        paramContext = localObject1;
        label170:
        if (paramContext != null) {
          paramContext.close();
        }
      }
    }
    return null;
  }
  
  /* Error */
  private static String queryVideoThumbnailFilePath(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 8
    //   12: new 143	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: ldc 210
    //   25: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: lload_1
    //   32: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: aload_0
    //   44: invokevirtual 164	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   47: getstatic 214	android/provider/MediaStore$Video$Thumbnails:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   50: iconst_2
    //   51: anewarray 17	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc 216
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: ldc 21
    //   63: aastore
    //   64: aload 5
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 176	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 5
    //   73: aload 8
    //   75: astore_0
    //   76: aload 5
    //   78: ifnull +79 -> 157
    //   81: aload 8
    //   83: astore_0
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: invokeinterface 181 1 0
    //   95: ifle +62 -> 157
    //   98: aload 5
    //   100: astore 4
    //   102: aload 5
    //   104: ldc 21
    //   106: invokeinterface 187 2 0
    //   111: istore_3
    //   112: aload 8
    //   114: astore_0
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: invokeinterface 191 1 0
    //   126: ifeq +31 -> 157
    //   129: aload 5
    //   131: astore 4
    //   133: aload 5
    //   135: iload_3
    //   136: invokeinterface 219 2 0
    //   141: astore_0
    //   142: goto +15 -> 157
    //   145: astore 4
    //   147: aload 5
    //   149: astore_0
    //   150: aload 4
    //   152: astore 5
    //   154: goto +32 -> 186
    //   157: aload_0
    //   158: astore 4
    //   160: aload 5
    //   162: ifnull +97 -> 259
    //   165: aload_0
    //   166: astore 4
    //   168: aload 5
    //   170: invokeinterface 204 1 0
    //   175: aload 4
    //   177: areturn
    //   178: astore_0
    //   179: goto +84 -> 263
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_0
    //   187: astore 4
    //   189: getstatic 221	com/tencent/component/media/image/VideoThumbnail:TAG	Ljava/lang/String;
    //   192: astore 8
    //   194: aload_0
    //   195: astore 4
    //   197: new 143	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   204: astore 9
    //   206: aload_0
    //   207: astore 4
    //   209: aload 9
    //   211: ldc 223
    //   213: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_0
    //   218: astore 4
    //   220: aload 9
    //   222: aload 5
    //   224: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_0
    //   229: astore 4
    //   231: aload 8
    //   233: aload 9
    //   235: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 232	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 7
    //   243: astore 4
    //   245: aload_0
    //   246: ifnull +13 -> 259
    //   249: aload 6
    //   251: astore 4
    //   253: aload_0
    //   254: astore 5
    //   256: goto -88 -> 168
    //   259: aload 4
    //   261: areturn
    //   262: astore_0
    //   263: aload 4
    //   265: ifnull +10 -> 275
    //   268: aload 4
    //   270: invokeinterface 204 1 0
    //   275: goto +5 -> 280
    //   278: aload_0
    //   279: athrow
    //   280: goto -2 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramContext	Context
    //   0	283	1	paramLong	long
    //   111	25	3	i	int
    //   7	125	4	localObject1	Object
    //   145	6	4	localException1	java.lang.Exception
    //   158	111	4	localObject2	Object
    //   19	150	5	localObject3	Object
    //   182	41	5	localException2	java.lang.Exception
    //   254	1	5	localContext	Context
    //   1	249	6	localObject4	Object
    //   4	238	7	localObject5	Object
    //   10	222	8	str	String
    //   204	30	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   88	98	145	java/lang/Exception
    //   102	112	145	java/lang/Exception
    //   119	129	145	java/lang/Exception
    //   133	142	145	java/lang/Exception
    //   12	73	178	finally
    //   12	73	182	java/lang/Exception
    //   88	98	262	finally
    //   102	112	262	finally
    //   119	129	262	finally
    //   133	142	262	finally
    //   189	194	262	finally
    //   197	206	262	finally
    //   209	217	262	finally
    //   220	228	262	finally
    //   231	241	262	finally
  }
  
  /* Error */
  public static String queryVideoThumbnailFilePath(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: ifnull +249 -> 259
    //   13: getstatic 35	android/os/Build$VERSION:SDK_INT	I
    //   16: iconst_5
    //   17: if_icmpge +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 143	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc 154
    //   33: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: aload_1
    //   39: invokestatic 156	com/tencent/component/media/image/VideoThumbnail:processPath	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: ldc 158
    //   49: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 164	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   62: getstatic 170	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   65: getstatic 23	com/tencent/component/media/image/VideoThumbnail:PROJECTION_VIDEO	[Ljava/lang/String;
    //   68: aload_1
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 176	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 4
    //   76: aload 7
    //   78: astore_1
    //   79: aload 4
    //   81: ifnull +74 -> 155
    //   84: aload 7
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: invokeinterface 181 1 0
    //   97: ifle +58 -> 155
    //   100: aload 4
    //   102: astore_3
    //   103: aload 4
    //   105: ldc 183
    //   107: invokeinterface 187 2 0
    //   112: istore_2
    //   113: aload 7
    //   115: astore_1
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokeinterface 191 1 0
    //   126: ifeq +29 -> 155
    //   129: aload 4
    //   131: astore_3
    //   132: aload_0
    //   133: aload 4
    //   135: iload_2
    //   136: invokeinterface 195 2 0
    //   141: invokestatic 235	com/tencent/component/media/image/VideoThumbnail:queryVideoThumbnailFilePath	(Landroid/content/Context;J)Ljava/lang/String;
    //   144: astore_1
    //   145: goto +10 -> 155
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: goto +30 -> 182
    //   155: aload_1
    //   156: astore_3
    //   157: aload 4
    //   159: ifnull +85 -> 244
    //   162: aload 4
    //   164: astore_0
    //   165: aload_0
    //   166: invokeinterface 204 1 0
    //   171: aload_1
    //   172: areturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_3
    //   176: goto +71 -> 247
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_0
    //   183: astore_3
    //   184: getstatic 221	com/tencent/component/media/image/VideoThumbnail:TAG	Ljava/lang/String;
    //   187: astore 4
    //   189: aload_0
    //   190: astore_3
    //   191: new 143	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   198: astore 7
    //   200: aload_0
    //   201: astore_3
    //   202: aload 7
    //   204: ldc 223
    //   206: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: astore_3
    //   212: aload 7
    //   214: aload_1
    //   215: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_0
    //   220: astore_3
    //   221: aload 4
    //   223: aload 7
    //   225: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 232	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 6
    //   233: astore_3
    //   234: aload_0
    //   235: ifnull +9 -> 244
    //   238: aload 5
    //   240: astore_1
    //   241: goto -76 -> 165
    //   244: aload_3
    //   245: areturn
    //   246: astore_0
    //   247: aload_3
    //   248: ifnull +9 -> 257
    //   251: aload_3
    //   252: invokeinterface 204 1 0
    //   257: aload_0
    //   258: athrow
    //   259: aconst_null
    //   260: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   0	261	1	paramString	String
    //   112	24	2	i	int
    //   29	223	3	localObject1	Object
    //   74	148	4	localObject2	Object
    //   1	238	5	localObject3	Object
    //   4	228	6	localObject4	Object
    //   7	217	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   90	100	148	java/lang/Throwable
    //   103	113	148	java/lang/Throwable
    //   119	129	148	java/lang/Throwable
    //   132	145	148	java/lang/Throwable
    //   22	76	173	finally
    //   22	76	179	java/lang/Throwable
    //   90	100	246	finally
    //   103	113	246	finally
    //   119	129	246	finally
    //   132	145	246	finally
    //   184	189	246	finally
    //   191	200	246	finally
    //   202	210	246	finally
    //   212	219	246	finally
    //   221	231	246	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.VideoThumbnail
 * JD-Core Version:    0.7.0.1
 */