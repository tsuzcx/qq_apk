package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class RecentOptPopBar$1
  implements PopupMenuDialog.OnClickActionListener
{
  RecentOptPopBar$1(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    if (i != 2131698708)
    {
      if (i != 2131699241) {
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            if (!QQAudioHelper.b()) {
              break;
            }
            PstnCardTestActivity.onDebugMenuEvent(paramMenuItem, this.a.a);
            return;
          case 2131691276: 
            this.a.h();
            return;
          case 2131691275: 
            this.a.b();
            return;
          case 2131691274: 
            this.a.g();
            return;
          }
          break;
        case 2131691271: 
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).handleMiniAppMoreClick(this.a.a);
          ReportController.b(this.a.a.app, "dc00898", "", "", "0X8009CB9", "0X8009CB9", 0, 0, "", "", "", "");
          return;
        case 2131691270: 
          this.a.j();
          return;
        case 2131691269: 
          this.a.e();
          return;
        case 2131691268: 
          this.a.f();
          return;
        case 2131691267: 
          this.a.a(8);
          ReportController.b(this.a.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.fukuan.click", 0, 0, "", "", "", "");
          return;
        case 2131691266: 
          this.a.k();
          return;
        case 2131691265: 
          this.a.c();
          return;
        }
      } else {
        RecentOptPopBar.a(this.a);
      }
    }
    else {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar.1
 * JD-Core Version:    0.7.0.1
 */