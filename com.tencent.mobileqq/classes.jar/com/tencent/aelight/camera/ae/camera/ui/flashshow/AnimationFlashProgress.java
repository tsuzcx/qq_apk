package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.QIMCircleProgress;

public class AnimationFlashProgress
  extends QIMCircleProgress
{
  Paint a;
  private int b;
  private int c;
  private RectF d;
  private int e;
  private int f;
  private boolean g = true;
  
  public AnimationFlashProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationFlashProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i = (getWidth() - this.e) / 2;
    int k = getHeight();
    int j = this.e;
    k = (k - j) / 2;
    this.d.set(i, k, i + j, k + j);
    RectF localRectF = this.d;
    i = this.f;
    paramCanvas.drawRoundRect(localRectF, i, i, this.mPaintWhite);
  }
  
  protected void b(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.c * this.mCenterScale, this.mPaintWhite);
  }
  
  public void changeMode(int paramInt)
  {
    setBackgroundResource(2130845881);
    super.changeMode(paramInt);
  }
  
  protected void drawCenterCircle(Canvas paramCanvas)
  {
    if (!this.g) {
      return;
    }
    if (this.mMode == 3)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  protected void init()
  {
    super.init();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.mPaintWhite.setStyle(Paint.Style.FILL);
    setBackgroundResource(2130845881);
    this.e = ViewUtils.dip2px(30.0F);
    this.f = ViewUtils.dip2px(6.0F);
    this.d = new RectF();
  }
  
  public void setCenterView()
  {
    super.setCenterView();
    this.b = ViewUtils.dip2px(3.0F);
    this.c = ViewUtils.dip2px(14.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AnimationFlashProgress
 * JD-Core Version:    0.7.0.1
 */