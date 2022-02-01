package com.tencent.luggage.wxa.qz;

import androidx.annotation.NonNull;
import java.io.StringWriter;
import java.io.Writer;

final class a$3
  extends Writer
{
  private StringWriter a;
  
  public void close()
  {
    flush();
  }
  
  public void flush()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((StringWriter)localObject).toString();
    this.a = null;
    o.c("MicroMsg.BitmapTracer", (String)localObject);
  }
  
  public void write(@NonNull char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      this.a = new StringWriter();
    }
    this.a.write(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.a.3
 * JD-Core Version:    0.7.0.1
 */