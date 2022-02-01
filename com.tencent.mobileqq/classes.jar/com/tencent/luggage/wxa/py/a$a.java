package com.tencent.luggage.wxa.py;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.qz.o;
import org.apache.commons.lang.ArrayUtils;

final class a$a
  extends FrameLayout
{
  private final Rect a = new Rect();
  private final int[] b = new int[2];
  private boolean c = false;
  
  public a$a(@NonNull Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(true);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    paramLayoutParams = (FrameLayout.LayoutParams)super.generateLayoutParams(paramLayoutParams);
    if (-1 == paramLayoutParams.gravity) {
      paramLayoutParams.gravity = 17;
    }
    return paramLayoutParams;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!ViewCompat.isAttachedToWindow(this)) {
      return;
    }
    getWindowVisibleDisplayFrame(this.a);
    getLocationInWindow(this.b);
    if (o.c() <= 1) {
      o.e("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.a, ArrayUtils.toString(this.b) });
    }
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      View localView = getChildAt(paramInt1);
      paramInt2 = this.b[1] + localView.getTop() + localView.getHeight() - this.a.bottom;
      if (paramInt2 > 0)
      {
        paramInt2 = Math.max(0, localView.getTop() - paramInt2);
        localView.layout(localView.getLeft(), paramInt2, localView.getRight(), localView.getHeight() + paramInt2);
      }
      paramInt1 += 1;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    bringToFront();
    bringChildToFront(paramView);
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if (getChildCount() == 0)
    {
      setVisibility(8);
      if ((getParent() instanceof ViewGroup)) {
        ((ViewGroup)getParent()).removeView(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.py.a.a
 * JD-Core Version:    0.7.0.1
 */