package com.tencent.image;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  protected static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static MessageDigest messagedigest = null;
  
  static
  {
    try
    {
      messagedigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char[] arrayOfChar = hexDigits;
    char c1 = arrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = arrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] byteArrayToMd5(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      messagedigest.update(paramString.getBytes());
      return messagedigest.digest();
    }
    return null;
  }
  
  /* Error */
  public static String getMd5(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_1
    //   8: aload 4
    //   10: astore_2
    //   11: aload 5
    //   13: astore_3
    //   14: aload_0
    //   15: instanceof 70
    //   18: ifeq +24 -> 42
    //   21: aload 4
    //   23: astore_2
    //   24: aload 5
    //   26: astore_3
    //   27: new 93	java/io/FileInputStream
    //   30: dup
    //   31: aload_0
    //   32: checkcast 70	java/lang/String
    //   35: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   38: astore_0
    //   39: goto +157 -> 196
    //   42: aload 4
    //   44: astore_2
    //   45: aload 5
    //   47: astore_3
    //   48: aload_0
    //   49: instanceof 98
    //   52: ifeq +24 -> 76
    //   55: aload 4
    //   57: astore_2
    //   58: aload 5
    //   60: astore_3
    //   61: new 93	java/io/FileInputStream
    //   64: dup
    //   65: aload_0
    //   66: checkcast 98	java/io/FileDescriptor
    //   69: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   72: astore_0
    //   73: goto +123 -> 196
    //   76: aload 4
    //   78: astore_2
    //   79: aload 5
    //   81: astore_3
    //   82: aload_0
    //   83: instanceof 103
    //   86: ifeq +27 -> 113
    //   89: aload 4
    //   91: astore_2
    //   92: aload 5
    //   94: astore_3
    //   95: new 105	java/io/ByteArrayInputStream
    //   98: dup
    //   99: aload_0
    //   100: checkcast 103	[B
    //   103: checkcast 103	[B
    //   106: invokespecial 107	java/io/ByteArrayInputStream:<init>	([B)V
    //   109: astore_0
    //   110: goto +86 -> 196
    //   113: aload_1
    //   114: ifnull +15 -> 129
    //   117: aload_1
    //   118: astore_2
    //   119: aload_1
    //   120: astore_3
    //   121: aload_1
    //   122: invokestatic 111	com/tencent/image/MD5Util:getStreamMD5String	(Ljava/io/InputStream;)Ljava/lang/String;
    //   125: astore_0
    //   126: goto +6 -> 132
    //   129: ldc 113
    //   131: astore_0
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 118	java/io/InputStream:close	()V
    //   140: aload_0
    //   141: areturn
    //   142: astore_0
    //   143: goto +29 -> 172
    //   146: astore_0
    //   147: aload_3
    //   148: astore_2
    //   149: aload_0
    //   150: invokevirtual 121	java/io/FileNotFoundException:printStackTrace	()V
    //   153: aload_3
    //   154: ifnull +15 -> 169
    //   157: aload_3
    //   158: invokevirtual 118	java/io/InputStream:close	()V
    //   161: ldc 113
    //   163: areturn
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   169: ldc 113
    //   171: areturn
    //   172: aload_2
    //   173: ifnull +15 -> 188
    //   176: aload_2
    //   177: invokevirtual 118	java/io/InputStream:close	()V
    //   180: goto +8 -> 188
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   188: goto +5 -> 193
    //   191: aload_0
    //   192: athrow
    //   193: goto -2 -> 191
    //   196: aload_0
    //   197: astore_1
    //   198: goto -85 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramObject	Object
    //   7	130	1	localInputStream	java.io.InputStream
    //   183	2	1	localIOException	java.io.IOException
    //   197	1	1	localObject1	Object
    //   10	167	2	localObject2	Object
    //   13	145	3	localObject3	Object
    //   1	89	4	localObject4	Object
    //   4	89	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	142	finally
    //   27	39	142	finally
    //   48	55	142	finally
    //   61	73	142	finally
    //   82	89	142	finally
    //   95	110	142	finally
    //   121	126	142	finally
    //   149	153	142	finally
    //   14	21	146	java/io/FileNotFoundException
    //   27	39	146	java/io/FileNotFoundException
    //   48	55	146	java/io/FileNotFoundException
    //   61	73	146	java/io/FileNotFoundException
    //   82	89	146	java/io/FileNotFoundException
    //   95	110	146	java/io/FileNotFoundException
    //   121	126	146	java/io/FileNotFoundException
    //   136	140	164	java/io/IOException
    //   157	161	164	java/io/IOException
    //   176	180	183	java/io/IOException
  }
  
  /* Error */
  public static String getStreamMD5String(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 10
    //   11: astore 8
    //   13: aload_0
    //   14: ifnull +173 -> 187
    //   17: aload_0
    //   18: invokevirtual 127	java/io/InputStream:available	()I
    //   21: i2l
    //   22: lstore_1
    //   23: sipush 4096
    //   26: newarray byte
    //   28: astore 8
    //   30: lload_1
    //   31: lconst_0
    //   32: lcmp
    //   33: ifle +54 -> 87
    //   36: aload_0
    //   37: aload 8
    //   39: invokevirtual 131	java/io/InputStream:read	([B)I
    //   42: i2l
    //   43: lstore 5
    //   45: lload 5
    //   47: ldc2_w 132
    //   50: lcmp
    //   51: ifeq +36 -> 87
    //   54: lload 5
    //   56: lstore_3
    //   57: lload 5
    //   59: lload_1
    //   60: lcmp
    //   61: ifle +5 -> 66
    //   64: lload_1
    //   65: lstore_3
    //   66: lload_1
    //   67: lload_3
    //   68: lsub
    //   69: lstore_1
    //   70: getstatic 32	com/tencent/image/MD5Util:messagedigest	Ljava/security/MessageDigest;
    //   73: aload 8
    //   75: iconst_0
    //   76: lload_3
    //   77: l2i
    //   78: invokestatic 139	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   81: invokevirtual 142	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   84: goto -54 -> 30
    //   87: aload_0
    //   88: invokevirtual 118	java/io/InputStream:close	()V
    //   91: getstatic 32	com/tencent/image/MD5Util:messagedigest	Ljava/security/MessageDigest;
    //   94: invokevirtual 85	java/security/MessageDigest:digest	()[B
    //   97: astore 8
    //   99: aload 8
    //   101: ifnull +10 -> 111
    //   104: aload 8
    //   106: invokestatic 144	com/tencent/image/MD5Util:bufferToHex	([B)Ljava/lang/String;
    //   109: astore 7
    //   111: aload 7
    //   113: astore 8
    //   115: aload_0
    //   116: ifnull +71 -> 187
    //   119: aload 7
    //   121: astore 8
    //   123: aload_0
    //   124: invokevirtual 118	java/io/InputStream:close	()V
    //   127: aload 7
    //   129: areturn
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   135: aload 8
    //   137: areturn
    //   138: astore 7
    //   140: goto +28 -> 168
    //   143: astore 7
    //   145: aload 7
    //   147: invokevirtual 145	java/lang/Throwable:printStackTrace	()V
    //   150: aload 10
    //   152: astore 8
    //   154: aload_0
    //   155: ifnull +32 -> 187
    //   158: aload 9
    //   160: astore 8
    //   162: aload_0
    //   163: invokevirtual 118	java/io/InputStream:close	()V
    //   166: aconst_null
    //   167: areturn
    //   168: aload_0
    //   169: ifnull +15 -> 184
    //   172: aload_0
    //   173: invokevirtual 118	java/io/InputStream:close	()V
    //   176: goto +8 -> 184
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   184: aload 7
    //   186: athrow
    //   187: aload 8
    //   189: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramInputStream	java.io.InputStream
    //   22	48	1	l1	long
    //   56	21	3	l2	long
    //   43	15	5	l3	long
    //   7	121	7	str	String
    //   138	1	7	localObject1	Object
    //   143	42	7	localThrowable	java.lang.Throwable
    //   11	177	8	localObject2	Object
    //   1	158	9	localObject3	Object
    //   4	147	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   123	127	130	java/io/IOException
    //   162	166	130	java/io/IOException
    //   17	30	138	finally
    //   36	45	138	finally
    //   70	84	138	finally
    //   87	99	138	finally
    //   104	111	138	finally
    //   145	150	138	finally
    //   17	30	143	java/lang/Throwable
    //   36	45	143	java/lang/Throwable
    //   70	84	143	java/lang/Throwable
    //   87	99	143	java/lang/Throwable
    //   104	111	143	java/lang/Throwable
    //   172	176	179	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.MD5Util
 * JD-Core Version:    0.7.0.1
 */