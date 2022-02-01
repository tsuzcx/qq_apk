package com.tencent.aelight.camera.aioeditor.takevideo;

import android.widget.ImageView;

class EditPicRawImage$2
  implements Runnable
{
  EditPicRawImage$2(EditPicRawImage paramEditPicRawImage, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.this$0.a.getWidth();
    int j = this.this$0.a.getHeight();
    if ((this.a) && (i > 0) && (j > 0))
    {
      EditPicRawImage.c(this.this$0);
      this.this$0.a(i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage.2
 * JD-Core Version:    0.7.0.1
 */