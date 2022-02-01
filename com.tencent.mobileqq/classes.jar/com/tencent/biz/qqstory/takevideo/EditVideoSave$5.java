package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;

class EditVideoSave$5
  implements Runnable
{
  EditVideoSave$5(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      SLog.b("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.this$0.jdField_a_of_type_Boolean);
      return;
    }
    EditVideoSave localEditVideoSave;
    if (this.this$0.jdField_a_of_type_Int < 50) {
      localEditVideoSave = this.this$0;
    }
    for (localEditVideoSave.jdField_a_of_type_Int += this.this$0.b; this.this$0.jdField_a_of_type_Int > 99; localEditVideoSave.jdField_a_of_type_Int += 1)
    {
      this.this$0.jdField_a_of_type_Int = 99;
      this.this$0.a(this.this$0.jdField_a_of_type_Int);
      return;
      localEditVideoSave = this.this$0;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_Int);
    this.this$0.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */