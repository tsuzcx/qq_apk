package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.automator.IThreadExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.jetbrains.annotations.NotNull;

class RIJUgcVideoPublishManager$3
  implements IThreadExecutor
{
  RIJUgcVideoPublishManager$3(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager) {}
  
  public void a(@NotNull Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.3
 * JD-Core Version:    0.7.0.1
 */