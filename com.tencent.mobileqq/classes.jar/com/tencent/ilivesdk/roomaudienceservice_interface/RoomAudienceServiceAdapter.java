package com.tencent.ilivesdk.roomaudienceservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.util.List;

public abstract interface RoomAudienceServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract LogInterface getLogger();
  
  public abstract void queryUsersInfo(List<UserServer> paramList, RoomAudienceServiceAdapter.IUserInfoBack paramIUserInfoBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceAdapter
 * JD-Core Version:    0.7.0.1
 */