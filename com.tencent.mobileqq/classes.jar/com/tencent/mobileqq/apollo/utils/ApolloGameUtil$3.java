package com.tencent.mobileqq.apollo.utils;

import android.util.SparseArray;
import aukn;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class ApolloGameUtil$3
  implements Runnable
{
  ApolloGameUtil$3(aukn paramaukn) {}
  
  public void run()
  {
    SparseArray localSparseArray;
    for (;;)
    {
      ApolloGameRedDot localApolloGameRedDot;
      try
      {
        if (this.a == null) {
          break label212;
        }
        Object localObject1 = this.a.a(ApolloGameRedDot.class);
        localSparseArray = new SparseArray();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("apolloGameReddot getGameReddotMap, redDots.size:");
          if (localObject1 == null)
          {
            i = 0;
            QLog.d("ApolloGameUtil", 2, i);
          }
        }
        else
        {
          if (localObject1 == null) {
            break;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localApolloGameRedDot = (ApolloGameRedDot)localIterator.next();
          if (localApolloGameRedDot == null) {
            continue;
          }
          if (!localApolloGameRedDot.isTimeValid()) {
            break label193;
          }
          localObject2 = (SparseArray)localSparseArray.get(localApolloGameRedDot.mGameId);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new SparseArray();
            localSparseArray.put(localApolloGameRedDot.mGameId, localObject1);
          }
          ((SparseArray)localObject1).put(localApolloGameRedDot.mDotId, localApolloGameRedDot);
          continue;
        }
        int i = localThrowable.size();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameUtil", 1, localThrowable, new Object[] { "[loadCache] inner error" });
        return;
      }
      continue;
      label193:
      this.a.b(localApolloGameRedDot);
    }
    ApolloGameUtil.a = localSparseArray;
    return;
    label212:
    QLog.e("ApolloGameUtil", 1, "[loadCache] em is null inner");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.3
 * JD-Core Version:    0.7.0.1
 */