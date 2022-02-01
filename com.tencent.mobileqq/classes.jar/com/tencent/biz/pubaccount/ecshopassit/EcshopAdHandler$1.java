package com.tencent.biz.pubaccount.ecshopassit;

import acsb;
import acsc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import odh;

public class EcshopAdHandler$1
  implements Runnable
{
  public EcshopAdHandler$1(odh paramodh) {}
  
  public void run()
  {
    MiniLog.init();
    acsb.a().a(BaseApplicationImpl.getApplication().getApplicationContext(), new acsc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.1
 * JD-Core Version:    0.7.0.1
 */