package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFeedItemBuilder$1
  implements View.OnClickListener
{
  QCircleFeedItemBuilder$1(QCircleFeedItemBuilder paramQCircleFeedItemBuilder, MessageForQCircleFeed paramMessageForQCircleFeed) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", this.b.d.b, "0X800B27A", "0X800B27A", 0, 0, "", "", "", "");
    MessageForQCircleFeed localMessageForQCircleFeed = this.a;
    if ((localMessageForQCircleFeed != null) && (!TextUtils.isEmpty(localMessageForQCircleFeed.contentJumpUrl))) {
      QCircleUtils.a().enterByScheme(BaseApplication.getContext(), this.a.contentJumpUrl);
    } else {
      QLog.e("QCircleFeedItemBuilder", 1, "getItemView onClick  circleFeed || contentJumpUrl == null");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */