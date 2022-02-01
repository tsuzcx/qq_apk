package com.tencent.mobileqq.app;

import MQQ.PayRuleCfg;
import java.util.HashMap;

final class VipInfoHandler$1
  implements Runnable
{
  VipInfoHandler$1(String paramString, PayRuleCfg paramPayRuleCfg) {}
  
  public void run()
  {
    synchronized ()
    {
      if (VipInfoHandler.b().get(this.a) != this.b) {
        return;
      }
      VipInfoHandler.a(this.a, "payRule.cfg", this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */