package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

class ForwardRecentActivity$10
  implements View.OnClickListener
{
  ForwardRecentActivity$10(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131366333)
    {
      ForwardRecentActivity.access$1000(this.a, 10);
      ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D91", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
    }
    else if (i == 2131369233)
    {
      if (this.a.mOnlySingleSelection)
      {
        if (this.a.mForwardOption != null)
        {
          this.a.mForwardOption.a(false);
          com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
        }
        if (this.a.mNeedShareCallback) {
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
        }
        ForwardRecentActivity.access$1100(this.a);
        this.a.finish();
        ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
        if (this.a.getIntent().getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "2", "", "", "");
        }
      }
      else if (ForwardRecentActivity.access$400(this.a))
      {
        ForwardRecentActivity.access$1200(this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D98", ForwardRecentActivity.access$800(this.a), 0, "", "", "", ForwardRecentActivity.access$1300(this.a));
      }
      else
      {
        ForwardRecentActivity.access$1400(this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D93", ForwardRecentActivity.access$800(this.a), 0, "", "", "", ForwardRecentActivity.access$1300(this.a));
      }
    }
    else
    {
      if (i == 2131369204) {
        if (ForwardRecentActivity.access$400(this.a))
        {
          ForwardRecentActivity.access$1500(this.a);
          ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D94", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
        }
        else
        {
          if (this.a.mForwardOption != null)
          {
            this.a.mForwardOption.a(false);
            com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
          }
          this.a.finish();
          ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
          if ("caller_aecamera".equals(this.a.mCallActivity)) {
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_cancle_send_info", null, null);
          }
        }
      }
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("call_by_forward", true);
      if (this.a.dataUri != null) {
        ((Intent)localObject1).setData(this.a.dataUri);
      }
      Object localObject2 = this.a.mForwardOption.a();
      if (((Bundle)localObject2).getBoolean("sendMultiple", false)) {
        ((Intent)localObject1).putStringArrayListExtra("foward_key_m_p_l", ((Bundle)localObject2).getStringArrayList("foward_key_m_p_l"));
      } else {
        ((Intent)localObject1).putExtra("forward_filepath", ((Bundle)localObject2).getString("forward_filepath"));
      }
      ((Intent)localObject1).putExtras(this.a.mForwardOption.a());
      if (this.a.getIntent().getBooleanExtra("isFromShare", false))
      {
        ((Intent)localObject1).putExtras(this.a.mForwardOption.a());
        ((Intent)localObject1).setAction(this.a.getIntent().getAction());
      }
      else
      {
        ((Intent)localObject1).putExtras(this.a.getIntent().getExtras());
      }
      int j = paramView.getId();
      i = 2;
      switch (j)
      {
      default: 
        break;
      case 2131367171: 
        ForwardRecentActivity.access$1600(this.a, (Intent)localObject1);
        if (this.a.mOnlySingleSelection)
        {
          this.a.reportDataForBusiness("0X8007825");
          ((Intent)localObject1).setClass(this.a, TroopActivity.class);
          if (!this.a.mForwardOption.a(ForwardAbility.ForwardAbilityType.d))
          {
            ((Intent)localObject1).putExtra("onlyOneSegement", true);
            ((Intent)localObject1).putExtra("_key_mode", 0);
            ((Intent)localObject1).putExtra("key_tab_mode", 1);
          }
          else if (!this.a.mForwardOption.a(ForwardAbility.ForwardAbilityType.c))
          {
            ((Intent)localObject1).putExtra("onlyOneSegement", true);
            ((Intent)localObject1).putExtra("_key_mode", 1);
            ((Intent)localObject1).putExtra("key_tab_mode", 1);
          }
          ((Intent)localObject1).putExtra("only_single_selection", this.a.mOnlySingleSelection);
          this.a.startActivityForResult((Intent)localObject1, 20000);
          localObject2 = this.a.app;
          if (this.a.mIsFromShare) {
            localObject1 = "2";
          } else {
            localObject1 = "1";
          }
          ReportController.b((AppRuntime)localObject2, "dc00899", "Share", "", "select_friend", "clk_group", 0, 0, (String)localObject1, "", "", "");
          new ReportTask(this.a.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grpList").a();
        }
        else
        {
          ((Intent)localObject1).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.access$1800(this.a).values()));
          ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
          PublicFragmentActivity.Launcher.a(this.a, (Intent)localObject1, PublicTransFragmentActivity.class, ForwardTroopListFragment.class, 20000);
          ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D96", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
        }
        break;
      case 2131367167: 
        localObject1 = new ForwardRecentActivity.10.1(this, (Intent)localObject1);
        localObject2 = new DenyRunnable(this.a, 6);
        PermissionChecker.a(this.a, (Runnable)localObject1, (Runnable)localObject2);
        localObject2 = this.a.app;
        if (this.a.mIsFromShare) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportController.b((AppRuntime)localObject2, "dc00899", "Share", "", "select_friend", "clk_addressbook", 0, 0, (String)localObject1, "", "", "");
        break;
      case 2131367166: 
        this.a.reportDataForBusiness("0X8007826");
        if (this.a.mForwardOption.a(ForwardAbility.ForwardAbilityType.b)) {
          i = 1;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("param_type", 3000);
        ((Intent)localObject1).putExtra("param_subtype", 0);
        ((Intent)localObject1).putExtra("param_done_button_wording", this.a.getString(2131718709));
        ((Intent)localObject1).putExtra("param_done_button_highlight_wording", this.a.getString(2131718710));
        ((Intent)localObject1).putExtra("param_min", i);
        ((Intent)localObject1).putExtra("param_max", 99);
        ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
        ((Intent)localObject1).putExtra("param_entrance", 12);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this.a, (Intent)localObject1, 20003);
        ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D92", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
        break;
      case 2131367164: 
        this.a.reportDataForBusiness("0X8007824");
        ForwardRecentActivity.access$1600(this.a, (Intent)localObject1);
        ReportController.b(this.a.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
        ((Intent)localObject1).setClass(this.a, ForwardFriendListActivity.class);
        ((Intent)localObject1).putExtra("extra_choose_friend", 5);
        ((Intent)localObject1).putExtra("only_single_selection", this.a.mOnlySingleSelection);
        ((Intent)localObject1).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.access$1800(this.a).values()));
        this.a.startActivityForResult((Intent)localObject1, 20000);
        ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D95", ForwardRecentActivity.access$800(this.a), 0, "", "", "", "");
        if (this.a.mIsToPayList) {
          if ((this.a.mBusinessType == 1) && (this.a.mBusinessSubType == 1)) {
            ReportController.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
          } else if ((this.a.mBusinessType == 1) && (this.a.mBusinessSubType == 2)) {
            ReportController.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
          }
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.10
 * JD-Core Version:    0.7.0.1
 */