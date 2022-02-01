package com.tencent.hippy.qq.module;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.commons.HttpStatusText;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class HippyQQHttpModule$1
  implements HippyQQHttpModule.ResponseCallback
{
  HippyQQHttpModule$1(HippyQQHttpModule paramHippyQQHttpModule, Promise paramPromise) {}
  
  public void onResponse(HttpResponse paramHttpResponse, Map<String, String> paramMap)
  {
    int j = 0;
    if ((this.val$promise != null) && (this.val$promise.isCallback()))
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if ((paramHttpResponse == null) || ("-1".equals(paramHttpResponse.statusCode)))
        {
          localJSONObject.put("success", 0);
          localJSONObject.put("errorText", "ERR_CONNECT_FAILED");
        }
        for (;;)
        {
          paramHttpResponse = new HippyMap();
          paramHttpResponse.pushJSONObject(localJSONObject);
          this.val$promise.resolve(paramHttpResponse);
          return;
          int k = Integer.parseInt(paramHttpResponse.statusCode);
          localJSONObject.put("code", k);
          int i = j;
          if (k >= 200)
          {
            i = j;
            if (k <= 299) {
              i = 1;
            }
          }
          localJSONObject.put("success", i);
          if (paramHttpResponse.originalData != null) {
            break;
          }
          localJSONObject.put("data", null);
          localJSONObject.put("errorText", HttpStatusText.getStatusText(paramHttpResponse.statusCode));
        }
        arrayOfByte = paramHttpResponse.originalData;
      }
      catch (JSONException paramHttpResponse)
      {
        ViolaLogUtils.e(HippyQQHttpModule.TAG, "JSONException e:" + paramHttpResponse.getMessage());
        return;
      }
      byte[] arrayOfByte;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule.1
 * JD-Core Version:    0.7.0.1
 */