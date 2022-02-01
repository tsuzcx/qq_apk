package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class VideoLayerUIBase$1
  implements Runnable
{
  VideoLayerUIBase$1(VideoLayerUIBase paramVideoLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.Z != null)
    {
      Object localObject = this.this$0.Z.k();
      if (((SessionInfo)localObject).p == 1011) {
        int i = ((SessionInfo)localObject).aY;
      }
      localObject = ((SessionInfo)localObject).s;
      this.this$0.Z.c((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.1
 * JD-Core Version:    0.7.0.1
 */