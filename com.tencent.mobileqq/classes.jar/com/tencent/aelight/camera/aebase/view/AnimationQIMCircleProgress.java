package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.QIMCircleProgress;

public class AnimationQIMCircleProgress
  extends QIMCircleProgress
{
  Paint a;
  private float b = 1.0F;
  private int c;
  private int d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private AECircleCaptureStyle h = null;
  private RectF i;
  private int j;
  private int k;
  private boolean l = true;
  
  public AnimationQIMCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationQIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int m = (getWidth() - this.j) / 2;
    int i1 = getHeight();
    int n = this.j;
    i1 = (i1 - n) / 2;
    this.i.set(m, i1, m + n, i1 + n);
    RectF localRectF = this.i;
    m = this.k;
    paramCanvas.drawRoundRect(localRectF, m, m, this.mPaintWhite);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.f)
    {
      setBackgroundResource(2130837929);
      setCenterCircleColor(getResources().getColor(2131167113));
    }
    else
    {
      setBackgroundResource(2130845881);
      setCenterCircleColor(-1);
    }
    invalidate();
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    this.g = paramBoolean;
    this.h = paramAECircleCaptureStyle;
    if (this.g)
    {
      setBackgroundResource(this.h.k);
      setCenterCircleColor(0);
      setProgressOffset(AIOUtils.b(2.5F, getResources()));
      setProgressColor(this.h.p);
    }
    else
    {
      setBackgroundResource(2130845881);
      setCenterCircleColor(-1);
    }
    invalidate();
  }
  
  protected void b(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.d * this.mCenterScale, this.mPaintWhite);
  }
  
  protected void c(Canvas paramCanvas)
  {
    int m = UIUtils.a(getContext(), 3.0F);
    Color.parseColor("#33000000");
    float f1 = this.mWidth / 2;
    float f2 = this.mWidth / 2;
    float f3 = this.mWidth / 2 - m / 2;
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(m);
    this.a.setColor(-1);
    paramCanvas.drawCircle(f1, f2, f3, this.a);
  }
  
  public void changeMode(int paramInt)
  {
    if (this.g)
    {
      AECircleCaptureStyle localAECircleCaptureStyle = this.h;
      if (localAECircleCaptureStyle != null)
      {
        setBackgroundResource(localAECircleCaptureStyle.k);
        break label69;
      }
    }
    if (this.f) {
      setBackgroundResource(2130837929);
    } else if ((paramInt != 1) && (this.e)) {
      setBackgroundDrawable(null);
    } else {
      setBackgroundResource(2130845881);
    }
    label69:
    super.changeMode(paramInt);
  }
  
  protected void drawCenterCircle(Canvas paramCanvas)
  {
    if (!this.l) {
      return;
    }
    if (!this.e)
    {
      if (this.mMode == 3)
      {
        a(paramCanvas);
        return;
      }
      b(paramCanvas);
      return;
    }
    if (this.mMode == 1)
    {
      b(paramCanvas);
      return;
    }
    if (this.mMode == 3) {
      a(paramCanvas);
    }
    c(paramCanvas);
  }
  
  protected void init()
  {
    super.init();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.mPaintWhite.setStyle(Paint.Style.FILL);
    setBackgroundResource(2130845881);
    this.j = ViewUtils.dip2px(30.0F);
    this.k = ViewUtils.dip2px(6.0F);
    this.i = new RectF();
  }
  
  public void setCenterView()
  {
    super.setCenterView();
    this.c = ViewUtils.dip2px(3.0F);
    this.d = ViewUtils.dip2px(14.0F);
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      invalidate();
    }
  }
  
  public void setIldeStyle(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.e) {
      setBackgroundDrawable(null);
    } else {
      setBackgroundResource(2130845881);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */