package com.tencent.luggage.wxa.ct;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.xweb.WebView;

class i
  extends WebView
{
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(Context paramContext)
  {
    if (!(getContext() instanceof MutableContextWrapper)) {
      return;
    }
    MutableContextWrapper localMutableContextWrapper = (MutableContextWrapper)getContext();
    if (localMutableContextWrapper.getBaseContext() == paramContext) {
      return;
    }
    localMutableContextWrapper.setBaseContext(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.i
 * JD-Core Version:    0.7.0.1
 */