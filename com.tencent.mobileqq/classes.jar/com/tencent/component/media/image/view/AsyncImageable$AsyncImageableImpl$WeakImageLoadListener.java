package com.tencent.component.media.image.view;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import java.lang.ref.WeakReference;

class AsyncImageable$AsyncImageableImpl$WeakImageLoadListener
  implements ImageLoader.ImageLoadListener
{
  private WeakReference<AsyncImageable.AsyncImageableImpl> mAsyncImageableRef;
  
  public AsyncImageable$AsyncImageableImpl$WeakImageLoadListener(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl)
  {
    this.mAsyncImageableRef = new WeakReference(paramAsyncImageableImpl);
  }
  
  private AsyncImageable.AsyncImageableImpl getAsyncImageable()
  {
    return (AsyncImageable.AsyncImageableImpl)this.mAsyncImageableRef.get();
  }
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    paramOptions = getAsyncImageable();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.access$400(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.access$500(paramOptions);
    AsyncImageable.AsyncImageableImpl.access$000(paramOptions);
    AsyncImageable.AsyncImageableImpl.access$600(paramOptions);
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    paramOptions = getAsyncImageable();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.access$400(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.access$700(paramOptions, paramDrawable, true);
    AsyncImageable.AsyncImageableImpl.access$800(paramOptions);
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
  {
    paramOptions = getAsyncImageable();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.access$400(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.access$900(paramOptions, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.WeakImageLoadListener
 * JD-Core Version:    0.7.0.1
 */