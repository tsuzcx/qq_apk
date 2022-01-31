package com.tencent.biz.qqstory.takevideo;

import uss;

public class EditPicSave$4
  implements Runnable
{
  public EditPicSave$4(uss paramuss) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    uss localuss = this.this$0;
    localuss.jdField_a_of_type_Int += this.this$0.b;
    if (this.this$0.jdField_a_of_type_Int > 99)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.4
 * JD-Core Version:    0.7.0.1
 */