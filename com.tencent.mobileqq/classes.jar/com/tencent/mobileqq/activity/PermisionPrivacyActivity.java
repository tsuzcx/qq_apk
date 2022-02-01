package com.tencent.mobileqq.activity;

import Override;
import afcb;
import afcc;
import afcd;
import afce;
import afcf;
import afcg;
import afch;
import afci;
import afcj;
import afck;
import afcl;
import afcm;
import afcn;
import agej;
import ajnk;
import ajnl;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anum;
import anuw;
import anyu;
import anyw;
import anzj;
import aoau;
import aogu;
import aoip;
import aojs;
import aold;
import aran;
import avhb;
import avyj;
import avyo;
import axfs;
import axtm;
import bbsw;
import bbvd;
import bdgb;
import bdll;
import bhnv;
import bhsi;
import bhxt;
import bias;
import bjbs;
import bjbv;
import bmtd;
import bmtk;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;
import zps;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements ajnk, View.OnClickListener, axfs
{
  private int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  public TextView a;
  private anuw jdField_a_of_type_Anuw = new afcf(this);
  anyu jdField_a_of_type_Anyu = new afcc(this);
  aoau jdField_a_of_type_Aoau = new afce(this);
  public aoip a;
  aojs jdField_a_of_type_Aojs = new afcn(this);
  private aold jdField_a_of_type_Aold;
  avhb jdField_a_of_type_Avhb = new afcm(this);
  avyo jdField_a_of_type_Avyo = new afcd(this);
  private bbsw jdField_a_of_type_Bbsw = new afch(this);
  private bbvd jdField_a_of_type_Bbvd;
  private bjbs jdField_a_of_type_Bjbs;
  protected bjbv a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  protected BounceScrollView a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  public FormSwitchItem b;
  View jdField_c_of_type_AndroidViewView;
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
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new afcg(this);
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "gotoFriendSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {}
    while (!QQBrowserActivity.a(1000L)) {
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
      avyj localavyj = (avyj)aran.a().a(445);
      if (localavyj != null)
      {
        boolean bool = localavyj.a;
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
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363060));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363061));
    boolean bool = bhsi.c(this, this.app.getCurrentAccountUin());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    label304:
    Object localObject2;
    label363:
    Object localObject3;
    if (bool)
    {
      k = 2131692803;
      ((TextView)localObject1).setText(k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_Aoip.d();
      this.jdField_c_of_type_AndroidViewView = findViewById(2131375178);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131374428);
      bdll.b(null, "dc00898", "", "", "0X800B1B1", "0X800B1B1", 0, 0, "", "", "", "");
      this.jdField_b_of_type_AndroidViewView = findViewById(2131374426);
      bdll.b(null, "dc00898", "", "", "0X800B1AF", "0X800B1AF", 0, 0, "", "", "", "");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372747));
      g();
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374444));
      localObject1 = (anyw)this.app.getManager(51);
      if (!VipUtils.a(this.app)) {
        break label1389;
      }
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131698389));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afcb(this));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374457));
      localObject2 = (ContactSyncManager)this.app.getManager(41);
      if (!((ContactSyncManager)localObject2).b()) {
        break label1409;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((ContactSyncManager)localObject2).a());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131377515));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131377978));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377608));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377604));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.d(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371677));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362645));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364118));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131379321));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372391));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372392));
      localObject1 = ((anyw)localObject1).c(this.app.getCurrentAccountUin());
      if (!((Card)localObject1).allowClick) {
        break label1421;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label568:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1442;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anzj.a(2131698371));
      label599:
      if (!((Card)localObject1).troopHonorSwitch) {
        break label1458;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anzj.a(2131698371));
      label619:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374432));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      c();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374433));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      bdll.b(null, "dc00898", "", "", "0X800ACA5", "0X800ACA5", 0, 0, "", "0", "0", "");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374429));
      d();
      localObject2 = (anum)this.app.a(2);
      ((anum)localObject2).n();
      ((anum)localObject2).o();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374430));
      localObject3 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_a_of_type_Bbvd == null) || (!this.jdField_a_of_type_Bbvd.b())) {
        break label1474;
      }
      bool = true;
      label780:
      ((FormSwitchItem)localObject3).setChecked(bool);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.t());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.v());
      bool = this.app.u();
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
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363058));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.i = ((FormSwitchItem)super.findViewById(2131370673));
      if (bhsi.W(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.i.setVisibility(0);
        ThreadManager.post(new PermisionPrivacyActivity.2(this), 5, null, true);
        this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      localObject3 = (FormSimpleItem)findViewById(2131365244);
      if ((localObject3 == null) || (!bhxt.a().a())) {
        break label1479;
      }
      ((FormSimpleItem)localObject3).setLeftText(getResources().getString(2131691164));
      ((FormSimpleItem)localObject3).a().setMaxWidth(agej.a(130.0F, getResources()));
      ((FormSimpleItem)localObject3).setOnClickListener(new afck(this));
      PermisionPrivacyActivity.4 local4 = new PermisionPrivacyActivity.4(this, (FormSimpleItem)localObject3);
      local4.run();
      ((FormSimpleItem)localObject3).setTag("online_status_callback".hashCode(), local4);
      bhxt.a().a(local4);
      label1173:
      if (AppSetting.c)
      {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131698337));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131706799));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706794));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706792));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131693962));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131689981));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706793));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131706795));
      }
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!a()) {
        break label1494;
      }
      k = 0;
      label1320:
      ((FormSwitchItem)localObject3).setVisibility(k);
      ((anum)localObject2).j();
      this.j = ((FormSwitchItem)findViewById(2131377624));
      localObject2 = this.j;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1500;
      }
    }
    label1409:
    label1421:
    label1442:
    label1458:
    label1474:
    label1479:
    label1494:
    label1500:
    for (bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool);
      this.j.setOnCheckedChangeListener(new afcl(this));
      return;
      k = 2131692804;
      break;
      label1389:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      break label304;
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label363;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label568;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anzj.a(2131698372));
      break label599;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anzj.a(2131698372));
      break label619;
      bool = false;
      break label780;
      if (localObject3 == null) {
        break label1173;
      }
      ((FormSimpleItem)localObject3).setVisibility(8);
      break label1173;
      k = 8;
      break label1320;
    }
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "gotoFriendFindMeSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {}
    while (!QQBrowserActivity.a(1000L)) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendshipauth/find?_wv=3&_bid=173"));
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
    if ((this.app != null) && (axtm.a(this.app.c())))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      bdll.b(this.app, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
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
    if (bhnv.g(this)) {
      ((aogu)this.app.a(13)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject2 = ((anyw)this.app.getManager(51)).b(this.app.c());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = bias.a().a(this.app.c(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, zps.a(this.app.getApp(), 47.0F), zps.a(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new afci(this));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, zps.a(this.app.getApp(), 47.0F), zps.a(this.app.getApp(), 14.0F));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new afcj(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131694377));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs != null)
      {
        this.jdField_a_of_type_Bjbs.dismiss();
        this.jdField_a_of_type_Bjbs.cancel();
        this.jdField_a_of_type_Bjbs = null;
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
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bjbs.setCancelable(true);
    this.jdField_a_of_type_Bjbs.a(paramString);
    this.jdField_a_of_type_Bjbs.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, ajnl paramajnl)
  {
    paramajnl.a(paramBoolean);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
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
    super.setContentView(2131561568);
    setTitle(2131698369);
    this.jdField_a_of_type_Bjbv = new bjbv(this);
    this.jdField_a_of_type_Bbvd = ((bbvd)this.app.getManager(15));
    this.jdField_a_of_type_Aold = ((aold)this.app.getManager(85));
    if (this.jdField_a_of_type_Bbvd != null) {
      this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Bbsw);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_Aoip = ((aoip)this.app.a(20));
    b();
    addObserver(this.jdField_a_of_type_Aoau);
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Avyo);
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Aojs);
    addObserver(this.jdField_a_of_type_Avhb);
    this.app.u();
    this.app.v();
    this.app.c(true);
    this.app.d(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    if (this.jdField_a_of_type_Anuw != null) {
      removeObserver(this.jdField_a_of_type_Anuw);
    }
    if (this.jdField_a_of_type_Bbvd != null) {
      this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Bbsw);
    }
    removeObserver(this.jdField_a_of_type_Aoau);
    removeObserver(this.jdField_a_of_type_Anyu);
    removeObserver(this.jdField_a_of_type_Avyo);
    removeObserver(this.jdField_a_of_type_Aojs);
    removeObserver(this.jdField_a_of_type_Avhb);
    if (this.jdField_a_of_type_Bjbv != null)
    {
      this.jdField_a_of_type_Bjbv.b();
      this.jdField_a_of_type_Bjbv = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377111));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        k = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - zps.d(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130850347);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this);
      bdll.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X800B1B2", "0X800B1B2", 0, 0, "", "", "", "");
      continue;
      b(this);
      bdll.b(null, "dc00898", "", "", "0X800B1B0", "0X800B1B0", 0, 0, "", "", "", "");
      continue;
      Object localObject = bmtk.a();
      ((bmtk)localObject).a = this.app.getCurrentAccountUin();
      ((bmtk)localObject).b = this.app.getCurrentNickname();
      bmtd.b(this, (bmtk)localObject, -1);
      bdll.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      continue;
      bdll.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
      localObject = axtm.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject));
        continue;
        bdll.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
        localObject = new Intent(this, ShowReactiveActivity.class);
        ((Intent)localObject).putExtra("entry", 1);
        startActivity((Intent)localObject);
        continue;
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        String str = "?mode_color=ffffff";
        localObject = str;
        if (bdgb.b())
        {
          int k = bdgb.a();
          localObject = str;
          if (k != 0)
          {
            localObject = String.format("%08x", new Object[] { Integer.valueOf(k) }).substring(2);
            localObject = "?mode_color=" + (String)localObject;
          }
        }
        localObject = "https://qun.qq.com/interactive/usersetting" + (String)localObject;
        localIntent.putExtra("url", (String)localObject + "&_wv=3");
        startActivity(localIntent);
        continue;
        AuthorityControlFragment.a(this);
        continue;
        bdll.b(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
        PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        startActivity((Intent)localObject);
        bdll.b(null, "dc00898", "", "", "0X800ACA6", "0X800ACA6", 0, 0, "", "0", "0", "");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */