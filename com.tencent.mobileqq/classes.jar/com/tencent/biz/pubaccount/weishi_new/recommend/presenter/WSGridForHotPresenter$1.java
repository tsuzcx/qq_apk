package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import UserGrowth.stGetFollowedDramasRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSGridForHotPresenter$1
  implements IWeiShiCacheCallback
{
  WSGridForHotPresenter$1(WSGridForHotPresenter paramWSGridForHotPresenter) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stGetFollowedDramasRsp)) {
      return;
    }
    WSLog.a("WSGridForHotPresenterLog", "fetchFollowDramaHeaderDataFromCache() onReadCacheCompleted");
    WSGridForHotPresenter.a(this.a, WSDramaUtils.a((stGetFollowedDramasRsp)paramJceStruct), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridForHotPresenter.1
 * JD-Core Version:    0.7.0.1
 */