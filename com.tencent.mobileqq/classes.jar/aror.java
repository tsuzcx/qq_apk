import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aror
{
  public static final String[] a = { "expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png", "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png", "expand_square_blank.png", "expand_voice_animation.json", "expand_summary_bg.png", "expand_summary_default_bg.png", "expand_guide_wording.png", "expand_guide_profile.png", "expand_guide_switch.png", "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png" };
  public static final String[] b = { "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png" };
  public static final String[] c = { "expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png" };
  public static final String[] d = { "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png" };
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_2
    //   6: aload_0
    //   7: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +58 -> 68
    //   13: new 73	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 81	java/io/File:exists	()Z
    //   26: ifeq +139 -> 165
    //   29: new 83	java/io/BufferedInputStream
    //   32: dup
    //   33: new 85	java/io/FileInputStream
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: aconst_null
    //   49: aload_1
    //   50: invokestatic 97	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: aload_0
    //   57: astore_2
    //   58: aload_3
    //   59: ifnull +9 -> 68
    //   62: aload_3
    //   63: invokevirtual 102	java/io/InputStream:close	()V
    //   66: aload_0
    //   67: astore_2
    //   68: aload_2
    //   69: areturn
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_3
    //   73: aload_3
    //   74: astore_2
    //   75: ldc 104
    //   77: iconst_1
    //   78: ldc 106
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: aastore
    //   88: invokestatic 110	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   91: aload_1
    //   92: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload 4
    //   97: astore_2
    //   98: aload_3
    //   99: ifnull -31 -> 68
    //   102: aload_3
    //   103: invokevirtual 102	java/io/InputStream:close	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aconst_null
    //   110: areturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_3
    //   114: aload_3
    //   115: astore_2
    //   116: ldc 104
    //   118: iconst_1
    //   119: ldc 106
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: aastore
    //   129: invokestatic 110	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   132: aload_1
    //   133: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: ifnull -72 -> 68
    //   143: aload_3
    //   144: invokevirtual 102	java/io/InputStream:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 102	java/io/InputStream:close	()V
    //   163: aload_0
    //   164: athrow
    //   165: ldc 104
    //   167: iconst_1
    //   168: ldc 117
    //   170: iconst_1
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_0
    //   177: aastore
    //   178: invokestatic 110	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   181: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: aload_0
    //   188: areturn
    //   189: astore_1
    //   190: goto -27 -> 163
    //   193: astore_0
    //   194: goto -39 -> 155
    //   197: astore_1
    //   198: goto -84 -> 114
    //   201: astore_1
    //   202: goto -129 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString	String
    //   0	205	1	paramOptions	android.graphics.BitmapFactory.Options
    //   5	155	2	localObject1	Object
    //   44	100	3	localBufferedInputStream	java.io.BufferedInputStream
    //   1	136	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	45	70	java/lang/Exception
    //   102	106	108	java/lang/Exception
    //   29	45	111	java/lang/OutOfMemoryError
    //   143	147	149	java/lang/Exception
    //   29	45	152	finally
    //   62	66	186	java/lang/Exception
    //   159	163	189	java/lang/Exception
    //   47	54	193	finally
    //   75	95	193	finally
    //   116	136	193	finally
    //   47	54	197	java/lang/OutOfMemoryError
    //   47	54	201	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    return String.format("%s/%s", new Object[] { arhu.a(), paramString });
  }
  
  public static boolean a()
  {
    return a(a(a));
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!new File(str).exists())
      {
        QLog.e("ExtendFriendResourceUtil", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { str }));
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = null;
    if (paramArrayOfString != null)
    {
      arrayOfString = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[i] = a(paramArrayOfString[i]);
        i += 1;
      }
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aror
 * JD-Core Version:    0.7.0.1
 */