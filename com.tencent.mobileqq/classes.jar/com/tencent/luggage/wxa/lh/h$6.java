package com.tencent.luggage.wxa.lh;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.qz.o;

class h$6
  extends ResultReceiver
{
  h$6(h paramh, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle != null)
    {
      if (paramInt != 10002) {
        return;
      }
      paramInt = paramBundle.getInt("key_event_type", -1);
      String str1 = paramBundle.getString("key_appid");
      int i = paramBundle.getInt("errCode", -1);
      String str2 = paramBundle.getString("errMsg");
      o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", new Object[] { Integer.valueOf(paramInt), str1 });
      if (paramInt != 12)
      {
        if ((paramInt != 31) && (paramInt != 41)) {
          return;
        }
        a.a(h.b(this.a), paramInt, paramBundle);
        return;
      }
      if (paramBundle != null) {
        h.a(this.a, str1, i, str2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.h.6
 * JD-Core Version:    0.7.0.1
 */