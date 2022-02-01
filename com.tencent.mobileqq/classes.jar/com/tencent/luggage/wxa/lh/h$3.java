package com.tencent.luggage.wxa.lh;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.qz.o;

class h$3
  extends ResultReceiver
{
  h$3(h paramh, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle != null)
    {
      if (paramInt != 10001) {
        return;
      }
      paramInt = paramBundle.getInt("errCode", -1);
      paramBundle = paramBundle.getString("errMsg");
      h.a(this.a, paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.h.3
 * JD-Core Version:    0.7.0.1
 */