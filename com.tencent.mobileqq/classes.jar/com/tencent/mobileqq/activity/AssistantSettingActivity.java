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
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.IVipStatusManager;
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
    if (StudyModeManager.a()) {
      return;
    }
    boolean bool = true;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CTEntry localCTEntry = (CTEntry)((Iterator)localObject).next();
        if (localCTEntry.a == 3) {
          if (localCTEntry.e)
          {
            this.m.setVisibility(8);
          }
          else
          {
            this.m.setVisibility(0);
            a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c() ^ true);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter;
    if (this.m.getVisibility() != 0) {
      bool = false;
    }
    ((AssistantSettingActivity.EntryListAdapter)localObject).a(bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter.a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem = this.m;
    if (localFormMultiLineSwitchItem != null)
    {
      localFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.m.setChecked(paramBoolean);
      this.m.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem = this.j;
    if (localFormMultiLineSwitchItem != null)
    {
      localFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.j.setChecked(paramBoolean);
      this.j.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_text_");
    ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("businessinfo_ptt_auto_change_time_");
    ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("businessinfo_ptt_auto_change_guide_has_show_");
    ((StringBuilder)localObject3).append(this.app.getCurrentAccountUin());
    localObject3 = ((StringBuilder)localObject3).toString();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putBoolean((String)localObject1, paramBoolean);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      localEditor.putLong((String)localObject2, l1);
      localSharedPreferences.edit().putBoolean((String)localObject3, true);
      PttConstants.d = true;
    }
    else
    {
      localEditor.putLong((String)localObject2, 9223372036854775807L);
    }
    localEditor.commit();
    PttConstants.c = paramBoolean;
    PttConstants.a = l1;
  }
  
  private void b(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem = this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
    if (localFormMultiLineSwitchItem != null)
    {
      localFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      h();
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void c()
  {
    boolean bool1 = SimpleUIUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372020));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131373014);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373178));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373179));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380044));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362939));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374350));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131374349));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366957));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362940);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131377905));
    Object localObject2 = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365818));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131366179));
    this.k = ((FormMultiLineSwitchItem)super.findViewById(2131381341));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369616));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371610));
    this.l = ((FormMultiLineSwitchItem)findViewById(2131376986));
    f();
    Object localObject1 = (PttAutoChangeBean)QConfigManager.a().a(442);
    if (localObject1 != null)
    {
      bool2 = ((PttAutoChangeBean)localObject1).a();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("is Open:");
        ((StringBuilder)localObject3).append(bool2);
        QLog.i("PttAutoChangeProcessor", 2, ((StringBuilder)localObject3).toString());
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373184));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373186));
    Object localObject3 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_ptt_auto_change_text_");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    ((SharedPreferences)localObject3).getBoolean(localStringBuilder.toString(), false);
    if (((localObject1 != null) && (((PttAutoChangeBean)localObject1).a())) || (PttConstants.c))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QVipAutoPttProcessor.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130847662));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_text_");
      ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
      bool2 = ((SharedPreferences)localObject3).getBoolean(((StringBuilder)localObject1).toString(), false);
      int n;
      if (bool2 == true) {
        n = 1;
      } else {
        n = 0;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", n, 0, "", "", "", "");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.8(this));
      if (VasUtil.a(this.app).getVipStatus().isVip()) {
        localObject1 = "vip";
      } else if (VasUtil.a(this.app).getVipStatus().isSVip()) {
        localObject1 = "svip";
      } else {
        localObject1 = "normal";
      }
      localObject3 = this.app;
      if (bool2) {
        n = 1;
      } else {
        n = 2;
      }
      ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "", "0X800A414", n, 0, "", "", "", (String)localObject1);
    }
    else
    {
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "disable the ptt check box");
      b(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373311));
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerEnable())
    {
      if (getIntent().getBooleanExtra("need_open_tips", false)) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setBackgroundColor(getResources().getColor(2131167385));
      }
      b(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp(), this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
    else
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    }
    if (EmojiStickerManager.a())
    {
      localObject1 = this.app.getCurrentUin();
      localObject3 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sticker_switch_");
      localStringBuilder.append((String)localObject1);
      ((FormMultiLineSwitchItem)localObject3).setChecked(((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), true));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.9(this, (SharedPreferences)localObject2, (String)localObject1));
    }
    else
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362719));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362009));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.11(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getNowLiveManager().jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694549));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700998));
    ((StringBuilder)localObject2).append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701002));
    ((FormSwitchItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.12(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839433);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    if ((QQStoryManager.i()) && (this.app.getNowLiveManager().jdField_a_of_type_Char != '0') && (this.app.getNowLiveManager().jdField_a_of_type_Char != '1')) {
      StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131376966));
    boolean bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131694975), "qqsetting_screenshot_key", false);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.13(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    bool2 = ((FriendsManager)localObject1).f();
    if (bool1)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.14(this, (FriendsManager)localObject1));
    }
    localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    bool2 = ((TroopManager)localObject1).e();
    if (bool1)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.15(this, (TroopManager)localObject1));
    }
    bool2 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab();
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
    localObject1 = ((IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class)).getArkAuthorityAppList(this.app.getCurrentAccountUin());
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AssistantSettingActivity.19(this, (ArrayList)localObject1));
    }
    bool2 = ((IStickerRecManager)this.app.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen();
    this.j.setChecked(bool2);
    this.j.setContentDescription(getResources().getString(2131691946));
    this.j.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject1 = (IDoutuService)this.app.getRuntimeService(IDoutuService.class, "");
    ((IDoutuService)localObject1).setApp(this.app);
    if ((((IDoutuService)localObject1).isDoutuConfigOpen()) && (((IDoutuService)localObject1).checkLocalResFiles()))
    {
      this.i.setVisibility(0);
      bool2 = ((IDoutuService)localObject1).isDoutuSettingOpen();
      this.i.setChecked(bool2);
      this.i.setContentDescription(HardCodeUtil.a(2131700993));
      this.i.setOnCheckedChangeListener(new AssistantSettingActivity.20(this, (IDoutuService)localObject1));
    }
    else
    {
      this.i.setVisibility(8);
    }
    if ((RichTextChatManager.a(this.app).a(this.app)) && (!bool1))
    {
      this.k.setVisibility(0);
      bool1 = RichTextChatManager.a(this.app).a();
      this.k.setChecked(bool1);
      this.k.setContentDescription(HardCodeUtil.a(2131700997));
      this.k.setChecked(bool1);
      this.k.setOnCheckedChangeListener(new AssistantSettingActivity.21(this));
    }
    else
    {
      this.k.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365108));
    this.m = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131365097));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c() ^ true);
    this.m.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365115));
    this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter = new AssistantSettingActivity.EntryListAdapter(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localObject1 != null) {
      a(((CTEntryMng)localObject1).c());
    }
    this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter);
    i();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364845));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingActivity.30(this));
    try
    {
      localObject1 = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131377800);
      localObject2 = (TextView)this.mContentView.findViewById(2131379838);
      localObject3 = (SpringFestivalEntryManager)this.app.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (((SpringFestivalEntryManager)localObject3).a())
      {
        ((TextView)localObject2).setVisibility(0);
        ((FormMultiLineSwitchItem)localObject1).setVisibility(0);
        ((FormMultiLineSwitchItem)localObject1).setOnCheckedChangeListener(new AssistantSettingActivity.31(this, (SpringFestivalEntryManager)localObject3));
        ((FormMultiLineSwitchItem)localObject1).setChecked(((SpringFestivalEntryManager)localObject3).b());
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
        ((FormMultiLineSwitchItem)localObject1).setVisibility(8);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AssistantSettingActivity", 1, localThrowable, new Object[0]);
    }
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(HardCodeUtil.a(2131700995));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131701005));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131690920));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690123));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131376812));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.32(this));
  }
  
  private void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363769));
    boolean bool = QzoneConfig.isShowBottomTabSwitch();
    int n = 0;
    Object localObject;
    if (bool)
    {
      localObject = this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      if (localObject != null) {
        ((FormMultiLineSwitchItem)localObject).setVisibility(8);
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (localObject != null)
      {
        ((FormSimpleItem)localObject).setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingActivity.33(this));
      }
    }
    else
    {
      localObject = this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      if (localObject != null)
      {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).hideKandianTab()) {
          n = 8;
        }
        ((FormMultiLineSwitchItem)localObject).setVisibility(n);
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (localObject != null) {
        ((FormSimpleItem)localObject).setVisibility(8);
      }
    }
  }
  
  private void e()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (localFormSimpleItem != null) {
      localFormSimpleItem.setRightText(BottomTabSettingFragment.a(getResources()));
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
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371587));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379556));
    boolean bool = C2CShortcutBarSwitcher.b();
    Object localObject = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    int i1 = 0;
    int n;
    if (bool) {
      n = 0;
    } else {
      n = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(n);
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (bool) {
      n = i1;
    } else {
      n = 8;
    }
    ((TextView)localObject).setVisibility(n);
    if (bool)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(C2CShortcutBarSwitcher.a(this.app));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingActivity.35(this));
      ReportController.b(this.app, "dc00898", "", "", "0X800B332", "0X800B332", 0, 0, "", "", "", "");
    }
  }
  
  private void h()
  {
    int n;
    if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      n = 0;
    } else {
      n = 1;
    }
    boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(this);
    if ((n == 0) || (!bool)) {}
    try
    {
      if (!((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp())
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695311)));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        if (n != 0) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695316)));
        } else if (bool) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695314)));
        } else {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695312)));
        }
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label193:
      break label193;
    }
    if (((n != 0) && (bool)) || (!((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp()))
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695318));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      if (n != 0) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695317));
      } else if (bool) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695315));
      } else {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(getResources().getString(2131695313));
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    e();
  }
  
  private void i()
  {
    if (StudyModeManager.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.m.setVisibility(8);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localObject != null)
    {
      localObject = ((CTEntryMng)localObject).c();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCTEntrySetting visible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
      QLog.i("AssistantSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, HardCodeUtil.a(2131700999), HardCodeUtil.a(2131701003), 2131695068, 2131695069, new AssistantSettingActivity.41(this), new AssistantSettingActivity.42(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void k()
  {
    QVipConfigManager.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, null, HardCodeUtil.a(2131701004), 0, 2131719065, new AssistantSettingActivity.43(this), null);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  protected void b()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558646);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(this, paramBundle, "/base/login");
      super.finish();
      return false;
    }
    super.setTitle(2131694949);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = ((CTEntryMng)this.app.getManager(QQManagerFactory.CTENTRY_MNG));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (paramBundle != null)
    {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.d(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
    }
    c();
    paramBundle = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (paramBundle != null) {
      paramBundle.getEmotionRecSwitch();
    }
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getAssistantImplSwitch(this.app);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      super.dismissDialog(1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppCardObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localObject != null) {
      ((CTEntryMng)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
    }
    b();
    a();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
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
    if (paramInt != 1) {
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131690861));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131694949);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */