package com.tencent.mobileqq.activity.aio.rebuild;

import aiay;
import android.support.v4.app.FragmentActivity;
import bhtu;
import mqq.os.MqqHandler;

public class GameRoomChatPie$16
  implements Runnable
{
  public GameRoomChatPie$16(aiay paramaiay) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        return;
      }
      this.this$0.jdField_a_of_type_Bhtu.a(this.this$0.a(), this.this$0);
      aiay.a(this.this$0).post(new GameRoomChatPie.16.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16
 * JD-Core Version:    0.7.0.1
 */