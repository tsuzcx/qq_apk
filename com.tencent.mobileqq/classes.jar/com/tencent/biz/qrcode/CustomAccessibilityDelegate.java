package com.tencent.biz.qrcode;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;
import osk;

@SuppressLint({"NewApi"})
public class CustomAccessibilityDelegate
  extends View.AccessibilityDelegate
{
  private View jdField_a_of_type_AndroidViewView;
  private CustomAccessibilityDelegate.CallBack jdField_a_of_type_ComTencentBizQrcodeCustomAccessibilityDelegate$CallBack;
  private Runnable jdField_a_of_type_JavaLangRunnable = new osk(this);
  
  public CustomAccessibilityDelegate(View paramView, CustomAccessibilityDelegate.CallBack paramCallBack)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQrcodeCustomAccessibilityDelegate$CallBack = paramCallBack;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new CustomAccessibilityDelegate.FocusNextAccessibiltyProvider(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.CustomAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */