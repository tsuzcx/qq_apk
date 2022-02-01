package com.tencent.mobileqq.activity.photo;

import akps;
import akry;
import bgup;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(akry paramakry, bgup parambgup, akps paramakps, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bgup.c;
    this.jdField_a_of_type_Akps.a = false;
    this.jdField_a_of_type_Akps.b = 1;
    this.jdField_a_of_type_Akps.jdField_c_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Akps);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Akps.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Akps.b = 1;
      this.jdField_a_of_type_Akps.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Akps)) {
        akry.a(this.this$0, this.jdField_a_of_type_Akps);
      }
    }
    akry.a(this.this$0, null);
    akry.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Akps, this.jdField_a_of_type_Bgup);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */