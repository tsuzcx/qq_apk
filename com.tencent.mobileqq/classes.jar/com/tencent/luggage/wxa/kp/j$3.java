package com.tencent.luggage.wxa.kp;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class j$3
  implements ActivityCompat.OnRequestPermissionsResultCallback
{
  j$3(j paramj, WeakReference paramWeakReference1, WeakReference paramWeakReference2, com.tencent.luggage.wxa.kd.j paramj1) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    e locale = (e)this.a.get();
    paramArrayOfString = (c)this.b.get();
    if (paramInt == 16)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0) && (locale != null) && (paramArrayOfString != null))
      {
        a.a().a(true);
        j.a(this.d, paramArrayOfString, locale, this.c);
        return;
      }
      paramArrayOfInt = new HashMap();
      if (locale != null) {
        paramArrayOfInt.put("cameraId", Integer.valueOf(locale.getCameraId()));
      } else {
        o.c("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
      }
      if (paramArrayOfString != null)
      {
        paramArrayOfInt = new JSONObject(paramArrayOfInt).toString();
        new h().b(paramArrayOfString).b(paramArrayOfInt).a();
      }
      else
      {
        o.c("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
      }
      a.a().a(false);
      return;
    }
    if (paramInt == 18)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0) && (locale != null) && (paramArrayOfString != null))
      {
        a.a().b(true);
        j.a(this.d, paramArrayOfString, locale, this.c);
        return;
      }
      paramArrayOfInt = new HashMap();
      if (locale != null) {
        paramArrayOfInt.put("cameraId", Integer.valueOf(locale.getCameraId()));
      } else {
        o.c("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
      }
      if (paramArrayOfString != null)
      {
        paramArrayOfInt = new JSONObject(paramArrayOfInt).toString();
        new h().b(paramArrayOfString).b(paramArrayOfInt).a();
      }
      else
      {
        o.c("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
      }
      a.a().b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.j.3
 * JD-Core Version:    0.7.0.1
 */