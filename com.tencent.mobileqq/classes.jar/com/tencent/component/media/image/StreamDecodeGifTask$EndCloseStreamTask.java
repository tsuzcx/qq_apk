package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import java.util.HashMap;

class StreamDecodeGifTask$EndCloseStreamTask
  implements Runnable
{
  String filePath = null;
  private ImageKey key = null;
  String url = null;
  
  public StreamDecodeGifTask$EndCloseStreamTask(StreamDecodeGifTask paramStreamDecodeGifTask, ImageKey paramImageKey, String paramString1, String paramString2)
  {
    this.key = paramImageKey;
    this.url = paramString1;
    this.filePath = paramString2;
  }
  
  public void run()
  {
    if (this.this$0.isCanceled()) {
      return;
    }
    try
    {
      localObject2 = (NewGifDrawable)ImageManager.getInstance().getDrawbleFromCache(this.key);
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = ImageManagerEnv.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" isEndDownload hashcode:");
        localStringBuilder.append(this.key.hashCodeEx());
        localStringBuilder.append(" filePath:");
        localStringBuilder.append(this.filePath);
        localStringBuilder.append(" url:");
        localStringBuilder.append(this.url);
        ((ILog)localObject1).d("StreamDecodeGifTask-decoding-thread", new Object[] { localStringBuilder.toString() });
        localObject1 = localObject2;
        if (this.key != null)
        {
          localObject1 = localObject2;
          if (this.key.options != null)
          {
            localObject1 = localObject2;
            if ((this.key.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
              localObject1 = (NewGifDrawable)this.key.options.extraProcessor.doProcess((Drawable)localObject2);
            }
          }
        }
        ((NewGifDrawable)localObject1).isEndDownload();
        ((NewGifDrawable)localObject1).changeFile(this.filePath);
        ImageManager.getInstance().putDrawableInMemoryCache(this.key, this.key.hashCodeEx(), null, (Drawable)localObject1, this.key.options);
        this.this$0.setResult(8, new Object[] { localObject1, null, this.key.urlKey, Integer.valueOf(this.key.hashCodeEx()), null, localObject1 });
        localObject2 = ImageManagerEnv.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isEndDownload hashcode:");
        localStringBuilder.append(this.key.hashCodeEx());
        localStringBuilder.append("\ncost time:");
        localStringBuilder.append(System.currentTimeMillis() - StreamDecodeGifTask.access$000(this.this$0));
        localStringBuilder.append("\nwidth:");
        localStringBuilder.append(((NewGifDrawable)localObject1).getsWidth());
        localStringBuilder.append(" height:");
        localStringBuilder.append(((NewGifDrawable)localObject1).getsHeight());
        localStringBuilder.append("\nframe count:");
        localStringBuilder.append(((NewGifDrawable)localObject1).getNumberOfFrames());
        localStringBuilder.append("\nlength:");
        localStringBuilder.append(((NewGifDrawable)localObject1).getAllocationByteCount());
        localStringBuilder.append("\nnetworkstate:");
        localStringBuilder.append(ImageManagerEnv.g().getNetWorkState());
        localStringBuilder.append("\ncontrolsTime:");
        localStringBuilder.append(StreamDecodeGifTask.access$100(this.this$0));
        localStringBuilder.append("\nurl:");
        localStringBuilder.append(this.url);
        ((ILog)localObject2).d("StreamDecodeGifTask-performance", new Object[] { localStringBuilder.toString() });
        if (StreamDecodeGifTask.access$000(this.this$0) != 0L)
        {
          localObject2 = new HashMap();
          int i = (int)(System.currentTimeMillis() - StreamDecodeGifTask.access$000(this.this$0));
          if (i > 0)
          {
            ((HashMap)localObject2).put("g_costTime", String.valueOf(i));
            ((HashMap)localObject2).put("g_width", String.valueOf(((NewGifDrawable)localObject1).getsWidth()));
            ((HashMap)localObject2).put("g_height", String.valueOf(((NewGifDrawable)localObject1).getsHeight()));
            ((HashMap)localObject2).put("g_frameCount", String.valueOf(((NewGifDrawable)localObject1).getNumberOfFrames()));
            ((HashMap)localObject2).put("g_size", String.valueOf(((NewGifDrawable)localObject1).getAllocationByteCount()));
            ((HashMap)localObject2).put("g_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
            ((HashMap)localObject2).put("g_controlsTime", String.valueOf(StreamDecodeGifTask.access$100(this.this$0)));
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_costTime", i);
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_frameCount", ((NewGifDrawable)localObject1).getNumberOfFrames());
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_size", (int)((NewGifDrawable)localObject1).getAllocationByteCount());
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_controlsTime", StreamDecodeGifTask.access$100(this.this$0));
            ImageManagerEnv.g().statisticCollectorReport("gifPlayingReportNew", (HashMap)localObject2);
          }
        }
      }
      else
      {
        localObject1 = ImageManagerEnv.getLogger();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" NewGifDrawable is null url:");
        ((StringBuilder)localObject2).append(this.url);
        ((ILog)localObject1).e("StreamDecodeGifTask-decoding-thread", new Object[] { ((StringBuilder)localObject2).toString() });
        this.this$0.startDecodeTask();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EndCloseStreamTask error :");
      localStringBuilder.append(localThrowable.toString());
      ((ILog)localObject2).e("StreamDecodeGifTask-decoding-thread", new Object[] { localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.StreamDecodeGifTask.EndCloseStreamTask
 * JD-Core Version:    0.7.0.1
 */