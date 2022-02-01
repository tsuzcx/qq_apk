package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.luggage.wxa.qz.o;

final class t
  extends r
{
  public t(Context paramContext)
  {
    super(paramContext);
  }
  
  public void e()
  {
    try
    {
      ak.a(this).restartInput(this);
      return;
    }
    catch (RuntimeException localRuntimeException1)
    {
      o.b("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", new Object[] { localRuntimeException1 });
      try
      {
        ak.a(this).showSoftInput(this, 0);
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        o.b("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", new Object[] { localRuntimeException2 });
      }
    }
  }
  
  public View getInputPanel()
  {
    return x.c(this);
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    l();
    int i = getInputType() | 0x1;
    if (paramBoolean) {
      i |= 0x80;
    } else {
      i &= 0xFFFFFF7F;
    }
    setInputType(i);
    super.setPasswordMode(paramBoolean);
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.t
 * JD-Core Version:    0.7.0.1
 */