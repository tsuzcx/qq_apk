package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import java.lang.ref.WeakReference;

public class Image2Video$EglHandlerThreadEx
  extends EglHandlerThread
{
  private WeakReference<Object> a;
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = ((WeakReference)localObject1).get();
      if (localObject1 != null) {
        try
        {
          localObject1.notify();
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx
 * JD-Core Version:    0.7.0.1
 */