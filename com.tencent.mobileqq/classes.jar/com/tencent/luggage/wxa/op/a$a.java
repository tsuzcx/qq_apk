package com.tencent.luggage.wxa.op;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.b;
import com.tencent.luggage.wxa.lp.b.a;
import com.tencent.luggage.wxa.lp.d;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.i.a;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.lp.j.a;

class a$a
{
  public final int a;
  @Nullable
  public b.a b = b.a.a;
  public boolean c = false;
  public final i.a d;
  public final d e;
  public final h f;
  public final j g;
  public c h;
  
  a$a(int paramInt, @NonNull b paramb, @NonNull h paramh, @NonNull i.a parama, @NonNull d paramd, @NonNull c paramc, @Nullable j.a parama1)
  {
    this.a = paramInt;
    this.f = paramh;
    this.d = parama;
    this.e = paramd;
    this.h = paramc;
    a(paramb);
    this.g = paramh.d();
    this.g.a(parama1);
  }
  
  private void a(@NonNull b paramb)
  {
    b.a locala = paramb.a();
    if (locala != null) {
      this.b = locala;
    }
    paramb = paramb.b();
    if (paramb != null) {
      this.c = paramb.booleanValue();
    }
  }
  
  void a()
  {
    j localj = this.g;
    if (localj != null) {
      localj.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.a.a
 * JD-Core Version:    0.7.0.1
 */