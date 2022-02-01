package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavcut.TAVCut.Callback;

class AbsAEPublishVideoProcessFragment$1
  implements TAVCut.Callback
{
  AbsAEPublishVideoProcessFragment$1(AbsAEPublishVideoProcessFragment paramAbsAEPublishVideoProcessFragment) {}
  
  public void onDone(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0) {
          return;
        }
        AEQLog.a("AbsAEPublishVideoProces", "初始化TAVCut成功");
        return;
      }
      AEQLog.d("AbsAEPublishVideoProces", "初始化TAVCut失败：tavkit so库加载异常");
      return;
    }
    AEQLog.d("AbsAEPublishVideoProces", "初始化TAVCut失败：pag so库加载异常");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment.1
 * JD-Core Version:    0.7.0.1
 */