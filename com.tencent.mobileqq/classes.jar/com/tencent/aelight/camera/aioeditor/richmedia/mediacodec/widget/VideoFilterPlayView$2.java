package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.app.Activity;
import android.os.Build.VERSION;

class VideoFilterPlayView$2
  implements Runnable
{
  VideoFilterPlayView$2(VideoFilterPlayView paramVideoFilterPlayView) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.getContext();
    if ((localActivity != null) && ((Build.VERSION.SDK_INT <= 16) || (!localActivity.isDestroyed())))
    {
      if (localActivity.isFinishing()) {
        return;
      }
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView.2
 * JD-Core Version:    0.7.0.1
 */