package com.tencent.hippy.qq.update.qarchive.tools.zip;

class ZipEncodingHelper$SimpleEncodingHolder
{
  private Simple8BitZipEncoding encoding;
  private final char[] highChars;
  
  ZipEncodingHelper$SimpleEncodingHolder(char[] paramArrayOfChar)
  {
    this.highChars = paramArrayOfChar;
  }
  
  public Simple8BitZipEncoding getEncoding()
  {
    try
    {
      if (this.encoding == null) {
        this.encoding = new Simple8BitZipEncoding(this.highChars);
      }
      Simple8BitZipEncoding localSimple8BitZipEncoding = this.encoding;
      return localSimple8BitZipEncoding;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncodingHelper.SimpleEncodingHolder
 * JD-Core Version:    0.7.0.1
 */