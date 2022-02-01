package com.huawei.secure.android.common.encrypt.utils;

import android.support.annotation.RequiresApi;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;

public class WorkKeyCryptUtil
{
  public static String decryptWorkKey(String paramString, RootKeyUtil paramRootKeyUtil)
  {
    return AesCbc.decrypt(paramString, paramRootKeyUtil.getRootKey());
  }
  
  public static String decryptWorkKey(String paramString, byte[] paramArrayOfByte)
  {
    return AesCbc.decrypt(paramString, paramArrayOfByte);
  }
  
  public static byte[] decryptWorkKey2Byte(byte[] paramArrayOfByte1, RootKeyUtil paramRootKeyUtil, byte[] paramArrayOfByte2)
  {
    return AesCbc.decrypt(paramArrayOfByte1, paramRootKeyUtil.getRootKey(), paramArrayOfByte2);
  }
  
  public static byte[] decryptWorkKey2Byte(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return AesCbc.decrypt(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  @RequiresApi(api=19)
  public static byte[] decryptWorkKey2ByteGcm(byte[] paramArrayOfByte1, RootKeyUtil paramRootKeyUtil, byte[] paramArrayOfByte2)
  {
    return AesGcm.decrypt(paramArrayOfByte1, paramRootKeyUtil.getRootKey(), paramArrayOfByte2);
  }
  
  @RequiresApi(api=19)
  public static byte[] decryptWorkKey2ByteGcm(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return AesGcm.decrypt(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  @RequiresApi(api=19)
  public static String decryptWorkKeyGcm(String paramString, RootKeyUtil paramRootKeyUtil)
  {
    return AesGcm.decrypt(paramString, paramRootKeyUtil.getRootKey());
  }
  
  @RequiresApi(api=19)
  public static String decryptWorkKeyGcm(String paramString, byte[] paramArrayOfByte)
  {
    return AesGcm.decrypt(paramString, paramArrayOfByte);
  }
  
  public static String encryptWorkKey(String paramString, RootKeyUtil paramRootKeyUtil)
  {
    return AesCbc.encrypt(paramString, paramRootKeyUtil.getRootKey());
  }
  
  public static String encryptWorkKey(String paramString, byte[] paramArrayOfByte)
  {
    return AesCbc.encrypt(paramString, paramArrayOfByte);
  }
  
  public static byte[] encryptWorkKey2Byte(byte[] paramArrayOfByte1, RootKeyUtil paramRootKeyUtil, byte[] paramArrayOfByte2)
  {
    return AesCbc.encrypt(paramArrayOfByte1, paramRootKeyUtil.getRootKey(), paramArrayOfByte2);
  }
  
  public static byte[] encryptWorkKey2Byte(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return AesCbc.encrypt(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  @RequiresApi(api=19)
  public static byte[] encryptWorkKey2ByteGcm(byte[] paramArrayOfByte1, RootKeyUtil paramRootKeyUtil, byte[] paramArrayOfByte2)
  {
    return AesGcm.encrypt(paramArrayOfByte1, paramRootKeyUtil.getRootKey(), paramArrayOfByte2);
  }
  
  @RequiresApi(api=19)
  public static byte[] encryptWorkKey2ByteGcm(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return AesGcm.encrypt(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  @RequiresApi(api=19)
  public static String encryptWorkKeyGcm(String paramString, RootKeyUtil paramRootKeyUtil)
  {
    return AesGcm.encrypt(paramString, paramRootKeyUtil.getRootKey());
  }
  
  @RequiresApi(api=19)
  public static String encryptWorkKeyGcm(String paramString, byte[] paramArrayOfByte)
  {
    return AesGcm.encrypt(paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil
 * JD-Core Version:    0.7.0.1
 */