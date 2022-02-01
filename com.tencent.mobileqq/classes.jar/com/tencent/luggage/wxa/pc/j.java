package com.tencent.luggage.wxa.pc;

public final class j
{
  public static Object a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    return a(paramClass, paramString, paramObject, paramArrayOfClass, paramArrayOfObject, null);
  }
  
  /* Error */
  public static <T> T a(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, T paramT)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +115 -> 116
    //   4: aconst_null
    //   5: astore 8
    //   7: aload_2
    //   8: invokevirtual 18	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: astore 7
    //   13: aload 7
    //   15: ifnull +60 -> 75
    //   18: aload 7
    //   20: aload_1
    //   21: aload_3
    //   22: invokevirtual 24	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   25: astore 6
    //   27: aload 7
    //   29: invokevirtual 27	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   32: astore 7
    //   34: aload 6
    //   36: astore 8
    //   38: goto -25 -> 13
    //   41: astore_0
    //   42: goto +25 -> 67
    //   45: aload 8
    //   47: astore 6
    //   49: aload_0
    //   50: aload 7
    //   52: if_acmpne -25 -> 27
    //   55: aload 7
    //   57: aload_1
    //   58: aload_3
    //   59: invokevirtual 24	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   62: astore 6
    //   64: goto -37 -> 27
    //   67: aload 7
    //   69: invokevirtual 27	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   72: pop
    //   73: aload_0
    //   74: athrow
    //   75: aload 8
    //   77: ifnonnull +6 -> 83
    //   80: aload 5
    //   82: areturn
    //   83: aload 8
    //   85: iconst_1
    //   86: invokevirtual 33	java/lang/reflect/Method:setAccessible	(Z)V
    //   89: aload 8
    //   91: aload_2
    //   92: aload 4
    //   94: invokevirtual 37	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: astore_0
    //   98: aload_0
    //   99: areturn
    //   100: astore_0
    //   101: ldc 39
    //   103: aload_0
    //   104: ldc 41
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 46	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload 5
    //   115: areturn
    //   116: new 48	java/lang/IllegalArgumentException
    //   119: dup
    //   120: ldc 50
    //   122: invokespecial 54	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   125: astore_0
    //   126: goto +5 -> 131
    //   129: aload_0
    //   130: athrow
    //   131: goto -2 -> 129
    //   134: astore 6
    //   136: goto -91 -> 45
    //   139: astore 6
    //   141: aload 8
    //   143: astore 6
    //   145: goto -118 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramClass	Class<?>
    //   0	148	1	paramString	String
    //   0	148	2	paramObject	Object
    //   0	148	3	paramArrayOfClass	Class<?>[]
    //   0	148	4	paramArrayOfObject	Object[]
    //   0	148	5	paramT	T
    //   25	38	6	localObject1	Object
    //   134	1	6	localException1	java.lang.Exception
    //   139	1	6	localException2	java.lang.Exception
    //   143	1	6	localObject2	Object
    //   11	57	7	localClass	Class
    //   5	137	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	41	finally
    //   55	64	41	finally
    //   83	98	100	java/lang/Exception
    //   18	27	134	java/lang/Exception
    //   55	64	139	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.j
 * JD-Core Version:    0.7.0.1
 */