package com.tencent.mobileqq.activity.shortvideo;

import android.media.AudioManager;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.mobileqq.video.IMediaPlayer.OnCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

class ShortVideoPreviewActivity$7
  implements IMediaPlayer.OnCompletionListener
{
  ShortVideoPreviewActivity$7(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    QLog.i("ShortVideoPreviewActivity", 1, "[onCompletion] ");
    if (VersionUtils.b()) {
      ((AudioManager)this.a.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */