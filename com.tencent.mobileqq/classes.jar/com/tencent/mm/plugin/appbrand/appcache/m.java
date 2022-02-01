package com.tencent.mm.plugin.appbrand.appcache;

public final class m
{
  /* Error */
  public static java.lang.String a(v paramv, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +313 -> 314
    //   4: aload_1
    //   5: invokestatic 14	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: invokevirtual 20	com/tencent/mm/plugin/appbrand/appcache/v:e	()Z
    //   17: pop
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 23	com/tencent/mm/plugin/appbrand/appcache/v:c	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnonnull +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: aload_3
    //   31: aload_3
    //   32: invokevirtual 29	java/io/InputStream:available	()I
    //   35: invokevirtual 33	java/io/InputStream:mark	(I)V
    //   38: aload_3
    //   39: sipush 4096
    //   42: invokestatic 38	com/tencent/luggage/wxa/gl/c:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   45: astore 4
    //   47: aload_3
    //   48: invokevirtual 42	java/io/InputStream:reset	()V
    //   51: new 44	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   58: astore_2
    //   59: aload_2
    //   60: aload_0
    //   61: invokevirtual 51	com/tencent/mm/plugin/appbrand/appcache/v:b	()Ljava/lang/String;
    //   64: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: ldc 57
    //   71: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_2
    //   76: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_2
    //   80: aload_2
    //   81: astore_0
    //   82: aload_2
    //   83: ldc 62
    //   85: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   88: ifne +40 -> 128
    //   91: aload_2
    //   92: astore_0
    //   93: aload_1
    //   94: ldc 62
    //   96: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifne +29 -> 128
    //   102: new 44	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   109: astore_0
    //   110: aload_0
    //   111: aload_2
    //   112: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_0
    //   117: ldc 62
    //   119: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_0
    //   124: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_0
    //   128: new 44	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   135: astore_2
    //   136: aload_2
    //   137: aload_0
    //   138: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: aload_1
    //   144: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 72	com/tencent/luggage/wxa/rt/i
    //   151: dup
    //   152: aload_2
    //   153: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokespecial 75	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 79	com/tencent/luggage/wxa/rt/i:g	()Lcom/tencent/luggage/wxa/rt/i;
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 82	com/tencent/luggage/wxa/rt/i:j	()Z
    //   169: ifeq +15 -> 184
    //   172: aload_1
    //   173: invokevirtual 85	com/tencent/luggage/wxa/rt/i:o	()Z
    //   176: ifeq +8 -> 184
    //   179: aload_1
    //   180: invokevirtual 88	com/tencent/luggage/wxa/rt/i:w	()Z
    //   183: pop
    //   184: aload_1
    //   185: invokevirtual 91	com/tencent/luggage/wxa/rt/i:u	()Z
    //   188: pop
    //   189: aload 4
    //   191: aload_0
    //   192: invokevirtual 92	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   195: invokestatic 97	com/tencent/luggage/wxa/rt/k:o	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +6 -> 207
    //   204: goto +70 -> 274
    //   207: aload_0
    //   208: invokevirtual 104	com/tencent/luggage/wxa/rt/i:n	()Z
    //   211: ifeq +43 -> 254
    //   214: invokestatic 110	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   217: astore_1
    //   218: new 44	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   225: astore_2
    //   226: aload_2
    //   227: ldc 112
    //   229: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: aload_0
    //   235: invokevirtual 115	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   238: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: aload_2
    //   244: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokevirtual 119	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   250: pop
    //   251: goto +8 -> 259
    //   254: aload_0
    //   255: invokevirtual 88	com/tencent/luggage/wxa/rt/i:w	()Z
    //   258: pop
    //   259: aload_0
    //   260: invokestatic 122	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   263: astore_1
    //   264: aload_3
    //   265: aload_1
    //   266: invokestatic 127	com/tencent/luggage/wxa/gl/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   269: pop2
    //   270: aload_1
    //   271: invokestatic 130	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   274: aload_0
    //   275: invokevirtual 115	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   278: astore_0
    //   279: aload_3
    //   280: invokestatic 130	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   283: aload_0
    //   284: areturn
    //   285: astore_0
    //   286: goto +22 -> 308
    //   289: astore_0
    //   290: ldc 132
    //   292: aload_0
    //   293: ldc 134
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 139	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload_3
    //   303: invokestatic 130	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   306: aconst_null
    //   307: areturn
    //   308: aload_3
    //   309: invokestatic 130	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   312: aload_0
    //   313: athrow
    //   314: aconst_null
    //   315: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramv	v
    //   0	316	1	paramString	java.lang.String
    //   58	186	2	localObject	Object
    //   23	286	3	localInputStream	java.io.InputStream
    //   45	145	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   30	80	285	finally
    //   82	91	285	finally
    //   93	128	285	finally
    //   128	184	285	finally
    //   184	204	285	finally
    //   207	251	285	finally
    //   254	259	285	finally
    //   259	274	285	finally
    //   274	279	285	finally
    //   290	302	285	finally
    //   30	80	289	java/lang/Exception
    //   82	91	289	java/lang/Exception
    //   93	128	289	java/lang/Exception
    //   128	184	289	java/lang/Exception
    //   184	204	289	java/lang/Exception
    //   207	251	289	java/lang/Exception
    //   254	259	289	java/lang/Exception
    //   259	274	289	java/lang/Exception
    //   274	279	289	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.m
 * JD-Core Version:    0.7.0.1
 */