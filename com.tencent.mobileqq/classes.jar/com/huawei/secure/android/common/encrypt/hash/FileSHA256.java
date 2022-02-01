package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.InputStream;

public abstract class FileSHA256
{
  private static final String TAG = FileSHA256.class.getSimpleName();
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
    boolean bool2 = false;
    String[] arrayOfString = r;
    int k = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (arrayOfString[j].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static String fileSHA256Encrypt(File paramFile)
  {
    return fileSHAEncrypt(paramFile, "SHA-256");
  }
  
  /* Error */
  public static String fileSHAEncrypt(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_1
    //   6: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokestatic 75	com/huawei/secure/android/common/encrypt/hash/FileSHA256:d	(Ljava/lang/String;)Z
    //   16: ifne +14 -> 30
    //   19: getstatic 27	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   22: ldc 77
    //   24: invokestatic 83	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: ldc 9
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic 85	com/huawei/secure/android/common/encrypt/hash/FileSHA256:a	(Ljava/io/File;)Z
    //   34: ifne +14 -> 48
    //   37: getstatic 27	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   40: ldc 87
    //   42: invokestatic 83	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 9
    //   47: areturn
    //   48: aload_1
    //   49: invokestatic 93	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   52: astore 5
    //   54: new 95	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: sipush 8192
    //   68: newarray byte
    //   70: astore 6
    //   72: aload_1
    //   73: astore_0
    //   74: aload_1
    //   75: aload 6
    //   77: invokevirtual 102	java/io/FileInputStream:read	([B)I
    //   80: istore_3
    //   81: iload_3
    //   82: ifle +19 -> 101
    //   85: aload_1
    //   86: astore_0
    //   87: aload 5
    //   89: aload 6
    //   91: iconst_0
    //   92: iload_3
    //   93: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   96: iconst_1
    //   97: istore_2
    //   98: goto -26 -> 72
    //   101: aload 4
    //   103: astore_0
    //   104: iload_2
    //   105: ifeq +18 -> 123
    //   108: aload_1
    //   109: astore_0
    //   110: aload 5
    //   112: invokevirtual 110	java/security/MessageDigest:digest	()[B
    //   115: invokestatic 116	com/huawei/secure/android/common/encrypt/utils/HexUtil:byteArray2HexStr	([B)Ljava/lang/String;
    //   118: astore 4
    //   120: aload 4
    //   122: astore_0
    //   123: aload_1
    //   124: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   127: aload_0
    //   128: areturn
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: astore_0
    //   135: getstatic 27	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   138: new 123	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   145: ldc 126
    //   147: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 4
    //   152: invokevirtual 133	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 83	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_1
    //   165: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   168: aconst_null
    //   169: areturn
    //   170: astore 4
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: astore_0
    //   176: getstatic 27	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   179: new 123	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   186: ldc 138
    //   188: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 4
    //   193: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   196: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 83	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_1
    //   206: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_0
    //   212: aconst_null
    //   213: astore 4
    //   215: aload_0
    //   216: astore_1
    //   217: aload 4
    //   219: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: aload_0
    //   226: astore 4
    //   228: goto -11 -> 217
    //   231: astore 4
    //   233: goto -59 -> 174
    //   236: astore 4
    //   238: goto -105 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramFile	File
    //   0	241	1	paramString	String
    //   4	101	2	j	int
    //   80	13	3	k	int
    //   1	120	4	str	String
    //   129	22	4	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   170	22	4	localIOException1	java.io.IOException
    //   213	14	4	localObject	Object
    //   231	1	4	localIOException2	java.io.IOException
    //   236	1	4	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   52	59	5	localMessageDigest	java.security.MessageDigest
    //   70	20	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   48	63	129	java/security/NoSuchAlgorithmException
    //   48	63	170	java/io/IOException
    //   48	63	211	finally
    //   65	72	224	finally
    //   74	81	224	finally
    //   87	96	224	finally
    //   110	120	224	finally
    //   135	164	224	finally
    //   176	205	224	finally
    //   65	72	231	java/io/IOException
    //   74	81	231	java/io/IOException
    //   87	96	231	java/io/IOException
    //   110	120	231	java/io/IOException
    //   65	72	236	java/security/NoSuchAlgorithmException
    //   74	81	236	java/security/NoSuchAlgorithmException
    //   87	96	236	java/security/NoSuchAlgorithmException
    //   110	120	236	java/security/NoSuchAlgorithmException
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
    //   4: ldc 9
    //   6: areturn
    //   7: sipush 8192
    //   10: newarray byte
    //   12: astore_3
    //   13: aload_1
    //   14: invokestatic 93	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_3
    //   20: invokevirtual 148	java/io/InputStream:read	([B)I
    //   23: istore_2
    //   24: iload_2
    //   25: iflt +33 -> 58
    //   28: iload_2
    //   29: ifle -11 -> 18
    //   32: aload_1
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_2
    //   36: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   39: goto -21 -> 18
    //   42: astore_1
    //   43: getstatic 27	com/huawei/secure/android/common/encrypt/hash/FileSHA256:TAG	Ljava/lang/String;
    //   46: ldc 150
    //   48: invokestatic 83	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   55: ldc 9
    //   57: areturn
    //   58: aload_1
    //   59: invokevirtual 110	java/security/MessageDigest:digest	()[B
    //   62: invokestatic 116	com/huawei/secure/android/common/encrypt/utils/HexUtil:byteArray2HexStr	([B)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_0
    //   67: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: areturn
    //   72: astore_1
    //   73: aload_0
    //   74: invokestatic 121	com/huawei/secure/android/common/encrypt/utils/a:a	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: goto -37 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramInputStream	InputStream
    //   0	83	1	paramString	String
    //   23	13	2	j	int
    //   12	22	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   13	18	42	java/io/IOException
    //   18	24	42	java/io/IOException
    //   32	39	42	java/io/IOException
    //   58	66	42	java/io/IOException
    //   13	18	72	finally
    //   18	24	72	finally
    //   32	39	72	finally
    //   43	51	72	finally
    //   58	66	72	finally
    //   13	18	79	java/security/NoSuchAlgorithmException
    //   18	24	79	java/security/NoSuchAlgorithmException
    //   32	39	79	java/security/NoSuchAlgorithmException
    //   58	66	79	java/security/NoSuchAlgorithmException
  }
  
  public static boolean validateFileSHA(File paramFile, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!d(paramString2)))
    {
      b.f(TAG, "hash value is null || algorithm is illegal");
      return false;
    }
    return paramString1.equals(fileSHAEncrypt(paramFile, paramString2));
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
    if ((TextUtils.isEmpty(paramString1)) || (!d(paramString2)))
    {
      b.f(TAG, "hash value is null || algorithm is illegal");
      return false;
    }
    return paramString1.equals(inputStreamSHAEncrypt(paramInputStream, paramString2));
  }
  
  public static boolean validateInputStreamSHA256(InputStream paramInputStream, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals(inputStreamSHA256Encrypt(paramInputStream));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.FileSHA256
 * JD-Core Version:    0.7.0.1
 */