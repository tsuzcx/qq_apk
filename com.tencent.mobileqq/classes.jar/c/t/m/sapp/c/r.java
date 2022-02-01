package c.t.m.sapp.c;

import java.io.File;

public class r
{
  public String a = "WriterAndReader";
  public File b = null;
  
  public r(String paramString)
  {
    this.b = new File(paramString);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: new 29	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 5
    //   15: aload 5
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 19	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   23: invokevirtual 34	java/io/File:exists	()Z
    //   26: istore_3
    //   27: iload_3
    //   28: ifne +18 -> 46
    //   31: new 36	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 37	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: aload 7
    //   41: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: aload 5
    //   48: astore 4
    //   50: new 42	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: getfield 19	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   58: invokevirtual 46	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: sipush 10240
    //   69: newarray byte
    //   71: astore 4
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 51	java/io/FileInputStream:read	([B)I
    //   80: istore_2
    //   81: iload_2
    //   82: iconst_m1
    //   83: if_icmpeq +15 -> 98
    //   86: aload 7
    //   88: aload 4
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 55	java/io/ByteArrayOutputStream:write	([BII)V
    //   95: goto -22 -> 73
    //   98: aload 7
    //   100: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   103: new 57	java/lang/String
    //   106: dup
    //   107: aload 7
    //   109: invokevirtual 61	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   112: invokespecial 64	java/lang/String:<init>	([B)V
    //   115: astore 4
    //   117: aload 5
    //   119: invokevirtual 65	java/io/FileInputStream:close	()V
    //   122: aload 5
    //   124: invokevirtual 65	java/io/FileInputStream:close	()V
    //   127: aload 7
    //   129: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   132: aload 4
    //   134: areturn
    //   135: astore_1
    //   136: aload 5
    //   138: astore 4
    //   140: goto +31 -> 171
    //   143: goto +7 -> 150
    //   146: astore_1
    //   147: goto +24 -> 171
    //   150: aload 5
    //   152: astore 4
    //   154: aload 5
    //   156: invokevirtual 65	java/io/FileInputStream:close	()V
    //   159: aload 5
    //   161: astore 4
    //   163: aload 7
    //   165: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   168: goto +15 -> 183
    //   171: aload 4
    //   173: invokevirtual 65	java/io/FileInputStream:close	()V
    //   176: aload 7
    //   178: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   181: aload_1
    //   182: athrow
    //   183: aload 5
    //   185: invokevirtual 65	java/io/FileInputStream:close	()V
    //   188: aload 7
    //   190: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   193: aload_1
    //   194: areturn
    //   195: astore 4
    //   197: aload 6
    //   199: astore 5
    //   201: goto -51 -> 150
    //   204: astore 4
    //   206: goto -167 -> 39
    //   209: astore 4
    //   211: aload_1
    //   212: areturn
    //   213: astore 4
    //   215: goto -72 -> 143
    //   218: astore_1
    //   219: goto -92 -> 127
    //   222: astore_1
    //   223: aload 4
    //   225: areturn
    //   226: astore 4
    //   228: goto -69 -> 159
    //   231: astore 4
    //   233: goto -50 -> 183
    //   236: astore 4
    //   238: goto -62 -> 176
    //   241: astore 4
    //   243: goto -62 -> 181
    //   246: astore 4
    //   248: goto -60 -> 188
    //   251: astore 4
    //   253: aload_1
    //   254: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	r
    //   0	255	1	paramString	String
    //   80	12	2	i	int
    //   26	2	3	bool	boolean
    //   17	155	4	localObject1	Object
    //   195	1	4	localException1	java.lang.Exception
    //   204	1	4	localException2	java.lang.Exception
    //   209	1	4	localException3	java.lang.Exception
    //   213	11	4	localException4	java.lang.Exception
    //   226	1	4	localException5	java.lang.Exception
    //   231	1	4	localException6	java.lang.Exception
    //   236	1	4	localException7	java.lang.Exception
    //   241	1	4	localException8	java.lang.Exception
    //   246	1	4	localException9	java.lang.Exception
    //   251	1	4	localException10	java.lang.Exception
    //   13	187	5	localObject2	Object
    //   10	188	6	localObject3	Object
    //   7	182	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   66	73	135	finally
    //   73	81	135	finally
    //   86	95	135	finally
    //   98	122	135	finally
    //   19	27	146	finally
    //   50	66	146	finally
    //   154	159	146	finally
    //   163	168	146	finally
    //   19	27	195	java/lang/Exception
    //   50	66	195	java/lang/Exception
    //   31	39	204	java/lang/Exception
    //   39	44	209	java/lang/Exception
    //   66	73	213	java/lang/Exception
    //   73	81	213	java/lang/Exception
    //   86	95	213	java/lang/Exception
    //   98	122	213	java/lang/Exception
    //   122	127	218	java/lang/Exception
    //   127	132	222	java/lang/Exception
    //   154	159	226	java/lang/Exception
    //   163	168	231	java/lang/Exception
    //   171	176	236	java/lang/Exception
    //   176	181	241	java/lang/Exception
    //   183	188	246	java/lang/Exception
    //   188	193	251	java/lang/Exception
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 19	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   10: invokevirtual 34	java/io/File:exists	()Z
    //   13: ifne +38 -> 51
    //   16: new 21	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 19	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   24: invokevirtual 69	java/io/File:getParent	()Ljava/lang/String;
    //   27: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 34	java/io/File:exists	()Z
    //   35: ifne +16 -> 51
    //   38: aload_3
    //   39: invokevirtual 72	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: aload_0
    //   44: getfield 19	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   47: invokevirtual 75	java/io/File:createNewFile	()Z
    //   50: pop
    //   51: new 77	java/io/FileOutputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 19	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   59: iload_2
    //   60: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   63: astore_3
    //   64: aload_3
    //   65: aload_1
    //   66: invokevirtual 82	java/io/FileOutputStream:write	([B)V
    //   69: aload_3
    //   70: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   73: aload_3
    //   74: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   77: iconst_1
    //   78: ireturn
    //   79: astore_1
    //   80: goto +10 -> 90
    //   83: goto +13 -> 96
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: aload_3
    //   97: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload 5
    //   105: astore_3
    //   106: goto -10 -> 96
    //   109: astore_1
    //   110: goto -27 -> 83
    //   113: astore_1
    //   114: iconst_1
    //   115: ireturn
    //   116: astore_3
    //   117: goto -23 -> 94
    //   120: astore_1
    //   121: iconst_0
    //   122: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	r
    //   0	123	1	paramArrayOfByte	byte[]
    //   0	123	2	paramBoolean	boolean
    //   30	76	3	localObject1	Object
    //   116	1	3	localException	java.lang.Exception
    //   4	84	4	localObject2	Object
    //   1	103	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   64	73	79	finally
    //   6	51	86	finally
    //   51	64	86	finally
    //   6	51	102	java/lang/Exception
    //   51	64	102	java/lang/Exception
    //   64	73	109	java/lang/Exception
    //   73	77	113	java/lang/Exception
    //   90	94	116	java/lang/Exception
    //   96	100	120	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.r
 * JD-Core Version:    0.7.0.1
 */