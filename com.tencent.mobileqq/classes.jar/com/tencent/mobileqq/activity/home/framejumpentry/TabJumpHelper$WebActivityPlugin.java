package com.tencent.mobileqq.activity.home.framejumpentry;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TabJumpHelper$WebActivityPlugin
  extends TabJumpHelper.BaseJumpActivityPlugin
{
  public TabJumpHelper$WebActivityPlugin(TabJumpHelper paramTabJumpHelper)
  {
    super(paramTabJumpHelper);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uintype", -1);
    paramIntent = paramIntent.getStringExtra("url");
    Intent localIntent = new Intent(paramFrameFragment.C(), QQBrowserActivity.class);
    Object localObject;
    if (i != -1)
    {
      localIntent.putExtra("uintype", i);
      if ((i == 1030) && (((QQAppInterface)paramFrameFragment.A).isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)))
      {
        localObject = new PushReportController.PushReportItem();
        ((PushReportController.PushReportItem)localObject).e = "0X8009241";
        ((PushReportController.PushReportItem)localObject).d = "点击业务Push";
        PushReportController.a(paramIntent, (PushReportController.PushReportItem)localObject);
        PushReportController.a((QQAppInterface)paramFrameFragment.A, (PushReportController.PushReportItem)localObject);
        ((CampusNoticeManager)paramFrameFragment.A.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
        if (QLog.isColorLevel()) {
          QLog.d("CampusNoticeManager", 2, "remove campus notice");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnNewIntent : url");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("CampusNoticeManager", 1, ((StringBuilder)localObject).toString());
    }
    localIntent.putExtra("url", paramIntent);
    paramFrameFragment.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper.WebActivityPlugin
 * JD-Core Version:    0.7.0.1
 */