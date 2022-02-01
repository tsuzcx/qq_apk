package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter.ViewHolder;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
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
    if ((paramView != null) && (paramView.getId() == 2131362229))
    {
      AssociatedAccountActivity.access$1300(this.a);
    }
    else if ((paramView != null) && ((paramView.getTag() instanceof AssociatedAccountListAdapter.ViewHolder)))
    {
      Object localObject1 = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((AssociatedAccountListAdapter.ViewHolder)localObject1).a != null))
      {
        Object localObject3 = ((AssociatedAccountListAdapter.ViewHolder)localObject1).a;
        Iterator localIterator = null;
        SubAccountInfo localSubAccountInfo = null;
        localObject1 = null;
        Object localObject2 = null;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick type = ");
          localStringBuilder.append(((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Int);
          QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
        }
        int i = ((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Int;
        if ((i != 1) && (i != 2)) {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 7) {
                  break label558;
                }
              }
              else
              {
                localObject1 = localObject2;
                if (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject != null)
                {
                  localObject1 = localObject2;
                  if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject instanceof SimpleAccount)) {
                    localObject1 = ((SimpleAccount)((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject).getUin();
                  }
                }
                ReportController.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
                break label558;
              }
            }
            else
            {
              AssociatedAccountActivity.access$1300(this.a);
              ReportController.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
              break label1075;
            }
          }
          else
          {
            localObject1 = localIterator;
            if (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject != null)
            {
              localObject1 = localIterator;
              if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
                localObject1 = ((SubAccountMessage)((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject).subUin;
              }
            }
            ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
            ReportController.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
            break label558;
          }
        }
        localObject1 = localSubAccountInfo;
        if (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject != null)
        {
          localObject1 = localSubAccountInfo;
          if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
            localObject1 = ((SubAccountInfo)((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject).subuin;
          }
        }
        if (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Int == 2)
        {
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
        }
        else
        {
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        }
        label558:
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((IPwdSetUtilApi)QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(this.a)) && (this.a.isNetConnToast())) {
          if (!((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountActivity", 2, "onItemClick goto SubAccountUgActivity");
            }
            localObject2 = this.a;
            ((AssociatedAccountActivity)localObject2).mCurrentSwitchUin = ((String)localObject1);
            ((AssociatedAccountActivity)localObject2).mClick2Switch = true;
            localObject2 = new Intent("before_account_change");
            this.a.sendBroadcast((Intent)localObject2);
            localObject2 = new Intent(this.a, SubAccountUgActivity.class);
            ((Intent)localObject2).putExtra("subAccount", (String)localObject1);
            ((Intent)localObject2).putExtra("from_associated_activity", true);
            this.a.startActivity((Intent)localObject2);
          }
          else if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Boolean) && (((AssociatedAccountListItemData)localObject3).jdField_a_of_type_Int == 2))
          {
            if ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) && (this.a.curSubAccountInfo != null))
            {
              localObject1 = (SubAccountInfo)((AssociatedAccountListItemData)localObject3).jdField_a_of_type_JavaLangObject;
              if ((!TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)) && (!((SubAccountInfo)localObject1).subuin.equals(this.a.curSubAccountInfo.subuin)))
              {
                localObject2 = this.a;
                ((AssociatedAccountActivity)localObject2).curSubAccountInfo = ((SubAccountInfo)localObject1);
                AssociatedAccountActivity.access$1600((AssociatedAccountActivity)localObject2, true);
              }
            }
          }
          else
          {
            this.a.showJuhua(2131694655);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onItemClick mNeed2ConfirmMsgNum = ");
              ((StringBuilder)localObject2).append(this.a.mNeed2ConfirmMsgNum);
              ((StringBuilder)localObject2).append("  toUin=");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject2).toString());
            }
            if (this.a.mNeed2ConfirmMsgNum > 0)
            {
              localObject2 = this.a;
              ((AssociatedAccountActivity)localObject2).mCurrentSwitchUin = ((String)localObject1);
              localObject2 = (SubAccountServiceImpl)((AssociatedAccountActivity)localObject2).app.getRuntimeService(ISubAccountService.class, "");
              localIterator = this.a.mSubAccountList.iterator();
              i = 0;
              for (;;)
              {
                j = i;
                if (!localIterator.hasNext()) {
                  break;
                }
                localSubAccountInfo = (SubAccountInfo)localIterator.next();
                if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (((SubAccountServiceImpl)localObject2).getUnreadAllMsgNum(localSubAccountInfo.subuin) > 0))
                {
                  j = i + 1;
                  localObject3 = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(this.a.app);
                  i = j;
                  if (localObject3 != null)
                  {
                    ((AbsSubAccountMessageProcessor)localObject3).a(localSubAccountInfo.subuin, "sub.account.switchAccount");
                    i = j;
                  }
                }
              }
            }
            int j = 0;
            if (j > 0) {
              this.a.mNeed2ConfirmMsgNum = j;
            } else {
              AssociatedAccountActivity.access$1700(this.a, false, (String)localObject1);
            }
          }
        }
      }
    }
    label1075:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.11
 * JD-Core Version:    0.7.0.1
 */