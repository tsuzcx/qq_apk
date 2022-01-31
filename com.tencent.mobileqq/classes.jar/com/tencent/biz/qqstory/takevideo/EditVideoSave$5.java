package com.tencent.biz.qqstory.takevideo;

import wsv;
import wxb;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(wxb paramwxb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      wsv.b("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.this$0.jdField_a_of_type_Boolean);
      return;
    }
    wxb localwxb;
    if (this.this$0.jdField_a_of_type_Int < 50) {
      localwxb = this.this$0;
    }
    for (localwxb.jdField_a_of_type_Int += this.this$0.b; this.this$0.jdField_a_of_type_Int > 99; localwxb.jdField_a_of_type_Int += 1)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
      localwxb = this.this$0;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */