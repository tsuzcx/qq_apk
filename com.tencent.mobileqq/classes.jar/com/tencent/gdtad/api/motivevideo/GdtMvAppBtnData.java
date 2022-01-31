package com.tencent.gdtad.api.motivevideo;

import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnData;
import org.json.JSONObject;
import yny;

public class GdtMvAppBtnData
  extends GdtAppBtnData
{
  public static GdtMvAppBtnData parseJsonForMv(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
      paramJSONObject = new GdtMvAppBtnData();
      try
      {
        paramJSONObject.apkUrlhttp = localJSONObject.optString("dstlink");
        return paramJSONObject;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramJSONObject = null;
      }
    }
    yny.d("GdtMvDownloadBtnPresenter", "parseJsonForMv Error", localException1);
    localException1.printStackTrace();
    return paramJSONObject;
  }
  
  public String toString()
  {
    return "GdtMvAppBtnData{mGdtAd_appId='" + this.mGdtAd_appId + '\'' + ", apkUrlhttp='" + this.apkUrlhttp + '\'' + ", packageName='" + this.packageName + '\'' + ", name='" + this.name + '\'' + ", cState=" + this.cState + ", cProgerss=" + this.cProgerss + ", via='" + this.via + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAppBtnData
 * JD-Core Version:    0.7.0.1
 */