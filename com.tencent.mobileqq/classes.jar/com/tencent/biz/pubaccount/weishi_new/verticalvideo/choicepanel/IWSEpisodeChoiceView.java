package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalChoiceVideoPresenter;
import java.util.List;

public abstract interface IWSEpisodeChoiceView
{
  public abstract void a(AbsWSVerticalChoiceVideoPresenter paramAbsWSVerticalChoiceVideoPresenter);
  
  public abstract void a(List<WSVerticalItemData> paramList);
  
  public abstract void b();
  
  public abstract void b(List<WSVerticalItemData> paramList);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void c(List<WSVerticalItemData> paramList);
  
  public abstract void d();
  
  public abstract void dismiss();
  
  public abstract void e();
  
  public abstract boolean isShowing();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView
 * JD-Core Version:    0.7.0.1
 */