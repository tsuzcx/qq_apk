import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bgwf
{
  protected static MessageDigest a;
  protected static char[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload 9
    //   8: astore 7
    //   10: aload_0
    //   11: ifnull +153 -> 164
    //   14: aload 9
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 51	java/io/File:exists	()Z
    //   22: ifeq +142 -> 164
    //   25: aload 9
    //   27: astore 7
    //   29: aload_0
    //   30: invokevirtual 55	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +129 -> 164
    //   38: new 57	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore 8
    //   48: aload 8
    //   50: astore 7
    //   52: aload_0
    //   53: invokevirtual 55	java/io/File:length	()J
    //   56: lstore_1
    //   57: aload 8
    //   59: astore 7
    //   61: sipush 4096
    //   64: newarray byte
    //   66: astore_0
    //   67: lload_1
    //   68: lconst_0
    //   69: lcmp
    //   70: ifle +97 -> 167
    //   73: aload 8
    //   75: astore 7
    //   77: aload 8
    //   79: aload_0
    //   80: invokevirtual 65	java/io/FileInputStream:read	([B)I
    //   83: i2l
    //   84: lstore 5
    //   86: lload 5
    //   88: ldc2_w 66
    //   91: lcmp
    //   92: ifeq +75 -> 167
    //   95: lload 5
    //   97: lstore_3
    //   98: lload 5
    //   100: lload_1
    //   101: lcmp
    //   102: ifle +5 -> 107
    //   105: lload_1
    //   106: lstore_3
    //   107: lload_1
    //   108: lload_3
    //   109: lsub
    //   110: lstore_1
    //   111: aload 8
    //   113: astore 7
    //   115: getstatic 39	bgwf:jdField_a_of_type_JavaSecurityMessageDigest	Ljava/security/MessageDigest;
    //   118: aload_0
    //   119: iconst_0
    //   120: lload_3
    //   121: l2i
    //   122: invokestatic 73	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   125: invokevirtual 77	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   128: goto -61 -> 67
    //   131: astore 7
    //   133: aload 8
    //   135: astore_0
    //   136: aload 7
    //   138: astore 8
    //   140: aload_0
    //   141: astore 7
    //   143: aload 8
    //   145: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   148: aload 9
    //   150: astore 7
    //   152: aload_0
    //   153: ifnull +11 -> 164
    //   156: aload_0
    //   157: invokevirtual 83	java/io/FileInputStream:close	()V
    //   160: aload 9
    //   162: astore 7
    //   164: aload 7
    //   166: areturn
    //   167: aload 8
    //   169: astore 7
    //   171: aload 8
    //   173: invokevirtual 83	java/io/FileInputStream:close	()V
    //   176: aload 8
    //   178: astore 7
    //   180: getstatic 39	bgwf:jdField_a_of_type_JavaSecurityMessageDigest	Ljava/security/MessageDigest;
    //   183: invokevirtual 87	java/security/MessageDigest:digest	()[B
    //   186: astore 11
    //   188: aload 10
    //   190: astore_0
    //   191: aload 11
    //   193: ifnull +13 -> 206
    //   196: aload 8
    //   198: astore 7
    //   200: aload 11
    //   202: invokestatic 90	bgwf:a	([B)Ljava/lang/String;
    //   205: astore_0
    //   206: aload_0
    //   207: astore 7
    //   209: aload 8
    //   211: ifnull -47 -> 164
    //   214: aload 8
    //   216: invokevirtual 83	java/io/FileInputStream:close	()V
    //   219: aload_0
    //   220: areturn
    //   221: astore 7
    //   223: aload 7
    //   225: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   228: aload_0
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 7
    //   241: aload 7
    //   243: ifnull +8 -> 251
    //   246: aload 7
    //   248: invokevirtual 83	java/io/FileInputStream:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore 7
    //   255: aload 7
    //   257: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   260: goto -9 -> 251
    //   263: astore_0
    //   264: goto -23 -> 241
    //   267: astore 8
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -131 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramFile	java.io.File
    //   56	55	1	l1	long
    //   97	24	3	l2	long
    //   84	15	5	l3	long
    //   8	106	7	localObject1	Object
    //   131	6	7	localThrowable1	java.lang.Throwable
    //   141	67	7	localObject2	Object
    //   221	3	7	localIOException1	java.io.IOException
    //   239	8	7	localObject3	Object
    //   253	3	7	localIOException2	java.io.IOException
    //   46	169	8	localObject4	Object
    //   267	1	8	localThrowable2	java.lang.Throwable
    //   4	157	9	localObject5	Object
    //   1	188	10	localObject6	Object
    //   186	15	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	57	131	java/lang/Throwable
    //   61	67	131	java/lang/Throwable
    //   77	86	131	java/lang/Throwable
    //   115	128	131	java/lang/Throwable
    //   171	176	131	java/lang/Throwable
    //   180	188	131	java/lang/Throwable
    //   200	206	131	java/lang/Throwable
    //   214	219	221	java/io/IOException
    //   156	160	230	java/io/IOException
    //   38	48	237	finally
    //   246	251	253	java/io/IOException
    //   52	57	263	finally
    //   61	67	263	finally
    //   77	86	263	finally
    //   115	128	263	finally
    //   143	148	263	finally
    //   171	176	263	finally
    //   180	188	263	finally
    //   200	206	263	finally
    //   38	48	267	java/lang/Throwable
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = jdField_a_of_type_ArrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwf
 * JD-Core Version:    0.7.0.1
 */