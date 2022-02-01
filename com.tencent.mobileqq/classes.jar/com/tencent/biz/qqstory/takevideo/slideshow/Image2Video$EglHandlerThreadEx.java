package com.tencent.biz.qqstory.takevideo.slideshow;

import android.opengl.EGLContext;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import java.lang.ref.WeakReference;

public class Image2Video$EglHandlerThreadEx
  extends EglHandlerThread
{
  private WeakReference<Object> a;
  
  public Image2Video$EglHandlerThreadEx(String paramString, EGLContext paramEGLContext, Object paramObject)
  {
    super(paramString, paramEGLContext);
    if (paramObject != null) {
      this.a = new WeakReference(paramObject);
    }
  }
  
  public void onLooperPrepared()
  {
    super.onLooperPrepared();
    if (this.a != null)
    {
      Object localObject1 = this.a.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx
 * JD-Core Version:    0.7.0.1
 */