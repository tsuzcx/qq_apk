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
    if ((TextUtils.equals(???, this.val$pluginName)) && (paramBoolean)) {
      Log.v("TdsReaderHelper", "Plugin[" + ??? + "] is downloaded.");
    }
    for (;;)
    {
      this.val$isDownloading.set(false);
      synchronized (this.val$isDownloading)
      {
        this.val$isDownloading.notifyAll();
        return;
        Log.e("TdsReaderHelper", "Download plugin[" + ??? + "], succeed=" + paramBoolean + ", error=" + paramInt);
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    Log.d("TdsReaderHelper", "Downloading plugin[" + paramString + "], total=" + paramLong + ", progress=" + paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.TdsReaderHelper.1
 * JD-Core Version:    0.7.0.1
 */