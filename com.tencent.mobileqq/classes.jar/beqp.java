import android.content.Context;

public class beqp
{
  private static volatile beqp jdField_a_of_type_Beqp;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  protected Context a;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  
  public static beqp a()
  {
    if (jdField_a_of_type_Beqp == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Beqp == null) {
        jdField_a_of_type_Beqp = new beqp();
      }
      return jdField_a_of_type_Beqp;
    }
  }
  
  /* Error */
  public java.lang.Class a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	beqp:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 30	beqp:a	()V
    //   11: ldc 32
    //   13: new 34	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   20: ldc 37
    //   22: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 51	besl:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 28	beqp:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +47 -> 86
    //   42: aload_0
    //   43: getfield 28	beqp:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   46: aload_1
    //   47: invokevirtual 56	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore_2
    //   51: ldc 32
    //   53: new 34	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   60: ldc 37
    //   62: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 58
    //   71: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 51	besl:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: areturn
    //   86: aload_0
    //   87: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
    //   90: invokevirtual 71	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   93: aload_1
    //   94: invokevirtual 56	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: astore_2
    //   98: aload_2
    //   99: areturn
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: ldc 32
    //   105: new 34	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   112: ldc 37
    //   114: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 73
    //   123: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 76	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 79	besl:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
    //   143: invokevirtual 71	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   146: aload_1
    //   147: invokevirtual 56	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   150: astore 4
    //   152: aload 4
    //   154: areturn
    //   155: astore 4
    //   157: ldc 32
    //   159: new 34	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   166: ldc 37
    //   168: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 73
    //   177: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload_3
    //   184: invokestatic 82	besl:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_2
    //   188: areturn
    //   189: astore_3
    //   190: goto -87 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	beqp
    //   0	193	1	paramString	java.lang.String
    //   50	138	2	localClass1	java.lang.Class
    //   100	84	3	localException1	java.lang.Exception
    //   189	1	3	localException2	java.lang.Exception
    //   150	3	4	localClass2	java.lang.Class
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
  public Object a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	beqp:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 30	beqp:a	()V
    //   11: ldc 32
    //   13: new 34	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   20: ldc 85
    //   22: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 51	besl:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 28	beqp:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +53 -> 92
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 28	beqp:jdField_a_of_type_JavaLangClassLoader	Ljava/lang/ClassLoader;
    //   47: invokestatic 90	beqq:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbeqq;
    //   50: invokevirtual 93	beqq:a	()Lbeqq;
    //   53: invokevirtual 96	beqq:a	()Ljava/lang/Object;
    //   56: astore_2
    //   57: ldc 32
    //   59: new 34	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   66: ldc 85
    //   68: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 98
    //   77: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 51	besl:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: areturn
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: invokevirtual 71	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   100: invokestatic 90	beqq:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbeqq;
    //   103: invokevirtual 93	beqq:a	()Lbeqq;
    //   106: invokevirtual 96	beqq:a	()Ljava/lang/Object;
    //   109: astore_2
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: ldc 32
    //   117: new 34	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   124: ldc 100
    //   126: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 73
    //   135: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 76	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 79	besl:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: aload_0
    //   153: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: invokevirtual 71	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: invokestatic 90	beqq:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lbeqq;
    //   162: invokevirtual 93	beqq:a	()Lbeqq;
    //   165: invokevirtual 96	beqq:a	()Ljava/lang/Object;
    //   168: astore 4
    //   170: aload 4
    //   172: areturn
    //   173: astore 4
    //   175: ldc 32
    //   177: new 34	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   184: ldc 100
    //   186: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 73
    //   195: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload_3
    //   202: invokestatic 82	besl:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_2
    //   206: areturn
    //   207: astore_3
    //   208: goto -93 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	beqp
    //   0	211	1	paramString	java.lang.String
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
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqp
 * JD-Core Version:    0.7.0.1
 */