package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;

public class ReqBlessMsgAddedSending
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    switch (paramInt)
    {
    case 8021: 
    case 8025: 
    case 8026: 
    case 8027: 
    case 8028: 
    case 8029: 
    default: 
      return;
    case 8017: 
      paramMessageObserver.reqInsertBlacklistPB(paramBoolean, paramObject);
      return;
    case 8024: 
      if (paramObject != null) {}
      for (paramArrayOfObject = ((SubAccountThirdQQBackProtocData)paramObject).a;; paramArrayOfObject = null)
      {
        paramMessageObserver.onSubAccountThirdQQUnreadMsgNum(paramBoolean, paramArrayOfObject, (SubAccountThirdQQBackProtocData)paramObject);
        return;
      }
    case 8016: 
      paramMessageObserver.msgRevokeRsp(paramBoolean, paramArrayOfObject);
      return;
    case 8018: 
      paramMessageObserver.reqBlessDirtyTextCheck(paramBoolean, paramArrayOfObject);
      return;
    case 8019: 
      paramMessageObserver.reqBlessMsg(paramBoolean, paramArrayOfObject);
      return;
    case 8020: 
      paramMessageObserver.newMessageAdded(paramObject);
      return;
    case 8022: 
      paramMessageObserver.msgStartSendingUI(paramArrayOfObject);
      return;
    case 8023: 
      paramMessageObserver.onBoxMsgUnreadNumRefresh();
      return;
    case 8030: 
      paramMessageObserver.addFriendByContact(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.onMsgForwardWXResult(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.ReqBlessMsgAddedSending
 * JD-Core Version:    0.7.0.1
 */