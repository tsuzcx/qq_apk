package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUIBase$2
  implements Runnable
{
  VideoLayerUIBase$2(VideoLayerUIBase paramVideoLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.Z != null) {
      try
      {
        String str = this.this$0.Z.k().s;
        this.this$0.Z.b(str);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.U, 2, "pauseVideo Runnable exception", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.2
 * JD-Core Version:    0.7.0.1
 */