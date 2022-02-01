package com.tencent.mobileqq.activity.aio.rebuild;

import ahgc;
import android.support.v4.app.FragmentActivity;
import bhar;
import mqq.os.MqqHandler;

public class GameRoomChatPie$16
  implements Runnable
{
  public GameRoomChatPie$16(ahgc paramahgc) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (this.this$0.mActivity.isFinishing()) {
        return;
      }
      this.this$0.a.a(this.this$0.getActivity(), this.this$0);
      ahgc.a(this.this$0).post(new GameRoomChatPie.16.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16
 * JD-Core Version:    0.7.0.1
 */