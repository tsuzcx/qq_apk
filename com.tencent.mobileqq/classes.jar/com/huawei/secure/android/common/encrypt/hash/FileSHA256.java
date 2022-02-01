package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.InputStream;

public abstract class FileSHA256
{
  private static final String TAG = "FileSHA256";
  private static final String i = "";
  private static final int p = 8192;
  private static final String q = "SHA-256";
  private static final String[] r = { "SHA-256", "SHA-384", "SHA-512" };
  
  private static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.length() > 0L);
  }
  
  private static boolean d(String paramString)
  {
    String[] arrayOfString = r;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfString[j].equals(paramString)) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public static String fileSHA256Encrypt(File paramFile)
  {
    return fileSHAEncrypt(paramFile, "SHA-256");
  }
  
  /* Error */
  public static String fileSHAEncrypt(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +271 -> 275
    //   7: aload_1
    //   8: invokestatic 69	com/huawei/secure/android/common/encrypt/hash/FileSHA256:d	(Ljava/lang/String;)Z
    //   11: ifne +6 -> 17
    //   14: goto +261 -> 275
    //   17: aload_0
    //   18: invokestatic 71	com/huawei/secure/android/common/encrypt/hash/FileSHA256:a	(Ljava/io/File;)Z
    //   21: ifne +14 -> 35
    //   24: getstatic 73	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   27: ldc 75
    //   29: invokestatic 81	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc 11
    //   34: areturn
    //   35: aconst_null
    //   36: astore 5
    //   38: aload_1
    //   39: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   42: astore 6
    //   44: new 89	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 4
    //   62: iconst_0
    //   63: istore_2
    //   64: aload_1
    //   65: astore_0
    //   66: aload_1
    //   67: aload 4
    //   69: invokevirtual 96	java/io/FileInputStream:read	([B)I
    //   72: istore_3
    //   73: iload_3
    //   74: ifle +19 -> 93
    //   77: aload_1
    //   78: astore_0
    //   79: aload 6
    //   81: aload 4
    //   83: iconst_0
    //   84: iload_3
    //   85: invokevirtual 100	java/security/MessageDigest:update	([BII)V
    //   88: iconst_1
    //   89: istore_2
    //   90: goto -26 -> 64
    //   93: aload 5
    //   95: astore 4
    //   97: aload_1
    //   98: astore_0
    //   99: iload_2
    //   100: ifeq +17 -> 117
    //   103: aload_1
    //   104: astore_0
    //   105: aload 6
    //   107: invokevirtual 104	java/security/MessageDigest:digest	()[B
    //   110: invokestatic 110	com/huawei/secure/android/common/encrypt/utils/HexUtil:byteArray2HexStr	([B)Ljava/lang/String;
    //   113: astore 4
    //   115: aload_1
    //   116: astore_0
    //   117: aload_0
    //   118: invokestatic 115	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   121: aload 4
    //   123: areturn
    //   124: astore 4
    //   126: goto +18 -> 144
    //   129: astore 4
    //   131: goto +75 -> 206
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: goto +132 -> 269
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: astore_0
    //   146: getstatic 73	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   149: astore 6
    //   151: aload_1
    //   152: astore_0
    //   153: new 117	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   160: astore 7
    //   162: aload_1
    //   163: astore_0
    //   164: aload 7
    //   166: ldc 120
    //   168: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_1
    //   173: astore_0
    //   174: aload 7
    //   176: aload 4
    //   178: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: astore_0
    //   187: aload 6
    //   189: aload 7
    //   191: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 81	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 5
    //   199: astore 4
    //   201: aload_1
    //   202: astore_0
    //   203: goto -86 -> 117
    //   206: aload_1
    //   207: astore_0
    //   208: getstatic 73	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   211: astore 6
    //   213: aload_1
    //   214: astore_0
    //   215: new 117	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   222: astore 7
    //   224: aload_1
    //   225: astore_0
    //   226: aload 7
    //   228: ldc 133
    //   230: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_1
    //   235: astore_0
    //   236: aload 7
    //   238: aload 4
    //   240: invokevirtual 134	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: astore_0
    //   249: aload 6
    //   251: aload 7
    //   253: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 81	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 5
    //   261: astore 4
    //   263: aload_1
    //   264: astore_0
    //   265: goto -148 -> 117
    //   268: astore_1
    //   269: aload_0
    //   270: invokestatic 115	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   273: aload_1
    //   274: athrow
    //   275: getstatic 73	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   278: ldc 136
    //   280: invokestatic 81	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc 11
    //   285: areturn
    //   286: astore 4
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -84 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramFile	File
    //   0	293	1	paramString	String
    //   63	37	2	j	int
    //   72	13	3	k	int
    //   60	62	4	localObject1	Object
    //   124	1	4	localIOException1	java.io.IOException
    //   129	1	4	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   140	37	4	localIOException2	java.io.IOException
    //   199	63	4	localObject2	Object
    //   286	1	4	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   36	224	5	localObject3	Object
    //   42	208	6	localObject4	Object
    //   160	92	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   55	62	124	java/io/IOException
    //   66	73	124	java/io/IOException
    //   79	88	124	java/io/IOException
    //   105	115	124	java/io/IOException
    //   55	62	129	java/security/NoSuchAlgorithmException
    //   66	73	129	java/security/NoSuchAlgorithmException
    //   79	88	129	java/security/NoSuchAlgorithmException
    //   105	115	129	java/security/NoSuchAlgorithmException
    //   38	53	134	finally
    //   38	53	140	java/io/IOException
    //   55	62	268	finally
    //   66	73	268	finally
    //   79	88	268	finally
    //   105	115	268	finally
    //   146	151	268	finally
    //   153	162	268	finally
    //   164	172	268	finally
    //   174	185	268	finally
    //   187	197	268	finally
    //   208	213	268	finally
    //   215	224	268	finally
    //   226	234	268	finally
    //   236	247	268	finally
    //   249	259	268	finally
    //   38	53	286	java/security/NoSuchAlgorithmException
  }
  
  public static String inputStreamSHA256Encrypt(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return "";
    }
    return inputStreamSHAEncrypt(paramInputStream, "SHA-256");
  }
  
  /* Error */
  public static String inputStreamSHAEncrypt(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 11
    //   6: areturn
    //   7: sipush 8192
    //   10: newarray byte
    //   12: astore_3
    //   13: aload_1
    //   14: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_3
    //   20: invokevirtual 145	java/io/InputStream:read	([B)I
    //   23: istore_2
    //   24: iload_2
    //   25: iflt +17 -> 42
    //   28: iload_2
    //   29: ifle -11 -> 18
    //   32: aload_1
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_2
    //   36: invokevirtual 100	java/security/MessageDigest:update	([BII)V
    //   39: goto -21 -> 18
    //   42: aload_1
    //   43: invokevirtual 104	java/security/MessageDigest:digest	()[B
    //   46: invokestatic 110	com/huawei/secure/android/common/encrypt/utils/HexUtil:byteArray2HexStr	([B)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: invokestatic 115	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   54: aload_1
    //   55: areturn
    //   56: astore_1
    //   57: goto +18 -> 75
    //   60: getstatic 73	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   63: ldc 147
    //   65: invokestatic 81	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: invokestatic 115	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   72: ldc 11
    //   74: areturn
    //   75: aload_0
    //   76: invokestatic 115	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   79: goto +5 -> 84
    //   82: aload_1
    //   83: athrow
    //   84: goto -2 -> 82
    //   87: astore_1
    //   88: goto -28 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramInputStream	InputStream
    //   0	91	1	paramString	String
    //   23	13	2	j	int
    //   12	22	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   13	18	56	finally
    //   18	24	56	finally
    //   32	39	56	finally
    //   42	50	56	finally
    //   60	68	56	finally
    //   13	18	87	java/io/IOException
    //   13	18	87	java/security/NoSuchAlgorithmException
    //   18	24	87	java/io/IOException
    //   18	24	87	java/security/NoSuchAlgorithmException
    //   32	39	87	java/io/IOException
    //   32	39	87	java/security/NoSuchAlgorithmException
    //   42	50	87	java/io/IOException
    //   42	50	87	java/security/NoSuchAlgorithmException
  }
  
  public static boolean validateFileSHA(File paramFile, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (d(paramString2))) {
      return paramString1.equals(fileSHAEncrypt(paramFile, paramString2));
    }
    b.f(TAG, "hash value is null || algorithm is illegal");
    return false;
  }
  
  public static boolean validateFileSHA256(File paramFile, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals(fileSHA256Encrypt(paramFile));
  }
  
  public static boolean validateInputStreamSHA(InputStream paramInputStream, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (d(paramString2))) {
      return paramString1.equals(inputStreamSHAEncrypt(paramInputStream, paramString2));
    }
    b.f(TAG, "hash value is null || algorithm is illegal");
    return false;
  }
  
  public static boolean validateInputStreamSHA256(InputStream paramInputStream, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals(inputStreamSHA256Encrypt(paramInputStream));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.FileSHA256
 * JD-Core Version:    0.7.0.1
 */