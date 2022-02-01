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
  
  public void g()
  {
    super.g();
    k();
  }
  
  protected boolean g()
  {
    return true;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioRedPresenter
 * JD-Core Version:    0.7.0.1
 */