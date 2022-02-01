package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;

public class ReqBlessMsgAddedSending
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    if (paramInt != 8031)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        case 8024: 
          if (paramObject != null) {
            paramArrayOfObject = ((SubAccountThirdQQBackProtocData)paramObject).a;
          } else {
            paramArrayOfObject = null;
          }
          paramMessageObserver.onSubAccountThirdQQUnreadMsgNum(paramBoolean, paramArrayOfObject, (SubAccountThirdQQBackProtocData)paramObject);
          return;
        case 8023: 
          paramMessageObserver.onBoxMsgUnreadNumRefresh();
          return;
        }
        paramMessageObserver.msgStartSendingUI(paramArrayOfObject);
        return;
      case 8020: 
        paramMessageObserver.newMessageAdded(paramObject);
        return;
      case 8019: 
        paramMessageObserver.reqBlessMsg(paramBoolean, paramArrayOfObject);
        return;
      case 8018: 
        paramMessageObserver.reqBlessDirtyTextCheck(paramBoolean, paramArrayOfObject);
        return;
      case 8017: 
        paramMessageObserver.reqInsertBlacklistPB(paramBoolean, paramObject);
        return;
      }
      paramMessageObserver.msgRevokeRsp(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.onMsgForwardWXResult(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.ReqBlessMsgAddedSending
 * JD-Core Version:    0.7.0.1
 */