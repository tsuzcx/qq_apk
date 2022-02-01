package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class ChatApolloViewListener$2
  implements Runnable
{
  ChatApolloViewListener$2(ChatApolloViewListener paramChatApolloViewListener, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.a == null) {
        return;
      }
      Object localObject2 = (BaseChatPie)this.this$0.a.get();
      if ((localObject2 != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a()) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null))
      {
        Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          localObject2 = SpriteUtil.a(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localObject2 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((SpriteActionScript)localObject2).a((String)((Iterator)localObject1).next(), true);
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ChatApolloViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2
 * JD-Core Version:    0.7.0.1
 */