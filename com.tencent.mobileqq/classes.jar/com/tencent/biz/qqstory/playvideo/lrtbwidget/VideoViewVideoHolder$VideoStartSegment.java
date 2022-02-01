package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.view.TextureView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerTest;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import mqq.os.MqqHandler;

class VideoViewVideoHolder$VideoStartSegment
  extends JobSegment<StoryVideoItem, StoryVideoItem>
  implements Runnable
{
  StoryVideoItem a;
  long b = 0L;
  
  private VideoViewVideoHolder$VideoStartSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  private void a(VideoViewVideoHolder paramVideoViewVideoHolder, long paramLong, String paramString)
  {
    VideoViewVideoHolder.a(paramVideoViewVideoHolder, paramLong, paramString);
    a(this.a);
  }
  
  private boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, TextureView paramTextureView, long paramLong)
  {
    if (paramTextureView.isAvailable())
    {
      if ((VideoViewVideoHolder.l(paramVideoViewVideoHolder) != null) && (VideoViewVideoHolder.l(paramVideoViewVideoHolder).getWidth() == paramTextureView.getWidth() / 16) && (VideoViewVideoHolder.l(paramVideoViewVideoHolder).getHeight() == paramTextureView.getHeight() / 16))
      {
        paramTextureView = paramTextureView.getBitmap(VideoViewVideoHolder.l(paramVideoViewVideoHolder));
      }
      else
      {
        if (VideoViewVideoHolder.l(paramVideoViewVideoHolder) != null) {
          VideoViewVideoHolder.l(paramVideoViewVideoHolder).recycle();
        }
        int i = paramTextureView.getWidth() / 16;
        int j = paramTextureView.getHeight() / 16;
        if ((i <= 0) || (j <= 0)) {
          break label198;
        }
        if (Build.VERSION.SDK_INT >= 17) {
          VideoViewVideoHolder.a(paramVideoViewVideoHolder, Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888));
        } else {
          VideoViewVideoHolder.a(paramVideoViewVideoHolder, Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        }
        paramTextureView = paramTextureView.getBitmap(VideoViewVideoHolder.l(paramVideoViewVideoHolder));
      }
      if (StoryPlayerTest.a(paramTextureView, 4, 16))
      {
        SLog.a(paramVideoViewVideoHolder.a, "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d", Long.valueOf(paramLong));
        return true;
      }
      SLog.d(this.this$0.a, "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
      return false;
      label198:
      return false;
    }
    SLog.d(this.this$0.a, "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    return false;
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.this$0, 10);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.this$0, 9);
    this.a = paramStoryVideoItem;
    if (this.this$0.f != null)
    {
      ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoStartSegment.1(this));
      if (!this.this$0.i().mUIStyle.mForDebug) {
        VideoViewVideoHolder.b(this.this$0, paramStoryVideoItem);
      }
    }
    else
    {
      SLog.e(this.this$0.a, "onPrepared, is not on foreground, do not start video view !!");
      notifyError(new ErrorMessage(0, "onPrepared, is not on foreground"));
    }
  }
  
  protected void onCancel()
  {
    super.onCancel();
    SLog.b(this.this$0.a, "VideoStartSegment onCancel");
    this.this$0.p.c();
  }
  
  public void run()
  {
    VideoViewVideoHolder localVideoViewVideoHolder = this.this$0;
    if (!localVideoViewVideoHolder.f())
    {
      SLog.d(localVideoViewVideoHolder.a, "!holder.isSelected() holder = %s", new Object[] { localVideoViewVideoHolder });
      notifyError(new ErrorMessage(0, "!holder.isSelected"));
      return;
    }
    if (VideoViewVideoHolder.m(this.this$0) == 1)
    {
      SLog.d(this.this$0.a, "SOFT DECODE, waiting PLAYER_INFO_START_RENDERING");
      a(this.a);
      return;
    }
    long l1 = localVideoViewVideoHolder.p.e();
    if (l1 > 0L)
    {
      TextureView localTextureView = StoryPlayerTest.a(localVideoViewVideoHolder.p.a());
      if (localTextureView != null)
      {
        long l2 = SystemClock.uptimeMillis();
        boolean bool = a(localVideoViewVideoHolder, localTextureView, l1);
        SLog.a(this.this$0.a, "check black cost %d ms", Long.valueOf(SystemClock.uptimeMillis() - l2));
        if (!bool)
        {
          a(localVideoViewVideoHolder, l1, "NotBlackFrame");
          return;
        }
        if (l1 > 500L)
        {
          a(localVideoViewVideoHolder, l1, "BlackFrame-TimeOut");
          return;
        }
        VideoViewVideoHolder.k(localVideoViewVideoHolder).postDelayed(this, 20L);
        return;
      }
      if (l1 > 100L)
      {
        a(localVideoViewVideoHolder, l1, "NoTextureView-TimeOut");
        return;
      }
      VideoViewVideoHolder.k(localVideoViewVideoHolder).postDelayed(this, 20L);
      return;
    }
    if (SystemClock.uptimeMillis() - this.b > 4000L)
    {
      SLog.d(this.this$0.a, "check black frame time out. holder = %s", new Object[] { localVideoViewVideoHolder });
      localVideoViewVideoHolder.p.c();
      VideoViewVideoHolder.c(this.this$0, 14);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.this$0), "check black frame time out"));
      return;
    }
    VideoViewVideoHolder.k(localVideoViewVideoHolder).postDelayed(this, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoStartSegment
 * JD-Core Version:    0.7.0.1
 */