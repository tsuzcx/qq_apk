package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;

class WSVerticalForAioRedPresenter$1
  implements Runnable
{
  WSVerticalForAioRedPresenter$1(WSVerticalForAioRedPresenter paramWSVerticalForAioRedPresenter, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    WSVerticalDataManager.a().a(this.a, this.this$0);
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(2, this.b, this.a).b(WSVerticalDataUtil.b());
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioRedPresenter.1
 * JD-Core Version:    0.7.0.1
 */