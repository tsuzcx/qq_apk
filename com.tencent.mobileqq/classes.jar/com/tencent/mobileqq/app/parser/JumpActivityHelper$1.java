package com.tencent.mobileqq.app.parser;

import android.content.Intent;
import android.os.Message;
import aviq;
import com.tencent.mobileqq.activity.JumpActivity;
import mqq.os.MqqHandler;

public final class JumpActivityHelper$1
  implements Runnable
{
  public JumpActivityHelper$1(aviq paramaviq, Intent paramIntent, int paramInt, JumpActivity paramJumpActivity) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Aviq.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidContentIntent.getAction()))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = this.jdField_a_of_type_Int;
      localMessage.obj = this.jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */