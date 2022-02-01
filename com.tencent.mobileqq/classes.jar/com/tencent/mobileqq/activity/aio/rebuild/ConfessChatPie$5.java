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
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      try
      {
        localObject1 = NewReportPlugin.b(paramView, NewReportPlugin.b(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.b, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = ConfessChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie);
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = NewReportPlugin.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.b, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.b, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject1 = (ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER);
    Object localObject2 = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((ConfessConfig)localObject2).j)
    {
      ((ConfessHandler)localObject1).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.a(0, ConfessConfig.h, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.5
 * JD-Core Version:    0.7.0.1
 */