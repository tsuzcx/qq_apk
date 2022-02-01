package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.RecyclerView;

public class MaxHeightRecyclerView
  extends RecyclerView
{
  private int a;
  
  public MaxHeightRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaxHeightRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MaxHeightRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getMaxHeight()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.a;
    if (i > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    invalidate();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView
 * JD-Core Version:    0.7.0.1
 */