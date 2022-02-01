package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.qphone.base.util.QLog;

class DoodleLayout$LineLayerTouchListener
  implements BaseLayer.OnLayerTouchListener<LineLayer>
{
  int a;
  int b;
  long c;
  
  private DoodleLayout$LineLayerTouchListener(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.d.setState(5);
    if (DoodleLayout.s(this.d) > System.currentTimeMillis())
    {
      this.d.a(5, Boolean.valueOf(false));
    }
    else
    {
      this.d.a(5, Boolean.valueOf(true));
      a(false, true);
    }
    DoodleLayout.m(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("Personality", 2, "LineLayer draw move hide");
    }
  }
  
  private void a(LineLayer paramLineLayer, int paramInt1, int paramInt2)
  {
    if (paramLineLayer.b.c() > 0)
    {
      this.d.s.setUndoViewEnable(true);
      DoodleLayout.t(this.d).setUndoEnabled(true);
    }
    if (this.d.C == 5)
    {
      DoodleLayout.a(this.d, 2);
      this.d.setState(2);
      DoodleLayout.o(this.d);
      a(true, true);
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "LineLayer draw up show");
      }
    }
    else if ((Math.abs(paramInt2 - this.a) < 3) && (Math.abs(paramInt1 - this.b) < 3))
    {
      if (this.d.C == 6)
      {
        this.d.a(2, Boolean.valueOf(false));
        this.d.setState(2);
        DoodleLayout.o(this.d);
        a(true, false);
        if (QLog.isColorLevel()) {
          QLog.d("Personality", 2, "LineLayer tap up show");
        }
      }
      else
      {
        VideoEditReport.b("0X80080E5", VideoEditReport.c);
        if (!paramLineLayer.d())
        {
          this.d.setState(6);
          DoodleLayout.a(this.d, 6);
          DoodleLayout.m(this.d);
          a(false, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Personality", 2, "LineLayer tap up hide");
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (this.d.e()) {
      localObject1 = DoodleLayout.t(this.d);
    } else {
      localObject1 = this.d.s;
    }
    Object localObject2 = this.d;
    long l1 = System.currentTimeMillis();
    long l2 = 500;
    DoodleLayout.a((DoodleLayout)localObject2, l1 + l2);
    if (paramBoolean2)
    {
      localObject2 = this.d;
      DoodleLayout.a((DoodleLayout)localObject2, DoodleLayout.s((DoodleLayout)localObject2) + l2);
    }
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setDuration(l2);
    ((AlphaAnimation)localObject2).setFillAfter(true);
    ((AlphaAnimation)localObject2).setAnimationListener(new DoodleLayout.LineLayerTouchListener.1(this, (View)localObject1));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(l2);
    if (paramBoolean2) {
      localAlphaAnimation.setStartOffset(l2);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new DoodleLayout.LineLayerTouchListener.2(this, (View)localObject1));
    if (paramBoolean1) {
      localObject2 = localAlphaAnimation;
    }
    ((View)localObject1).startAnimation((Animation)localObject2);
    if (localObject1 == this.d.s) {
      this.d.s.setAnimationEndTime(DoodleLayout.s(this.d));
    }
  }
  
  public boolean a(LineLayer paramLineLayer, MotionEvent paramMotionEvent)
  {
    if (!this.d.e()) {
      DoodleLayout.a(this.d, paramLineLayer);
    }
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
          if (((Math.abs(j - this.a) < 3) && (Math.abs(i - this.b) < 3)) || (this.d.C == 6) || (this.d.C == 5)) {
            break label236;
          }
          if (!paramLineLayer.i())
          {
            a();
            return false;
          }
          if (4 == this.d.C) {
            break label236;
          }
          DoodleLayout.a(this.d, 4);
          return false;
        }
      }
      if (paramLineLayer.i())
      {
        AEQLog.b("DoodleLayout", "LineLayer--onLayerTouch--ACTION_UP--is passive activation");
        this.d.n();
        DoodleLayout.a(this.d, 0);
        return false;
      }
      a(paramLineLayer, i, j);
      return false;
    }
    else
    {
      if (paramLineLayer.i())
      {
        AEQLog.a("DoodleLayout", "LineLayer--onLayerTouch--ACTION_DOWN--is passive activation");
        return false;
      }
      this.a = Math.round(paramMotionEvent.getX());
      this.b = Math.round(paramMotionEvent.getY());
      this.c = System.currentTimeMillis();
    }
    label236:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.LineLayerTouchListener
 * JD-Core Version:    0.7.0.1
 */