package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.util.LuggageActivityHelper.PermissionResultCallback;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class a$1
  implements LuggageActivityHelper.PermissionResultCallback
{
  a$1(a parama, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void onResult(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      o.d("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
      this.d.a(this.a, this.b, this.c);
      return;
    }
    o.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
    a.a(this.d, true);
    this.a.a(this.c, this.d.b("fail:system permission denied"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.a.1
 * JD-Core Version:    0.7.0.1
 */