package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter.ViewHolder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$11
  implements View.OnClickListener
{
  AssociatedAccountActivity$11(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131362204)) {
      AssociatedAccountActivity.a(this.a);
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == null) || ((paramView.getTag() instanceof AssociatedAccountListAdapter.ViewHolder)))
      {
        localObject1 = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
        if ((localObject1 == null) || (((AssociatedAccountListAdapter.ViewHolder)localObject1).a != null))
        {
          localObject2 = ((AssociatedAccountListAdapter.ViewHolder)localObject1).a;
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick type = " + ((AssociatedAccountListItemData)localObject2).jdField_a_of_type_Int);
          }
          switch (((AssociatedAccountListItemData)localObject2).jdField_a_of_type_Int)
          {
          case 5: 
          default: 
            localObject1 = null;
            label163:
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!PwdSetUtil.a(this.a.app, this.a)) && (this.a.c()))
            {
              if (((AssociatedAccountListItemData)localObject2).jdField_a_of_type_Boolean) {
                break label670;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AssociatedAccountActivity", 2, "onItemClick goto SubAccountUgActivity");
              }
              this.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
              this.a.d = true;
              localObject2 = new Intent("before_account_change");
              this.a.sendBroadcast((Intent)localObject2);
              localObject2 = new Intent(this.a, SubAccountUgActivity.class);
              ((Intent)localObject2).putExtra("subAccount", (String)localObject1);
              ((Intent)localObject2).putExtra("from_associated_activity", true);
              this.a.startActivity((Intent)localObject2);
            }
            break;
          }
        }
      }
    }
    if ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject instanceof SimpleAccount))) {}
    for (Object localObject1 = ((SimpleAccount)((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject).getUin();; localObject1 = null)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
      break label163;
      AssociatedAccountActivity.a(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
      break;
      if ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountMessage))) {}
      for (localObject1 = ((SubAccountMessage)((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject).subUin;; localObject1 = null)
      {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        break label163;
        if ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo))) {}
        for (localObject1 = ((SubAccountInfo)((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject).subuin;; localObject1 = null)
        {
          if (((AssociatedAccountListItemData)localObject2).jdField_a_of_type_Int == 2)
          {
            ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
            ReportController.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
            break label163;
          }
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          break label163;
          label670:
          if ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_Boolean) && (((AssociatedAccountListItemData)localObject2).jdField_a_of_type_Int == 2))
          {
            if ((((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject == null) || (!(((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null)) {
              break;
            }
            localObject1 = (SubAccountInfo)((AssociatedAccountListItemData)localObject2).jdField_a_of_type_JavaLangObject;
            if ((TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)) || (((SubAccountInfo)localObject1).subuin.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountInfo)localObject1);
            AssociatedAccountActivity.b(this.a, true);
            break;
          }
          this.a.a(2131694686);
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick mNeed2ConfirmMsgNum = " + this.a.b + "  toUin=" + (String)localObject1);
          }
          if (this.a.b > 0)
          {
            this.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localObject2 = (MessageHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
            SubAccountManager localSubAccountManager = (SubAccountManager)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
            Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
            int i = 0;
            for (;;)
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountManager.c(localSubAccountInfo.subuin) > 0))
              {
                i += 1;
                ((MessageHandler)localObject2).a().a(localSubAccountInfo.subuin, "sub.account.switchAccount");
              }
            }
          }
          int j = 0;
          if (j > 0)
          {
            this.a.b = j;
            break;
          }
          AssociatedAccountActivity.b(this.a, false, (String)localObject1);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.11
 * JD-Core Version:    0.7.0.1
 */