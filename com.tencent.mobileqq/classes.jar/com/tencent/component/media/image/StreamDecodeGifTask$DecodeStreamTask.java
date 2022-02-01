package com.tencent.component.media.image;

import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

class StreamDecodeGifTask$DecodeStreamTask
  implements Runnable
{
  private ImageKey key = null;
  String path = null;
  String url = null;
  
  public StreamDecodeGifTask$DecodeStreamTask(StreamDecodeGifTask paramStreamDecodeGifTask, ImageKey paramImageKey, String paramString1, String paramString2)
  {
    this.key = paramImageKey;
    this.url = paramString1;
    this.path = paramString2;
  }
  
  public void run()
  {
    try
    {
      if (!this.this$0.isCanceled()) {
        StreamDecodeGifTask.access$200(this.this$0, this.key, this.url, this.path);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { "DecodeStreamTask error : " + localThrowable.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.StreamDecodeGifTask.DecodeStreamTask
 * JD-Core Version:    0.7.0.1
 */