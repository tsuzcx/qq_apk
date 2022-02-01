package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.mobileqq.kandian.biz.viola.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HippyQQHttpAdapter
  implements HippyHttpAdapter
{
  private static final int HTTP_STATUS_CODE_OK = 200;
  private static final String TAG = "HippyQQHttpAdapter";
  IHttpAdapter mHttpAdapter = ((IBaseHttpAdapterFactory)QRoute.api(IBaseHttpAdapterFactory.class)).create();
  
  private boolean rspFromOffinePackage(HippyHttpRequest paramHippyHttpRequest, HippyHttpAdapter.HttpTaskCallback paramHttpTaskCallback, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    try
    {
      HippyHttpResponse localHippyHttpResponse = new HippyHttpResponse();
      localHippyHttpResponse.setStatusCode(Integer.valueOf(200));
      localHippyHttpResponse.setResponseMessage("OK from cache");
      localHippyHttpResponse.setInputStream(new FileInputStream(paramString));
      if (paramHttpTaskCallback != null) {
        paramHttpTaskCallback.onTaskSuccess(paramHippyHttpRequest, localHippyHttpResponse);
      }
      return true;
    }
    catch (Throwable paramHippyHttpRequest)
    {
      paramHttpTaskCallback = new StringBuilder();
      paramHttpTaskCallback.append("convertToHippyHttpResponse e:");
      paramHttpTaskCallback.append(paramHippyHttpRequest);
      QLog.e("HippyQQHttpAdapter", 1, paramHttpTaskCallback.toString());
    }
    return false;
  }
  
  private HippyHttpResponse toHippyHttpResponse(HttpResponse paramHttpResponse, Map<String, List<String>> paramMap)
  {
    try
    {
      HippyHttpResponse localHippyHttpResponse = new HippyHttpResponse();
      if (paramHttpResponse != null)
      {
        localHippyHttpResponse.setStatusCode(Integer.valueOf(paramHttpResponse.statusCode));
        localHippyHttpResponse.setRspHeaderMap(paramMap);
        if (paramHttpResponse.originalData != null) {
          localHippyHttpResponse.setInputStream(new ByteArrayInputStream(paramHttpResponse.originalData));
        }
      }
      return localHippyHttpResponse;
    }
    catch (Throwable paramHttpResponse)
    {
      paramMap = new StringBuilder();
      paramMap.append("convertToHippyHttpResponse e:");
      paramMap.append(paramHttpResponse);
      QLog.e("HippyQQHttpAdapter", 1, paramMap.toString());
    }
    return null;
  }
  
  private HttpRequset toViolaHttpRequest(HippyHttpRequest paramHippyHttpRequest)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.paramMap = new HashMap();
    localHttpRequset.url = paramHippyHttpRequest.getUrl();
    localHttpRequset.method = paramHippyHttpRequest.getMethod();
    localHttpRequset.body = paramHippyHttpRequest.getBody();
    localHttpRequset.timeoutMs = (paramHippyHttpRequest.getConnectTimeout() + paramHippyHttpRequest.getReadTimeout());
    if (paramHippyHttpRequest.getHeaders() != null)
    {
      paramHippyHttpRequest = paramHippyHttpRequest.getHeaders().entrySet().iterator();
      while (paramHippyHttpRequest.hasNext())
      {
        Object localObject = (Map.Entry)paramHippyHttpRequest.next();
        String str = (String)((Map.Entry)localObject).getKey();
        if (!TextUtils.isEmpty(str))
        {
          localObject = ((Map.Entry)localObject).getValue();
          if ((localObject instanceof String))
          {
            localHttpRequset.paramMap.put(str, (String)localObject);
          }
          else if ((localObject instanceof List))
          {
            localObject = (List)localObject;
            if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {
              localHttpRequset.paramMap.put(str, ((List)localObject).get(0).toString());
            }
          }
        }
      }
    }
    return localHttpRequset;
  }
  
  public void destroyIfNeed() {}
  
  public void sendRequest(HippyHttpRequest paramHippyHttpRequest, HippyHttpAdapter.HttpTaskCallback paramHttpTaskCallback)
  {
    if (paramHippyHttpRequest == null) {
      return;
    }
    if (rspFromOffinePackage(paramHippyHttpRequest, paramHttpTaskCallback, HippyOfflineAssist.getOfflineResPath(paramHippyHttpRequest.getUrl()))) {
      return;
    }
    HttpRequset localHttpRequset = toViolaHttpRequest(paramHippyHttpRequest);
    HashMap localHashMap = new HashMap();
    this.mHttpAdapter.sendRequest(localHttpRequset, new HippyQQHttpAdapter.1(this, localHashMap, paramHttpTaskCallback, paramHippyHttpRequest), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQHttpAdapter
 * JD-Core Version:    0.7.0.1
 */