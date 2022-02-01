import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bmiq
{
  public static String a(String paramString)
  {
    return blwp.d + File.separator + paramString;
  }
  
  public static boolean a(Activity paramActivity, Bitmap paramBitmap, int paramInt, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (paramActivity != null) {
        bool1 = bmjl.a(paramActivity, new bmis(paramBitmap, paramInt, paramString, paramActivity), 1);
      }
    }
    if (bool1) {
      return b(paramBitmap, paramInt, paramString);
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (paramActivity != null) {
        bool1 = bmjl.a(paramActivity, new bmir(paramString1, paramString2, paramActivity), 1);
      }
    }
    if (bool1) {
      return b(paramString1, paramString2);
    }
    return false;
  }
  
  private static Activity b(Activity paramActivity)
  {
    Activity localActivity;
    if (paramActivity == null) {
      localActivity = null;
    }
    do
    {
      return localActivity;
      localActivity = paramActivity;
    } while (!(paramActivity instanceof BasePluginActivity));
    return ((BasePluginActivity)paramActivity).getOutActivity();
  }
  
  /* Error */
  private static boolean b(Bitmap paramBitmap, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: new 29	java/io/File
    //   6: dup
    //   7: new 13	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   14: getstatic 23	blwp:d	Ljava/lang/String;
    //   17: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 32	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_2
    //   27: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 6
    //   38: aload 6
    //   40: invokevirtual 82	java/io/File:exists	()Z
    //   43: ifne +7 -> 50
    //   46: aload_0
    //   47: ifnonnull +5 -> 52
    //   50: iconst_0
    //   51: ireturn
    //   52: aload 6
    //   54: invokevirtual 85	java/io/File:createNewFile	()Z
    //   57: istore_3
    //   58: iload_3
    //   59: ifne +18 -> 77
    //   62: iconst_0
    //   63: ifeq -13 -> 50
    //   66: new 87	java/lang/NullPointerException
    //   69: dup
    //   70: invokespecial 88	java/lang/NullPointerException:<init>	()V
    //   73: athrow
    //   74: astore_0
    //   75: iconst_0
    //   76: ireturn
    //   77: new 90	java/io/BufferedOutputStream
    //   80: dup
    //   81: new 92	java/io/FileOutputStream
    //   84: dup
    //   85: aload 6
    //   87: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   93: astore 5
    //   95: aload 5
    //   97: astore_2
    //   98: aload_0
    //   99: getstatic 104	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   102: iload_1
    //   103: aload 5
    //   105: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   108: pop
    //   109: aload 5
    //   111: astore_2
    //   112: new 112	android/content/Intent
    //   115: dup
    //   116: ldc 114
    //   118: aload 6
    //   120: invokestatic 120	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   123: invokespecial 123	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   126: astore_0
    //   127: aload 5
    //   129: astore_2
    //   130: invokestatic 129	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   133: aload_0
    //   134: invokevirtual 135	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   137: iload 4
    //   139: istore_3
    //   140: aload 5
    //   142: ifnull +11 -> 153
    //   145: aload 5
    //   147: invokevirtual 138	java/io/BufferedOutputStream:close	()V
    //   150: iload 4
    //   152: istore_3
    //   153: iload_3
    //   154: ireturn
    //   155: astore 6
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_0
    //   160: astore_2
    //   161: ldc 140
    //   163: iconst_1
    //   164: ldc 142
    //   166: aload 6
    //   168: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 138	java/io/BufferedOutputStream:close	()V
    //   179: iconst_0
    //   180: istore_3
    //   181: goto -28 -> 153
    //   184: astore_0
    //   185: iconst_0
    //   186: istore_3
    //   187: goto -34 -> 153
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 138	java/io/BufferedOutputStream:close	()V
    //   201: aload_0
    //   202: athrow
    //   203: astore_0
    //   204: iload 4
    //   206: istore_3
    //   207: goto -54 -> 153
    //   210: astore_2
    //   211: goto -10 -> 201
    //   214: astore_0
    //   215: goto -22 -> 193
    //   218: astore 6
    //   220: aload 5
    //   222: astore_0
    //   223: goto -64 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramBitmap	Bitmap
    //   0	226	1	paramInt	int
    //   0	226	2	paramString	String
    //   57	150	3	bool1	boolean
    //   1	204	4	bool2	boolean
    //   93	128	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   36	83	6	localFile	File
    //   155	12	6	localException1	java.lang.Exception
    //   218	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   66	74	74	java/io/IOException
    //   52	58	155	java/lang/Exception
    //   77	95	155	java/lang/Exception
    //   175	179	184	java/io/IOException
    //   52	58	190	finally
    //   77	95	190	finally
    //   145	150	203	java/io/IOException
    //   197	201	210	java/io/IOException
    //   98	109	214	finally
    //   112	127	214	finally
    //   130	137	214	finally
    //   161	171	214	finally
    //   98	109	218	java/lang/Exception
    //   112	127	218	java/lang/Exception
    //   130	137	218	java/lang/Exception
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new File(paramString1);
      paramString2 = new File(blwp.d + File.separator + paramString2);
      bmij.a(paramString1, paramString2);
      paramString1 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(paramString2));
      BaseApplicationImpl.getContext().sendBroadcast(paramString1);
      return true;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MediaUtil", 1, "saveFileToSystemAlbum failed:", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiq
 * JD-Core Version:    0.7.0.1
 */