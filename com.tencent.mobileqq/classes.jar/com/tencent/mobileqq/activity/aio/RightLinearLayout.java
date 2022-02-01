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
    paramInt1 = getChildCount();
    paramInt3 = getPaddingLeft();
    paramInt1 -= 1;
    while (paramInt1 >= 0)
    {
      View localView = getChildAt(paramInt1);
      int i = paramInt3;
      if (localView != null)
      {
        i = paramInt3;
        if (localView.getVisibility() != 8)
        {
          int n = localView.getMeasuredWidth();
          int i1 = localView.getMeasuredHeight();
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
          int k = localLayoutParams.gravity;
          i = k;
          if (k < 0) {
            i = 16;
          }
          if ((i & 0x70) != 16) {
            i = j;
          } else {
            i = (paramInt4 - paramInt2 - j - m - i1) / 2 + j + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
          }
          paramInt3 += localLayoutParams.leftMargin;
          localView.layout(paramInt3, i, paramInt3 + n, i1 + i);
          i = paramInt3 + (n + localLayoutParams.rightMargin + 0);
        }
      }
      paramInt1 -= 1;
      paramInt3 = i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.RightLinearLayout
 * JD-Core Version:    0.7.0.1
 */