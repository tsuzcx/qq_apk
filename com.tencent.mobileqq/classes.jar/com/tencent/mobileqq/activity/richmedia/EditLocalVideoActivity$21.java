package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.qphone.base.util.QLog;

class EditLocalVideoActivity$21
  implements Runnable
{
  EditLocalVideoActivity$21(EditLocalVideoActivity paramEditLocalVideoActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if ((EditLocalVideoActivity.a(this.this$0).isPlaying()) && (EditLocalVideoActivity.b(this.this$0))) {
        EditLocalVideoActivity.a(this.this$0).pause();
      }
      if (EditLocalVideoActivity.c(this.this$0) == 0) {
        EditLocalVideoActivity.a(this.this$0).setPlayDuration(this.a, this.b - this.a);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.w("EditLocalVideoActivity", 2, "Illegal state: onFramesClipChanged");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.21
 * JD-Core Version:    0.7.0.1
 */