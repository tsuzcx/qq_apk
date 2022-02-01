package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.mm.plugin.appbrand.jsruntime.x;

class r
  extends p
{
  private x a;
  private final JavaVoidCallback b = new r.1(this);
  
  public r()
  {
    super("console");
  }
  
  public void a()
  {
    this.a = null;
  }
  
  protected void a(n paramn, V8Object paramV8Object)
  {
    paramV8Object.registerJavaMethod(new r.2(this), "log");
    paramV8Object.registerJavaMethod(new r.3(this), "info");
    paramV8Object.registerJavaMethod(new r.4(this), "warn");
    paramV8Object.registerJavaMethod(new r.5(this), "error");
    paramV8Object.registerJavaMethod(new r.6(this), "debug");
    paramV8Object.registerJavaMethod(this.b, "assert");
    paramV8Object.registerJavaMethod(this.b, "count");
    paramV8Object.registerJavaMethod(this.b, "profile");
    paramV8Object.registerJavaMethod(this.b, "profileEnd");
    paramV8Object.registerJavaMethod(this.b, "time");
    paramV8Object.registerJavaMethod(this.b, "timeEnd");
    paramV8Object.registerJavaMethod(this.b, "timeStamp");
    paramV8Object.registerJavaMethod(this.b, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.b, "group");
    paramV8Object.registerJavaMethod(this.b, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.b, "groupEnd");
    paramV8Object.registerJavaMethod(this.b, "clear");
    paramV8Object.registerJavaMethod(this.b, "dir");
    paramV8Object.registerJavaMethod(this.b, "dirxml");
    paramV8Object.registerJavaMethod(this.b, "table");
    paramV8Object.registerJavaMethod(this.b, "trace");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.r
 * JD-Core Version:    0.7.0.1
 */