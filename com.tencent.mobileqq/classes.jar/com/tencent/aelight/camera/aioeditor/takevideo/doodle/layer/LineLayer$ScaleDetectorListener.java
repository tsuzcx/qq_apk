package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.widget.ScaleGestureDetector;
import com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener;

class LineLayer$ScaleDetectorListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private LineLayer$ScaleDetectorListener(LineLayer paramLineLayer) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    EditPicRawImage localEditPicRawImage = LineLayer.a(this.a).l.getEditPicRawImage();
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return localEditPicRawImage != null;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    EditPicRawImage localEditPicRawImage = LineLayer.b(this.a).l.getEditPicRawImage();
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return localEditPicRawImage != null;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector = LineLayer.c(this.a).l.getEditPicRawImage();
    if (paramScaleGestureDetector != null) {
      paramScaleGestureDetector.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer.ScaleDetectorListener
 * JD-Core Version:    0.7.0.1
 */