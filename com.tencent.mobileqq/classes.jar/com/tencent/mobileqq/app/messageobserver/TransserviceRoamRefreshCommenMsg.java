package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class TransserviceRoamRefreshCommenMsg
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 999: 
      paramMessageObserver.commenMsgContentChanged(paramBoolean, paramObject);
      return;
    case 1000: 
      paramMessageObserver.comenMsgReceived();
      return;
    case 1003: 
      paramMessageObserver.delRoamChatFriend(paramBoolean);
      return;
    case 1004: 
      paramMessageObserver.getRoamChat(paramBoolean, paramObject);
      return;
    case 1005: 
      paramMessageObserver.setRoamChat(paramBoolean);
      return;
    case 2000: 
      paramMessageObserver.friendsListRefresh();
      return;
    case 2001: 
      paramMessageObserver.troopListRefresh();
      return;
    case 2002: 
      paramMessageObserver.recentListRefresh();
      return;
    case 1002: 
      paramMessageObserver.msgDelFriend(paramArrayOfObject);
      return;
    case 3012: 
      paramMessageObserver.transserviceTempChatDownloadPic(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.transserviceC2CUploadStreamPtt(paramBoolean, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.TransserviceRoamRefreshCommenMsg
 * JD-Core Version:    0.7.0.1
 */