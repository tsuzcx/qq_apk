package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public abstract interface IWSFragmentDelegate<V extends IWSBaseView, P extends IWSPresenter<V>>
{
  public abstract void a();
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(View paramView, @Nullable Bundle paramBundle);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.IWSFragmentDelegate
 * JD-Core Version:    0.7.0.1
 */