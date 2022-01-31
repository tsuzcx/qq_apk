package com.tencent.mobileqq.activity.photo;

import afzi;
import agej;
import azli;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(agej paramagej, azli paramazli, afzi paramafzi, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Azli.c;
    this.jdField_a_of_type_Afzi.a = false;
    this.jdField_a_of_type_Afzi.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Afzi.jdField_b_of_type_Boolean = false;
    this.this$0.c(this.jdField_a_of_type_Afzi);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Afzi.c = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Afzi.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Afzi.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Afzi)) {
        agej.a(this.this$0, this.jdField_a_of_type_Afzi);
      }
    }
    agej.a(this.this$0, null);
    agej.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_Afzi, this.jdField_a_of_type_Azli);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */