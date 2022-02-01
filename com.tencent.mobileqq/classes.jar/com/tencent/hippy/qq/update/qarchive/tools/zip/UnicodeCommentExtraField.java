package com.tencent.hippy.qq.update.qarchive.tools.zip;

public class UnicodeCommentExtraField
  extends AbstractUnicodeExtraField
{
  public static final ZipShort UCOM_ID = new ZipShort(25461);
  
  public UnicodeCommentExtraField() {}
  
  public UnicodeCommentExtraField(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  public UnicodeCommentExtraField(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public ZipShort getHeaderId()
  {
    return UCOM_ID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnicodeCommentExtraField
 * JD-Core Version:    0.7.0.1
 */