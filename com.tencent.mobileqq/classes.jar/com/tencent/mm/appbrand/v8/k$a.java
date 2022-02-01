package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.SharedV8ArrayBuffer;
import com.eclipsesource.mmv8.V8Context;
import java.nio.ByteBuffer;

final class k$a
{
  private final n a;
  private final int b;
  private ByteBuffer c;
  private SharedV8ArrayBuffer d;
  
  k$a(int paramInt, n paramn)
  {
    this.a = paramn;
    this.b = paramInt;
    this.c = ByteBuffer.allocateDirect(this.b);
    this.d = null;
  }
  
  SharedV8ArrayBuffer a()
  {
    if (this.d == null) {
      this.d = this.a.b().newSharedV8ArrayBuffer(this.c);
    }
    return this.d;
  }
  
  ByteBuffer b()
  {
    return this.c;
  }
  
  void c()
  {
    this.a.a().a(new k.a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.k.a
 * JD-Core Version:    0.7.0.1
 */