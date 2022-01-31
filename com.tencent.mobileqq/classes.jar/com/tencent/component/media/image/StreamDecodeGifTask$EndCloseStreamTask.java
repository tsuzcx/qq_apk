package com.tencent.component.media.image;

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
    label687:
    for (;;)
    {
      try
      {
        NewGifDrawable localNewGifDrawable = (NewGifDrawable)ImageManager.getInstance().getDrawbleFromCache(this.key);
        if (localNewGifDrawable != null)
        {
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { " isEndDownload hashcode:" + this.key.hashCodeEx() + " filePath:" + this.filePath + " url:" + this.url });
          if ((this.key == null) || (this.key.options == null) || (!(this.key.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
            break label687;
          }
          localNewGifDrawable = (NewGifDrawable)this.key.options.extraProcessor.doProcess(localNewGifDrawable);
          localNewGifDrawable.isEndDownload();
          localNewGifDrawable.changeFile(this.filePath);
          ImageManager.getInstance().putDrawableInMemoryCache(this.key, this.key.hashCodeEx(), null, localNewGifDrawable, this.key.options);
          this.this$0.setResult(8, new Object[] { localNewGifDrawable, null, this.key.urlKey, Integer.valueOf(this.key.hashCodeEx()), null, localNewGifDrawable });
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", new Object[] { "isEndDownload hashcode:" + this.key.hashCodeEx() + "\ncost time:" + (System.currentTimeMillis() - StreamDecodeGifTask.access$000(this.this$0)) + "\nwidth:" + localNewGifDrawable.getsWidth() + " height:" + localNewGifDrawable.getsHeight() + "\nframe count:" + localNewGifDrawable.getNumberOfFrames() + "\nlength:" + localNewGifDrawable.getAllocationByteCount() + "\nnetworkstate:" + ImageManagerEnv.g().getNetWorkState() + "\ncontrolsTime:" + StreamDecodeGifTask.access$100(this.this$0) + "\nurl:" + this.url });
          if (StreamDecodeGifTask.access$000(this.this$0) == 0L) {
            break;
          }
          HashMap localHashMap = new HashMap();
          int i = (int)(System.currentTimeMillis() - StreamDecodeGifTask.access$000(this.this$0));
          if (i <= 0) {
            break;
          }
          localHashMap.put("g_costTime", String.valueOf(i));
          localHashMap.put("g_width", String.valueOf(localNewGifDrawable.getsWidth()));
          localHashMap.put("g_height", String.valueOf(localNewGifDrawable.getsHeight()));
          localHashMap.put("g_frameCount", String.valueOf(localNewGifDrawable.getNumberOfFrames()));
          localHashMap.put("g_size", String.valueOf(localNewGifDrawable.getAllocationByteCount()));
          localHashMap.put("g_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
          localHashMap.put("g_controlsTime", String.valueOf(StreamDecodeGifTask.access$100(this.this$0)));
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_costTime", i);
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_frameCount", localNewGifDrawable.getNumberOfFrames());
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_size", (int)localNewGifDrawable.getAllocationByteCount());
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_controlsTime", StreamDecodeGifTask.access$100(this.this$0));
          ImageManagerEnv.g().statisticCollectorReport("gifPlayingReportNew", localHashMap);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { "EndCloseStreamTask error :" + localThrowable.toString() });
        return;
      }
      ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { " NewGifDrawable is null url:" + this.url });
      this.this$0.startDecodeTask();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.StreamDecodeGifTask.EndCloseStreamTask
 * JD-Core Version:    0.7.0.1
 */