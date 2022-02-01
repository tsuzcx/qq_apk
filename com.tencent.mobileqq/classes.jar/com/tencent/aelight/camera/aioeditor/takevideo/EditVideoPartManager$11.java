package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController.IUploadArkVideoCallback;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EditVideoPartManager$11
  implements PeakIpcController.IUploadArkVideoCallback
{
  EditVideoPartManager$11(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void a()
  {
    AEQLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onFail:");
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.2(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.4(this, paramInt));
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadArkVideo---onSuccess: videoDownLoadUrl=");
    localStringBuilder.append(paramString);
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.1(this));
  }
  
  public void b()
  {
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onCancel:");
    ThreadManager.getUIHandler().post(new EditVideoPartManager.11.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.11
 * JD-Core Version:    0.7.0.1
 */