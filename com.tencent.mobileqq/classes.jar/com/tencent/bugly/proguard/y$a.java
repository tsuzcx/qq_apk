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
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    this.c = paramString;
    this.a = a();
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
    }
    catch (Throwable localThrowable)
    {
      x.a(localThrowable);
      this.a = false;
      return false;
    }
    return true;
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
    //   9: new 68	java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 41	com/tencent/bugly/proguard/y$a:b	Ljava/io/File;
    //   17: iconst_1
    //   18: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_2
    //   24: aload_1
    //   25: ldc 73
    //   27: invokevirtual 77	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   30: astore_1
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 81	java/io/FileOutputStream:write	([B)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: invokevirtual 84	java/io/FileOutputStream:flush	()V
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   50: aload_3
    //   51: astore_2
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 89	com/tencent/bugly/proguard/y$a:d	J
    //   57: aload_1
    //   58: arraylength
    //   59: i2l
    //   60: ladd
    //   61: putfield 89	com/tencent/bugly/proguard/y$a:d	J
    //   64: aload_3
    //   65: astore_2
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 37	com/tencent/bugly/proguard/y$a:a	Z
    //   71: aload_3
    //   72: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   75: iconst_1
    //   76: ireturn
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_2
    //   83: aload 4
    //   85: invokestatic 61	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   88: pop
    //   89: aload_1
    //   90: astore_2
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 37	com/tencent/bugly/proguard/y$a:a	Z
    //   96: aload_1
    //   97: ifnull -90 -> 7
    //   100: aload_1
    //   101: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: goto -48 -> 75
    //   126: astore_2
    //   127: goto -7 -> 120
    //   130: astore_1
    //   131: goto -19 -> 112
    //   134: astore 4
    //   136: aload_3
    //   137: astore_1
    //   138: goto -57 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	a
    //   0	141	1	paramString	String
    //   23	94	2	localObject	Object
    //   126	1	2	localIOException	java.io.IOException
    //   21	116	3	localFileOutputStream	java.io.FileOutputStream
    //   77	7	4	localThrowable1	Throwable
    //   134	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	22	77	java/lang/Throwable
    //   100	104	106	java/io/IOException
    //   9	22	109	finally
    //   71	75	122	java/io/IOException
    //   116	120	126	java/io/IOException
    //   24	31	130	finally
    //   33	38	130	finally
    //   40	44	130	finally
    //   46	50	130	finally
    //   52	64	130	finally
    //   66	71	130	finally
    //   83	89	130	finally
    //   91	96	130	finally
    //   24	31	134	java/lang/Throwable
    //   33	38	134	java/lang/Throwable
    //   40	44	134	java/lang/Throwable
    //   46	50	134	java/lang/Throwable
    //   52	64	134	java/lang/Throwable
    //   66	71	134	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.y.a
 * JD-Core Version:    0.7.0.1
 */