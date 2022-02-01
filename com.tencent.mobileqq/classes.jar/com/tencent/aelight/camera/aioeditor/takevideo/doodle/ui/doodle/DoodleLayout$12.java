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
  private boolean c;
  private float d;
  private Rect e;
  private float[] f = new float[2];
  
  DoodleLayout$12(DoodleLayout paramDoodleLayout, ShapeLayer paramShapeLayer) {}
  
  @NotNull
  public MotionEvent a(MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    this.f[0] = paramMotionEvent.getX();
    this.f[1] = paramMotionEvent.getY();
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMatrix.mapPoints(this.f);
    paramMatrix = this.f;
    paramMotionEvent.setLocation(paramMatrix[0], paramMatrix[1]);
    return paramMotionEvent;
  }
  
  public void a()
  {
    AEQLog.a("DoodleLayout", "onClickEmpty");
    if (this.b.C == 11)
    {
      this.b.a(9, Boolean.valueOf(false));
      this.b.setState(9);
      DoodleLayout.b(this.b);
      DoodleLayout.a(this.b, true, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "ShapeLayer tap up show");
      }
    }
    else
    {
      if (!this.a.d())
      {
        this.b.setState(11);
        DoodleLayout.a(this.b, 11);
        DoodleLayout.k(this.b);
        DoodleLayout.a(this.b, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "ShapeLayer tap up hide");
      }
    }
  }
  
  public void a(ShapeEffect paramShapeEffect) {}
  
  public void a(ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    DoodleLayout.a(this.b, paramShapeEffect, paramRectF);
    AEBaseDataReporter.a().bg();
  }
  
  public void a(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    Matrix localMatrix = this.a.y();
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
    if (DoodleLayout.h(this.b)) {
      this.d = paramShapeEffect.getY();
    }
    if (localMatrix != null) {
      paramShapeEffect.recycle();
    }
  }
  
  public void b()
  {
    DoodleLayout.a(this.b);
    DoodleLayout localDoodleLayout = this.b;
    DoodleLayout.a(localDoodleLayout, localDoodleLayout.C);
  }
  
  public void b(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    if ((DoodleLayout.h(this.b)) && (this.b.q.getVisibility() != 0))
    {
      TakeVideoUtils.a(this.b.q, false);
      this.e = new Rect();
      this.b.q.getGlobalVisibleRect(this.e);
      this.b.v.getGlobalVisibleRect(this.b.I);
    }
    if (DoodleLayout.h(this.b))
    {
      Matrix localMatrix = this.a.y();
      paramShapeEffect = paramMotionEvent;
      if (localMatrix != null) {
        paramShapeEffect = a(paramMotionEvent, localMatrix);
      }
      if (((int)Math.abs(paramShapeEffect.getY() - this.d) > DoodleLayout.i(this.b)) && (this.e != null)) {
        if ((this.b.p != null) && (!this.b.p.b()))
        {
          if ((paramShapeEffect.getPointerCount() == 1) && (this.e.contains((int)paramShapeEffect.getX(), (int)paramShapeEffect.getY())) && (DoodleLayout.h(this.b)))
          {
            DoodleLayout.a(this.b, true);
            this.c = true;
          }
          else
          {
            DoodleLayout.a(this.b, false);
            this.c = false;
          }
        }
        else
        {
          int i = (int)paramShapeEffect.getX();
          int j = this.b.I.left;
          int k = (int)paramShapeEffect.getY();
          int m = this.b.I.top;
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("onTouchBodyMove--(");
          paramMotionEvent.append(paramShapeEffect.getX());
          paramMotionEvent.append(", ");
          paramMotionEvent.append(paramShapeEffect.getY());
          paramMotionEvent.append("), mRubbishRect=");
          paramMotionEvent.append(this.e.toShortString());
          paramMotionEvent.append(", mDisplayRect=");
          paramMotionEvent.append(this.b.I.toShortString());
          AEQLog.a("DoodleLayout", paramMotionEvent.toString());
          if (this.e.contains(i + j, k + m))
          {
            DoodleLayout.a(this.b, true);
            this.c = true;
          }
          else
          {
            DoodleLayout.a(this.b, false);
            this.c = false;
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
    if (DoodleLayout.h(this.b))
    {
      Matrix localMatrix = this.a.y();
      paramShapeEffect = paramMotionEvent;
      if (localMatrix != null) {
        paramShapeEffect = a(paramMotionEvent, localMatrix);
      }
      if ((this.e != null) && ((this.b.p == null) || (this.b.p.b())))
      {
        int i = (int)paramShapeEffect.getX();
        int j = this.b.I.left;
        int k = (int)paramShapeEffect.getY();
        int m = this.b.I.top;
        if ((DoodleLayout.j(this.b)) && (this.e.contains(i + j, k + m)))
        {
          DoodleLayout.a(this.b, false);
          this.a.i().h();
        }
      }
      else if (paramShapeEffect.getPointerCount() == 1)
      {
        paramMotionEvent = this.e;
        if ((paramMotionEvent != null) && (paramMotionEvent.contains((int)paramShapeEffect.getX(), (int)paramShapeEffect.getY())) && (this.c))
        {
          DoodleLayout.a(this.b, false);
          this.a.i().h();
        }
      }
      paramMotionEvent = this.b;
      paramMotionEvent.setViewsInVisible(new View[] { paramMotionEvent.q });
      if (localMatrix != null) {
        paramShapeEffect.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.12
 * JD-Core Version:    0.7.0.1
 */