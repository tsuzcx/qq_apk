package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class RightLinearLayout
  extends LinearLayout
{
  public RightLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RightLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingTop();
    int m = getPaddingBottom();
    paramInt3 = getChildCount();
    paramInt1 = getPaddingLeft();
    paramInt3 -= 1;
    int i1;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if (paramInt3 >= 0)
    {
      View localView = getChildAt(paramInt3);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label205;
      }
      int n = localView.getMeasuredWidth();
      i1 = localView.getMeasuredHeight();
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      int k = localLayoutParams.gravity;
      i = k;
      if (k < 0) {
        i = 16;
      }
      switch (i & 0x70)
      {
      default: 
        i = j;
        label124:
        paramInt1 += localLayoutParams.leftMargin;
        localView.layout(paramInt1, i, paramInt1 + n, i1 + i);
        paramInt1 = localLayoutParams.rightMargin + n + 0 + paramInt1;
      }
    }
    label205:
    for (;;)
    {
      paramInt3 -= 1;
      break;
      i = (paramInt4 - paramInt2 - j - m - i1) / 2 + j + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
      break label124;
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getOrientation() == 1)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.RightLinearLayout
 * JD-Core Version:    0.7.0.1
 */