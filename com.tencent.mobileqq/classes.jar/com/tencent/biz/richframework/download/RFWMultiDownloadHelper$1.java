package com.tencent.biz.richframework.download;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class RFWMultiDownloadHelper$1
  implements RFWDownloader.RFWDownloadListener
{
  RFWMultiDownloadHelper$1(RFWMultiDownloadHelper paramRFWMultiDownloadHelper, RFWMultiDownloadHelper.DownloadTask paramDownloadTask, int paramInt) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    paramString = new RFWMultiDownloadHelper.DownloadResult(this.val$task.mDownloadUrl, paramBoolean, paramString);
    if (RFWMultiDownloadHelper.access$000(this.this$0) != null) {
      RFWMultiDownloadHelper.access$000(this.this$0).put(this.val$task.mDownloadUrl, paramString);
    }
    if (paramBoolean) {
      RFWMultiDownloadHelper.access$100(this.this$0).incrementAndGet();
    } else {
      RFWMultiDownloadHelper.access$200(this.this$0).incrementAndGet();
    }
    if ((RFWMultiDownloadHelper.access$100(this.this$0).get() + RFWMultiDownloadHelper.access$200(this.this$0).get() == this.val$taskCount) && (RFWMultiDownloadHelper.access$300(this.this$0) != null))
    {
      paramString = (RFWMultiDownloadHelper.MultiDownloadResultListener)RFWMultiDownloadHelper.access$300(this.this$0).get();
      if (paramString != null)
      {
        if (RFWMultiDownloadHelper.access$200(this.this$0).get() == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString.onDownloadResult(paramBoolean, RFWMultiDownloadHelper.access$000(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWMultiDownloadHelper.1
 * JD-Core Version:    0.7.0.1
 */