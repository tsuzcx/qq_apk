package com.tencent.hippy.qq.update.qarchive.tools.zip;

final class Simple8BitZipEncoding$Simple8BitChar
  implements Comparable<Simple8BitChar>
{
  public final byte code;
  public final char unicode;
  
  Simple8BitZipEncoding$Simple8BitChar(byte paramByte, char paramChar)
  {
    this.code = paramByte;
    this.unicode = paramChar;
  }
  
  public int compareTo(Simple8BitChar paramSimple8BitChar)
  {
    return this.unicode - paramSimple8BitChar.unicode;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Simple8BitChar;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Simple8BitChar)paramObject;
      bool1 = bool2;
      if (this.unicode == paramObject.unicode)
      {
        bool1 = bool2;
        if (this.code == paramObject.code) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.unicode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    localStringBuilder.append(Integer.toHexString(this.unicode & 0xFFFF));
    localStringBuilder.append("->0x");
    localStringBuilder.append(Integer.toHexString(this.code & 0xFF));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.Simple8BitZipEncoding.Simple8BitChar
 * JD-Core Version:    0.7.0.1
 */