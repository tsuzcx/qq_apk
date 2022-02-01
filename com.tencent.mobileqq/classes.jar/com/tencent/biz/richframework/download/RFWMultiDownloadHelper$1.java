package com.tencent.biz.richframework.download;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

class RFWMultiDownloadHelper$1
  implements RFWDownloader.GetFileListener
{
  RFWMultiDownloadHelper$1(RFWMultiDownloadHelper paramRFWMultiDownloadHelper, RFWMultiDownloadHelper.DownloadTask paramDownloadTask, int paramInt) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    paramString = new RFWMultiDownloadHelper.DownloadResult(this.val$task.mDownloadUrl, paramBoolean, paramString);
    RFWMultiDownloadHelper.access$000(this.this$0).put(this.val$task.mDownloadUrl, paramString);
    if (paramBoolean)
    {
      RFWMultiDownloadHelper.access$100(this.this$0).incrementAndGet();
      if ((RFWMultiDownloadHelper.access$100(this.this$0).get() + RFWMultiDownloadHelper.access$200(this.this$0).get() == this.val$taskCount) && (RFWMultiDownloadHelper.access$300(this.this$0) != null))
      {
        paramString = (RFWMultiDownloadHelper.MultiDownloadResultListener)RFWMultiDownloadHelper.access$300(this.this$0).get();
        if (paramString != null) {
          if (RFWMultiDownloadHelper.access$200(this.this$0).get() != 0) {
            break label153;
          }
        }
      }
    }
    label153:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.onDownloadResult(paramBoolean, RFWMultiDownloadHelper.access$000(this.this$0));
      return;
      RFWMultiDownloadHelper.access$200(this.this$0).incrementAndGet();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWMultiDownloadHelper.1
 * JD-Core Version:    0.7.0.1
 */