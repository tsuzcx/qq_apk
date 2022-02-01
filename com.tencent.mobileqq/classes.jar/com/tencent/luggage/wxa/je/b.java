package com.tencent.luggage.wxa.je;

import android.graphics.Paint.Style;
import com.tencent.luggage.wxa.pc.g;

public class b
  extends a
{
  private static b a = new b();
  
  public static b c()
  {
    return a;
  }
  
  public void a(com.tencent.luggage.wxa.jf.a parama)
  {
    parama.reset();
    parama.d();
    parama.setStyle(Paint.Style.FILL);
    parama.setAntiAlias(true);
    parama.setStrokeWidth(g.c(1));
    super.a(parama);
  }
  
  public com.tencent.luggage.wxa.jf.a b()
  {
    com.tencent.luggage.wxa.jf.a locala = new com.tencent.luggage.wxa.jf.a();
    locala.setStyle(Paint.Style.FILL);
    locala.setAntiAlias(true);
    locala.setStrokeWidth(g.c(1));
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.je.b
 * JD-Core Version:    0.7.0.1
 */