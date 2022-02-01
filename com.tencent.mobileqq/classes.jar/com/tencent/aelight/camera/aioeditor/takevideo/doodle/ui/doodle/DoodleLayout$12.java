package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.takevideo.TakeVideoUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class DoodleLayout$12
  implements ShapeEffect.InteractionListener
{
  private float jdField_a_of_type_Float;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  
  DoodleLayout$12(DoodleLayout paramDoodleLayout, ShapeLayer paramShapeLayer) {}
  
  @NotNull
  public MotionEvent a(MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    paramMatrix = this.jdField_a_of_type_ArrayOfFloat;
    paramMotionEvent.setLocation(paramMatrix[0], paramMatrix[1]);
    return paramMotionEvent;
  }
  
  public void a()
  {
    AEQLog.a("DoodleLayout", "onClickEmpty");
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 11)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(9, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(9);
      DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
      DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, true, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "ShapeLayer tap up show");
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.b())
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(11);
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 11);
        DoodleLayout.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "ShapeLayer tap up hide");
      }
    }
  }
  
  public void a(ShapeEffect paramShapeEffect) {}
  
  public void a(ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, paramShapeEffect, paramRectF);
    AEBaseDataReporter.a().aY();
  }
  
  public void a(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    Matrix localMatrix = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.a();
    paramShapeEffect = paramMotionEvent;
    if (localMatrix != null)
    {
      paramShapeEffect = new StringBuilder();
      paramShapeEffect.append("onTouchBodyDown--(");
      paramShapeEffect.append(paramMotionEvent.getX());
      paramShapeEffect.append(", ");
      paramShapeEffect.append(paramMotionEvent.getY());
      paramShapeEffect.append("), invertMatrix=");
      paramShapeEffect.append(localMatrix.toShortString());
      AEQLog.a("DoodleLayout", paramShapeEffect.toString());
      paramShapeEffect = a(paramMotionEvent, localMatrix);
    }
    if (DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) {
      this.jdField_a_of_type_Float = paramShapeEffect.getY();
    }
    if (localMatrix != null) {
      paramShapeEffect.recycle();
    }
  }
  
  public void b()
  {
    DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    DoodleLayout.a(localDoodleLayout, localDoodleLayout.h);
  }
  
  public void b(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    if ((DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
    {
      TakeVideoUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
    }
    if (DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout))
    {
      Matrix localMatrix = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.a();
      paramShapeEffect = paramMotionEvent;
      if (localMatrix != null) {
        paramShapeEffect = a(paramMotionEvent, localMatrix);
      }
      if (((int)Math.abs(paramShapeEffect.getY() - this.jdField_a_of_type_Float) > DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) && (this.jdField_a_of_type_AndroidGraphicsRect != null)) {
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a()))
        {
          if ((paramShapeEffect.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramShapeEffect.getX(), (int)paramShapeEffect.getY())) && (DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)))
          {
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, true);
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          int i = (int)paramShapeEffect.getX();
          int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
          int k = (int)paramShapeEffect.getY();
          int m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("onTouchBodyMove--(");
          paramMotionEvent.append(paramShapeEffect.getX());
          paramMotionEvent.append(", ");
          paramMotionEvent.append(paramShapeEffect.getY());
          paramMotionEvent.append("), mRubbishRect=");
          paramMotionEvent.append(this.jdField_a_of_type_AndroidGraphicsRect.toShortString());
          paramMotionEvent.append(", mDisplayRect=");
          paramMotionEvent.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.toShortString());
          AEQLog.a("DoodleLayout", paramMotionEvent.toString());
          if (this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m))
          {
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, true);
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      if (localMatrix != null) {
        paramShapeEffect.recycle();
      }
    }
  }
  
  public void c(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    if (DoodleLayout.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout))
    {
      Matrix localMatrix = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.a();
      paramShapeEffect = paramMotionEvent;
      if (localMatrix != null) {
        paramShapeEffect = a(paramMotionEvent, localMatrix);
      }
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams == null) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())))
      {
        int i = (int)paramShapeEffect.getX();
        int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
        int k = (int)paramShapeEffect.getY();
        int m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
        if ((DoodleLayout.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout)) && (this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)))
        {
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.a().e();
        }
      }
      else if (paramShapeEffect.getPointerCount() == 1)
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidGraphicsRect;
        if ((paramMotionEvent != null) && (paramMotionEvent.contains((int)paramShapeEffect.getX(), (int)paramShapeEffect.getY())) && (this.jdField_a_of_type_Boolean))
        {
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.a().e();
        }
      }
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
      paramMotionEvent.a(new View[] { paramMotionEvent.jdField_a_of_type_AndroidWidgetRelativeLayout });
      if (localMatrix != null) {
        paramShapeEffect.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.12
 * JD-Core Version:    0.7.0.1
 */