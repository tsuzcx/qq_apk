import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class bhti
{
  public static int a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d = localStatFs.getAvailableBlocks();
    return (int)(i * (1.0D * d) / 1024.0D / 1024.0D);
  }
  
  private static File a(Context paramContext)
  {
    paramContext = new File(bbvj.a("uploader"));
    if ((paramContext.isDirectory()) || (paramContext.mkdirs())) {
      return paramContext;
    }
    return null;
  }
  
  protected static String a(Context paramContext, String paramString)
  {
    paramString = paramString.replace("data:image/jpg;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/png;base64,", "");
    paramContext = b(paramContext, UUID.randomUUID().toString());
    if (TextUtils.isEmpty(paramContext))
    {
      QLog.e("js-upload: QzoneWebUploadInterface", 1, "getTempFilePath return null !");
      return null;
    }
    try
    {
      boolean bool = a(Base64.decode(paramString.getBytes(), 2), paramContext);
      QLog.d("js-upload: QzoneWebUploadInterface", 1, "saveByteBufferToLocalFile ret:" + bool);
      if (bool) {}
      for (;;)
      {
        return paramContext;
        paramContext = null;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      QLog.d("js-upload: QzoneWebUploadInterface", 1, "Base64.decode Exception: " + paramContext.toString());
    }
  }
  
  public static final String a(String paramString1, String paramString2)
  {
    return 8 + paramString1 + File.separator + paramString2 + ".qtmp";
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "localPath: " + paramString1 + " bid:" + paramString2);
      return false;
    }
    if (!new File(paramString1).exists())
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "upload file not exist! localPath:" + paramString1);
      return false;
    }
    Object localObject2 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if (localObject2 == null)
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "app == null");
      return false;
    }
    Object localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
    String str = ((AppInterface)localObject2).getAccount();
    localObject2 = ((TicketManager)localObject1).getSkey(str);
    localObject1 = ((TicketManager)localObject1).getA2(str);
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      QLog.w("js-upload: QzoneWebUploadInterface", 1, "mSkey == null || mA2 == null, mSkey=" + (String)localObject2 + " mA2=" + (String)localObject1);
      return false;
    }
    bhlc.a().a().a(paramString1, paramString2);
    return true;
  }
  
  /* Error */
  protected static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aload 6
    //   19: astore 4
    //   21: new 16	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload 6
    //   32: astore 4
    //   34: aload_1
    //   35: invokevirtual 149	java/io/File:exists	()Z
    //   38: ifne +12 -> 50
    //   41: aload 6
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 210	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aload 6
    //   52: astore 4
    //   54: new 212	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 215	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 219	java/io/FileOutputStream:write	([B)V
    //   68: iload_3
    //   69: istore_2
    //   70: aload_1
    //   71: ifnull +9 -> 80
    //   74: aload_1
    //   75: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   78: iload_3
    //   79: istore_2
    //   80: iload_2
    //   81: ireturn
    //   82: astore_0
    //   83: ldc 86
    //   85: iconst_1
    //   86: new 109	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   93: ldc 224
    //   95: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iload_3
    //   109: istore_2
    //   110: goto -30 -> 80
    //   113: astore_1
    //   114: aload 5
    //   116: astore_0
    //   117: aload_0
    //   118: astore 4
    //   120: ldc 86
    //   122: iconst_1
    //   123: new 109	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   130: ldc 229
    //   132: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: ifnull +102 -> 248
    //   149: aload_0
    //   150: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   153: iconst_0
    //   154: istore_2
    //   155: goto -75 -> 80
    //   158: astore_0
    //   159: ldc 86
    //   161: iconst_1
    //   162: new 109	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   169: ldc 224
    //   171: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iconst_0
    //   185: istore_2
    //   186: goto -106 -> 80
    //   189: astore_0
    //   190: aload 4
    //   192: ifnull +8 -> 200
    //   195: aload 4
    //   197: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   200: aload_0
    //   201: athrow
    //   202: astore_1
    //   203: ldc 86
    //   205: iconst_1
    //   206: new 109	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   213: ldc 224
    //   215: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: goto -28 -> 200
    //   231: astore_0
    //   232: aload_1
    //   233: astore 4
    //   235: goto -45 -> 190
    //   238: astore 4
    //   240: aload_1
    //   241: astore_0
    //   242: aload 4
    //   244: astore_1
    //   245: goto -128 -> 117
    //   248: iconst_0
    //   249: istore_2
    //   250: goto -170 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramArrayOfByte	byte[]
    //   0	253	1	paramString	String
    //   69	181	2	bool1	boolean
    //   1	108	3	bool2	boolean
    //   19	215	4	localObject1	Object
    //   238	5	4	localIOException	java.io.IOException
    //   15	100	5	localObject2	Object
    //   12	39	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	78	82	java/lang/Exception
    //   21	30	113	java/io/IOException
    //   34	41	113	java/io/IOException
    //   45	50	113	java/io/IOException
    //   54	63	113	java/io/IOException
    //   149	153	158	java/lang/Exception
    //   21	30	189	finally
    //   34	41	189	finally
    //   45	50	189	finally
    //   54	63	189	finally
    //   120	145	189	finally
    //   195	200	202	java/lang/Exception
    //   63	68	231	finally
    //   63	68	238	java/io/IOException
  }
  
  public static int b()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d = localStatFs.getAvailableBlocks();
    return (int)(i * (1.0D * d) / 1024.0D / 1024.0D);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        if (("mounted".equals(Environment.getExternalStorageState())) && (a() > 5))
        {
          File localFile = a(paramContext);
          if (localFile != null) {
            return a(localFile.getAbsolutePath(), paramString);
          }
        }
      } while (b() <= 5);
      paramContext = paramContext.getDir("uploader", 0);
    } while (paramContext == null);
    return a(paramContext.getAbsolutePath(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhti
 * JD-Core Version:    0.7.0.1
 */