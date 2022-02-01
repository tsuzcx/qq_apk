package com.tencent.mm.appbrand.v8;

import androidx.annotation.NonNull;
import com.eclipsesource.mmv8.V8Object;

public class s
  extends p
{
  private final e a;
  
  public s(@NonNull e parame)
  {
    super("WeixinArrayBuffer");
    this.a = parame;
  }
  
  void a() {}
  
  protected void a(n paramn, V8Object paramV8Object)
  {
    paramV8Object.registerJavaMethod(new s.1(this), "get");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */