package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;

class w$2
  implements JavaVoidCallback
{
  w$2(w paramw, int paramInt) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if (paramV8Array.length() >= 1)
    {
      if (paramV8Array.getType(0) != 4) {
        return;
      }
      w.a(this.b).a(this.a, paramV8Array.getString(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.w.2
 * JD-Core Version:    0.7.0.1
 */