package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;

class EditProviderPart$3
  implements Runnable
{
  EditProviderPart$3(EditProviderPart paramEditProviderPart) {}
  
  public void run()
  {
    if (!this.this$0.b)
    {
      if (this.this$0.a == null) {
        return;
      }
      if ((this.this$0.a.getActivity() != null) && (!this.this$0.a.getActivity().isFinishing()))
      {
        if ((Build.VERSION.SDK_INT > 16) && (this.this$0.a.getActivity().isDestroyed())) {
          return;
        }
        EditProviderPart localEditProviderPart = this.this$0;
        localEditProviderPart.b = true;
        localEditProviderPart.e(false);
        EditProviderPart.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.3
 * JD-Core Version:    0.7.0.1
 */