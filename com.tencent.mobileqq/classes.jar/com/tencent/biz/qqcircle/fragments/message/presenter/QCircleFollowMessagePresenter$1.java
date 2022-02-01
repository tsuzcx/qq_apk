package com.tencent.biz.qqcircle.fragments.message.presenter;

import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowChangeListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFollowMessagePresenter$1
  implements QCircleFollowView.FollowChangeListener
{
  QCircleFollowMessagePresenter$1(QCircleFollowMessagePresenter paramQCircleFollowMessagePresenter) {}
  
  public void onFollowStateChange(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    paramStUser = new QCircleLpReportDc05504.DataBuilder().setToUin(paramStUser.id.get()).setActionType(17);
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 5;
    }
    QCircleLpReportDc05504.DataBuilder localDataBuilder = paramStUser.setSubActionType(i).setThrActionType(0);
    if (this.a.d != null) {
      paramStUser = this.a.d.busiReport.get().toByteArray();
    } else {
      paramStUser = null;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setMsgReportInfo(paramStUser).setPageId(this.a.d().getPageId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleFollowMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */