package com.tencent.av.ui;

import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

class AVActivity$10
  implements Runnable
{
  AVActivity$10(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if ((this.this$0.H != null) && (this.this$0.H.n("BEAUTY_SKIN") > 0))
    {
      SessionInfo localSessionInfo = SessionMgr.a().b();
      if (localSessionInfo != null) {
        localSessionInfo.S = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.10
 * JD-Core Version:    0.7.0.1
 */