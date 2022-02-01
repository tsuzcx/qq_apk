package com.tencent.luggage.wxa.mw;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kp.a;
import com.tencent.luggage.wxa.kp.e;
import com.tencent.luggage.wxa.kp.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class b$3
  implements ActivityCompat.OnRequestPermissionsResultCallback
{
  b$3(b paramb, c paramc, e parame, b.a parama) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt == 16)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        a.a().a(true);
        b.a(this.d, this.a, this.b, this.c);
        return;
      }
      paramArrayOfString = new HashMap();
      paramArrayOfString.put("cameraId", Integer.valueOf(this.b.getCameraId()));
      paramArrayOfString = new JSONObject(paramArrayOfString).toString();
      new h().b(this.a).b(paramArrayOfString).a();
      a.a().a(false);
      return;
    }
    if (paramInt == 18)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        a.a().b(true);
        b.a(this.d, this.a, this.b, this.c);
        return;
      }
      paramArrayOfString = new HashMap();
      paramArrayOfString.put("cameraId", Integer.valueOf(this.b.getCameraId()));
      paramArrayOfString = new JSONObject(paramArrayOfString).toString();
      new h().b(this.a).b(paramArrayOfString).a();
      a.a().b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mw.b.3
 * JD-Core Version:    0.7.0.1
 */