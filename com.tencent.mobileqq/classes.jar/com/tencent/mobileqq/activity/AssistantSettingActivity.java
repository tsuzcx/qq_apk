package com.tencent.mobileqq.activity;

import aais;
import aait;
import aaiu;
import aaiv;
import aaiw;
import aaix;
import aaiy;
import aaiz;
import aaja;
import aajb;
import aajc;
import aajd;
import aaje;
import aajf;
import aajg;
import aajh;
import aaji;
import aajj;
import aajk;
import aajl;
import aajm;
import aajn;
import aajo;
import aajp;
import aajq;
import aajr;
import aajs;
import aajt;
import adjn;
import adwt;
import aexb;
import afru;
import afrx;
import afry;
import ahfx;
import ahif;
import ajti;
import ajto;
import ajxl;
import ajya;
import akjv;
import alpe;
import ampl;
import amue;
import amzb;
import amzc;
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
import anoi;
import apzf;
import aspm;
import aspx;
import axmv;
import axqy;
import bbdj;
import bbgu;
import bbxj;
import bcqf;
import bcql;
import bhvy;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nde;
import ssf;
import sst;
import vei;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public aajt a;
  private afrx jdField_a_of_type_Afrx = new aajk(this);
  public afry a;
  private ajto jdField_a_of_type_Ajto = new aais(this);
  private akjv jdField_a_of_type_Akjv;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aaji(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bbgu a;
  public bcqf a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aajb(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected bbgu b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aajj(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new aajg(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    bcql.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new aajh(this));
  }
  
  private void a(List<afru> paramList)
  {
    boolean bool2 = true;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        afru localafru = (afru)((Iterator)localObject).next();
        if (localafru.a == 3)
        {
          if (!localafru.e) {
            break label95;
          }
          this.k.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Aajt;
    if (this.k.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((aajt)localObject).a(bool1);
      this.jdField_a_of_type_Aajt.a(paramList);
      return;
      label95:
      this.k.setVisibility(0);
      if (!this.jdField_a_of_type_Afry.c()) {}
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
      adwt.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      adwt.d = paramBoolean;
      adwt.a = l;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  private void c()
  {
    boolean bool1 = axmv.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131370968));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131371889);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372057));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372058));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378495));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362760));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131373115));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373114));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366362));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362761);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131376510));
    localObject2 = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131365325));
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365621));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131379594));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131368792));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370544));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370545));
    Object localObject1 = (amue)ampl.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((amue)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131372065));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372066));
    localObject3 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject3).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int m;
    if (((localObject1 != null) && (((amue)localObject1).a())) || (adwt.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (amzc.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130846513));
      }
      bool2 = ((SharedPreferences)localObject3).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        m = 1;
        axqy.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", m, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aajf(this));
        localObject1 = "normal";
        if (!VipUtils.c(this.app)) {
          break label1900;
        }
        localObject1 = "vip";
        label570:
        localObject3 = this.app;
        if (!bool2) {
          break label1918;
        }
        m = 1;
        label582:
        axqy.b((QQAppInterface)localObject3, "dc00898", "", "", "", "0X800A414", m, 0, "", "", "", (String)localObject1);
        label609:
        if (!EmojiStickerManager.a()) {
          break label1959;
        }
        localObject1 = this.app.c();
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(((SharedPreferences)localObject2).getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aajo(this, (SharedPreferences)localObject2, (String)localObject1));
        label679:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362562));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361931));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Akjv.a(true));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aajp(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.a().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694744));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131700778) + ssf.jdField_a_of_type_JavaLangString + ajya.a(2131700782));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aajq(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839169);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((sst.i()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
          break label1971;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label896:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131375631));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131695284), "qqsetting_screenshot_key", false);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aajr(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (ajxl)this.app.getManager(51);
        bool2 = ((ajxl)localObject1).f();
        if (!bool1) {
          break label1989;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label992:
        localObject1 = (TroopManager)this.app.getManager(52);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label2017;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1025:
        bool2 = bhvy.i();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aaiu(this));
        if (((aspx)this.app.getManager(325)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = aspm.a();
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aaiv(this));
        }
        if ((adjn.b()) && (adjn.c()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "Multicard switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = adjn.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aaiw(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aaix(this));
        localObject1 = alpe.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aaiy(this, (ArrayList)localObject1));
        }
        bool2 = aexb.a(this.app).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(getResources().getString(2131692070));
        this.i.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (anoi)this.app.getManager(214);
        if ((!((anoi)localObject1).a()) || (!((anoi)localObject1).d())) {
          break label2045;
        }
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
        bool2 = ((anoi)localObject1).b();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(ajya.a(2131700773));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aaiz(this, (anoi)localObject1));
        label1380:
        if ((!apzf.a(this.app).a(this.app)) || (bool1)) {
          break label2057;
        }
        this.j.setVisibility(0);
        bool1 = apzf.a(this.app).a();
        this.j.setChecked(bool1);
        this.j.setContentDescription(ajya.a(2131700777));
        this.j.setChecked(bool1);
        this.j.setOnCheckedChangeListener(new aaja(this));
        label1464:
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364631));
        this.k = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131364624));
        if (this.jdField_a_of_type_Afry.c()) {
          break label2069;
        }
        bool1 = true;
        label1510:
        a(bool1);
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131364638));
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
        this.jdField_a_of_type_Aajt = new aajt(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        if (this.jdField_a_of_type_Afry != null) {
          a(this.jdField_a_of_type_Afry.c());
        }
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Aajt);
        d();
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131376413);
        localObject2 = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131376412);
        localObject3 = (TextView)this.mContentView.findViewById(2131378311);
        ahfx localahfx = (ahfx)this.app.getManager(342);
        if (!localahfx.g()) {
          continue;
        }
        ahif.a("sq.sz.dzkg", 0, 0, null);
        ((FormMultiLineSwitchItem)localObject1).setVisibility(0);
        ((FormMultiLineSwitchItem)localObject1).setOnCheckedChangeListener(new aajc(this, localahfx));
        ((FormMultiLineSwitchItem)localObject1).setChecked(localahfx.d());
        if (!localahfx.b()) {
          continue;
        }
        ahif.a("sq.sz.hxdkg", 0, 0, null);
        ((FormMultiLineSwitchItem)localObject2).setVisibility(0);
        ((FormMultiLineSwitchItem)localObject2).setOnCheckedChangeListener(new aajd(this, localahfx));
        ((FormMultiLineSwitchItem)localObject2).setChecked(localahfx.e());
      }
      catch (Throwable localThrowable)
      {
        label1900:
        label1918:
        QLog.e("AssistantSettingActivity", 1, localThrowable, new Object[0]);
        label1959:
        label1971:
        label1989:
        label2017:
        label2045:
        continue;
        label2057:
        label2069:
        ((FormMultiLineSwitchItem)localObject2).setVisibility(8);
        continue;
        ((TextView)localObject3).setVisibility(8);
        continue;
      }
      if ((((FormMultiLineSwitchItem)localObject1).getVisibility() != 0) && (((FormMultiLineSwitchItem)localObject2).getVisibility() != 0)) {
        continue;
      }
      ((TextView)localObject3).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364394));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aaje(this));
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(ajya.a(2131700775));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131700785));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131690878));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690189));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131375497));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.29(this));
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
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label679;
      vei.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label896;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aajs(this, (ajxl)localObject1));
      break label992;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new aait(this, (TroopManager)localObject1));
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
    if (this.jdField_a_of_type_Afry != null)
    {
      List localList = this.jdField_a_of_type_Afry.c();
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
    if (this.jdField_a_of_type_Bbgu == null) {
      this.jdField_a_of_type_Bbgu = bbdj.a(this, 0, ajya.a(2131700779), ajya.a(2131700783), 2131695421, 2131695422, new aajl(this), new aajm(this));
    }
    this.jdField_a_of_type_Bbgu.show();
  }
  
  private void f()
  {
    bbxj.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_Bbgu == null) {
      this.jdField_b_of_type_Bbgu = bbdj.a(this, 0, null, ajya.a(2131700784), 0, 2131719551, new aajn(this), null);
    }
    this.jdField_b_of_type_Bbgu.show();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Bbgu != null) {
      this.jdField_b_of_type_Bbgu.dismiss();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558635);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131695240);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Akjv = ((akjv)this.app.getManager(85));
    addObserver(this.jdField_a_of_type_Ajto);
    this.jdField_a_of_type_Afry = ((afry)this.app.getManager(295));
    if (this.jdField_a_of_type_Afry != null)
    {
      this.jdField_a_of_type_Afry.a(this.jdField_a_of_type_Afrx);
      this.jdField_a_of_type_Afry.d(false);
      this.jdField_a_of_type_Afry.a();
    }
    c();
    paramBundle = (ajti)this.app.a(2);
    if (paramBundle != null) {
      paramBundle.A();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Ajto != null) {
      removeObserver(this.jdField_a_of_type_Ajto);
    }
    if (this.jdField_a_of_type_Afry != null) {
      this.jdField_a_of_type_Afry.b(this.jdField_a_of_type_Afrx);
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
    this.jdField_a_of_type_Bcqf = null;
    this.jdField_a_of_type_Bcqf = new bcqf(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.a(getString(2131690811));
    this.jdField_a_of_type_Bcqf.c(true);
    this.jdField_a_of_type_Bcqf.a(false);
    this.jdField_a_of_type_Bcqf.b(true);
    return this.jdField_a_of_type_Bcqf;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131695240);
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