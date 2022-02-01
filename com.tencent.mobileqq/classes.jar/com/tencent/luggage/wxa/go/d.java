package com.tencent.luggage.wxa.go;

import com.tencent.luggage.wxa.gq.k;
import com.tencent.luggage.wxa.gq.l;

public class d
  extends l
{
  private e a;
  
  public d(e parame, String paramString, int paramInt)
  {
    super(paramString, paramInt);
    this.a = parame;
  }
  
  public void run()
  {
    e locale = this.a;
    if (locale != null)
    {
      locale.a();
      this.a.b();
    }
    this.a = null;
    k.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.go.d
 * JD-Core Version:    0.7.0.1
 */