package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient.Observer;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;

class PublicAccountH5AbilityPluginImpl$7$3
  implements QQProgressDialog.Callback
{
  PublicAccountH5AbilityPluginImpl$7$3(PublicAccountH5AbilityPluginImpl.7 param7, IVideoFeedsIPCClient.Observer paramObserver) {}
  
  public void a()
  {
    this.b.this$0.mVideoIPCClient.removeObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.7.3
 * JD-Core Version:    0.7.0.1
 */