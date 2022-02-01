package com.tencent.image;

import android.os.Handler;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.net.URL;
import org.apache.http.HttpException;

class URLState$3
  extends URLDrawableHandler.Adapter
{
  URLState$3(URLState paramURLState, URL paramURL, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    super.onFileDownloadFailed(paramInt);
    this.val$handler.onFileDownloadFailed(paramInt);
    URLState.access$000(this.this$0, new HttpException(" http error code " + paramInt));
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    super.onFileDownloadSucceed(paramLong);
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.i("URLDrawable_", 2, "async onFileDownloadSucceed.");
    }
    try
    {
      if (this.this$0.mProtocolDownloader.hasDiskFile(this.this$0.mParams))
      {
        if (this.this$0.mTask != null)
        {
          this.this$0.mTask.run();
          return;
        }
        Object localObject = this.this$0.loadImage(this.val$url, this.val$handler);
        this.val$handler.onFileDownloadSucceed(paramLong);
        URLState.access$100().post(new URLState.3.1(this, localObject));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState.3
 * JD-Core Version:    0.7.0.1
 */