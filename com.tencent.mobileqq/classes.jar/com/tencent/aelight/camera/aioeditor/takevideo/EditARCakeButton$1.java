package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EditARCakeButton$1
  implements Runnable
{
  EditARCakeButton$1(EditARCakeButton paramEditARCakeButton, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    EditARCakeButton.a(this.this$0, this.a, this.b);
    if (EditARCakeButton.a(this.this$0) != null) {
      AEQLog.b("EditARCakeButton", "build share object success, start open share panel");
    } else {
      AEQLog.d("EditARCakeButton", "build share object fail");
    }
    ThreadManager.getUIHandler().post(new EditARCakeButton.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.1
 * JD-Core Version:    0.7.0.1
 */