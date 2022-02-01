package com.tencent.mobileqq.activity.photo.incompatiblephoto;

public class PhotoWebp
  extends PhotoIncompatibleBase
{
  private static final byte[] d = "WEBP".getBytes();
  private static final byte[] e = "RIFF".getBytes();
  
  public PhotoWebp(String paramString)
  {
    super(paramString);
    this.a = "PhotoIncompatibleWebp";
    this.b = "reportGenerateWebp";
  }
  
  /* Error */
  static boolean a(String paramString)
  {
    // Byte code:
    //   0: bipush 16
    //   2: newarray byte
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 4
    //   12: new 46	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: aload 5
    //   24: invokevirtual 51	java/io/FileInputStream:read	([B)I
    //   27: pop
    //   28: aload 5
    //   30: arraylength
    //   31: istore_1
    //   32: iload_1
    //   33: bipush 12
    //   35: if_icmpge +16 -> 51
    //   38: aload_0
    //   39: invokevirtual 54	java/io/FileInputStream:close	()V
    //   42: iconst_0
    //   43: ireturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   49: iconst_0
    //   50: ireturn
    //   51: iconst_0
    //   52: istore_1
    //   53: iload_1
    //   54: getstatic 23	com/tencent/mobileqq/activity/photo/incompatiblephoto/PhotoWebp:e	[B
    //   57: arraylength
    //   58: if_icmpge +39 -> 97
    //   61: getstatic 23	com/tencent/mobileqq/activity/photo/incompatiblephoto/PhotoWebp:e	[B
    //   64: iload_1
    //   65: baload
    //   66: istore_2
    //   67: aload 5
    //   69: iload_1
    //   70: baload
    //   71: istore_3
    //   72: iload_2
    //   73: iload_3
    //   74: if_icmpeq +16 -> 90
    //   77: aload_0
    //   78: invokevirtual 54	java/io/FileInputStream:close	()V
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: iload_1
    //   91: iconst_1
    //   92: iadd
    //   93: istore_1
    //   94: goto -41 -> 53
    //   97: bipush 8
    //   99: istore_1
    //   100: iload_1
    //   101: bipush 12
    //   103: if_icmpge +42 -> 145
    //   106: getstatic 19	com/tencent/mobileqq/activity/photo/incompatiblephoto/PhotoWebp:d	[B
    //   109: iload_1
    //   110: bipush 8
    //   112: isub
    //   113: baload
    //   114: istore_2
    //   115: aload 5
    //   117: iload_1
    //   118: baload
    //   119: istore_3
    //   120: iload_2
    //   121: iload_3
    //   122: if_icmpeq +16 -> 138
    //   125: aload_0
    //   126: invokevirtual 54	java/io/FileInputStream:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore_1
    //   142: goto -42 -> 100
    //   145: aload_0
    //   146: invokevirtual 54	java/io/FileInputStream:close	()V
    //   149: goto +8 -> 157
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore 4
    //   161: goto +50 -> 211
    //   164: astore 5
    //   166: goto +20 -> 186
    //   169: astore 5
    //   171: aload 4
    //   173: astore_0
    //   174: aload 5
    //   176: astore 4
    //   178: goto +33 -> 211
    //   181: astore 5
    //   183: aload 6
    //   185: astore_0
    //   186: aload_0
    //   187: astore 4
    //   189: aload 5
    //   191: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   194: aload_0
    //   195: ifnull +14 -> 209
    //   198: aload_0
    //   199: invokevirtual 54	java/io/FileInputStream:close	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: aload_0
    //   212: ifnull +15 -> 227
    //   215: aload_0
    //   216: invokevirtual 54	java/io/FileInputStream:close	()V
    //   219: goto +8 -> 227
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   227: goto +6 -> 233
    //   230: aload 4
    //   232: athrow
    //   233: goto -3 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   31	111	1	i	int
    //   66	57	2	j	int
    //   71	52	3	k	int
    //   10	1	4	localObject1	java.lang.Object
    //   159	13	4	localObject2	java.lang.Object
    //   176	55	4	localObject3	java.lang.Object
    //   4	112	5	arrayOfByte	byte[]
    //   164	1	5	localException1	java.lang.Exception
    //   169	6	5	localObject4	java.lang.Object
    //   181	9	5	localException2	java.lang.Exception
    //   7	177	6	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   38	42	44	java/io/IOException
    //   77	81	83	java/io/IOException
    //   125	129	131	java/io/IOException
    //   145	149	152	java/io/IOException
    //   21	32	159	finally
    //   53	67	159	finally
    //   106	115	159	finally
    //   21	32	164	java/lang/Exception
    //   53	67	164	java/lang/Exception
    //   106	115	164	java/lang/Exception
    //   12	21	169	finally
    //   189	194	169	finally
    //   12	21	181	java/lang/Exception
    //   198	202	204	java/io/IOException
    //   215	219	222	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoWebp
 * JD-Core Version:    0.7.0.1
 */