package com.tencent.biz.subscribe.framework;

import android.os.Handler;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

class BaseVideoView$1
  implements SDKInitListener
{
  BaseVideoView$1(BaseVideoView paramBaseVideoView) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    this.a.a().post(new BaseVideoView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.1
 * JD-Core Version:    0.7.0.1
 */