package com.tencent.luggage.wxa.ga;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.i.a;

final class d
  extends com.tencent.luggage.wxa.fy.c<com.tencent.luggage.wxa.nb.c, View>
{
  private i.a<com.tencent.luggage.wxa.nb.c, View> a = new d.1(this);
  @NonNull
  private final a b;
  @NonNull
  private final c c;
  
  protected d(@NonNull a parama)
  {
    super(parama);
    this.b = parama;
    this.c = new c(parama);
  }
  
  @NonNull
  public h a()
  {
    return this.c.a();
  }
  
  @NonNull
  public i.a<com.tencent.luggage.wxa.nb.c, View> b()
  {
    return this.a;
  }
  
  @NonNull
  public com.tencent.luggage.wxa.lp.d c()
  {
    return this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.d
 * JD-Core Version:    0.7.0.1
 */