package com.tencent.luggage.wxa.e;

import androidx.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class e
{
  public static InputStream a(@NonNull InputStream paramInputStream)
  {
    if (!paramInputStream.markSupported())
    {
      if ((paramInputStream instanceof FileInputStream)) {
        return new c((FileInputStream)paramInputStream);
      }
      return new BufferedInputStream(paramInputStream);
    }
    return paramInputStream;
  }
  
  public static void b(@NonNull InputStream paramInputStream)
  {
    paramInputStream.mark(8388608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.e.e
 * JD-Core Version:    0.7.0.1
 */