package com.tencent.aelight.camera.aioeditor.takevideo;

class EditVideoStoryButton$4
  implements Runnable
{
  EditVideoStoryButton$4(EditVideoStoryButton paramEditVideoStoryButton) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Float < 50.0F)
    {
      localEditVideoStoryButton = this.this$0;
      localEditVideoStoryButton.jdField_a_of_type_Float += this.this$0.b;
    }
    else
    {
      localEditVideoStoryButton = this.this$0;
      localEditVideoStoryButton.jdField_a_of_type_Float += 1.0F;
    }
    if (this.this$0.jdField_a_of_type_Float > 99.0F)
    {
      localEditVideoStoryButton = this.this$0;
      localEditVideoStoryButton.jdField_a_of_type_Float = 99.0F;
      localEditVideoStoryButton.a((int)localEditVideoStoryButton.jdField_a_of_type_Float);
      return;
    }
    EditVideoStoryButton localEditVideoStoryButton = this.this$0;
    localEditVideoStoryButton.a((int)localEditVideoStoryButton.jdField_a_of_type_Float);
    this.this$0.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.4
 * JD-Core Version:    0.7.0.1
 */