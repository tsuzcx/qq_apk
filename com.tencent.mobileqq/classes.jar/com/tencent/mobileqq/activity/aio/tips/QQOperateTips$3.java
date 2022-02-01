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
    if ((QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips) != null) && (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get() != null))
    {
      FriendHotTipsBar.c(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips), QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_JavaLangString);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("mqqapi");
      int j = 2;
      if (bool)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("c2c")) && (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int == 0)) {
          ChatActivityUtils.a(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips), (Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get(), QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).d, null, true, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).b, true, true, null, "from_internal");
        } else if ((this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.contains("discussion")) && (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int == 3000)) {
          ChatActivityUtils.a(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips), (Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get(), QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int, QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_JavaLangString, true, true, null, null);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url.startsWith("http"))
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.url;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          StringBuilder localStringBuilder;
          if (((String)localObject2).contains("?"))
          {
            localObject1 = (TicketManager)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getManager(2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("&sid=");
            localStringBuilder.append(((TicketManager)localObject1).getSkey(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getCurrentAccountUin()));
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localObject1 = (TicketManager)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getManager(2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("?sid=");
            localStringBuilder.append(((TicketManager)localObject1).getSkey(QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).getCurrentAccountUin()));
            localObject1 = localStringBuilder.toString();
          }
        }
        localObject2 = new Intent((Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_left_button", true);
        ((Intent)localObject2).putExtra("show_right_close_button", true);
        ((Intent)localObject2).putExtra("finish_animation_up_down", true);
        ((Context)QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).get()).startActivity((Intent)localObject2);
        i = 2;
        break label528;
      }
      int i = 1;
      label528:
      Object localObject1 = QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
      if (QQOperateTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips).jdField_a_of_type_Int == 0) {
        j = 1;
      }
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperationViopTipTask.taskid));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.3
 * JD-Core Version:    0.7.0.1
 */