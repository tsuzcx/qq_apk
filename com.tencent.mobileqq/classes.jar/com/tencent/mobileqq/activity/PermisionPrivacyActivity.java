package com.tencent.mobileqq.activity;

import adhu;
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
import aekt;
import alkv;
import allb;
import alox;
import aloz;
import alpo;
import alqy;
import alxl;
import alzf;
import amab;
import ambl;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aogj;
import aovp;
import aovq;
import aovt;
import ased;
import asuf;
import asuk;
import aubn;
import aupd;
import axxl;
import axzt;
import azib;
import azmj;
import bdee;
import bdiv;
import bdog;
import bdrb;
import bepp;
import beps;
import bizm;
import bizt;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;
import xod;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aovp, aubn
{
  private int jdField_a_of_type_Int = -1;
  private allb jdField_a_of_type_Allb = new adhy(this);
  alox jdField_a_of_type_Alox = new adhv(this);
  alqy jdField_a_of_type_Alqy = new adhx(this);
  public alzf a;
  amab jdField_a_of_type_Amab = new adig(this);
  private ambl jdField_a_of_type_Ambl;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  public TextView a;
  ased jdField_a_of_type_Ased = new adif(this);
  asuk jdField_a_of_type_Asuk = new adhw(this);
  private axxl jdField_a_of_type_Axxl = new adia(this);
  private axzt jdField_a_of_type_Axzt;
  private bepp jdField_a_of_type_Bepp;
  protected beps a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  protected BounceScrollView a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  public FormSwitchItem b;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  private FormSimpleItem d;
  public FormSwitchItem d;
  private FormSimpleItem e;
  public FormSwitchItem e;
  private FormSimpleItem f;
  public FormSwitchItem f;
  private FormSimpleItem g;
  public FormSwitchItem g;
  private FormSimpleItem h;
  public FormSwitchItem h;
  public FormSwitchItem i;
  public FormSwitchItem j;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new adhz(this);
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "gotoFriendSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private boolean a()
  {
    try
    {
      asuf localasuf = (asuf)aogj.a().a(445);
      if (localasuf != null)
      {
        boolean bool = localasuf.a;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.security", 1, localException, new Object[0]);
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362926));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362927));
    boolean bool = bdiv.d(this, this.app.getCurrentAccountUin());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    label226:
    Object localObject2;
    label285:
    label490:
    Object localObject3;
    if (bool)
    {
      k = 2131693298;
      ((TextView)localObject1).setText(k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_Alzf.d();
      this.jdField_b_of_type_AndroidViewView = findViewById(2131374269);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131373534);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372045));
      g();
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373550));
      localObject1 = (aloz)this.app.getManager(51);
      if (!VipUtils.a(this.app)) {
        break label1303;
      }
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131699806));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adhu(this));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131373565));
      localObject2 = (aovt)this.app.getManager(41);
      if (!((aovt)localObject2).d()) {
        break label1323;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((aovt)localObject2).c());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131376526));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131376967));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376597));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376593));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.d(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370988));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362541));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363870));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378249));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371683));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371684));
      localObject1 = ((aloz)localObject1).c(this.app.getCurrentAccountUin());
      if (!((Card)localObject1).allowClick) {
        break label1335;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1356;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(alpo.a(2131699787));
      label521:
      if (!((Card)localObject1).troopHonorSwitch) {
        break label1372;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(alpo.a(2131699787));
      label541:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373538));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      c();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373539));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      azmj.b(null, "dc00898", "", "", "0X800ACA5", "0X800ACA5", 0, 0, "", "0", "0", "");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373535));
      d();
      localObject2 = (alkv)this.app.a(2);
      ((alkv)localObject2).p();
      ((alkv)localObject2).q();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131373536));
      localObject3 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_a_of_type_Axzt == null) || (!this.jdField_a_of_type_Axzt.b())) {
        break label1388;
      }
      bool = true;
      label702:
      ((FormSwitchItem)localObject3).setChecked(bool);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.n());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.p());
      bool = this.app.o();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
      a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), ((Card)localObject1).strangerInviteMeGroupOpen);
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362924));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.i = ((FormSwitchItem)super.findViewById(2131370109));
      if (bdiv.W(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.i.setVisibility(0);
        ThreadManager.post(new PermisionPrivacyActivity.2(this), 5, null, true);
        this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      localObject3 = (FormSimpleItem)findViewById(2131364962);
      if ((localObject3 == null) || (!bdog.a().a())) {
        break label1393;
      }
      ((FormSimpleItem)localObject3).setLeftText(getResources().getString(2131691384));
      ((FormSimpleItem)localObject3).a().setMaxWidth(aekt.a(130.0F, getResources()));
      ((FormSimpleItem)localObject3).setOnClickListener(new adid(this));
      PermisionPrivacyActivity.4 local4 = new PermisionPrivacyActivity.4(this, (FormSimpleItem)localObject3);
      local4.run();
      ((FormSimpleItem)localObject3).setTag("online_status_callback".hashCode(), local4);
      bdog.a().a(local4);
      label1087:
      if (AppSetting.c)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131699748));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(alpo.a(2131708301));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131708296));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131708294));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131694763));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131690080));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131708295));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131708297));
      }
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!a()) {
        break label1408;
      }
      k = 0;
      label1234:
      ((FormSwitchItem)localObject3).setVisibility(k);
      ((alkv)localObject2).l();
      this.j = ((FormSwitchItem)findViewById(2131376613));
      localObject2 = this.j;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1414;
      }
    }
    label1408:
    label1414:
    for (bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool);
      this.j.setOnCheckedChangeListener(new adie(this));
      return;
      k = 2131693299;
      break;
      label1303:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      break label226;
      label1323:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label285;
      label1335:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label490;
      label1356:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(alpo.a(2131699788));
      break label521;
      label1372:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(alpo.a(2131699788));
      break label541;
      label1388:
      bool = false;
      break label702;
      label1393:
      if (localObject3 == null) {
        break label1087;
      }
      ((FormSimpleItem)localObject3).setVisibility(8);
      break label1087;
      k = 8;
      break label1234;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new PermisionPrivacyActivity.14(this, paramBoolean));
  }
  
  private void c()
  {
    ThreadManager.excute(new PermisionPrivacyActivity.6(this), 16, null, true);
  }
  
  private void d()
  {
    if ((this.app != null) && (aupd.a(this.app.c())))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      azmj.b(this.app, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
      e();
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    if ((isFinishing()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    ThreadManager.excute(new PermisionPrivacyActivity.7(this), 16, null, true);
  }
  
  private void f()
  {
    if (bdee.g(this)) {
      ((alxl)this.app.a(13)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject2 = ((aloz)this.app.getManager(51)).b(this.app.c());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = bdrb.a().a(this.app.c(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, xod.a(this.app.getApp(), 47.0F), xod.a(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new adib(this));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, xod.a(this.app.getApp(), 47.0F), xod.a(this.app.getApp(), 14.0F));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new adic(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131695355));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bepp != null)
      {
        this.jdField_a_of_type_Bepp.dismiss();
        this.jdField_a_of_type_Bepp.cancel();
        this.jdField_a_of_type_Bepp = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bepp.setCancelable(true);
    this.jdField_a_of_type_Bepp.a(paramString);
    this.jdField_a_of_type_Bepp.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, aovq paramaovq)
  {
    paramaovq.a(paramBoolean);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      c();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    super.setContentView(2131561279);
    setTitle(2131699785);
    this.jdField_a_of_type_Beps = new beps(this);
    this.jdField_a_of_type_Axzt = ((axzt)this.app.getManager(15));
    this.jdField_a_of_type_Ambl = ((ambl)this.app.getManager(85));
    if (this.jdField_a_of_type_Axzt != null) {
      this.jdField_a_of_type_Axzt.a(this.jdField_a_of_type_Axxl);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_Alzf = ((alzf)this.app.a(20));
    b();
    addObserver(this.jdField_a_of_type_Alqy);
    addObserver(this.jdField_a_of_type_Alox);
    addObserver(this.jdField_a_of_type_Asuk);
    addObserver(this.jdField_a_of_type_Allb);
    addObserver(this.jdField_a_of_type_Amab);
    addObserver(this.jdField_a_of_type_Ased);
    this.app.t();
    this.app.u();
    this.app.c(true);
    this.app.d(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    if (this.jdField_a_of_type_Allb != null) {
      removeObserver(this.jdField_a_of_type_Allb);
    }
    if (this.jdField_a_of_type_Axzt != null) {
      this.jdField_a_of_type_Axzt.b(this.jdField_a_of_type_Axxl);
    }
    removeObserver(this.jdField_a_of_type_Alqy);
    removeObserver(this.jdField_a_of_type_Alox);
    removeObserver(this.jdField_a_of_type_Asuk);
    removeObserver(this.jdField_a_of_type_Amab);
    removeObserver(this.jdField_a_of_type_Ased);
    if (this.jdField_a_of_type_Beps != null)
    {
      this.jdField_a_of_type_Beps.b();
      this.jdField_a_of_type_Beps = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    g();
    f();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    int k;
    BounceScrollView localBounceScrollView;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376147));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        k = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - xod.d(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130849676);
      ThreadManager.getUIHandler().postDelayed(new PermisionPrivacyActivity.15(this), 1000L);
      return;
      label98:
      k = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131373534: 
    case 2131374269: 
    case 2131373535: 
      do
      {
        return;
        a(this);
        azmj.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
        return;
        paramView = bizt.a();
        paramView.a = this.app.getCurrentAccountUin();
        paramView.b = this.app.getCurrentNickname();
        bizm.b(this, paramView, -1);
        azmj.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
        return;
        azmj.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
        paramView = aupd.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", paramView));
      return;
    case 2131363870: 
      azmj.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
      paramView = new Intent(this, ShowReactiveActivity.class);
      paramView.putExtra("entry", 1);
      startActivity(paramView);
      return;
    case 2131378249: 
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      String str = "?mode_color=ffffff";
      paramView = str;
      if (azib.b())
      {
        int k = azib.a();
        paramView = str;
        if (k != 0)
        {
          paramView = String.format("%08x", new Object[] { Integer.valueOf(k) }).substring(2);
          paramView = "?mode_color=" + paramView;
        }
      }
      paramView = "https://qun.qq.com/interactive/usersetting" + paramView;
      localIntent.putExtra("url", paramView + "&_wv=3");
      startActivity(localIntent);
      return;
    case 2131362924: 
      AuthorityControlFragment.a(this);
      return;
    case 2131373538: 
      azmj.b(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
      PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
    startActivity(paramView);
    azmj.b(null, "dc00898", "", "", "0X800ACA6", "0X800ACA6", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */