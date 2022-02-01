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
  private static final String TAG = VideoThumbnail.class.getSimpleName();
  
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 10
    //   11: if_icmple +96 -> 107
    //   14: new 53	android/media/MediaMetadataRetriever
    //   17: dup
    //   18: invokespecial 54	android/media/MediaMetadataRetriever:<init>	()V
    //   21: astore 7
    //   23: aload 7
    //   25: aload_0
    //   26: invokevirtual 58	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   29: aload 7
    //   31: ldc2_w 59
    //   34: iconst_2
    //   35: invokevirtual 64	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +128 -> 168
    //   43: aload_0
    //   44: invokevirtual 70	android/graphics/Bitmap:getWidth	()I
    //   47: istore_2
    //   48: aload_0
    //   49: invokevirtual 73	android/graphics/Bitmap:getHeight	()I
    //   52: istore_3
    //   53: iload_2
    //   54: iload_3
    //   55: invokestatic 79	java/lang/Math:max	(II)I
    //   58: istore 4
    //   60: iload 4
    //   62: sipush 512
    //   65: if_icmple +103 -> 168
    //   68: ldc 80
    //   70: iload 4
    //   72: i2f
    //   73: fdiv
    //   74: fstore_1
    //   75: aload_0
    //   76: iload_2
    //   77: i2f
    //   78: fload_1
    //   79: fmul
    //   80: invokestatic 84	java/lang/Math:round	(F)I
    //   83: iload_3
    //   84: i2f
    //   85: fload_1
    //   86: fmul
    //   87: invokestatic 84	java/lang/Math:round	(F)I
    //   90: iconst_1
    //   91: invokestatic 88	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   94: astore 5
    //   96: aload 5
    //   98: astore_0
    //   99: aload 7
    //   101: invokevirtual 91	android/media/MediaMetadataRetriever:release	()V
    //   104: aload_0
    //   105: astore 5
    //   107: aload 5
    //   109: areturn
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 94	java/lang/RuntimeException:printStackTrace	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore 5
    //   121: aload 6
    //   123: astore_0
    //   124: aload 5
    //   126: invokevirtual 95	java/lang/Throwable:printStackTrace	()V
    //   129: aload 7
    //   131: invokevirtual 91	android/media/MediaMetadataRetriever:release	()V
    //   134: aload_0
    //   135: areturn
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 94	java/lang/RuntimeException:printStackTrace	()V
    //   143: aload_0
    //   144: areturn
    //   145: astore_0
    //   146: aload 7
    //   148: invokevirtual 91	android/media/MediaMetadataRetriever:release	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 94	java/lang/RuntimeException:printStackTrace	()V
    //   160: goto -9 -> 151
    //   163: astore 5
    //   165: goto -41 -> 124
    //   168: goto -69 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramString	String
    //   74	12	1	f	float
    //   47	30	2	i	int
    //   52	32	3	j	int
    //   58	13	4	k	int
    //   4	104	5	localObject1	Object
    //   110	3	5	localRuntimeException1	java.lang.RuntimeException
    //   119	6	5	localThrowable1	Throwable
    //   136	3	5	localRuntimeException2	java.lang.RuntimeException
    //   153	3	5	localRuntimeException3	java.lang.RuntimeException
    //   163	1	5	localThrowable2	Throwable
    //   1	121	6	localObject2	Object
    //   21	126	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   99	104	110	java/lang/RuntimeException
    //   23	39	119	java/lang/Throwable
    //   129	134	136	java/lang/RuntimeException
    //   23	39	145	finally
    //   43	60	145	finally
    //   68	96	145	finally
    //   124	129	145	finally
    //   146	151	153	java/lang/RuntimeException
    //   43	60	163	java/lang/Throwable
    //   68	96	163	java/lang/Throwable
  }
  
  public static BitmapReference getThumb(Context paramContext, String paramString)
  {
    localObject = null;
    try
    {
      Bitmap localBitmap = createVideoThumbnail(paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        paramContext = queryVideoThumbnail(paramContext, paramString);
        localObject = paramContext;
      }
      paramContext = (Context)localObject;
      if (localObject != null) {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
    return BitmapReference.getBitmapReference(paramContext);
  }
  
  public static boolean isVideo(String paramString)
  {
    paramString = MediaFile.getFileType(paramString);
    return (paramString != null) && (MediaFile.isVideoFileType(paramString.fileType));
  }
  
  private static String processPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.startsWith("file://")) {
        str = paramString.substring("file://".length());
      }
      paramString = str;
    } while (str.startsWith(File.separator));
    return File.separator + str;
  }
  
  private static Bitmap queryVideoThumbnail(Context paramContext, String paramString)
  {
    Object localObject = null;
    if ((paramContext == null) || (Build.VERSION.SDK_INT < 5))
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        paramString = "_data='" + processPath(paramString) + "' COLLATE NOCASE";
        localCursor = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, paramString, null, null);
        if (localCursor == null) {}
      }
      finally
      {
        try
        {
          if (localCursor.getCount() <= 0) {
            break label158;
          }
          int i = localCursor.getColumnIndexOrThrow("_id");
          if (!localCursor.moveToFirst()) {
            break label158;
          }
          long l = localCursor.getLong(i);
          paramContext = MediaStore.Video.Thumbnails.getThumbnail(paramContext.getContentResolver(), l, 1, null);
          paramString = paramContext;
          if (localCursor == null) {
            break;
          }
          localCursor.close();
          return paramContext;
        }
        finally
        {
          Cursor localCursor;
          paramString = localCursor;
        }
        paramContext = finally;
        paramString = localObject;
        if (paramString != null) {
          paramString.close();
        }
      }
      label158:
      paramContext = null;
    }
  }
  
  /* Error */
  private static String queryVideoThumbnailFilePath(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 152	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   10: ldc 218
    //   12: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_1
    //   16: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 5
    //   24: aload_0
    //   25: invokevirtual 172	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: getstatic 222	android/provider/MediaStore$Video$Thumbnails:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   31: iconst_2
    //   32: anewarray 23	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 224
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: ldc 27
    //   44: aastore
    //   45: aload 5
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +139 -> 193
    //   57: aload_0
    //   58: astore 4
    //   60: aload_0
    //   61: invokeinterface 189 1 0
    //   66: ifle +127 -> 193
    //   69: aload_0
    //   70: astore 4
    //   72: aload_0
    //   73: ldc 27
    //   75: invokeinterface 195 2 0
    //   80: istore_3
    //   81: aload_0
    //   82: astore 4
    //   84: aload_0
    //   85: invokeinterface 199 1 0
    //   90: ifeq +103 -> 193
    //   93: aload_0
    //   94: astore 4
    //   96: aload_0
    //   97: iload_3
    //   98: invokeinterface 227 2 0
    //   103: astore 5
    //   105: aload 5
    //   107: astore 4
    //   109: aload_0
    //   110: ifnull +9 -> 119
    //   113: aload_0
    //   114: invokeinterface 212 1 0
    //   119: aload 4
    //   121: areturn
    //   122: astore 5
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: astore 4
    //   129: getstatic 21	com/tencent/component/media/image/VideoThumbnail:TAG	Ljava/lang/String;
    //   132: new 152	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   139: ldc 229
    //   141: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 5
    //   146: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 238	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: ifnull +35 -> 191
    //   159: aload_0
    //   160: invokeinterface 212 1 0
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: aload 4
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: invokeinterface 212 1 0
    //   180: aload_0
    //   181: athrow
    //   182: astore_0
    //   183: goto -15 -> 168
    //   186: astore 5
    //   188: goto -62 -> 126
    //   191: aconst_null
    //   192: areturn
    //   193: aconst_null
    //   194: astore 4
    //   196: goto -87 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramContext	Context
    //   0	199	1	paramLong	long
    //   80	18	3	i	int
    //   1	194	4	localObject	Object
    //   22	84	5	str	String
    //   122	23	5	localException1	java.lang.Exception
    //   186	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	53	122	java/lang/Exception
    //   3	53	167	finally
    //   60	69	182	finally
    //   72	81	182	finally
    //   84	93	182	finally
    //   96	105	182	finally
    //   129	155	182	finally
    //   60	69	186	java/lang/Exception
    //   72	81	186	java/lang/Exception
    //   84	93	186	java/lang/Exception
    //   96	105	186	java/lang/Exception
  }
  
  /* Error */
  public static String queryVideoThumbnailFilePath(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   7: iconst_5
    //   8: if_icmpge +7 -> 15
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_3
    //   14: areturn
    //   15: new 152	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   22: ldc 162
    //   24: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokestatic 164	com/tencent/component/media/image/VideoThumbnail:processPath	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 166
    //   36: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 172	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   47: getstatic 178	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   50: getstatic 29	com/tencent/component/media/image/VideoThumbnail:PROJECTION_VIDEO	[Ljava/lang/String;
    //   53: aload_1
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +131 -> 192
    //   64: aload_1
    //   65: astore_3
    //   66: aload_1
    //   67: invokeinterface 189 1 0
    //   72: ifle +120 -> 192
    //   75: aload_1
    //   76: astore_3
    //   77: aload_1
    //   78: ldc 191
    //   80: invokeinterface 195 2 0
    //   85: istore_2
    //   86: aload_1
    //   87: astore_3
    //   88: aload_1
    //   89: invokeinterface 199 1 0
    //   94: ifeq +98 -> 192
    //   97: aload_1
    //   98: astore_3
    //   99: aload_0
    //   100: aload_1
    //   101: iload_2
    //   102: invokeinterface 203 2 0
    //   107: invokestatic 241	com/tencent/component/media/image/VideoThumbnail:queryVideoThumbnailFilePath	(Landroid/content/Context;J)Ljava/lang/String;
    //   110: astore_0
    //   111: aload_0
    //   112: astore_3
    //   113: aload_1
    //   114: ifnull -101 -> 13
    //   117: aload_1
    //   118: invokeinterface 212 1 0
    //   123: aload_0
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: astore_3
    //   130: getstatic 21	com/tencent/component/media/image/VideoThumbnail:TAG	Ljava/lang/String;
    //   133: new 152	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   140: ldc 229
    //   142: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 238	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_1
    //   156: ifnull +34 -> 190
    //   159: aload_1
    //   160: invokeinterface 212 1 0
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_3
    //   170: aload_3
    //   171: ifnull +9 -> 180
    //   174: aload_3
    //   175: invokeinterface 212 1 0
    //   180: aload_0
    //   181: athrow
    //   182: astore_0
    //   183: goto -13 -> 170
    //   186: astore_0
    //   187: goto -59 -> 128
    //   190: aconst_null
    //   191: areturn
    //   192: aconst_null
    //   193: astore_0
    //   194: goto -83 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString	String
    //   85	17	2	i	int
    //   12	163	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	60	125	java/lang/Throwable
    //   15	60	167	finally
    //   66	75	182	finally
    //   77	86	182	finally
    //   88	97	182	finally
    //   99	111	182	finally
    //   130	155	182	finally
    //   66	75	186	java/lang/Throwable
    //   77	86	186	java/lang/Throwable
    //   88	97	186	java/lang/Throwable
    //   99	111	186	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.VideoThumbnail
 * JD-Core Version:    0.7.0.1
 */