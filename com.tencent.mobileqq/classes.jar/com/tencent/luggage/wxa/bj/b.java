package com.tencent.luggage.wxa.bj;

import com.tencent.luggage.wxa.gl.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/crash/EncryptUtil;", "", "()V", "DECRYPTION", "", "getDECRYPTION", "()I", "ENCRYPTION", "getENCRYPTION", "LATEST_RBCRYPT_PACK_VERSION", "getLATEST_RBCRYPT_PACK_VERSION", "RBCPR_ERR_DECRYPT_WITH_DES_KEY", "getRBCPR_ERR_DECRYPT_WITH_DES_KEY", "RBCPR_ERR_DECRYPT_WITH_RSA_PRIVKEY", "getRBCPR_ERR_DECRYPT_WITH_RSA_PRIVKEY", "RBCPR_ERR_ENCRYPT_WITH_DES_KEY", "getRBCPR_ERR_ENCRYPT_WITH_DES_KEY", "RBCPR_ERR_ENCRYPT_WITH_RSA_PUBKEY", "getRBCPR_ERR_ENCRYPT_WITH_RSA_PUBKEY", "RBCPR_ERR_GENERAL", "getRBCPR_ERR_GENERAL", "RBCPR_ERR_INVALID_ARG", "getRBCPR_ERR_INVALID_ARG", "RBCPR_ERR_INVALID_RSA_KEY_E", "getRBCPR_ERR_INVALID_RSA_KEY_E", "RBCPR_ERR_INVALID_RSA_KEY_N", "getRBCPR_ERR_INVALID_RSA_KEY_N", "RBCPR_ERR_LOAD_RSA_PRIVATE_KEY", "getRBCPR_ERR_LOAD_RSA_PRIVATE_KEY", "RBCPR_ERR_NO_MEMORY", "getRBCPR_ERR_NO_MEMORY", "RBCPR_ERR_NO_REFERENCE_INFO", "getRBCPR_ERR_NO_REFERENCE_INFO", "RBCPR_ERR_NO_SEQ", "getRBCPR_ERR_NO_SEQ", "RBCPR_ERR_PACK_CORRUPTED", "getRBCPR_ERR_PACK_CORRUPTED", "RBCPR_ERR_UNSUPPORTED_ALGORITHM", "getRBCPR_ERR_UNSUPPORTED_ALGORITHM", "RBCPR_ERR_UNSUPPORTED_VERSION", "getRBCPR_ERR_UNSUPPORTED_VERSION", "RBCPR_OK", "getRBCPR_OK", "RBCRYPT_PACK_VERSION_1", "getRBCRYPT_PACK_VERSION_1", "TAG", "", "compress", "", "data", "desEncrypt", "cipherText", "Lcom/tencent/mm/pointers/PByteArray;", "plainText", "key", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final int b = 1001;
  private static final int c = b;
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private static final int h = 4;
  private static final int i = 5;
  private static final int j = 6;
  private static final int k = 7;
  private static final int l = 8;
  private static final int m = 9;
  private static final int n = 10;
  private static final int o = 11;
  private static final int p = 12;
  private static final int q = 13;
  private static final int r = 14;
  private static final int s = 15;
  private static final int t = 0;
  private static final int u = 1;
  
  public final int a(@Nullable com.tencent.luggage.wxa.qt.b paramb, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    if ((paramb != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if ((paramArrayOfByte1.length >= 0) && (paramArrayOfByte2.length > 0))
      {
        int i3 = 8 - paramArrayOfByte1.length % 8;
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + i3];
        int i4 = paramArrayOfByte1.length;
        int i2 = 0;
        int i1 = 0;
        while (i1 < i4)
        {
          arrayOfByte[i1] = paramArrayOfByte1[i1];
          i1 += 1;
        }
        i1 = 0;
        while (i1 < i3)
        {
          arrayOfByte[(paramArrayOfByte1.length + i1)] = ((byte)i3);
          i1 += 1;
        }
        paramb.a = new byte[paramArrayOfByte1.length + i3 + 32];
        if (f.a(paramb.a, arrayOfByte, arrayOfByte.length, paramArrayOfByte2.length, paramArrayOfByte2, t) == 0) {
          return o;
        }
        paramArrayOfByte1 = new byte[paramArrayOfByte1.length + i3 + 8];
        i3 = paramArrayOfByte1.length;
        i1 = i2;
        while (i1 < i3)
        {
          if (paramb.a != null)
          {
            paramArrayOfByte2 = paramb.a;
            if (paramArrayOfByte2 == null) {
              Intrinsics.throwNpe();
            }
            paramArrayOfByte1[i1] = paramArrayOfByte2[i1];
          }
          i1 += 1;
        }
        paramb.a = paramArrayOfByte1;
        return d;
      }
      return f;
    }
    return f;
  }
  
  /* Error */
  @org.jetbrains.annotations.NotNull
  public final byte[] a(@org.jetbrains.annotations.NotNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 177
    //   3: invokestatic 181	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new 183	java/util/zip/Deflater
    //   9: dup
    //   10: invokespecial 184	java/util/zip/Deflater:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 187	java/util/zip/Deflater:reset	()V
    //   20: aload 5
    //   22: aload_1
    //   23: invokevirtual 191	java/util/zip/Deflater:setInput	([B)V
    //   26: aload 5
    //   28: invokevirtual 194	java/util/zip/Deflater:finish	()V
    //   31: aconst_null
    //   32: checkcast 196	java/io/ByteArrayOutputStream
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: new 196	java/io/ByteArrayOutputStream
    //   43: dup
    //   44: aload_1
    //   45: arraylength
    //   46: invokespecial 199	java/io/ByteArrayOutputStream:<init>	(I)V
    //   49: astore_2
    //   50: aload_2
    //   51: astore_3
    //   52: sipush 1024
    //   55: newarray byte
    //   57: astore 4
    //   59: aload_2
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 203	java/util/zip/Deflater:finished	()Z
    //   66: ifne +22 -> 88
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: aload 4
    //   74: iconst_0
    //   75: aload 5
    //   77: aload 4
    //   79: invokevirtual 207	java/util/zip/Deflater:deflate	([B)I
    //   82: invokevirtual 211	java/io/ByteArrayOutputStream:write	([BII)V
    //   85: goto -26 -> 59
    //   88: aload_2
    //   89: astore_3
    //   90: aload_2
    //   91: invokevirtual 215	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore 4
    //   96: aload_2
    //   97: astore_3
    //   98: aload 4
    //   100: ldc 217
    //   102: invokestatic 220	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   105: aload_2
    //   106: checkcast 222	java/io/OutputStream
    //   109: invokestatic 228	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   112: aload 4
    //   114: astore_1
    //   115: goto +99 -> 214
    //   118: aload_2
    //   119: astore 4
    //   121: goto +12 -> 133
    //   124: astore 4
    //   126: goto +63 -> 189
    //   129: astore_1
    //   130: goto +92 -> 222
    //   133: aload 4
    //   135: astore_3
    //   136: new 230	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   143: astore_2
    //   144: aload 4
    //   146: astore_3
    //   147: aload_2
    //   148: ldc 233
    //   150: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 4
    //   156: astore_3
    //   157: aload_2
    //   158: aload_1
    //   159: arraylength
    //   160: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 4
    //   166: astore_3
    //   167: new 176	java/lang/OutOfMemoryError
    //   170: dup
    //   171: aload_2
    //   172: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 247	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   178: checkcast 249	java/lang/Throwable
    //   181: athrow
    //   182: astore_3
    //   183: aload 4
    //   185: astore_2
    //   186: aload_3
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: ldc 251
    //   193: ldc 253
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload 4
    //   203: aastore
    //   204: invokestatic 258	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload_2
    //   208: checkcast 222	java/io/OutputStream
    //   211: invokestatic 228	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   214: aload 5
    //   216: invokevirtual 261	java/util/zip/Deflater:end	()V
    //   219: aload_1
    //   220: areturn
    //   221: astore_1
    //   222: aload_3
    //   223: checkcast 222	java/io/OutputStream
    //   226: invokestatic 228	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   229: goto +5 -> 234
    //   232: aload_1
    //   233: athrow
    //   234: goto -2 -> 232
    //   237: astore_2
    //   238: goto -105 -> 133
    //   241: astore_3
    //   242: goto -124 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	b
    //   0	245	1	paramArrayOfByte	byte[]
    //   49	159	2	localObject1	Object
    //   237	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   39	128	3	localObject2	Object
    //   182	5	3	localException1	java.lang.Exception
    //   190	33	3	localObject3	Object
    //   241	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   35	85	4	localObject4	Object
    //   124	60	4	localException2	java.lang.Exception
    //   187	15	4	localObject5	Object
    //   13	202	5	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   52	59	124	java/lang/Exception
    //   61	69	124	java/lang/Exception
    //   71	85	124	java/lang/Exception
    //   90	96	124	java/lang/Exception
    //   98	105	124	java/lang/Exception
    //   40	50	129	finally
    //   136	144	129	finally
    //   147	154	129	finally
    //   157	164	129	finally
    //   167	182	129	finally
    //   40	50	182	java/lang/Exception
    //   52	59	221	finally
    //   61	69	221	finally
    //   71	85	221	finally
    //   90	96	221	finally
    //   98	105	221	finally
    //   191	207	221	finally
    //   40	50	237	java/lang/OutOfMemoryError
    //   52	59	241	java/lang/OutOfMemoryError
    //   61	69	241	java/lang/OutOfMemoryError
    //   71	85	241	java/lang/OutOfMemoryError
    //   90	96	241	java/lang/OutOfMemoryError
    //   98	105	241	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bj.b
 * JD-Core Version:    0.7.0.1
 */