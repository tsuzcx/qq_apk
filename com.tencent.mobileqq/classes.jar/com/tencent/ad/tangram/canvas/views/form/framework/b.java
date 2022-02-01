package com.tencent.ad.tangram.canvas.views.form.framework;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b
{
  private static final String TAG = "AdFormPrefetchTokenUtil";
  
  private static byte[] getRequestData(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = e.toJson(paramAdFormData);
    if ((!isValid(paramAd, paramAdFormData)) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      AdLog.e("AdFormPrefetchTokenUtil", "getRequestData error");
      return null;
    }
    paramContext = AdCanvasDataBuilderV2.build(paramContext, paramAd);
    long l;
    if (paramContext != null) {
      if (!paramContext.isValid()) {
        l = -2147483648L;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = new JSONObject();
        if (l != -2147483648L) {
          paramContext.put("pageId", l);
        }
        paramContext.put("traceId", paramAd.getTraceId());
        paramContext.put("formId", paramAdFormData.formId);
        paramContext.put("formValue", localJSONArray.toString());
        paramContext = paramContext.toString().getBytes("UTF-8");
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        AdLog.e("AdFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      l = paramContext.pageId;
      continue;
      l = -2147483648L;
    }
  }
  
  private static b.a getRequestParams(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    b.a locala = new b.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/getSaveTokenForNative");
    locala.method = "POST";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    locala.requestData = getRequestData(paramContext, paramAd, paramAdFormData);
    return locala;
  }
  
  private static boolean isValid(Ad paramAd, AdFormData paramAdFormData)
  {
    return (paramAd != null) && (paramAd.isValid()) && (!TextUtils.isEmpty(paramAd.getTraceId())) && (paramAdFormData != null) && (paramAdFormData.isValid()) && (!TextUtils.isEmpty(paramAd.getTraceId()));
  }
  
  private static void parseResponse(Ad paramAd, AdFormData paramAdFormData, b.a parama)
  {
    if ((parama == null) || (!parama.isSuccess()) || (!isValid(paramAd, paramAdFormData)))
    {
      AdLog.e("AdFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    try
    {
      paramAd = new JSONObject(new String(parama.responseData, "UTF-8"));
      parama.returnCode = paramAd.getInt("code");
      String str = paramAd.optString("message");
      AdLog.i("AdFormPrefetchTokenUtil", "onResponse code:" + parama.returnCode + " message:" + str);
      if (parama.returnCode == 0)
      {
        paramAdFormData.tokenForUpload = paramAd.getJSONObject("data").getString("token");
        return;
      }
    }
    catch (UnsupportedEncodingException paramAd)
    {
      AdLog.e("AdFormPrefetchTokenUtil", "onResponse", paramAd);
      return;
      AdLog.e("AdFormPrefetchTokenUtil", "onResponse error");
      return;
    }
    catch (JSONException paramAd)
    {
      AdLog.e("AdFormPrefetchTokenUtil", "onResponse", paramAd);
    }
  }
  
  public static void prefetch(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if (!isValid(paramAd, paramAdFormData))
    {
      AdLog.e("AdFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    for (;;)
    {
      b.a locala;
      if (i < 3)
      {
        if (!isValid(paramAd, paramAdFormData))
        {
          AdLog.e("AdFormPrefetchTokenUtil", "prefetch error");
          return;
        }
        locala = getRequestParams(paramContext, paramAd, paramAdFormData);
        if (locala != null) {}
      }
      else
      {
        AdLog.e("AdFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      AdHttp.send(locala);
      parseResponse(paramAd, paramAdFormData, locala);
      if ((locala.isSuccess()) && (locala.returnCode == 0)) {
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.b
 * JD-Core Version:    0.7.0.1
 */