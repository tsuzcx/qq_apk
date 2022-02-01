package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class VerticalAbsSpinner
  extends AbsSpinner
{
  public VerticalAbsSpinner(Context paramContext)
  {
    super(paramContext);
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalAbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  void g()
  {
    super.g();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public View getSelectedView()
  {
    if ((this.B > 0) && (this.z >= 0))
    {
      if (Math.abs(this.z - this.k) > getChildCount())
      {
        i = this.z + this.B - this.k;
        localView = getChildAt(i);
        if (localView != null) {
          localView.setTag(String.valueOf(i));
        }
        return localView;
      }
      int i = this.z - this.k;
      View localView = getChildAt(i);
      if (localView != null) {
        localView.setTag(String.valueOf(i));
      }
      return localView;
    }
    return null;
  }
  
  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
    h();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    super.setSelection(paramInt, paramBoolean);
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.VerticalAbsSpinner
 * JD-Core Version:    0.7.0.1
 */