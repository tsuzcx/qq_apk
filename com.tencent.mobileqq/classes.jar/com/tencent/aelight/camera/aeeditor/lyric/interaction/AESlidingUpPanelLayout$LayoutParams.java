package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class AESlidingUpPanelLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  private static final int[] b = { 16843137 };
  public float a = 0.0F;
  
  public AESlidingUpPanelLayout$LayoutParams()
  {
    super(-1, -1);
  }
  
  public AESlidingUpPanelLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b);
    if (paramContext != null)
    {
      this.a = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
  }
  
  public AESlidingUpPanelLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public AESlidingUpPanelLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.AESlidingUpPanelLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */