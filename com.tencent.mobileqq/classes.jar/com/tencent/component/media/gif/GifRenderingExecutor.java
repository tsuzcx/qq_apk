package com.tencent.component.media.gif;

import com.tencent.component.media.ImageManagerEnv;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

public final class GifRenderingExecutor
  extends ScheduledThreadPoolExecutor
{
  private static volatile GifRenderingExecutor a = null;
  
  private GifRenderingExecutor()
  {
    super(2, new ThreadPoolExecutor.DiscardPolicy());
    setMaximumPoolSize(ImageManagerEnv.g().getMaxGifRenderThreadNum());
  }
  
  public static GifRenderingExecutor getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new GifRenderingExecutor();
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.GifRenderingExecutor
 * JD-Core Version:    0.7.0.1
 */