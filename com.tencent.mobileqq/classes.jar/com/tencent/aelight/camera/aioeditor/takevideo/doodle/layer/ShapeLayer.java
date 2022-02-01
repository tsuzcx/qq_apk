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
  public int a = 9;
  private final ShapeOperator b = new ShapeOperator(this.y);
  private boolean c = false;
  private Matrix d = new Matrix();
  private float[] e = new float[2];
  private ScaleGestureDetector f = new ScaleGestureDetector(this.y, new ShapeLayer.ScaleDetectorListener(this, null));
  private int g = -1;
  private int h = 1;
  
  public ShapeLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return this.f.onTouchEvent(paramMotionEvent);
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.g = paramMotionEvent.getPointerId(0);
    }
    if (this.g != paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())) {
      return false;
    }
    if (i == 0)
    {
      VideoEditReport.a("0X80076BE");
      VideoEditReport.b("0X80075CB");
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.e[0] = paramMotionEvent.getX();
    this.e[1] = paramMotionEvent.getY();
    this.d.mapPoints(this.e);
    float[] arrayOfFloat = this.e;
    localMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    if ((i == 6) && (this.g == paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()))) {
      localMotionEvent.setAction(1);
    }
    boolean bool = this.b.a(localMotionEvent);
    localMotionEvent.recycle();
    return bool;
  }
  
  public String a()
  {
    return "ShapeLayer";
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
    this.a = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.b.a(paramInt1, paramInt2);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.L);
    this.b.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    this.b.b(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    this.L.invert(this.d);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsPassiveActivation: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("ShapeLayer", localStringBuilder.toString());
    this.c = paramBoolean;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((this.z != null) && (this.z.l.e()))
    {
      int j = paramMotionEvent.getActionMasked();
      boolean bool2 = false;
      boolean bool1 = false;
      boolean bool3;
      if (j == 0)
      {
        this.h = 1;
        bool3 = e(paramMotionEvent);
        bool2 = c(paramMotionEvent);
        if ((bool3) || (bool2)) {
          bool1 = true;
        }
        return bool1;
      }
      if (this.h == 1)
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
          this.h = 3;
          e(localMotionEvent);
        }
        else if (i == 0)
        {
          AEQLog.b("ShapeLayer", "recognize this gesture as DRAW");
          this.h = 2;
          c(localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      int i = this.h;
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
        this.h = 1;
      }
      return bool1;
    }
    return e(paramMotionEvent);
  }
  
  public void aw_()
  {
    super.aw_();
    if ((!h()) && (this.b.c())) {
      this.z.invalidate();
    }
  }
  
  public void b()
  {
    this.b.g();
    SLog.b("ShapeLayer", "clear over.");
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.J);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.e[0] = paramMotionEvent.getX();
    this.e[1] = paramMotionEvent.getY();
    this.d.mapPoints(this.e);
    paramMotionEvent = this.e;
    localMotionEvent.setLocation(paramMotionEvent[0], paramMotionEvent[1]);
    boolean bool = this.b.b(localMotionEvent);
    localMotionEvent.recycle();
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("accept touch event: ");
    paramMotionEvent.append(bool);
    AEQLog.b("ShapeLayer", paramMotionEvent.toString());
    return bool;
  }
  
  public boolean c()
  {
    return this.b.e();
  }
  
  public boolean d()
  {
    return this.b.i() != null;
  }
  
  public boolean h()
  {
    return this.c;
  }
  
  public ShapeOperator i()
  {
    return this.b;
  }
  
  public int j()
  {
    return this.b.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer
 * JD-Core Version:    0.7.0.1
 */