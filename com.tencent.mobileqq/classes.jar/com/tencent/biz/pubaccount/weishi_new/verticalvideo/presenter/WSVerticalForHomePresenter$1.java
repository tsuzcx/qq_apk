package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;

class WSVerticalForHomePresenter$1
  implements Runnable
{
  WSVerticalForHomePresenter$1(WSVerticalForHomePresenter paramWSVerticalForHomePresenter, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.this$0.a = System.currentTimeMillis();
    WSVerticalDataManager.a().a(this.a, this.this$0);
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(12, this.b, this.a).b(WSVerticalDataUtil.b()).a(WSVerticalForHomePresenter.a(this.this$0, this.a)).a(WSVerticalForHomePresenter.a(this.this$0));
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForHomePresenter.1
 * JD-Core Version:    0.7.0.1
 */