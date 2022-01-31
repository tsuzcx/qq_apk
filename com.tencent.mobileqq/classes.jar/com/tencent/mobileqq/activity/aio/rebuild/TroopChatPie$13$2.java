package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import aeje;
import mnf;
import mnk;
import mqq.os.MqqHandler;

public class TroopChatPie$13$2
  implements Runnable
{
  public TroopChatPie$13$2(aeje paramaeje) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Mnk != null) {
      this.a.a.jdField_a_of_type_Mnk.dismiss();
    }
    this.a.a.u(true);
    aejb.d(this.a.a).postDelayed(new TroopChatPie.13.2.1(this), 100L);
    if (!mnf.a(this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      aejb.e(this.a.a).postDelayed(new TroopChatPie.13.2.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.13.2
 * JD-Core Version:    0.7.0.1
 */