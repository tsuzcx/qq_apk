package com.tencent.aelight.camera.aioeditor.takevideo;

class EditVideoStoryButton$4
  implements Runnable
{
  EditVideoStoryButton$4(EditVideoStoryButton paramEditVideoStoryButton) {}
  
  public void run()
  {
    if (this.this$0.d) {
      return;
    }
    if (this.this$0.c < 50.0F)
    {
      localEditVideoStoryButton = this.this$0;
      localEditVideoStoryButton.c += this.this$0.e;
    }
    else
    {
      localEditVideoStoryButton = this.this$0;
      localEditVideoStoryButton.c += 1.0F;
    }
    if (this.this$0.c > 99.0F)
    {
      localEditVideoStoryButton = this.this$0;
      localEditVideoStoryButton.c = 99.0F;
      localEditVideoStoryButton.a((int)localEditVideoStoryButton.c);
      return;
    }
    EditVideoStoryButton localEditVideoStoryButton = this.this$0;
    localEditVideoStoryButton.a((int)localEditVideoStoryButton.c);
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.4
 * JD-Core Version:    0.7.0.1
 */