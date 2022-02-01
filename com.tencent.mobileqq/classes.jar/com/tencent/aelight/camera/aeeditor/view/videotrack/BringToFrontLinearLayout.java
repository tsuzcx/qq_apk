package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class BringToFrontLinearLayout
  extends BringToFrontLinear
{
  public BringToFrontLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BringToFrontLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BringToFrontLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    paramView1.bringToFront();
    super.requestChildFocus(paramView1, paramView2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.BringToFrontLinearLayout
 * JD-Core Version:    0.7.0.1
 */