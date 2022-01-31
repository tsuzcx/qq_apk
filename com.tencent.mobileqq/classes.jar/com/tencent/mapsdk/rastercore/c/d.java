package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;

public final class d
  extends a
{
  private float d;
  private float e;
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(e parame)
  {
    parame = parame.c();
    if (this.a)
    {
      parame.a((int)-this.d, (int)-this.e, this.b, this.c);
      return;
    }
    parame.scrollBy((int)-this.d, (int)-this.e);
  }
  
  public final void b(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.c.d
 * JD-Core Version:    0.7.0.1
 */