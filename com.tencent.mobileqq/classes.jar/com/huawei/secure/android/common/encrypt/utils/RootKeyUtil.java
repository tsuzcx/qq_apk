package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;

public class RootKeyUtil
{
  private static final String TAG = RootKeyUtil.class.getSimpleName();
  private byte[] S = null;
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, HexUtil.hexStr2ByteArray(paramString4));
  }
  
  @SuppressLint({"NewApi"})
  private void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      b.d(TAG, "initRootKey: sha1");
      this.S = BaseKeyUtil.exportRootKey(paramString1, paramString2, paramString3, paramArrayOfByte, false);
      return;
    }
    b.d(TAG, "initRootKey: sha256");
    this.S = BaseKeyUtil.exportRootKey(paramString1, paramString2, paramString3, paramArrayOfByte, true);
  }
  
  public static RootKeyUtil newInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RootKeyUtil localRootKeyUtil = new RootKeyUtil();
    localRootKeyUtil.a(paramString1, paramString2, paramString3, paramString4);
    return localRootKeyUtil;
  }
  
  public static RootKeyUtil newInstance(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    RootKeyUtil localRootKeyUtil = new RootKeyUtil();
    localRootKeyUtil.a(paramString1, paramString2, paramString3, paramArrayOfByte);
    return localRootKeyUtil;
  }
  
  public byte[] getRootKey()
  {
    return (byte[])this.S.clone();
  }
  
  public String getRootKeyHex()
  {
    return HexUtil.byteArray2HexStr(this.S);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.RootKeyUtil
 * JD-Core Version:    0.7.0.1
 */