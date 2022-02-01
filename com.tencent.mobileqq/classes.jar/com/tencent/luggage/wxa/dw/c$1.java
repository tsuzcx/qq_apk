package com.tencent.luggage.wxa.dw;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.qz.o;

class c$1
  extends ResultReceiver
{
  c$1(c paramc, Handler paramHandler, b paramb)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      this.a.a(null);
      return;
    }
    paramBundle.setClassLoader(c.a.class.getClassLoader());
    try
    {
      this.a.a(c.a.a((c.a)paramBundle.getParcelable("parcel")));
      return;
    }
    catch (NullPointerException paramBundle) {}catch (ClassCastException paramBundle) {}
    o.b("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "onReceiveResult, e = %s", new Object[] { paramBundle });
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.c.1
 * JD-Core Version:    0.7.0.1
 */