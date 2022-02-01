package com.tencent.aelight.camera.aioeditor.takevideo;

class EditPicSave$4
  implements Runnable
{
  EditPicSave$4(EditPicSave paramEditPicSave) {}
  
  public void run()
  {
    if (this.this$0.b) {
      return;
    }
    EditPicSave localEditPicSave = this.this$0;
    localEditPicSave.a += this.this$0.c;
    if (this.this$0.a > 99)
    {
      localEditPicSave = this.this$0;
      localEditPicSave.a = 99;
      localEditPicSave.a(localEditPicSave.a);
      return;
    }
    localEditPicSave = this.this$0;
    localEditPicSave.a(localEditPicSave.a);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.4
 * JD-Core Version:    0.7.0.1
 */