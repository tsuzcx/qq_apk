package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8Context;

class a$2
  implements n.a
{
  a$2(a parama, int paramInt) {}
  
  public V8Context a()
  {
    if (a.a(this.b) != null) {
      return a.a(this.b).createContext(this.a);
    }
    throw new IllegalStateException("createContext mV8 not ready!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a.2
 * JD-Core Version:    0.7.0.1
 */