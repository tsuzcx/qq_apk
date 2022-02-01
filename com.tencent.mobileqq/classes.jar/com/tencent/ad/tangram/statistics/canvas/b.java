package com.tencent.ad.tangram.statistics.canvas;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.statistics.xijing.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static final String DMP_ACTION_DOWNLOAD_CLICK = "DOWNLOAD_CLICK";
  public static final String DMP_ACTION_VIEW_CONTENT = "VIEW_CONTENT";
  private static final String TAG = "AdDMPReportUtil";
  
  private static JSONObject getActionParamsForDownload(Ad paramAd)
  {
    if ((paramAd != null) && (paramAd.isValid())) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("app_id", paramAd.getAppId());
        return localJSONObject;
      }
      catch (JSONException paramAd)
      {
        AdLog.e("AdDMPReportUtil", "getActionParamsForDownload", paramAd);
        return null;
      }
    }
    AdLog.e("AdDMPReportUtil", "getActionParamsForDownload error");
    return null;
  }
  
  private static boolean reportAppBtnClick(Ad paramAd)
  {
    paramAd = a.getRequestData(a.getRequestJson(paramAd, getActionParamsForDownload(paramAd), "CUSTOM", "DOWNLOAD_CLICK", "https://fv.gdt.qq.com"));
    if ((paramAd != null) && (paramAd.length > 0))
    {
      int i = 0;
      while (i < 3)
      {
        AdHttp.Params localParams = a.getRequestParams(paramAd);
        AdHttp.send(localParams);
        if ((localParams != null) && (localParams.isSuccess()))
        {
          AdLog.i("AdDMPReportUtil", "reportAppBtnClick success");
          return true;
        }
        AdLog.e("AdDMPReportUtil", "reportAppBtnClick error");
        i += 1;
      }
      return false;
    }
    AdLog.e("AdDMPReportUtil", "reportAppBtnClick error");
    return false;
  }
  
  public static void reportAppBtnClickAsync(Ad paramAd)
  {
    AdThreadManager.INSTANCE.post(new b.2(paramAd), 4);
  }
  
  private static boolean reportLoad(Ad paramAd, boolean paramBoolean)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("auto_download", paramBoolean);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramAd = a.getRequestData(a.getRequestJson(paramAd, (JSONObject)localObject, "VIEW_CONTENT", null, "https://fv.gdt.qq.com"));
    if ((paramAd != null) && (paramAd.length > 0))
    {
      int i = 0;
      while (i < 3)
      {
        localObject = a.getRequestParams(paramAd);
        AdHttp.send((AdHttp.Params)localObject);
        if ((localObject != null) && (((AdHttp.Params)localObject).isSuccess())) {
          return true;
        }
        AdLog.e("AdDMPReportUtil", "reportLoad error");
        i += 1;
      }
      return false;
    }
    AdLog.e("AdDMPReportUtil", "reportLoad error");
    return false;
  }
  
  public static void reportLoadAsync(Ad paramAd, boolean paramBoolean)
  {
    AdThreadManager.INSTANCE.post(new b.1(paramAd, paramBoolean), 4);
  }
  
  private static boolean reportOpenWebPage(Ad paramAd)
  {
    if (paramAd != null)
    {
      if (TextUtils.isEmpty(paramAd.getCanvas())) {
        return false;
      }
      Object localObject1 = new JSONObject();
      try
      {
        Object localObject2 = new JSONObject(paramAd.getCanvas()).getJSONObject("content").getJSONObject("pageConfig");
        String str = ((JSONObject)localObject2).getString("pageId");
        localObject2 = ((JSONObject)localObject2).getString("pageUrl");
        if (!TextUtils.isEmpty(str))
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            return false;
          }
          ((JSONObject)localObject1).put("object", "product");
          ((JSONObject)localObject1).put("page_id", str);
          ((JSONObject)localObject1).put("page_url", localObject2);
        }
        else
        {
          return false;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        paramAd = a.getRequestData(a.getRequestJson(paramAd, (JSONObject)localObject1, "VIEW_CONTENT", null, null));
        if ((paramAd != null) && (paramAd.length > 0))
        {
          int i = 0;
          while (i < 3)
          {
            localObject1 = a.getRequestParams(paramAd);
            AdHttp.send((AdHttp.Params)localObject1);
            if ((localObject1 != null) && (((AdHttp.Params)localObject1).isSuccess())) {
              return true;
            }
            AdLog.e("AdDMPReportUtil", "reportOpenWebPage error");
            i += 1;
          }
          return false;
        }
        AdLog.e("AdDMPReportUtil", "reportOpenWebPage error");
      }
    }
    return false;
  }
  
  public static void reportOpenWebPageAsync(Ad paramAd)
  {
    AdThreadManager.INSTANCE.post(new b.3(paramAd), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.canvas.b
 * JD-Core Version:    0.7.0.1
 */