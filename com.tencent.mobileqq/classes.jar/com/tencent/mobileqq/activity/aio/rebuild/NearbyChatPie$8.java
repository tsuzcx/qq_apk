package com.tencent.mobileqq.activity.aio.rebuild;

import aego;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import atcl;
import awqx;

public class NearbyChatPie$8
  implements Runnable
{
  public NearbyChatPie$8(aego paramaego) {}
  
  public void run()
  {
    String[] arrayOfString = atcl.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.T = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */