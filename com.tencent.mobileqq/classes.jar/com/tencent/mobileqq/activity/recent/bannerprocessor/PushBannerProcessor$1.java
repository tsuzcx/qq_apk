package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class PushBannerProcessor$1
  implements View.OnClickListener
{
  PushBannerProcessor$1(PushBannerProcessor paramPushBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = PushBannerProcessor.a(this.a).getSharedPreferences("mobileQQ", 0).edit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("push_banner_display");
    ((StringBuilder)localObject2).append(PushBannerProcessor.b(this.a).getAppRuntime().getAccount());
    ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false).commit();
    localObject1 = BannerManager.a().a(PushBannerProcessor.a);
    if ((localObject1 != null) && (((Banner)localObject1).c != null))
    {
      localObject2 = (ADView)((Banner)localObject1).c.findViewById(2131427870);
      if (localObject2 != null) {
        localObject1 = ((ADView)localObject2).e(0);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        int j = ((ViewGroup)localObject1).getChildCount();
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < j)
        {
          View localView = ((ViewGroup)localObject1).getChildAt(i);
          if (localView != null) {
            localLinkedList.add((PushBanner)localView.getTag());
          }
          i += 1;
        }
        ThreadManager.getFileThreadHandler().post(new PushBannerProcessor.1.1(this, j, localLinkedList));
        if (localObject2 != null) {
          ((ADView)localObject2).i();
        }
      }
    }
    BannerManager.a().a(PushBannerProcessor.a, 0, null);
    PushBannerProcessor.a(this.a, false);
    ReportController.b(PushBannerProcessor.d(this.a).getAppRuntime(), "dc00898", "", "", "0X80087C3", "0X80087C3", 0, 0, "", "", "", "");
    ReportController.a(PushBannerProcessor.e(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 12, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */