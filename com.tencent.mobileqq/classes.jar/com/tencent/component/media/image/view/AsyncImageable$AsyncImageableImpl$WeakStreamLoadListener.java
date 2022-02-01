package com.tencent.component.media.image.view;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageLoader.StreamDownloadListener;
import java.lang.ref.WeakReference;

class AsyncImageable$AsyncImageableImpl$WeakStreamLoadListener
  implements ImageLoader.StreamDownloadListener
{
  private WeakReference<AsyncImageable.AsyncImageableImpl> mAsyncImageableRef;
  
  public AsyncImageable$AsyncImageableImpl$WeakStreamLoadListener(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl)
  {
    this.mAsyncImageableRef = new WeakReference(paramAsyncImageableImpl);
  }
  
  private AsyncImageable.AsyncImageableImpl getAsyncImageable()
  {
    return (AsyncImageable.AsyncImageableImpl)this.mAsyncImageableRef.get();
  }
  
  public void onApplyToImage(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    paramOptions = getAsyncImageable();
    if (paramOptions == null) {}
    while (AsyncImageable.AsyncImageableImpl.access$400(paramOptions, paramString)) {
      return;
    }
    AsyncImageable.AsyncImageableImpl.access$700(paramOptions, paramDrawable, true);
  }
  
  public void onDownloadCanceled(String paramString1, String paramString2, String paramString3) {}
  
  public void onDownloadFailed(String paramString1, String paramString2, String paramString3) {}
  
  public void onDownloadProgress(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt) {}
  
  public void onDownloadSucceed(String paramString1, String paramString2, String paramString3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.WeakStreamLoadListener
 * JD-Core Version:    0.7.0.1
 */