package com.tencent.mobileqq.activity;

import aaaa;
import aaab;
import aaac;
import aaad;
import aaae;
import aaaf;
import acyo;
import adlw;
import aemi;
import affz;
import afgc;
import afgd;
import agtk;
import agvs;
import ajfi;
import ajfo;
import ajjj;
import ajjy;
import ajvm;
import alat;
import alrv;
import alsp;
import alsq;
import aluq;
import alzw;
import amdz;
import amiq;
import amir;
import amxv;
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
import apha;
import artg;
import artr;
import awnu;
import awqx;
import babr;
import bafb;
import bajr;
import baub;
import bbms;
import bbmy;
import bgmq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msg;
import sfm;
import sga;
import urp;
import zze;
import zzf;
import zzg;
import zzh;
import zzi;
import zzj;
import zzk;
import zzl;
import zzm;
import zzn;
import zzo;
import zzp;
import zzq;
import zzr;
import zzs;
import zzt;
import zzu;
import zzv;
import zzw;
import zzx;
import zzy;
import zzz;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public aaaf a;
  private afgc jdField_a_of_type_Afgc = new zzw(this);
  public afgd a;
  private ajfo jdField_a_of_type_Ajfo = new zze(this);
  private ajvm jdField_a_of_type_Ajvm;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new zzu(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bafb a;
  public bbms a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new zzn(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected bafb b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new zzv(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
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
  private FormMultiLineSwitchItem jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSwitchItem jdField_i_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormMultiLineSwitchItem j;
  private FormMultiLineSwitchItem k;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new zzs(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    bbmy.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new zzt(this));
  }
  
  private void a(List<affz> paramList)
  {
    boolean bool2 = true;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        affz localaffz = (affz)((Iterator)localObject).next();
        if (localaffz.a == 3)
        {
          if (!localaffz.e) {
            break label95;
          }
          this.k.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Aaaf;
    if (this.k.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((aaaf)localObject).a(bool1);
      this.jdField_a_of_type_Aaaf.a(paramList);
      return;
      label95:
      this.k.setVisibility(0);
      if (!this.jdField_a_of_type_Afgd.c()) {}
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
    if (this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
    {
      this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
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
      adlw.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      adlw.d = paramBoolean;
      adlw.a = l;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void c()
  {
    bool1 = awnu.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131305293));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131306192);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131306360));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131306361));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131312666));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131297221));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131307402));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131307401));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131300751));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297222);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131310714));
    localObject2 = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131299758));
    this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131300026));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131313753));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131303152));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131304879));
    this.jdField_i_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131304880));
    Object localObject1 = (amdz)alzw.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((amdz)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131306368));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306369));
    localObject3 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject3).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    if (((localObject1 != null) && (((amdz)localObject1).a())) || (adlw.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (amir.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130846326));
      }
      bool2 = ((SharedPreferences)localObject3).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        m = 1;
        awqx.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", m, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new zzr(this));
        localObject1 = "normal";
        if (!bajr.c(this.app)) {
          break label1977;
        }
        localObject1 = "vip";
        label570:
        localObject3 = this.app;
        if (!bool2) {
          break label1995;
        }
        m = 1;
        label582:
        awqx.b((QQAppInterface)localObject3, "dc00898", "", "", "", "0X800A414", m, 0, "", "", "", (String)localObject1);
        label609:
        if (!EmojiStickerManager.a()) {
          break label2036;
        }
        localObject1 = this.app.c();
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(((SharedPreferences)localObject2).getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aaaa(this, (SharedPreferences)localObject2, (String)localObject1));
        label679:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131297024));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131296396));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Ajvm.a(true));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aaab(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.a().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131629078));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131634983) + sfm.jdField_a_of_type_JavaLangString + ajjy.a(2131634987));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aaac(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839144);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((sga.i()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
          break label2048;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label896:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131309870));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131629602), "qqsetting_screenshot_key", false);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aaad(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (ajjj)this.app.getManager(51);
        bool2 = ((ajjj)localObject1).f();
        if (!bool1) {
          break label2066;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label992:
        localObject1 = (TroopManager)this.app.getManager(52);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label2094;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1025:
        bool2 = bgmq.i();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new zzg(this));
        if (((artr)this.app.getManager(325)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = artg.a();
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new zzh(this));
        }
        if ((acyo.b()) && (acyo.c()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "Multicard switch is open, so switch is visible");
          }
          this.jdField_i_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = acyo.a();
          this.jdField_i_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_i_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new zzi(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new zzj(this));
        localObject1 = alat.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new zzk(this, (ArrayList)localObject1));
        }
        bool2 = aemi.a(this.app).b();
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(getResources().getString(2131626484));
        this.jdField_i_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (amxv)this.app.getManager(214);
        if ((!((amxv)localObject1).a()) || (!((amxv)localObject1).d())) {
          break label2122;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
        bool2 = ((amxv)localObject1).b();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(ajjy.a(2131634978));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new zzl(this, (amxv)localObject1));
        label1380:
        if ((!apha.a(this.app).a(this.app)) || (bool1)) {
          break label2134;
        }
        this.j.setVisibility(0);
        bool1 = apha.a(this.app).a();
        this.j.setChecked(bool1);
        this.j.setContentDescription(ajjy.a(2131634982));
        this.j.setChecked(bool1);
        this.j.setOnCheckedChangeListener(new zzm(this));
        label1464:
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131299072));
        this.k = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131299065));
        if (this.jdField_a_of_type_Afgd.c()) {
          break label2146;
        }
        bool1 = true;
        label1510:
        a(bool1);
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131299079));
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
        this.jdField_a_of_type_Aaaf = new aaaf(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        if (this.jdField_a_of_type_Afgd != null) {
          a(this.jdField_a_of_type_Afgd.c());
        }
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Aaaf);
        d();
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131310618);
        localObject2 = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131310617);
        localObject3 = (TextView)this.mContentView.findViewById(2131312482);
        agtk localagtk = (agtk)this.app.getManager(342);
        if (!localagtk.g()) {
          continue;
        }
        agvs.a("sq.sz.dzkg", 0, 0, null);
        ((FormMultiLineSwitchItem)localObject1).setVisibility(0);
        ((FormMultiLineSwitchItem)localObject1).setOnCheckedChangeListener(new zzo(this, localagtk));
        ((FormMultiLineSwitchItem)localObject1).setChecked(localagtk.d());
        if (!localagtk.b()) {
          continue;
        }
        agvs.a("sq.sz.hxdkg", 0, 0, null);
        ((FormMultiLineSwitchItem)localObject2).setVisibility(0);
        ((FormMultiLineSwitchItem)localObject2).setOnCheckedChangeListener(new zzp(this, localagtk));
        ((FormMultiLineSwitchItem)localObject2).setChecked(localagtk.e());
      }
      catch (Throwable localThrowable)
      {
        label1977:
        label1995:
        label2036:
        QLog.e("AssistantSettingActivity", 1, localThrowable, new Object[0]);
        label2048:
        label2066:
        label2094:
        label2122:
        label2134:
        label2146:
        continue;
        ((FormMultiLineSwitchItem)localObject2).setVisibility(8);
        continue;
        ((TextView)localObject3).setVisibility(8);
        continue;
        bool1 = false;
        continue;
        m = 0;
        continue;
      }
      if ((((FormMultiLineSwitchItem)localObject1).getVisibility() != 0) && (((FormMultiLineSwitchItem)localObject2).getVisibility() != 0)) {
        continue;
      }
      ((TextView)localObject3).setVisibility(0);
      localObject1 = alsq.a();
      if ((localObject1 == null) || (!((alsp)localObject1).a())) {
        continue;
      }
      m = 1;
      if ((!alrv.a(this.app)) || (m == 0)) {
        continue;
      }
      bool1 = true;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131298838));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131298839));
      if (m != 0)
      {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new zzq(this));
      }
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(ajjy.a(2131634980));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131634990));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131624635));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131625305));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131309740));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.29(this));
      return;
      m = 0;
      break;
      if (!bajr.b(this.app)) {
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
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label679;
      urp.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label896;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aaae(this, (ajjj)localObject1));
      break label992;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new zzf(this, (TroopManager)localObject1));
      break label1025;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label1380;
      this.j.setVisibility(8);
      break label1464;
      bool1 = false;
      break label1510;
      ((FormMultiLineSwitchItem)localObject1).setVisibility(8);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Afgd != null)
    {
      List localList = this.jdField_a_of_type_Afgd.c();
      if ((localList != null) && (localList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssistantSettingActivity", 2, "updateCTEntrySetting visible: " + this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bafb == null) {
      this.jdField_a_of_type_Bafb = babr.a(this, 0, ajjy.a(2131634984), ajjy.a(2131634988), 2131629739, 2131629740, new zzx(this), new zzy(this));
    }
    this.jdField_a_of_type_Bafb.show();
  }
  
  private void f()
  {
    baub.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_Bafb == null) {
      this.jdField_b_of_type_Bafb = babr.a(this, 0, null, ajjy.a(2131634989), 0, 2131653656, new zzz(this), null);
    }
    this.jdField_b_of_type_Bafb.show();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Bafb != null) {
      this.jdField_b_of_type_Bafb.dismiss();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131493083);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131629558);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Ajvm = ((ajvm)this.app.getManager(85));
    addObserver(this.jdField_a_of_type_Ajfo);
    this.jdField_a_of_type_Afgd = ((afgd)this.app.getManager(295));
    if (this.jdField_a_of_type_Afgd != null)
    {
      this.jdField_a_of_type_Afgd.a(this.jdField_a_of_type_Afgc);
      this.jdField_a_of_type_Afgd.d(false);
      this.jdField_a_of_type_Afgd.a();
    }
    c();
    paramBundle = (ajfi)this.app.a(2);
    if (paramBundle != null) {
      paramBundle.A();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Ajfo != null) {
      removeObserver(this.jdField_a_of_type_Ajfo);
    }
    if (this.jdField_a_of_type_Afgd != null) {
      this.jdField_a_of_type_Afgd.b(this.jdField_a_of_type_Afgc);
    }
    b();
    a();
    String str = getIntent().getStringExtra("from");
    if ((str != null) && (str.equals("color_note")) && (!getIntent().getBooleanExtra("do_not_open", false))) {
      aluq.a(getApplicationContext(), true);
    }
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
    this.jdField_a_of_type_Bbms = null;
    this.jdField_a_of_type_Bbms = new bbms(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bbms.a(getString(2131625250));
    this.jdField_a_of_type_Bbms.c(true);
    this.jdField_a_of_type_Bbms.a(false);
    this.jdField_a_of_type_Bbms.b(true);
    return this.jdField_a_of_type_Bbms;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131629558);
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