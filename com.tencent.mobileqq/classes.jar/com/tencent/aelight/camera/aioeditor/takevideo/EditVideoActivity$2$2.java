package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Build.VERSION;

class EditVideoActivity$2$2
  implements Runnable
{
  EditVideoActivity$2$2(EditVideoActivity.2 param2) {}
  
  public void run()
  {
    if (((Build.VERSION.SDK_INT > 16) && (this.a.this$0.isDestroyed())) || (this.a.this$0.isFinishing())) {
      return;
    }
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.2.2
 * JD-Core Version:    0.7.0.1
 */