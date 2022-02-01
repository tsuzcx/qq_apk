package com.tencent.component.media.image;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ImageManager$14
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "Qzone_ImageManager_decode_ThreadPool_" + ImageManager.access$2900().getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.14
 * JD-Core Version:    0.7.0.1
 */