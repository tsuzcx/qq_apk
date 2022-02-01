package com.tencent.av.ui;

import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

class AVActivity$9
  implements Runnable
{
  AVActivity$9(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.b("BEAUTY_SKIN") > 0))
    {
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo != null) {
        localSessionInfo.u = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.9
 * JD-Core Version:    0.7.0.1
 */