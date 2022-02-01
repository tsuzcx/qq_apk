package com.tencent.aelight.camera.aeeditor.view.timebar;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;

class ScaleView$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  ScaleView$1(ScaleView paramScaleView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.a.a(paramScaleGestureDetector.getScaleFactor());
    if (ScaleView.a(this.a) != null) {
      ScaleView.a(this.a).a();
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.ScaleView.1
 * JD-Core Version:    0.7.0.1
 */