package com.qq.a.a.a;

import android.util.Base64;
import com.b.a.b.a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  private static Charset a = Charset.forName("utf-8");
  private byte[] b;
  private String c;
  private String d;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.length() != 43) {
      throw new a(-40004);
    }
    this.c = paramString1;
    this.d = paramString3;
    this.b = Base64.decode(paramString2 + "=", 0);
  }
  
  private static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return j;
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 77	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_3
    //   6: aload_3
    //   7: iconst_2
    //   8: new 79	javax/crypto/spec/SecretKeySpec
    //   11: dup
    //   12: aload_0
    //   13: getfield 65	com/qq/a/a/a/d:b	[B
    //   16: ldc 81
    //   18: invokespecial 84	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   21: new 86	javax/crypto/spec/IvParameterSpec
    //   24: dup
    //   25: aload_0
    //   26: getfield 65	com/qq/a/a/a/d:b	[B
    //   29: iconst_0
    //   30: bipush 16
    //   32: invokestatic 92	java/util/Arrays:copyOfRange	([BII)[B
    //   35: invokespecial 95	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   38: invokevirtual 99	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   41: aload_3
    //   42: aload_1
    //   43: iconst_0
    //   44: invokestatic 63	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   47: invokevirtual 103	javax/crypto/Cipher:doFinal	([B)[B
    //   50: astore_1
    //   51: aload_1
    //   52: invokestatic 107	com/qq/a/a/a/c:a	([B)[B
    //   55: astore_3
    //   56: aload_3
    //   57: bipush 16
    //   59: bipush 20
    //   61: invokestatic 92	java/util/Arrays:copyOfRange	([BII)[B
    //   64: invokestatic 109	com/qq/a/a/a/d:a	([B)I
    //   67: istore_2
    //   68: new 30	java/lang/String
    //   71: dup
    //   72: aload_3
    //   73: bipush 20
    //   75: iload_2
    //   76: bipush 20
    //   78: iadd
    //   79: invokestatic 92	java/util/Arrays:copyOfRange	([BII)[B
    //   82: getstatic 23	com/qq/a/a/a/d:a	Ljava/nio/charset/Charset;
    //   85: invokespecial 112	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   88: astore_1
    //   89: new 30	java/lang/String
    //   92: dup
    //   93: aload_3
    //   94: iload_2
    //   95: bipush 20
    //   97: iadd
    //   98: aload_3
    //   99: arraylength
    //   100: invokestatic 92	java/util/Arrays:copyOfRange	([BII)[B
    //   103: getstatic 23	com/qq/a/a/a/d:a	Ljava/nio/charset/Charset;
    //   106: invokespecial 112	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   109: astore_3
    //   110: aload_3
    //   111: aload_0
    //   112: getfield 44	com/qq/a/a/a/d:d	Ljava/lang/String;
    //   115: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifne +43 -> 161
    //   121: new 36	com/qq/a/a/a/a
    //   124: dup
    //   125: ldc 117
    //   127: invokespecial 40	com/qq/a/a/a/a:<init>	(I)V
    //   130: athrow
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   136: new 36	com/qq/a/a/a/a
    //   139: dup
    //   140: ldc 121
    //   142: invokespecial 40	com/qq/a/a/a/a:<init>	(I)V
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   151: new 36	com/qq/a/a/a/a
    //   154: dup
    //   155: ldc 122
    //   157: invokespecial 40	com/qq/a/a/a/a:<init>	(I)V
    //   160: athrow
    //   161: aload_1
    //   162: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	d
    //   0	163	1	paramString	String
    //   67	31	2	i	int
    //   5	106	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	51	131	java/lang/Exception
    //   51	110	146	java/lang/Exception
  }
  
  private String a(String paramString1, String paramString2)
  {
    b localb = new b();
    paramString1 = paramString1.getBytes(a);
    paramString2 = paramString2.getBytes(a);
    int n = paramString2.length;
    int i = (byte)n;
    int j = (byte)(n >> 8);
    int k = (byte)(n >> 16);
    int m = (byte)(n >>> 24);
    byte[] arrayOfByte = this.d.getBytes(a);
    localb.a(paramString1);
    localb.a(new byte[] { m, k, j, i });
    localb.a(paramString2);
    localb.a(arrayOfByte);
    localb.a(c.a(localb.a.size()));
    paramString1 = new byte[localb.a.size()];
    n = 0;
    while (n < localb.a.size())
    {
      paramString1[n] = ((Byte)localb.a.get(n)).byteValue();
      n += 1;
    }
    try
    {
      paramString2 = Cipher.getInstance("AES/CBC/NoPadding");
      paramString2.init(1, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.b, 0, 16));
      paramString1 = Base64.encodeToString(paramString2.doFinal(paramString1), 0);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      throw new a(-40006);
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(((Random)localObject).nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length())));
      i += 1;
    }
    localObject = a(localStringBuffer.toString(), paramString2);
    paramString2 = paramString3;
    if (paramString3 == "") {
      paramString2 = Long.toString(System.currentTimeMillis());
    }
    return b.a.a(paramString1, (String)localObject, b.a(this.c, paramString2, paramString4, (String)localObject), paramString2, paramString4);
  }
  
  public final String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = b.a.c(paramString4);
    if (!b.a(this.c, paramString2, paramString3, paramString4[1].toString()).equals(paramString1)) {
      throw new a(-40001);
    }
    return a(paramString4[1].toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */