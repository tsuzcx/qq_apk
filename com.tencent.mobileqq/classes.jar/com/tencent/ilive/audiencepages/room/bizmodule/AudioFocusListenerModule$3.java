package com.tencent.ilive.audiencepages.room.bizmodule;

import android.media.AudioManager;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;

class AudioFocusListenerModule$3
  implements Observer<FloatWindowStateEvent>
{
  AudioFocusListenerModule$3(AudioFocusListenerModule paramAudioFocusListenerModule) {}
  
  public void onChanged(@Nullable FloatWindowStateEvent paramFloatWindowStateEvent)
  {
    AudioFocusListenerModule.access$202(this.this$0, paramFloatWindowStateEvent.showing);
    if ((!AudioFocusListenerModule.access$300(this.this$0)) && (!AudioFocusListenerModule.access$200(this.this$0)) && (paramFloatWindowStateEvent.reason == 9))
    {
      AudioFocusListenerModule.access$402(this.this$0, false);
      if (AudioFocusListenerModule.access$500(this.this$0) != null) {
        AudioFocusListenerModule.access$600(this.this$0).abandonAudioFocus(AudioFocusListenerModule.access$500(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule.3
 * JD-Core Version:    0.7.0.1
 */