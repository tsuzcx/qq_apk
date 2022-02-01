package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

abstract interface e
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public abstract String a(@NonNull ByteBuffer paramByteBuffer);
  
  public abstract ByteBuffer a(@NonNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e
 * JD-Core Version:    0.7.0.1
 */