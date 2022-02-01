package com.tencent.biz.qrcode;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;

@SuppressLint({"NewApi"})
public class CustomAccessibilityDelegate
  extends View.AccessibilityDelegate
{
  private View a;
  private CustomAccessibilityDelegate.CallBack b;
  private Runnable c = new CustomAccessibilityDelegate.1(this);
  
  public CustomAccessibilityDelegate(View paramView, CustomAccessibilityDelegate.CallBack paramCallBack)
  {
    this.a = paramView;
    this.b = paramCallBack;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new CustomAccessibilityDelegate.FocusNextAccessibiltyProvider(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CustomAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */