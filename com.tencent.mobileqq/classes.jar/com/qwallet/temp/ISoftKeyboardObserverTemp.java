package com.qwallet.temp;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ISoftKeyboardObserverTemp
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract void newSoftKeyboardObserverTempImpl(View paramView, ISoftKeyboardObserverTemp.OnSoftKeyboardToggledListenerTemp paramOnSoftKeyboardToggledListenerTemp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.ISoftKeyboardObserverTemp
 * JD-Core Version:    0.7.0.1
 */