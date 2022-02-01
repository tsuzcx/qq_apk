package com.tencent.beacon.core.b;

import com.tencent.beacon.core.network.volley.Response.ErrorListener;
import com.tencent.beacon.core.network.volley.VolleyError;

class d
  implements Response.ErrorListener
{
  d(f paramf, b paramb) {}
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    b localb = this.a;
    if (localb != null) {
      localb.a(paramVolleyError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.b.d
 * JD-Core Version:    0.7.0.1
 */