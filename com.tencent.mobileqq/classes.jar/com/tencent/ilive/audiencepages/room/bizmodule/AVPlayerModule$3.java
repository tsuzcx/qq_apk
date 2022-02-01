package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;

class AVPlayerModule$3
  implements Observer<FloatWindowStateEvent>
{
  AVPlayerModule$3(AVPlayerModule paramAVPlayerModule) {}
  
  public void onChanged(@Nullable FloatWindowStateEvent paramFloatWindowStateEvent)
  {
    AVPlayerModule.access$302(this.this$0, paramFloatWindowStateEvent.showing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule.3
 * JD-Core Version:    0.7.0.1
 */