package com.tencent.biz.pubaccount.util;

import axqw;
import com.tencent.mobileqq.app.QQAppInterface;
import sbc;

public final class PublicAccountUtil$23
  implements Runnable
{
  public PublicAccountUtil$23(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    String str = "0X80067EA";
    sbc localsbc = sbc.a();
    int i = localsbc.b();
    int j = localsbc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (j == 1) {
      str = "0X80067E8";
    }
    for (;;)
    {
      long l = localsbc.a();
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "", str, str, 0, 0, "" + l, "" + j, "" + i, String.valueOf(this.jdField_a_of_type_Int + 1));
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "auth_entry", "clk_msg", 0, 0, "", "", "", "");
      return;
      if (j == 2) {
        str = "0X80067E9";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.23
 * JD-Core Version:    0.7.0.1
 */