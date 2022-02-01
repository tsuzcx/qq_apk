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
  long jdField_a_of_type_Long = 0L;
  StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  
  private VideoViewVideoHolder$VideoStartSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  private void a(VideoViewVideoHolder paramVideoViewVideoHolder, long paramLong, String paramString)
  {
    VideoViewVideoHolder.a(paramVideoViewVideoHolder, paramLong, paramString);
    a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
  
  private boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, TextureView paramTextureView, long paramLong)
  {
    if (paramTextureView.isAvailable())
    {
      if ((VideoViewVideoHolder.a(paramVideoViewVideoHolder) != null) && (VideoViewVideoHolder.a(paramVideoViewVideoHolder).getWidth() == paramTextureView.getWidth() / 16) && (VideoViewVideoHolder.a(paramVideoViewVideoHolder).getHeight() == paramTextureView.getHeight() / 16))
      {
        paramTextureView = paramTextureView.getBitmap(VideoViewVideoHolder.a(paramVideoViewVideoHolder));
        if (StoryPlayerTest.a(paramTextureView, 4, 16))
        {
          SLog.a(paramVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d", Long.valueOf(paramLong));
          return true;
        }
      }
      else
      {
        if (VideoViewVideoHolder.a(paramVideoViewVideoHolder) != null) {
          VideoViewVideoHolder.a(paramVideoViewVideoHolder).recycle();
        }
        int i = paramTextureView.getWidth() / 16;
        int j = paramTextureView.getHeight() / 16;
        if ((i > 0) && (j > 0))
        {
          if (Build.VERSION.SDK_INT >= 17) {
            VideoViewVideoHolder.a(paramVideoViewVideoHolder, Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888));
          }
          for (;;)
          {
            paramTextureView = paramTextureView.getBitmap(VideoViewVideoHolder.a(paramVideoViewVideoHolder));
            break;
            VideoViewVideoHolder.a(paramVideoViewVideoHolder, Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
          }
        }
        return false;
      }
      SLog.d(this.this$0.jdField_a_of_type_JavaLangString, "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
    }
    for (;;)
    {
      return false;
      SLog.d(this.this$0.jdField_a_of_type_JavaLangString, "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    }
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.this$0, 10);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.this$0, 9);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder != null)
    {
      ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoStartSegment.1(this));
      if (!this.this$0.a().mUIStyle.mForDebug) {
        VideoViewVideoHolder.b(this.this$0, paramStoryVideoItem);
      }
      return;
    }
    SLog.e(this.this$0.jdField_a_of_type_JavaLangString, "onPrepared, is not on foreground, do not start video view !!");
    notifyError(new ErrorMessage(0, "onPrepared, is not on foreground"));
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.b(this.this$0.jdField_a_of_type_JavaLangString, "VideoStartSegment onCancel");
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public void run()
  {
    VideoViewVideoHolder localVideoViewVideoHolder = this.this$0;
    if (!localVideoViewVideoHolder.c())
    {
      SLog.d(localVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "!holder.isSelected() holder = %s", new Object[] { localVideoViewVideoHolder });
      notifyError(new ErrorMessage(0, "!holder.isSelected"));
      return;
    }
    if (VideoViewVideoHolder.e(this.this$0) == 1)
    {
      SLog.d(this.this$0.jdField_a_of_type_JavaLangString, "SOFT DECODE, waiting PLAYER_INFO_START_RENDERING");
      a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
    long l1 = localVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
    if (l1 > 0L)
    {
      TextureView localTextureView = StoryPlayerTest.a(localVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a());
      if (localTextureView != null)
      {
        long l2 = SystemClock.uptimeMillis();
        boolean bool = a(localVideoViewVideoHolder, localTextureView, l1);
        SLog.a(this.this$0.jdField_a_of_type_JavaLangString, "check black cost %d ms", Long.valueOf(SystemClock.uptimeMillis() - l2));
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
        VideoViewVideoHolder.a(localVideoViewVideoHolder).postDelayed(this, 20L);
        return;
      }
      if (l1 > 100L)
      {
        a(localVideoViewVideoHolder, l1, "NoTextureView-TimeOut");
        return;
      }
      VideoViewVideoHolder.a(localVideoViewVideoHolder).postDelayed(this, 20L);
      return;
    }
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > 4000L)
    {
      SLog.d(this.this$0.jdField_a_of_type_JavaLangString, "check black frame time out. holder = %s", new Object[] { localVideoViewVideoHolder });
      localVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
      VideoViewVideoHolder.c(this.this$0, 14);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.this$0), "check black frame time out"));
      return;
    }
    VideoViewVideoHolder.a(localVideoViewVideoHolder).postDelayed(this, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoStartSegment
 * JD-Core Version:    0.7.0.1
 */