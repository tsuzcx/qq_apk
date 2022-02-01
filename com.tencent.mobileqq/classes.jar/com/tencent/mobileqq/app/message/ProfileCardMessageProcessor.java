package com.tencent.mobileqq.app.message;

import IMMsgBodyPack.PersonInfoChange;
import IMMsgBodyPack.PersonInfoField;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.OnLinePushParamReturnMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ProfileCardMessageProcessor
  extends BaseMessageProcessor
{
  public ProfileCardMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(MsgInfo paramMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "Recieved user info update");
    }
    paramMsgInfo = new JceInputStream(paramMsgInfo.vMsg);
    paramMsgInfo.setServerEncoding("utf-8");
    PersonInfoChange localPersonInfoChange = new PersonInfoChange();
    localPersonInfoChange.readFrom(paramMsgInfo);
    int j;
    int i;
    long l;
    int k;
    if (localPersonInfoChange.cType == 0)
    {
      paramMsgInfo = localPersonInfoChange.vChgField.iterator();
      j = 0;
      i = 0;
      if (paramMsgInfo.hasNext())
      {
        l = ((PersonInfoField)paramMsgInfo.next()).uField;
        if ((l == 20015L) || (l == 10009L))
        {
          k = 1;
          j = i;
          i = k;
        }
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if ((l == 20002L) || (l == 20009L) || (l == 20031L) || (l == 20019L))
      {
        i = j;
        j = 1;
        continue;
        if (this.a != null)
        {
          paramMsgInfo = (IQQAvatarHandlerService)this.a.getRuntimeService(IQQAvatarHandlerService.class, "");
          if (j != 0) {
            paramMsgInfo.getCustomHead(this.a.getAccount());
          }
          if (i != 0) {
            BaseApplicationImpl.sUiHandler.postDelayed(new ProfileCardMessageProcessor.1(this), 150L);
          }
        }
        do
        {
          return;
        } while ((localPersonInfoChange.cType != 1) || (!QLog.isColorLevel()));
        QLog.d("MessageHandler", 2, "group data update push");
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public OnLinePushParamReturnMsg a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new OnLinePushParamReturnMsg(null, false);
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        a(paramMsgInfo);
      } else {
        a(getClass().getName(), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor
 * JD-Core Version:    0.7.0.1
 */