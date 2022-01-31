package com.tencent.image;

import com.tencent.qphone.base.util.QLog;

class URLState$2
  extends URLDrawableHandler.Adapter
{
  URLState$2(URLState paramURLState, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.this$0.mParams.useApngImage = false;
    onFileDownloadSucceed(0L);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    try
    {
      Object localObject = this.this$0.loadImage(this.this$0.mUrl, this.val$handler);
      if (localObject != URLState.DOWNLOAD_ASYNC) {
        URLState.access$300(this.this$0, localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("URLDrawable_", 1, "ApngSoLoader error: ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState.2
 * JD-Core Version:    0.7.0.1
 */