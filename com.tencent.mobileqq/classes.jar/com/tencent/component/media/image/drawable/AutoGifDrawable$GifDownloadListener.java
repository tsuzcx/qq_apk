package com.tencent.component.media.image.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.utils.ImageManagerLog;

class AutoGifDrawable$GifDownloadListener
  implements ImageLoader.ImageLoadListener
{
  private AutoGifDrawable$GifDownloadListener(AutoGifDrawable paramAutoGifDrawable) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
  {
    if (this.this$0.gifDownloadCallBackListener != null) {
      this.this$0.gifDownloadCallBackListener.onImageCanceled(paramString, paramOptions);
    }
  }
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    if (this.this$0.gifDownloadCallBackListener != null) {
      this.this$0.gifDownloadCallBackListener.onImageFailed(paramString, paramOptions);
    }
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramDrawable != null) && ((paramDrawable instanceof NewGifDrawable))) {
      try
      {
        this.this$0.realDrawable = ((NewGifDrawable)paramDrawable);
        this.this$0.realDrawable.setCallback(AutoGifDrawable.access$200(this.this$0));
        if (this.this$0.gifDownloadCallBackListener != null)
        {
          this.this$0.gifDownloadCallBackListener.onImageLoaded(paramString, this.this$0.realDrawable, paramOptions);
          return;
        }
      }
      catch (NullPointerException paramString)
      {
        paramDrawable = AutoGifDrawable.access$100();
        paramOptions = new StringBuilder();
        paramOptions.append("catch an exception:");
        paramOptions.append(Log.getStackTraceString(paramString));
        ImageManagerLog.e(paramDrawable, paramOptions.toString());
      }
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
  {
    if (this.this$0.gifDownloadCallBackListener != null) {
      this.this$0.gifDownloadCallBackListener.onImageProgress(paramString, paramFloat, paramOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadListener
 * JD-Core Version:    0.7.0.1
 */