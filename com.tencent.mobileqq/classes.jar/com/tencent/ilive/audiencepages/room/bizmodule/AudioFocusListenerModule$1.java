package com.tencent.ilive.audiencepages.room.bizmodule;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.notification.NotificationIdConstant;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.ilive.pages.room.events.PlayOverEvent;

class AudioFocusListenerModule$1
  implements Observer<PlayOverEvent>
{
  AudioFocusListenerModule$1(AudioFocusListenerModule paramAudioFocusListenerModule) {}
  
  public void onChanged(@Nullable PlayOverEvent paramPlayOverEvent)
  {
    AudioFocusListenerModule.access$000(this.this$0).cancel(NotificationIdConstant.BACKGROUND_AUDIO.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule.1
 * JD-Core Version:    0.7.0.1
 */