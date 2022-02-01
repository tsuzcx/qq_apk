package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

class NioZipEncoding
  implements ZipEncoding
{
  private final Charset charset;
  
  public NioZipEncoding(Charset paramCharset)
  {
    this.charset = paramCharset;
  }
  
  public boolean canEncode(String paramString)
  {
    CharsetEncoder localCharsetEncoder = this.charset.newEncoder();
    localCharsetEncoder.onMalformedInput(CodingErrorAction.REPORT);
    localCharsetEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
    return localCharsetEncoder.canEncode(paramString);
  }
  
  public String decode(byte[] paramArrayOfByte)
  {
    return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(paramArrayOfByte)).toString();
  }
  
  public ByteBuffer encode(String paramString)
  {
    CharsetEncoder localCharsetEncoder = this.charset.newEncoder();
    localCharsetEncoder.onMalformedInput(CodingErrorAction.REPORT);
    localCharsetEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
    CharBuffer localCharBuffer = CharBuffer.wrap(paramString);
    paramString = ByteBuffer.allocate(paramString.length() + (paramString.length() + 1) / 2);
    while (localCharBuffer.remaining() > 0)
    {
      CoderResult localCoderResult = localCharsetEncoder.encode(localCharBuffer, paramString, true);
      boolean bool = localCoderResult.isUnmappable();
      int j = 0;
      if ((!bool) && (!localCoderResult.isMalformed()))
      {
        if (localCoderResult.isOverflow()) {
          paramString = ZipEncodingHelper.growBuffer(paramString, 0);
        } else if (localCoderResult.isUnderflow()) {
          localCharsetEncoder.flush(paramString);
        }
      }
      else
      {
        int i = j;
        Object localObject = paramString;
        if (localCoderResult.length() * 6 > paramString.remaining())
        {
          localObject = ZipEncodingHelper.growBuffer(paramString, paramString.position() + localCoderResult.length() * 6);
          i = j;
        }
        for (;;)
        {
          paramString = (String)localObject;
          if (i >= localCoderResult.length()) {
            break;
          }
          ZipEncodingHelper.appendSurrogate((ByteBuffer)localObject, localCharBuffer.get());
          i += 1;
        }
      }
    }
    paramString.limit(paramString.position());
    paramString.rewind();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.NioZipEncoding
 * JD-Core Version:    0.7.0.1
 */