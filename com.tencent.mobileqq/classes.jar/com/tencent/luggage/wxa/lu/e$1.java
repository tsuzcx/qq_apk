package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.pd.t.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

class e$1
  implements t.b
{
  e$1(e parame) {}
  
  public void a(t.a parama1, t.a parama2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OrientationListener lastOrientation:");
    localStringBuilder.append(parama1.name());
    localStringBuilder.append("; newOrientation:");
    localStringBuilder.append(parama2.name());
    o.d("MicroMsg.JsApiEnableDeviceOrientation", localStringBuilder.toString());
    t.a(new e.1.1(this, parama2), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.e.1
 * JD-Core Version:    0.7.0.1
 */