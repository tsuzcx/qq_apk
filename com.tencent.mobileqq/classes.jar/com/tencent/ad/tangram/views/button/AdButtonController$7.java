package com.tencent.ad.tangram.views.button;

import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloaderV2.Listener;

class AdButtonController$7
  implements AdDownloaderV2.Listener
{
  AdButtonController$7(AdButtonController paramAdButtonController) {}
  
  private boolean isCurrentTask(String paramString)
  {
    return TextUtils.equals(paramString, AdButtonController.access$000(this.this$0));
  }
  
  public void onStatusChanged(String paramString, int paramInt)
  {
    if (!isCurrentTask(paramString)) {
      return;
    }
    paramString = this.this$0;
    AdButtonController.access$100(paramString, paramInt, AdButtonController.access$500(paramString));
  }
  
  public void onStatusChanged(String paramString, int paramInt1, int paramInt2)
  {
    if (!isCurrentTask(paramString)) {
      return;
    }
    AdButtonController.access$100(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.7
 * JD-Core Version:    0.7.0.1
 */