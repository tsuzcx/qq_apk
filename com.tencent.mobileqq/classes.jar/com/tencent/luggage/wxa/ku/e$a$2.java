package com.tencent.luggage.wxa.ku;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.c;
import java.nio.ByteBuffer;

final class e$a$2
  implements e
{
  public String a(@NonNull ByteBuffer paramByteBuffer)
  {
    return new String(Base64.encode(c.a(paramByteBuffer), 2), a);
  }
  
  public ByteBuffer a(@NonNull String paramString)
  {
    return ByteBuffer.wrap(Base64.decode(paramString.getBytes(a), 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e.a.2
 * JD-Core Version:    0.7.0.1
 */