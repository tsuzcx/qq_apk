package com.tencent.aelight.camera.aioeditor.takevideo;

class EditVideoPartManager$6
  implements Runnable
{
  EditVideoPartManager$6(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void run()
  {
    if (EditVideoPartManager.b(this.this$0)) {
      return;
    }
    if (EditVideoPartManager.a(this.this$0) < 50.0F)
    {
      localEditVideoPartManager = this.this$0;
      EditVideoPartManager.a(localEditVideoPartManager, EditVideoPartManager.a(localEditVideoPartManager) + EditVideoPartManager.b(this.this$0));
    }
    else
    {
      EditVideoPartManager.c(this.this$0);
    }
    if (EditVideoPartManager.a(this.this$0) > 99.0F)
    {
      EditVideoPartManager.a(this.this$0, 99.0F);
      localEditVideoPartManager = this.this$0;
      EditVideoPartManager.a(localEditVideoPartManager, (int)EditVideoPartManager.a(localEditVideoPartManager));
      return;
    }
    EditVideoPartManager localEditVideoPartManager = this.this$0;
    EditVideoPartManager.a(localEditVideoPartManager, (int)EditVideoPartManager.a(localEditVideoPartManager));
    EditVideoPartManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.6
 * JD-Core Version:    0.7.0.1
 */