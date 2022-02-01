package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetTabsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;

class WSHomeFragmentPresenter$6
  implements IWeiShiCacheCallback
{
  WSHomeFragmentPresenter$6(WSHomeFragmentPresenter paramWSHomeFragmentPresenter) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if ((paramJceStruct instanceof stGetTabsRsp)) {}
    for (paramJceStruct = (stGetTabsRsp)paramJceStruct;; paramJceStruct = null)
    {
      if (this.a.a() != null) {
        ((IWSHomeView)this.a.a()).a(paramJceStruct);
      }
      WSHomeFragmentPresenter.a(this.a, paramJceStruct);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.6
 * JD-Core Version:    0.7.0.1
 */