package com.tencent.mobileqq.activity.aio.rebuild;

import aegy;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import java.util.Iterator;
import java.util.List;
import ncw;

public class PublicAccountChatPie$45
  implements Runnable
{
  public PublicAccountChatPie$45(aegy paramaegy) {}
  
  public void run()
  {
    if (ncw.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != 0L) {}
    for (;;)
    {
      return;
      Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
                  ncw.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.45
 * JD-Core Version:    0.7.0.1
 */