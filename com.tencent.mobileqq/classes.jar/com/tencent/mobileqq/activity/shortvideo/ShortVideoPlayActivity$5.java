package com.tencent.mobileqq.activity.shortvideo;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$5
  implements Runnable
{
  ShortVideoPlayActivity$5(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    Object localObject;
    if (this.this$0.isPlaying())
    {
      if (this.this$0.mDuration <= 0L) {
        this.this$0.initDuration();
      }
      if ((this.this$0.mMediaPlayer != null) && (this.this$0.mMediaPlayer.get() != null))
      {
        localObject = this.this$0;
        ShortVideoPlayActivity.access$202((ShortVideoPlayActivity)localObject, ((TVK_IMediaPlayer)((ShortVideoPlayActivity)localObject).mMediaPlayer.get()).getCurrentPostion());
      }
      if (ShortVideoPlayActivity.access$200(this.this$0) != 0L)
      {
        localObject = this.this$0;
        double d = ShortVideoPlayActivity.access$200((ShortVideoPlayActivity)localObject) * 10000L / this.this$0.mDuration;
        Double.isNaN(d);
        ShortVideoPlayActivity.access$302((ShortVideoPlayActivity)localObject, (int)(d + 0.5D));
        if (!ShortVideoPlayActivity.access$400(this.this$0))
        {
          localObject = this.this$0;
          ShortVideoPlayActivity.access$502((ShortVideoPlayActivity)localObject, ShortVideoPlayActivity.access$200((ShortVideoPlayActivity)localObject));
        }
        if (!ShortVideoPlayActivity.access$600(this.this$0))
        {
          this.this$0.mSeekBar.setProgress(ShortVideoPlayActivity.access$300(this.this$0));
          localObject = this.this$0;
          ((ShortVideoPlayActivity)localObject).setProgressTime(ShortVideoPlayActivity.access$200((ShortVideoPlayActivity)localObject));
        }
        if ((ShortVideoPlayActivity.access$700(this.this$0) == 0L) && (((TVK_IMediaPlayer)this.this$0.mMediaPlayer.get()).getFirsFrameCost() > 0L))
        {
          localObject = this.this$0;
          ShortVideoPlayActivity.access$702((ShortVideoPlayActivity)localObject, ((TVK_IMediaPlayer)((ShortVideoPlayActivity)localObject).mMediaPlayer.get()).getFirsFrameCost());
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mProgressChecker run , mTCOfMCFirstFrame = ");
            ((StringBuilder)localObject).append(ShortVideoPlayActivity.access$700(this.this$0));
            ((StringBuilder)localObject).append(", mPlayProgress = ");
            ((StringBuilder)localObject).append(ShortVideoPlayActivity.access$300(this.this$0));
            QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new HashMap();
          ((HashMap)localObject).put("param_timeCost", String.valueOf(ShortVideoPlayActivity.access$700(this.this$0)));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "videoMCFFTimeCost", true, ShortVideoPlayActivity.access$700(this.this$0), 0L, (HashMap)localObject, "");
        }
      }
    }
    if ((this.this$0.mMediaPlayer == null) || (this.this$0.mFileSize == 0L) || (this.this$0.mNeedDownload)) {}
    try
    {
      ShortVideoPlayActivity.access$802(this.this$0, (int)(this.this$0.mTransferredSize * 10000L / this.this$0.mFileSize));
    }
    catch (Throwable localThrowable)
    {
      label426:
      TextView localTextView;
      StringBuilder localStringBuilder;
      break label426;
    }
    break label440;
    ShortVideoPlayActivity.access$802(this.this$0, 10000);
    label440:
    if (this.this$0.mSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.access$800(this.this$0)) {
      this.this$0.mSeekBar.setSecondaryProgress(ShortVideoPlayActivity.access$800(this.this$0));
    }
    if ((this.this$0.isBuffering()) && (ShortVideoPlayActivity.access$900(this.this$0) > 0) && (ShortVideoPlayActivity.access$1000(this.this$0) != null) && (ShortVideoPlayActivity.access$1000(this.this$0).getVisibility() == 0))
    {
      localObject = ShortVideoUtils.stringForFileSize(this.this$0.mContext, ShortVideoPlayActivity.access$900(this.this$0) * 1024);
      localTextView = ShortVideoPlayActivity.access$1000(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/s");
      localTextView.setText(localStringBuilder.toString());
    }
    if (this.this$0.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "check progress, while finishing");
      }
      return;
    }
    if (this.this$0.mHandler.get() != null) {
      ((MqqHandler)this.this$0.mHandler.get()).postDelayed(this.this$0.mProgressChecker, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */