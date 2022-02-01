package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;

class EditVideoDoodle$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EditVideoDoodle$4(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void onGlobalLayout()
  {
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(EditVideoDoodle.a(this.a));
    this.a.t.a(Message.obtain(null, 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.4
 * JD-Core Version:    0.7.0.1
 */