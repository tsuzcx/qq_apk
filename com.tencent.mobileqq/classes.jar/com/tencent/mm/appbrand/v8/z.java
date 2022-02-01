package com.tencent.mm.appbrand.v8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.MultiContextV8;
import com.tencent.luggage.wxa.qz.o;

public class z
  extends a
{
  private MultiContextV8 e;
  
  z(@Nullable c.a parama)
  {
    super(parama);
  }
  
  @NonNull
  static z b(@Nullable c.a parama)
  {
    return new z(parama);
  }
  
  MultiContextV8 b()
  {
    this.e = MultiContextV8.createMultiContextV8(this.c, this.a, this.b);
    this.b = null;
    return this.e;
  }
  
  public z b(f paramf)
  {
    a(paramf);
    return this;
  }
  
  d c()
  {
    return ac.a(new z.1(this), a().g);
  }
  
  void d()
  {
    try
    {
      this.e.release();
      return;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", new Object[] { localException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.z
 * JD-Core Version:    0.7.0.1
 */