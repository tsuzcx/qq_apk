package com.tencent.mobileqq.app;

import MQQ.PayRuleCfg;
import amfs;
import java.util.HashMap;

public final class VipInfoHandler$1
  implements Runnable
{
  public VipInfoHandler$1(String paramString, PayRuleCfg paramPayRuleCfg) {}
  
  public void run()
  {
    synchronized ()
    {
      if (amfs.a().get(this.jdField_a_of_type_JavaLangString) != this.jdField_a_of_type_MQQPayRuleCfg) {
        return;
      }
      amfs.a(this.jdField_a_of_type_JavaLangString, "payRule.cfg", this.jdField_a_of_type_MQQPayRuleCfg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */