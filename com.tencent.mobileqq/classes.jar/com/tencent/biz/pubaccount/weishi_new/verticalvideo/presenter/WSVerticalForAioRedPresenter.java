package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.mobileqq.app.ThreadManager;

public class WSVerticalForAioRedPresenter
  extends WSVerticalForRecommendPresenter
{
  public WSVerticalForAioRedPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (a() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForAioRedPresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  protected boolean g()
  {
    return true;
  }
  
  public void h()
  {
    super.h();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioRedPresenter
 * JD-Core Version:    0.7.0.1
 */