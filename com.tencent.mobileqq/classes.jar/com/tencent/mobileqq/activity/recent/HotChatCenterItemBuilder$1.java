package com.tencent.mobileqq.activity.recent;

import android.util.SparseArray;
import atmp;
import atmq;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class HotChatCenterItemBuilder$1
  implements Runnable
{
  HotChatCenterItemBuilder$1(HotChatCenterItemBuilder paramHotChatCenterItemBuilder, int paramInt) {}
  
  public void run()
  {
    ??? = ((QQAppInterface)HotChatCenterItemBuilder.a(this.this$0).get()).getEntityManagerFactory().createEntityManager();
    HotChatCenterItemBuilder.a(this.this$0, ApolloGameUtil.a((atmp)???));
    if ((HotChatCenterItemBuilder.a(this.this$0) != null) && (HotChatCenterItemBuilder.a(this.this$0).size() > 0))
    {
      SparseArray localSparseArray = (SparseArray)HotChatCenterItemBuilder.a(this.this$0).get(this.a);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        if ((HotChatCenterItemBuilder.a(this.this$0) != null) && (HotChatCenterItemBuilder.a(this.this$0).get() != null)) {
          ApolloGameUtil.a((atmp)???, ApolloUtil.a(localSparseArray));
        }
        synchronized (HotChatCenterItemBuilder.a(this.this$0))
        {
          localSparseArray.remove(1000);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */