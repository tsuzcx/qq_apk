package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.support.annotation.Keep;
import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class AdAppBtnData
  implements Serializable
{
  public String apkUrlhttp;
  public volatile int cProgerss;
  public volatile int cState = 0;
  public String mGdtAd_appId;
  public String name;
  public String packageName;
  public String signatureMd5Molo;
  public String via;
  
  public static AdAppBtnData parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("appData");
      paramJSONObject = new AdAppBtnData();
      try
      {
        paramJSONObject.apkUrlhttp = localJSONObject.optString("apkUrl");
        paramJSONObject.packageName = localJSONObject.optString("packageName");
        paramJSONObject.name = localJSONObject.optString("name");
        paramJSONObject.signatureMd5Molo = localJSONObject.optString("signatureMd5Molo");
        return paramJSONObject;
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramJSONObject = null;
      }
    }
    localJSONException1.printStackTrace();
    return paramJSONObject;
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.apkUrlhttp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData
 * JD-Core Version:    0.7.0.1
 */