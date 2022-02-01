package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;

public abstract class AbsAECaptureButton
  extends RelativeLayout
  implements IAECaptureButton, ISimpleLifecycle
{
  public AbsAECaptureButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public AbsAECaptureButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsAECaptureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, AECircleCaptureStyle paramAECircleCaptureStyle) {}
  
  public abstract View getProgressView();
  
  public void setGifMode(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
 * JD-Core Version:    0.7.0.1
 */