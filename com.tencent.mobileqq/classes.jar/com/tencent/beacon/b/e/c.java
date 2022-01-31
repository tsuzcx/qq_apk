package com.tencent.beacon.b.e;

import com.tencent.beacon.e.a;
import com.tencent.beacon.e.b;

public final class c
  extends com.tencent.beacon.e.c
{
  private String a = "";
  private int b = 0;
  private int c = 0;
  private boolean d = true;
  
  public final void a(a parama)
  {
    this.a = parama.b(0, true);
    this.b = parama.a(this.b, 1, true);
    this.c = parama.a(this.c, 2, false);
    boolean bool = this.d;
    this.d = parama.a(3, false);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.e.c
 * JD-Core Version:    0.7.0.1
 */