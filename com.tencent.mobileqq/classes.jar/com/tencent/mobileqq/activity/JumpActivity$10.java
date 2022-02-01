package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Message;
import aucw;
import mqq.os.MqqHandler;

class JumpActivity$10
  implements Runnable
{
  JumpActivity$10(JumpActivity paramJumpActivity, aucw paramaucw, Intent paramIntent, int paramInt) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Aucw.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidContentIntent.getAction()))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = this.jdField_a_of_type_Int;
      localMessage.obj = this.jdField_a_of_type_AndroidContentIntent;
      this.this$0.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.10
 * JD-Core Version:    0.7.0.1
 */