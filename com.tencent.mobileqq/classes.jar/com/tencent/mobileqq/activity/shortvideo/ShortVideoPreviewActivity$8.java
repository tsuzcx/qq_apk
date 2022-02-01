package com.tencent.mobileqq.activity.shortvideo;

import android.widget.ImageView;
import com.tencent.mobileqq.video.IMediaPlayer.OnPlayStateListener;
import com.tencent.qphone.base.util.QLog;

class ShortVideoPreviewActivity$8
  implements IMediaPlayer.OnPlayStateListener
{
  ShortVideoPreviewActivity$8(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a.setVisibility(8);
      this.a.b.setImageResource(2130846433);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + this.a.a(paramInt));
      }
      return;
      this.a.b.setImageResource(2130846432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */