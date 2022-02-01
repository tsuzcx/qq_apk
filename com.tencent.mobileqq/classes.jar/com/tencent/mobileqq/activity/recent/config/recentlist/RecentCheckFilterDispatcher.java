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
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          IRecentCheckFilterProcessor localIRecentCheckFilterProcessor = (IRecentCheckFilterProcessor)localIterator.next();
          if ((localIRecentCheckFilterProcessor == null) || (!localIRecentCheckFilterProcessor.a(paramBaseQQAppInterface, paramRecentUser))) {
            continue;
          }
          paramBaseQQAppInterface = new Pair(localIRecentCheckFilterProcessor.a(paramRecentUser, paramInt), Boolean.valueOf(true));
          return paramBaseQQAppInterface;
        }
      }
      paramBaseQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentCheckFilterDispatcher
 * JD-Core Version:    0.7.0.1
 */