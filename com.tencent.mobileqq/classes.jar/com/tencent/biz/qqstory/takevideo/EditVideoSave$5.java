package com.tencent.biz.qqstory.takevideo;

import yqp;
import yuv;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(yuv paramyuv) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      yqp.b("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.this$0.jdField_a_of_type_Boolean);
      return;
    }
    yuv localyuv;
    if (this.this$0.jdField_a_of_type_Int < 50) {
      localyuv = this.this$0;
    }
    for (localyuv.jdField_a_of_type_Int += this.this$0.b; this.this$0.jdField_a_of_type_Int > 99; localyuv.jdField_a_of_type_Int += 1)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
      localyuv = this.this$0;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */