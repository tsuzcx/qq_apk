package com.tencent.mobileqq.activity;

import aceh;
import acei;
import acej;
import acek;
import acel;
import acem;
import acen;
import aceo;
import acep;
import aceq;
import acer;
import aces;
import acet;
import aceu;
import acev;
import acew;
import acex;
import acey;
import acez;
import acfa;
import acfb;
import acfc;
import acfd;
import acfe;
import acff;
import acfg;
import afgj;
import afxv;
import agyv;
import ahua;
import ahue;
import ahuf;
import alpk;
import alpq;
import alto;
import alud;
import amga;
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
import anke;
import aoks;
import aopr;
import aour;
import aous;
import apjy;
import arwq;
import auku;
import aulf;
import azmk;
import azqs;
import babd;
import bdgm;
import bdjz;
import beat;
import bety;
import bkbq;
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
import ulg;
import ulu;
import wxj;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public acfg a;
  private ahue jdField_a_of_type_Ahue = new acex(this);
  public ahuf a;
  private alpq jdField_a_of_type_Alpq = new aceh(this);
  private amga jdField_a_of_type_Amga;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acev(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdjz a;
  public bety a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aceq(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected bdjz b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acew(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new aces(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new acet(this));
  }
  
  private void a(List<ahua> paramList)
  {
    boolean bool2 = true;
    if (babd.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ahua localahua = (ahua)((Iterator)localObject).next();
        if (localahua.a == 3)
        {
          if (!localahua.e) {
            break label102;
          }
          this.k.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Acfg;
    if (this.k.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((acfg)localObject).a(bool1);
      this.jdField_a_of_type_Acfg.a(paramList);
      return;
      label102:
      this.k.setVisibility(0);
      if (!this.jdField_a_of_type_Ahuf.c()) {}
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
      afxv.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      afxv.d = paramBoolean;
      afxv.a = l;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void c()
  {
    boolean bool1 = azmk.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371298));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372228);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372394));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372395));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379165));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362790));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131373604));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373603));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366472));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362791);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131377064));
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131365412));
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365706));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131380396));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369029));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370869));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378432));
    Object localObject1 = (aopr)aoks.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((aopr)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131372402));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372403));
    Object localObject2 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int m;
    if (((localObject1 != null) && (((aopr)localObject1).a())) || (afxv.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (aous.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130846967));
      }
      bool2 = ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        m = 1;
        azqs.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", m, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aceu(this));
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
        azqs.b((QQAppInterface)localObject2, "dc00898", "", "", "", "0X800A414", m, 0, "", "", "", (String)localObject1);
        label609:
        if (!EmojiStickerManager.a()) {
          break label1779;
        }
        localObject1 = this.app.c();
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(localSharedPreferences.getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acfb(this, localSharedPreferences, (String)localObject1));
        label679:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362590));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361933));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Amga.a(true));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acfc(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.a().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694903));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alud.a(2131701159) + ulg.jdField_a_of_type_JavaLangString + alud.a(2131701163));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acfd(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839254);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((ulu.i()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
          break label1791;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label896:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131376176));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131695444), "qqsetting_screenshot_key", false);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acfe(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (alto)this.app.getManager(51);
        bool2 = ((alto)localObject1).f();
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
        bool2 = bkbq.i();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acej(this));
        if (((aulf)this.app.getManager(325)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = auku.a();
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acek(this));
        }
        if (afgj.a(this.app))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "TroopLeftSilde switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = afgj.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acel(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new acem(this));
        localObject1 = anke.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new acen(this, (ArrayList)localObject1));
        }
        bool2 = agyv.a(this.app).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(getResources().getString(2131692126));
        this.i.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (apjy)this.app.getManager(214);
        if ((!((apjy)localObject1).a()) || (!((apjy)localObject1).d())) {
          break label1865;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
        bool2 = ((apjy)localObject1).b();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(alud.a(2131701154));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aceo(this, (apjy)localObject1));
        label1378:
        if ((!arwq.a(this.app).a(this.app)) || (bool1)) {
          break label1877;
        }
        this.j.setVisibility(0);
        bool1 = arwq.a(this.app).a();
        this.j.setChecked(bool1);
        this.j.setContentDescription(alud.a(2131701158));
        this.j.setChecked(bool1);
        this.j.setOnCheckedChangeListener(new acep(this));
        label1462:
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364711));
        this.k = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131364704));
        if (this.jdField_a_of_type_Ahuf.c()) {
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
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131364718));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_Acfg = new acfg(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_Ahuf != null) {
        a(this.jdField_a_of_type_Ahuf.c());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Acfg);
      d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364467));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new acer(this));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(alud.a(2131701156));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alud.a(2131701166));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(alud.a(2131690932));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690237));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131376038));
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
      wxj.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label896;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acff(this, (alto)localObject1));
      break label992;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new acei(this, (TroopManager)localObject1));
      break label1025;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label1378;
      this.j.setVisibility(8);
      break label1462;
    }
  }
  
  private void d()
  {
    if (babd.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.k.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Ahuf != null)
      {
        List localList = this.jdField_a_of_type_Ahuf.c();
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
    if (this.jdField_a_of_type_Bdjz == null) {
      this.jdField_a_of_type_Bdjz = bdgm.a(this, 0, alud.a(2131701160), alud.a(2131701164), 2131695581, 2131695582, new acey(this), new acez(this));
    }
    this.jdField_a_of_type_Bdjz.show();
  }
  
  private void f()
  {
    beat.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_Bdjz == null) {
      this.jdField_b_of_type_Bdjz = bdgm.a(this, 0, null, alud.a(2131701165), 0, 2131720095, new acfa(this), null);
    }
    this.jdField_b_of_type_Bdjz.show();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Bdjz != null) {
      this.jdField_b_of_type_Bdjz.dismiss();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      this.jdField_a_of_type_Bdjz.dismiss();
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
    super.setTitle(2131695400);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Amga = ((amga)this.app.getManager(85));
    addObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_Ahuf = ((ahuf)this.app.getManager(295));
    if (this.jdField_a_of_type_Ahuf != null)
    {
      this.jdField_a_of_type_Ahuf.a(this.jdField_a_of_type_Ahue);
      this.jdField_a_of_type_Ahuf.d(false);
      this.jdField_a_of_type_Ahuf.a();
    }
    c();
    paramBundle = (alpk)this.app.a(2);
    if (paramBundle != null) {
      paramBundle.B();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Alpq != null) {
      removeObserver(this.jdField_a_of_type_Alpq);
    }
    if (this.jdField_a_of_type_Ahuf != null) {
      this.jdField_a_of_type_Ahuf.b(this.jdField_a_of_type_Ahue);
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
    this.jdField_a_of_type_Bety = null;
    this.jdField_a_of_type_Bety = new bety(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bety.a(getString(2131690864));
    this.jdField_a_of_type_Bety.c(true);
    this.jdField_a_of_type_Bety.a(false);
    this.jdField_a_of_type_Bety.b(true);
    return this.jdField_a_of_type_Bety;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131695400);
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