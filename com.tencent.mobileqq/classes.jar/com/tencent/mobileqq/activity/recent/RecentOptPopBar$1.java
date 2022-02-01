package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class RecentOptPopBar$1
  implements PopupMenuDialog.OnClickActionListener
{
  RecentOptPopBar$1(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      if (AudioHelper.d()) {
        PstnCardTestActivity.onDebugMenuEvent(paramMenuItem, this.a.a);
      }
      return;
    case 2131698642: 
      this.a.e();
      return;
    case 2131691344: 
      this.a.d();
      return;
    case 2131691354: 
      this.a.c();
      return;
    case 2131691348: 
      this.a.f();
      return;
    case 2131691355: 
      this.a.i();
      return;
    case 2131691346: 
      this.a.a(8);
      ReportController.b(this.a.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.fukuan.click", 0, 0, "", "", "", "");
      return;
    case 2131691353: 
      this.a.h();
      return;
    case 2131691347: 
      this.a.g();
      return;
    case 2131691350: 
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).handleMiniAppMoreClick(this.a.a);
      ReportController.b(this.a.a.app, "dc00898", "", "", "0X8009CB9", "0X8009CB9", 0, 0, "", "", "", "");
      return;
    case 2131691349: 
      this.a.k();
      return;
    case 2131699137: 
      RecentOptPopBar.a(this.a);
      return;
    }
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar.1
 * JD-Core Version:    0.7.0.1
 */