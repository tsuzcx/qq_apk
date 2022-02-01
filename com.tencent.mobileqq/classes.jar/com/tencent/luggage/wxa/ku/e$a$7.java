package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class e$a$7
  implements e
{
  private final Charset b = Charset.forName("ISO-8859-1");
  
  public String a(@NonNull ByteBuffer paramByteBuffer)
  {
    return new String(c.a(paramByteBuffer), this.b);
  }
  
  public ByteBuffer a(@NonNull String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e.a.7
 * JD-Core Version:    0.7.0.1
 */