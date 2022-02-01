package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController.IUploadArkVideoCallback;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EditVideoStoryButton$2
  implements PeakIpcController.IUploadArkVideoCallback
{
  EditVideoStoryButton$2(EditVideoStoryButton paramEditVideoStoryButton) {}
  
  public void a()
  {
    AEQLog.d("EditVideoStoryButton", "uploadArkVideo---onFail:");
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.2(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.4(this, paramInt));
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadArkVideo---onSuccess: videoDownLoadUrl=");
    localStringBuilder.append(paramString);
    AEQLog.b("EditVideoStoryButton", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.1(this));
  }
  
  public void b()
  {
    AEQLog.b("EditVideoStoryButton", "uploadArkVideo---onCancel:");
    ThreadManager.getUIHandler().post(new EditVideoStoryButton.2.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.2
 * JD-Core Version:    0.7.0.1
 */