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
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onScale");
    }
    if (VideoLayerUI.c(this.a) < 0) {
      VideoLayerUI.a(this.a, (int)paramScaleGestureDetector.getFocusX());
    }
    if (VideoLayerUI.d(this.a) < 0) {
      VideoLayerUI.b(this.a, (int)paramScaleGestureDetector.getFocusY());
    }
    float f = paramScaleGestureDetector.getScaleFactor();
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, VideoLayerUI.c(this.a), VideoLayerUI.d(this.a));
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onScaleEnd");
    }
    float f1 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
    float f2 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
    float f3 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b();
    if (f1 < f2)
    {
      paramScaleGestureDetector = this.a;
      VideoLayerUI.a(paramScaleGestureDetector, paramScaleGestureDetector.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0], f2 / f1, 60L);
      return;
    }
    if (f1 > f3)
    {
      paramScaleGestureDetector = this.a;
      VideoLayerUI.a(paramScaleGestureDetector, paramScaleGestureDetector.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0], f3 / f1, 60L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.ScaleGestureListener
 * JD-Core Version:    0.7.0.1
 */