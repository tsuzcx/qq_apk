package com.tencent.biz.qqcircle.publish.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleTitlePart$2
  implements DialogInterface.OnClickListener
{
  QCircleTitlePart$2(QCircleTitlePart paramQCircleTitlePart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = QCircleTitlePart.b(this.a).g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("User cancel with video edit in progress. missionId=");
    localStringBuilder.append(paramDialogInterface);
    QLog.i("[QcirclePublish]QCircleTitlePart", 1, localStringBuilder.toString());
    QCircleHostAEHelper.cancelMission(paramDialogInterface);
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLIC_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", QCircleTitlePart.b(this.a).w), QCircleReportHelper.newEntry("ext1", "cancelexport"), QCircleReportHelper.newEntry("ret_code", "0") }));
    this.a.j().getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleTitlePart.2
 * JD-Core Version:    0.7.0.1
 */