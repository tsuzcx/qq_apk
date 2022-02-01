package com.tencent.aelight.camera.aioeditor.takevideo;

import android.widget.TextView;

class EditProviderPart$4
  implements Runnable
{
  EditProviderPart$4(EditProviderPart paramEditProviderPart, boolean paramBoolean) {}
  
  public void run()
  {
    if (EditProviderPart.a(this.this$0) == null) {
      return;
    }
    if (this.a)
    {
      EditProviderPart.a(this.this$0).setVisibility(0);
      return;
    }
    EditProviderPart.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.4
 * JD-Core Version:    0.7.0.1
 */