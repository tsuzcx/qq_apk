package com.tencent.mobileqq.activity.aio.rebuild;

import aetx;
import mqq.os.MqqHandler;
import myb;
import myg;

public class TroopChatPie$12$2
  implements Runnable
{
  public TroopChatPie$12$2(aetx paramaetx) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Myg != null) {
      this.a.a.jdField_a_of_type_Myg.dismiss();
    }
    this.a.a.u(true);
    TroopChatPie.d(this.a.a).postDelayed(new TroopChatPie.12.2.1(this), 100L);
    if (!myb.a(this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      TroopChatPie.e(this.a.a).postDelayed(new TroopChatPie.12.2.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.2
 * JD-Core Version:    0.7.0.1
 */