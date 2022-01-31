package com.tencent.mobileqq.activity.aio.rebuild;

import aerl;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import atyp;
import axqw;

public class NearbyChatPie$8
  implements Runnable
{
  public NearbyChatPie$8(aerl paramaerl) {}
  
  public void run()
  {
    String[] arrayOfString = atyp.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    axqw.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.T = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */