package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForFriendFeedPresenter;

final class WSVerticalPresenterFactory$6
  implements WSVerticalPresenterFactory.OnCreatePresenterListener
{
  public WSVerticalPageContract.Presenter a(WSVerticalPageContract.View paramView)
  {
    return new WSVerticalForFriendFeedPresenter(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPresenterFactory.6
 * JD-Core Version:    0.7.0.1
 */