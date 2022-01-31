package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.config.AppSetting;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import rpr;
import rps;
import rpt;
import rpu;
import rpv;
import rpw;
import rpx;
import rpy;
import rpz;
import rqa;
import rqb;
import rqc;
import rqd;
import rqe;
import rqf;
import rqg;
import rqh;
import rqi;
import rqj;
import rqk;
import rql;
import rqm;
import rqn;
import rqo;
import rqp;
import rqq;
import rqr;
import rqs;
import rqt;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new rql(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new rqk(this);
  public FormSwitchItem a;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSwitchItem b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem h;
  FormSwitchItem i;
  FormSwitchItem j;
  FormSwitchItem k;
  FormSwitchItem l;
  FormSwitchItem m;
  FormSwitchItem n;
  FormSwitchItem o;
  FormSwitchItem p;
  FormSwitchItem q;
  private FormSwitchItem r;
  private FormSwitchItem s;
  private FormSwitchItem t;
  private FormSwitchItem u;
  private FormSwitchItem v;
  private FormSwitchItem w;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new rqj(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363356));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131363349);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363350);
    if (!QQStoryManager.j())
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      ((FormSimpleItem)this.jdField_c_of_type_AndroidViewView).setBgType(0);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363346));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363347));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363360));
    this.h = ((FormSwitchItem)super.findViewById(2131363361));
    this.i = ((FormSwitchItem)super.findViewById(2131363362));
    this.j = ((FormSwitchItem)super.findViewById(2131363363));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363348));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363359));
    this.k = ((FormSwitchItem)super.findViewById(2131363365));
    this.l = ((FormSwitchItem)super.findViewById(2131363364));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131363344);
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131363345);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363343);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.m = ((FormSwitchItem)super.findViewById(2131363351));
    this.n = ((FormSwitchItem)super.findViewById(2131363352));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363353));
    this.o = ((FormSwitchItem)super.findViewById(2131363366));
    this.p = ((FormSwitchItem)super.findViewById(2131363369));
    this.r = ((FormSwitchItem)super.findViewById(2131363354));
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131363370);
    this.u = ((FormSwitchItem)super.findViewById(2131363367));
    Object localObject = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.v = ((FormSwitchItem)super.findViewById(2131363371));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363372));
    this.w = ((FormSwitchItem)super.findViewById(2131363375));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363376));
    this.q = ((FormSwitchItem)findViewById(2131363373));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363374));
    this.q.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.s = ((FormSwitchItem)findViewById(2131363377));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363378));
    this.t = ((FormSwitchItem)findViewById(2131363379));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363380));
    String str;
    label626:
    boolean bool;
    if (EmojiStickerManager.a())
    {
      str = this.app.c();
      this.u.setChecked(((SharedPreferences)localObject).getBoolean("sticker_switch_" + str, true));
      this.u.setOnCheckedChangeListener(new rpr(this, (SharedPreferences)localObject, str));
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
      }
      if ((!"1".equals(localObject)) || (!FontSettingManager.b())) {
        break label2110;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (PreDownloadStrategyBeta.c != 0L) {
        break label2169;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label642:
      if (!MagicfaceViewController.a()) {
        break label2181;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      label656:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363357));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363358));
      if (QFindBLEScanMgr.a()) {
        break label2193;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      bool = SettingCloneUtil.readValue(this, null, super.getString(2131433595), "qqsetting_screenshot_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rqn(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(new rqo(this));
      }
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(new rqp(this));
      }
      bool = SettingCloneUtil.readValue(this, null, getString(2131433586), "qqsetting_auto_receive_pic_key", true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rqq(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131433586), "qqsetting_auto_receive_magic_face_key", true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rqr(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131433640), "qqsetting_enter_sendmsg_key", false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rqs(this));
      bool = SettingCloneUtil.readValue(this, null, null, "qqsetting_clear_memory_key", true);
      this.j.setChecked(bool);
      this.j.setOnCheckedChangeListener(new rqt(this));
      bool = ConfigHandler.a(this.app, false);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rps(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131436038), "qqsetting_notify_icon_key", false);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rpt(this));
      b();
      this.k.setChecked(this.app.a().jdField_a_of_type_Boolean);
      this.k.setText(getText(2131434117));
      this.k.setContentDescription("在底部栏展示小视频功能");
      this.k.setOnCheckedChangeListener(new rpu(this));
      this.k.setBackgroundResource(2130838629);
      this.k.setVisibility(0);
      if ((QQStoryManager.j()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
        break label2264;
      }
      this.k.setVisibility(8);
      label1141:
      PstnManager localPstnManager = (PstnManager)this.app.getManager(142);
      if (localPstnManager.a() == 1)
      {
        this.m.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = this.app.getApplication().getResources().getString(2131438430);
        str = localPstnManager.a("pstn_c2c_trans_setting_wording");
        FormSwitchItem localFormSwitchItem = this.m;
        if (!TextUtils.isEmpty(str)) {
          break label2282;
        }
        label1220:
        localFormSwitchItem.setText((CharSequence)localObject);
        this.m.setChecked(localPstnManager.a());
        this.m.setOnCheckedChangeListener(new rpv(this, localPstnManager));
        if (localPstnManager.d() == 1)
        {
          this.n.setVisibility(0);
          localObject = this.app.getApplication().getResources().getString(2131438433);
          str = localPstnManager.a("pstn_multi_trans_setting_wording");
          localFormSwitchItem = this.n;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label2287;
          }
          label1311:
          localFormSwitchItem.setText((CharSequence)localObject);
          this.n.setChecked(localPstnManager.b());
          this.n.setOnCheckedChangeListener(new rpw(this, localPstnManager));
        }
      }
      if (!SharedPreUtils.c(getApplicationContext(), this.app.getCurrentAccountUin())) {
        break label2292;
      }
      this.o.setVisibility(8);
      label1372:
      localObject = (FlashChatManager)this.app.getManager(216);
      if ((localObject != null) && (((FlashChatManager)localObject).c()))
      {
        bool = ((FlashChatManager)localObject).b();
        this.p.setVisibility(0);
        this.p.setChecked(bool);
        this.p.setOnCheckedChangeListener(new rpy(this));
      }
      bool = ReadInJoyHelper.f();
      if (!bool) {
        break label2334;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433568);
      label1451:
      this.q.setChecked(bool);
      this.q.setOnCheckedChangeListener(new rpz(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new rqa(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new rqb(this));
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new rqd(this));
      if (SharedPreUtils.aj(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.r.setVisibility(0);
        findViewById(2131363355).setVisibility(0);
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams()).setMargins(0, 0, 0, 0);
        ThreadManager.post(new rqe(this), 5, null, true);
        this.r.setOnCheckedChangeListener(this);
      }
      localObject = ArkAppModuleReg.ModuleQQ.a(this.app.getCurrentAccountUin());
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(new rqf(this, (ArrayList)localObject));
      }
      localObject = (DoutuManager)this.app.getManager(213);
      if ((!((DoutuManager)localObject).a()) || (!((DoutuManager)localObject).d())) {
        break label2347;
      }
      this.v.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      bool = ((DoutuManager)localObject).b();
      this.v.setChecked(bool);
      this.v.setContentDescription("斗图功能");
      this.v.setOnCheckedChangeListener(new rqg(this, (DoutuManager)localObject));
      label1724:
      if (!ZhituManager.a(this.app).a()) {
        break label2368;
      }
      this.w.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      bool = ZhituManager.a(this.app).b();
      this.w.setChecked(bool);
      this.w.setContentDescription("智图功能");
      this.w.setChecked(bool);
      this.w.setOnCheckedChangeListener(new rqh(this));
      label1805:
      localObject = (NowEnterManager)this.app.getManager(264);
      if (!((NowEnterManager)localObject).d()) {
        break label2389;
      }
      this.t.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      bool = ((NowEnterManager)localObject).c();
      this.t.setChecked(bool);
      this.t.setOnCheckedChangeListener(new rqi(this, (NowEnterManager)localObject));
      this.s.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.b)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription("流量统计");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("摇动手机截屏");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("加入寻找丢失儿童项目");
        this.jdField_c_of_type_AndroidViewView.setContentDescription("空间图片浏览模式");
        this.jdField_d_of_type_AndroidViewView.setContentDescription("小视频浏览设置");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("非Wi-Fi环境下自动接收图片");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("回车键发送消息");
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("WiFi下自动在后台下载新版本");
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
        this.i.setContentDescription("有可用QQ WiFi时通知我");
        this.j.setContentDescription("内存低时自动清理内存");
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131434076));
        this.r.setContentDescription(getString(2131434084));
        this.jdField_f_of_type_AndroidViewView.setContentDescription(getString(2131438842));
        this.q.setContentDescription(getString(2131439122));
        this.w.setContentDescription("智能匹配图片");
        this.s.setContentDescription(getString(2131439220));
      }
      return;
      this.u.setVisibility(8);
      super.findViewById(2131363368).setVisibility(8);
      break;
      label2110:
      if ("0".equals(localObject))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        FontSettingManager.b(this);
        break label626;
      }
      if (FontSettingManager.a())
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break label626;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      FontSettingManager.b(this);
      break label626;
      label2169:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label642;
      label2181:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label656;
      label2193:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (SettingCloneUtil.readValueForInt(BaseApplication.getContext(), this.app.getCurrentAccountUin(), null, "qqsetting_antilost_key", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rqc(this));
        break;
      }
      label2264:
      StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label1141;
      label2282:
      localObject = str;
      break label1220;
      label2287:
      localObject = str;
      break label1311;
      label2292:
      bool = ArkAiAppCenter.a(this.app);
      this.o.setVisibility(0);
      this.o.setChecked(bool);
      this.o.setOnCheckedChangeListener(new rpx(this));
      break label1372;
      label2334:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433567);
      break label1451;
      label2347:
      this.v.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1724;
      label2368:
      this.w.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1805;
      label2389:
      this.t.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter == null)
      {
        QQToast.a(this, 2131438197, 100).a();
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      CardHandler localCardHandler = (CardHandler)this.app.a(2);
      if (paramBoolean) {}
      for (short s1 = 1;; s1 = 0)
      {
        localCardHandler.a(s1);
        if (!paramBoolean) {
          break;
        }
        if (!localObject.isEnabled()) {
          localObject.enable();
        }
        SmartDeviceReport.a(this.app, 0L, "QFIND_BluetoothBtnClick", 1, 0, 0);
        return;
      }
      SmartDeviceReport.a(this.app, 0L, "QFIND_BluetoothBtnClick", 0, 0, 0);
    }
  }
  
  private void b()
  {
    Object localObject = (MsgTabStoryNodeConfigManager)this.app.getManager(251);
    if ((((MsgTabStoryNodeConfigManager)localObject).b) && (((MsgTabStoryNodeConfigManager)localObject).c))
    {
      this.l.setVisibility(0);
      this.l.setChecked(((MsgTabStoryNodeConfigManager)localObject).d);
      this.l.setText("在消息顶部展示好友小视频");
      this.l.setOnCheckedChangeListener(new rqm(this, (MsgTabStoryNodeConfigManager)localObject));
      if (((MsgTabStoryNodeConfigManager)localObject).d) {}
      for (localObject = "1";; localObject = "2")
      {
        StoryReportor.a("msg_tab", "exp_set", 0, 0, new String[] { "2", localObject });
        return;
      }
    }
    this.l.setVisibility(8);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968712);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131433593);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      super.dismissDialog(1);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramCompoundButton == this.r.a())
    {
      if (!NetworkUtil.d(this))
      {
        QQToast.a(getApplicationContext(), 2131436084, 1).a();
        if (paramBoolean) {
          break label73;
        }
        bool1 = true;
        a(paramCompoundButton, bool1);
      }
      paramCompoundButton = (CardHandler)this.app.a(2);
      if (paramBoolean) {
        break label78;
      }
    }
    label73:
    label78:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramCompoundButton.h(paramBoolean);
      return;
      bool1 = false;
      break;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131434061));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131433593);
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