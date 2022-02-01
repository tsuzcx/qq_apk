package com.tencent.luggage.wxa.kr;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.tencent.luggage.wxa.jx.c;
import org.json.JSONObject;

class e$1
  implements ActivityCompat.OnRequestPermissionsResultCallback
{
  e$1(e parame, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt != 48) {
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.d.a(this.a, this.b, this.c);
      return;
    }
    this.a.a(this.c, this.d.b("fail:system permission denied"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.e.1
 * JD-Core Version:    0.7.0.1
 */