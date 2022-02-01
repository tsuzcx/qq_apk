package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;

class EditProviderPart$4
  implements Runnable
{
  EditProviderPart$4(EditProviderPart paramEditProviderPart) {}
  
  public void run()
  {
    if (!this.this$0.g)
    {
      if (this.this$0.u == null) {
        return;
      }
      if ((this.this$0.u.getActivity() != null) && (!this.this$0.u.getActivity().isFinishing()))
      {
        if ((Build.VERSION.SDK_INT > 16) && (this.this$0.u.getActivity().isDestroyed())) {
          return;
        }
        EditProviderPart localEditProviderPart = this.this$0;
        localEditProviderPart.g = true;
        localEditProviderPart.e(false);
        EditProviderPart.i(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.4
 * JD-Core Version:    0.7.0.1
 */