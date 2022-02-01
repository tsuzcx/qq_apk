package com.tencent.TMG.ptt;

import com.tencent.TMG.utils.CosFileTransfer.DownloadCosFileListener;

class PttManager$2$1
  implements CosFileTransfer.DownloadCosFileListener
{
  PttManager$2$1(PttManager.2 param2) {}
  
  public void onCompleted(int paramInt, Object paramObject)
  {
    if (this.this$1.val$monitor != null) {
      this.this$1.val$monitor.onCompleted(paramInt, this.this$1.val$savePath, this.this$1.val$downloadUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.2.1
 * JD-Core Version:    0.7.0.1
 */