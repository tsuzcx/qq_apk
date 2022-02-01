package com.tencent.bugly.proguard;

import java.io.File;

public final class y$a
{
  private boolean a;
  private File b;
  private String c;
  private long d;
  private long e = 30720L;
  
  public y$a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
      }
      this.c = paramString;
      this.a = a();
    }
  }
  
  private boolean a()
  {
    try
    {
      this.b = new File(this.c);
      if ((this.b.exists()) && (!this.b.delete()))
      {
        this.a = false;
        return false;
      }
      if (!this.b.createNewFile())
      {
        this.a = false;
        return false;
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      x.a(localThrowable);
      this.a = false;
    }
    return false;
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/bugly/proguard/y$a:a	Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_2
    //   14: new 68	java/io/FileOutputStream
    //   17: dup
    //   18: aload_0
    //   19: getfield 41	com/tencent/bugly/proguard/y$a:b	Ljava/io/File;
    //   22: iconst_1
    //   23: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   26: astore_3
    //   27: aload_1
    //   28: ldc 73
    //   30: invokevirtual 77	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   33: astore_1
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 81	java/io/FileOutputStream:write	([B)V
    //   39: aload_3
    //   40: invokevirtual 84	java/io/FileOutputStream:flush	()V
    //   43: aload_3
    //   44: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 89	com/tencent/bugly/proguard/y$a:d	J
    //   52: aload_1
    //   53: arraylength
    //   54: i2l
    //   55: ladd
    //   56: putfield 89	com/tencent/bugly/proguard/y$a:d	J
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 37	com/tencent/bugly/proguard/y$a:a	Z
    //   64: aload_3
    //   65: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_1
    //   71: goto +45 -> 116
    //   74: astore_2
    //   75: aload_3
    //   76: astore_1
    //   77: aload_2
    //   78: astore_3
    //   79: goto +13 -> 92
    //   82: astore_1
    //   83: aload_2
    //   84: astore_3
    //   85: goto +31 -> 116
    //   88: astore_3
    //   89: aload 4
    //   91: astore_1
    //   92: aload_1
    //   93: astore_2
    //   94: aload_3
    //   95: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: pop
    //   99: aload_1
    //   100: astore_2
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 37	com/tencent/bugly/proguard/y$a:a	Z
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_1
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_2
    //   133: goto -9 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	a
    //   0	136	1	paramString	String
    //   13	1	2	localObject1	Object
    //   74	10	2	localThrowable1	Throwable
    //   93	8	2	str	String
    //   132	1	2	localIOException	java.io.IOException
    //   26	59	3	localObject2	Object
    //   88	33	3	localThrowable2	Throwable
    //   10	80	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	64	70	finally
    //   27	64	74	java/lang/Throwable
    //   14	27	82	finally
    //   94	99	82	finally
    //   101	106	82	finally
    //   14	27	88	java/lang/Throwable
    //   64	68	126	java/io/IOException
    //   110	114	129	java/io/IOException
    //   120	124	132	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.y.a
 * JD-Core Version:    0.7.0.1
 */