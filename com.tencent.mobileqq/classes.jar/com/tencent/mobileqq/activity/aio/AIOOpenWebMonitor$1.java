package com.tencent.mobileqq.activity.aio;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class AIOOpenWebMonitor$1
  implements Runnable
{
  AIOOpenWebMonitor$1(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    if (this.b == 1)
    {
      localObject1 = ((TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER)).f(this.c);
      if (localObject1 == null) {
        return;
      }
      localObject2 = new HashMap(3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TroopInfo)localObject1).wMemberNum);
      localStringBuilder.append("");
      ((HashMap)localObject2).put("m_num", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOWebTC", false, 0L, 0L, (HashMap)localObject2, "", false);
    }
    localObject1 = this.a.getMessageFacade().o(this.c, this.b);
    if (localObject1 == null) {
      return;
    }
    int j = 2;
    localObject1 = ((List)localObject1).iterator();
    do
    {
      i = j;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((ChatMessage)((Iterator)localObject1).next()).msgUid != this.d);
    int i = 1;
    localObject1 = new HashMap(3);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("m_i", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOWebmsgposition", false, 0L, 0L, (HashMap)localObject1, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor.1
 * JD-Core Version:    0.7.0.1
 */