package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.tencent.luggage.wxa.fx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

class j$14
  implements ActivityCompat.OnRequestPermissionsResultCallback
{
  j$14(j paramj, Activity paramActivity, a parama) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    o.d(j.g(this.c), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 117)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        t.a(new j.14.1(this), 50L);
        return;
      }
      o.d(j.g(this.c), "onRequestPermissionsResult callback, camera permission not grant");
      this.b.a("fail:system permission denied");
      return;
    }
    if (paramInt == 118)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        t.a(new j.14.2(this), 50L);
        return;
      }
      o.d(j.g(this.c), "onRequestPermissionsResult callback, microphone permission not grant");
      this.b.a("fail:system permission denied");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.14
 * JD-Core Version:    0.7.0.1
 */