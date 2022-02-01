package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import java.io.UnsupportedEncodingException;

public abstract class b
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = a[((j & 0xF0) >> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    int i = 0;
    arrayOfByte = new byte[paramString.length() / 2];
    try
    {
      paramString = paramString.getBytes("UTF-8");
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)((byte)(Byte.decode("0x" + new String(new byte[] { paramString[(i * 2)] }, "UTF-8")).byteValue() << 4) ^ Byte.decode("0x" + new String(new byte[] { paramString[(i * 2 + 1)] }, "UTF-8")).byteValue()));
        i += 1;
      }
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException paramString)
    {
      HMSLog.e("BaseUtil", "hexString2ByteArray error" + paramString.getMessage());
      return arrayOfByte;
    }
    catch (NumberFormatException paramString)
    {
      HMSLog.e("BaseUtil", "hexString2ByteArray error" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.b
 * JD-Core Version:    0.7.0.1
 */