package com.tencent.mobileqq.activity.recent.config.recentlist;

import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentCheckFilterDispatcher
  extends RecentListDispatchImpl<IRecentCheckFilterProcessor>
{
  public Pair<String, Boolean> a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    Object localObject3 = a;
    Object localObject2 = null;
    try
    {
      Iterator localIterator = this.b.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (IRecentCheckFilterProcessor)localIterator.next();
      } while ((localObject1 == null) || (!((IRecentCheckFilterProcessor)localObject1).a(paramBaseQQAppInterface, paramRecentUser)));
      Object localObject1 = new Pair(((IRecentCheckFilterProcessor)localObject1).a(paramRecentUser, paramInt), Boolean.valueOf(true));
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramBaseQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentCheckFilterDispatcher
 * JD-Core Version:    0.7.0.1
 */