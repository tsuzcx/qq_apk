package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class UrlQRProcessor$ConcurrentReqManager$2
  implements MiniAppCmdInterface
{
  UrlQRProcessor$ConcurrentReqManager$2(UrlQRProcessor.ConcurrentReqManager paramConcurrentReqManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    UrlQRProcessor.ConcurrentReqManager.a(this.a, new UrlQRProcessor.ConcurrentReqManager.MiniAppReqResult(paramBoolean, paramJSONObject));
    UrlQRProcessor.ConcurrentReqManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.UrlQRProcessor.ConcurrentReqManager.2
 * JD-Core Version:    0.7.0.1
 */