package com.tencent.mobileqq.activity.photo;

import ajnr;
import ajpw;
import bfed;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(ajpw paramajpw, bfed parambfed, ajnr paramajnr, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bfed.c;
    this.jdField_a_of_type_Ajnr.a = false;
    this.jdField_a_of_type_Ajnr.b = 1;
    this.jdField_a_of_type_Ajnr.jdField_c_of_type_Boolean = false;
    this.this$0.initVerifyFlag(this.jdField_a_of_type_Ajnr);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_Ajnr.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Ajnr.b = 1;
      this.jdField_a_of_type_Ajnr.a = false;
      if (this.this$0.update2DB(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ajnr)) {
        ajpw.a(this.this$0, this.jdField_a_of_type_Ajnr);
      }
    }
    ajpw.a(this.this$0, null);
    ajpw.b(this.this$0, null);
    this.this$0.notifyUpdate(this.jdField_a_of_type_Ajnr, this.jdField_a_of_type_Bfed);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */