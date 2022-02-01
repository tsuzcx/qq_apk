package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils;

class WSVerticalForTrendsPresenter$1
  implements Runnable
{
  WSVerticalForTrendsPresenter$1(WSVerticalForTrendsPresenter paramWSVerticalForTrendsPresenter, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    WSVerticalTrendsCacheUtils.a(this.a, this.this$0);
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(6, this.b, this.a);
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForTrendsPresenter.1
 * JD-Core Version:    0.7.0.1
 */