package com.tencent.hippy.qq.module;

import com.tencent.viola.adapter.HttpResponse;
import java.util.Map;

abstract interface HippyQQHttpModule$ResponseCallback
{
  public abstract void onResponse(HttpResponse paramHttpResponse, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule.ResponseCallback
 * JD-Core Version:    0.7.0.1
 */