package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qroute.QRoute;

class EditVideoActivity$6
  implements Runnable
{
  EditVideoActivity$6(EditVideoActivity paramEditVideoActivity) {}
  
  public void run()
  {
    ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).loadEffectSo();
    VideoFilterTools.a().a(this.this$0.getApplicationContext(), this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.6
 * JD-Core Version:    0.7.0.1
 */