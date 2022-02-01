package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class QCircleFlowLayoutItemView
  extends FrameLayout
  implements Checkable
{
  private static final int[] b = { 16842912 };
  private boolean a;
  
  public QCircleFlowLayoutItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getTagView()
  {
    return getChildAt(0);
  }
  
  public boolean isChecked()
  {
    return this.a;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void toggle()
  {
    setChecked(this.a ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayoutItemView
 * JD-Core Version:    0.7.0.1
 */