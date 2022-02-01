package com.tencent.av.ui;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.qphone.base.util.QLog;

public class VideoLayerUI$ScaleGestureListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public VideoLayerUI$ScaleGestureListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.U, 2, "onScale");
    }
    if (VideoLayerUI.e(this.a) < 0) {
      VideoLayerUI.a(this.a, (int)paramScaleGestureDetector.getFocusX());
    }
    if (VideoLayerUI.f(this.a) < 0) {
      VideoLayerUI.b(this.a, (int)paramScaleGestureDetector.getFocusY());
    }
    float f = paramScaleGestureDetector.getScaleFactor();
    this.a.ae[0].a(f, VideoLayerUI.e(this.a), VideoLayerUI.f(this.a));
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.U, 2, "onScaleEnd");
    }
    float f1 = this.a.ae[0].G();
    float f2 = this.a.ae[0].E();
    float f3 = this.a.ae[0].F();
    if (f1 < f2)
    {
      paramScaleGestureDetector = this.a;
      VideoLayerUI.a(paramScaleGestureDetector, paramScaleGestureDetector.ae[0], f2 / f1, 60L);
      return;
    }
    if (f1 > f3)
    {
      paramScaleGestureDetector = this.a;
      VideoLayerUI.a(paramScaleGestureDetector, paramScaleGestureDetector.ae[0], f3 / f1, 60L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.ScaleGestureListener
 * JD-Core Version:    0.7.0.1
 */