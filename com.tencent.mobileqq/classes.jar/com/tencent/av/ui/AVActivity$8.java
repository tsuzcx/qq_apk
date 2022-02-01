package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import lcb;
import lff;

class AVActivity$8
  implements Runnable
{
  AVActivity$8(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.b("BEAUTY_SKIN") > 0))
    {
      lff locallff = lcb.a().a();
      if (locallff != null) {
        locallff.u = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.8
 * JD-Core Version:    0.7.0.1
 */