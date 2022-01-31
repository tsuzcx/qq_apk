package com.tencent.av.business.manager;

import ayrx;
import aysa;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class EffectConfigBase$NetReqRunnable
  implements Runnable
{
  final ayrx a;
  
  public EffectConfigBase$NetReqRunnable(EffectConfigBase paramEffectConfigBase, ayrx paramayrx)
  {
    this.a = paramayrx;
  }
  
  public void run()
  {
    try
    {
      if ((this.this$0.a != null) && (this.a != null)) {
        this.this$0.a.getNetEngine(0).a(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase.NetReqRunnable
 * JD-Core Version:    0.7.0.1
 */