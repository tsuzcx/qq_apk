package com.tencent.mobileqq.activity.aio.rebuild;

import agqq;
import android.support.v4.app.FragmentActivity;
import bemq;
import mqq.os.MqqHandler;

public class GameRoomChatPie$16
  implements Runnable
{
  public GameRoomChatPie$16(agqq paramagqq) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        return;
      }
      this.this$0.jdField_a_of_type_Bemq.a(this.this$0.a(), this.this$0);
      agqq.a(this.this$0).post(new GameRoomChatPie.16.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16
 * JD-Core Version:    0.7.0.1
 */