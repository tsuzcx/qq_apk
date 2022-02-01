package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.c;
import java.math.BigInteger;
import java.nio.ByteBuffer;

final class e$a$3
  implements e
{
  public String a(@NonNull ByteBuffer paramByteBuffer)
  {
    return new BigInteger(1, c.a(paramByteBuffer)).toString(16);
  }
  
  public ByteBuffer a(@NonNull String paramString)
  {
    return ByteBuffer.wrap(new BigInteger(paramString, 16).toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e.a.3
 * JD-Core Version:    0.7.0.1
 */