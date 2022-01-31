package com.squareup.okhttp.internal.framed;

import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.ByteString;

final class Hpack$Writer
{
  private final Buffer out;
  
  Hpack$Writer(Buffer paramBuffer)
  {
    this.out = paramBuffer;
  }
  
  void writeByteString(ByteString paramByteString)
  {
    writeInt(paramByteString.size(), 127, 0);
    this.out.write(paramByteString);
  }
  
  void writeHeaders(List<Header> paramList)
  {
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      ByteString localByteString = ((Header)paramList.get(i)).name.toAsciiLowercase();
      Integer localInteger = (Integer)Hpack.access$200().get(localByteString);
      if (localInteger != null)
      {
        writeInt(localInteger.intValue() + 1, 15, 0);
        writeByteString(((Header)paramList.get(i)).value);
      }
      for (;;)
      {
        i += 1;
        break;
        this.out.writeByte(0);
        writeByteString(localByteString);
        writeByteString(((Header)paramList.get(i)).value);
      }
    }
  }
  
  void writeInt(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
    {
      this.out.writeByte(paramInt3 | paramInt1);
      return;
    }
    this.out.writeByte(paramInt3 | paramInt2);
    paramInt1 -= paramInt2;
    while (paramInt1 >= 128)
    {
      this.out.writeByte(paramInt1 & 0x7F | 0x80);
      paramInt1 >>>= 7;
    }
    this.out.writeByte(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Hpack.Writer
 * JD-Core Version:    0.7.0.1
 */