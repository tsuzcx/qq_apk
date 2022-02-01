package com.tencent.hippy.qq.module;

import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HippyQQHttpModule$HttpListener
  implements IHttpAdapter.OnHttpListener
{
  private long mHttpStartTime;
  private Map<String, String> mRespHeaders;
  private Map<String, Object> mResponse = new HashMap();
  private HippyQQHttpModule.ResponseCallback mResponseCallback;
  
  public HippyQQHttpModule$HttpListener(HippyQQHttpModule paramHippyQQHttpModule, HippyQQHttpModule.ResponseCallback paramResponseCallback)
  {
    this.mResponseCallback = paramResponseCallback;
  }
  
  public void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    this.mResponse.put("readyState", Integer.valueOf(2));
    this.mResponse.put("status", Integer.valueOf(paramInt));
    HashMap localHashMap = new HashMap();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((List)localEntry.getValue()).size() > 0)
        {
          if (localEntry.getKey() == null) {
            paramMap = "_";
          } else {
            paramMap = (String)localEntry.getKey();
          }
          localHashMap.put(paramMap, ((List)localEntry.getValue()).get(0));
        }
      }
    }
    this.mResponse.put("headers", localHashMap);
    this.mRespHeaders = localHashMap;
  }
  
  public void onHttpFinish(HttpResponse paramHttpResponse)
  {
    HippyQQHttpModule.ResponseCallback localResponseCallback = this.mResponseCallback;
    if (localResponseCallback != null) {
      localResponseCallback.onResponse(paramHttpResponse, this.mRespHeaders);
    }
  }
  
  public void onHttpStart()
  {
    this.mHttpStartTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule.HttpListener
 * JD-Core Version:    0.7.0.1
 */