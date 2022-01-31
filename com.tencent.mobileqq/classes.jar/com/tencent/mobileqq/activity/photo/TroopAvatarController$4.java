package com.tencent.mobileqq.activity.photo;

import ainn;
import aipt;
import bcpw;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(aipt paramaipt, bcpw parambcpw, ainn paramainn, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bcpw.c;
    this.jdField_a_of_type_Ainn.a = false;
    this.jdField_a_of_type_Ainn.b = 1;
    this.jdField_a_of_type_Ainn.jdField_c_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Ainn);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Ainn.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Ainn.b = 1;
      this.jdField_a_of_type_Ainn.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ainn)) {
        aipt.a(this.this$0, this.jdField_a_of_type_Ainn);
      }
    }
    aipt.a(this.this$0, null);
    aipt.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Ainn, this.jdField_a_of_type_Bcpw);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */