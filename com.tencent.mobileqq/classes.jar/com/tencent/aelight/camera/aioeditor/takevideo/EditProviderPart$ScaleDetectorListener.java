package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.widget.ScaleGestureDetector;
import com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener;

class EditProviderPart$ScaleDetectorListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private EditProviderPart$ScaleDetectorListener(EditProviderPart paramEditProviderPart) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    EditPicRawImage localEditPicRawImage = this.a.a.a;
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return localEditPicRawImage != null;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    EditPicRawImage localEditPicRawImage = this.a.a.a;
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return localEditPicRawImage != null;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector = this.a.a.a;
    if (paramScaleGestureDetector != null) {
      paramScaleGestureDetector.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.ScaleDetectorListener
 * JD-Core Version:    0.7.0.1
 */