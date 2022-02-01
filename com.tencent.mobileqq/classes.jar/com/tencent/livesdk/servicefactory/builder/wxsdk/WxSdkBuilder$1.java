package com.tencent.livesdk.servicefactory.builder.wxsdk;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.wxsdk.WxSdkAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class WxSdkBuilder$1
  implements WxSdkAdapter
{
  WxSdkBuilder$1(WxSdkBuilder paramWxSdkBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public String getWxAppKey()
  {
    return "wx87f0d936dd720581";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.wxsdk.WxSdkBuilder.1
 * JD-Core Version:    0.7.0.1
 */