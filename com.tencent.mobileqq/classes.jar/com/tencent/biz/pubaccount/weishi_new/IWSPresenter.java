package com.tencent.biz.pubaccount.weishi_new;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;

public abstract interface IWSPresenter<V extends IWSBaseView>
{
  @UiThread
  public abstract void attachView(@NonNull V paramV);
  
  @UiThread
  public abstract void destroy();
  
  @UiThread
  public abstract void detachView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.IWSPresenter
 * JD-Core Version:    0.7.0.1
 */