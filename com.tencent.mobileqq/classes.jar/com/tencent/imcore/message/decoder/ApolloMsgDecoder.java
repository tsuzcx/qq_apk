package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class ApolloMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2039) {
      ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).decodeBaseMsgApollo(paramAppRuntime, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.ApolloMsgDecoder
 * JD-Core Version:    0.7.0.1
 */