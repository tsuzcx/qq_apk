package com.tencent.kwstudio.office.preview;

import android.text.TextUtils;
import com.tencent.kwstudio.office.base.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class TdsReaderHelper$1
  implements IHostInterface.IDownloadListener
{
  TdsReaderHelper$1(String paramString, AtomicBoolean paramAtomicBoolean) {}
  
  public void onDownloadFinished(String arg1, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((TextUtils.equals(???, this.val$pluginName)) && (paramBoolean))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Plugin[");
      localStringBuilder.append(???);
      localStringBuilder.append("] is downloaded.");
      Log.v("TdsReaderHelper", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download plugin[");
      localStringBuilder.append(???);
      localStringBuilder.append("], succeed=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", error=");
      localStringBuilder.append(paramInt);
      Log.e("TdsReaderHelper", localStringBuilder.toString());
    }
    this.val$isDownloading.set(false);
    synchronized (this.val$isDownloading)
    {
      this.val$isDownloading.notifyAll();
      return;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Downloading plugin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], total=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(paramFloat);
    Log.d("TdsReaderHelper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.TdsReaderHelper.1
 * JD-Core Version:    0.7.0.1
 */