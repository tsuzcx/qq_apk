package com.huawei.secure.android.common.encrypt.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public final class HexUtil
{
  private static final String TAG = "HexUtil";
  private static final String i = "";
  
  public static String byteArray2HexStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = byteArray2HexStr(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b.f("HexUtil", "byte array 2 hex string exception : " + paramString.getMessage());
    }
    return "";
  }
  
  public static String byteArray2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static byte[] hexStr2ByteArray(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +7 -> 13
    //   9: iconst_0
    //   10: newarray byte
    //   12: areturn
    //   13: aload_0
    //   14: getstatic 81	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   17: invokevirtual 85	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 69	java/lang/String:length	()I
    //   25: iconst_2
    //   26: idiv
    //   27: newarray byte
    //   29: astore_2
    //   30: aload_0
    //   31: ldc 28
    //   33: invokevirtual 34	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   36: astore_0
    //   37: iload_1
    //   38: aload_2
    //   39: arraylength
    //   40: if_icmpge +136 -> 176
    //   43: aload_2
    //   44: iload_1
    //   45: new 39	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   52: ldc 87
    //   54: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: new 30	java/lang/String
    //   60: dup
    //   61: iconst_1
    //   62: newarray byte
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: iload_1
    //   68: iconst_2
    //   69: imul
    //   70: baload
    //   71: bastore
    //   72: ldc 28
    //   74: invokespecial 90	java/lang/String:<init>	([BLjava/lang/String;)V
    //   77: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 96	java/lang/Byte:decode	(Ljava/lang/String;)Ljava/lang/Byte;
    //   86: invokevirtual 100	java/lang/Byte:byteValue	()B
    //   89: iconst_4
    //   90: ishl
    //   91: i2b
    //   92: new 39	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   99: ldc 87
    //   101: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: new 30	java/lang/String
    //   107: dup
    //   108: iconst_1
    //   109: newarray byte
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: iload_1
    //   115: iconst_2
    //   116: imul
    //   117: iconst_1
    //   118: iadd
    //   119: baload
    //   120: bastore
    //   121: ldc 28
    //   123: invokespecial 90	java/lang/String:<init>	([BLjava/lang/String;)V
    //   126: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 96	java/lang/Byte:decode	(Ljava/lang/String;)Ljava/lang/Byte;
    //   135: invokevirtual 100	java/lang/Byte:byteValue	()B
    //   138: ixor
    //   139: i2b
    //   140: bastore
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: goto -108 -> 37
    //   148: astore_0
    //   149: ldc 8
    //   151: new 39	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   158: ldc 102
    //   160: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 59	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_2
    //   177: areturn
    //   178: astore_0
    //   179: goto -30 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   1	144	1	j	int
    //   29	148	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	37	148	java/lang/NumberFormatException
    //   37	141	148	java/lang/NumberFormatException
    //   30	37	178	java/io/UnsupportedEncodingException
    //   37	141	178	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.HexUtil
 * JD-Core Version:    0.7.0.1
 */