import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bfgc
{
  protected static Comparator a;
  protected static List<String> a;
  static final byte[] jdField_a_of_type_ArrayOfByte = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  protected static Comparator<File> b;
  private long[] jdField_a_of_type_ArrayOfLong = new long[4];
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[64];
  private long[] jdField_b_of_type_ArrayOfLong = new long[2];
  private byte[] c = new byte[16];
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new bfge();
    jdField_b_of_type_JavaUtilComparator = new bfgd();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public bfgc()
  {
    a();
  }
  
  public static long a(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong2 | (0xFFFFFFFF ^ paramLong1) & paramLong3;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = a(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    return bffx.a(a(paramString));
  }
  
  private void a()
  {
    this.jdField_b_of_type_ArrayOfLong[0] = 0L;
    this.jdField_b_of_type_ArrayOfLong[1] = 0L;
    this.jdField_a_of_type_ArrayOfLong[0] = 1732584193L;
    this.jdField_a_of_type_ArrayOfLong[1] = 4023233417L;
    this.jdField_a_of_type_ArrayOfLong[2] = 2562383102L;
    this.jdField_a_of_type_ArrayOfLong[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l2 = this.jdField_a_of_type_ArrayOfLong[0];
    long l1 = this.jdField_a_of_type_ArrayOfLong[1];
    long l4 = this.jdField_a_of_type_ArrayOfLong[2];
    long l3 = this.jdField_a_of_type_ArrayOfLong[3];
    long[] arrayOfLong = new long[16];
    a(arrayOfLong, paramArrayOfByte, 64);
    l2 = a(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[1] = (l1 + paramArrayOfByte[1]);
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[3] += l3;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[64];
    int k = (int)(this.jdField_b_of_type_ArrayOfLong[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
    long l = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l;
    if (l < paramInt << 3)
    {
      arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
    arrayOfLong[1] += (paramInt >>> 29);
    int m = 64 - k;
    int i = k;
    if (paramInt >= m)
    {
      a(this.jdField_b_of_type_ArrayOfByte, paramArrayOfByte, k, 0, m);
      a(this.jdField_b_of_type_ArrayOfByte);
      i = m;
      while (i + 63 < paramInt)
      {
        a(arrayOfByte, paramArrayOfByte, 0, i, 64);
        a(arrayOfByte);
        i += 64;
      }
      k = 0;
      j = i;
      i = k;
    }
    a(this.jdField_b_of_type_ArrayOfByte, paramArrayOfByte, i, j, paramInt - j);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(paramArrayOfLong[j] >>> 24 & 0xFF));
      j += 1;
      i += 4;
    }
  }
  
  private void a(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfLong[j] = (a(paramArrayOfByte[i]) | a(paramArrayOfByte[(i + 1)]) << 8 | a(paramArrayOfByte[(i + 2)]) << 16 | a(paramArrayOfByte[(i + 3)]) << 24);
      j += 1;
      i += 4;
    }
  }
  
  private boolean a(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.jdField_b_of_type_ArrayOfLong[0] >>> 3) & 0x3F;
    Object localObject = this.jdField_b_of_type_ArrayOfLong;
    long l = localObject[0] + (paramLong << 3);
    localObject[0] = l;
    if (l < paramLong << 3)
    {
      localObject = this.jdField_b_of_type_ArrayOfLong;
      localObject[1] += 1L;
    }
    localObject = this.jdField_b_of_type_ArrayOfLong;
    localObject[1] += (paramLong >>> 29);
    int i = 64 - j;
    if (paramLong >= i)
    {
      localObject = new byte[i];
      try
      {
        paramInputStream.read((byte[])localObject, 0, i);
        a(this.jdField_b_of_type_ArrayOfByte, (byte[])localObject, j, 0, i);
        a(this.jdField_b_of_type_ArrayOfByte);
      }
      catch (Exception paramInputStream)
      {
        try
        {
          paramInputStream.read(arrayOfByte);
          a(arrayOfByte);
          i += 64;
        }
        catch (Exception paramInputStream)
        {
          paramInputStream.printStackTrace();
          return false;
        }
        paramInputStream = paramInputStream;
        paramInputStream.printStackTrace();
        return false;
      }
      if (i + 63 < paramLong) {}
      j = 0;
    }
    for (;;)
    {
      arrayOfByte = new byte[(int)(paramLong - i)];
      try
      {
        paramInputStream.read(arrayOfByte);
        a(this.jdField_b_of_type_ArrayOfByte, arrayOfByte, j, 0, arrayOfByte.length);
        return true;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
      i = 0;
    }
    return false;
  }
  
  /* Error */
  protected static byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc_w 300
    //   3: invokestatic 306	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   6: astore_3
    //   7: new 308	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 311	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 315	java/io/File:exists	()Z
    //   20: ifne +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: new 317	java/io/BufferedInputStream
    //   28: dup
    //   29: new 319	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 325	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_2
    //   41: sipush 4096
    //   44: newarray byte
    //   46: astore_0
    //   47: aload_2
    //   48: aload_0
    //   49: invokevirtual 326	java/io/BufferedInputStream:read	([B)I
    //   52: istore_1
    //   53: iload_1
    //   54: iconst_m1
    //   55: if_icmpeq +26 -> 81
    //   58: aload_3
    //   59: aload_0
    //   60: iconst_0
    //   61: iload_1
    //   62: invokevirtual 330	java/security/MessageDigest:update	([BII)V
    //   65: goto -18 -> 47
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   73: aload_2
    //   74: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: areturn
    //   81: aload_3
    //   82: invokevirtual 338	java/security/MessageDigest:digest	()[B
    //   85: astore_0
    //   86: aload_2
    //   87: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   90: goto -11 -> 79
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   98: goto -19 -> 79
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 339	java/io/FileNotFoundException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -36 -> 79
    //   118: astore_0
    //   119: aload_2
    //   120: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 340	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   137: goto -14 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   52	10	1	i	int
    //   40	47	2	localBufferedInputStream	java.io.BufferedInputStream
    //   93	27	2	localIOException1	java.io.IOException
    //   132	2	2	localIOException2	java.io.IOException
    //   6	76	3	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   47	53	68	java/io/IOException
    //   58	65	68	java/io/IOException
    //   81	86	68	java/io/IOException
    //   86	90	93	java/io/IOException
    //   0	23	101	java/io/FileNotFoundException
    //   25	47	101	java/io/FileNotFoundException
    //   73	77	101	java/io/FileNotFoundException
    //   86	90	101	java/io/FileNotFoundException
    //   94	98	101	java/io/FileNotFoundException
    //   109	113	101	java/io/FileNotFoundException
    //   119	123	101	java/io/FileNotFoundException
    //   123	125	101	java/io/FileNotFoundException
    //   133	137	101	java/io/FileNotFoundException
    //   73	77	108	java/io/IOException
    //   47	53	118	finally
    //   58	65	118	finally
    //   69	73	118	finally
    //   81	86	118	finally
    //   0	23	125	java/security/NoSuchAlgorithmException
    //   25	47	125	java/security/NoSuchAlgorithmException
    //   73	77	125	java/security/NoSuchAlgorithmException
    //   86	90	125	java/security/NoSuchAlgorithmException
    //   94	98	125	java/security/NoSuchAlgorithmException
    //   109	113	125	java/security/NoSuchAlgorithmException
    //   119	123	125	java/security/NoSuchAlgorithmException
    //   123	125	125	java/security/NoSuchAlgorithmException
    //   133	137	125	java/security/NoSuchAlgorithmException
    //   119	123	132	java/io/IOException
  }
  
  protected static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = b(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = bffx.a(a(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b()
  {
    byte[] arrayOfByte = new byte[8];
    a(arrayOfByte, this.jdField_b_of_type_ArrayOfLong, 8);
    int i = (int)(this.jdField_b_of_type_ArrayOfLong[0] >>> 3) & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      a(jdField_a_of_type_ArrayOfByte, i);
      a(arrayOfByte, 8);
      a(this.c, this.jdField_a_of_type_ArrayOfLong, 16);
      return;
    }
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = c(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String c(String paramString)
  {
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        paramString = paramString.getBytes();
      }
      return localUnsupportedEncodingException.toString();
    }
    paramString = new bfgc().b(paramString);
    localObject = new StringBuilder(32);
    i = 0;
    while (i < 16)
    {
      ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfChar[(paramString[i] >>> 4 & 0xF)]);
      ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfChar[(paramString[i] & 0xF)]);
      i += 1;
    }
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = d(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    a();
    a(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    b();
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgc
 * JD-Core Version:    0.7.0.1
 */