package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.concurrent.CountDownLatch;

class TRTCCustomTextureUtil$2
  implements Runnable
{
  TRTCCustomTextureUtil$2(TRTCCustomTextureUtil paramTRTCCustomTextureUtil, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    TXCLog.i("TRTCCustomTextureUtil", "GLContext create finished!");
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil.2
 * JD-Core Version:    0.7.0.1
 */