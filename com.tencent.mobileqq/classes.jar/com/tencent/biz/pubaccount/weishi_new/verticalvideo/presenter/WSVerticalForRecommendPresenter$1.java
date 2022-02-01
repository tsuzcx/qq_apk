package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;

class WSVerticalForRecommendPresenter$1
  implements Runnable
{
  WSVerticalForRecommendPresenter$1(WSVerticalForRecommendPresenter paramWSVerticalForRecommendPresenter, boolean paramBoolean1, boolean paramBoolean2, WSVerticalPageContract.View paramView) {}
  
  public void run()
  {
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(2, this.a, this.b).a(this.c.m()).a(WSVerticalDataUtil.a(this.b, this.c.g()));
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForRecommendPresenter.1
 * JD-Core Version:    0.7.0.1
 */