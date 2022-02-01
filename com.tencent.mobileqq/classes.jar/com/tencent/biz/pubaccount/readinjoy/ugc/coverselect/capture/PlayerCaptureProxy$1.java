package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

final class PlayerCaptureProxy$1
  implements SDKInitListener
{
  public void onSDKInited(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayerCaptureProxy", 2, "onSDKInited result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.1
 * JD-Core Version:    0.7.0.1
 */