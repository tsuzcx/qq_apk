package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class QCircleFlowLayoutItemView
  extends FrameLayout
  implements Checkable
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private boolean jdField_a_of_type_Boolean;
  
  public QCircleFlowLayoutItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a()
  {
    return getChildAt(0);
  }
  
  public boolean isChecked()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void toggle()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayoutItemView
 * JD-Core Version:    0.7.0.1
 */