package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.util.LuggageActivityHelper.PermissionResultCallback;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class b$1
  implements LuggageActivityHelper.PermissionResultCallback
{
  b$1(b paramb, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void onResult(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      o.d("MicroMsg.BaseRecordJsApi", "PERMISSION_GRANTED, do invoke again");
      this.d.a(this.a, this.b, this.c);
      return;
    }
    o.b("MicroMsg.BaseRecordJsApi", "operateRecorder, SYS_PERM_DENIED");
    this.a.a(this.c, this.d.b("fail:system permission denied"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.b.1
 * JD-Core Version:    0.7.0.1
 */