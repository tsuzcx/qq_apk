package com.tencent.luggage.wxa.pm;

import com.tencent.luggage.wxa.qz.o;

public class d
  extends g
  implements b
{
  private String a = "*";
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      o.d("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      return;
    }
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pm.d
 * JD-Core Version:    0.7.0.1
 */