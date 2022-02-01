package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
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
      Object localObject1 = (BaseChatPie)this.this$0.a.get();
      if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        Object localObject2 = ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject1);
        if (localObject2 != null)
        {
          if (!((ChatPieApolloViewController)localObject2).a()) {
            return;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_a_of_type_JavaLangObject == null) {
              return;
            }
            localObject2 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
            if (localObject2 != null)
            {
              if (((ArrayList)localObject2).size() == 0) {
                return;
              }
              localObject1 = SpriteUtil.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (localObject1 == null) {
                return;
              }
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                ((SpriteActionScript)localObject1).a((String)((Iterator)localObject2).next(), true);
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ChatApolloViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2
 * JD-Core Version:    0.7.0.1
 */