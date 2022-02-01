package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ConfessChatPie$5
  implements ActionSheet.OnButtonClickListener
{
  ConfessChatPie$5(ConfessChatPie paramConfessChatPie, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.cancel();
    Object localObject1;
    Object localObject2;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramView = this.b.ah.b;
      if ((this.b.aX() != null) && (this.b.ah != null) && (!TextUtils.isEmpty(paramView)))
      {
        if (this.b.d == null) {
          return;
        }
        try
        {
          localObject1 = NewReportPlugin.b(paramView, NewReportPlugin.c(2));
          if (QLog.isColorLevel())
          {
            localObject2 = this.b.c;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("openMoreOptions uin:");
            ((StringBuilder)localObject3).append(paramView);
            ((StringBuilder)localObject3).append(" uinCode:");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          localObject2 = ConfessChatPie.f(this.b);
          Object localObject3 = new ArrayList();
          if (localObject2 != null) {
            ((List)localObject3).addAll((Collection)localObject2);
          }
          localObject2 = NewReportPlugin.a(paramView, this.b.d.getCurrentAccountUin(), 21002, 10, (List)localObject3);
          localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
          Bundle localBundle = NewReportPlugin.a(this.b.ah);
          if (QLog.isColorLevel())
          {
            String str = this.b.c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openMoreOptions safetyReport reportMsgOrg: ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("  reportMsg: ");
            localStringBuilder.append((String)localObject3);
            QLog.i(str, 2, localStringBuilder.toString());
          }
          NewReportPlugin.a(this.b.aX(), paramView, (String)localObject1, null, null, this.b.d.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
        }
        catch (Throwable paramView)
        {
          localObject1 = this.b.c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("openMoreOptions safetyReport error");
          ((StringBuilder)localObject2).append(paramView.getMessage());
          QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        ReportController.b(this.b.d, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
        return;
      }
      return;
    }
    paramView = this.b.ah.b;
    if ((this.b.aX() != null) && (this.b.ah != null) && (!TextUtils.isEmpty(paramView)))
    {
      if (this.b.d == null) {
        return;
      }
      localObject1 = (ConfessHandler)this.b.d.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER);
      localObject2 = ((ConfessManager)this.b.d.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
      if (localObject2 == null) {
        paramInt = 24;
      } else {
        paramInt = ((ConfessConfig)localObject2).C;
      }
      ((ConfessHandler)localObject1).a(paramView, this.b.ah.a, this.b.ah.v, this.b.bj, paramInt);
      this.b.a(0, ConfessConfig.h, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.5
 * JD-Core Version:    0.7.0.1
 */