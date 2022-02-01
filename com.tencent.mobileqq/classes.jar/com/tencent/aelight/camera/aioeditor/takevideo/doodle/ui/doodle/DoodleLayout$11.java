package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;

class DoodleLayout$11
  implements FaceLayer.LayerEventListener
{
  DoodleLayout$11(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.y != null) {
      this.a.y.a(1, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (DoodleLayout.e(this.a)) {
      return;
    }
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(FaceLayer.FaceItem paramFaceItem)
  {
    if (DoodleLayout.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onEditFaceItem mIsRecording");
      }
      return false;
    }
    if ((DoodleLayout.e(this.a)) && (!DoodleLayout.f(this.a))) {
      return false;
    }
    if (this.a.w != null)
    {
      this.a.w.setVisibility(0);
      DoodleLayout.g(this.a);
      if (paramFaceItem.y == 3) {
        this.a.post(new DoodleLayout.11.1(this));
      }
      this.a.w.a.a(paramFaceItem);
      paramFaceItem.M = true;
      paramFaceItem.U.lockData(this.a.w.b() ^ true);
      if ((paramFaceItem.y == 1) || (paramFaceItem.y == 3)) {
        paramFaceItem.l.setCallback(this.a.w);
      }
      this.a.w.requestLayout();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.11
 * JD-Core Version:    0.7.0.1
 */