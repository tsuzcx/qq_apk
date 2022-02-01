package com.tencent.mobileqq.activity.home;

import ajdm;
import akho;
import aych;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$UICallBack$7
  implements Runnable
{
  public Conversation$UICallBack$7(ajdm paramajdm) {}
  
  public void run()
  {
    boolean bool3 = true;
    int i;
    boolean bool4;
    boolean bool1;
    if (this.a.a.jdField_a_of_type_Akho.a(20) == 2)
    {
      i = 1;
      bool4 = aych.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool4) {
        break label122;
      }
      if (i != 0) {
        break label165;
      }
      aych.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool1 = false;
    }
    for (;;)
    {
      label69:
      boolean bool2;
      if ((bool4) && (i == 0))
      {
        bool2 = true;
        label80:
        if ((bool4) || (!bool1) || (i == 0)) {
          break label160;
        }
      }
      label160:
      for (bool1 = bool3;; bool1 = false)
      {
        this.a.a.b(new Conversation.UICallBack.7.1(this, bool2, bool1));
        return;
        i = 0;
        break;
        label122:
        bool1 = aych.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break label69;
        bool2 = false;
        break label80;
      }
      label165:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.7
 * JD-Core Version:    0.7.0.1
 */