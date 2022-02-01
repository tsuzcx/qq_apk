package com.tencent.TMG.audio;

import com.tencent.TMG.utils.QLog;
import java.util.HashMap;

class TraeAudioManager$TraeAudioManagerLooper$1
  implements TraeMediaPlayer.OnCompletionListener
{
  TraeAudioManager$TraeAudioManagerLooper$1(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  public void onCompletion()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "_ringPlayer onCompletion _activeMode:" + this.this$1.this$0._activeMode + " _preRingMode:" + this.this$1._preRingMode);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(true));
    this.this$1.sendMessage(32783, localHashMap);
    this.this$1.notifyRingCompletion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.TraeAudioManagerLooper.1
 * JD-Core Version:    0.7.0.1
 */