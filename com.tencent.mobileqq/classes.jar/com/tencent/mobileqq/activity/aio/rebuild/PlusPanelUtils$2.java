package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class PlusPanelUtils$2
  implements ActionSheet.OnButtonClickListener
{
  PlusPanelUtils$2(VideoActionSheet paramVideoActionSheet, int[] paramArrayOfInt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Context paramContext, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    paramInt = this.b[paramInt];
    QQAppInterface localQQAppInterface;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5) {
          return;
        }
        paramView = ((QidianManager)this.d.getManager(QQManagerFactory.QIDIAN_MANAGER)).h(this.c.b);
        CrmUtils.b(this.d, this.f, paramView, this.c.b);
        return;
      }
      if ((this.c.a != 1001) && (this.c.a != 10002))
      {
        if ((this.c.a == 1010) && (!DatingUtil.a(this.d, this.c.b)))
        {
          paramView = this.e;
          paramView.c(paramView.aX().getString(2131892082));
          ReportController.b(this.d, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
        }
      }
      else
      {
        ReportController.b(this.d, "CliOper", "", "", "0X8005151", "0X8005151", 0, 0, "", "", "", "");
        if (!LBSHandler.a(this.d, this.c.b))
        {
          paramView = this.e;
          paramView.c(paramView.aX().getString(2131892082));
          ReportController.b(this.d, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
          localQQAppInterface = this.d;
          if (this.c.a == 1001) {
            paramView = "0";
          } else {
            paramView = "1";
          }
          ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "1", "", "");
          return;
        }
      }
      PlusPanelUtils.a(this.d, this.f, this.c, false, this.g, null);
      ReportController.b(this.d, "CliOper", "", "", "0X8004C09", "0X8004C09", 0, 0, "", "", "", "");
      return;
    }
    if ((this.c.a != 1001) && (this.c.a != 10002))
    {
      if ((this.c.a == 1010) && (!DatingUtil.a(this.d, this.c.b)))
      {
        paramView = this.e;
        paramView.c(paramView.aX().getString(2131892081));
        ReportController.b(this.d, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
      }
    }
    else
    {
      ReportController.b(this.d, "CliOper", "", "", "0X8005150", "0X8005150", 0, 0, "", "", "", "");
      if (!LBSHandler.a(this.d, this.c.b))
      {
        paramView = this.e;
        paramView.c(paramView.aX().getString(2131892081));
        ReportController.b(this.d, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
        localQQAppInterface = this.d;
        if (this.c.a == 1001) {
          paramView = "0";
        } else {
          paramView = "1";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "0", "", "");
        return;
      }
    }
    PlusPanelUtils.a(this.d, this.f, this.c, true, this.g, null);
    ReportController.b(this.d, "CliOper", "", "", "0X8004861", "0X8004861", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.2
 * JD-Core Version:    0.7.0.1
 */