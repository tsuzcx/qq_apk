package com.tencent.luggage.wxa.lz;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public enum a
{
  private final String e;
  
  private a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(h paramh, @Nullable String paramString)
  {
    if (paramh == null) {
      return;
    }
    o.d("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d", new Object[] { this.e, paramh.getAppId(), Integer.valueOf(paramh.hashCode()) });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("state", this.e);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("passThroughInfo", new JSONObject(paramString));
        localHashMap.put("appContactInfo", localJSONObject);
      }
      catch (JSONException paramString)
      {
        o.b("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, put passThroughInfo get Exception:%s", new Object[] { this.e, paramh.getAppId(), Integer.valueOf(paramh.hashCode()), paramString });
      }
    }
    new a.a(null).a(paramh).a(localHashMap).a();
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lz.a
 * JD-Core Version:    0.7.0.1
 */