package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

public final class JarMarker
  implements ZipExtraField
{
  private static final JarMarker DEFAULT = new JarMarker();
  private static final ZipShort ID = new ZipShort(51966);
  private static final byte[] NO_BYTES;
  private static final ZipShort NULL = new ZipShort(0);
  
  static
  {
    NO_BYTES = new byte[0];
  }
  
  public static JarMarker getInstance()
  {
    return DEFAULT;
  }
  
  public byte[] getCentralDirectoryData()
  {
    return NO_BYTES;
  }
  
  public ZipShort getCentralDirectoryLength()
  {
    return NULL;
  }
  
  public ZipShort getHeaderId()
  {
    return ID;
  }
  
  public byte[] getLocalFileDataData()
  {
    return NO_BYTES;
  }
  
  public ZipShort getLocalFileDataLength()
  {
    return NULL;
  }
  
  public void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    throw new ZipException("JarMarker doesn't expect any data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.JarMarker
 * JD-Core Version:    0.7.0.1
 */