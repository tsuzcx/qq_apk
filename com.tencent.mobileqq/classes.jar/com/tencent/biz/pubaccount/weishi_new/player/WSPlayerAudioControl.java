package com.tencent.biz.pubaccount.weishi_new.player;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;

public class WSPlayerAudioControl
{
  private Handler a = new WSPlayerAudioControl.AudioHandler(Looper.getMainLooper(), this);
  private AudioManager b;
  private AudioManager.OnAudioFocusChangeListener c = new WSPlayerAudioControl.1(this);
  
  public static WSPlayerAudioControl a()
  {
    return WSPlayerAudioControl.SingletonHolder.a();
  }
  
  private void b()
  {
    if (this.b == null) {
      this.b = ((AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio"));
    }
    this.b.requestAudioFocus(this.c, 3, 2);
  }
  
  private void c()
  {
    AudioManager localAudioManager = this.b;
    if (localAudioManager == null) {
      return;
    }
    localAudioManager.abandonAudioFocus(this.c);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerAudioControl.java][requestOrAbandonAudioFocus] isFocus:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WSPlayerAudioControlLog", localStringBuilder.toString());
    this.a.removeMessages(1);
    this.a.removeMessages(2);
    if (paramBoolean)
    {
      this.a.sendEmptyMessage(1);
      return;
    }
    this.a.sendEmptyMessageDelayed(2, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl
 * JD-Core Version:    0.7.0.1
 */