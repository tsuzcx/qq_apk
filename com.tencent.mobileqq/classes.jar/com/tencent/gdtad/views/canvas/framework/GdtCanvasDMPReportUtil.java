package com.tencent.gdtad.views.canvas.framework;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.net.GdtHttp.Params;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormTableData;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qme;

public class GdtCanvasDMPReportUtil
{
  private static GdtHttp.Params a(byte[] paramArrayOfByte)
  {
    GdtHttp.Params localParams = new GdtHttp.Params();
    localParams.a("https://h5.gdt.qq.com/pageviewer/actionset/report");
    localParams.jdField_a_of_type_JavaLangString = "POST";
    localParams.jdField_b_of_type_JavaLangString = "application/json";
    localParams.c = "http://fv.gdt.qq.com";
    localParams.jdField_a_of_type_Int = 5000;
    localParams.jdField_b_of_type_Int = 5000;
    localParams.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    return localParams;
  }
  
  public static GdtCanvasFormError a(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    paramGdtCanvasFormComponentData = a(paramGdtCanvasFormComponentData);
    paramGdtCanvasData = a(paramGdtCanvasData, paramGdtCanvasFormComponentData, "RESERVATION", "http://fv.gdt.qq.com");
    if ((paramGdtCanvasFormComponentData == null) || (paramGdtCanvasFormComponentData == JSONObject.NULL) || (paramGdtCanvasData == null) || (paramGdtCanvasData.length <= 0))
    {
      GdtLog.d("GdtCanvasFormDMPReportUtil", "reportUpload error");
      return new GdtCanvasFormError(4, -1, null);
    }
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        paramGdtCanvasFormComponentData = a(paramGdtCanvasData);
        if (paramGdtCanvasFormComponentData != null) {}
      }
      else
      {
        GdtLog.d("GdtCanvasFormDMPReportUtil", "reportUpload error");
        return new GdtCanvasFormError(4, -1, null);
      }
      GdtHttp.a(paramGdtCanvasFormComponentData);
      if (paramGdtCanvasFormComponentData.b()) {
        return new GdtCanvasFormError(1, -1, null);
      }
      try
      {
        Thread.sleep(1000L);
        i += 1;
      }
      catch (InterruptedException paramGdtCanvasFormComponentData)
      {
        for (;;)
        {
          GdtLog.d("GdtCanvasFormDMPReportUtil", "reportUpload", paramGdtCanvasFormComponentData);
        }
      }
    }
  }
  
  private static JSONObject a(GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    if ((paramGdtCanvasFormComponentData == null) || (!paramGdtCanvasFormComponentData.isValid()))
    {
      GdtLog.d("GdtCanvasFormDMPReportUtil", "getActionParamsForUpload error");
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        localJSONObject = new JSONObject();
        i = 0;
        if (i < paramGdtCanvasFormComponentData.table.getSize())
        {
          GdtCanvasFormItemData localGdtCanvasFormItemData = paramGdtCanvasFormComponentData.table.getItem(i);
          if ((localGdtCanvasFormItemData == null) || (!localGdtCanvasFormItemData.isValid())) {
            GdtLog.d("GdtCanvasFormDMPReportUtil", "getActionParamsForUpload error");
          } else {
            localJSONObject.put(localGdtCanvasFormItemData.title.text, localGdtCanvasFormItemData.getResult());
          }
        }
      }
      catch (JSONException paramGdtCanvasFormComponentData)
      {
        GdtLog.d("GdtCanvasFormDMPReportUtil", "getActionParamsForUpload", paramGdtCanvasFormComponentData);
        return null;
      }
      paramGdtCanvasFormComponentData = new JSONObject();
      paramGdtCanvasFormComponentData.put("form_info", localJSONObject.toString());
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("custom_info", paramGdtCanvasFormComponentData.toString());
      return localJSONObject;
      i += 1;
    }
  }
  
  public static void a(GdtCanvasData paramGdtCanvasData)
  {
    ThreadManager.post(new qme(paramGdtCanvasData), 5, null, true);
  }
  
  private static byte[] a(GdtCanvasData paramGdtCanvasData, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()) || (paramGdtCanvasData.actionSetId == -2147483648L) || (paramGdtCanvasData.ad.advertiserId == -2147483648L) || (TextUtils.isEmpty(paramGdtCanvasData.ad.getTraceId())))
    {
      GdtLog.d("GdtCanvasFormDMPReportUtil", "getRequestData error");
      return null;
    }
    try
    {
      long l = System.currentTimeMillis() / 1000L;
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("click_id", paramGdtCanvasData.ad.getTraceId());
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action_time", l);
      localJSONObject1.put("action_type", paramString1);
      if ((paramJSONObject != null) && (paramJSONObject != JSONObject.NULL)) {
        localJSONObject1.put("action_param", paramJSONObject);
      }
      localJSONObject1.put("user_action_set_id", paramGdtCanvasData.actionSetId);
      localJSONObject1.put("url", paramString2);
      localJSONObject1.put("trace", localJSONObject2);
      paramJSONObject = new JSONArray();
      paramJSONObject.put(0, localJSONObject1);
      paramString1 = new JSONObject();
      paramString1.put("account_id", paramGdtCanvasData.ad.advertiserId);
      paramString1.put("actions", paramJSONObject);
      paramString1.put("signature", paramGdtCanvasData.ad.getTraceId() + l);
      paramGdtCanvasData = paramString1.toString().getBytes("UTF-8");
      return paramGdtCanvasData;
    }
    catch (JSONException paramGdtCanvasData)
    {
      GdtLog.d("GdtCanvasFormDMPReportUtil", "getRequestData", paramGdtCanvasData);
      return null;
    }
    catch (UnsupportedEncodingException paramGdtCanvasData)
    {
      GdtLog.d("GdtCanvasFormDMPReportUtil", "getRequestData", paramGdtCanvasData);
    }
    return null;
  }
  
  private static boolean b(GdtCanvasData paramGdtCanvasData)
  {
    paramGdtCanvasData = a(paramGdtCanvasData, null, "VIEW_CONTENT", "http://fv.gdt.qq.com");
    if ((paramGdtCanvasData == null) || (paramGdtCanvasData.length <= 0)) {
      GdtLog.d("GdtCanvasFormDMPReportUtil", "reportLoad error");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < 3)
      {
        GdtHttp.Params localParams = a(paramGdtCanvasData);
        GdtHttp.a(localParams);
        if ((localParams != null) && (localParams.b())) {
          return true;
        }
        GdtLog.d("GdtCanvasFormDMPReportUtil", "reportLoad error");
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasDMPReportUtil
 * JD-Core Version:    0.7.0.1
 */