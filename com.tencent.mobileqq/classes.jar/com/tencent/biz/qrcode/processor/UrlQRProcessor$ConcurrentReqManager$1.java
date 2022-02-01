package com.tencent.biz.qrcode.processor;

import android.os.Bundle;
import com.tencent.mobileqq.qrscan.QRCodeBusinessObserver;

class UrlQRProcessor$ConcurrentReqManager$1
  extends QRCodeBusinessObserver
{
  UrlQRProcessor$ConcurrentReqManager$1(UrlQRProcessor.ConcurrentReqManager paramConcurrentReqManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onReceive(paramInt, paramBoolean, paramBundle);
    UrlQRProcessor.ConcurrentReqManager.a(this.a, new UrlQRProcessor.ConcurrentReqManager.UrlDecodeReqResult(paramInt, paramBoolean, paramBundle));
    UrlQRProcessor.ConcurrentReqManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.UrlQRProcessor.ConcurrentReqManager.1
 * JD-Core Version:    0.7.0.1
 */