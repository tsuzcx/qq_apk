package com.tencent.luggage.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class h
{
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return false;
    }
    if ((paramContext instanceof Activity)) {
      paramContext = (Activity)paramContext;
    } else {
      paramContext = null;
    }
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getCurrentFocus();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getWindowToken();
    if (paramContext == null) {
      return false;
    }
    try
    {
      boolean bool = localInputMethodManager.hideSoftInputFromWindow(paramContext, 0);
      return bool;
    }
    catch (IllegalArgumentException paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.h
 * JD-Core Version:    0.7.0.1
 */