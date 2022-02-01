package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class VideoLayerUIBase$1
  implements Runnable
{
  VideoLayerUIBase$1(VideoLayerUIBase paramVideoLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      Object localObject = this.this$0.a.a();
      if ((((SessionInfo)localObject).j == 1011) && (((SessionInfo)localObject).I != 3)) {}
      localObject = ((SessionInfo)localObject).d;
      this.this$0.a.c((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.1
 * JD-Core Version:    0.7.0.1
 */