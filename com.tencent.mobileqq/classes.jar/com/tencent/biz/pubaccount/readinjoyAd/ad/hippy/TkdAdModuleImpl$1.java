package com.tencent.biz.pubaccount.readinjoyAd.ad.hippy;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.modules.Promise;

class TkdAdModuleImpl$1
  implements Runnable
{
  TkdAdModuleImpl$1(TkdAdModuleImpl paramTkdAdModuleImpl, String paramString, int paramInt, Promise paramPromise) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getApplication(), this.a, this.b).show();
    this.c.resolve("0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.1
 * JD-Core Version:    0.7.0.1
 */