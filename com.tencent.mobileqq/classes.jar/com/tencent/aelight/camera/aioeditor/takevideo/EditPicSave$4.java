package com.tencent.aelight.camera.aioeditor.takevideo;

class EditPicSave$4
  implements Runnable
{
  EditPicSave$4(EditPicSave paramEditPicSave) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    EditPicSave localEditPicSave = this.this$0;
    localEditPicSave.jdField_a_of_type_Int += this.this$0.b;
    if (this.this$0.jdField_a_of_type_Int > 99)
    {
      localEditPicSave = this.this$0;
      localEditPicSave.jdField_a_of_type_Int = 99;
      localEditPicSave.a(localEditPicSave.jdField_a_of_type_Int);
      return;
    }
    localEditPicSave = this.this$0;
    localEditPicSave.a(localEditPicSave.jdField_a_of_type_Int);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.4
 * JD-Core Version:    0.7.0.1
 */