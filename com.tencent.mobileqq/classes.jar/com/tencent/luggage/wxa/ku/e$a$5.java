package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class e$a$5
  implements e
{
  e$a$5(Charset paramCharset) {}
  
  public String a(@NonNull ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return new String(c.a(paramByteBuffer), this.b);
  }
  
  public ByteBuffer a(@NonNull String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(this.b)).order(ByteOrder.LITTLE_ENDIAN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e.a.5
 * JD-Core Version:    0.7.0.1
 */