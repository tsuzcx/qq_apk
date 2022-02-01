package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class CameraCover
  extends FrameLayout
{
  private View a;
  
  public CameraCover(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraCover(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraCover(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setCameraView(View paramView)
  {
    this.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraCover
 * JD-Core Version:    0.7.0.1
 */