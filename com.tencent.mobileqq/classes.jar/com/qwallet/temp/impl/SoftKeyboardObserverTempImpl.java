package com.qwallet.temp.impl;

import android.view.View;
import com.qwallet.temp.ISoftKeyboardObserverTemp;
import com.qwallet.temp.ISoftKeyboardObserverTemp.OnSoftKeyboardToggledListenerTemp;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.widget.immersive.ImmersiveUtils;

public class SoftKeyboardObserverTempImpl
  implements ISoftKeyboardObserverTemp
{
  private SoftKeyboardObserver mSoftKeyboardObserver;
  
  public void destroy()
  {
    SoftKeyboardObserver localSoftKeyboardObserver = this.mSoftKeyboardObserver;
    if (localSoftKeyboardObserver != null) {
      localSoftKeyboardObserver.a();
    }
  }
  
  public void newSoftKeyboardObserverTempImpl(View paramView, ISoftKeyboardObserverTemp.OnSoftKeyboardToggledListenerTemp paramOnSoftKeyboardToggledListenerTemp)
  {
    this.mSoftKeyboardObserver = new SoftKeyboardObserver(paramView, new SoftKeyboardObserverTempImpl.1(this, paramOnSoftKeyboardToggledListenerTemp), ImmersiveUtils.getStatusBarHeight(paramView.getContext()) + 160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.SoftKeyboardObserverTempImpl
 * JD-Core Version:    0.7.0.1
 */