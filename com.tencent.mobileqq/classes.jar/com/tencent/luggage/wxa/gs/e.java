package com.tencent.luggage.wxa.gs;

import java.util.List;

public class e
  implements h
{
  private g a;
  private int b = 4;
  
  public com.tencent.luggage.wxa.gm.b a(List<com.tencent.luggage.wxa.gm.e> paramList)
  {
    if (this.a == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
      return null;
    }
    com.tencent.luggage.wxa.gm.b localb = com.tencent.luggage.wxa.gn.b.a().b();
    if (!this.a.a(localb, paramList))
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixer", "mix audio fail");
      return null;
    }
    return localb;
  }
  
  public void a()
  {
    if (this.a == null) {
      this.a = b();
    }
  }
  
  protected g b()
  {
    return c.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.e
 * JD-Core Version:    0.7.0.1
 */