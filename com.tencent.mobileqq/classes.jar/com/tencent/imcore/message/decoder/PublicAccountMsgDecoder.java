package com.tencent.imcore.message.decoder;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class PublicAccountMsgDecoder
  implements IMessageDecoder
{
  private boolean a(Message paramMessage)
  {
    return (paramMessage.msgtype == -3006) || (paramMessage.msgtype == -5004);
  }
  
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (a(paramMessage)) {
      if (paramMessage.msgtype == -3006)
      {
        paramIMessageManager = (QQAppInterface)paramAppRuntime;
        paramMessage.msg = MessageForPubAccount.getMsgSummary(paramIMessageManager, paramMessage, false);
        if (paramMessage.istroop == 1) {
          paramMessage.nickName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(paramIMessageManager, BaseApplication.getContext());
        }
      }
      else
      {
        paramMessage.msg = paramAppRuntime.getApp().getString(2131694677);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.PublicAccountMsgDecoder
 * JD-Core Version:    0.7.0.1
 */