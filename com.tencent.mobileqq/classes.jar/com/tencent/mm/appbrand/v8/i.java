package com.tencent.mm.appbrand.v8;

import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.MultiContextNodeJS;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.wxa.qz.o;

public final class i
  extends a
{
  private MultiContextNodeJS e;
  private volatile n f;
  private j g;
  
  static
  {
    MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new i.1());
  }
  
  private i(@Nullable c.a parama)
  {
    super(parama);
  }
  
  static i a(@Nullable c.a parama)
  {
    return new i(parama);
  }
  
  MultiContextV8 b()
  {
    try
    {
      this.e = MultiContextNodeJS.createMultiContextNodeJS(1, this.a, this.b, this.d);
      this.e.getRuntime().getV8().setNativeJavaCallback(new i.2(this));
      this.e.getRuntime().getV8().setJavaTaskScheduler(new i.3(this));
      this.b = null;
      return this.e.getRuntime();
    }
    finally {}
  }
  
  d c()
  {
    this.g = j.a(new i.4(this), a().g);
    return this.g;
  }
  
  void d()
  {
    o.d("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.e.release();
      o.d("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      return;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
    }
  }
  
  public n q()
  {
    if (this.f == null) {
      this.f = new n(this, e(), new i.5(this));
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i
 * JD-Core Version:    0.7.0.1
 */