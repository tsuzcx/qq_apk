package com.tencent.mobileqq.activity;

import abzs;
import abzt;
import abzu;
import abzv;
import abzw;
import abzx;
import abzy;
import abzz;
import acaa;
import acab;
import acac;
import acad;
import acae;
import acaf;
import acag;
import acah;
import acai;
import acaj;
import acak;
import acal;
import acam;
import acan;
import acao;
import acap;
import acaq;
import acar;
import afbu;
import aftg;
import agug;
import ahpl;
import ahpp;
import ahpq;
import alkv;
import allb;
import aloz;
import alpo;
import ambl;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anfv;
import aogj;
import aoli;
import aoqi;
import aoqj;
import apfp;
import arsh;
import augl;
import augw;
import azib;
import azmj;
import azwu;
import bdcd;
import bdfq;
import bdwk;
import bepp;
import bjxj;
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
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nga;
import ugx;
import uhl;
import wta;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public acar a;
  private ahpp jdField_a_of_type_Ahpp = new acai(this);
  public ahpq a;
  private allb jdField_a_of_type_Allb = new abzs(this);
  private ambl jdField_a_of_type_Ambl;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acag(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdfq a;
  public bepp a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acab(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected bdfq b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acah(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormMultiLineSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public FormMultiLineSwitchItem e;
  FormSwitchItem e;
  public FormMultiLineSwitchItem f;
  public FormSwitchItem f;
  private FormMultiLineSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem i;
  private FormMultiLineSwitchItem j;
  private FormMultiLineSwitchItem k;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new acad(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new acae(this));
  }
  
  private void a(List<ahpl> paramList)
  {
    boolean bool2 = true;
    if (azwu.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ahpl localahpl = (ahpl)((Iterator)localObject).next();
        if (localahpl.a == 3)
        {
          if (!localahpl.e) {
            break label102;
          }
          this.k.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Acar;
    if (this.k.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((acar)localObject).a(bool1);
      this.jdField_a_of_type_Acar.a(paramList);
      return;
      label102:
      this.k.setVisibility(0);
      if (!this.jdField_a_of_type_Ahpq.c()) {}
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
      aftg.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      aftg.d = paramBoolean;
      aftg.a = l;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void c()
  {
    boolean bool1 = azib.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371279));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372208);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372374));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372375));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379107));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362790));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131373552));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373551));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366466));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362791);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131377010));
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131365410));
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365704));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131380338));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369011));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370850));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378378));
    Object localObject1 = (aoli)aogj.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((aoli)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131372382));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372383));
    Object localObject2 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int m;
    if (((localObject1 != null) && (((aoli)localObject1).a())) || (aftg.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (aoqj.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130846894));
      }
      bool2 = ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        m = 1;
        azmj.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", m, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acaf(this));
        localObject1 = "normal";
        if (!VipUtils.c(this.app)) {
          break label1720;
        }
        localObject1 = "vip";
        label570:
        localObject2 = this.app;
        if (!bool2) {
          break label1738;
        }
        m = 1;
        label582:
        azmj.b((QQAppInterface)localObject2, "dc00898", "", "", "", "0X800A414", m, 0, "", "", "", (String)localObject1);
        label609:
        if (!EmojiStickerManager.a()) {
          break label1779;
        }
        localObject1 = this.app.c();
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(localSharedPreferences.getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acam(this, localSharedPreferences, (String)localObject1));
        label679:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362590));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361933));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Ambl.a(true));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acan(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.a().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694901));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131701147) + ugx.jdField_a_of_type_JavaLangString + alpo.a(2131701151));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acao(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839253);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((uhl.i()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
          break label1791;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label896:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131376122));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131695442), "qqsetting_screenshot_key", false);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acap(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (aloz)this.app.getManager(51);
        bool2 = ((aloz)localObject1).f();
        if (!bool1) {
          break label1809;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label992:
        localObject1 = (TroopManager)this.app.getManager(52);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label1837;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1025:
        bool2 = bjxj.i();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new abzu(this));
        if (((augw)this.app.getManager(325)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = augl.a();
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abzv(this));
        }
        if (afbu.a(this.app))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "TroopLeftSilde switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = afbu.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abzw(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new abzx(this));
        localObject1 = anfv.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new abzy(this, (ArrayList)localObject1));
        }
        bool2 = agug.a(this.app).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(getResources().getString(2131692125));
        this.i.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (apfp)this.app.getManager(214);
        if ((!((apfp)localObject1).a()) || (!((apfp)localObject1).d())) {
          break label1865;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
        bool2 = ((apfp)localObject1).b();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(alpo.a(2131701142));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new abzz(this, (apfp)localObject1));
        label1378:
        if ((!arsh.a(this.app).a(this.app)) || (bool1)) {
          break label1877;
        }
        this.j.setVisibility(0);
        bool1 = arsh.a(this.app).a();
        this.j.setChecked(bool1);
        this.j.setContentDescription(alpo.a(2131701146));
        this.j.setChecked(bool1);
        this.j.setOnCheckedChangeListener(new acaa(this));
        label1462:
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364710));
        this.k = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131364703));
        if (this.jdField_a_of_type_Ahpq.c()) {
          break label1889;
        }
      }
    }
    label1720:
    label1738:
    label1877:
    label1889:
    for (bool1 = true;; bool1 = false)
    {
      a(bool1);
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131364717));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_Acar = new acar(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_Ahpq != null) {
        a(this.jdField_a_of_type_Ahpq.c());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Acar);
      d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364465));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new acac(this));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(alpo.a(2131701144));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131701154));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alpo.a(2131690931));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690237));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131375985));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.27(this));
      return;
      m = 0;
      break;
      if (!VipUtils.b(this.app)) {
        break label570;
      }
      localObject1 = "svip";
      break label570;
      m = 2;
      break label582;
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "disable the ptt check box");
      b(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label609;
      label1779:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label679;
      label1791:
      wta.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label896;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acaq(this, (aloz)localObject1));
      break label992;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new abzt(this, (TroopManager)localObject1));
      break label1025;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label1378;
      this.j.setVisibility(8);
      break label1462;
    }
  }
  
  private void d()
  {
    if (azwu.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.k.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Ahpq != null)
      {
        List localList = this.jdField_a_of_type_Ahpq.c();
        if ((localList != null) && (localList.size() > 0))
        {
          this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.i("AssistantSettingActivity", 2, "updateCTEntrySetting visible: " + this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
        return;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bdfq == null) {
      this.jdField_a_of_type_Bdfq = bdcd.a(this, 0, alpo.a(2131701148), alpo.a(2131701152), 2131695579, 2131695580, new acaj(this), new acak(this));
    }
    this.jdField_a_of_type_Bdfq.show();
  }
  
  private void f()
  {
    bdwk.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_Bdfq == null) {
      this.jdField_b_of_type_Bdfq = bdcd.a(this, 0, null, alpo.a(2131701153), 0, 2131720083, new acal(this), null);
    }
    this.jdField_b_of_type_Bdfq.show();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Bdfq != null) {
      this.jdField_b_of_type_Bdfq.dismiss();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558670);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131695398);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Ambl = ((ambl)this.app.getManager(85));
    addObserver(this.jdField_a_of_type_Allb);
    this.jdField_a_of_type_Ahpq = ((ahpq)this.app.getManager(295));
    if (this.jdField_a_of_type_Ahpq != null)
    {
      this.jdField_a_of_type_Ahpq.a(this.jdField_a_of_type_Ahpp);
      this.jdField_a_of_type_Ahpq.d(false);
      this.jdField_a_of_type_Ahpq.a();
    }
    c();
    paramBundle = (alkv)this.app.a(2);
    if (paramBundle != null) {
      paramBundle.B();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Allb != null) {
      removeObserver(this.jdField_a_of_type_Allb);
    }
    if (this.jdField_a_of_type_Ahpq != null) {
      this.jdField_a_of_type_Ahpq.b(this.jdField_a_of_type_Ahpp);
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
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bepp = null;
    this.jdField_a_of_type_Bepp = new bepp(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bepp.a(getString(2131690863));
    this.jdField_a_of_type_Bepp.c(true);
    this.jdField_a_of_type_Bepp.a(false);
    this.jdField_a_of_type_Bepp.b(true);
    return this.jdField_a_of_type_Bepp;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131695398);
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