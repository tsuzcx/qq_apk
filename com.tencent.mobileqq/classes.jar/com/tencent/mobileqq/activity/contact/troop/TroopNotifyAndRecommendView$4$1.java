package com.tencent.mobileqq.activity.contact.troop;

import afna;
import afoa;
import ajsf;
import akpc;
import aydb;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopNotifyAndRecommendView$4$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$4$1(afoa paramafoa) {}
  
  public void run()
  {
    this.a.a.jdField_a_of_type_Afna.a(this.a.a.jdField_a_of_type_JavaUtilList);
    this.a.a.jdField_a_of_type_Afna.a = aydb.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.a.a.jdField_a_of_type_Afna.notifyDataSetChanged();
    this.a.a.jdField_a_of_type_Akfd.c = aydb.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.a.a.b) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(ajsf.W, 9000, 0 - aydb.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.4.1
 * JD-Core Version:    0.7.0.1
 */