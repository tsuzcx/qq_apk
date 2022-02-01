package com.tencent.mobileqq.activity.shortvideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShortVideoPlayActivity$3
  implements DialogInterface.OnClickListener
{
  ShortVideoPlayActivity$3(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.mMediaPlayer != null)
    {
      if (this.a.mPlayState == 2) {
        this.a.resume();
      }
      paramDialogInterface = this.a;
      paramDialogInterface.play(paramDialogInterface.mCurrentPosition);
    }
    com.tencent.mobileqq.shortvideo.SVBusiUtil.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.3
 * JD-Core Version:    0.7.0.1
 */