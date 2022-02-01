package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;

class DoodleLayout$ShapeLayerTouchListener
  implements BaseLayer.OnLayerTouchListener<ShapeLayer>
{
  int a;
  int b;
  long c;
  
  private DoodleLayout$ShapeLayerTouchListener(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.d.setState(10);
    if (DoodleLayout.s(this.d) > System.currentTimeMillis())
    {
      this.d.a(10, Boolean.valueOf(false));
    }
    else
    {
      this.d.a(10, Boolean.valueOf(true));
      if (DoodleLayout.n(this.d).getVisibility() == 0) {
        DoodleLayout.a(this.d, false, true);
      }
    }
    DoodleLayout.k(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("Personality", 2, "LineLayer draw move hide");
    }
  }
  
  private void b()
  {
    if (this.d.C == 10)
    {
      this.d.a(9, Boolean.valueOf(true));
      this.d.setState(9);
      DoodleLayout.b(this.d);
      DoodleLayout.a(this.d, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "LineLayer draw up show");
      }
    }
    else if (this.d.C == 9)
    {
      this.d.a(9, Boolean.valueOf(false));
      this.d.setState(9);
      DoodleLayout.b(this.d);
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "LineLayer draw up show");
      }
    }
  }
  
  public boolean a(ShapeLayer paramShapeLayer, MotionEvent paramMotionEvent)
  {
    int i = Math.round(paramMotionEvent.getY());
    int j = Math.round(paramMotionEvent.getX());
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            return false;
          }
        }
        else
        {
          if (((Math.abs(j - this.a) >= 3) || (Math.abs(i - this.b) >= 3)) && (this.d.C != 11) && (this.d.C != 10)) {
            if (!paramShapeLayer.h()) {
              a();
            } else if (4 != this.d.C) {
              DoodleLayout.a(this.d, 4);
            }
          }
          if (DoodleLayout.r(this.d).getVisibility() != 0) {
            break label296;
          }
          DoodleLayout.a(this.d);
          return false;
        }
      }
      if (paramShapeLayer.d())
      {
        DoodleLayout.a(this.d, paramShapeLayer.i().i());
        if (this.d.C == 10) {
          this.d.setState(9);
        }
        DoodleLayout.a(this.d, 12);
        return false;
      }
      DoodleLayout.a(this.d);
      if (paramShapeLayer.h())
      {
        AEQLog.b("DoodleLayout", "LineLayer--onLayerTouch--ACTION_UP--is passive activation");
        this.d.n();
        DoodleLayout.a(this.d, 0);
        return false;
      }
      b();
      return false;
    }
    else
    {
      if (paramShapeLayer.h())
      {
        AEQLog.a("DoodleLayout", "LineLayer--onLayerTouch--ACTION_DOWN--is passive activation");
        return false;
      }
      this.a = Math.round(paramMotionEvent.getX());
      this.b = Math.round(paramMotionEvent.getY());
      this.c = System.currentTimeMillis();
    }
    label296:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.ShapeLayerTouchListener
 * JD-Core Version:    0.7.0.1
 */