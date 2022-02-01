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
    Object localObject = jdField_a_of_type_JavaLangObject;
    RecentBaseData localRecentBaseData = null;
    label74:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          IRecentDataConvertProcessor localIRecentDataConvertProcessor = (IRecentDataConvertProcessor)localIterator.next();
          if (localIRecentDataConvertProcessor == null) {
            continue;
          }
          localRecentBaseData = localIRecentDataConvertProcessor.a(paramBaseQQAppInterface, paramRecentUser);
          if (localRecentBaseData == null) {
            break label74;
          }
          return localRecentBaseData;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentDataConvertDispatcher
 * JD-Core Version:    0.7.0.1
 */