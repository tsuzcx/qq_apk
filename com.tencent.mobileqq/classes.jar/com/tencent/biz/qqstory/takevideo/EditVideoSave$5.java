package com.tencent.biz.qqstory.takevideo;

import yuk;
import yyq;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(yyq paramyyq) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      yuk.b("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.this$0.jdField_a_of_type_Boolean);
      return;
    }
    yyq localyyq;
    if (this.this$0.jdField_a_of_type_Int < 50) {
      localyyq = this.this$0;
    }
    for (localyyq.jdField_a_of_type_Int += this.this$0.b; this.this$0.jdField_a_of_type_Int > 99; localyyq.jdField_a_of_type_Int += 1)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
      localyyq = this.this$0;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */