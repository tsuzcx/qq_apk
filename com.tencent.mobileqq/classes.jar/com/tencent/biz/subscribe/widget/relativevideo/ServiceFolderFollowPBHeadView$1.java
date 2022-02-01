package com.tencent.biz.subscribe.widget.relativevideo;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ServiceFolderFollowPBHeadView$1
  implements View.OnClickListener
{
  ServiceFolderFollowPBHeadView$1(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(ServiceFolderFollowPBHeadView.a(this.a))) {
      SubscribeLaucher.a(ServiceFolderFollowPBHeadView.a(this.a));
    } else {
      QLog.e(ServiceFolderFollowPBHeadView.a(), 2, "jump error mJumpWebMessageListUrl is null");
    }
    ServiceFolderFollowPBHeadView.a(this.a).setVisibility(8);
    ReportController.b(null, "dc00898", "", "", "auth_page", "msg_exp", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.1
 * JD-Core Version:    0.7.0.1
 */