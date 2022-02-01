package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

class QQOperateTips$3
  implements View.OnClickListener
{
  QQOperateTips$3(QQOperateTips paramQQOperateTips, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((QQOperateTips.g(this.b) != null) && (QQOperateTips.g(this.b).get() != null))
    {
      FriendHotTipsBar.c(QQOperateTips.b(this.b), QQOperateTips.a(this.b).b);
      boolean bool = this.a.url.startsWith("mqqapi");
      int j = 2;
      if (bool)
      {
        if ((this.a.url.contains("c2c")) && (QQOperateTips.a(this.b).a == 0)) {
          ChatActivityUtils.a(QQOperateTips.b(this.b), (Context)QQOperateTips.g(this.b).get(), QQOperateTips.a(this.b).a, QQOperateTips.a(this.b).b, QQOperateTips.a(this.b).e, null, true, QQOperateTips.a(this.b).c, true, true, null, "from_internal");
        } else if ((this.a.url.contains("discussion")) && (QQOperateTips.a(this.b).a == 3000)) {
          ChatActivityUtils.a(QQOperateTips.b(this.b), (Context)QQOperateTips.g(this.b).get(), QQOperateTips.a(this.b).a, QQOperateTips.a(this.b).b, true, true, null, null);
        }
      }
      else if (this.a.url.startsWith("http"))
      {
        Object localObject2 = this.a.url;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          StringBuilder localStringBuilder;
          if (((String)localObject2).contains("?"))
          {
            localObject1 = (TicketManager)QQOperateTips.b(this.b).getManager(2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("&sid=");
            localStringBuilder.append(((TicketManager)localObject1).getSkey(QQOperateTips.b(this.b).getCurrentAccountUin()));
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localObject1 = (TicketManager)QQOperateTips.b(this.b).getManager(2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("?sid=");
            localStringBuilder.append(((TicketManager)localObject1).getSkey(QQOperateTips.b(this.b).getCurrentAccountUin()));
            localObject1 = localStringBuilder.toString();
          }
        }
        localObject2 = new Intent((Context)QQOperateTips.g(this.b).get(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_left_button", true);
        ((Intent)localObject2).putExtra("show_right_close_button", true);
        ((Intent)localObject2).putExtra("finish_animation_up_down", true);
        ((Context)QQOperateTips.g(this.b).get()).startActivity((Intent)localObject2);
        i = 2;
        break label528;
      }
      int i = 1;
      label528:
      Object localObject1 = QQOperateTips.b(this.b);
      if (QQOperateTips.a(this.b).a == 0) {
        j = 1;
      }
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.a.taskid));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.3
 * JD-Core Version:    0.7.0.1
 */