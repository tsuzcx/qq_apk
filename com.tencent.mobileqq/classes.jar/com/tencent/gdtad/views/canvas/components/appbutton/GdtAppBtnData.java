package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtAppBtnData
  implements Serializable
{
  public String apkUrlhttp;
  public int cProgerss;
  public int cState = 0;
  public String mGdtAd_appId;
  public String name;
  public String packageName;
  public String via;
  
  public static GdtAppBtnData parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("appData");
      paramJSONObject = new GdtAppBtnData();
      try
      {
        paramJSONObject.apkUrlhttp = localJSONObject.optString("apkUrl");
        paramJSONObject.packageName = localJSONObject.optString("packageName");
        paramJSONObject.name = localJSONObject.optString("name");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnData
 * JD-Core Version:    0.7.0.1
 */