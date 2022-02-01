package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import junit.framework.a;
import org.joor.Reflect;

public abstract class b
{
  private String a;
  
  public b()
  {
    a.a("Must declare NAME in subclasses", true);
  }
  
  public final String d()
  {
    if (af.c(this.a)) {
      try
      {
        this.a = ((String)Reflect.on(getClass()).field("NAME").get());
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { af.a(localException) });
      }
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.b
 * JD-Core Version:    0.7.0.1
 */