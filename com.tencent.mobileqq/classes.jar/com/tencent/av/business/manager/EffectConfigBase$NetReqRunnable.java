package com.tencent.av.business.manager;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;

class EffectConfigBase$NetReqRunnable
  implements Runnable
{
  final HttpNetReq a;
  
  public EffectConfigBase$NetReqRunnable(EffectConfigBase paramEffectConfigBase, HttpNetReq paramHttpNetReq)
  {
    this.a = paramHttpNetReq;
  }
  
  public void run()
  {
    try
    {
      if ((this.this$0.c != null) && (this.a != null))
      {
        ((IHttpEngineService)this.this$0.c.getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.a);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase.NetReqRunnable
 * JD-Core Version:    0.7.0.1
 */