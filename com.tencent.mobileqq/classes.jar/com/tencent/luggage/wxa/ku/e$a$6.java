package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.c;
import java.nio.ByteBuffer;

final class e$a$6
  implements e
{
  public String a(@NonNull ByteBuffer paramByteBuffer)
  {
    return new String(c.a(paramByteBuffer), a);
  }
  
  public ByteBuffer a(@NonNull String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e.a.6
 * JD-Core Version:    0.7.0.1
 */