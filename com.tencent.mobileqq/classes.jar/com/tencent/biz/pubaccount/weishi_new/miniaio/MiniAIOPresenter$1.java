package com.tencent.biz.pubaccount.weishi_new.miniaio;

import android.view.View;

class MiniAIOPresenter$1
  extends MiniMsgCallbackImpl
{
  MiniAIOPresenter$1(MiniAIOPresenter paramMiniAIOPresenter) {}
  
  public void hide()
  {
    super.hide();
    if (MiniAIOPresenter.a(this.a) != null)
    {
      MiniAIOPresenter.a(this.a).setVisibility(4);
      MiniAIOPresenter.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      MiniAIOPresenter.a(this.a, 0);
    }
    while ((paramInt <= MiniAIOPresenter.a(this.a)) || (MiniAIOPresenter.a(this.a) == null)) {
      return;
    }
    if (MiniAIOPresenter.a(this.a)) {
      MiniAIOPresenter.a(this.a).setVisibility(0);
    }
    MiniAIOPresenter.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniaio.MiniAIOPresenter.1
 * JD-Core Version:    0.7.0.1
 */