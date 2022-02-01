package com.tencent.luggage.wxa.ja;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.je.b;
import com.tencent.luggage.wxa.pc.g;
import java.util.Stack;

public class d
  implements a
{
  private com.tencent.luggage.wxa.jf.a a;
  private com.tencent.luggage.wxa.jf.a b;
  private Stack<com.tencent.luggage.wxa.jf.a> c;
  private Stack<com.tencent.luggage.wxa.jf.a> d;
  private Paint e = new Paint();
  private Paint f;
  private e g;
  private a h;
  private final a.b i = new a.b();
  private com.tencent.luggage.wxa.jx.c j;
  private boolean k = true;
  
  public d(@NonNull a parama)
  {
    this.h = parama;
    if (k()) {
      parama = com.tencent.luggage.wxa.je.c.c().a();
    } else {
      parama = new com.tencent.luggage.wxa.jf.a();
    }
    this.a = parama;
    if (k()) {
      parama = b.c().a();
    } else {
      parama = new com.tencent.luggage.wxa.jf.a();
    }
    this.b = parama;
    this.a.setStyle(Paint.Style.STROKE);
    this.b.setStyle(Paint.Style.FILL);
    this.a.setAntiAlias(true);
    this.b.setAntiAlias(true);
    this.a.setStrokeWidth(g.c(1));
    this.b.setStrokeWidth(g.c(1));
    this.c = new Stack();
    this.d = new Stack();
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void a()
  {
    this.h.a();
  }
  
  public void a(e parame)
  {
    this.g = parame;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc)
  {
    this.j = paramc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void b()
  {
    this.c.clear();
    this.d.clear();
    this.a.reset();
    this.b.reset();
    this.a.setStyle(Paint.Style.STROKE);
    this.b.setStyle(Paint.Style.FILL);
    this.a.setAntiAlias(true);
    this.b.setAntiAlias(true);
    this.a.setStrokeWidth(g.c(1));
    this.b.setStrokeWidth(g.c(1));
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.jf.a locala = this.a;
    this.c.push(locala);
    if (k())
    {
      this.a = com.tencent.luggage.wxa.je.c.c().a();
      locala.a(this.a);
    }
    else
    {
      this.a = locala.a();
    }
    if (this.a == null) {
      this.a = locala;
    }
    locala = this.b;
    this.d.push(locala);
    if (k()) {
      this.b = b.c().a();
    } else {
      this.b = locala.a();
    }
    locala.a(this.b);
    if (this.b == null) {
      this.b = locala;
    }
  }
  
  public void d()
  {
    if (this.c.isEmpty()) {
      return;
    }
    com.tencent.luggage.wxa.jf.a locala1 = this.a;
    com.tencent.luggage.wxa.jf.a locala2 = this.b;
    this.a = ((com.tencent.luggage.wxa.jf.a)this.c.pop());
    this.b = ((com.tencent.luggage.wxa.jf.a)this.d.pop());
    if (k())
    {
      if (this.a != locala1) {
        com.tencent.luggage.wxa.je.c.c().a(locala1);
      }
      if (this.b != locala2) {
        b.c().a(locala2);
      }
    }
  }
  
  public com.tencent.luggage.wxa.jf.a e()
  {
    return this.a;
  }
  
  public Paint f()
  {
    return this.e;
  }
  
  public Paint g()
  {
    return this.f;
  }
  
  public com.tencent.luggage.wxa.jf.a h()
  {
    return this.b;
  }
  
  public com.tencent.luggage.wxa.jx.c i()
  {
    return this.j;
  }
  
  public e j()
  {
    return this.g;
  }
  
  public boolean k()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.d
 * JD-Core Version:    0.7.0.1
 */