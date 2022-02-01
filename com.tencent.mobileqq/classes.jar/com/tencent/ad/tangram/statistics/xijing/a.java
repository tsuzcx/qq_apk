package com.tencent.ad.tangram.statistics.xijing;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp.Params;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static final String DEST_URL = "https://fv.gdt.qq.com";
  private static final String DMP_REQUEST_CGI = "https://h5.gdt.qq.com/player/actionset/report?type=XJ_CANVAS";
  public static final int RETRY_TIMES_MAX = 3;
  private static final String TAG = "AdDMPReporterHelper";
  
  public static byte[] getRequestData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (JSONObject.NULL.equals(paramJSONObject)) {
        return null;
      }
      try
      {
        paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
        return paramJSONObject;
      }
      catch (UnsupportedEncodingException paramJSONObject)
      {
        AdLog.e("AdDMPReporterHelper", "getRequestData", paramJSONObject);
      }
    }
    return null;
  }
  
  public static JSONObject getRequestJson(Ad paramAd, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if ((paramAd != null) && (paramAd.isValid()) && (paramAd.getActionSetId() != -2147483648L) && (paramAd.getAdvertiserId() != -2147483648L) && (!TextUtils.isEmpty(paramAd.getTraceId()))) {
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
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramAd.getTraceId());
        paramJSONObject.append(l);
        paramString1.put("signature", paramJSONObject.toString());
        return paramString1;
      }
      catch (JSONException paramAd)
      {
        AdLog.e("AdDMPReporterHelper", "getRequestData", paramAd);
        return null;
      }
    }
    AdLog.e("AdDMPReporterHelper", "getRequestData error");
    return null;
  }
  
  public static AdHttp.Params getRequestParams(byte[] paramArrayOfByte)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.xijing.a
 * JD-Core Version:    0.7.0.1
 */