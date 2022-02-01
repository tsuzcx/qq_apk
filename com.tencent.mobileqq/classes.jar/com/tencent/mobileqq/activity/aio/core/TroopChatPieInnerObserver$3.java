package com.tencent.mobileqq.activity.aio.core;

import agbv;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopChatPieInnerObserver$3
  implements Runnable
{
  public TroopChatPieInnerObserver$3(agbv paramagbv, long paramLong) {}
  
  public void run()
  {
    if ((agbv.a(this.this$0) != null) && (agbv.a(this.this$0).isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(agbv.a(this.this$0).c, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerObserver.3
 * JD-Core Version:    0.7.0.1
 */