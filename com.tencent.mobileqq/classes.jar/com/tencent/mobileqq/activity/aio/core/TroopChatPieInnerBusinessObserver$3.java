package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopChatPieInnerBusinessObserver$3
  implements Runnable
{
  TroopChatPieInnerBusinessObserver$3(TroopChatPieInnerBusinessObserver paramTroopChatPieInnerBusinessObserver, long paramLong) {}
  
  public void run()
  {
    if ((TroopChatPieInnerBusinessObserver.a(this.this$0) != null) && (TroopChatPieInnerBusinessObserver.a(this.this$0).isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(TroopChatPieInnerBusinessObserver.a(this.this$0).d, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerBusinessObserver.3
 * JD-Core Version:    0.7.0.1
 */