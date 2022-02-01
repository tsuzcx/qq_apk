package com.tencent.mobileqq.apollo.view;

import amos;
import anbt;
import anck;
import annn;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatApolloViewListener$2
  implements Runnable
{
  public ChatApolloViewListener$2(annn paramannn, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.a == null) {
        return;
      }
      Object localObject2 = (BaseChatPie)this.this$0.a.get();
      if ((localObject2 != null) && (((BaseChatPie)localObject2).sessionInfo != null) && (((BaseChatPie)localObject2).app != null) && (((BaseChatPie)localObject2).mApolloViewController != null) && (((BaseChatPie)localObject2).mApolloViewController.a()) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null))
      {
        Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          localObject2 = anck.a(((BaseChatPie)localObject2).app);
          if (localObject2 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((anbt)localObject2).a((String)((Iterator)localObject1).next(), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2
 * JD-Core Version:    0.7.0.1
 */