package com.tencent.luggage.wxa.hd;

import android.os.Build;

final class c$10
  extends c.b
{
  final c.a a = new c.c(259);
  
  c$10(c.a parama)
  {
    super(parama);
  }
  
  String a()
  {
    Object localObject = this.a.a(null);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(b.a());
    return ((StringBuilder)localObject).toString();
  }
  
  void b() {}
  
  void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.10
 * JD-Core Version:    0.7.0.1
 */