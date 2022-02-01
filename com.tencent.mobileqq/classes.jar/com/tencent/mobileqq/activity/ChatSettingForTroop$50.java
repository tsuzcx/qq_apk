package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studyroom.utils.StudyRoomReporter;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;

class ChatSettingForTroop$50
  implements View.OnClickListener
{
  ChatSettingForTroop$50(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject3;
    String str;
    long l2;
    long l1;
    if ((localObject1 instanceof oidb_0xe83.AppInfo))
    {
      localObject3 = (oidb_0xe83.AppInfo)localObject1;
      str = ((oidb_0xe83.AppInfo)localObject3).url.get();
      l2 = ((oidb_0xe83.AppInfo)localObject3).appid.get();
      localObject1 = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label1392;
      }
      localObject1 = ((TroopManager)localObject1).c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (localObject1 == null) {
        break label1387;
      }
      l1 = ((TroopInfo)localObject1).dwGroupClassExt;
    }
    for (;;)
    {
      Object localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      long l3 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      Object localObject2;
      if (paramView.getTag(-1) == null)
      {
        localObject2 = String.valueOf(l2) + "-0";
        ReportController.b(null, "dc00898", "", (String)localObject4, "0X800AFC4", "0X800AFC4", 0, 0, String.valueOf(l3), String.valueOf(l2), (String)localObject2, "");
        if (l2 == 0L)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          new SessionInfo();
          localObject4 = new SessionInfo();
          ((SessionInfo)localObject4).jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          ((SessionInfo)localObject4).jdField_a_of_type_Int = 1;
          ((SessionInfo)localObject4).b = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          ((Intent)localObject2).putExtra("session_info", (Parcelable)localObject4);
          ((Intent)localObject2).putExtra("fling_action_key", 2);
          ((Intent)localObject2).putExtra("fling_code_key", hashCode());
          ((Intent)localObject2).putExtra("reportfrom", 2);
          PublicFragmentActivity.Launcher.a(this.a.getActivity(), (Intent)localObject2, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
          ReportController.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
          localObject2 = (TroopAppMgr)this.a.app.getManager(QQManagerFactory.TROOP_APP_MGR);
          if (localObject2 != null) {
            ((TroopAppMgr)localObject2).a(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
        }
        if (!TextUtils.isEmpty(str)) {
          break label450;
        }
      }
      label450:
      while (ChatSettingForTroop.a(this.a, l2, (TroopInfo)localObject1))
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = String.valueOf(l2) + "-" + paramView.getTag(-1).toString();
        break;
      }
      int i;
      if ((l2 == 1101236949L) && (QVipBigTroopExpiredProcessor.c().mIsEnable) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
      {
        boolean bool = TroopManager.LiangGroupHelper.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          localObject2 = this.a;
          localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          if (bool)
          {
            i = 15;
            label563:
            str = VipUtils.a(0, i).toString();
            localObject4 = HardCodeUtil.a(2131701813);
            ChatSettingForTroop.50.1 local1 = new ChatSettingForTroop.50.1(this, bool);
            if (!bool) {
              break label661;
            }
            localObject1 = "0X800A57F";
            label601:
            if (!bool) {
              break label669;
            }
            i = 1;
            label608:
            VipUtils.a((Context)localObject2, (String)localObject3, str, (String)localObject4, local1, (String)localObject1, i, bool);
          }
        }
        for (;;)
        {
          ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
          break;
          i = 8;
          break label563;
          label661:
          localObject1 = "0X8009E38";
          break label601;
          label669:
          i = 3;
          break label608;
          VipUtils.a(this.a, bool);
        }
      }
      if (l2 == 101914115L)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
          label717:
          QQGameTroopManager.a(1, (String)localObject1, false);
        }
      }
      else
      {
        i = ((oidb_0xe83.AppInfo)localObject3).push_red_point.get();
        if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
          break label1094;
        }
        localObject1 = TroopUtils.a(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, (String)localObject1, 2010, TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), null);
        TroopUtils.a((oidb_0xe83.AppInfo)localObject3, "click", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        label840:
        if (i != 0)
        {
          ((oidb_0xe83.AppInfo)localObject3).push_red_point.set(0);
          ((TextView)paramView.findViewById(2131362907)).setVisibility(8);
          TroopNotificationHelper.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (int)l2);
        }
        TroopReportor.a("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(l2) });
        localObject1 = "";
        if (l2 != 0L) {
          break label1338;
        }
        localObject1 = "app_clk";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          TroopReportor.a("Grp_app_new", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        }
        if (l2 != 101889454L) {
          break;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("action", "click");
        ((Bundle)localObject1).putString("page", "group_page");
        ((Bundle)localObject1).putString("module", "studyroom_entry");
        ((Bundle)localObject1).putString("room_id", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        StudyRoomReporter.a((Bundle)localObject1);
        break;
        localObject1 = "";
        break label717;
        label1094:
        if ((str.startsWith("http")) || (str.startsWith("https")))
        {
          localObject1 = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", TroopUtils.a(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true));
          ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.a.startActivity((Intent)localObject1);
          break label840;
        }
        if (!str.startsWith("mqqapi")) {
          break label840;
        }
        localObject2 = TroopUtils.a(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        localObject1 = localObject2;
        if (l2 == 1105981808L)
        {
          localObject1 = TroopStoryUtil.a(this.a.getIntent(), (String)localObject2, null);
          StoryReportor.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        localObject2 = new Intent(this.a, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.a.startActivity((Intent)localObject2);
        break label840;
        label1338:
        if (l2 == 1L) {
          localObject1 = "clk_file";
        } else if (l2 == 2L) {
          localObject1 = "clk_album";
        } else if (l2 == 1101236949L) {
          localObject1 = "clk_notice";
        }
      }
      label1387:
      l1 = 0L;
      continue;
      label1392:
      localObject1 = null;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.50
 * JD-Core Version:    0.7.0.1
 */