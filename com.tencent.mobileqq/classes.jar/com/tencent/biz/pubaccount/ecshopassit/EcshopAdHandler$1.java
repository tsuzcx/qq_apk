package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;

class EcshopAdHandler$1
  implements Runnable
{
  EcshopAdHandler$1(EcshopAdHandler paramEcshopAdHandler) {}
  
  public void run()
  {
    GdtManager.a().a(BaseApplicationImpl.getApplication().getApplicationContext(), new GdtManager.Params());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.1
 * JD-Core Version:    0.7.0.1
 */