package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgBackupBannerProcessor$1
  implements View.OnClickListener
{
  MsgBackupBannerProcessor$1(MsgBackupBannerProcessor paramMsgBackupBannerProcessor, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BaseActivity.sTopActivity != null) {
      MsgBackupManager.a().a(BaseActivity.sTopActivity, this.a);
    } else if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "sTopActivity is null");
    }
    MsgBackupManager.q();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */