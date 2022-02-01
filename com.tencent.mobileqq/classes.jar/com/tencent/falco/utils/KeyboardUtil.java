package com.tencent.falco.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class KeyboardUtil
{
  public static void hideKeyboard(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getCurrentFocus() != null) && (paramActivity.getWindow().getCurrentFocus().getWindowToken() != null)) {
      hideKeyboard(paramActivity, paramActivity.getWindow().getCurrentFocus().getWindowToken());
    }
  }
  
  public static void hideKeyboard(Context paramContext, IBinder paramIBinder)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 0);
  }
  
  public static void hideKeyboard(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
  
  public static boolean isKeyboardShown(Activity paramActivity)
  {
    return keyboardHeight(paramActivity) > UIUtil.getScreenHeight(paramActivity) / 3;
  }
  
  public static int keyboardHeight(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      int i = UIUtil.getScreenMetrics(paramActivity).heightPixels;
      View localView = paramActivity.getWindow().getDecorView();
      Rect localRect = new Rect();
      localView.getWindowVisibleDisplayFrame(localRect);
      return i - UIUtil.getStatusBarHeight(paramActivity) - localRect.height();
    }
    return 0;
  }
  
  public static void showKeyboard(Context paramContext, IBinder paramIBinder)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInputFromWindow(paramIBinder, 0, 0);
  }
  
  public static void showKeyboard(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).showSoftInput(paramEditText, 0);
  }
  
  public static void toggleSoftInputFromWindow(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInputFromWindow(paramEditText.getWindowToken(), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.KeyboardUtil
 * JD-Core Version:    0.7.0.1
 */