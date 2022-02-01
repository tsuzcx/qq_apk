package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.RecentDispatchImpl;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentStatusIconDispatch
  extends RecentDispatchImpl<AbsRecentStatus>
{
  public void a() {}
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    b();
    paramRecentBaseData.mStatus = 0;
    Iterator localIterator = this.a.iterator();
    do
    {
      AbsRecentStatus localAbsRecentStatus;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAbsRecentStatus = (AbsRecentStatus)localIterator.next();
      } while (!localAbsRecentStatus.a(paramRecentBaseData, paramBaseQQAppInterface));
      localAbsRecentStatus.a(paramBaseQQAppInterface, paramRecentBaseData);
    } while (paramRecentBaseData.mStatus == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch
 * JD-Core Version:    0.7.0.1
 */