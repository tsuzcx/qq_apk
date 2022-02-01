package com.tencent.aelight.camera.aioeditor.takevideo;

import android.widget.TextView;

class EditProviderPart$5
  implements Runnable
{
  EditProviderPart$5(EditProviderPart paramEditProviderPart, boolean paramBoolean) {}
  
  public void run()
  {
    if (EditProviderPart.j(this.this$0) == null) {
      return;
    }
    if (this.a)
    {
      EditProviderPart.j(this.this$0).setVisibility(0);
      return;
    }
    EditProviderPart.j(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.5
 * JD-Core Version:    0.7.0.1
 */