package com.tencent.luggage.wxa.bl;

import com.tencent.luggage.wxa.bm.g;

public class c
{
  private static volatile c a;
  private g b = new com.tencent.luggage.wxa.bm.c();
  
  public static c a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new c();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(g paramg)
  {
    this.b = paramg;
  }
  
  public g b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bl.c
 * JD-Core Version:    0.7.0.1
 */