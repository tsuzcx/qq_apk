package com.tencent.ilivesdk.playview.data;

public class VideoImage
{
  public static long INDEX = -1L;
  private static final int MAX_POOL_SIZE = 20;
  private static VideoImage sPool;
  private static final Object sPoolLock = new Object();
  private static int sPoolSize = 0;
  public byte[] content;
  public boolean deleteFlag = false;
  public int height;
  public long index = 0L;
  public boolean mIsFree = false;
  public int mOutputImageDataType = -1;
  protected VideoImage next;
  public int seq;
  public long timestamp;
  public int type;
  public int width;
  
  public VideoImage()
  {
    INDEX += 1L;
    this.index = INDEX;
    this.mIsFree = false;
  }
  
  protected VideoImage(int paramInt1, int paramInt2)
  {
    INDEX += 1L;
    this.index = INDEX;
    this.mIsFree = false;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public static void createImagePool(int paramInt1, int paramInt2)
  {
    INDEX = -1L;
    releasePool();
    int i = 0;
    while (i < 20)
    {
      new VideoImage(paramInt1, paramInt2).recycle();
      i += 1;
    }
  }
  
  public static VideoImage obtain()
  {
    synchronized (sPoolLock)
    {
      if (sPool != null)
      {
        VideoImage localVideoImage = sPool;
        sPool = localVideoImage.next;
        localVideoImage.next = null;
        sPoolSize -= 1;
        localVideoImage.mIsFree = false;
        return localVideoImage;
      }
      return new VideoImage();
    }
  }
  
  public static VideoImage obtainSafely()
  {
    VideoImage localVideoImage;
    synchronized (sPoolLock)
    {
      localVideoImage = sPool;
      if (localVideoImage != null) {}
    }
    try
    {
      sPoolLock.wait(40L);
      label23:
      if (sPool != null)
      {
        localVideoImage = sPool;
        sPool = localVideoImage.next;
        localVideoImage.next = null;
        sPoolSize -= 1;
        localVideoImage.mIsFree = false;
        return localVideoImage;
      }
      return null;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }
  
  public static void releasePool()
  {
    synchronized (sPoolLock)
    {
      if (sPool != null)
      {
        VideoImage localVideoImage = sPool;
        sPool = localVideoImage.next;
        localVideoImage.next = null;
        sPoolSize -= 1;
      }
    }
  }
  
  public void clear()
  {
    this.type = 0;
    this.seq = 0;
    this.timestamp = 0L;
    this.next = null;
    this.deleteFlag = false;
  }
  
  public void recycle()
  {
    if (this.mIsFree) {
      return;
    }
    clear();
    synchronized (sPoolLock)
    {
      if (sPoolSize < 20)
      {
        this.mIsFree = true;
        this.next = sPool;
        sPool = this;
        sPoolSize += 1;
        sPoolLock.notifyAll();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.data.VideoImage
 * JD-Core Version:    0.7.0.1
 */