package com.tencent.mobileqq.activity.photo;

import aiiy;
import aile;
import bcln;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(aile paramaile, bcln parambcln, aiiy paramaiiy, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bcln.c;
    this.jdField_a_of_type_Aiiy.a = false;
    this.jdField_a_of_type_Aiiy.b = 1;
    this.jdField_a_of_type_Aiiy.jdField_c_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Aiiy);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Aiiy.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aiiy.b = 1;
      this.jdField_a_of_type_Aiiy.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aiiy)) {
        aile.a(this.this$0, this.jdField_a_of_type_Aiiy);
      }
    }
    aile.a(this.this$0, null);
    aile.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Aiiy, this.jdField_a_of_type_Bcln);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */