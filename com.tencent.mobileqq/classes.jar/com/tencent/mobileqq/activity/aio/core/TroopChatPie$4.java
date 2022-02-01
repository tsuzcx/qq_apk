package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicPreDownload;

class TroopChatPie$4
  implements Runnable
{
  TroopChatPie$4(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.ah != null)
    {
      String str = this.this$0.ah.b;
      ((IPicPreDownload)this.this$0.d.getRuntimeService(IPicPreDownload.class, "")).increaseTroopCountWhenEnterAIO(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.4
 * JD-Core Version:    0.7.0.1
 */