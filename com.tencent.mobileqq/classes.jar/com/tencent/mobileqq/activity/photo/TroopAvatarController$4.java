package com.tencent.mobileqq.activity.photo;

import aglg;
import agqh;
import bamm;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(agqh paramagqh, bamm parambamm, aglg paramaglg, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bamm.c;
    this.jdField_a_of_type_Aglg.a = false;
    this.jdField_a_of_type_Aglg.b = 1;
    this.jdField_a_of_type_Aglg.jdField_c_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Aglg);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Aglg.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aglg.b = 1;
      this.jdField_a_of_type_Aglg.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aglg)) {
        agqh.a(this.this$0, this.jdField_a_of_type_Aglg);
      }
    }
    agqh.a(this.this$0, null);
    agqh.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Aglg, this.jdField_a_of_type_Bamm);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */