package com.tencent.TMG.ptt;

import com.tencent.TMG.utils.CosFileTransfer.UploadCosFileListener;

class PttManager$1$1
  implements CosFileTransfer.UploadCosFileListener
{
  PttManager$1$1(PttManager.1 param1) {}
  
  public void onCompleted(int paramInt, String paramString, Object paramObject)
  {
    if (this.this$1.val$monitor != null) {
      this.this$1.val$monitor.onCompleted(paramInt, this.this$1.val$srcPath, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.1.1
 * JD-Core Version:    0.7.0.1
 */