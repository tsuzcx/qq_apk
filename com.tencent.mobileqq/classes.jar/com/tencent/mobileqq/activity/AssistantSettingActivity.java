package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new AssistantSettingActivity.36(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AssistantSettingActivity.5(this);
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingActivity.38(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AssistantSettingActivity.EntryListAdapter jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter;
  private CTEntryListener jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener = new AssistantSettingActivity.40(this);
  CTEntryMng jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new AssistantSettingActivity.1(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  C2CShortcutBarObserver jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver = new AssistantSettingActivity.7(this);
  private ProfileCommonObserver jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver = new AssistantSettingActivity.2(this);
  protected QQCustomDialog a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  HeightAdaptableListView jdField_a_of_type_ComTencentWidgetHeightAdaptableListView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new AssistantSettingActivity.6(this);
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingActivity.3(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected QQCustomDialog b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingActivity.4(this);
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingActivity.39(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormMultiLineSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormMultiLineSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormMultiLineSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem i;
  private FormMultiLineSwitchItem j;
  private FormMultiLineSwitchItem k;
  private FormMultiLineSwitchItem l;
  private FormMultiLineSwitchItem m;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new AssistantSettingActivity.37(this));
  }
  
  private void a(List<CTEntry> paramList)
  {
    boolean bool2 = true;
    if (StudyModeManager.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CTEntry localCTEntry = (CTEntry)((Iterator)localObject).next();
        if (localCTEntry.a == 3)
        {
          if (!localCTEntry.e) {
            break label102;
          }
          this.m.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter;
    if (this.m.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AssistantSettingActivity.EntryListAdapter)localObject).a(bool1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter.a(paramList);
      return;
      label102:
      this.m.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {}
      for (bool1 = true;; bool1 = false)
      {
        a(bool1);
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.m != null)
    {
      this.m.setOnCheckedChangeListener(null);
      this.m.setChecked(paramBoolean);
      this.m.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.j != null)
    {
      this.j.setOnCheckedChangeListener(null);
      this.j.setChecked(paramBoolean);
      this.j.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str1 = "businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin();
    String str2 = "businessinfo_ptt_auto_change_time_" + this.app.getCurrentAccountUin();
    String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + this.app.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putBoolean(str1, paramBoolean);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      localEditor.putLong(str2, l1);
      localSharedPreferences.edit().putBoolean(str3, true);
      PttSlideStateHelper.d = true;
    }
    for (;;)
    {
      localEditor.commit();
      PttSlideStateHelper.c = paramBoolean;
      PttSlideStateHelper.a = l1;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void b(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      h();
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void c()
  {
    boolean bool1 = SimpleUIUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372437));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131373434);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373603));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373604));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380781));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362990));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374805));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131374804));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131367120));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362991);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131378492));
    Object localObject2 = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365982));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131366291));
    this.k = ((FormMultiLineSwitchItem)super.findViewById(2131382137));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369931));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372004));
    this.l = ((FormMultiLineSwitchItem)findViewById(2131377544));
    f();
    Object localObject1 = (PttAutoChangeBean)QConfigManager.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((PttAutoChangeBean)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373609));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373611));
    Object localObject3 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject3).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int n;
    if (((localObject1 != null) && (((PttAutoChangeBean)localObject1).a())) || (PttSlideStateHelper.c))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QVipAutoPttProcessor.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130847795));
      }
      bool2 = ((SharedPreferences)localObject3).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true) {
        n = 1;
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", n, 0, "", "", "", "");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.8(this));
      localObject1 = "normal";
      if (VipUtils.c(this.app))
      {
        localObject1 = "vip";
        label576:
        localObject3 = this.app;
        if (!bool2) {
          break label1860;
        }
        n = 1;
        label588:
        ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "", "0X800A414", n, 0, "", "", "", (String)localObject1);
        label615:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373739));
        if (!WakeManager.a().b()) {
          break label1901;
        }
        if (getIntent().getBooleanExtra("need_open_tips", false)) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setBackgroundColor(getResources().getColor(2131167364));
        }
        b(WakeManager.a().jdField_a_of_type_Boolean, this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        label683:
        if (!EmojiStickerManager.a()) {
          break label1913;
        }
        localObject1 = this.app.getCurrentUin();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(((SharedPreferences)localObject2).getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.9(this, (SharedPreferences)localObject2, (String)localObject1));
        label753:
        g();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362764));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361994));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.11(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getNowLiveManager().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694581));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700855) + QQStoryConstant.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131700859));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.12(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839575);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((QQStoryManager.i()) && (this.app.getNowLiveManager().jdField_a_of_type_Char != '0') && (this.app.getNowLiveManager().jdField_a_of_type_Char != '1')) {
          break label1925;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label974:
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131377522));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131694985), "qqsetting_screenshot_key", false);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.13(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool2 = ((FriendsManager)localObject1).f();
        if (!bool1) {
          break label1943;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label1071:
        localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label1971;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1105:
        bool2 = ReadInJoyHelper.m();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.16(this));
        d();
        if (((MultiAIOManager)this.app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = MultiAIOHelper.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.17(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AssistantSettingActivity.18(this));
        localObject1 = ArkAppModuleBase.APIAuthority.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AssistantSettingActivity.19(this, (ArrayList)localObject1));
        }
        bool2 = StickerRecManager.a(this.app).b();
        this.j.setChecked(bool2);
        this.j.setContentDescription(getResources().getString(2131692027));
        this.j.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (DoutuManager)this.app.getManager(QQManagerFactory.DOUTU_MAGAGER);
        if ((!((DoutuManager)localObject1).a()) || (!((DoutuManager)localObject1).d())) {
          break label1999;
        }
        this.i.setVisibility(0);
        bool2 = ((DoutuManager)localObject1).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(HardCodeUtil.a(2131700850));
        this.i.setOnCheckedChangeListener(new AssistantSettingActivity.20(this, (DoutuManager)localObject1));
        label1401:
        if ((!RichTextChatManager.a(this.app).a(this.app)) || (bool1)) {
          break label2011;
        }
        this.k.setVisibility(0);
        bool1 = RichTextChatManager.a(this.app).a();
        this.k.setChecked(bool1);
        this.k.setContentDescription(HardCodeUtil.a(2131700854));
        this.k.setChecked(bool1);
        this.k.setOnCheckedChangeListener(new AssistantSettingActivity.21(this));
        label1485:
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365231));
        this.m = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131365219));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {
          break label2023;
        }
        bool1 = true;
        label1531:
        a(bool1);
        this.m.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365238));
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter = new AssistantSettingActivity.EntryListAdapter(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null) {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c());
        }
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter);
        i();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364961));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingActivity.30(this));
      }
      try
      {
        localObject1 = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131378389);
        localObject2 = (TextView)this.mContentView.findViewById(2131380547);
        localObject3 = (SpringFestivalEntryManager)this.app.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (((SpringFestivalEntryManager)localObject3).a())
        {
          ((TextView)localObject2).setVisibility(0);
          ((FormMultiLineSwitchItem)localObject1).setVisibility(0);
          ((FormMultiLineSwitchItem)localObject1).setOnCheckedChangeListener(new AssistantSettingActivity.31(this, (SpringFestivalEntryManager)localObject3));
          ((FormMultiLineSwitchItem)localObject1).setChecked(((SpringFestivalEntryManager)localObject3).b());
        }
        for (;;)
        {
          if (AppSetting.d)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(HardCodeUtil.a(2131700852));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700862));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131691000));
            this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690207));
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131377360));
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.32(this));
          return;
          n = 0;
          break;
          if (!VipUtils.b(this.app)) {
            break label576;
          }
          localObject1 = "svip";
          break label576;
          label1860:
          n = 2;
          break label588;
          QLog.e("vip_ptt.AssistantSettingActivity", 1, "disable the ptt check box");
          b(false);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label615;
          label1901:
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
          break label683;
          label1913:
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
          break label753;
          label1925:
          StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
          break label974;
          label1943:
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.14(this, (FriendsManager)localObject1));
          break label1071;
          label1971:
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.15(this, (TroopManager)localObject1));
          break label1105;
          label1999:
          this.i.setVisibility(8);
          break label1401;
          label2011:
          this.k.setVisibility(8);
          break label1485;
          label2023:
          bool1 = false;
          break label1531;
          ((TextView)localObject2).setVisibility(8);
          ((FormMultiLineSwitchItem)localObject1).setVisibility(8);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AssistantSettingActivity", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363842));
    if (QzoneConfig.isShowBottomTabSwitch())
    {
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingActivity.33(this));
      }
      return;
    }
    FormMultiLineSwitchItem localFormMultiLineSwitchItem;
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
    {
      localFormMultiLineSwitchItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      if (!ReadInJoyHelper.j()) {
        break label110;
      }
    }
    label110:
    for (int n = 8;; n = 0)
    {
      localFormMultiLineSwitchItem.setVisibility(n);
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(BottomTabSettingFragment.a(getResources()));
    }
  }
  
  private void f()
  {
    boolean bool = ScreenShotDetector.b();
    this.l.setVisibility(0);
    this.l.setChecked(bool);
    this.l.setOnCheckedChangeListener(new AssistantSettingActivity.34(this));
    ReportController.b(this.app, "dc00898", "", "", "0X800B4E5", "0X800B4E5", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    int i1 = 8;
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371980));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380239));
    boolean bool = C2CShortcutBarSwitcher.b();
    Object localObject = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (bool) {}
    for (int n = 0;; n = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(n);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      n = i1;
      if (bool) {
        n = 0;
      }
      ((TextView)localObject).setVisibility(n);
      if (bool)
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(C2CShortcutBarSwitcher.a(this.app));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.35(this));
        ReportController.b(this.app, "dc00898", "", "", "0X800B332", "0X800B332", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void h()
  {
    int n;
    boolean bool;
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0))
    {
      n = 1;
      bool = FloatingScreenPermission.checkPermission(this);
      if ((n != 0) && (bool)) {}
    }
    for (;;)
    {
      try
      {
        if (WakeManager.a().jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695302)));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        if (((n == 0) || (!bool)) && (WakeManager.a().jdField_a_of_type_Boolean)) {
          continue;
        }
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695309));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        continue;
        if (!bool) {
          continue;
        }
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695305)));
        continue;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695303)));
        continue;
        if (n == 0) {
          break label257;
        }
      }
      e();
      return;
      n = 0;
      break;
      if (n != 0)
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695307)));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695308));
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      break;
      label257:
      if (bool) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695306));
      } else {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695304));
      }
    }
  }
  
  private void i()
  {
    if (StudyModeManager.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.m.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null)
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c();
        if ((localList != null) && (localList.size() > 0))
        {
          this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.i("AssistantSettingActivity", 2, "updateCTEntrySetting visible: " + this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
        return;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, HardCodeUtil.a(2131700856), HardCodeUtil.a(2131700860), 2131695078, 2131695079, new AssistantSettingActivity.41(this), new AssistantSettingActivity.42(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void k()
  {
    QVipConfigManager.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, null, HardCodeUtil.a(2131700861), 0, 2131719347, new AssistantSettingActivity.43(this), null);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558747);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(this, paramBundle, "/base/login");
      super.finish();
      return false;
    }
    super.setTitle(2131694959);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = ((CTEntryMng)this.app.getManager(QQManagerFactory.CTENTRY_MNG));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.d(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
    }
    c();
    paramBundle = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (paramBundle != null) {
      paramBundle.getEmotionRecSwitch();
    }
    AssistantSwitchImpl.a(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
    }
    b();
    a();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    h();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131690933));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131694959);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */