package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class VideoNetStateBar$GroupNetLevelRunnable
  implements Runnable
{
  VideoNetStateBar$GroupNetLevelRunnable(VideoNetStateBar paramVideoNetStateBar) {}
  
  public void run()
  {
    if (this.this$0.g == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, "mVideoController == null");
      }
      return;
    }
    int i = this.this$0.g.N();
    Object localObject = this.this$0;
    ((VideoNetStateBar)localObject).t = true;
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i == 3) {
          ((VideoNetStateBar)localObject).q = 1;
        }
      }
      else {
        ((VideoNetStateBar)localObject).q = 2;
      }
    }
    else {
      this.this$0.q = 3;
    }
    this.this$0.p = 1;
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, String.format("getGAudioNetLevel[%s], mCurNetLevel[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.this$0.q) }));
    }
    localObject = this.this$0.g;
    if ((this.this$0.j != null) && (localObject != null) && (((VideoController)localObject).aH() != null)) {
      ((VideoController)localObject).aH().postDelayed(this.this$0.j, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar.GroupNetLevelRunnable
 * JD-Core Version:    0.7.0.1
 */