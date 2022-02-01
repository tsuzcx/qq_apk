package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent;
import java.util.Iterator;
import java.util.List;

class QCircleDraftRecyclerView$DraftAdapter$3
  implements Runnable
{
  QCircleDraftRecyclerView$DraftAdapter$3(QCircleDraftRecyclerView.DraftAdapter paramDraftAdapter, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((IDataManager)QRoute.api(IDataManager.class)).removeMissionIdAndData(HostDataTransUtils.getLongAccountUin(), str);
    }
    SimpleEventBus.getInstance().dispatchEvent(new DraftDataChangeEvent(2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.3
 * JD-Core Version:    0.7.0.1
 */