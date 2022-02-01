package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioRedPresenter;

final class WSVerticalPresenterFactory$10
  implements WSVerticalPresenterFactory.OnCreatePresenterListener
{
  public WSVerticalPageContract.Presenter a(WSVerticalPageContract.View paramView)
  {
    return new WSVerticalForAioRedPresenter(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPresenterFactory.10
 * JD-Core Version:    0.7.0.1
 */