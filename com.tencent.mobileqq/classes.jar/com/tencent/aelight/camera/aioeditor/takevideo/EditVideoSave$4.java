package com.tencent.aelight.camera.aioeditor.takevideo;

class EditVideoSave$4
  implements Runnable
{
  EditVideoSave$4(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Float < 50.0F)
    {
      localEditVideoSave = this.this$0;
      localEditVideoSave.jdField_a_of_type_Float += this.this$0.b;
    }
    else
    {
      localEditVideoSave = this.this$0;
      localEditVideoSave.jdField_a_of_type_Float += 1.0F;
    }
    if (this.this$0.jdField_a_of_type_Float > 99.0F)
    {
      localEditVideoSave = this.this$0;
      localEditVideoSave.jdField_a_of_type_Float = 99.0F;
      localEditVideoSave.a((int)localEditVideoSave.jdField_a_of_type_Float);
      return;
    }
    EditVideoSave localEditVideoSave = this.this$0;
    localEditVideoSave.a((int)localEditVideoSave.jdField_a_of_type_Float);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.4
 * JD-Core Version:    0.7.0.1
 */