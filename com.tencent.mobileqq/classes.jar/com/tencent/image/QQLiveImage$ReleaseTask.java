package com.tencent.image;

import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class QQLiveImage$ReleaseTask
  implements Runnable
{
  boolean keepPosition;
  TVK_IMediaPlayer videoPlayer;
  
  public QQLiveImage$ReleaseTask(QQLiveImage paramQQLiveImage, TVK_IMediaPlayer paramTVK_IMediaPlayer, boolean paramBoolean)
  {
    this.videoPlayer = paramTVK_IMediaPlayer;
    this.keepPosition = paramBoolean;
  }
  
  public void run()
  {
    if (this.videoPlayer != null)
    {
      long l1 = SystemClock.uptimeMillis();
      TVK_IMediaPlayer localTVK_IMediaPlayer = this.videoPlayer;
      if (this.keepPosition) {
        QQLiveImage.access$1302(this.this$0, (int)this.videoPlayer.getCurrentPostion());
      }
      this.videoPlayer.stop();
      this.videoPlayer.release();
      this.videoPlayer = null;
      long l2 = SystemClock.uptimeMillis();
      URLDrawable.depImp.mLog.d(QQLiveImage.TAG + this.this$0.ID, 1, "ReleaseTask release TVK_IMediaPlayer =" + localTVK_IMediaPlayer + "，cost = " + (l2 - l1) + "ms");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.ReleaseTask
 * JD-Core Version:    0.7.0.1
 */