package com.tencent.luggage.wxa.jo;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jr.e;

class c$2
  implements com.tencent.luggage.wxa.jq.c
{
  c$2(c paramc) {}
  
  public void a(com.tencent.luggage.wxa.jr.c paramc)
  {
    c localc = this.a;
    localc.l = true;
    localc.h = paramc;
    if (localc.a != null)
    {
      paramc = new StringBuilder();
      paramc.append(this.a.a.g);
      paramc.append(" subscribeRenderingControlEvent success");
      Log.i("MRDevice", paramc.toString());
    }
  }
  
  public void a(@Nullable e parame)
  {
    if ((parame != null) && (this.a.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a.g);
      localStringBuilder.append(" subscribeRenderingControlEvent fail response code : ");
      localStringBuilder.append(parame.a);
      Log.e("MRDevice", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jo.c.2
 * JD-Core Version:    0.7.0.1
 */