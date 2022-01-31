package com.tencent.mobileqq.activity;

import aamh;
import agxq;
import atok;
import com.tencent.mobileqq.app.QQAppInterface;

public class Conversation$1$3
  implements Runnable
{
  public Conversation$1$3(aamh paramaamh) {}
  
  public void run()
  {
    boolean bool3 = true;
    int i;
    boolean bool4;
    boolean bool1;
    if (this.a.a.jdField_a_of_type_Agxq.a(17) == 2)
    {
      i = 1;
      bool4 = atok.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool4) {
        break label122;
      }
      if (i != 0) {
        break label165;
      }
      atok.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        this.a.a.a(new Conversation.1.3.1(this, bool2, bool1));
        return;
        i = 0;
        break;
        label122:
        bool1 = atok.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break label69;
        bool2 = false;
        break label80;
      }
      label165:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.3
 * JD-Core Version:    0.7.0.1
 */