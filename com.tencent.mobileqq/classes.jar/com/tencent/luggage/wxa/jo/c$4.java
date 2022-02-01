package com.tencent.luggage.wxa.jo;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jq.a;
import com.tencent.luggage.wxa.jr.e;

class c$4
  implements a
{
  c$4(c paramc) {}
  
  public void a(@Nullable e parame)
  {
    parame = this.a;
    parame.l = false;
    parame.h = null;
    if (parame.a != null)
    {
      parame = new StringBuilder();
      parame.append(this.a.a.g);
      parame.append(" unSubscribeRenderingControlEvent success");
      Log.i("MRDevice", parame.toString());
    }
  }
  
  public void b(@Nullable e parame)
  {
    if ((parame != null) && (this.a.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a.g);
      localStringBuilder.append(" unSubscribeRenderingControlEvent fail response code : ");
      localStringBuilder.append(parame.a);
      Log.e("MRDevice", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jo.c.4
 * JD-Core Version:    0.7.0.1
 */