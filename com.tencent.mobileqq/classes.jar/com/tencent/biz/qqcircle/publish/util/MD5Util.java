package com.tencent.biz.qqcircle.publish.util;

public class MD5Util
{
  /* Error */
  public static java.lang.String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 15
    //   6: areturn
    //   7: new 17	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 20	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_0
    //   16: sipush 8192
    //   19: newarray byte
    //   21: astore 6
    //   23: bipush 16
    //   25: newarray char
    //   27: astore 5
    //   29: aload 5
    //   31: dup
    //   32: iconst_0
    //   33: ldc 21
    //   35: castore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 22
    //   40: castore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 23
    //   45: castore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 24
    //   50: castore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 25
    //   55: castore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 26
    //   60: castore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 27
    //   66: castore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 28
    //   72: castore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 29
    //   78: castore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 30
    //   84: castore
    //   85: dup
    //   86: bipush 10
    //   88: ldc 31
    //   90: castore
    //   91: dup
    //   92: bipush 11
    //   94: ldc 32
    //   96: castore
    //   97: dup
    //   98: bipush 12
    //   100: ldc 33
    //   102: castore
    //   103: dup
    //   104: bipush 13
    //   106: ldc 34
    //   108: castore
    //   109: dup
    //   110: bipush 14
    //   112: ldc 35
    //   114: castore
    //   115: dup
    //   116: bipush 15
    //   118: ldc 36
    //   120: castore
    //   121: pop
    //   122: ldc 38
    //   124: invokestatic 44	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   127: astore 7
    //   129: aload 6
    //   131: arraylength
    //   132: istore_1
    //   133: iconst_0
    //   134: istore_2
    //   135: aload_0
    //   136: aload 6
    //   138: iconst_0
    //   139: iload_1
    //   140: invokevirtual 48	java/io/FileInputStream:read	([BII)I
    //   143: istore_1
    //   144: iload_1
    //   145: iconst_m1
    //   146: if_icmpeq +15 -> 161
    //   149: aload 7
    //   151: aload 6
    //   153: iconst_0
    //   154: iload_1
    //   155: invokevirtual 52	java/security/MessageDigest:update	([BII)V
    //   158: goto -29 -> 129
    //   161: aload_0
    //   162: invokevirtual 55	java/io/FileInputStream:close	()V
    //   165: aload 7
    //   167: invokevirtual 59	java/security/MessageDigest:digest	()[B
    //   170: astore 6
    //   172: bipush 32
    //   174: newarray char
    //   176: astore 7
    //   178: iconst_0
    //   179: istore_1
    //   180: goto +50 -> 230
    //   183: new 61	java/lang/String
    //   186: dup
    //   187: aload 7
    //   189: invokespecial 64	java/lang/String:<init>	([C)V
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 55	java/io/FileInputStream:close	()V
    //   198: aload 5
    //   200: areturn
    //   201: astore 5
    //   203: goto +16 -> 219
    //   206: astore 5
    //   208: aload 5
    //   210: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   213: aload_0
    //   214: invokevirtual 55	java/io/FileInputStream:close	()V
    //   217: aconst_null
    //   218: areturn
    //   219: aload_0
    //   220: invokevirtual 55	java/io/FileInputStream:close	()V
    //   223: aload 5
    //   225: athrow
    //   226: astore_0
    //   227: ldc 15
    //   229: areturn
    //   230: iload_2
    //   231: bipush 16
    //   233: if_icmpge -50 -> 183
    //   236: aload 6
    //   238: iload_2
    //   239: baload
    //   240: istore_3
    //   241: iload_1
    //   242: iconst_1
    //   243: iadd
    //   244: istore 4
    //   246: aload 7
    //   248: iload_1
    //   249: aload 5
    //   251: iload_3
    //   252: iconst_4
    //   253: iushr
    //   254: bipush 15
    //   256: iand
    //   257: caload
    //   258: castore
    //   259: iload 4
    //   261: iconst_1
    //   262: iadd
    //   263: istore_1
    //   264: aload 7
    //   266: iload 4
    //   268: aload 5
    //   270: iload_3
    //   271: bipush 15
    //   273: iand
    //   274: caload
    //   275: castore
    //   276: iload_2
    //   277: iconst_1
    //   278: iadd
    //   279: istore_2
    //   280: goto -50 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramFile	java.io.File
    //   132	132	1	i	int
    //   134	146	2	j	int
    //   240	34	3	k	int
    //   244	23	4	m	int
    //   27	172	5	localObject1	Object
    //   201	1	5	localObject2	Object
    //   206	63	5	localException	java.lang.Exception
    //   21	216	6	arrayOfByte	byte[]
    //   127	138	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   122	129	201	finally
    //   129	133	201	finally
    //   135	144	201	finally
    //   149	158	201	finally
    //   161	178	201	finally
    //   183	194	201	finally
    //   208	213	201	finally
    //   122	129	206	java/lang/Exception
    //   129	133	206	java/lang/Exception
    //   135	144	206	java/lang/Exception
    //   149	158	206	java/lang/Exception
    //   161	178	206	java/lang/Exception
    //   183	194	206	java/lang/Exception
    //   7	16	226	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.MD5Util
 * JD-Core Version:    0.7.0.1
 */