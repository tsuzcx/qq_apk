package com.tencent.hippy.qq.update.qarchive.tools.zip;

public class UnicodePathExtraField
  extends AbstractUnicodeExtraField
{
  public static final ZipShort UPATH_ID = new ZipShort(28789);
  
  public UnicodePathExtraField() {}
  
  public UnicodePathExtraField(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  public UnicodePathExtraField(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public ZipShort getHeaderId()
  {
    return UPATH_ID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnicodePathExtraField
 * JD-Core Version:    0.7.0.1
 */