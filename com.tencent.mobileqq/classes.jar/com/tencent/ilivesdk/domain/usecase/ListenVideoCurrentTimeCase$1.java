package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;

class ListenVideoCurrentTimeCase$1
  implements Runnable
{
  ListenVideoCurrentTimeCase$1(ListenVideoCurrentTimeCase paramListenVideoCurrentTimeCase) {}
  
  public void run()
  {
    if (this.this$0.avPlayerService != null)
    {
      long l = this.this$0.avPlayerService.getCurrentPositionMs();
      ListenVideoCurrentTimeCase.access$000(this.this$0, Long.valueOf(l));
      ListenVideoCurrentTimeCase localListenVideoCurrentTimeCase = this.this$0;
      ThreadCenter.postDelayedUITask(localListenVideoCurrentTimeCase, localListenVideoCurrentTimeCase.timeRunnable, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.ListenVideoCurrentTimeCase.1
 * JD-Core Version:    0.7.0.1
 */