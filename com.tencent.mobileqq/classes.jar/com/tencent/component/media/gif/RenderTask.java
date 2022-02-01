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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportFailCount(int paramInt, NewGifDrawable paramNewGifDrawable)
  {
    if (paramNewGifDrawable != null)
    {
      if (paramNewGifDrawable.getNumberOfFrames() == 0) {
        return;
      }
      HashMap localHashMap = new HashMap();
      ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingFailCountReport", "performance", "gif_play_fail_count", paramInt);
      ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingFailCountReport", "performance", "gif_play_frame_count", paramNewGifDrawable.getNumberOfFrames());
      localHashMap.put("f_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
      localHashMap.put("gif_play_fail_count", String.valueOf(paramInt));
      localHashMap.put("f_frame_count", String.valueOf(paramNewGifDrawable.getNumberOfFrames()));
      if (paramNewGifDrawable.getNumberOfFrames() != 0)
      {
        double d1 = paramInt;
        Double.isNaN(d1);
        double d2 = paramNewGifDrawable.getNumberOfFrames();
        Double.isNaN(d2);
        localHashMap.put("fail_frame", String.valueOf(d1 * 1.0D / d2));
      }
      ImageManagerEnv.g().statisticCollectorReport("gifPlayingFailCountReport", localHashMap);
    }
  }
  
  public void doWork()
  {
    for (;;)
    {
      long l2;
      try
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        if (this.mGifDrawable.getCurrentModel() == 4)
        {
          localObject1 = ImageManagerEnv.getLogger();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("doWork | ====mCurrentIndex:");
          ((StringBuilder)localObject3).append(this.mGifDrawable.getCurrentFrameIndex());
          ((StringBuilder)localObject3).append(" mGifDrawable.isEndDownload:");
          ((StringBuilder)localObject3).append(this.mGifDrawable.isEndDownload);
          ((StringBuilder)localObject3).append(" mHashcode:");
          ((StringBuilder)localObject3).append(this.mGifDrawable.mHashcode);
          ((ILog)localObject1).d("NewGifDrawable", new Object[] { ((StringBuilder)localObject3).toString() });
          localObject1 = this.mGifDrawable.mGifDecoder.nextForGifPlay(this.mGifDrawable.mBuffer, this.mGifDrawable.isEndDownload);
          if (!this.mReported)
          {
            localObject3 = (Long)ImageTaskBuilder.stampMap.remove(this.mGifDrawable.getUrl());
            localObject4 = (Long)ImageTaskBuilder.stampMap2.remove(this.mGifDrawable.getUrl());
            if (localObject3 != null)
            {
              l1 = ((Long)localObject3).longValue();
              l2 = System.currentTimeMillis() - l1;
              if (localObject4 == null) {
                break label843;
              }
              l1 = System.currentTimeMillis() - ((Long)localObject4).longValue();
              localObject3 = ImageManagerEnv.getLogger();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("1 first_frame_render_cost2: ");
              ((StringBuilder)localObject4).append(l1);
              ((ILog)localObject3).d("NewGifDrawable", new Object[] { ((StringBuilder)localObject4).toString() });
              localObject3 = ImageManagerEnv.getLogger();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("1 first_frame_render_cost: ");
              ((StringBuilder)localObject4).append(l2);
              ((ILog)localObject3).d("NewGifDrawable", new Object[] { ((StringBuilder)localObject4).toString() });
              if (l1 == 0L) {
                break label848;
              }
              reportCostsTime(true, l1, this.mGifDrawable);
              this.mReported = true;
            }
          }
          localObject3 = ImageManagerEnv.getLogger();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("doWork | ====invalidationDelay:");
          ((StringBuilder)localObject4).append(((NewGifDecoder.GifFrame)localObject1).delay);
          ((ILog)localObject3).d("NewGifDrawable", new Object[] { ((StringBuilder)localObject4).toString() });
          if ((localObject1 != null) && (((NewGifDecoder.GifFrame)localObject1).delay == -1L))
          {
            if (this.startCollectFailCount) {
              this.failCount += 1;
            }
            return;
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
          this.mGifDrawable.mBuffer = ((NewGifDecoder.GifFrame)localObject1).image;
          this.invalidationDelay = ((NewGifDecoder.GifFrame)localObject1).delay;
        }
        else
        {
          this.mGifDrawable.mIsRenderingTriggeredOnDraw = true;
          localObject1 = this.mGifDrawable.mGifDecoder.next(this.mGifDrawable.mBuffer);
          if (!this.mReported)
          {
            localObject3 = (Long)ImageTaskBuilder.stampMap.remove(this.mGifDrawable.getUrl());
            if (localObject3 != null)
            {
              l1 = ((Long)localObject3).longValue();
              l1 = System.currentTimeMillis() - l1;
              localObject3 = ImageManagerEnv.getLogger();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("2 first_frame_render_cost: ");
              ((StringBuilder)localObject4).append(l1);
              ((ILog)localObject3).d("NewGifDrawable", new Object[] { ((StringBuilder)localObject4).toString() });
              reportCostsTime(false, l1, this.mGifDrawable);
              this.mReported = true;
            }
          }
          this.mGifDrawable.mBuffer = ((NewGifDecoder.GifFrame)localObject1).image;
          this.invalidationDelay = ((NewGifDecoder.GifFrame)localObject1).delay;
          this.mCurrentIndex = ((this.mCurrentIndex + 1) % this.mGifDrawable.getNumberOfFrames());
        }
        if (this.invalidationDelay >= 0L)
        {
          this.mGifDrawable.mNextFrameRenderTime = (SystemClock.uptimeMillis() + this.invalidationDelay);
          if ((!this.mGifDrawable.mListeners.isEmpty()) && (this.mGifDrawable.getCurrentFrameIndex() == this.mGifDrawable.getNumberOfFrames() - 1)) {
            this.mGifDrawable.scheduleSelf(this.mNotifyListenersTask, this.mGifDrawable.mNextFrameRenderTime);
          }
        }
        else
        {
          this.mGifDrawable.mNextFrameRenderTime = -9223372036854775808L;
          this.mGifDrawable.mIsRunning = false;
        }
        if ((this.mGifDrawable.isVisible()) && (!this.mGifDrawable.mInvalidationHandler.hasMessages(0)) && (this.mGifDrawable.getCallback() != null)) {
          this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
        return;
      }
      finally {}
      label843:
      long l1 = 0L;
      continue;
      label848:
      l1 = l2;
    }
  }
  
  public long getFrameDelay()
  {
    return this.invalidationDelay;
  }
  
  public void waitFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.gif.RenderTask
 * JD-Core Version:    0.7.0.1
 */