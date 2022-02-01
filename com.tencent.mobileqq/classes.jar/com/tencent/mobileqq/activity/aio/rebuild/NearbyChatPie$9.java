package com.tencent.mobileqq.activity.aio.rebuild;

import aimx;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import ayun;
import bdll;

public class NearbyChatPie$9
  implements Runnable
{
  public NearbyChatPie$9(aimx paramaimx) {}
  
  public void run()
  {
    String[] arrayOfString = ayun.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    bdll.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.S = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9
 * JD-Core Version:    0.7.0.1
 */