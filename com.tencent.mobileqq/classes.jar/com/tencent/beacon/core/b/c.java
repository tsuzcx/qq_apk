package com.tencent.beacon.core.b;

import com.tencent.beacon.core.network.volley.Response.Listener;

class c
  implements Response.Listener<String>
{
  c(f paramf, b paramb) {}
  
  public void a(String paramString)
  {
    b localb = this.a;
    if (localb != null) {
      localb.onResponse(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.b.c
 * JD-Core Version:    0.7.0.1
 */