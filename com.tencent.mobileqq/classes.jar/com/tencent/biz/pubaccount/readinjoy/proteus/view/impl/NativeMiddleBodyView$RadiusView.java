package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import qwb;

public class NativeMiddleBodyView$RadiusView
  extends RelativeLayout
{
  final int jdField_a_of_type_Int = ViewUtils.dip2px(8.0F);
  String jdField_a_of_type_JavaLangString = null;
  String b = null;
  String c = null;
  String d = null;
  
  public NativeMiddleBodyView$RadiusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View.OnLayoutChangeListener a()
  {
    return new qwb(this);
  }
  
  public void setBottomLeftRadius(String paramString)
  {
    this.b = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    localLayoutParams.addRule(12);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setBottomRightRadius(String paramString)
  {
    this.d = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setLeftTopRadius(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    addView(localNativeReadInjoyImageView, new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void setRightTopRadius(String paramString)
  {
    this.c = paramString;
    NativeReadInjoyImageView localNativeReadInjoyImageView = new NativeReadInjoyImageView(getContext());
    localNativeReadInjoyImageView.setIsCacheIcon(true);
    localNativeReadInjoyImageView.setIsClosedoAlphaAniamation(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    localLayoutParams.addRule(11);
    addView(localNativeReadInjoyImageView, localLayoutParams);
    localNativeReadInjoyImageView.setImageSrc(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView.RadiusView
 * JD-Core Version:    0.7.0.1
 */