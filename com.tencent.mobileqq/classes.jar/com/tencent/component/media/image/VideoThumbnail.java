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
  private static final String jdField_a_of_type_JavaLangString = VideoThumbnail.class.getSimpleName();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DISTINCT _id", "_data" };
  
  private static Bitmap a(Context paramContext, String paramString)
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
        paramString = "_data='" + a(paramString) + "'" + " COLLATE NOCASE";
        localCursor = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, paramString, null, null);
        if (localCursor == null) {}
      }
      finally
      {
        try
        {
          if (localCursor.getCount() <= 0) {
            break label163;
          }
          int i = localCursor.getColumnIndexOrThrow("_id");
          if (!localCursor.moveToFirst()) {
            break label163;
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
      label163:
      paramContext = null;
    }
  }
  
  private static Bitmap a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return b(paramString);
  }
  
  /* Error */
  private static String a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 38	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   10: ldc 111
    //   12: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_1
    //   16: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 5
    //   24: aload_0
    //   25: invokevirtual 61	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: getstatic 115	android/provider/MediaStore$Video$Thumbnails:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   31: iconst_2
    //   32: anewarray 19	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 117
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: ldc 23
    //   44: aastore
    //   45: aload 5
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +139 -> 193
    //   57: aload_0
    //   58: astore 4
    //   60: aload_0
    //   61: invokeinterface 79 1 0
    //   66: ifle +127 -> 193
    //   69: aload_0
    //   70: astore 4
    //   72: aload_0
    //   73: ldc 23
    //   75: invokeinterface 85 2 0
    //   80: istore_3
    //   81: aload_0
    //   82: astore 4
    //   84: aload_0
    //   85: invokeinterface 89 1 0
    //   90: ifeq +103 -> 193
    //   93: aload_0
    //   94: astore 4
    //   96: aload_0
    //   97: iload_3
    //   98: invokeinterface 121 2 0
    //   103: astore 5
    //   105: aload 5
    //   107: astore 4
    //   109: aload_0
    //   110: ifnull +9 -> 119
    //   113: aload_0
    //   114: invokeinterface 102 1 0
    //   119: aload 4
    //   121: areturn
    //   122: astore 5
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: astore 4
    //   129: getstatic 17	com/tencent/component/media/image/VideoThumbnail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: new 38	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   139: ldc 123
    //   141: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 5
    //   146: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 132	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: ifnull +35 -> 191
    //   159: aload_0
    //   160: invokeinterface 102 1 0
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: aload 4
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: invokeinterface 102 1 0
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
  
  private static String a(String paramString)
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
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: getstatic 36	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 10
    //   11: if_icmple +96 -> 107
    //   14: new 164	android/media/MediaMetadataRetriever
    //   17: dup
    //   18: invokespecial 165	android/media/MediaMetadataRetriever:<init>	()V
    //   21: astore 7
    //   23: aload 7
    //   25: aload_0
    //   26: invokevirtual 169	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   29: aload 7
    //   31: ldc2_w 170
    //   34: iconst_2
    //   35: invokevirtual 175	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +128 -> 168
    //   43: aload_0
    //   44: invokevirtual 180	android/graphics/Bitmap:getWidth	()I
    //   47: istore_2
    //   48: aload_0
    //   49: invokevirtual 183	android/graphics/Bitmap:getHeight	()I
    //   52: istore_3
    //   53: iload_2
    //   54: iload_3
    //   55: invokestatic 189	java/lang/Math:max	(II)I
    //   58: istore 4
    //   60: iload 4
    //   62: sipush 512
    //   65: if_icmple +103 -> 168
    //   68: ldc 190
    //   70: iload 4
    //   72: i2f
    //   73: fdiv
    //   74: fstore_1
    //   75: aload_0
    //   76: iload_2
    //   77: i2f
    //   78: fload_1
    //   79: fmul
    //   80: invokestatic 194	java/lang/Math:round	(F)I
    //   83: iload_3
    //   84: i2f
    //   85: fload_1
    //   86: fmul
    //   87: invokestatic 194	java/lang/Math:round	(F)I
    //   90: iconst_1
    //   91: invokestatic 198	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   94: astore 5
    //   96: aload 5
    //   98: astore_0
    //   99: aload 7
    //   101: invokevirtual 201	android/media/MediaMetadataRetriever:release	()V
    //   104: aload_0
    //   105: astore 5
    //   107: aload 5
    //   109: areturn
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 204	java/lang/RuntimeException:printStackTrace	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore 5
    //   121: aload 6
    //   123: astore_0
    //   124: aload 5
    //   126: invokevirtual 205	java/lang/Throwable:printStackTrace	()V
    //   129: aload 7
    //   131: invokevirtual 201	android/media/MediaMetadataRetriever:release	()V
    //   134: aload_0
    //   135: areturn
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 204	java/lang/RuntimeException:printStackTrace	()V
    //   143: aload_0
    //   144: areturn
    //   145: astore_0
    //   146: aload 7
    //   148: invokevirtual 201	android/media/MediaMetadataRetriever:release	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 204	java/lang/RuntimeException:printStackTrace	()V
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
      Bitmap localBitmap = a(paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        paramContext = a(paramContext, paramString);
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
  
  /* Error */
  public static String queryVideoThumbnailFilePath(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnull +10 -> 13
    //   6: getstatic 36	android/os/Build$VERSION:SDK_INT	I
    //   9: iconst_5
    //   10: if_icmpge +7 -> 17
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_3
    //   16: areturn
    //   17: new 38	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   24: ldc 41
    //   26: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokestatic 48	com/tencent/component/media/image/VideoThumbnail:a	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 50
    //   38: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 52
    //   43: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: invokevirtual 61	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: getstatic 67	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   57: getstatic 25	com/tencent/component/media/image/VideoThumbnail:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   60: aload_1
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +133 -> 201
    //   71: aload_1
    //   72: astore_3
    //   73: aload_1
    //   74: invokeinterface 79 1 0
    //   79: ifle +122 -> 201
    //   82: aload_1
    //   83: astore_3
    //   84: aload_1
    //   85: ldc 81
    //   87: invokeinterface 85 2 0
    //   92: istore_2
    //   93: aload_1
    //   94: astore_3
    //   95: aload_1
    //   96: invokeinterface 89 1 0
    //   101: ifeq +100 -> 201
    //   104: aload_1
    //   105: astore_3
    //   106: aload_0
    //   107: aload_1
    //   108: iload_2
    //   109: invokeinterface 93 2 0
    //   114: invokestatic 238	com/tencent/component/media/image/VideoThumbnail:a	(Landroid/content/Context;J)Ljava/lang/String;
    //   117: astore_0
    //   118: aload_0
    //   119: astore_3
    //   120: aload_1
    //   121: ifnull -106 -> 15
    //   124: aload_1
    //   125: invokeinterface 102 1 0
    //   130: aload_0
    //   131: areturn
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_3
    //   137: getstatic 17	com/tencent/component/media/image/VideoThumbnail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: new 38	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   147: ldc 123
    //   149: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 132	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_1
    //   163: ifnull +36 -> 199
    //   166: aload_1
    //   167: invokeinterface 102 1 0
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aload_3
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +9 -> 187
    //   181: aload_1
    //   182: invokeinterface 102 1 0
    //   187: aload_0
    //   188: athrow
    //   189: astore_0
    //   190: aload_3
    //   191: astore_1
    //   192: goto -15 -> 177
    //   195: astore_0
    //   196: goto -61 -> 135
    //   199: aconst_null
    //   200: areturn
    //   201: aconst_null
    //   202: astore_0
    //   203: goto -85 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramContext	Context
    //   0	206	1	paramString	String
    //   92	17	2	i	int
    //   1	190	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	67	132	java/lang/Throwable
    //   17	67	174	finally
    //   73	82	189	finally
    //   84	93	189	finally
    //   95	104	189	finally
    //   106	118	189	finally
    //   137	162	189	finally
    //   73	82	195	java/lang/Throwable
    //   84	93	195	java/lang/Throwable
    //   95	104	195	java/lang/Throwable
    //   106	118	195	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.VideoThumbnail
 * JD-Core Version:    0.7.0.1
 */