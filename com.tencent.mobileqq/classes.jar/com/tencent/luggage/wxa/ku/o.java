package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class o
  extends a
{
  private static final int CTRL_INDEX = 278;
  private static final String NAME = "getFileInfo";
  
  public static final String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toLowerCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  private static String b(com.tencent.luggage.wxa.rt.i parami)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 67	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: aload_0
    //   7: invokestatic 72	com/tencent/luggage/wxa/rt/k:a	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: sipush 8192
    //   14: newarray byte
    //   16: astore_3
    //   17: aload_0
    //   18: aload_3
    //   19: invokevirtual 78	java/io/InputStream:read	([B)I
    //   22: istore_1
    //   23: iload_1
    //   24: ifle +13 -> 37
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: iload_1
    //   31: invokevirtual 82	java/security/MessageDigest:update	([BII)V
    //   34: goto -17 -> 17
    //   37: aload_2
    //   38: invokevirtual 86	java/security/MessageDigest:digest	()[B
    //   41: invokestatic 88	com/tencent/luggage/wxa/ku/o:a	([B)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_0
    //   46: invokevirtual 91	java/io/InputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore_0
    //   52: ldc 93
    //   54: ldc 95
    //   56: iconst_1
    //   57: anewarray 97	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: aastore
    //   64: invokestatic 102	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: goto +29 -> 99
    //   73: aload_0
    //   74: invokevirtual 91	java/io/InputStream:close	()V
    //   77: ldc 104
    //   79: areturn
    //   80: astore_0
    //   81: ldc 93
    //   83: ldc 95
    //   85: iconst_1
    //   86: anewarray 97	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: aastore
    //   93: invokestatic 102	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: ldc 104
    //   98: areturn
    //   99: aload_0
    //   100: invokevirtual 91	java/io/InputStream:close	()V
    //   103: goto +19 -> 122
    //   106: astore_0
    //   107: ldc 93
    //   109: ldc 95
    //   111: iconst_1
    //   112: anewarray 97	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_0
    //   118: aastore
    //   119: invokestatic 102	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_2
    //   123: athrow
    //   124: astore_0
    //   125: ldc 93
    //   127: ldc 106
    //   129: iconst_1
    //   130: anewarray 97	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: aastore
    //   137: invokestatic 102	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: ldc 104
    //   142: areturn
    //   143: astore_0
    //   144: ldc 93
    //   146: ldc 108
    //   148: iconst_1
    //   149: anewarray 97	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload_0
    //   155: aastore
    //   156: invokestatic 102	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: ldc 104
    //   161: areturn
    //   162: astore_2
    //   163: goto -90 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	parami	com.tencent.luggage.wxa.rt.i
    //   22	9	1	i	int
    //   5	63	2	localObject1	java.lang.Object
    //   69	54	2	localObject2	java.lang.Object
    //   162	1	2	localIOException	java.io.IOException
    //   16	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   17	23	69	finally
    //   27	34	69	finally
    //   37	45	69	finally
    //   73	77	80	java/io/IOException
    //   99	103	106	java/io/IOException
    //   6	11	124	java/io/FileNotFoundException
    //   0	6	143	java/security/NoSuchAlgorithmException
    //   17	23	162	java/io/IOException
    //   27	34	162	java/io/IOException
    //   37	45	162	java/io/IOException
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("filePath", "");
    if (!"sha1".equalsIgnoreCase(paramJSONObject.optString("digestAlgorithm", "md5"))) {
      paramJSONObject = "md5";
    } else {
      paramJSONObject = "sha1";
    }
    if (af.c(str))
    {
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    b.a.execute(new o.1(this, paramc, str, paramInt, paramJSONObject));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.o
 * JD-Core Version:    0.7.0.1
 */