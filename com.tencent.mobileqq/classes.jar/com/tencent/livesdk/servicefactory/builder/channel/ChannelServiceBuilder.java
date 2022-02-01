package com.tencent.livesdk.servicefactory.builder.channel;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.channelservice.ChannelService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ChannelServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    ChannelService localChannelService = new ChannelService();
    localChannelService.setAdapter(new ChannelServiceBuilder.1(this, paramServiceAccessor));
    return localChannelService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.channel.ChannelServiceBuilder
 * JD-Core Version:    0.7.0.1
 */