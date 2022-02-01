package com.tencent.hippy.qq.module.tkd;

import aoki;
import com.tencent.qphone.base.remote.ToServiceMsg;

class TKDWupModule$1
  extends aoki
{
  TKDWupModule$1(TKDWupModule paramTKDWupModule) {}
  
  public void handleSearchHippyDiscoveryResult(ToServiceMsg paramToServiceMsg, Integer paramInteger, Object paramObject)
  {
    super.handleSearchHippyDiscoveryResult(paramToServiceMsg, paramInteger, paramObject);
    TKDWupModule.access$000(this.this$0).onWUPTaskSuccess(paramToServiceMsg, paramInteger.intValue(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDWupModule.1
 * JD-Core Version:    0.7.0.1
 */