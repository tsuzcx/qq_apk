import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.InputStream;
import java.security.MessageDigest;

public final class bfme
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext == null) {
        return "f2";
      }
    }
    catch (Exception paramContext)
    {
      return "f1";
    }
    if (paramContext.signatures == null) {
      return "f3";
    }
    if (paramContext.signatures[0] == null) {
      return "f4";
    }
    paramContext = paramContext.signatures[0].toByteArray();
    if ((paramContext == null) || (paramContext.length == 0)) {
      return "f5";
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramContext);
      paramContext = a(((MessageDigest)localObject).digest());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "f6";
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = a(localMessageDigest.digest());
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    return paramInputStream;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 108	zzo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_1
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: new 110	java/io/BufferedInputStream
    //   18: dup
    //   19: new 112	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 119	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: invokestatic 121	bfme:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: astore_0
    //   40: aload_0
    //   41: astore_2
    //   42: aload_1
    //   43: ifnull -30 -> 13
    //   46: aload_1
    //   47: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   50: aload_0
    //   51: areturn
    //   52: astore_1
    //   53: aload_0
    //   54: areturn
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_2
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: goto -16 -> 72
    //   91: astore_1
    //   92: goto -7 -> 85
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: aload_2
    //   99: astore_0
    //   100: goto -23 -> 77
    //   103: astore_2
    //   104: goto -46 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   6	41	1	localObject1	Object
    //   52	1	1	localIOException1	java.io.IOException
    //   57	25	1	localIOException2	java.io.IOException
    //   91	1	1	localIOException3	java.io.IOException
    //   97	1	1	str	String
    //   1	41	2	localObject2	Object
    //   55	21	2	localIOException4	java.io.IOException
    //   95	4	2	localObject3	Object
    //   103	1	2	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   46	50	52	java/io/IOException
    //   15	31	55	java/io/IOException
    //   15	31	74	finally
    //   68	72	87	java/io/IOException
    //   81	85	91	java/io/IOException
    //   33	38	95	finally
    //   60	64	95	finally
    //   33	38	103	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfme
 * JD-Core Version:    0.7.0.1
 */