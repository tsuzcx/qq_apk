package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class GuideLineLayer
  extends BaseLayer
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  int e = 0;
  int f = 0;
  private PointF g;
  private int h;
  private Paint i;
  private Paint j;
  private Path k;
  private GestureHelper l;
  private float m = 45.0F;
  private boolean n = false;
  private boolean o = false;
  
  public GuideLineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    d();
  }
  
  private void d()
  {
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(Color.parseColor("#12B7F5"));
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(2.0F);
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setColor(Color.parseColor("#12B7F5"));
    this.j.setStyle(Paint.Style.STROKE);
    this.j.setStrokeWidth(2.0F);
    this.j.setPathEffect(new DashPathEffect(new float[] { 5.0F, 5.0F, 5.0F, 5.0F }, 1.0F));
    this.k = new Path();
    DisplayMetrics localDisplayMetrics = this.z.getResources().getDisplayMetrics();
    this.a = 0;
    this.b = localDisplayMetrics.widthPixels;
    this.c = 0;
    this.d = localDisplayMetrics.heightPixels;
    if (LiuHaiUtils.b()) {
      this.d = (localDisplayMetrics.heightPixels - LiuHaiUtils.j - LiuHaiUtils.d);
    }
    this.h = ((int)Math.sqrt(Math.pow(localDisplayMetrics.heightPixels, 2.0D) + Math.pow(localDisplayMetrics.widthPixels, 2.0D)));
    this.g = new PointF(this.b / 2, this.d / 2);
    this.l = new GestureHelper();
    this.l.a(true);
    this.l.a(18.0F);
    this.l.b(0.5F);
  }
  
  public String a()
  {
    return "GuideLineLayer";
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    this.m = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayerDraw  showGuideLine : ");
      localStringBuilder.append(this.o);
      localStringBuilder.append(" currentDegree : ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" centerPoint.x ");
      localStringBuilder.append(this.g.x);
      localStringBuilder.append(" centerPoint.y : ");
      localStringBuilder.append(this.g.y);
      localStringBuilder.append(" isDualFinger : ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" transX : ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" transY : ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" maxLength : ");
      localStringBuilder.append(this.h);
      QLog.d("GuideLineLayer", 2, localStringBuilder.toString());
    }
    if ((this.o) && (this.n) && (Math.abs((int)this.m % 45) < 3))
    {
      paramCanvas.translate(this.g.x, this.g.y);
      paramCanvas.translate(this.e, this.f);
      int i1 = Math.round(this.m / 45.0F) * 45;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("currentDegree : ");
        localStringBuilder.append(this.m);
        localStringBuilder.append("   guideLine Angle : ");
        localStringBuilder.append(i1);
        QLog.d("GuideLineLayer", 2, localStringBuilder.toString());
      }
      paramCanvas.rotate(i1);
      this.k.reset();
      this.k.moveTo(-this.h, 0.0F);
      this.k.lineTo(this.h, 0.0F);
      paramCanvas.drawPath(this.k, this.j);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw angle guide line");
      }
    }
    paramCanvas.restore();
    paramCanvas.save();
    if ((this.o) && (Math.abs(this.g.x + this.e - (this.a + this.b) / 2) < 4.0F))
    {
      this.k.reset();
      this.k.moveTo((this.a + this.b) / 2, 0.0F);
      this.k.lineTo((this.a + this.b) / 2, this.d);
      paramCanvas.drawPath(this.k, this.i);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw X guide line");
      }
    }
    if ((this.o) && (Math.abs(this.g.y + this.f - (this.c + this.d) / 2) < 4.0F))
    {
      this.k.reset();
      this.k.moveTo(this.a, (this.c + this.d) / 2);
      this.k.lineTo(this.b, (this.c + this.d) / 2);
      paramCanvas.drawPath(this.k, this.i);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw Y guide line");
      }
    }
    paramCanvas.restore();
  }
  
  public void a(PointF paramPointF)
  {
    if (paramPointF == null) {
      return;
    }
    this.g.set(paramPointF);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GuideLineLayer refreshed, entrance : ");
      localStringBuilder.append(paramInt3);
      QLog.d("GuideLineLayer", 2, localStringBuilder.toString());
    }
    this.o = paramBoolean1;
    a(paramFloat);
    a(paramInt1);
    b(paramInt2);
    a(paramPointF);
    this.n = paramBoolean2;
    u();
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.GuideLineLayer
 * JD-Core Version:    0.7.0.1
 */