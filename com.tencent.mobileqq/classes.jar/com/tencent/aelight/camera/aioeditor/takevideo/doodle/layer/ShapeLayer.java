package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.widget.ScaleGestureDetector;

public class ShapeLayer
  extends BaseLayer
{
  public int a;
  private final ShapeOperator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator = new ShapeOperator(this.jdField_a_of_type_AndroidContentContext);
  private ScaleGestureDetector jdField_a_of_type_ComTencentWidgetScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new ShapeLayer.ScaleDetectorListener(this, null));
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private int jdField_b_of_type_Int = -1;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private int c = 1;
  
  public ShapeLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 9;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.jdField_b_of_type_Int = paramMotionEvent.getPointerId(0);
    }
    if (this.jdField_b_of_type_Int != paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())) {
      return false;
    }
    if (i == 0)
    {
      VideoEditReport.a("0X80076BE");
      VideoEditReport.b("0X80075CB");
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    localMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    if ((i == 6) && (this.jdField_b_of_type_Int == paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()))) {
      localMotionEvent.setAction(1);
    }
    boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.a(localMotionEvent);
    localMotionEvent.recycle();
    return bool;
  }
  
  public ShapeOperator a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator;
  }
  
  public String a()
  {
    return "ShapeLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.d();
    SLog.b("ShapeLayer", "clear over.");
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMode---invalid mode: ");
      localStringBuilder.append(paramInt);
      AEQLog.d("ShapeLayer", localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.a(paramInt1, paramInt2);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.b(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsPassiveActivation: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("ShapeLayer", localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.b();
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a.a()))
    {
      int j = paramMotionEvent.getActionMasked();
      boolean bool2 = false;
      boolean bool1 = false;
      boolean bool3;
      if (j == 0)
      {
        this.c = 1;
        bool3 = e(paramMotionEvent);
        bool2 = c(paramMotionEvent);
        if ((bool3) || (bool2)) {
          bool1 = true;
        }
        return bool1;
      }
      if (this.c == 1)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= 100L) {
          i = 1;
        } else {
          i = 0;
        }
        if ((j == 5) && (i != 0))
        {
          AEQLog.b("ShapeLayer", "recognize this gesture as SCALE");
          this.c = 3;
          e(localMotionEvent);
        }
        else if (i == 0)
        {
          AEQLog.b("ShapeLayer", "recognize this gesture as DRAW");
          this.c = 2;
          c(localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      int i = this.c;
      if (i == 3)
      {
        bool1 = c(paramMotionEvent);
      }
      else if (i == 2)
      {
        bool1 = e(paramMotionEvent);
      }
      else
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = e(paramMotionEvent);
          bool3 = c(paramMotionEvent);
          if (!bool1)
          {
            bool1 = bool2;
            if (!bool3) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
      if (j == 1) {
        this.c = 1;
      }
      return bool1;
    }
    return e(paramMotionEvent);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.a();
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.a() != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    paramMotionEvent = this.jdField_a_of_type_ArrayOfFloat;
    localMotionEvent.setLocation(paramMotionEvent[0], paramMotionEvent[1]);
    boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.b(localMotionEvent);
    localMotionEvent.recycle();
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("accept touch event: ");
    paramMotionEvent.append(bool);
    AEQLog.b("ShapeLayer", paramMotionEvent.toString());
    return bool;
  }
  
  public void c()
  {
    super.c();
    if ((!c()) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator.a())) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.invalidate();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer
 * JD-Core Version:    0.7.0.1
 */