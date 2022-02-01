package com.bumptech.glide.load.resource.gif;

import android.os.Handler.Callback;
import android.os.Message;
import com.bumptech.glide.RequestManager;

class GifFrameLoader$FrameLoaderCallback
  implements Handler.Callback
{
  GifFrameLoader$FrameLoaderCallback(GifFrameLoader paramGifFrameLoader) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (GifFrameLoader.DelayTarget)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (GifFrameLoader.DelayTarget)paramMessage.obj;
      this.a.a.a(paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameLoaderCallback
 * JD-Core Version:    0.7.0.1
 */