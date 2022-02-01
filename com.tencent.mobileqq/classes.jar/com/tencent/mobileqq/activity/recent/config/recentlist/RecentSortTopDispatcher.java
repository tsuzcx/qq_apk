package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentSortTopDispatcher
  extends RecentListDispatchImpl<IRecentSortTopProcessor>
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData)
  {
    synchronized (a)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        IRecentSortTopProcessor localIRecentSortTopProcessor = (IRecentSortTopProcessor)localIterator.next();
        if ((localIRecentSortTopProcessor != null) && (localIRecentSortTopProcessor.a(paramBaseQQAppInterface, paramRecentUserBaseData))) {
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramBaseQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortTopDispatcher
 * JD-Core Version:    0.7.0.1
 */