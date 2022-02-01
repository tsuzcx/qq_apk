package com.tencent.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public abstract class BaseLayout
  extends FrameLayout
{
  protected View a = b(paramContext);
  
  public BaseLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(getLayoutId(), null, false);
  }
  
  protected abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.library.BaseLayout
 * JD-Core Version:    0.7.0.1
 */