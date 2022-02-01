package com.tencent.mobileqq.activity.shortvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;

class ShortVideoPlayActivity$7
  extends BroadcastReceiver
{
  ShortVideoPlayActivity$7(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive ===>");
      paramIntent.append(paramContext);
      QLog.d("ShortVideoPlayActivity", 2, paramIntent.toString());
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      if ((this.a.mMediaPlayer != null) && (this.a.mMediaPlayer.get() != null) && (((TVK_IMediaPlayer)this.a.mMediaPlayer.get()).isPlaying())) {
        this.a.mNeedPlay = true;
      }
      this.a.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.7
 * JD-Core Version:    0.7.0.1
 */