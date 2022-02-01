package com.tencent.livesdk.servicefactory.builder.roomaudience;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceAdapter;
import com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceAdapter.IUserInfoBack;
import com.tencent.ilivesdk.roomaudienceservice_interface.UserServer;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RoomAudienceServiceBuilder$1
  implements RoomAudienceServiceAdapter
{
  RoomAudienceServiceBuilder$1(RoomAudienceServiceBuilder paramRoomAudienceServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceAccessor.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceAccessor.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceAccessor.getService(DataReportInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
  
  public void queryUsersInfo(List<UserServer> paramList, RoomAudienceServiceAdapter.IUserInfoBack paramIUserInfoBack)
  {
    UserInfoServiceInterface localUserInfoServiceInterface = (UserInfoServiceInterface)this.val$serviceAccessor.getService(UserInfoServiceInterface.class);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(Long.valueOf(((UserServer)localIterator.next()).uin));
    }
    localUserInfoServiceInterface.batchQueryUserInfos(localLinkedList, new RoomAudienceServiceBuilder.1.1(this, paramList, paramIUserInfoBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roomaudience.RoomAudienceServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */