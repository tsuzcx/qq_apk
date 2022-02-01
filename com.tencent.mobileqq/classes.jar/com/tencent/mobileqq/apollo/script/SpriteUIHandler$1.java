package com.tencent.mobileqq.apollo.script;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;

class SpriteUIHandler$1
  implements Runnable
{
  SpriteUIHandler$1(SpriteUIHandler paramSpriteUIHandler, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = SpriteUIHandler.a(this.this$0);
      if (!(localObject1 instanceof ChatAdapter1))
      {
        QLog.e("[cmshow][scripted]SpriteUIHandler", 1, "adapter is null.");
        return;
      }
      Object localObject2 = (ChatAdapter1)localObject1;
      int i = AIOUtils.a(this.a, (ListAdapter)localObject2);
      if (i < 0) {
        return;
      }
      localObject1 = SpriteUIHandler.b(this.this$0);
      Object localObject3 = (ChatMessage)((ChatAdapter1)localObject2).getItem(i);
      if (localObject1 != null)
      {
        if (!(localObject3 instanceof MessageForApollo)) {
          return;
        }
        localObject2 = ((ChatAdapter1)localObject2).c.a((ChatMessage)localObject3, (BaseAdapter)localObject2);
        if (!(localObject2 instanceof ApolloItemBuilder)) {
          return;
        }
        localObject2 = (ApolloItemBuilder)localObject2;
        localObject3 = (BaseChatItemLayout)AIOUtils.a((ListView)localObject1, AIOUtils.a(this.a, ((XListView)localObject1).getAdapter()));
        if (localObject3 != null)
        {
          ((ApolloItemBuilder)localObject2).a((View)localObject3, this.b, this.c);
          ((XListView)localObject1).getFirstVisiblePosition();
          int j = ((XListView)localObject1).getLastVisiblePosition();
          i = 0;
          while (i < j)
          {
            BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)AIOUtils.a((ListView)localObject1, i);
            if (localBaseChatItemLayout != null) {
              ((ApolloItemBuilder)localObject2).a(localBaseChatItemLayout, (BaseChatItemLayout)localObject3, this.b, this.c);
            }
            i += 1;
          }
        }
      }
      else {}
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteUIHandler", 1, "[onActionDownloadNotify], error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.1
 * JD-Core Version:    0.7.0.1
 */