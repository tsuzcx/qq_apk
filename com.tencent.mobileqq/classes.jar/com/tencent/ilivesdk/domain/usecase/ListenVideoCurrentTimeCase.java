package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.livesdk.roomengine.RoomEngine;

public class ListenVideoCurrentTimeCase
  extends LiveUseCase<Long, Boolean>
  implements ThreadCenter.HandlerKeyable
{
  AVPlayerBuilderServiceInterface avPlayerService;
  Runnable timeRunnable = new ListenVideoCurrentTimeCase.1(this);
  
  protected void executeRoomUseCase(RoomEngine paramRoomEngine, Boolean paramBoolean)
  {
    if (paramRoomEngine == null) {
      return;
    }
    this.avPlayerService = ((AVPlayerBuilderServiceInterface)paramRoomEngine.getService(AVPlayerBuilderServiceInterface.class));
    ThreadCenter.clear(this);
    ThreadCenter.postDelayedUITask(this, this.timeRunnable, 0L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ThreadCenter.clear(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.ListenVideoCurrentTimeCase
 * JD-Core Version:    0.7.0.1
 */