package com.tencent.component.media.image;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ImageManager$14
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Qzone_ImageManager_decode_ThreadPool_");
    localStringBuilder.append(ImageManager.access$2900().getAndIncrement());
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.14
 * JD-Core Version:    0.7.0.1
 */