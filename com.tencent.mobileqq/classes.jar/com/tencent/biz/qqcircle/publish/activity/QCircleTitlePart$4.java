package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleTitlePart$4
  implements ActionSheet.OnButtonClickListener
{
  QCircleTitlePart$4(QCircleTitlePart paramQCircleTitlePart) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.j().getActivity();
    if (paramView != null)
    {
      if (this.a.a == null) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          if (QCircleTitlePart.b(this.a).e())
          {
            QCircleTitlePart.b(this.a).a(this.a.j(), 1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(QCircleTitlePart.b(this.a).l);
            localStringBuilder.append("");
            QCirclePublishReport.a(15, 30, 2, localStringBuilder.toString(), "");
            QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLIC_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", QCircleTitlePart.b(this.a).w), QCircleReportHelper.newEntry("ext1", "save"), QCircleReportHelper.newEntry("ret_code", "0") }));
            paramView.finish();
          }
          else
          {
            QCircleToast.a(2131916939, 1);
          }
        }
      }
      else
      {
        QCircleTitlePart.b(this.a).n = true;
        QCircleTitlePart.b(this.a).B = true;
        QCircleTitlePart.b(this.a).a(this.a.c());
        QCircleTitlePart.b(this.a).h();
        if (this.a.E().a(QCircleLabelPart.class.getName()) != null) {
          ((QCircleLabelPart)this.a.E().a(QCircleLabelPart.class.getName())).i();
        }
        paramView = new StringBuilder();
        paramView.append(QCircleTitlePart.b(this.a).l);
        paramView.append("");
        QCirclePublishReport.a(15, 30, 1, paramView.toString(), "");
      }
      this.a.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleTitlePart.4
 * JD-Core Version:    0.7.0.1
 */