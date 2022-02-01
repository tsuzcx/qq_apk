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
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private GestureHelper jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 45.0F;
  public int b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  public int c;
  private boolean c;
  public int d = 0;
  int e = 0;
  int f = 0;
  private int g;
  
  public GuideLineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#12B7F5"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setPathEffect(new DashPathEffect(new float[] { 5.0F, 5.0F, 5.0F, 5.0F }, 1.0F));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
    this.jdField_c_of_type_Int = 0;
    this.d = localDisplayMetrics.heightPixels;
    if (LiuHaiUtils.b()) {
      this.d = (localDisplayMetrics.heightPixels - LiuHaiUtils.e - LiuHaiUtils.jdField_a_of_type_Int);
    }
    this.g = ((int)Math.sqrt(Math.pow(localDisplayMetrics.heightPixels, 2.0D) + Math.pow(localDisplayMetrics.widthPixels, 2.0D)));
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(this.jdField_b_of_type_Int / 2, this.d / 2);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(18.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.b(0.5F);
  }
  
  public String a()
  {
    return "GuideLineLayer";
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    this.jdField_b_of_type_Float = paramFloat;
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
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(" currentDegree : ");
      localStringBuilder.append(this.jdField_b_of_type_Float);
      localStringBuilder.append(" centerPoint.x ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF.x);
      localStringBuilder.append(" centerPoint.y : ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF.y);
      localStringBuilder.append(" isDualFinger : ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" transX : ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" transY : ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" maxLength : ");
      localStringBuilder.append(this.g);
      QLog.d("GuideLineLayer", 2, localStringBuilder.toString());
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (Math.abs((int)this.jdField_b_of_type_Float % 45) < 3))
    {
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramCanvas.translate(this.e, this.f);
      int i = Math.round(this.jdField_b_of_type_Float / 45.0F) * 45;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("currentDegree : ");
        localStringBuilder.append(this.jdField_b_of_type_Float);
        localStringBuilder.append("   guideLine Angle : ");
        localStringBuilder.append(i);
        QLog.d("GuideLineLayer", 2, localStringBuilder.toString());
      }
      paramCanvas.rotate(i);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(-this.g, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.g, 0.0F);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw angle guide line");
      }
    }
    paramCanvas.restore();
    paramCanvas.save();
    if ((this.jdField_c_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.x + this.e - (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2) < 4.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2, this.d);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw X guide line");
      }
    }
    if ((this.jdField_c_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.y + this.f - (this.jdField_c_of_type_Int + this.d) / 2) < 4.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, (this.jdField_c_of_type_Int + this.d) / 2);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_Int, (this.jdField_c_of_type_Int + this.d) / 2);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
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
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
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
    this.jdField_c_of_type_Boolean = paramBoolean1;
    a(paramFloat);
    a(paramInt1);
    b(paramInt2);
    a(paramPointF);
    this.jdField_a_of_type_Boolean = paramBoolean2;
    k();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.GuideLineLayer
 * JD-Core Version:    0.7.0.1
 */