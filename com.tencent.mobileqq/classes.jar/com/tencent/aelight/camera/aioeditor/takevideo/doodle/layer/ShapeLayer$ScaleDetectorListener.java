package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.widget.ScaleGestureDetector;
import com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener;

class ShapeLayer$ScaleDetectorListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private ShapeLayer$ScaleDetectorListener(ShapeLayer paramShapeLayer) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    EditPicRawImage localEditPicRawImage = ShapeLayer.a(this.a).a.a();
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return localEditPicRawImage != null;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    EditPicRawImage localEditPicRawImage = ShapeLayer.b(this.a).a.a();
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return localEditPicRawImage != null;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector = ShapeLayer.c(this.a).a.a();
    if (paramScaleGestureDetector != null) {
      paramScaleGestureDetector.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer.ScaleDetectorListener
 * JD-Core Version:    0.7.0.1
 */