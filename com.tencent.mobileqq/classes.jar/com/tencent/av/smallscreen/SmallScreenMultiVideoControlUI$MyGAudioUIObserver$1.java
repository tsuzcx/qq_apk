package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;

class SmallScreenMultiVideoControlUI$MyGAudioUIObserver$1
  implements Runnable
{
  SmallScreenMultiVideoControlUI$MyGAudioUIObserver$1(SmallScreenMultiVideoControlUI.MyGAudioUIObserver paramMyGAudioUIObserver, long paramLong) {}
  
  public void run()
  {
    if ((this.b.b.r() == this.a) && (!SharedPreUtils.B(this.b.b.y.getApp().getApplicationContext()).getBoolean("kick_out_self", false))) {
      this.b.b.d(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver.1
 * JD-Core Version:    0.7.0.1
 */