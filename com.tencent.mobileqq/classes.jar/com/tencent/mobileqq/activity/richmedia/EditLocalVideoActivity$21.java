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
      if ((EditLocalVideoActivity.q(this.this$0).isPlaying()) && (EditLocalVideoActivity.t(this.this$0))) {
        EditLocalVideoActivity.q(this.this$0).pause();
      }
      if (EditLocalVideoActivity.u(this.this$0) != 0) {
        break label75;
      }
      EditLocalVideoActivity.q(this.this$0).setPlayDuration(this.a, this.b - this.a);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label67:
      label75:
      break label67;
    }
    QLog.w("EditLocalVideoActivity", 2, "Illegal state: onFramesClipChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.21
 * JD-Core Version:    0.7.0.1
 */