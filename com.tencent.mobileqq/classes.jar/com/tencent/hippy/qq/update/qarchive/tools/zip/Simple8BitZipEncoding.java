package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Simple8BitZipEncoding
  implements ZipEncoding
{
  private final char[] highChars;
  private final List<Simple8BitZipEncoding.Simple8BitChar> reverseMapping;
  
  public Simple8BitZipEncoding(char[] paramArrayOfChar)
  {
    this.highChars = ((char[])paramArrayOfChar.clone());
    paramArrayOfChar = new ArrayList(this.highChars.length);
    int j = 127;
    int i = 0;
    for (;;)
    {
      char[] arrayOfChar = this.highChars;
      if (i >= arrayOfChar.length) {
        break;
      }
      byte b = (byte)(j + 1);
      paramArrayOfChar.add(new Simple8BitZipEncoding.Simple8BitChar(b, arrayOfChar[i]));
      i += 1;
      j = b;
    }
    Collections.sort(paramArrayOfChar);
    this.reverseMapping = Collections.unmodifiableList(paramArrayOfChar);
  }
  
  private Simple8BitZipEncoding.Simple8BitChar encodeHighChar(char paramChar)
  {
    int j = this.reverseMapping.size();
    int i = 0;
    while (j > i)
    {
      int k = (j - i) / 2 + i;
      localSimple8BitChar = (Simple8BitZipEncoding.Simple8BitChar)this.reverseMapping.get(k);
      if (localSimple8BitChar.unicode == paramChar) {
        return localSimple8BitChar;
      }
      if (localSimple8BitChar.unicode < paramChar) {
        i = k + 1;
      } else {
        j = k;
      }
    }
    if (i >= this.reverseMapping.size()) {
      return null;
    }
    Simple8BitZipEncoding.Simple8BitChar localSimple8BitChar = (Simple8BitZipEncoding.Simple8BitChar)this.reverseMapping.get(i);
    if (localSimple8BitChar.unicode != paramChar) {
      return null;
    }
    return localSimple8BitChar;
  }
  
  public boolean canEncode(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      if (!canEncodeChar(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean canEncodeChar(char paramChar)
  {
    if ((paramChar >= 0) && (paramChar < '')) {
      return true;
    }
    return encodeHighChar(paramChar) != null;
  }
  
  public String decode(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfChar[i] = decodeByte(paramArrayOfByte[i]);
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public char decodeByte(byte paramByte)
  {
    if (paramByte >= 0) {
      return (char)paramByte;
    }
    return this.highChars[(paramByte + 128)];
  }
  
  public ByteBuffer encode(String paramString)
  {
    Object localObject1 = ByteBuffer.allocate(paramString.length() + 6 + (paramString.length() + 1) / 2);
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).remaining() < 6) {
        localObject2 = ZipEncodingHelper.growBuffer((ByteBuffer)localObject1, ((ByteBuffer)localObject1).position() + 6);
      }
      if (!pushEncodedChar((ByteBuffer)localObject2, c)) {
        ZipEncodingHelper.appendSurrogate((ByteBuffer)localObject2, c);
      }
      i += 1;
      localObject1 = localObject2;
    }
    ((ByteBuffer)localObject1).limit(((ByteBuffer)localObject1).position());
    ((ByteBuffer)localObject1).rewind();
    return localObject1;
  }
  
  public boolean pushEncodedChar(ByteBuffer paramByteBuffer, char paramChar)
  {
    if ((paramChar >= 0) && (paramChar < ''))
    {
      paramByteBuffer.put((byte)paramChar);
      return true;
    }
    Simple8BitZipEncoding.Simple8BitChar localSimple8BitChar = encodeHighChar(paramChar);
    if (localSimple8BitChar == null) {
      return false;
    }
    paramByteBuffer.put(localSimple8BitChar.code);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.Simple8BitZipEncoding
 * JD-Core Version:    0.7.0.1
 */