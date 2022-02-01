package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.luggage.wxa.rt.i;
import java.io.IOException;

public final class h
{
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramContext.getAssets().open(paramString1), paramString2, false);
      return bool;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          int i;
          Object localObject;
          if (!a(paramContext.getAssets().open((String)localObject), paramString2, true)) {
            return true;
          }
          o.e("MicroMsg.SDK.FilesCopy", "copy pattern %s", new Object[] { localObject });
          i += 1;
        }
        catch (IOException paramContext) {}
        localIOException = localIOException;
      }
    }
    o.b("MicroMsg.SDK.FilesCopy", "copy assets file srcpath=%s to=%s failed, try pattern now", new Object[] { paramString1, paramString2 });
    i = 0;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    return true;
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 12
    //   6: aload 12
    //   8: astore 10
    //   10: aload 13
    //   12: astore 11
    //   14: aload_0
    //   15: invokevirtual 66	java/io/InputStream:available	()I
    //   18: istore_3
    //   19: aload 12
    //   21: astore 10
    //   23: aload 13
    //   25: astore 11
    //   27: aload_1
    //   28: iload_2
    //   29: invokestatic 71	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   32: astore 12
    //   34: aload 12
    //   36: astore 10
    //   38: aload 12
    //   40: astore 11
    //   42: sipush 16384
    //   45: newarray byte
    //   47: astore 13
    //   49: aload 12
    //   51: astore 10
    //   53: aload 12
    //   55: astore 11
    //   57: aload_0
    //   58: aload 13
    //   60: invokevirtual 75	java/io/InputStream:read	([B)I
    //   63: istore 4
    //   65: iload 4
    //   67: iconst_m1
    //   68: if_icmpeq +284 -> 352
    //   71: aload 12
    //   73: astore 10
    //   75: aload 12
    //   77: astore 11
    //   79: aload 12
    //   81: aload 13
    //   83: iconst_0
    //   84: iload 4
    //   86: invokevirtual 81	java/io/OutputStream:write	([BII)V
    //   89: goto -40 -> 49
    //   92: aload 12
    //   94: astore 10
    //   96: aload 12
    //   98: astore 11
    //   100: new 83	com/tencent/luggage/wxa/rt/i
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 86	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload 12
    //   111: astore 10
    //   113: aload 12
    //   115: astore 11
    //   117: aload_1
    //   118: invokevirtual 90	com/tencent/luggage/wxa/rt/i:j	()Z
    //   121: ifeq +35 -> 156
    //   124: iload_3
    //   125: i2l
    //   126: lstore 6
    //   128: aload 12
    //   130: astore 10
    //   132: aload 12
    //   134: astore 11
    //   136: aload_1
    //   137: invokevirtual 94	com/tencent/luggage/wxa/rt/i:q	()J
    //   140: lstore 8
    //   142: lload 6
    //   144: lload 8
    //   146: lcmp
    //   147: ifne +9 -> 156
    //   150: iload 5
    //   152: istore_2
    //   153: goto +5 -> 158
    //   156: iconst_0
    //   157: istore_2
    //   158: iload_2
    //   159: istore 5
    //   161: aload_0
    //   162: ifnull +29 -> 191
    //   165: aload_0
    //   166: invokevirtual 97	java/io/InputStream:close	()V
    //   169: iload_2
    //   170: istore 5
    //   172: goto +19 -> 191
    //   175: astore_0
    //   176: ldc 25
    //   178: aload_0
    //   179: ldc 99
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: iconst_0
    //   189: istore 5
    //   191: aload 12
    //   193: ifnull +26 -> 219
    //   196: aload 12
    //   198: invokevirtual 103	java/io/OutputStream:close	()V
    //   201: goto +18 -> 219
    //   204: astore_0
    //   205: ldc 25
    //   207: aload_0
    //   208: ldc 99
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: iconst_0
    //   218: ireturn
    //   219: iload 5
    //   221: ireturn
    //   222: astore_1
    //   223: goto +71 -> 294
    //   226: astore_1
    //   227: aload 11
    //   229: astore 10
    //   231: ldc 25
    //   233: aload_1
    //   234: ldc 99
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload_0
    //   244: ifnull +23 -> 267
    //   247: aload_0
    //   248: invokevirtual 97	java/io/InputStream:close	()V
    //   251: goto +16 -> 267
    //   254: astore_0
    //   255: ldc 25
    //   257: aload_0
    //   258: ldc 99
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: aload 11
    //   269: ifnull +23 -> 292
    //   272: aload 11
    //   274: invokevirtual 103	java/io/OutputStream:close	()V
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_0
    //   280: ldc 25
    //   282: aload_0
    //   283: ldc 99
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: iconst_0
    //   293: ireturn
    //   294: aload_0
    //   295: ifnull +23 -> 318
    //   298: aload_0
    //   299: invokevirtual 97	java/io/InputStream:close	()V
    //   302: goto +16 -> 318
    //   305: astore_0
    //   306: ldc 25
    //   308: aload_0
    //   309: ldc 99
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload 10
    //   320: ifnull +24 -> 344
    //   323: aload 10
    //   325: invokevirtual 103	java/io/OutputStream:close	()V
    //   328: goto +16 -> 344
    //   331: astore_0
    //   332: ldc 25
    //   334: aload_0
    //   335: ldc 99
    //   337: iconst_0
    //   338: anewarray 4	java/lang/Object
    //   341: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: goto +5 -> 349
    //   347: aload_1
    //   348: athrow
    //   349: goto -2 -> 347
    //   352: iconst_1
    //   353: istore 5
    //   355: iload_2
    //   356: ifeq -264 -> 92
    //   359: iload 5
    //   361: istore_2
    //   362: goto -204 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramInputStream	java.io.InputStream
    //   0	365	1	paramString	String
    //   0	365	2	paramBoolean	boolean
    //   18	107	3	i	int
    //   63	22	4	j	int
    //   150	210	5	bool	boolean
    //   126	17	6	l1	long
    //   140	5	8	l2	long
    //   8	316	10	localObject1	Object
    //   12	261	11	localObject2	Object
    //   4	193	12	localOutputStream	java.io.OutputStream
    //   1	81	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   165	169	175	java/io/IOException
    //   196	201	204	java/io/IOException
    //   14	19	222	finally
    //   27	34	222	finally
    //   42	49	222	finally
    //   57	65	222	finally
    //   79	89	222	finally
    //   100	109	222	finally
    //   117	124	222	finally
    //   136	142	222	finally
    //   231	243	222	finally
    //   14	19	226	java/lang/Exception
    //   27	34	226	java/lang/Exception
    //   42	49	226	java/lang/Exception
    //   57	65	226	java/lang/Exception
    //   79	89	226	java/lang/Exception
    //   100	109	226	java/lang/Exception
    //   117	124	226	java/lang/Exception
    //   136	142	226	java/lang/Exception
    //   247	251	254	java/io/IOException
    //   272	277	279	java/io/IOException
    //   298	302	305	java/io/IOException
    //   323	328	331	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 110	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: ifne +340 -> 344
    //   7: aload_1
    //   8: invokestatic 110	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   11: ifeq +6 -> 17
    //   14: goto +330 -> 344
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: istore_3
    //   23: iconst_1
    //   24: istore 4
    //   26: iload_3
    //   27: ifeq +5 -> 32
    //   30: iconst_1
    //   31: ireturn
    //   32: aconst_null
    //   33: astore 8
    //   35: aconst_null
    //   36: astore 7
    //   38: aconst_null
    //   39: astore 5
    //   41: aconst_null
    //   42: astore 9
    //   44: aload_0
    //   45: invokestatic 118	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore 6
    //   50: aload 9
    //   52: astore_0
    //   53: aload 8
    //   55: astore 5
    //   57: aload_1
    //   58: invokestatic 121	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   61: astore_1
    //   62: aload_1
    //   63: astore_0
    //   64: aload_1
    //   65: astore 5
    //   67: sipush 16384
    //   70: newarray byte
    //   72: astore 7
    //   74: aload_1
    //   75: astore_0
    //   76: aload_1
    //   77: astore 5
    //   79: aload 6
    //   81: aload 7
    //   83: invokevirtual 75	java/io/InputStream:read	([B)I
    //   86: istore_2
    //   87: iload_2
    //   88: iconst_m1
    //   89: if_icmpeq +19 -> 108
    //   92: aload_1
    //   93: astore_0
    //   94: aload_1
    //   95: astore 5
    //   97: aload_1
    //   98: aload 7
    //   100: iconst_0
    //   101: iload_2
    //   102: invokevirtual 81	java/io/OutputStream:write	([BII)V
    //   105: goto -31 -> 74
    //   108: iload 4
    //   110: istore_3
    //   111: aload 6
    //   113: ifnull +29 -> 142
    //   116: aload 6
    //   118: invokevirtual 97	java/io/InputStream:close	()V
    //   121: iload 4
    //   123: istore_3
    //   124: goto +18 -> 142
    //   127: astore_0
    //   128: ldc 25
    //   130: aload_0
    //   131: ldc 99
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: iconst_0
    //   141: istore_3
    //   142: aload_1
    //   143: ifnull +25 -> 168
    //   146: aload_1
    //   147: invokevirtual 103	java/io/OutputStream:close	()V
    //   150: goto +18 -> 168
    //   153: astore_0
    //   154: ldc 25
    //   156: aload_0
    //   157: ldc 99
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: iconst_0
    //   167: ireturn
    //   168: iload_3
    //   169: ireturn
    //   170: astore_1
    //   171: aload 6
    //   173: astore 5
    //   175: goto +115 -> 290
    //   178: astore 7
    //   180: aload 6
    //   182: astore_0
    //   183: aload 5
    //   185: astore_1
    //   186: aload 7
    //   188: astore 5
    //   190: goto +24 -> 214
    //   193: astore_1
    //   194: aconst_null
    //   195: astore 6
    //   197: aload 5
    //   199: astore_0
    //   200: aload 6
    //   202: astore 5
    //   204: goto +86 -> 290
    //   207: astore 5
    //   209: aconst_null
    //   210: astore_1
    //   211: aload 7
    //   213: astore_0
    //   214: ldc 25
    //   216: aload 5
    //   218: ldc 99
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload_0
    //   228: ifnull +23 -> 251
    //   231: aload_0
    //   232: invokevirtual 97	java/io/InputStream:close	()V
    //   235: goto +16 -> 251
    //   238: astore_0
    //   239: ldc 25
    //   241: aload_0
    //   242: ldc 99
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload_1
    //   252: ifnull +22 -> 274
    //   255: aload_1
    //   256: invokevirtual 103	java/io/OutputStream:close	()V
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_0
    //   262: ldc 25
    //   264: aload_0
    //   265: ldc 99
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore 5
    //   278: aload_1
    //   279: astore 6
    //   281: aload 5
    //   283: astore_1
    //   284: aload_0
    //   285: astore 5
    //   287: aload 6
    //   289: astore_0
    //   290: aload 5
    //   292: ifnull +26 -> 318
    //   295: aload 5
    //   297: invokevirtual 97	java/io/InputStream:close	()V
    //   300: goto +18 -> 318
    //   303: astore 5
    //   305: ldc 25
    //   307: aload 5
    //   309: ldc 99
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_0
    //   319: ifnull +23 -> 342
    //   322: aload_0
    //   323: invokevirtual 103	java/io/OutputStream:close	()V
    //   326: goto +16 -> 342
    //   329: astore_0
    //   330: ldc 25
    //   332: aload_0
    //   333: ldc 99
    //   335: iconst_0
    //   336: anewarray 4	java/lang/Object
    //   339: invokestatic 102	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: aload_1
    //   343: athrow
    //   344: ldc 25
    //   346: ldc 123
    //   348: invokestatic 126	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: iconst_0
    //   352: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramString1	String
    //   0	353	1	paramString2	String
    //   86	16	2	i	int
    //   22	147	3	bool1	boolean
    //   24	98	4	bool2	boolean
    //   39	164	5	localObject1	Object
    //   207	10	5	localException1	java.lang.Exception
    //   276	6	5	localObject2	Object
    //   285	11	5	str	String
    //   303	5	5	localIOException	IOException
    //   48	240	6	localObject3	Object
    //   36	63	7	arrayOfByte	byte[]
    //   178	34	7	localException2	java.lang.Exception
    //   33	21	8	localObject4	Object
    //   42	9	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   116	121	127	java/io/IOException
    //   146	150	153	java/io/IOException
    //   57	62	170	finally
    //   67	74	170	finally
    //   79	87	170	finally
    //   97	105	170	finally
    //   57	62	178	java/lang/Exception
    //   67	74	178	java/lang/Exception
    //   79	87	178	java/lang/Exception
    //   97	105	178	java/lang/Exception
    //   44	50	193	finally
    //   44	50	207	java/lang/Exception
    //   231	235	238	java/io/IOException
    //   255	259	261	java/io/IOException
    //   214	227	276	finally
    //   295	300	303	java/io/IOException
    //   322	326	329	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = af.c(paramString1);
    int i = 0;
    if (bool) {
      return false;
    }
    Object localObject1 = new i(paramString1);
    if (!((i)localObject1).j()) {
      return false;
    }
    Object localObject2 = new i(paramString2);
    if (((i)localObject1).o())
    {
      if ((!((i)localObject2).o()) && (((i)localObject2).j())) {
        return false;
      }
      a(paramString1, paramString2);
      if (paramBoolean) {
        ((i)localObject1).w();
      }
    }
    else if (((i)localObject1).n())
    {
      if (!((i)localObject2).j()) {
        ((i)localObject2).t();
      }
      if (!((i)localObject2).n()) {
        return false;
      }
      localObject1 = ((i)localObject1).r();
      while (i < localObject1.length)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(localObject1[i]);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("/");
        localStringBuilder.append(localObject1[i]);
        a((String)localObject2, localStringBuilder.toString(), paramBoolean);
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.h
 * JD-Core Version:    0.7.0.1
 */