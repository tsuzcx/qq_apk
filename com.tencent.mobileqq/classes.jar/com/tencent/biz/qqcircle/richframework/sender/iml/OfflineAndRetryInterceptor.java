package com.tencent.biz.qqcircle.richframework.sender.iml;

import android.os.Handler;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

public class OfflineAndRetryInterceptor
  implements ReqInterceptor
{
  private boolean a;
  
  public void a(Object paramObject, SenderChain paramSenderChain)
  {
    if (paramObject != null)
    {
      if (paramSenderChain == null) {
        return;
      }
      if (!HostNetworkUtils.isNetworkAvailable())
      {
        if (this.a) {
          RFThreadManager.getUIHandler().post(new OfflineAndRetryInterceptor.1(this));
        }
      }
      else {
        paramSenderChain.a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.OfflineAndRetryInterceptor
 * JD-Core Version:    0.7.0.1
 */