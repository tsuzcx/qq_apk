package com.tencent.aelight.camera.aioeditor.takevideo;

class EditVideoSave$4
  implements Runnable
{
  EditVideoSave$4(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    if (this.this$0.b) {
      return;
    }
    if (this.this$0.a < 50.0F)
    {
      localEditVideoSave = this.this$0;
      localEditVideoSave.a += this.this$0.c;
    }
    else
    {
      localEditVideoSave = this.this$0;
      localEditVideoSave.a += 1.0F;
    }
    if (this.this$0.a > 99.0F)
    {
      localEditVideoSave = this.this$0;
      localEditVideoSave.a = 99.0F;
      localEditVideoSave.a((int)localEditVideoSave.a);
      return;
    }
    EditVideoSave localEditVideoSave = this.this$0;
    localEditVideoSave.a((int)localEditVideoSave.a);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.4
 * JD-Core Version:    0.7.0.1
 */