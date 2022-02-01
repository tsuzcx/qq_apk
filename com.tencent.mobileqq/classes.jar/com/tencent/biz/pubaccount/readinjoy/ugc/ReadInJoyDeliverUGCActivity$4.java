package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView.OnDragListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyDeliverUGCActivity$4
  implements ReadInJoyNinePicDeliverDynamicGridView.OnDragListener
{
  ReadInJoyDeliverUGCActivity$4(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startDrag!");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.a) != 0)
    {
      Integer localInteger = (Integer)ReadInJoyDeliverUGCActivity.a(this.a).remove(paramInt1);
      ReadInJoyDeliverUGCActivity.a(this.a).add(paramInt2, localInteger);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800953F", "0X800953F", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "change position old position=" + paramInt1 + " new position" + paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.4
 * JD-Core Version:    0.7.0.1
 */