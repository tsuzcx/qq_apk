package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class EraserOperator
  implements DoodleOperator
{
  public float a;
  public float b;
  private Paint c = new Paint();
  private Paint d;
  private PureLinePath e;
  private int f = AIOUtils.b(6.0F, BaseApplicationImpl.getContext().getResources());
  private DoodleLineListener g;
  
  public EraserOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeJoin(Paint.Join.ROUND);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.c.setStrokeWidth(this.f);
    this.c.setColor(-1);
    this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeJoin(Paint.Join.ROUND);
    this.d.setStrokeCap(Paint.Cap.ROUND);
    this.d.setColor(-1);
    this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.g = paramDoodleLineListener;
  }
  
  private void a(Paint paramPaint, PureLinePath paramPureLinePath)
  {
    paramPaint.setStrokeWidth(paramPureLinePath.d);
    paramPaint.setShader(null);
  }
  
  public Paint a()
  {
    return this.d;
  }
  
  public void a(float paramFloat)
  {
    this.f = ((int)paramFloat);
    this.c.setStrokeWidth(paramFloat);
  }
  
  public void a(Canvas paramCanvas, DoodleLinePath paramDoodleLinePath, Paint paramPaint)
  {
    if ((paramDoodleLinePath instanceof PureLinePath))
    {
      paramDoodleLinePath = (PureLinePath)paramDoodleLinePath;
      if (paramDoodleLinePath.b != null)
      {
        a(paramPaint, paramDoodleLinePath);
        paramCanvas.drawPath(paramDoodleLinePath.b, paramPaint);
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    float f3;
    float f4;
    if (i != 0)
    {
      if (i == 2)
      {
        f3 = (this.a + f1) / 2.0F;
        f4 = (this.b + f2) / 2.0F;
        paramMotionEvent = this.e;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.b.quadTo(this.a, this.b, f3, f4);
          this.e.e.add(new PointAction(PointAction.c, this.a, this.b, f3, f4));
        }
        this.a = f1;
        this.b = f2;
      }
    }
    else
    {
      this.a = f1;
      this.b = f2;
      this.e = new PureLinePath(new Path(), 111, this.c.getColor(), this.f);
      paramMotionEvent = this.g;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.e);
      }
      this.e.b.reset();
      this.e.b.moveTo(f1, f2);
      paramMotionEvent = this.e.b;
      f3 = f1 + 1.0F;
      f4 = 1.0F + f2;
      paramMotionEvent.lineTo(f3, f4);
      this.e.e.add(new PointAction(PointAction.a, f1, f2));
      this.e.e.add(new PointAction(PointAction.b, f3, f4));
    }
    return true;
  }
  
  public Paint b()
  {
    return this.c;
  }
  
  public void c()
  {
    this.c.setStrokeWidth(this.f);
  }
  
  public void d()
  {
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.EraserOperator
 * JD-Core Version:    0.7.0.1
 */