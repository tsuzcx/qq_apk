package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class QCircleSystemMessagePresenter$1
  implements View.OnClickListener
{
  QCircleSystemMessagePresenter$1(QCircleSystemMessagePresenter paramQCircleSystemMessagePresenter, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clickSystemMessage messageId");
    ((StringBuilder)localObject).append(this.b.d.feedId.get());
    QLog.i("QCircleSystemMessagePresenter", 1, ((StringBuilder)localObject).toString());
    if ((this.b.e != null) && (this.b.e.busiInfo.get() != null))
    {
      localObject = QCircleJsUrlConfig.a(this.b.e.busiInfo.get(), "noticeFeedJumpUrl");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickSystemMessage get jumpUrl");
      localStringBuilder.append((String)localObject);
      QLog.i("QCircleSystemMessagePresenter", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QCircleLauncher.a(this.a, (String)localObject);
      }
      this.b.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleSystemMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */