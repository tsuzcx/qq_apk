package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.tool.v.VersionConfiguration;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

public class QIO
{
  public void md5Int(MessageDigest paramMessageDigest, int paramInt)
  {
    byte[] arrayOfByte = TypeHelper.intToByte(paramInt);
    paramMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void md5Long(MessageDigest paramMessageDigest, long paramLong)
  {
    byte[] arrayOfByte = TypeHelper.longToByte(paramLong);
    paramMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void md5String(MessageDigest paramMessageDigest, String paramString)
  {
    paramString = paramString.getBytes();
    md5Int(paramMessageDigest, paramString.length);
    paramMessageDigest.update(paramString, 0, paramString.length);
  }
  
  public int readInt(InputStream paramInputStream)
  {
    paramInputStream.read(VersionConfiguration.BYTE_4);
    return TypeHelper.byteToInt(VersionConfiguration.BYTE_4);
  }
  
  public long readLong(InputStream paramInputStream)
  {
    paramInputStream.read(VersionConfiguration.BYTE_8);
    return TypeHelper.byteToLong(VersionConfiguration.BYTE_8);
  }
  
  public String readString(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[readInt(paramInputStream)];
    paramInputStream.read(arrayOfByte);
    return new String(arrayOfByte);
  }
  
  public void writeInt(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(TypeHelper.intToByte(paramInt));
  }
  
  public void writeLong(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write(TypeHelper.longToByte(paramLong));
  }
  
  public void writeString(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes();
    writeInt(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QIO
 * JD-Core Version:    0.7.0.1
 */