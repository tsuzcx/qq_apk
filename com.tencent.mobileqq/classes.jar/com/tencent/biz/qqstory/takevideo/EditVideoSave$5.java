package com.tencent.biz.qqstory.takevideo;

import ykq;
import yot;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(yot paramyot) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      ykq.b("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.this$0.jdField_a_of_type_Boolean);
      return;
    }
    yot localyot;
    if (this.this$0.jdField_a_of_type_Int < 50) {
      localyot = this.this$0;
    }
    for (localyot.jdField_a_of_type_Int += this.this$0.b; this.this$0.jdField_a_of_type_Int > 99; localyot.jdField_a_of_type_Int += 1)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
      localyot = this.this$0;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */