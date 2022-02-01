package com.tencent.mobileqq.activity;

import Override;
import adhv;
import adhw;
import adhx;
import adhy;
import adhz;
import adia;
import adib;
import adic;
import adid;
import adie;
import adif;
import adig;
import adih;
import adii;
import adij;
import adik;
import adil;
import adim;
import adin;
import adio;
import adip;
import adiq;
import adir;
import adis;
import adiv;
import adiw;
import adix;
import adiy;
import adiz;
import adjb;
import adjc;
import adjd;
import adje;
import ahdg;
import aiin;
import ajmt;
import ajmx;
import ajmy;
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
import anri;
import anvk;
import anvx;
import aohe;
import apsm;
import aqlq;
import aqlr;
import aqxe;
import ardl;
import arjv;
import arjw;
import asaa;
import aumk;
import axea;
import axel;
import baex;
import balv;
import banp;
import bdfk;
import bdla;
import bdvn;
import bhdj;
import bhzf;
import bisl;
import bmhv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
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
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nyv;
import vzh;
import vzv;
import ykv;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public adje a;
  private ajmx jdField_a_of_type_Ajmx = new adir(this);
  public ajmy a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adiy(this);
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adip(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aohe jdField_a_of_type_Aohe;
  aqlq jdField_a_of_type_Aqlq = new adjb(this);
  private baex jdField_a_of_type_Baex = new adif(this);
  public bisl a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adhv(this);
  protected QQCustomDialog a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public HeightAdaptableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new adiz(this);
  private View jdField_b_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adii(this);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected QQCustomDialog b;
  FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adis(this);
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adiq(this);
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
  private FormMultiLineSwitchItem m;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new adin(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new adio(this));
  }
  
  private void a(List<ajmt> paramList)
  {
    boolean bool2 = true;
    if (bdvn.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajmt localajmt = (ajmt)((Iterator)localObject).next();
        if (localajmt.a == 3)
        {
          if (!localajmt.e) {
            break label102;
          }
          this.m.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_Adje;
    if (this.m.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((adje)localObject).a(bool1);
      this.jdField_a_of_type_Adje.a(paramList);
      return;
      label102:
      this.m.setVisibility(0);
      if (!this.jdField_a_of_type_Ajmy.c()) {}
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
      ahdg.e = true;
    }
    for (;;)
    {
      localEditor.commit();
      ahdg.d = paramBoolean;
      ahdg.a = l1;
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
    boolean bool1 = bdfk.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372135));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131373108);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373280));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373281));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380338));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131362949));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374449));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131374448));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366930));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362950);
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)super.findViewById(2131378072));
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131365817));
    this.j = ((FormMultiLineSwitchItem)super.findViewById(2131366119));
    this.k = ((FormMultiLineSwitchItem)super.findViewById(2131381672));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131369659));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371691));
    this.l = ((FormMultiLineSwitchItem)findViewById(2131377124));
    f();
    Object localObject1 = (ardl)aqxe.a().a(442);
    boolean bool2;
    if (localObject1 != null)
    {
      bool2 = ((ardl)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool2);
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373286));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373287));
    Object localObject2 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    int n;
    if (((localObject1 != null) && (((ardl)localObject1).a())) || (ahdg.d))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (arjw.c().a > 1)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText("超级会员尊享语音消息自动转文本\n点击语音仍可收听。");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setRightIcon(getResources().getDrawable(2130847438));
      }
      bool2 = ((SharedPreferences)localObject2).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
      if (bool2 == true)
      {
        n = 1;
        bdla.b(null, "dc00898", "", "", "0X8009DF5", "0X8009DF5", n, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new adjc(this));
        localObject1 = "normal";
        if (!VipUtils.c(this.app)) {
          break label1750;
        }
        localObject1 = "vip";
        label574:
        localObject2 = this.app;
        if (!bool2) {
          break label1768;
        }
        n = 1;
        label586:
        bdla.b((QQAppInterface)localObject2, "dc00898", "", "", "", "0X800A414", n, 0, "", "", "", (String)localObject1);
        label613:
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131373426));
        if (!banp.a().b()) {
          break label1809;
        }
        if (getIntent().getBooleanExtra("need_open_tips", false)) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setBackgroundColor(getResources().getColor(2131167353));
        }
        b(banp.a().jdField_a_of_type_Boolean, this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        label681:
        if (!EmojiStickerManager.a()) {
          break label1821;
        }
        localObject1 = this.app.getCurrentUin();
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(localSharedPreferences.getBoolean("sticker_switch_" + (String)localObject1, true));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new adjd(this, localSharedPreferences, (String)localObject1));
        label751:
        g();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362734));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131361991));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(this.jdField_a_of_type_Aohe.a(true));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new adhw(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getNowLiveManager().jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131694365));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131700277) + vzh.jdField_a_of_type_JavaLangString + anvx.a(2131700281));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new adhx(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839496);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        if ((vzv.i()) && (this.app.getNowLiveManager().jdField_a_of_type_Char != '0') && (this.app.getNowLiveManager().jdField_a_of_type_Char != '1')) {
          break label1833;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label972:
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131377108));
        bool2 = SettingCloneUtil.readValue(this, null, super.getString(2131694747), "qqsetting_screenshot_key", false);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new adhy(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        localObject1 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool2 = ((anvk)localObject1).f();
        if (!bool1) {
          break label1851;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        label1069:
        localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        bool2 = ((TroopManager)localObject1).f();
        if (!bool1) {
          break label1879;
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        label1103:
        bool2 = bmhv.l();
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new adib(this));
        d();
        if (((axel)this.app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssistantSettingActivity", 2, "MultiAio switch is open, so switch is visible");
          }
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          bool2 = axea.a();
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
          this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new adic(this));
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new adid(this));
        localObject1 = apsm.a(this.app.getCurrentAccountUin());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(new adie(this, (ArrayList)localObject1));
        }
        bool2 = aiin.a(this.app).b();
        this.j.setChecked(bool2);
        this.j.setContentDescription(getResources().getString(2131691901));
        this.j.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject1 = (asaa)this.app.getManager(QQManagerFactory.DOUTU_MAGAGER);
        if ((!((asaa)localObject1).a()) || (!((asaa)localObject1).d())) {
          break label1907;
        }
        this.i.setVisibility(0);
        bool2 = ((asaa)localObject1).b();
        this.i.setChecked(bool2);
        this.i.setContentDescription(anvx.a(2131700272));
        this.i.setOnCheckedChangeListener(new adig(this, (asaa)localObject1));
        label1399:
        if ((!aumk.a(this.app).a(this.app)) || (bool1)) {
          break label1919;
        }
        this.k.setVisibility(0);
        bool1 = aumk.a(this.app).a();
        this.k.setChecked(bool1);
        this.k.setContentDescription(anvx.a(2131700276));
        this.k.setChecked(bool1);
        this.k.setOnCheckedChangeListener(new adih(this));
        label1483:
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365095));
        this.m = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131365083));
        if (this.jdField_a_of_type_Ajmy.c()) {
          break label1931;
        }
      }
    }
    label1931:
    for (bool1 = true;; bool1 = false)
    {
      a(bool1);
      this.m.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365102));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_Adje = new adje(this, this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_Ajmy != null) {
        a(this.jdField_a_of_type_Ajmy.c());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_Adje);
      i();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364837));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adij(this));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(anvx.a(2131700274));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131700284));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anvx.a(2131690899));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131690150));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131376951));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.31(this));
      return;
      n = 0;
      break;
      label1750:
      if (!VipUtils.b(this.app)) {
        break label574;
      }
      localObject1 = "svip";
      break label574;
      label1768:
      n = 2;
      break label586;
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "disable the ptt check box");
      b(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label613;
      label1809:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label681;
      label1821:
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      break label751;
      label1833:
      ykv.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label972;
      label1851:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new adhz(this, (anvk)localObject1));
      break label1069;
      label1879:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(bool2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(new adia(this, (TroopManager)localObject1));
      break label1103;
      label1907:
      this.i.setVisibility(8);
      break label1399;
      label1919:
      this.k.setVisibility(8);
      break label1483;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363746));
    if (QzoneConfig.isShowBottomTabSwitch())
    {
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adik(this));
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
      {
        if (!bmhv.i()) {
          break label106;
        }
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      }
      while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
        label106:
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      }
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
    this.l.setOnCheckedChangeListener(new adil(this));
    bdla.b(this.app, "dc00898", "", "", "0X800B4E5", "0X800B4E5", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    int i1 = 8;
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371668));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379810));
    boolean bool = aqlr.b();
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
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(aqlr.a(this.app));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new adim(this));
        bdla.b(this.app, "dc00898", "", "", "0X800B332", "0X800B332", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void h()
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    boolean bool;
    for (int n = 1;; n = 0)
    {
      bool = FloatingScreenPermission.checkPermission(this);
      if (((n == 0) || (!bool)) && (banp.a().jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695063)));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      e();
      return;
    }
    if (n != 0) {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695066)));
    }
    for (;;)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineClick(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      break;
      if (bool) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695065)));
      } else {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setSecendLineText(Html.fromHtml(getResources().getString(2131695064)));
      }
    }
  }
  
  private void i()
  {
    if (bdvn.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.m.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Ajmy != null)
      {
        List localList = this.jdField_a_of_type_Ajmy.c();
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 0, anvx.a(2131700278), anvx.a(2131700282), 2131694840, 2131694841, new adiv(this), new adiw(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void k()
  {
    bhzf.b(this.app, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 0, null, anvx.a(2131700283), 0, 2131718822, new adix(this), null);
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
    super.setContentView(2131558718);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131694721);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Aohe = ((aohe)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Aqlq);
    addObserver(this.jdField_a_of_type_Baex);
    this.jdField_a_of_type_Ajmy = ((ajmy)this.app.getManager(QQManagerFactory.CTENTRY_MNG));
    if (this.jdField_a_of_type_Ajmy != null)
    {
      this.jdField_a_of_type_Ajmy.a(this.jdField_a_of_type_Ajmx);
      this.jdField_a_of_type_Ajmy.d(false);
      this.jdField_a_of_type_Ajmy.a();
    }
    c();
    paramBundle = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramBundle != null) {
      paramBundle.z();
    }
    balv.a(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_Aqlq != null) {
      removeObserver(this.jdField_a_of_type_Aqlq);
    }
    if (this.jdField_a_of_type_Baex != null) {
      removeObserver(this.jdField_a_of_type_Baex);
    }
    if (this.jdField_a_of_type_Ajmy != null) {
      this.jdField_a_of_type_Ajmy.b(this.jdField_a_of_type_Ajmx);
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
    this.jdField_a_of_type_Bisl = null;
    this.jdField_a_of_type_Bisl = new bisl(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bisl.a(getString(2131690828));
    this.jdField_a_of_type_Bisl.c(true);
    this.jdField_a_of_type_Bisl.a(false);
    this.jdField_a_of_type_Bisl.b(true);
    return this.jdField_a_of_type_Bisl;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131694721);
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