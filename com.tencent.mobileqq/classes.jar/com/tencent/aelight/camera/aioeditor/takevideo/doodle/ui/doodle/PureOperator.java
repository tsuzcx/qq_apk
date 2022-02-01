package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import java.util.ArrayList;

public class PureOperator
  implements DoodleOperator
{
  public float a;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private DoodleLineListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
  private PureLinePath jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath;
  public float b;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  
  public PureOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  private void a(Paint paramPaint, PureLinePath paramPureLinePath)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(paramPureLinePath.jdField_b_of_type_Int);
    paramPaint.setStrokeWidth(paramPureLinePath.c);
    paramPaint.setShader(null);
  }
  
  public Paint a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_Int = ((int)paramFloat);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas, DoodleLinePath paramDoodleLinePath, Paint paramPaint)
  {
    if ((paramDoodleLinePath instanceof PureLinePath))
    {
      paramDoodleLinePath = (PureLinePath)paramDoodleLinePath;
      if (paramDoodleLinePath.jdField_a_of_type_AndroidGraphicsPath != null)
      {
        a(paramPaint, paramDoodleLinePath);
        paramCanvas.drawPath(paramDoodleLinePath.jdField_a_of_type_AndroidGraphicsPath, paramPaint);
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
        f3 = (this.jdField_a_of_type_Float + f1) / 2.0F;
        f4 = (this.jdField_b_of_type_Float + f2) / 2.0F;
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f3, f4);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.c, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f3, f4));
        }
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
      }
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath = new PureLinePath(new Path(), 101, this.jdField_a_of_type_AndroidGraphicsPaint.getColor(), this.jdField_b_of_type_Int);
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLineListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath);
      }
      DoodleLayout.a("use_graffiti");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath;
      f3 = f1 + 1.0F;
      f4 = 1.0F + f2;
      paramMotionEvent.lineTo(f3, f4);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_a_of_type_Int, f1, f2));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_b_of_type_Int, f3, f4));
    }
    return true;
  }
  
  public Paint b()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureLinePath = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PureOperator
 * JD-Core Version:    0.7.0.1
 */