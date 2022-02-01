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
      this.a.mCover.setVisibility(8);
      this.a.mOperatorBtn.setImageResource(2130847780);
    }
    else
    {
      this.a.mOperatorBtn.setImageResource(2130847779);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changePlayState, playState => ");
      localStringBuilder.append(this.a.getPlayStateStr(paramInt));
      QLog.d("ShortVideoPreviewActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */