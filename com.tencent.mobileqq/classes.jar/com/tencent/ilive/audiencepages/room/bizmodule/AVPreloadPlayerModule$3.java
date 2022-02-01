package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;

class AVPreloadPlayerModule$3
  implements Observer<FloatWindowStateEvent>
{
  AVPreloadPlayerModule$3(AVPreloadPlayerModule paramAVPreloadPlayerModule) {}
  
  public void a(@Nullable FloatWindowStateEvent paramFloatWindowStateEvent)
  {
    AVPreloadPlayerModule.b(this.a, paramFloatWindowStateEvent.showing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule.3
 * JD-Core Version:    0.7.0.1
 */