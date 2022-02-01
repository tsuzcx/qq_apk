package com.tencent.ilivesdk.supervisionservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface SupervisionServiceInterface
  extends ServiceBaseInterface
{
  public abstract BanChatInterface getBanChatInterface();
  
  public abstract BlockInterface getBlockInterface();
  
  public abstract KickOutRoomInterface getKickOutRoomInterface();
  
  public abstract PersonalMessageInterface getPersonalMessageInterface();
  
  public abstract ReportInterface getReportInterface();
  
  public abstract RoomAdminInterface getRoomAdminInterface();
  
  public abstract void init(SupervisionServiceAdapter paramSupervisionServiceAdapter);
  
  public abstract void querySupervisionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.SupervisionServiceInterface
 * JD-Core Version:    0.7.0.1
 */