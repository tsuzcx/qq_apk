package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

public class BaseKeyUtil
{
  private static final int M = 16;
  private static final int N = 16;
  private static final int O = 10000;
  private static final String TAG = BaseKeyUtil.class.getSimpleName();
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < paramInt1) {}
    for (;;)
    {
      if (paramInt3 < paramInt2) {
        return paramInt3;
      }
      return paramInt2;
      paramInt2 = paramInt1;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= 16;
  }
  
  private static boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramInt) & f(paramArrayOfByte);
  }
  
  public static String exportHexRootKey(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    return HexUtil.byteArray2HexStr(exportRootKey(paramString1, paramString2, paramString3, paramArrayOfByte, paramInt, paramBoolean));
  }
  
  public static byte[] exportRootKey(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    return exportRootKey(paramString1, paramString2, paramString3, HexUtil.hexStr2ByteArray(paramString4), paramInt, paramBoolean);
  }
  
  @SuppressLint({"NewApi"})
  public static byte[] exportRootKey(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramString1 = HexUtil.hexStr2ByteArray(paramString1);
    paramString2 = HexUtil.hexStr2ByteArray(paramString2);
    paramString3 = HexUtil.hexStr2ByteArray(paramString3);
    int j = a(paramString1.length, paramString2.length, paramString3.length);
    if (!a(j, paramArrayOfByte)) {
      throw new IllegalArgumentException("key length must be more than 128bit.");
    }
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((char)(paramString1[i] ^ paramString2[i] ^ paramString3[i]));
      i += 1;
    }
    if (!paramBoolean)
    {
      b.d(TAG, "exportRootKey: sha1");
      return PBKDF2.pbkdf2(arrayOfChar, paramArrayOfByte, 10000, paramInt * 8);
    }
    b.d(TAG, "exportRootKey: sha256");
    return PBKDF2.pbkdf2SHA256(arrayOfChar, paramArrayOfByte, 10000, paramInt * 8);
  }
  
  @SuppressLint({"NewApi"})
  public static byte[] exportRootKey(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return exportRootKey(paramString1, paramString2, paramString3, paramArrayOfByte, 16, paramBoolean);
  }
  
  private static boolean f(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length >= 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil
 * JD-Core Version:    0.7.0.1
 */