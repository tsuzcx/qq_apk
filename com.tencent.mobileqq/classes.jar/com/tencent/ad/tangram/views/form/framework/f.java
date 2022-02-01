package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.views.form.AdFormData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class f
{
  private static final String TAG = "AdFormPrefetchTokenUtil";
  
  private static byte[] getRequestData(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    paramContext = j.toJson(paramAdFormData);
    if ((isValid(paramAd, paramAdFormData)) && (paramContext != null) && (!JSONObject.NULL.equals(paramContext))) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("traceId", paramAd.getTraceId());
        localJSONObject.put("formId", paramAdFormData.formId);
        localJSONObject.put("formValue", paramContext.toString());
        paramContext = localJSONObject.toString().getBytes("UTF-8");
        return paramContext;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        AdLog.e("AdFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdFormPrefetchTokenUtil", "getRequestData", paramContext);
        return null;
      }
    }
    AdLog.e("AdFormPrefetchTokenUtil", "getRequestData error");
    return null;
  }
  
  private static f.a getRequestParams(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    f.a locala = new f.a(null);
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
  
  private static void parseResponse(Ad paramAd, AdFormData paramAdFormData, f.a parama)
  {
    if ((parama != null) && (parama.isSuccess()) && (isValid(paramAd, paramAdFormData))) {
      try
      {
        paramAd = new JSONObject(new String(parama.responseData, "UTF-8"));
        parama.returnCode = paramAd.getInt("code");
        String str = paramAd.optString("message");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResponse code:");
        localStringBuilder.append(parama.returnCode);
        localStringBuilder.append(" message:");
        localStringBuilder.append(str);
        AdLog.i("AdFormPrefetchTokenUtil", localStringBuilder.toString());
        if (parama.returnCode == 0)
        {
          paramAdFormData.tokenForUpload = paramAd.getJSONObject("data").getString("token");
          return;
        }
        AdLog.e("AdFormPrefetchTokenUtil", "onResponse error");
        return;
      }
      catch (JSONException paramAd)
      {
        AdLog.e("AdFormPrefetchTokenUtil", "onResponse", paramAd);
        return;
      }
      catch (UnsupportedEncodingException paramAd)
      {
        AdLog.e("AdFormPrefetchTokenUtil", "onResponse", paramAd);
        return;
      }
    }
    AdLog.e("AdFormPrefetchTokenUtil", "onResponse error");
  }
  
  public static void prefetch(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if (!isValid(paramAd, paramAdFormData))
    {
      AdLog.e("AdFormPrefetchTokenUtil", "prefetch error");
      return;
    }
    int i = 0;
    while (i < 3)
    {
      if (!isValid(paramAd, paramAdFormData))
      {
        AdLog.e("AdFormPrefetchTokenUtil", "prefetch error");
        return;
      }
      f.a locala = getRequestParams(paramContext, paramAd, paramAdFormData);
      if (locala == null) {
        break;
      }
      AdHttp.send(locala);
      parseResponse(paramAd, paramAdFormData, locala);
      if ((locala.isSuccess()) && (locala.returnCode == 0)) {
        return;
      }
      i += 1;
    }
    AdLog.e("AdFormPrefetchTokenUtil", "prefetch error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.f
 * JD-Core Version:    0.7.0.1
 */