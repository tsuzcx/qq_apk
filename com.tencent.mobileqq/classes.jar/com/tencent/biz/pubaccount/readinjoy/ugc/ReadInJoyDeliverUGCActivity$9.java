package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyDeliverUGCActivity$9
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyDeliverUGCActivity$9(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.a)) {
      return;
    }
    ReadInJoyDeliverUGCActivity.b(this.a, true);
    ReadInJoyDeliverUGCActivity.c(this.a, ReadInJoyDeliverUGCActivity.c(this.a));
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoyDeliverUGCActivity.a(this.a).dismiss();
      return;
      ReadInJoyDeliverUGCActivity.b(this.a);
      RIJDeliverUGCReportUtil.c();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008239", "0X8008239", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
      continue;
      ReadInJoyDeliverUGCActivity.c(this.a);
      RIJDeliverUGCReportUtil.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.9
 * JD-Core Version:    0.7.0.1
 */