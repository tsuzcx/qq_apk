package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class WSFragmentDelegateImpl<V extends IWSBaseView, P extends IWSPresenter<V>>
  implements IWSFragmentDelegate
{
  private IWSDelegateCallback<V, P> a;
  
  public WSFragmentDelegateImpl(IWSDelegateCallback<V, P> paramIWSDelegateCallback)
  {
    if (paramIWSDelegateCallback == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramIWSDelegateCallback;
  }
  
  private V a()
  {
    IWSBaseView localIWSBaseView = this.a.a();
    if (localIWSBaseView == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localIWSBaseView;
  }
  
  private P a()
  {
    IWSPresenter localIWSPresenter = this.a.b();
    if (localIWSPresenter == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localIWSPresenter;
  }
  
  public void a()
  {
    a().c();
  }
  
  public void a(Bundle paramBundle)
  {
    IWSPresenter localIWSPresenter = this.a.b();
    paramBundle = localIWSPresenter;
    if (localIWSPresenter == null) {
      paramBundle = this.a.a();
    }
    this.a.a(paramBundle);
  }
  
  public void a(View paramView, @Nullable Bundle paramBundle)
  {
    a().a(a());
  }
  
  public void b()
  {
    a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFragmentDelegateImpl
 * JD-Core Version:    0.7.0.1
 */