package com.huawei.hms.common.internal;

import com.huawei.hms.common.HuaweiApi;

class HandlerMessageWrapper
{
  final HuaweiApi<?> mApi;
  final BaseContentWrapper mContentWrapper;
  
  public HandlerMessageWrapper(BaseContentWrapper paramBaseContentWrapper, int paramInt, HuaweiApi<?> paramHuaweiApi)
  {
    this.mContentWrapper = paramBaseContentWrapper;
    this.mApi = paramHuaweiApi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HandlerMessageWrapper
 * JD-Core Version:    0.7.0.1
 */