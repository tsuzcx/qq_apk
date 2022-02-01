package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams;

class WSVerticalForQQSchemePresenter$1
  implements Runnable
{
  WSVerticalForQQSchemePresenter$1(WSVerticalForQQSchemePresenter paramWSVerticalForQQSchemePresenter, boolean paramBoolean1, boolean paramBoolean2, WSVerticalPageContract.View paramView) {}
  
  public void run()
  {
    WSVerticalRequestParams localWSVerticalRequestParams = new WSVerticalRequestParams(14, this.a, this.b).a(WSVerticalDataUtil.a(this.b, this.c.g()));
    WSVerticalDataManager.a().a(localWSVerticalRequestParams, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForQQSchemePresenter.1
 * JD-Core Version:    0.7.0.1
 */