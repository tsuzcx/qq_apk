package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class TopBehindLayout
  extends FrameLayout
{
  private View mContent;
  
  public TopBehindLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopBehindLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopBehindLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {}
  
  public void setContent(View paramView)
  {
    View localView = this.mContent;
    if (localView != null) {
      removeView(localView);
    }
    this.mContent = paramView;
    addView(this.mContent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopBehindLayout
 * JD-Core Version:    0.7.0.1
 */