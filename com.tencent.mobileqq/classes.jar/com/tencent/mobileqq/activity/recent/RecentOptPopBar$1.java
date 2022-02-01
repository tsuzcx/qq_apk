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
    if (i != 2131896666)
    {
      if (i != 2131897257) {
        switch (i)
        {
        default: 
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
            case 2131888226: 
              this.a.m();
              return;
            case 2131888225: 
              this.a.g();
              return;
            case 2131888224: 
              this.a.l();
              return;
            }
            break;
          case 2131888221: 
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).handleMiniAppMoreClick(this.a.a);
            ReportController.b(this.a.a.app, "dc00898", "", "", "0X8009CB9", "0X8009CB9", 0, 0, "", "", "", "");
            return;
          case 2131888220: 
            this.a.p();
            return;
          case 2131888219: 
            this.a.j();
            return;
          case 2131888218: 
            this.a.k();
            return;
          }
          break;
        case 2131888215: 
          this.a.a(8);
          ReportController.b(this.a.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.fukuan.click", 0, 0, "", "", "", "");
          return;
        case 2131888214: 
          this.a.q();
          return;
        case 2131888213: 
          this.a.h();
          return;
        }
      } else {
        RecentOptPopBar.a(this.a);
      }
    }
    else {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar.1
 * JD-Core Version:    0.7.0.1
 */