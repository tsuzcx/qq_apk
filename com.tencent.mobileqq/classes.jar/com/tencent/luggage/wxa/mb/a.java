package com.tencent.luggage.wxa.mb;

import android.content.Context;
import com.tencent.luggage.wxa.qz.r;

public class a
{
  private com.tencent.luggage.wxa.hg.a a;
  private Context b = r.a();
  private com.tencent.luggage.wxa.hg.a.a c;
  private a.a d;
  private boolean e = false;
  
  public static a a()
  {
    return new a();
  }
  
  public boolean a(com.tencent.luggage.wxa.hg.a.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = new a.b(this, null);
    }
    if (this.a == null) {
      this.a = new com.tencent.luggage.wxa.hg.a(this.b);
    }
    if (this.c != localObject) {
      this.c = ((com.tencent.luggage.wxa.hg.a.a)localObject);
    }
    this.a.a(this.c);
    return b();
  }
  
  public boolean a(a.a parama)
  {
    this.d = parama;
    return a(null);
  }
  
  public boolean a(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.hg.a locala = this.a;
    boolean bool;
    if (locala != null) {
      bool = locala.b();
    } else {
      bool = false;
    }
    this.e = false;
    if (paramBoolean)
    {
      this.a = null;
      this.c = null;
      this.d = null;
    }
    return bool;
  }
  
  public boolean b()
  {
    com.tencent.luggage.wxa.hg.a locala = this.a;
    if (locala == null) {
      return false;
    }
    if (this.e) {
      return false;
    }
    locala.a();
    this.e = true;
    return this.e;
  }
  
  public boolean c()
  {
    return a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mb.a
 * JD-Core Version:    0.7.0.1
 */