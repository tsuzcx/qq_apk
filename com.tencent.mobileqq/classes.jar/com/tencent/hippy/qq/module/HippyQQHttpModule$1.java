package com.tencent.hippy.qq.module;

import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.commons.HttpStatusText;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class HippyQQHttpModule$1
  implements HippyQQHttpModule.ResponseCallback
{
  HippyQQHttpModule$1(HippyQQHttpModule paramHippyQQHttpModule, HttpRequset paramHttpRequset, Promise paramPromise) {}
  
  public void onResponse(HttpResponse paramHttpResponse, Map<String, String> paramMap)
  {
    int i = 1;
    QQGameHelper.a(this.val$request.url, System.currentTimeMillis());
    if ((this.val$promise != null) && (this.val$promise.isCallback()))
    {
      JSONObject localJSONObject;
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          if ((paramHttpResponse == null) || ("-1".equals(paramHttpResponse.statusCode)))
          {
            localJSONObject.put("success", 0);
            localJSONObject.put("errorText", "ERR_CONNECT_FAILED");
            paramMap = "";
            if (paramHttpResponse != null) {
              paramMap = paramHttpResponse.errorMsg;
            }
            QLog.e(HippyQQHttpModule.TAG, 1, "connect failed and msg is " + paramMap);
            paramHttpResponse = new HippyMap();
            QQGameHelper.a(this.val$request.url, System.currentTimeMillis());
            paramMap = QQGameHelper.a(this.val$request.url);
            if (paramMap != null) {
              localJSONObject.put("requestCostTime", paramMap);
            }
            paramHttpResponse.pushJSONObject(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.d("wenttt", 1, "retMap=" + paramHttpResponse.toString());
            }
            this.val$promise.resolve(paramHttpResponse);
            QQGameHelper.a(this.val$request.url);
            return;
          }
          int j = Integer.parseInt(paramHttpResponse.statusCode);
          localJSONObject.put("code", j);
          if ((j >= 200) && (j <= 299))
          {
            localJSONObject.put("success", i);
            if (paramHttpResponse.originalData != null) {
              break;
            }
            localJSONObject.put("data", null);
            localJSONObject.put("errorText", HttpStatusText.getStatusText(paramHttpResponse.statusCode));
          }
          else
          {
            i = 0;
          }
        }
        catch (JSONException paramHttpResponse)
        {
          ViolaLogUtils.e(HippyQQHttpModule.TAG, "JSONException e:" + paramHttpResponse.getMessage());
          return;
        }
      }
      byte[] arrayOfByte = paramHttpResponse.originalData;
      if (paramMap != null) {}
      for (paramMap = HippyQQHttpModule.getHeader(paramMap, "Content-Type");; paramMap = "")
      {
        for (;;)
        {
          paramMap = HippyQQHttpModule.readAsString(arrayOfByte, paramMap);
          try
          {
            localJSONObject.put("data", this.this$0.parseData(paramMap, "json"));
          }
          catch (JSONException paramMap)
          {
            localJSONObject.put("success", 0);
            localJSONObject.put("code", -1);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule.1
 * JD-Core Version:    0.7.0.1
 */