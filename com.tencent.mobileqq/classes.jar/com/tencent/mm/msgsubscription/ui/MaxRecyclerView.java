package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.RecyclerView;

public class MaxRecyclerView
  extends RecyclerView
{
  public MaxRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaxRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MaxRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.MaxRecyclerView
 * JD-Core Version:    0.7.0.1
 */