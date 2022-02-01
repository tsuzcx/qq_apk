package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.BaseApplication;

public class RecentDarenAssistantItem
  extends RecentMsgBoxItem
{
  private boolean mIsHasReportExp;
  
  public RecentDarenAssistantItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    this.mTitleName = BaseApplicationImpl.getContext().getString(2131694332);
    if (!this.mIsHasReportExp)
    {
      this.mIsHasReportExp = true;
      new ReportTask(null).a("dc00899").b("grp_lbs").c("vip_tips").d("exp").a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentDarenAssistantItem
 * JD-Core Version:    0.7.0.1
 */