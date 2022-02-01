package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;

class PublicAccountChatPie$49
  implements Runnable
{
  PublicAccountChatPie$49(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    if (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getMsgID(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != 0L) {}
    for (;;)
    {
      return;
      Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (((localObject2 instanceof MessageForStructing)) || ((localObject2 instanceof MessageForPubAccount)))
          {
            localObject2 = ((ChatMessage)localObject2).getExtInfoFromExtStr("pa_msgId");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              try
              {
                long l = Long.parseLong((String)localObject2);
                if (l > 0L)
                {
                  ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setMsgID(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, l);
                  return;
                }
              }
              catch (Exception localException) {}
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.49
 * JD-Core Version:    0.7.0.1
 */