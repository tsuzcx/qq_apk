package com.tencent.mobileqq.activity;

import Override;
import acrl;
import acrm;
import acrn;
import acro;
import acrp;
import acrq;
import acrr;
import acrs;
import acrt;
import acru;
import acrv;
import acrw;
import acrx;
import acry;
import acrz;
import acsa;
import acsb;
import acsc;
import acsd;
import acse;
import acsf;
import acsg;
import acsh;
import acsi;
import acsl;
import acsm;
import acsn;
import acsp;
import acsq;
import acsr;
import acss;
import agkq;
import ahns;
import aire;
import airi;
import airj;
import amov;
import amsw;
import amtj;
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
import aneo;
import aopl;
import apim;
import apin;
import apub;
import aqai;
import aqgo;
import aqgp;
import aqwg;
import atid;
import avxy;
import avyj;
import ayzm;
import azge;
import azhh;
import bbyp;
import bcef;
import bcoo;
import bfur;
import bgov;
import bhht;
import bkwm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nru;
import vkm;
import vla;
import xwa;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public acss a;
  private airi jdField_a_of_type_Airi = new acsf(this);
  public airj a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acsm(this);
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acsd(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aneo jdField_a_of_type_Aneo;
  apim jdField_a_of_type_Apim = new acsp(this);
  private ayzm jdField_a_of_type_Ayzm = new acrv(this);
  public bhht a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new acrl(this);
  protected QQCustomDialog a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new acsn(this);
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acry(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected QQCustomDialog b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acsi(this);
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acse(this);
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public FormMultiLineSwitchItem e;
  FormSwitchItem e;
  FormMultiLineSwitchItem f;
  public FormSwitchItem f;
  public FormMultiLineSwitchItem g;
  public FormSwitchItem g;
  private FormMultiLineSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem i;
  private FormMultiLineSwitchItem j;
  private FormMultiLineSwitchItem k;
  private FormMultiLineSwitchItem l;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new acsb(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new acsc(this));
  }
  
  private void a(List<aire> paramList)
  {
    boolean bool2 = true;
    if (bcoo.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aire localaire = (aire)((Iterator)localObject).next();
        if (localaire.a == 3)
        {
          if (!localaire.e) {
            break label102;
          }
          this.l.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Acss;
    if (this.l.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((acss)localObject).a(bool1);
      this.jdField_a_of_type_Acss.a(paramList);
      return;
      label102:
      this.l.setVisibility(0);
      if (!this.jdField_a_of_type_Airj.c()) {}
      for (bool1 = true;; bool1 = false)
      {
        a(bool1);
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.l != null)
    {
      this.l.setOnCheckedChangeListener(null);
      this.l.setChecked(paramBoolean);
      this.l.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
      agkq.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      agkq.d = paramBoolean;
      agkq.a = l1;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void b(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      e();
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void c()
  {
    boolean bool1 = bbyp.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371944));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372898);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373070));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373071));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379999));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362932));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374214));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131374213));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366812));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362933);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131377791));
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365723));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131366018));
    this.k = ((FormMultiLineSwitchItem)super.findViewById(2131381309));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369490));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371505));
    Object localObject1 = (aqai)apub.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((aqai)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373076));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373077));
    Object localObject2 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int m;
    if (((localObject1 != null) && (((aqai)localObject1).a())) || (agkq.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (aqgp.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130847350));
      }
      bool2 = ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        m = 1;
        bcef.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", m, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acsq(this));
        localObject1 = "normal";
        if (!VipUtils.c(this.app)) {
          break label1726;
        }
        localObject1 = "vip";
        label556:
        localObject2 = this.app;
        if (!bool2) {
          break label1744;
        }
        m = 1;
        label568:
        bcef.b((QQAppInterface)localObject2, "dc00898", "", "", "", "0X800A414", m, 0, "", "", "", (String)localObject1);
        label595:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373215));
        if (!azhh.a().b()) {
          break label1785;
        }
        if (getIntent().getBooleanExtra("need_open_tips", false)) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setBackgroundColor(getResources().getColor(2131167327));
        }
        b(azhh.a().jdField_a_of_type_Boolean, this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        label663:
        if (!EmojiStickerManager.a()) {
          break label1797;
        }
        localObject1 = this.app.getCurrentUin();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(localSharedPreferences.getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acsr(this, localSharedPreferences, (String)localObject1));
        label733:
        d();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362719));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361989));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Aneo.a(true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acrm(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getNowLiveManager().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694167));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(amtj.a(2131699926) + vkm.jdField_a_of_type_JavaLangString + amtj.a(2131699930));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acrn(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839475);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((vla.i()) && (this.app.getNowLiveManager().jdField_a_of_type_Char != '0') && (this.app.getNowLiveManager().jdField_a_of_type_Char != '1')) {
          break label1809;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label954:
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131376838));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131694546), "qqsetting_screenshot_key", false);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acro(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (amsw)this.app.getManager(51);
        bool2 = ((amsw)localObject1).f();
        if (!bool1) {
          break label1827;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label1050:
        localObject1 = (TroopManager)this.app.getManager(52);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label1855;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1083:
        bool2 = bkwm.i();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acrr(this));
        if (((avyj)this.app.getManager(325)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = avxy.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acrs(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new acrt(this));
        localObject1 = aopl.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new acru(this, (ArrayList)localObject1));
        }
        bool2 = ahns.a(this.app).b();
        this.j.setChecked(bool2);
        this.j.setContentDescription(getResources().getString(2131691813));
        this.j.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (aqwg)this.app.getManager(214);
        if ((!((aqwg)localObject1).a()) || (!((aqwg)localObject1).d())) {
          break label1883;
        }
        this.i.setVisibility(0);
        bool2 = ((aqwg)localObject1).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(amtj.a(2131699921));
        this.i.setOnCheckedChangeListener(new acrw(this, (aqwg)localObject1));
        label1375:
        if ((!atid.a(this.app).a(this.app)) || (bool1)) {
          break label1895;
        }
        this.k.setVisibility(0);
        bool1 = atid.a(this.app).a();
        this.k.setChecked(bool1);
        this.k.setContentDescription(amtj.a(2131699925));
        this.k.setChecked(bool1);
        this.k.setOnCheckedChangeListener(new acrx(this));
        label1459:
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365011));
        this.l = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131364999));
        if (this.jdField_a_of_type_Airj.c()) {
          break label1907;
        }
      }
    }
    label1726:
    label1744:
    label1883:
    label1895:
    label1907:
    for (bool1 = true;; bool1 = false)
    {
      a(bool1);
      this.l.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365018));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_Acss = new acss(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_Airj != null) {
        a(this.jdField_a_of_type_Airj.c());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Acss);
      f();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364750));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new acrz(this));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(amtj.a(2131699923));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(amtj.a(2131699933));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(amtj.a(2131690814));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690112));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131376683));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.31(this));
      return;
      m = 0;
      break;
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
      label1785:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label663;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label733;
      xwa.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label954;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acrp(this, (amsw)localObject1));
      break label1050;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acrq(this, (TroopManager)localObject1));
      break label1083;
      this.i.setVisibility(8);
      break label1375;
      this.k.setVisibility(8);
      break label1459;
    }
  }
  
  private void d()
  {
    int n = 8;
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371482));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379501));
    boolean bool = apin.b();
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
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(apin.a(this.app));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acsa(this));
        bcef.b(this.app, "dc00898", "", "", "0X800B332", "0X800B332", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void e()
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    boolean bool;
    for (int m = 1;; m = 0)
    {
      bool = FloatingScreenPermission.checkPermission(this);
      if (((m == 0) || (!bool)) && (azhh.a().jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131694849)));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    if (m != 0) {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131694852)));
    }
    for (;;)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
      if (bool) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131694851)));
      } else {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131694850)));
      }
    }
  }
  
  private void f()
  {
    if (bcoo.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.l.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Airj != null)
      {
        List localList = this.jdField_a_of_type_Airj.c();
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
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 0, amtj.a(2131699927), amtj.a(2131699931), 2131694639, 2131694640, new acsg(this), new acsh(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void h()
  {
    bgov.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 0, null, amtj.a(2131699932), 0, 2131718436, new acsl(this), null);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void b()
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
    super.setContentView(2131558706);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131694520);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Aneo = ((aneo)this.app.getManager(85));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Apim);
    addObserver(this.jdField_a_of_type_Ayzm);
    this.jdField_a_of_type_Airj = ((airj)this.app.getManager(295));
    if (this.jdField_a_of_type_Airj != null)
    {
      this.jdField_a_of_type_Airj.a(this.jdField_a_of_type_Airi);
      this.jdField_a_of_type_Airj.d(false);
      this.jdField_a_of_type_Airj.a();
    }
    c();
    paramBundle = (amov)this.app.getBusinessHandler(2);
    if (paramBundle != null) {
      paramBundle.z();
    }
    azge.a(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_Apim != null) {
      removeObserver(this.jdField_a_of_type_Apim);
    }
    if (this.jdField_a_of_type_Ayzm != null) {
      removeObserver(this.jdField_a_of_type_Ayzm);
    }
    if (this.jdField_a_of_type_Airj != null) {
      this.jdField_a_of_type_Airj.b(this.jdField_a_of_type_Airi);
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
    e();
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
    this.jdField_a_of_type_Bhht = null;
    this.jdField_a_of_type_Bhht = new bhht(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bhht.a(getString(2131690751));
    this.jdField_a_of_type_Bhht.c(true);
    this.jdField_a_of_type_Bhht.a(false);
    this.jdField_a_of_type_Bhht.b(true);
    return this.jdField_a_of_type_Bhht;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131694520);
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