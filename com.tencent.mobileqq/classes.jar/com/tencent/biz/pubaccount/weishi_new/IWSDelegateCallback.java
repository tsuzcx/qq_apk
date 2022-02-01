package com.tencent.biz.pubaccount.weishi_new;

import android.support.annotation.NonNull;

public abstract interface IWSDelegateCallback<V extends IWSBaseView, P extends IWSPresenter<V>>
{
  @NonNull
  public abstract P a();
  
  public abstract void a(P paramP);
  
  public abstract V aH_();
  
  public abstract P aO_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.IWSDelegateCallback
 * JD-Core Version:    0.7.0.1
 */