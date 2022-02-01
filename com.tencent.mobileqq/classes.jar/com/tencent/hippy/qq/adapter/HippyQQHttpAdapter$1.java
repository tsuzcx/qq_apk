package com.tencent.hippy.qq.adapter;

import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import java.util.List;
import java.util.Map;

class HippyQQHttpAdapter$1
  implements IHttpAdapter.OnHttpListener
{
  HippyQQHttpAdapter$1(HippyQQHttpAdapter paramHippyQQHttpAdapter, Map paramMap, HippyHttpAdapter.HttpTaskCallback paramHttpTaskCallback, HippyHttpRequest paramHippyHttpRequest) {}
  
  public void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    if (paramMap != null) {
      this.val$mapHeadersReceived.putAll(paramMap);
    }
  }
  
  public void onHttpFinish(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = HippyQQHttpAdapter.access$000(this.this$0, paramHttpResponse, this.val$mapHeadersReceived);
    Object localObject = this.val$callback;
    if (localObject != null) {
      try
      {
        ((HippyHttpAdapter.HttpTaskCallback)localObject).onTaskSuccess(this.val$hippyHttpRequest, paramHttpResponse);
        return;
      }
      catch (Exception paramHttpResponse)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onHttpFinish e:");
        ((StringBuilder)localObject).append(paramHttpResponse);
        QLog.e("HippyQQHttpAdapter", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onHttpStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQHttpAdapter.1
 * JD-Core Version:    0.7.0.1
 */