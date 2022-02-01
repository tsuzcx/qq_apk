package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
      if (ChatApolloViewListener.a(this.this$0) == null) {
        return;
      }
      Object localObject1 = (BaseChatPie)ChatApolloViewListener.a(this.this$0).get();
      if ((localObject1 != null) && (((BaseChatPie)localObject1).ah != null))
      {
        if (((BaseChatPie)localObject1).d == null) {
          return;
        }
        Object localObject2 = ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject1);
        if (localObject2 != null)
        {
          if (!((ChatPieApolloViewController)localObject2).a()) {
            return;
          }
          if (this.a)
          {
            if (this.b == null) {
              return;
            }
            localObject2 = (ArrayList)this.b;
            if (localObject2 != null)
            {
              if (((ArrayList)localObject2).size() == 0) {
                return;
              }
              localObject1 = SpriteUtil.i(((BaseChatPie)localObject1).d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatApolloViewListener.2
 * JD-Core Version:    0.7.0.1
 */