package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentDataConvertDispatcher
  extends RecentListDispatchImpl<IRecentDataConvertProcessor>
{
  public RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    Object localObject3 = a;
    Object localObject1 = null;
    try
    {
      Iterator localIterator = this.b.iterator();
      Object localObject2;
      do
      {
        do
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (IRecentDataConvertProcessor)localIterator.next();
        } while (localObject2 == null);
        localObject2 = ((IRecentDataConvertProcessor)localObject2).a(paramBaseQQAppInterface, paramRecentUser);
        localObject1 = localObject2;
      } while (localObject2 == null);
      return localObject2;
    }
    finally {}
    for (;;)
    {
      throw paramBaseQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentDataConvertDispatcher
 * JD-Core Version:    0.7.0.1
 */