package com.tencent.mobileqq.activity.aio.core;

import afjq;
import mqq.os.MqqHandler;
import nmy;
import nnd;

public class TroopChatPie$12$1
  implements Runnable
{
  public TroopChatPie$12$1(afjq paramafjq) {}
  
  public void run()
  {
    if (this.a.a.a != null) {
      this.a.a.a.dismiss();
    }
    this.a.a.b(true);
    this.a.a.uiHandler.postDelayed(new TroopChatPie.12.1.1(this), 100L);
    if (!nmy.a(this.a.a.mActivity, this.a.a.app)) {
      this.a.a.uiHandler.postDelayed(new TroopChatPie.12.1.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.12.1
 * JD-Core Version:    0.7.0.1
 */