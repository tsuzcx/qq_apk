package com.tencent.biz.pubaccount.weishi_new.player;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerAudioControl$1
  implements AudioManager.OnAudioFocusChangeListener
{
  WSPlayerAudioControl$1(WSPlayerAudioControl paramWSPlayerAudioControl) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerAudioControl.java][requestAudioFocus] onAudioFocusChange focusChange:");
    localStringBuilder.append(paramInt);
    WSLog.e("WSPlayerAudioControlLog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl.1
 * JD-Core Version:    0.7.0.1
 */