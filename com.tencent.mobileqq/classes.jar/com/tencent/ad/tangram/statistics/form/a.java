package com.tencent.ad.tangram.statistics.form;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.form.framework.d;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final String TAG = "AdReporterForDMPWithForm";
  
  private static JSONObject getActionParamsForUpload(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if ((paramAd != null) && (paramAd.isValid()) && (paramAdFormData != null) && (paramAdFormData.isValid())) {}
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
          if ((paramAd != null) && (paramAd.isValid()))
          {
            paramContext.put(paramAd.title.text, paramAd.getResult());
            break label200;
          }
          AdLog.e("AdReporterForDMPWithForm", "getActionParamsForUpload error");
          break label200;
        }
        paramAd = new JSONObject();
        paramAd.put("component_id", paramAdFormData.formId);
        paramAd.put("component_type", 1);
        paramAd.put("bundle", paramContext);
        paramAdFormData = new JSONObject();
        paramAdFormData.put("form_info", paramContext.toString());
        paramContext = new JSONObject();
        paramContext.put("custom_info", paramAdFormData.toString());
        paramContext.put("leads_standard_form_info", paramAd.toString());
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdReporterForDMPWithForm", "getActionParamsForUpload", paramContext);
        return null;
      }
      AdLog.e("AdReporterForDMPWithForm", "getActionParamsForUpload error");
      return null;
      label200:
      i += 1;
    }
  }
  
  public static AdFormError reportUpload(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    paramContext = getActionParamsForUpload(paramContext, paramAd, paramAdFormData);
    paramAd = com.tencent.ad.tangram.statistics.xijing.a.getRequestData(com.tencent.ad.tangram.statistics.xijing.a.getRequestJson(paramAd, paramContext, "RESERVATION", null, "https://fv.gdt.qq.com"));
    if ((paramContext != null) && (!JSONObject.NULL.equals(paramContext)) && (paramAd != null) && (paramAd.length > 0))
    {
      int i = 0;
      while (i < 3)
      {
        paramContext = com.tencent.ad.tangram.statistics.xijing.a.getRequestParams(paramAd);
        if (paramContext == null) {
          break;
        }
        AdHttp.send(paramContext);
        if (paramContext.isSuccess()) {
          return new AdFormError(1, -1, null);
        }
        i += 1;
      }
      AdLog.e("AdReporterForDMPWithForm", "reportUpload error");
      return new AdFormError(4, -1, null);
    }
    AdLog.e("AdReporterForDMPWithForm", "reportUpload error");
    return new AdFormError(4, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.form.a
 * JD-Core Version:    0.7.0.1
 */