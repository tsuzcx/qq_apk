package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PublicAccountChatPie$7
  implements Runnable
{
  PublicAccountChatPie$7(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    if (PublicAccountChatPie.a(this.this$0) > 0)
    {
      int j = PublicAccountChatPie.a(this.this$0);
      int i = j;
      if (j > 2) {
        i = 2;
      }
      localObject = this.this$0.a.getMessageFacade().a("2747277822", 1008, i);
      ((IApolloExtensionHandler)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(2, (List)localObject);
    }
    Object localObject = ((IGamePubAccountMsgService)this.this$0.a.getRuntimeService(IGamePubAccountMsgService.class, "")).findArkMessage("2747277822", 100, 100).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName)) {
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify(localQQGameMsgInfo.arkAppName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7
 * JD-Core Version:    0.7.0.1
 */