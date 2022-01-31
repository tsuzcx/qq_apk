package com.tencent.mobileqq.activity.photo;

import agle;
import agqf;
import bana;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(agqf paramagqf, bana parambana, agle paramagle, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bana.c;
    this.jdField_a_of_type_Agle.a = false;
    this.jdField_a_of_type_Agle.b = 1;
    this.jdField_a_of_type_Agle.jdField_c_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Agle);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Agle.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Agle.b = 1;
      this.jdField_a_of_type_Agle.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Agle)) {
        agqf.a(this.this$0, this.jdField_a_of_type_Agle);
      }
    }
    agqf.a(this.this$0, null);
    agqf.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Agle, this.jdField_a_of_type_Bana);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */