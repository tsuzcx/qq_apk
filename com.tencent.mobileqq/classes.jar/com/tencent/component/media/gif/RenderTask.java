package com.tencent.component.media.gif;

import android.os.SystemClock;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageTaskBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

class RenderTask
  extends SafeRunnable
{
  private int failCount = 0;
  private long invalidationDelay = 0L;
  public int mCurrentIndex = 0;
  private boolean mFailCountReported = false;
  protected final Runnable mNotifyListenersTask = new RenderTask.1(this);
  protected boolean mReported = false;
  private boolean startCollectFailCount = false;
  
  RenderTask(NewGifDrawable paramNewGifDrawable)
  {
    super(paramNewGifDrawable);
  }
  
  private void reportCostsTime(boolean paramBoolean, long paramLong, NewGifDrawable paramNewGifDrawable)
  {
    HashMap localHashMap = new HashMap();
    int i;
    if (paramBoolean)
    {
      i = 1;
      localHashMap.put("is_gif_playing", String.valueOf(i));
      localHashMap.put("first_frame_render_cost", String.valueOf(paramLong));
      localHashMap.put("networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
      if (!paramBoolean) {
        break label141;
      }
      ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "gif_play_first_frame_cost", (int)paramLong);
      ImageManagerEnv.getLogger().d("gifPlayingReport", new Object[] { "gif_play time:" + paramLong });
      localHashMap.put("gif_play_first_frame_cost", String.valueOf(paramLong));
    }
    for (;;)
    {
      ImageManagerEnv.g().statisticCollectorReport("gifPlayingReportNew", localHashMap);
      return;
      i = 0;
      break;
      label141:
      ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "normal_Play_first_frame_cost", (int)paramLong);
      ImageManagerEnv.getLogger().d("gifPlayingReport", new Object[] { "normal_Play time:" + paramLong });
      localHashMap.put("normal_Play_first_frame_cost", String.valueOf(paramLong));
      localHashMap.put("n_frameCount", String.valueOf(paramNewGifDrawable.getNumberOfFrames()));
      localHashMap.put("n_size", String.valueOf(paramNewGifDrawable.getAllocationByteCount()));
    }
  }
  
  private void reportFailCount(int paramInt, NewGifDrawable paramNewGifDrawable)
  {
    if ((paramNewGifDrawable == null) || (paramNewGifDrawable.getNumberOfFrames() == 0)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingFailCountReport", "performance", "gif_play_fail_count", paramInt);
    ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingFailCountReport", "performance", "gif_play_frame_count", paramNewGifDrawable.getNumberOfFrames());
    localHashMap.put("f_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
    localHashMap.put("gif_play_fail_count", String.valueOf(paramInt));
    localHashMap.put("f_frame_count", String.valueOf(paramNewGifDrawable.getNumberOfFrames()));
    if (paramNewGifDrawable.getNumberOfFrames() != 0) {
      localHashMap.put("fail_frame", String.valueOf(paramInt * 1.0D / paramNewGifDrawable.getNumberOfFrames()));
    }
    ImageManagerEnv.g().statisticCollectorReport("gifPlayingFailCountReport", localHashMap);
  }
  
  public void doWork()
  {
    for (;;)
    {
      Long localLong1;
      try
      {
        if (this.mGifDrawable.getCurrentModel() == 4)
        {
          ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "doWork | ====mCurrentIndex:" + this.mGifDrawable.getCurrentFrameIndex() + " mGifDrawable.isEndDownload:" + this.mGifDrawable.isEndDownload + " mHashcode:" + this.mGifDrawable.mHashcode });
          NewGifDecoder.GifFrame localGifFrame1 = this.mGifDrawable.mGifDecoder.nextForGifPlay(this.mGifDrawable.mBuffer, this.mGifDrawable.isEndDownload);
          long l2;
          if (!this.mReported)
          {
            localLong1 = (Long)ImageTaskBuilder.stampMap.remove(this.mGifDrawable.getUrl());
            Long localLong2 = (Long)ImageTaskBuilder.stampMap2.remove(this.mGifDrawable.getUrl());
            if (localLong1 != null)
            {
              l1 = localLong1.longValue();
              l2 = System.currentTimeMillis() - l1;
              if (localLong2 == null) {
                break label761;
              }
              l1 = System.currentTimeMillis() - localLong2.longValue();
              ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "1 first_frame_render_cost2: " + l1 });
              ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "1 first_frame_render_cost: " + l2 });
              if (l1 == 0L) {
                continue;
              }
              reportCostsTime(true, l1, this.mGifDrawable);
              this.mReported = true;
            }
          }
          ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "doWork | ====invalidationDelay:" + localGifFrame1.delay });
          if ((localGifFrame1 != null) && (localGifFrame1.delay == -1L))
          {
            if (this.startCollectFailCount) {
              this.failCount += 1;
            }
            return;
            l1 = l2;
            continue;
          }
          if (!this.startCollectFailCount) {
            this.startCollectFailCount = true;
          }
          if ((!this.mFailCountReported) && (this.mGifDrawable.isEndDownload))
          {
            this.mFailCountReported = true;
            reportFailCount(this.failCount, this.mGifDrawable);
          }
          this.mGifDrawable.mIsRenderingTriggeredOnDraw = true;
          this.mGifDrawable.mBuffer = localGifFrame1.image;
          this.invalidationDelay = localGifFrame1.delay;
          if (this.invalidationDelay < 0L) {
            break label740;
          }
          this.mGifDrawable.mNextFrameRenderTime = (SystemClock.uptimeMillis() + this.invalidationDelay);
          if ((!this.mGifDrawable.mListeners.isEmpty()) && (this.mGifDrawable.getCurrentFrameIndex() == this.mGifDrawable.getNumberOfFrames() - 1)) {
            this.mGifDrawable.scheduleSelf(this.mNotifyListenersTask, this.mGifDrawable.mNextFrameRenderTime);
          }
          if ((!this.mGifDrawable.isVisible()) || (this.mGifDrawable.mInvalidationHandler.hasMessages(0)) || (this.mGifDrawable.getCallback() == null)) {
            continue;
          }
          this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
          continue;
        }
        this.mGifDrawable.mIsRenderingTriggeredOnDraw = true;
      }
      finally {}
      NewGifDecoder.GifFrame localGifFrame2 = this.mGifDrawable.mGifDecoder.next(this.mGifDrawable.mBuffer);
      if (!this.mReported)
      {
        localLong1 = (Long)ImageTaskBuilder.stampMap.remove(this.mGifDrawable.getUrl());
        if (localLong1 != null)
        {
          l1 = localLong1.longValue();
          l1 = System.currentTimeMillis() - l1;
          ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "2 first_frame_render_cost: " + l1 });
          reportCostsTime(false, l1, this.mGifDrawable);
          this.mReported = true;
        }
      }
      this.mGifDrawable.mBuffer = localGifFrame2.image;
      this.invalidationDelay = localGifFrame2.delay;
      this.mCurrentIndex = ((this.mCurrentIndex + 1) % this.mGifDrawable.getNumberOfFrames());
      continue;
      label740:
      this.mGifDrawable.mNextFrameRenderTime = -9223372036854775808L;
      this.mGifDrawable.mIsRunning = false;
      continue;
      label761:
      long l1 = 0L;
    }
  }
  
  public long getFrameDelay()
  {
    return this.invalidationDelay;
  }
  
  public void waitFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.gif.RenderTask
 * JD-Core Version:    0.7.0.1
 */