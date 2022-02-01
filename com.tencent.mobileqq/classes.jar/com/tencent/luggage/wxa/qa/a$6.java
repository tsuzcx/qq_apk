package com.tencent.luggage.wxa.qa;

import com.tencent.luggage.wxa.qz.o;

class a$6
  extends d
{
  a$6(a parama) {}
  
  public void a(String paramString, e parame)
  {
    super.a(paramString, parame);
    parame = new StringBuilder();
    parame.append("load icon fail: ");
    parame.append(paramString);
    o.b("IconLoadErrorHandler ", parame.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.a.6
 * JD-Core Version:    0.7.0.1
 */