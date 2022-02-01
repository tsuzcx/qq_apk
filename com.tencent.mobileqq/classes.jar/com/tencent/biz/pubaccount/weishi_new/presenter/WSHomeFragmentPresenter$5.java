package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetTabsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;

class WSHomeFragmentPresenter$5
  implements IWeiShiCacheCallback
{
  WSHomeFragmentPresenter$5(WSHomeFragmentPresenter paramWSHomeFragmentPresenter) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if ((paramJceStruct instanceof stGetTabsRsp)) {
      paramJceStruct = (stGetTabsRsp)paramJceStruct;
    } else {
      paramJceStruct = null;
    }
    if (this.a.a() != null) {
      ((IWSHomeView)this.a.a()).a(paramJceStruct);
    }
    WSHomeFragmentPresenter.a(this.a, paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.5
 * JD-Core Version:    0.7.0.1
 */