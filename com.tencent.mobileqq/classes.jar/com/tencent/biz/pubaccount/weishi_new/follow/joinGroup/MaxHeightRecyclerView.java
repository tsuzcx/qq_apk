package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.utils.ViewUtils;

public class MaxHeightRecyclerView
  extends RecyclerView
{
  private static final int a = ViewUtils.dpToPx(300.0F);
  
  public MaxHeightRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaxHeightRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(a, -2147483648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.MaxHeightRecyclerView
 * JD-Core Version:    0.7.0.1
 */