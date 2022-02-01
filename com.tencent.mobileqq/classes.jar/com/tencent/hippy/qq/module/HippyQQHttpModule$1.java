package com.tencent.hippy.qq.module;

import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
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
    GamePubAccountHelper.a(this.val$request.url, System.currentTimeMillis());
    Object localObject = this.val$promise;
    if ((localObject != null) && (((Promise)localObject).isCallback())) {}
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        i = 1;
        localObject = "";
        if ((paramHttpResponse != null) && (!"-1".equals(paramHttpResponse.statusCode)))
        {
          int j = Integer.parseInt(paramHttpResponse.statusCode);
          localJSONObject.put("code", j);
          if ((j < 200) || (j > 299)) {
            break label403;
          }
          localJSONObject.put("success", i);
          byte[] arrayOfByte = paramHttpResponse.originalData;
          if (arrayOfByte == null)
          {
            localJSONObject.put("data", null);
          }
          else
          {
            arrayOfByte = paramHttpResponse.originalData;
            if (paramMap != null) {
              localObject = HippyQQHttpModule.getHeader(paramMap, "Content-Type");
            }
            paramMap = HippyQQHttpModule.readAsString(arrayOfByte, (String)localObject);
          }
        }
      }
      catch (JSONException paramHttpResponse)
      {
        JSONObject localJSONObject;
        paramMap = HippyQQHttpModule.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSONException e:");
        ((StringBuilder)localObject).append(paramHttpResponse.getMessage());
        ViolaLogUtils.e(paramMap, ((StringBuilder)localObject).toString());
      }
      try
      {
        localJSONObject.put("data", this.this$0.parseData(paramMap, "json"));
      }
      catch (JSONException paramMap)
      {
        continue;
      }
      localJSONObject.put("success", 0);
      localJSONObject.put("code", -1);
      localJSONObject.put("errorText", HttpStatusText.getStatusText(paramHttpResponse.statusCode));
      continue;
      localJSONObject.put("success", 0);
      localJSONObject.put("errorText", "ERR_CONNECT_FAILED");
      if (paramHttpResponse != null) {
        localObject = paramHttpResponse.errorMsg;
      }
      paramHttpResponse = HippyQQHttpModule.TAG;
      paramMap = new StringBuilder();
      paramMap.append("connect failed and msg is ");
      paramMap.append((String)localObject);
      QLog.e(paramHttpResponse, 1, paramMap.toString());
      paramHttpResponse = new HippyMap();
      GamePubAccountHelper.a(this.val$request.url, System.currentTimeMillis());
      paramMap = GamePubAccountHelper.a(this.val$request.url);
      if (paramMap != null) {
        localJSONObject.put("requestCostTime", paramMap);
      }
      paramHttpResponse.pushJSONObject(localJSONObject);
      this.val$promise.resolve(paramHttpResponse);
      GamePubAccountHelper.a(this.val$request.url);
      return;
      return;
      label403:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule.1
 * JD-Core Version:    0.7.0.1
 */