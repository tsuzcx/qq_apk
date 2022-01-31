import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier;
import com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier.SignatureNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Properties;
import java.util.zip.ZipException;

public final class becv
{
  private static int jdField_a_of_type_Int;
  private static final bedb jdField_a_of_type_Bedb = new bedb(84298576L);
  private static final bedb b = new bedb(50613072L);
  private static final bedb c = new bedb(101010256L);
  
  private static Pair<ByteBuffer, Long> a(ByteBuffer paramByteBuffer, int paramInt, byte[] paramArrayOfByte)
  {
    ApkSignatureSchemeV2Verifier.a(paramByteBuffer);
    ByteBuffer localByteBuffer1 = ApkSignatureSchemeV2Verifier.a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int j = paramArrayOfByte.length + 12;
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramByteBuffer.capacity() + j);
    localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer2.position(8);
    int i = 0;
    long l1;
    int k;
    int m;
    int n;
    if (localByteBuffer1.hasRemaining())
    {
      i += 1;
      if (localByteBuffer1.remaining() < 8) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      l1 = localByteBuffer1.getLong();
      if ((l1 < 4L) || (l1 > 2147483647L)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l1);
      }
      k = (int)l1;
      m = localByteBuffer1.position() + k;
      if (k > localByteBuffer1.remaining()) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + k + ", available: " + localByteBuffer1.remaining());
      }
      n = localByteBuffer1.getInt();
      if (n == paramInt)
      {
        l1 = paramArrayOfByte.length + 4 - k;
        localByteBuffer2.putLong(paramArrayOfByte.length + 4);
        localByteBuffer2.putInt(n);
        localByteBuffer2.put(paramArrayOfByte);
        localByteBuffer1.position(m);
        localByteBuffer2.put(localByteBuffer1.array(), localByteBuffer1.arrayOffset(), localByteBuffer1.remaining());
        localByteBuffer1.position(localByteBuffer1.limit());
      }
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 == 0L)
      {
        localByteBuffer2.putLong(paramArrayOfByte.length + 4);
        localByteBuffer2.putInt(paramInt);
        localByteBuffer2.put(paramArrayOfByte);
        l2 = j;
      }
      l1 = paramByteBuffer.getLong() + l2;
      localByteBuffer2.putLong(l1);
      localByteBuffer2.put(paramByteBuffer.array(), paramByteBuffer.array().length - 16, 16);
      localByteBuffer2.position(0);
      localByteBuffer2.putLong(l1);
      localByteBuffer2.position(0);
      localByteBuffer2.limit((int)l1 + 8);
      return Pair.create(localByteBuffer2, Long.valueOf(l2));
      localByteBuffer2.putLong(l1);
      localByteBuffer2.putInt(n);
      localByteBuffer2.put(ApkSignatureSchemeV2Verifier.a(localByteBuffer1, k - 4));
      localByteBuffer1.position(m);
      break;
      l1 = 0L;
    }
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 166
    //   2: iconst_1
    //   3: ldc 168
    //   5: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: ldc 166
    //   16: iconst_1
    //   17: new 74	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   24: ldc 176
    //   26: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 181	java/io/File:getName	()Ljava/lang/String;
    //   33: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokestatic 187	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:a	(Ljava/lang/String;)Z
    //   49: ifeq +209 -> 258
    //   52: aload_0
    //   53: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: ldc 188
    //   58: invokestatic 191	becv:a	(Ljava/lang/String;I)[B
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull +186 -> 249
    //   66: new 193	java/io/RandomAccessFile
    //   69: dup
    //   70: aload_0
    //   71: ldc 195
    //   73: invokespecial 198	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: invokestatic 201	becv:a	(Ljava/io/RandomAccessFile;)[B
    //   85: astore_3
    //   86: aload_3
    //   87: ifnonnull +45 -> 132
    //   90: aload_1
    //   91: astore_0
    //   92: aload_1
    //   93: astore_2
    //   94: ldc 166
    //   96: iconst_1
    //   97: ldc 203
    //   99: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: astore_2
    //   106: ldc 166
    //   108: iconst_1
    //   109: ldc 205
    //   111: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   122: ldc 166
    //   124: iconst_1
    //   125: ldc 210
    //   127: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: areturn
    //   132: aload_1
    //   133: astore_0
    //   134: aload_1
    //   135: astore_2
    //   136: new 212	becx
    //   139: dup
    //   140: aconst_null
    //   141: invokespecial 215	becx:<init>	(Lbecw;)V
    //   144: astore 4
    //   146: aload_1
    //   147: astore_0
    //   148: aload_1
    //   149: astore_2
    //   150: aload 4
    //   152: aload_3
    //   153: invokevirtual 218	becx:a	([B)V
    //   156: aload_1
    //   157: astore_0
    //   158: aload_1
    //   159: astore_2
    //   160: aload 4
    //   162: getfield 221	becx:a	Ljava/util/Properties;
    //   165: ldc 223
    //   167: invokevirtual 229	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_3
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   179: ldc 166
    //   181: iconst_1
    //   182: ldc 210
    //   184: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_3
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: astore_0
    //   194: aload_1
    //   195: invokevirtual 232	java/lang/Throwable:printStackTrace	()V
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   206: ldc 166
    //   208: iconst_1
    //   209: ldc 210
    //   211: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_0
    //   220: astore_1
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   229: ldc 166
    //   231: iconst_1
    //   232: ldc 210
    //   234: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: aload_0
    //   241: astore_2
    //   242: goto -21 -> 221
    //   245: astore_1
    //   246: goto -54 -> 192
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_1
    //   252: astore_3
    //   253: aload_0
    //   254: astore_1
    //   255: goto -169 -> 86
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -198 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   61	115	1	localObject1	Object
    //   189	6	1	localThrowable1	Throwable
    //   220	18	1	localFile1	File
    //   239	1	1	localObject2	Object
    //   245	7	1	localThrowable2	Throwable
    //   254	6	1	localFile2	File
    //   80	162	2	localObject3	Object
    //   85	168	3	localObject4	Object
    //   144	17	4	localbecx	becx
    // Exception table:
    //   from	to	target	type
    //   42	62	189	java/lang/Throwable
    //   66	77	189	java/lang/Throwable
    //   42	62	216	finally
    //   66	77	216	finally
    //   81	86	239	finally
    //   94	102	239	finally
    //   106	114	239	finally
    //   136	146	239	finally
    //   150	156	239	finally
    //   160	171	239	finally
    //   194	198	239	finally
    //   81	86	245	java/lang/Throwable
    //   94	102	245	java/lang/Throwable
    //   106	114	245	java/lang/Throwable
    //   136	146	245	java/lang/Throwable
    //   150	156	245	java/lang/Throwable
    //   160	171	245	java/lang/Throwable
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(paramArrayOfByte[i]);
        localStringBuilder.append(",");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "empty";
  }
  
  private static ByteBuffer a(RandomAccessFile paramRandomAccessFile, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    return localByteBuffer;
  }
  
  public static void a(File paramFile, String paramString)
  {
    if (ApkSignatureSchemeV2Verifier.a(paramFile.getAbsolutePath()))
    {
      c(paramFile, paramString);
      return;
    }
    b(paramFile, paramString);
  }
  
  private static void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new RandomAccessFile(paramString, "rw");
      localObject1 = ApkSignatureSchemeV2Verifier.a(paramString);
      localByteBuffer1 = (ByteBuffer)((Pair)localObject1).first;
      l2 = ((Long)((Pair)localObject1).second).longValue();
      if (bedd.a(paramString, l2)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
      }
    }
    catch (FileNotFoundException paramString)
    {
      Object localObject1;
      ByteBuffer localByteBuffer1;
      long l2;
      paramString.printStackTrace();
      long l3;
      do
      {
        return;
        long l1 = ApkSignatureSchemeV2Verifier.a(localByteBuffer1, l2);
        localObject1 = a(paramString, l1, (int)(l2 - l1));
        Object localObject2 = ApkSignatureSchemeV2Verifier.a(paramString, l1);
        ByteBuffer localByteBuffer2 = (ByteBuffer)((Pair)localObject2).first;
        l2 = ((Long)((Pair)localObject2).second).longValue();
        paramArrayOfByte = a(localByteBuffer2, paramInt, paramArrayOfByte);
        localObject2 = (ByteBuffer)paramArrayOfByte.first;
        l3 = ((Long)paramArrayOfByte.second).longValue();
        bedd.a(localByteBuffer1, l1 + l3);
        paramString.seek(l2);
        paramString.write(((ByteBuffer)localObject2).array(), ((ByteBuffer)localObject2).arrayOffset() + ((ByteBuffer)localObject2).position(), ((ByteBuffer)localObject2).remaining());
        paramString.write(((ByteBuffer)localObject1).array(), ((ByteBuffer)localObject1).arrayOffset() + ((ByteBuffer)localObject1).position(), ((ByteBuffer)localObject1).remaining());
        paramString.write(localByteBuffer1.array(), localByteBuffer1.arrayOffset() + localByteBuffer1.position(), localByteBuffer1.remaining());
      } while (l3 >= 0L);
      paramString.setLength(paramString.length() + l3);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    int k = 0;
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = c.a();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      int j = k;
      if (i != -1)
      {
        if ((i == arrayOfByte[0]) && (paramRandomAccessFile.read() == arrayOfByte[1]) && (paramRandomAccessFile.read() == arrayOfByte[2]) && (paramRandomAccessFile.read() == arrayOfByte[3])) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.e("ApkExternalInfoTool", 1, "archive is not a ZIP archive");
        throw new ZipException("archive is not a ZIP archive");
      }
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    paramRandomAccessFile.seek(l + 16L + 4L);
    if (jdField_a_of_type_Int != l + 16L + 4L) {
      jdField_a_of_type_Int = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    QLog.d("ApkExternalInfoTool", 1, "readComment:length bytes data = " + a(arrayOfByte));
    i = new bedc(arrayOfByte).a();
    if (i == 0) {
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    return arrayOfByte;
  }
  
  private static byte[] a(String paramString, int paramInt)
  {
    ByteBuffer localByteBuffer;
    long l;
    try
    {
      paramString = new RandomAccessFile(paramString, "r");
      localObject = ApkSignatureSchemeV2Verifier.a(paramString);
      localByteBuffer = (ByteBuffer)((Pair)localObject).first;
      l = ((Long)((Pair)localObject).second).longValue();
      if (bedd.a(paramString, l)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    paramString = ApkSignatureSchemeV2Verifier.b((ByteBuffer)ApkSignatureSchemeV2Verifier.a(paramString, ApkSignatureSchemeV2Verifier.a(localByteBuffer, l)).first, paramInt);
    Object localObject = new byte[paramString.remaining()];
    paramString.get((byte[])localObject, 0, localObject.length);
    return localObject;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        return localObject;
        localObject = ByteBuffer.wrap(paramArrayOfByte);
        arrayOfByte = new byte[jdField_a_of_type_Bedb.a().length];
        ((ByteBuffer)localObject).get(arrayOfByte);
        localObject = paramArrayOfByte;
      } while (jdField_a_of_type_Bedb.equals(new bedb(arrayOfByte)));
      localObject = paramArrayOfByte;
    } while (b.equals(new bedb(arrayOfByte)));
    Object localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(b.a());
    ((ByteArrayOutputStream)localObject).write(new bedc(paramArrayOfByte.length).a());
    ((ByteArrayOutputStream)localObject).write(paramArrayOfByte);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private static void b(File paramFile, String paramString)
  {
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      becx localbecx;
      int i;
      if (paramString == null) {
        break label156;
      }
    }
    finally
    {
      try
      {
        paramFile = a(a(localRandomAccessFile));
        localbecx = new becx(null);
        localbecx.a(paramFile);
        localbecx.a.setProperty("apkSecurityCode", paramString);
        paramFile = localbecx.a();
        localRandomAccessFile.seek(jdField_a_of_type_Int);
        localRandomAccessFile.write(new bedc(paramFile.length).a());
        localRandomAccessFile.write(paramFile);
        i = jdField_a_of_type_Int;
        localRandomAccessFile.setLength(paramFile.length + i + 2);
        QLog.d("ApkExternalInfoTool", 1, "file length is = " + localRandomAccessFile.length());
        if (localRandomAccessFile != null) {
          localRandomAccessFile.close();
        }
        QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
        return;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        paramString = localRandomAccessFile;
      }
      paramFile = finally;
      paramString = null;
    }
    paramString.close();
    label156:
    QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
    throw paramFile;
  }
  
  private static void c(File paramFile, String paramString)
  {
    try
    {
      byte[] arrayOfByte = a(a(paramFile.getAbsolutePath(), 2036624993));
      becx localbecx = new becx(null);
      localbecx.a(arrayOfByte);
      localbecx.a.setProperty("apkSecurityCode", paramString);
      paramString = localbecx.a();
      a(paramFile.getAbsolutePath(), 2036624993, paramString);
      return;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     becv
 * JD-Core Version:    0.7.0.1
 */