package com.tencent.mobileqq.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;

class LayoutInflaterCompatHC$FactoryWrapperHC
  implements LayoutInflater.Factory2
{
  final LayoutInflaterFactory a;
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.a(null, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LayoutInflaterCompatHC.FactoryWrapperHC
 * JD-Core Version:    0.7.0.1
 */