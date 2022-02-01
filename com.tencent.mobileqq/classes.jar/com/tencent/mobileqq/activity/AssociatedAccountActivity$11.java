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
    if ((paramView != null) && (paramView.getId() == 2131427810))
    {
      QLog.d("AssociatedAccountActivity", 2, "addAccount onClick");
      AssociatedAccountActivity.access$1302(this.a, 1);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800BDE3", "0X800BDE3", 0, 0, "", "", "", "");
      AssociatedAccountActivity.access$1400(this.a);
    }
    else if ((paramView != null) && ((paramView.getTag() instanceof AssociatedAccountListAdapter.ViewHolder)))
    {
      Object localObject1 = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((AssociatedAccountListAdapter.ViewHolder)localObject1).m != null))
      {
        Object localObject3 = ((AssociatedAccountListAdapter.ViewHolder)localObject1).m;
        Iterator localIterator = null;
        localObject1 = null;
        SubAccountInfo localSubAccountInfo = null;
        Object localObject2 = null;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick type = ");
          localStringBuilder.append(((AssociatedAccountListItemData)localObject3).a);
          QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
        }
        int i = ((AssociatedAccountListItemData)localObject3).a;
        if ((i != 1) && (i != 2)) {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 7)
                {
                  localObject1 = localSubAccountInfo;
                  break label887;
                }
              }
              else
              {
                localObject1 = localObject2;
                if (((AssociatedAccountListItemData)localObject3).l != null)
                {
                  localObject1 = localObject2;
                  if ((((AssociatedAccountListItemData)localObject3).l instanceof SimpleAccount)) {
                    localObject1 = ((SimpleAccount)((AssociatedAccountListItemData)localObject3).l).getUin();
                  }
                }
                QLog.d("AssociatedAccountActivity", 2, "switch login user");
                ReportController.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
                ReportController.b(this.a.app, "dc00898", "", "", "0X800BDE5", "0X800BDE5", 0, 0, "", "", "", "");
                break label887;
              }
            }
            else
            {
              AssociatedAccountActivity.access$1302(this.a, 1);
              AssociatedAccountActivity.access$1400(this.a);
              QLog.d("AssociatedAccountActivity", 2, "add subaccount");
              ReportController.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
              ReportController.b(this.a.app, "dc00898", "", "", "0X800BDE3", "0X800BDE3", 0, 0, "", "", "", "");
              break label1406;
            }
          }
          else
          {
            localObject1 = localIterator;
            if (((AssociatedAccountListItemData)localObject3).l != null)
            {
              localObject1 = localIterator;
              if ((((AssociatedAccountListItemData)localObject3).l instanceof SubAccountMessage)) {
                localObject1 = ((SubAccountMessage)((AssociatedAccountListItemData)localObject3).l).subUin;
              }
            }
            QLog.d("AssociatedAccountActivity", 2, "subaccount message1");
            ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
            ReportController.b(this.a.app, "dc00898", "", "", "0X800BDE1", "0X800BDE1", 0, 0, "", "", "", "");
            ReportController.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
            break label887;
          }
        }
        localObject2 = localObject1;
        if (((AssociatedAccountListItemData)localObject3).l != null)
        {
          localObject2 = localObject1;
          if ((((AssociatedAccountListItemData)localObject3).l instanceof SubAccountInfo)) {
            localObject2 = ((SubAccountInfo)((AssociatedAccountListItemData)localObject3).l).subuin;
          }
        }
        if (((AssociatedAccountListItemData)localObject3).a == 2)
        {
          QLog.d("AssociatedAccountActivity", 2, "subaccount avatar");
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "dc00898", "", "", "0X800BDDF", "0X800BDDF", 0, 0, "", "", "", "");
          localObject1 = localObject2;
          if (((AssociatedAccountListItemData)localObject3).l != null)
          {
            localObject1 = localObject2;
            if ((((AssociatedAccountListItemData)localObject3).l instanceof SubAccountInfo))
            {
              localObject1 = (SubAccountInfo)((AssociatedAccountListItemData)localObject3).l;
              ReportController.b(this.a.app, "dc00898", "", "", "0X800BDE0", "0X800BDE0", ((SubAccountInfo)localObject1).unreadMsgNum, 0, "", "", "", "");
              localObject1 = localObject2;
            }
          }
        }
        else
        {
          QLog.d("AssociatedAccountActivity", 2, "subaccount message2");
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "dc00898", "", "", "0X800BDE1", "0X800BDE1", 0, 0, "", "", "", "");
          localObject1 = localObject2;
        }
        label887:
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((IPwdSetUtilApi)QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(this.a)) && (this.a.isNetConnToast())) {
          if (!((AssociatedAccountListItemData)localObject3).i)
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
          else if ((((AssociatedAccountListItemData)localObject3).i) && (((AssociatedAccountListItemData)localObject3).a == 2))
          {
            if ((((AssociatedAccountListItemData)localObject3).l != null) && ((((AssociatedAccountListItemData)localObject3).l instanceof SubAccountInfo)) && (this.a.curSubAccountInfo != null))
            {
              localObject1 = (SubAccountInfo)((AssociatedAccountListItemData)localObject3).l;
              if ((!TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)) && (!((SubAccountInfo)localObject1).subuin.equals(this.a.curSubAccountInfo.subuin)))
              {
                localObject2 = this.a;
                ((AssociatedAccountActivity)localObject2).curSubAccountInfo = ((SubAccountInfo)localObject1);
                AssociatedAccountActivity.access$1700((AssociatedAccountActivity)localObject2, true);
              }
            }
          }
          else
          {
            this.a.showJuhua(2131892342);
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
              AssociatedAccountActivity.access$1800(this.a, false, (String)localObject1);
            }
          }
        }
      }
    }
    label1406:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.11
 * JD-Core Version:    0.7.0.1
 */