package com.tencent.mobileqq.activity;

import adws;
import adwy;
import adwz;
import aqwn;
import bdin;
import bdjz;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class SendMultiPictureHelper$6$1
  implements Runnable
{
  public SendMultiPictureHelper$6$1(adwy paramadwy) {}
  
  public void run()
  {
    if (bdin.d(this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      return;
    }
    this.a.a.jdField_d_of_type_Boolean = true;
    adws.a(this.a.a);
    this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.a.a.jdField_a_of_type_Aqru);
    int i = 1;
    while (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.a.a.a((adwz)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i), this.a.a.c, this.a.a.jdField_b_of_type_JavaLangString, this.a.a.jdField_a_of_type_JavaLangString);
      this.a.a.jdField_a_of_type_Bdjz.setMessage(String.format(this.a.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.a.jdField_a_of_type_Int + i), Integer.valueOf(this.a.a.jdField_b_of_type_Int), Integer.valueOf(0) }));
      i += 1;
    }
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.6.1
 * JD-Core Version:    0.7.0.1
 */