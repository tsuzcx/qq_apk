package com.tencent.TMG.audio;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.TMG.utils.QLog;

class TraeAudioManager$TraeAudioManagerLooper$3
  implements AudioManager.OnAudioFocusChangeListener
{
  TraeAudioManager$TraeAudioManagerLooper$3(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("focusChange:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" _focusSteamType:");
      localStringBuilder.append(this.this$1._focusSteamType);
      localStringBuilder.append(" currMode:");
      localStringBuilder.append(this.this$1.this$0._am.getMode());
      localStringBuilder.append(" _activeMode:");
      localStringBuilder.append(this.this$1.this$0._activeMode);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    if (paramInt == -1) {
      return;
    }
    if (paramInt == -2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.TraeAudioManagerLooper.3
 * JD-Core Version:    0.7.0.1
 */