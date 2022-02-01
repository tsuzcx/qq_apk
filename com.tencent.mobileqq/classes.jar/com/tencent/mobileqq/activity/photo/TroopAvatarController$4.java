package com.tencent.mobileqq.activity.photo;

import akeh;
import akgn;
import bfuo;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(akgn paramakgn, bfuo parambfuo, akeh paramakeh, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bfuo.c;
    this.jdField_a_of_type_Akeh.a = false;
    this.jdField_a_of_type_Akeh.b = 1;
    this.jdField_a_of_type_Akeh.jdField_c_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Akeh);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Akeh.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Akeh.b = 1;
      this.jdField_a_of_type_Akeh.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Akeh)) {
        akgn.a(this.this$0, this.jdField_a_of_type_Akeh);
      }
    }
    akgn.a(this.this$0, null);
    akgn.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Akeh, this.jdField_a_of_type_Bfuo);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */