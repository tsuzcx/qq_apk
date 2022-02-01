package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class BringToFrontLinear
  extends LinearLayout
{
  private BringToFrontHelper a;
  
  public BringToFrontLinear(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BringToFrontLinear(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BringToFrontLinear(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setWillNotDraw(true);
    setChildrenDrawingOrderEnabled(true);
    this.a = new BringToFrontHelper();
  }
  
  public void bringChildToFront(View paramView)
  {
    this.a.a(this, paramView);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.a.a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.BringToFrontLinear
 * JD-Core Version:    0.7.0.1
 */