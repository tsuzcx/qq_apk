package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class VideoMeasureScaleView
  extends LinearLayout
{
  public VideoMeasureScaleView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoMeasureScaleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoMeasureScaleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (getChildCount() < 40)
    {
      removeAllViews();
      int j = (getMeasuredWidth() - 80) / 39;
      int i = 0;
      while (i < 40)
      {
        View localView = new View(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(2, -1);
        if (i != 0) {
          localLayoutParams.setMargins(j, 0, 0, 0);
        }
        localView.setLayoutParams(localLayoutParams);
        localView.setBackgroundColor(-1);
        localView.setAlpha(0.1F);
        addView(localView);
        i += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VideoMeasureScaleView
 * JD-Core Version:    0.7.0.1
 */