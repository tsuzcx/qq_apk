package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;

class WSVerticalForCLinkPresenter$1
  implements Runnable
{
  WSVerticalForCLinkPresenter$1(WSVerticalForCLinkPresenter paramWSVerticalForCLinkPresenter, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.this$0.a = System.currentTimeMillis();
    WSVerticalDataManager.a().a(this.a, this.this$0);
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(15, this.b, this.a).b(WSVerticalDataUtil.b()).a(WSVerticalForCLinkPresenter.a(this.this$0, this.a));
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCLinkPresenter.1
 * JD-Core Version:    0.7.0.1
 */