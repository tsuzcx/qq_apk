package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class AEAbsBottomPanal
  extends FrameLayout
{
  protected boolean f = false;
  
  public AEAbsBottomPanal(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEAbsBottomPanal(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEAbsBottomPanal(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean e();
  
  public void h()
  {
    a(true);
  }
  
  public void setClosedByTouch(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
 * JD-Core Version:    0.7.0.1
 */