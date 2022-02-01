package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import mqq.os.MqqHandler;

class EditVideoActivity$2
  implements Runnable
{
  EditVideoActivity$2(EditVideoActivity paramEditVideoActivity) {}
  
  public void run()
  {
    try
    {
      ((IAEResUtil)QRoute.api(IAEResUtil.class)).loadAEBaseSo();
      if (VideoEnvironment.loadAVCodecSo() != 0)
      {
        SLog.e("EditVideoActivity", "load AVCodec so failed");
        ThreadManager.getUIHandler().post(new EditVideoActivity.2.1(this));
        return;
      }
    }
    catch (Exception localException)
    {
      SLog.c("EditVideoActivity", "load AVCodec so failed", localException);
      ThreadManager.getUIHandler().post(new EditVideoActivity.2.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.2
 * JD-Core Version:    0.7.0.1
 */