import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

public class bdmg
{
  private static volatile bdmg jdField_a_of_type_Bdmg;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  protected Context a;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  
  public static bdmg a()
  {
    if (jdField_a_of_type_Bdmg == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdmg == null) {
        jdField_a_of_type_Bdmg = new bdmg();
      }
      return jdField_a_of_type_Bdmg;
    }
  }
  
  private String a()
  {
    String str = bdly.a(bdze.a().getString("downloadUrl", ""), bdze.a().getString("version", "1.10.0.00173"));
    if (!TextUtils.isEmpty(str)) {
      return str + "sdk.jar";
    }
    return null;
  }
  
  /* Error */
  public Class a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	bdmg:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 72	bdmg:a	()V
    //   11: ldc 74
    //   13: new 53	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   20: ldc 76
    //   22: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 82	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 70	bdmg:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +47 -> 86
    //   42: aload_0
    //   43: getfield 70	bdmg:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   46: aload_1
    //   47: invokevirtual 87	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore_2
    //   51: ldc 74
    //   53: new 53	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   60: ldc 76
    //   62: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 89
    //   71: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 82	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: areturn
    //   86: aload_0
    //   87: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   90: invokevirtual 102	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   93: aload_1
    //   94: invokevirtual 87	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: astore_2
    //   98: aload_2
    //   99: areturn
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: ldc 74
    //   105: new 53	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   112: ldc 76
    //   114: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 104
    //   123: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 110	bdnw:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   143: invokevirtual 102	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   146: aload_1
    //   147: invokevirtual 87	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   150: astore 4
    //   152: aload 4
    //   154: areturn
    //   155: astore 4
    //   157: ldc 74
    //   159: new 53	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   166: ldc 76
    //   168: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 104
    //   177: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload_3
    //   184: invokestatic 114	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_2
    //   188: areturn
    //   189: astore_3
    //   190: goto -87 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	bdmg
    //   0	193	1	paramString	String
    //   50	138	2	localClass1	Class
    //   100	84	3	localException1	java.lang.Exception
    //   189	1	3	localException2	java.lang.Exception
    //   150	3	4	localClass2	Class
    //   155	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	100	java/lang/Exception
    //   11	51	100	java/lang/Exception
    //   86	98	100	java/lang/Exception
    //   139	152	155	java/lang/Throwable
    //   51	84	189	java/lang/Exception
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	bdmg:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 72	bdmg:a	()V
    //   11: ldc 74
    //   13: new 53	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   20: ldc 117
    //   22: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 82	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 70	bdmg:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +53 -> 92
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 70	bdmg:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   47: invokestatic 122	bdmh:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbdmh;
    //   50: invokevirtual 125	bdmh:a	()Lbdmh;
    //   53: invokevirtual 128	bdmh:a	()Ljava/lang/Object;
    //   56: astore_2
    //   57: ldc 74
    //   59: new 53	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   66: ldc 117
    //   68: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 130
    //   77: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 82	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: areturn
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: invokevirtual 102	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   100: invokestatic 122	bdmh:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbdmh;
    //   103: invokevirtual 125	bdmh:a	()Lbdmh;
    //   106: invokevirtual 128	bdmh:a	()Ljava/lang/Object;
    //   109: astore_2
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: ldc 74
    //   117: new 53	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   124: ldc 132
    //   126: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 104
    //   135: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 110	bdnw:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: aload_0
    //   153: invokevirtual 96	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: invokevirtual 102	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: invokestatic 122	bdmh:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbdmh;
    //   162: invokevirtual 125	bdmh:a	()Lbdmh;
    //   165: invokevirtual 128	bdmh:a	()Ljava/lang/Object;
    //   168: astore 4
    //   170: aload 4
    //   172: areturn
    //   173: astore 4
    //   175: ldc 74
    //   177: new 53	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   184: ldc 132
    //   186: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 104
    //   195: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload_3
    //   202: invokestatic 114	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_2
    //   206: areturn
    //   207: astore_3
    //   208: goto -93 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	bdmg
    //   0	211	1	paramString	String
    //   56	150	2	localObject1	Object
    //   112	90	3	localException1	java.lang.Exception
    //   207	1	3	localException2	java.lang.Exception
    //   168	3	4	localObject2	Object
    //   173	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	112	java/lang/Exception
    //   11	57	112	java/lang/Exception
    //   92	110	112	java/lang/Exception
    //   151	170	173	java/lang/Throwable
    //   57	90	207	java/lang/Exception
  }
  
  public void a()
  {
    try
    {
      getClass().getClassLoader();
      if ((a()) && (this.jdField_a_of_type_JavaLangClassLoader == null)) {
        this.jdField_a_of_type_JavaLangClassLoader = new bdmf(a(), this.jdField_a_of_type_AndroidContentContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a()
  {
    String str = a();
    if (TextUtils.isEmpty(str)) {}
    while (!new File(str).exists()) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdmg
 * JD-Core Version:    0.7.0.1
 */