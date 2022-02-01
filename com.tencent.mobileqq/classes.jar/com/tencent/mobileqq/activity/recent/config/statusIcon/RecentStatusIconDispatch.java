package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.RecentDispatchImpl;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentStatusIconDispatch
  extends RecentDispatchImpl<AbsRecentStatus>
{
  public void processor(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    prepare();
    paramRecentBaseData.mStatus = 0;
    Iterator localIterator = this.iRecentProcessors.iterator();
    do
    {
      AbsRecentStatus localAbsRecentStatus;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAbsRecentStatus = (AbsRecentStatus)localIterator.next();
      } while (!localAbsRecentStatus.focusUINType(paramRecentBaseData, paramIMCoreAppRuntime));
      localAbsRecentStatus.handleBusiness(paramIMCoreAppRuntime, paramRecentBaseData);
    } while (paramRecentBaseData.mStatus == 0);
  }
  
  public void registerCoreProcessor() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch
 * JD-Core Version:    0.7.0.1
 */