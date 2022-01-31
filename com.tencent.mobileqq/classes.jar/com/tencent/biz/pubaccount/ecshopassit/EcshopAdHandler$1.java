package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import nfw;
import ypc;
import ypd;

public class EcshopAdHandler$1
  implements Runnable
{
  public EcshopAdHandler$1(nfw paramnfw) {}
  
  public void run()
  {
    MiniLog.init();
    ypc.a().a(BaseApplicationImpl.getApplication().getApplicationContext(), new ypd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.1
 * JD-Core Version:    0.7.0.1
 */