package com.tencent.mobileqq.activity.aio.rebuild;

import agsy;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import avue;
import azqs;

public class NearbyChatPie$8
  implements Runnable
{
  public NearbyChatPie$8(agsy paramagsy) {}
  
  public void run()
  {
    String[] arrayOfString = avue.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    azqs.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.T = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */