package com.tencent.biz.pubaccount.weishi_new.presenter.view;

import android.support.annotation.UiThread;
import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;

public abstract interface IWSView<M>
  extends IWSBaseView
{
  @UiThread
  public abstract void a(int paramInt, String paramString);
  
  @UiThread
  public abstract void a(M paramM);
  
  @UiThread
  public abstract void r();
  
  @UiThread
  public abstract void s();
  
  @UiThread
  public abstract void u();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView
 * JD-Core Version:    0.7.0.1
 */