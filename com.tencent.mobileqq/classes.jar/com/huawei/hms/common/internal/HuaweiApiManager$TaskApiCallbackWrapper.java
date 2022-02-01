package com.huawei.hms.common.internal;

class HuaweiApiManager$TaskApiCallbackWrapper
{
  private final TaskApiCallWrapper mApiCallWrapper;
  private final AnyClient.CallBack mCallBack;
  
  HuaweiApiManager$TaskApiCallbackWrapper(TaskApiCallWrapper paramTaskApiCallWrapper, AnyClient.CallBack paramCallBack)
  {
    this.mApiCallWrapper = paramTaskApiCallWrapper;
    this.mCallBack = paramCallBack;
  }
  
  TaskApiCallWrapper getApiCallWrapper()
  {
    return this.mApiCallWrapper;
  }
  
  AnyClient.CallBack getCallBack()
  {
    return this.mCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager.TaskApiCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */