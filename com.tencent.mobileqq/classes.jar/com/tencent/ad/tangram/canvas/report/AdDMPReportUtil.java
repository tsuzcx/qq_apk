package com.tencent.ad.tangram.canvas.report;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class AdDMPReportUtil
{
  public static final String DEST_URL = "https://fv.gdt.qq.com";
  public static final String DMP_ACTION_DOWNLOAD_CLICK = "DOWNLOAD_CLICK";
  public static final String DMP_ACTION_VIEW_CONTENT = "VIEW_CONTENT";
  public static final String DMP_REQUEST_CGI = "https://h5.gdt.qq.com/player/actionset/report?type=XJ_CANVAS";
  private static final int RETRY_TIMES_MAX = 3;
  private static final String TAG = "AdDMPReportUtil";
  
  private static JSONObject getActionParamsForDownload(Ad paramAd)
  {
    if ((paramAd == null) || (!paramAd.isValid()))
    {
      AdLog.e("AdDMPReportUtil", "getActionParamsForDownload error");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("app_id", paramAd.getAppId());
      return localJSONObject;
    }
    catch (JSONException paramAd)
    {
      AdLog.e("AdDMPReportUtil", "getActionParamsForDownload", paramAd);
    }
    return null;
  }
  
  private static JSONObject getActionParamsForUpload(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if ((paramAd == null) || (!paramAd.isValid()) || (paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      AdLog.e("AdDMPReportUtil", "getActionParamsForUpload error");
      return null;
    }
    AdCanvasData localAdCanvasData = AdCanvasDataBuilderV2.build(paramContext, paramAd);
    for (;;)
    {
      int i;
      try
      {
        paramContext = new JSONObject();
        i = 0;
        if (i < paramAdFormData.getSize())
        {
          paramAd = paramAdFormData.getItem(i);
          if ((paramAd == null) || (!paramAd.isValid())) {
            AdLog.e("AdDMPReportUtil", "getActionParamsForUpload error");
          } else {
            paramContext.put(paramAd.title.text, paramAd.getResult());
          }
        }
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdDMPReportUtil", "getActionParamsForUpload", paramContext);
        return null;
      }
      paramAd = new JSONObject();
      paramAd.put("component_id", paramAdFormData.formId);
      paramAd.put("component_type", 1);
      paramAd.put("bundle", paramContext);
      if (localAdCanvasData != null)
      {
        if (!TextUtils.isEmpty(localAdCanvasData.commonPageId)) {
          paramAd.put("common_page_id", localAdCanvasData.commonPageId);
        }
        if (!TextUtils.isEmpty(localAdCanvasData.name)) {
          paramAd.put("page_name", localAdCanvasData.name);
        }
        if (localAdCanvasData.pageId != -2147483648L) {
          paramAd.put("page_id", localAdCanvasData.pageId);
        }
        if (!TextUtils.isEmpty(localAdCanvasData.pageType)) {
          paramAd.put("page_type", localAdCanvasData.pageType);
        }
        if (!TextUtils.isEmpty(localAdCanvasData.pageUrl)) {
          paramAd.put("page_url", localAdCanvasData.pageUrl);
        }
      }
      paramAdFormData = new JSONObject();
      paramAdFormData.put("form_info", paramContext.toString());
      paramContext = new JSONObject();
      paramContext.put("custom_info", paramAdFormData.toString());
      paramContext.put("leads_standard_form_info", paramAd.toString());
      return paramContext;
      i += 1;
    }
  }
  
  public static byte[] getRequestData(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject))) {
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
      return paramJSONObject;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      AdLog.e("AdDMPReportUtil", "getRequestData", paramJSONObject);
    }
    return null;
  }
  
  public static JSONObject getRequestJson(Ad paramAd, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if ((paramAd == null) || (!paramAd.isValid()) || (paramAd.getActionSetId() == -2147483648L) || (paramAd.getAdvertiserId() == -2147483648L) || (TextUtils.isEmpty(paramAd.getTraceId())))
    {
      AdLog.e("AdDMPReportUtil", "getRequestData error");
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("click_id", paramAd.getTraceId());
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action_time", l / 1000L);
      localJSONObject1.put("action_type", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject1.put("custom_action", paramString2);
      }
      if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject))) {
        localJSONObject1.put("action_param", paramJSONObject);
      }
      localJSONObject1.put("user_action_set_id", paramAd.getActionSetId());
      localJSONObject1.put("url", paramString3);
      localJSONObject1.put("trace", localJSONObject2);
      paramJSONObject = new JSONArray();
      paramJSONObject.put(0, localJSONObject1);
      paramString1 = new JSONObject();
      paramString1.put("account_id", paramAd.getAdvertiserId());
      paramString1.put("actions", paramJSONObject);
      paramString1.put("signature", paramAd.getTraceId() + l);
      return paramString1;
    }
    catch (JSONException paramAd)
    {
      AdLog.e("AdDMPReportUtil", "getRequestData", paramAd);
    }
    return null;
  }
  
  private static AdHttp.Params getRequestParams(byte[] paramArrayOfByte)
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://h5.gdt.qq.com/player/actionset/report?type=XJ_CANVAS");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.referer = "https://fv.gdt.qq.com";
    localParams.connectTimeoutMillis = 5000;
    localParams.readTimeoutMillis = 5000;
    localParams.requestData = paramArrayOfByte;
    return localParams;
  }
  
  private static boolean reportAppBtnClick(Ad paramAd)
  {
    paramAd = getRequestData(getRequestJson(paramAd, getActionParamsForDownload(paramAd), "CUSTOM", "DOWNLOAD_CLICK", "https://fv.gdt.qq.com"));
    if ((paramAd == null) || (paramAd.length <= 0)) {
      AdLog.e("AdDMPReportUtil", "reportAppBtnClick error");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < 3)
      {
        AdHttp.Params localParams = getRequestParams(paramAd);
        AdHttp.send(localParams);
        if ((localParams != null) && (localParams.isSuccess()))
        {
          AdLog.i("AdDMPReportUtil", "reportAppBtnClick success");
          return true;
        }
        AdLog.e("AdDMPReportUtil", "reportAppBtnClick error");
        i += 1;
      }
    }
  }
  
  public static void reportAppBtnClickAsync(Ad paramAd)
  {
    AdThreadManager.INSTANCE.post(new AdDMPReportUtil.2(paramAd), 4);
  }
  
  private static boolean reportLoad(Ad paramAd, boolean paramBoolean)
  {
    Object localObject = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        ((JSONObject)localObject).put("auto_download", paramBoolean);
        paramAd = getRequestData(getRequestJson(paramAd, (JSONObject)localObject, "VIEW_CONTENT", null, "https://fv.gdt.qq.com"));
        if ((paramAd == null) || (paramAd.length <= 0))
        {
          AdLog.e("AdDMPReportUtil", "reportLoad error");
          return false;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        i = 0;
      }
      while (i < 3)
      {
        localObject = getRequestParams(paramAd);
        AdHttp.send((AdHttp.Params)localObject);
        if ((localObject != null) && (((AdHttp.Params)localObject).isSuccess())) {
          return true;
        }
        AdLog.e("AdDMPReportUtil", "reportLoad error");
        i += 1;
      }
    }
  }
  
  public static void reportLoadAsync(Ad paramAd, boolean paramBoolean)
  {
    AdThreadManager.INSTANCE.post(new AdDMPReportUtil.1(paramAd, paramBoolean), 4);
  }
  
  private static boolean reportOpenWebPage(Ad paramAd)
  {
    if ((paramAd == null) || (TextUtils.isEmpty(paramAd.getCanvas()))) {}
    for (;;)
    {
      return false;
      Object localObject1 = new JSONObject();
      int i;
      try
      {
        Object localObject2 = new JSONObject(paramAd.getCanvas()).getJSONObject("content").getJSONObject("pageConfig");
        String str = ((JSONObject)localObject2).getString("pageId");
        localObject2 = ((JSONObject)localObject2).getString("pageUrl");
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          continue;
        }
        ((JSONObject)localObject1).put("object", "product");
        ((JSONObject)localObject1).put("page_id", str);
        ((JSONObject)localObject1).put("page_url", localObject2);
        paramAd = getRequestData(getRequestJson(paramAd, (JSONObject)localObject1, "VIEW_CONTENT", null, null));
        if ((paramAd == null) || (paramAd.length <= 0))
        {
          AdLog.e("AdDMPReportUtil", "reportOpenWebPage error");
          return false;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        i = 0;
      }
      while (i < 3)
      {
        localObject1 = getRequestParams(paramAd);
        AdHttp.send((AdHttp.Params)localObject1);
        if ((localObject1 != null) && (((AdHttp.Params)localObject1).isSuccess())) {
          return true;
        }
        AdLog.e("AdDMPReportUtil", "reportOpenWebPage error");
        i += 1;
      }
    }
  }
  
  public static void reportOpenWebPageAsync(Ad paramAd)
  {
    AdThreadManager.INSTANCE.post(new AdDMPReportUtil.3(paramAd), 4);
  }
  
  public static AdFormError reportUpload(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    paramContext = getActionParamsForUpload(paramContext, paramAd, paramAdFormData);
    paramAd = getRequestData(getRequestJson(paramAd, paramContext, "RESERVATION", null, "https://fv.gdt.qq.com"));
    if ((paramContext == null) || (JSONObject.NULL.equals(paramContext)) || (paramAd == null) || (paramAd.length <= 0))
    {
      AdLog.e("AdDMPReportUtil", "reportUpload error");
      return new AdFormError(4, -1, null);
    }
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        paramContext = getRequestParams(paramAd);
        if (paramContext != null) {}
      }
      else
      {
        AdLog.e("AdDMPReportUtil", "reportUpload error");
        return new AdFormError(4, -1, null);
      }
      AdHttp.send(paramContext);
      if (paramContext.isSuccess()) {
        return new AdFormError(1, -1, null);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.report.AdDMPReportUtil
 * JD-Core Version:    0.7.0.1
 */