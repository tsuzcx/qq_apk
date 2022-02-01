package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentSortValueDispatcher
  extends RecentListDispatchImpl<IRecentSortValueProcessor>
{
  public int a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData, int paramInt)
  {
    Object localObject = a;
    int i = 0;
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        IRecentSortValueProcessor localIRecentSortValueProcessor = (IRecentSortValueProcessor)localIterator.next();
        if (localIRecentSortValueProcessor != null) {
          i = localIRecentSortValueProcessor.a(paramBaseQQAppInterface, paramRecentUserBaseData, paramInt);
        }
      }
      return i;
    }
    finally {}
    for (;;)
    {
      throw paramBaseQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortValueDispatcher
 * JD-Core Version:    0.7.0.1
 */