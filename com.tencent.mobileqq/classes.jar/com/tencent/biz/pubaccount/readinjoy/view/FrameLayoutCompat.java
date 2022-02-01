package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class FrameLayoutCompat
  extends FrameLayout
{
  private FrameLayoutCompat.OnVisibilityChangedListener a;
  
  public FrameLayoutCompat(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FrameLayoutCompat(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FrameLayoutCompat(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.a != null) {
      this.a.a(paramView, paramInt);
    }
  }
  
  public void setVisibilityChangedListener(FrameLayoutCompat.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.a = paramOnVisibilityChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat
 * JD-Core Version:    0.7.0.1
 */