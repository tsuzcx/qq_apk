package com.tencent.luggage.wxa.ky;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

class d$5
  implements ActivityCompat.OnRequestPermissionsResultCallback
{
  d$5(d paramd, Activity paramActivity, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    o.d("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 117)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        t.a(new d.5.1(this), 50L);
        return;
      }
      o.d("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
      this.b.a(this.d, this.e.b("fail:system permission denied"));
      return;
    }
    if (paramInt == 118)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        t.a(new d.5.2(this), 50L);
        return;
      }
      o.d("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
      this.b.a(this.d, this.e.b("fail:system permission denied"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.d.5
 * JD-Core Version:    0.7.0.1
 */