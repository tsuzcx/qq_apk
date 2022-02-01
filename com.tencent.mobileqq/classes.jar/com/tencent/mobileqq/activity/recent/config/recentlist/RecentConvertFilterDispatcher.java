package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListDispatchImpl;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentConvertFilterDispatcher
  extends RecentListDispatchImpl<IRecentConvertFilterProcessor>
{
  public boolean a(RecentUser paramRecentUser, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        IRecentConvertFilterProcessor localIRecentConvertFilterProcessor = (IRecentConvertFilterProcessor)localIterator.next();
        if ((localIRecentConvertFilterProcessor != null) && (localIRecentConvertFilterProcessor.a(paramRecentUser, paramInt1, paramInt2))) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.RecentConvertFilterDispatcher
 * JD-Core Version:    0.7.0.1
 */