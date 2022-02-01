package com.tencent.biz.pubaccount.readinjoy.viola.delegate;

import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;

class ViolaUiDelegate$1
  implements ViolaUiDelegate.OnTitleChangeListener
{
  ViolaUiDelegate$1(ViolaUiDelegate paramViolaUiDelegate) {}
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    ViolaUiDelegate.a(this.a).setRightButtonText(paramString, paramOnClickListener);
  }
  
  public void a(boolean paramBoolean)
  {
    ViolaUiDelegate.a(this.a).setTitleTransparent(paramBoolean);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    ViolaUiDelegate.a(this.a).setLeftButtonText(paramString, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate.1
 * JD-Core Version:    0.7.0.1
 */