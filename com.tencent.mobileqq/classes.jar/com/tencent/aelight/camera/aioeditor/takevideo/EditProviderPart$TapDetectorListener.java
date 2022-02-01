package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;

class EditProviderPart$TapDetectorListener
  extends GestureDetector.SimpleOnGestureListener
{
  private boolean b = false;
  
  private EditProviderPart$TapDetectorListener(EditProviderPart paramEditProviderPart) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (EditProviderPart.a(this.a).s())
    {
      paramMotionEvent = (EditDoodleExport)this.a.b(EditDoodleExport.class);
      if (paramMotionEvent != null) {
        paramMotionEvent.c();
      }
    }
    try
    {
      boolean bool = this.a.t.j();
      if (!bool) {
        return false;
      }
      int i = this.a.t.C;
      if (i == 0)
      {
        this.b = true;
        this.a.t.d(11);
        return true;
      }
      if ((this.b) && (i == 11))
      {
        this.b = false;
        this.a.t.d(0);
        return true;
      }
      return false;
    }
    catch (RuntimeException paramMotionEvent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.TapDetectorListener
 * JD-Core Version:    0.7.0.1
 */