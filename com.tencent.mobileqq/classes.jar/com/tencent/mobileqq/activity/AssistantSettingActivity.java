package com.tencent.mobileqq.activity;

import Override;
import adus;
import adut;
import aduu;
import aduv;
import aduw;
import adux;
import aduy;
import aduz;
import adva;
import advb;
import advc;
import advd;
import adve;
import advf;
import advg;
import advh;
import advi;
import advj;
import advk;
import advl;
import advm;
import advn;
import advo;
import advp;
import advq;
import advr;
import advs;
import ahod;
import aiti;
import ajwh;
import ajwl;
import ajwm;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anum;
import anuw;
import anyw;
import anzj;
import aold;
import apvy;
import aqpd;
import aqpe;
import aran;
import args;
import armr;
import arms;
import ascj;
import auvv;
import axkr;
import axlc;
import bdgb;
import bdll;
import bduy;
import bhlq;
import bhpc;
import biik;
import bjbs;
import bnrf;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nql;
import win;
import wjb;
import yup;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public advs a;
  private ajwl jdField_a_of_type_Ajwl = new advj(this);
  public ajwm a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new advh(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new adus(this);
  private aold jdField_a_of_type_Aold;
  aqpd jdField_a_of_type_Aqpd = new advf(this);
  protected bhpc a;
  public bjbs a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new advb(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected bhpc b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new advi(this);
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public FormMultiLineSwitchItem e;
  FormSwitchItem e;
  public FormMultiLineSwitchItem f;
  public FormSwitchItem f;
  private FormMultiLineSwitchItem g;
  public FormSwitchItem g;
  private FormMultiLineSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem i;
  private FormMultiLineSwitchItem j;
  private FormMultiLineSwitchItem k;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new adve(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new advg(this));
  }
  
  private void a(List<ajwh> paramList)
  {
    boolean bool2 = true;
    if (bduy.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajwh localajwh = (ajwh)((Iterator)localObject).next();
        if (localajwh.a == 3)
        {
          if (!localajwh.e) {
            break label102;
          }
          this.k.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Advs;
    if (this.k.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((advs)localObject).a(bool1);
      this.jdField_a_of_type_Advs.a(paramList);
      return;
      label102:
      this.k.setVisibility(0);
      if (!this.jdField_a_of_type_Ajwm.c()) {}
      for (bool1 = true;; bool1 = false)
      {
        a(bool1);
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k != null)
    {
      this.k.setOnCheckedChangeListener(null);
      this.k.setChecked(paramBoolean);
      this.k.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.i != null)
    {
      this.i.setOnCheckedChangeListener(null);
      this.i.setChecked(paramBoolean);
      this.i.setOnCheckedChangeListener(paramOnCheckedChangeListener);
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
    long l = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      localEditor.putLong(str2, l);
      localSharedPreferences.edit().putBoolean(str3, true);
      ahod.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      ahod.d = paramBoolean;
      ahod.a = l;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void c()
  {
    boolean bool1 = bdgb.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371979));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372931);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373100));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373101));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380272));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362920));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374446));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131374445));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366788));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362921);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131378021));
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131365690));
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365988));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131381592));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369506));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371537));
    Object localObject1 = (args)aran.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((args)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373106));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373107));
    Object localObject2 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int m;
    if (((localObject1 != null) && (((args)localObject1).a())) || (ahod.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (arms.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130847441));
      }
      bool2 = ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        m = 1;
        bdll.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", m, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new advn(this));
        localObject1 = "normal";
        if (!VipUtils.c(this.app)) {
          break label1658;
        }
        localObject1 = "vip";
        label556:
        localObject2 = this.app;
        if (!bool2) {
          break label1676;
        }
        m = 1;
        label568:
        bdll.b((QQAppInterface)localObject2, "dc00898", "", "", "", "0X800A414", m, 0, "", "", "", (String)localObject1);
        label595:
        if (!EmojiStickerManager.a()) {
          break label1717;
        }
        localObject1 = this.app.c();
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(localSharedPreferences.getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new advo(this, localSharedPreferences, (String)localObject1));
        label665:
        d();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362714));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361990));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Aold.a(true));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new advp(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.a().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694065));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131699691) + win.jdField_a_of_type_JavaLangString + anzj.a(2131699695));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new advq(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839440);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((wjb.i()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
          break label1729;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label886:
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131377086));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131694432), "qqsetting_screenshot_key", false);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new advr(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (anyw)this.app.getManager(51);
        bool2 = ((anyw)localObject1).f();
        if (!bool1) {
          break label1747;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label982:
        localObject1 = (TroopManager)this.app.getManager(52);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label1775;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1015:
        bool2 = bnrf.h();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aduv(this));
        if (((axlc)this.app.getManager(325)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = axkr.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aduw(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new adux(this));
        localObject1 = apvy.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aduy(this, (ArrayList)localObject1));
        }
        bool2 = aiti.a(this.app).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(getResources().getString(2131691767));
        this.i.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (ascj)this.app.getManager(214);
        if ((!((ascj)localObject1).a()) || (!((ascj)localObject1).d())) {
          break label1803;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
        bool2 = ((ascj)localObject1).b();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(anzj.a(2131699686));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aduz(this, (ascj)localObject1));
        label1307:
        if ((!auvv.a(this.app).a(this.app)) || (bool1)) {
          break label1815;
        }
        this.j.setVisibility(0);
        bool1 = auvv.a(this.app).a();
        this.j.setChecked(bool1);
        this.j.setContentDescription(anzj.a(2131699690));
        this.j.setChecked(bool1);
        this.j.setOnCheckedChangeListener(new adva(this));
        label1391:
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364984));
        this.k = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131364972));
        if (this.jdField_a_of_type_Ajwm.c()) {
          break label1827;
        }
      }
    }
    label1676:
    label1815:
    label1827:
    for (bool1 = true;; bool1 = false)
    {
      a(bool1);
      this.k.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131364991));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_Advs = new advs(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_Ajwm != null) {
        a(this.jdField_a_of_type_Ajwm.c());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Advs);
      e();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364719));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new advc(this));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(anzj.a(2131699688));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131699698));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anzj.a(2131690774));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690093));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131376929));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.27(this));
      return;
      m = 0;
      break;
      label1658:
      if (!VipUtils.b(this.app)) {
        break label556;
      }
      localObject1 = "svip";
      break label556;
      m = 2;
      break label568;
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "disable the ptt check box");
      b(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label595;
      label1717:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label665;
      label1729:
      yup.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label886;
      label1747:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new adut(this, (anyw)localObject1));
      break label982;
      label1775:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aduu(this, (TroopManager)localObject1));
      break label1015;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label1307;
      this.j.setVisibility(8);
      break label1391;
    }
  }
  
  private void d()
  {
    int n = 8;
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371514));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379717));
    boolean bool = aqpe.b();
    Object localObject = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (bool) {}
    for (int m = 0;; m = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(m);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      m = n;
      if (bool) {
        m = 0;
      }
      ((TextView)localObject).setVisibility(m);
      if (bool)
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(aqpe.a(this.app));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new advd(this));
        bdll.b(this.app, "dc00898", "", "", "0X800B332", "0X800B332", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void e()
  {
    if (bduy.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.k.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Ajwm != null)
      {
        List localList = this.jdField_a_of_type_Ajwm.c();
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
  
  private void f()
  {
    if (this.jdField_a_of_type_Bhpc == null) {
      this.jdField_a_of_type_Bhpc = bhlq.a(this, 0, anzj.a(2131699692), anzj.a(2131699696), 2131694524, 2131694525, new advk(this), new advl(this));
    }
    this.jdField_a_of_type_Bhpc.show();
  }
  
  private void g()
  {
    biik.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_Bhpc == null) {
      this.jdField_b_of_type_Bhpc = bhlq.a(this, 0, null, anzj.a(2131699697), 0, 2131718195, new advm(this), null);
    }
    this.jdField_b_of_type_Bhpc.show();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Bhpc != null) {
      this.jdField_b_of_type_Bhpc.dismiss();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558701);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131694406);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Aold = ((aold)this.app.getManager(85));
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Aqpd);
    this.jdField_a_of_type_Ajwm = ((ajwm)this.app.getManager(295));
    if (this.jdField_a_of_type_Ajwm != null)
    {
      this.jdField_a_of_type_Ajwm.a(this.jdField_a_of_type_Ajwl);
      this.jdField_a_of_type_Ajwm.d(false);
      this.jdField_a_of_type_Ajwm.a();
    }
    c();
    paramBundle = (anum)this.app.a(2);
    if (paramBundle != null) {
      paramBundle.z();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Anuw != null) {
      removeObserver(this.jdField_a_of_type_Anuw);
    }
    if (this.jdField_a_of_type_Aqpd != null) {
      removeObserver(this.jdField_a_of_type_Aqpd);
    }
    if (this.jdField_a_of_type_Ajwm != null) {
      this.jdField_a_of_type_Ajwm.b(this.jdField_a_of_type_Ajwl);
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
    this.jdField_a_of_type_Bjbs = null;
    this.jdField_a_of_type_Bjbs = new bjbs(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.a(getString(2131690711));
    this.jdField_a_of_type_Bjbs.c(true);
    this.jdField_a_of_type_Bjbs.a(false);
    this.jdField_a_of_type_Bjbs.b(true);
    return this.jdField_a_of_type_Bjbs;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131694406);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */