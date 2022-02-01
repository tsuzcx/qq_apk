package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class TransserviceRoamRefreshCommenMsg
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    if (paramInt != 999)
    {
      if (paramInt != 1000)
      {
        if (paramInt != 3011)
        {
          if (paramInt != 3012)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return;
              case 2002: 
                paramMessageObserver.recentListRefresh();
                return;
              case 2001: 
                paramMessageObserver.troopListRefresh();
                return;
              }
              paramMessageObserver.friendsListRefresh();
              return;
            case 1005: 
              paramMessageObserver.setRoamChat(paramBoolean);
              return;
            case 1004: 
              paramMessageObserver.getRoamChat(paramBoolean, paramObject);
              return;
            case 1003: 
              paramMessageObserver.delRoamChatFriend(paramBoolean);
              return;
            }
            paramMessageObserver.msgDelFriend(paramArrayOfObject);
            return;
          }
          paramMessageObserver.transserviceTempChatDownloadPic(paramBoolean, paramArrayOfObject);
          return;
        }
        paramMessageObserver.transserviceC2CUploadStreamPtt(paramBoolean, paramArrayOfObject);
        return;
      }
      paramMessageObserver.comenMsgReceived();
      return;
    }
    paramMessageObserver.commenMsgContentChanged(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.TransserviceRoamRefreshCommenMsg
 * JD-Core Version:    0.7.0.1
 */