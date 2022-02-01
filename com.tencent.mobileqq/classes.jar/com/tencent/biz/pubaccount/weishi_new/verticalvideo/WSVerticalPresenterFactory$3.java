package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForTrendsPresenter;

final class WSVerticalPresenterFactory$3
  implements WSVerticalPresenterFactory.OnCreatePresenterListener
{
  public WSVerticalPageContract.Presenter a(WSVerticalPageContract.View paramView)
  {
    return new WSVerticalForTrendsPresenter(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPresenterFactory.3
 * JD-Core Version:    0.7.0.1
 */