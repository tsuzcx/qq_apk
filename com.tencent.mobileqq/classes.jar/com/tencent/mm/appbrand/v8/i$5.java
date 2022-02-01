package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextNodeJS;
import com.eclipsesource.mmv8.V8Context;
import com.tencent.luggage.wxa.qz.o;

class i$5
  implements n.a
{
  i$5(i parami) {}
  
  public V8Context a()
  {
    if (i.b(this.a) != null)
    {
      o.d("MicroMsg.NodeJSRuntime", "getMainContext %s", new Object[] { Integer.valueOf(i.b(this.a).getMainContext().hashCode()) });
      return i.b(this.a).getMainContext();
    }
    throw new IllegalStateException("getMainContext mNodeJS not ready!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.i.5
 * JD-Core Version:    0.7.0.1
 */