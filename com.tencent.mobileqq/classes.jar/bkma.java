public class bkma
{
  /* Error */
  public static long a(java.lang.String paramString, long paramLong)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 9
    //   3: sipush 8192
    //   6: newarray byte
    //   8: astore 13
    //   10: new 10	java/util/zip/CRC32
    //   13: dup
    //   14: invokespecial 14	java/util/zip/CRC32:<init>	()V
    //   17: astore 14
    //   19: new 16	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 19	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: lload_1
    //   29: lstore 5
    //   31: lconst_0
    //   32: lstore 7
    //   34: aload_0
    //   35: aload 13
    //   37: invokevirtual 25	java/io/InputStream:read	([B)I
    //   40: istore 4
    //   42: iload 4
    //   44: ifle +52 -> 96
    //   47: iload 4
    //   49: istore_3
    //   50: lload 5
    //   52: iload 4
    //   54: i2l
    //   55: lcmp
    //   56: ifge +7 -> 63
    //   59: lload 5
    //   61: l2i
    //   62: istore_3
    //   63: aload 14
    //   65: aload 13
    //   67: iconst_0
    //   68: iload_3
    //   69: invokevirtual 29	java/util/zip/CRC32:update	([BII)V
    //   72: lload 7
    //   74: iload_3
    //   75: i2l
    //   76: ladd
    //   77: lstore 7
    //   79: lload_1
    //   80: lload 7
    //   82: lsub
    //   83: lstore 11
    //   85: lload 11
    //   87: lstore 5
    //   89: lload 11
    //   91: lconst_0
    //   92: lcmp
    //   93: ifgt -59 -> 34
    //   96: aload_0
    //   97: invokevirtual 32	java/io/InputStream:close	()V
    //   100: aload 14
    //   102: invokevirtual 36	java/util/zip/CRC32:getValue	()J
    //   105: lstore_1
    //   106: lload_1
    //   107: lstore 5
    //   109: aload_0
    //   110: ifnull +10 -> 120
    //   113: aload_0
    //   114: invokevirtual 32	java/io/InputStream:close	()V
    //   117: lload_1
    //   118: lstore 5
    //   120: lload 5
    //   122: lreturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: lload 9
    //   128: lstore 5
    //   130: aload_0
    //   131: ifnull -11 -> 120
    //   134: aload_0
    //   135: invokevirtual 32	java/io/InputStream:close	()V
    //   138: lconst_0
    //   139: lreturn
    //   140: astore_0
    //   141: lconst_0
    //   142: lreturn
    //   143: astore 13
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 32	java/io/InputStream:close	()V
    //   155: aload 13
    //   157: athrow
    //   158: astore_0
    //   159: lload_1
    //   160: lreturn
    //   161: astore_0
    //   162: goto -7 -> 155
    //   165: astore 13
    //   167: goto -20 -> 147
    //   170: astore 13
    //   172: goto -46 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramString	java.lang.String
    //   0	175	1	paramLong	long
    //   49	26	3	i	int
    //   40	13	4	j	int
    //   29	100	5	l1	long
    //   32	49	7	l2	long
    //   1	126	9	l3	long
    //   83	7	11	l4	long
    //   8	58	13	arrayOfByte	byte[]
    //   143	13	13	localObject1	Object
    //   165	1	13	localObject2	Object
    //   170	1	13	localIOException	java.io.IOException
    //   17	84	14	localCRC32	java.util.zip.CRC32
    // Exception table:
    //   from	to	target	type
    //   19	28	123	java/io/IOException
    //   134	138	140	java/io/IOException
    //   19	28	143	finally
    //   113	117	158	java/io/IOException
    //   151	155	161	java/io/IOException
    //   34	42	165	finally
    //   63	72	165	finally
    //   96	106	165	finally
    //   34	42	170	java/io/IOException
    //   63	72	170	java/io/IOException
    //   96	106	170	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkma
 * JD-Core Version:    0.7.0.1
 */