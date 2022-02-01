package com.huawei.hms.opendevice;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;

public abstract class a
{
  public static String a(byte[] paramArrayOfByte)
  {
    return HexUtil.byteArray2HexStr(paramArrayOfByte);
  }
  
  public static byte[] a(String paramString)
  {
    return HexUtil.hexStr2ByteArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.a
 * JD-Core Version:    0.7.0.1
 */