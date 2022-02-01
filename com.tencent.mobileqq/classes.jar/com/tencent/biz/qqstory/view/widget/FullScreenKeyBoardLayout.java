package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class FullScreenKeyBoardLayout
  extends RelativeLayout
{
  private int a = 0;
  private int b = 0;
  private Rect c = new Rect();
  
  public FullScreenKeyBoardLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullScreenKeyBoardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FullScreenKeyBoardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    getWindowVisibleDisplayFrame(this.c);
    if ((this.b == 0) && (this.a == 0))
    {
      this.b = getRootView().getWidth();
      this.a = getRootView().getHeight();
    }
    int i = this.c.bottom - this.c.top;
    int j = this.a;
    if (j - i > j / 4)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenKeyBoardLayout
 * JD-Core Version:    0.7.0.1
 */