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
    if (paramIWSDelegateCallback != null)
    {
      this.a = paramIWSDelegateCallback;
      return;
    }
    throw new NullPointerException("IWSDelegateCallback is null!");
  }
  
  private V a()
  {
    IWSBaseView localIWSBaseView = this.a.a();
    if (localIWSBaseView != null) {
      return localIWSBaseView;
    }
    throw new NullPointerException("View returned from getMvpView() is null");
  }
  
  private P a()
  {
    IWSPresenter localIWSPresenter = this.a.b();
    if (localIWSPresenter != null) {
      return localIWSPresenter;
    }
    throw new NullPointerException("Presenter returned from getPresenter() is null");
  }
  
  public void a()
  {
    a().a();
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
    a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFragmentDelegateImpl
 * JD-Core Version:    0.7.0.1
 */