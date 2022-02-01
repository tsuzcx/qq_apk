package com.tencent.mobileqq.activity;

import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class PermisionPrivacyActivity$16
  implements CompoundButton.OnCheckedChangeListener
{
  PermisionPrivacyActivity$16(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.c.a()) || (paramCompoundButton == this.a.e.a())) && (!NetworkUtil.d(this.a.getActivity())))
    {
      this.a.a(2131694507, 1);
      localObject1 = this.a;
      if (!paramBoolean)
      {
        bool = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
      }
    }
    int i;
    label404:
    label453:
    label582:
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (AppSetting.d) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(this.a.getResources().getString(2131694456));
        }
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.app.setZanAllowed(true, paramBoolean);
          break;
        }
      }
      if (paramCompoundButton == this.a.e.a())
      {
        ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o(paramBoolean);
        if (paramBoolean) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8009E81", "0X8009E81", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8009E80", "0X8009E80", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (paramCompoundButton == this.a.i.a())
        {
          if (!NetworkUtil.d(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131719116, 1).a();
            localObject1 = this.a;
            if (!paramBoolean)
            {
              bool = true;
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
            }
          }
          else
          {
            localObject1 = (CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (paramBoolean) {
              break label453;
            }
          }
          for (bool = true;; bool = false)
          {
            ((CardHandler)localObject1).k(bool);
            break;
            bool = false;
            break label404;
          }
        }
        if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
        {
          if (!NetworkUtil.d(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131694459, 1).a();
            this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
            localObject1 = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
            if (this.a.app.getC2CRoamingSetting() == 1) {}
            for (bool = true;; bool = false)
            {
              ((CompoundButton)localObject1).setChecked(bool);
              this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
              break;
            }
          }
          if (paramBoolean)
          {
            i = 1;
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
            this.a.a(this.a.getApplication().getResources().getString(2131719068));
            if (!paramBoolean) {
              break label661;
            }
          }
          label661:
          for (i = 1;; i = 0)
          {
            this.a.app.setC2CRoamingSetting(i);
            break;
            i = 0;
            break label582;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
            this.a.app.setVisibilityForStatus(paramBoolean, false);
            this.a.a(paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
            this.a.app.setZanAllowed(false, paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == this.a.h.a())
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
            if ((!NetworkUtil.d(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
              break label928;
            }
            if (AppSetting.d) {
              this.a.h.setContentDescription(HardCodeUtil.a(2131707904));
            }
            PermisionPrivacyActivity.a(this.a).a(paramBoolean);
            break;
          }
          label928:
          localObject1 = this.a;
          if (PermisionPrivacyActivity.a(this.a) != null)
          {
            i = 2131694507;
            label947:
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
            localObject1 = this.a;
            localObject2 = this.a.h.a();
            if (paramBoolean) {
              break label996;
            }
          }
          label996:
          for (bool = true;; bool = false)
          {
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
            break;
            i = 2131719116;
            break label947;
          }
        }
        if (paramCompoundButton == this.a.g.a())
        {
          if (AppSetting.d) {
            this.a.g.setContentDescription("可通过系统通讯录发起QQ聊天");
          }
          localObject1 = new PermisionPrivacyActivity.16.1(this, (ContactSyncManager)this.a.app.getManager(QQManagerFactory.MGR_SYNC_CONTACT), paramBoolean);
          localObject2 = new PermisionPrivacyActivity.16.2(this);
          if (paramBoolean)
          {
            if ((PermissionChecker.a()) && (VersionUtils.k()))
            {
              PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
              PermissionParam localPermissionParam = new PermissionParam();
              localPermissionParam.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject1);
              localPermissionParam.b = ((Runnable)localObject2);
              localPermissionParam.jdField_a_of_type_Int = 7;
              localPhoneContactManagerImp.a().a(this.a, localPermissionParam, this.a, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
            }
            else
            {
              ((Runnable)localObject1).run();
            }
          }
          else {
            ((Runnable)localObject1).run();
          }
        }
        else if (paramCompoundButton == this.a.b.a())
        {
          if (AppSetting.d) {
            this.a.b.setContentDescription(HardCodeUtil.a(2131707906));
          }
          PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean);
          this.a.app.setVisibilityForNetWorkStatus(paramBoolean, true);
          if (paramBoolean) {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8009C08", "0X8009C08", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.a.app, "CliOper", "", "", "0X8009C09", "0X8009C09", 0, 0, "", "", "", "");
          }
        }
        else if (paramCompoundButton == this.a.c.a())
        {
          if (AppSetting.d) {
            this.a.c.setContentDescription(HardCodeUtil.a(2131707897));
          }
          PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean);
          this.a.app.setVisibilityForInputStatus(paramBoolean, true);
        }
        else
        {
          if (paramCompoundButton == this.a.d.a())
          {
            localObject1 = this.a.app;
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
              if (!NetworkUtil.d(this.a.getActivity())) {
                break label1528;
              }
              if (AppSetting.d) {
                this.a.d.setContentDescription(HardCodeUtil.a(2131707907));
              }
              ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).i(paramBoolean);
              break;
            }
            label1528:
            localObject1 = this.a;
            if (PermisionPrivacyActivity.a(this.a) != null)
            {
              i = 2131694507;
              label1547:
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
              localObject1 = this.a;
              localObject2 = this.a.d.a();
              if (paramBoolean) {
                break label1596;
              }
            }
            label1596:
            for (bool = true;; bool = false)
            {
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
              break;
              i = 2131719116;
              break label1547;
            }
          }
          if (paramCompoundButton == this.a.f.a())
          {
            if ((paramCompoundButton.getTag() == null) || (!((Boolean)paramCompoundButton.getTag()).booleanValue())) {
              break label1646;
            }
            paramCompoundButton.setTag(Boolean.FALSE);
          }
        }
      }
    }
    label1646:
    this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramBoolean);
    Object localObject1 = this.a.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean)
    {
      i = 2131693105;
      label1674:
      ((TextView)localObject1).setText(i);
      localObject2 = this.a.app;
      if (!paramBoolean) {
        break label1736;
      }
    }
    label1736:
    for (localObject1 = "open_autopass";; localObject1 = "close_autopass")
    {
      ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_invite_friend", "", "auto_pass", (String)localObject1, 0, 0, "", "", "", "");
      break;
      i = 2131693106;
      break label1674;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.16
 * JD-Core Version:    0.7.0.1
 */