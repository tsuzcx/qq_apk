package com.tencent.mobileqq.activity;

import abqm;
import abqn;
import abqo;
import abqp;
import abqq;
import abqr;
import abqs;
import abqt;
import abqu;
import abqv;
import abqw;
import abqx;
import abqy;
import actj;
import ajti;
import ajto;
import ajxj;
import ajxl;
import ajya;
import ajzk;
import akfv;
import akhp;
import akil;
import akjv;
import ampl;
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
import anei;
import anej;
import anem;
import aqkn;
import ardr;
import ardw;
import asko;
import asyg;
import awci;
import aweq;
import axqy;
import bbfj;
import bbkb;
import bbpm;
import bbsh;
import bcqf;
import bcqi;
import bcql;
import bgyp;
import bgyw;
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
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;
import vzl;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, anei, asko
{
  private int jdField_a_of_type_Int = -1;
  private ajto jdField_a_of_type_Ajto = new abqq(this);
  ajxj jdField_a_of_type_Ajxj = new abqn(this);
  ajzk jdField_a_of_type_Ajzk = new abqp(this);
  public akhp a;
  akil jdField_a_of_type_Akil = new abqy(this);
  private akjv jdField_a_of_type_Akjv;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  public TextView a;
  aqkn jdField_a_of_type_Aqkn = new abqx(this);
  ardw jdField_a_of_type_Ardw = new abqo(this);
  private awci jdField_a_of_type_Awci = new abqs(this);
  private aweq jdField_a_of_type_Aweq;
  private bcqf jdField_a_of_type_Bcqf;
  protected bcqi a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  protected BounceScrollView a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  private FormSimpleItem d;
  public FormSwitchItem d;
  private FormSimpleItem e;
  public FormSwitchItem e;
  private FormSimpleItem f;
  public FormSwitchItem f;
  public FormSwitchItem g;
  public FormSwitchItem h;
  public FormSwitchItem i;
  public FormSwitchItem j;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abqr(this);
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
      ardr localardr = (ardr)ampl.a().a(445);
      if (localardr != null)
      {
        boolean bool = localardr.a;
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
    boolean bool2 = true;
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362891));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362892));
    boolean bool1 = bbkb.d(this, this.app.getCurrentAccountUin());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool1);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    label231:
    Object localObject2;
    label290:
    label484:
    Object localObject3;
    if (bool1)
    {
      k = 2131693197;
      ((TextView)localObject1).setText(k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_Akhp.d();
      this.jdField_b_of_type_AndroidViewView = findViewById(2131373816);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131373098);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371728));
      g();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373113));
      localObject1 = (ajxl)this.app.getManager(51);
      if (!VipUtils.a(this.app)) {
        break label1218;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131699454));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abqm(this));
      this.g = ((FormSwitchItem)findViewById(2131373128));
      localObject2 = (anem)this.app.getManager(41);
      if (!((anem)localObject2).d()) {
        break label1238;
      }
      this.g.setChecked(((anem)localObject2).c());
      this.g.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131376027));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131376467));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376098));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131376094));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.d(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370677));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362519));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363814));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371367));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371368));
      localObject1 = ((ajxl)localObject1).c(this.app.getCurrentAccountUin());
      if (!((Card)localObject1).allowClick) {
        break label1250;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1271;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajya.a(2131699436));
      label517:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373102));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      c();
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373099));
      d();
      localObject2 = (ajti)this.app.a(2);
      ((ajti)localObject2).o();
      ((ajti)localObject2).p();
      this.h = ((FormSwitchItem)findViewById(2131373100));
      localObject3 = this.h;
      if ((this.jdField_a_of_type_Aweq == null) || (!this.jdField_a_of_type_Aweq.b())) {
        break label1287;
      }
      bool1 = true;
      label623:
      ((FormSwitchItem)localObject3).setChecked(bool1);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.n());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.p());
      bool1 = this.app.o();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool1);
      a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), ((Card)localObject1).strangerInviteMeGroupOpen);
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.h.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362889));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.i = ((FormSwitchItem)super.findViewById(2131369845));
      if (bbkb.W(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.i.setVisibility(0);
        ThreadManager.post(new PermisionPrivacyActivity.2(this), 5, null, true);
        this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      localObject3 = (FormSimpleItem)findViewById(2131364875);
      if ((localObject3 == null) || (!bbpm.a().a())) {
        break label1292;
      }
      ((FormSimpleItem)localObject3).setLeftText(getResources().getString(2131691331));
      ((FormSimpleItem)localObject3).a().setMaxWidth(actj.a(130.0F, getResources()));
      ((FormSimpleItem)localObject3).setOnClickListener(new abqv(this));
      PermisionPrivacyActivity.4 local4 = new PermisionPrivacyActivity.4(this, (FormSimpleItem)localObject3);
      local4.run();
      ((FormSimpleItem)localObject3).setTag("online_status_callback".hashCode(), local4);
      bbpm.a().a(local4);
      label1001:
      if (AppSetting.d)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131699397));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(ajya.a(2131707929));
        this.g.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131707924));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131707922));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131694607));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131690033));
        this.h.setContentDescription(ajya.a(2131707923));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131707925));
      }
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!a()) {
        break label1307;
      }
      k = 0;
      label1148:
      ((FormSwitchItem)localObject3).setVisibility(k);
      ((ajti)localObject2).l();
      this.j = ((FormSwitchItem)findViewById(2131376114));
      localObject2 = this.j;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1313;
      }
    }
    label1287:
    label1292:
    label1307:
    label1313:
    for (bool1 = bool2;; bool1 = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool1);
      this.j.setOnCheckedChangeListener(new abqw(this));
      return;
      k = 2131693198;
      break;
      label1218:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      break label231;
      label1238:
      this.g.setVisibility(8);
      break label290;
      label1250:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label484;
      label1271:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajya.a(2131699437));
      break label517;
      bool1 = false;
      break label623;
      if (localObject3 == null) {
        break label1001;
      }
      ((FormSimpleItem)localObject3).setVisibility(8);
      break label1001;
      k = 8;
      break label1148;
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
    if ((this.app != null) && (asyg.a(this.app.c())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      axqy.b(this.app, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
      e();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    bcql.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    if ((isFinishing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    ThreadManager.excute(new PermisionPrivacyActivity.7(this), 16, null, true);
  }
  
  private void f()
  {
    if (bbfj.g(this)) {
      ((akfv)this.app.a(13)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject2 = ((ajxl)this.app.getManager(51)).b(this.app.c());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = bbsh.a().a(this.app.c(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, vzl.a(this.app.getApp(), 47.0F), vzl.a(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new abqt(this));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, vzl.a(this.app.getApp(), 47.0F), vzl.a(this.app.getApp(), 14.0F));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abqu(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131695197));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bcqf != null)
      {
        this.jdField_a_of_type_Bcqf.dismiss();
        this.jdField_a_of_type_Bcqf.cancel();
        this.jdField_a_of_type_Bcqf = null;
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
    bcql.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bcqf.setCancelable(true);
    this.jdField_a_of_type_Bcqf.a(paramString);
    this.jdField_a_of_type_Bcqf.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, anej paramanej)
  {
    paramanej.a(paramBoolean);
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
    super.setContentView(2131561092);
    setTitle(2131699434);
    this.jdField_a_of_type_Bcqi = new bcqi(this);
    this.jdField_a_of_type_Aweq = ((aweq)this.app.getManager(15));
    this.jdField_a_of_type_Akjv = ((akjv)this.app.getManager(85));
    if (this.jdField_a_of_type_Aweq != null) {
      this.jdField_a_of_type_Aweq.a(this.jdField_a_of_type_Awci);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_Akhp = ((akhp)this.app.a(20));
    b();
    addObserver(this.jdField_a_of_type_Ajzk);
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Ardw);
    addObserver(this.jdField_a_of_type_Ajto);
    addObserver(this.jdField_a_of_type_Akil);
    addObserver(this.jdField_a_of_type_Aqkn);
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
    if (this.jdField_a_of_type_Ajto != null) {
      removeObserver(this.jdField_a_of_type_Ajto);
    }
    if (this.jdField_a_of_type_Aweq != null) {
      this.jdField_a_of_type_Aweq.b(this.jdField_a_of_type_Awci);
    }
    removeObserver(this.jdField_a_of_type_Ajzk);
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Ardw);
    removeObserver(this.jdField_a_of_type_Akil);
    removeObserver(this.jdField_a_of_type_Aqkn);
    if (this.jdField_a_of_type_Bcqi != null)
    {
      this.jdField_a_of_type_Bcqi.b();
      this.jdField_a_of_type_Bcqi = null;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131375655));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        k = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - vzl.d(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130849245);
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
    case 2131373098: 
    case 2131373816: 
    case 2131373099: 
      do
      {
        return;
        a(this);
        axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
        return;
        paramView = bgyw.a();
        paramView.a = this.app.getCurrentAccountUin();
        paramView.b = this.app.getCurrentNickname();
        bgyp.b(this, paramView, -1);
        axqy.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
        return;
        axqy.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
        paramView = asyg.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", paramView));
      return;
    case 2131363814: 
      axqy.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
      paramView = new Intent(this, ShowReactiveActivity.class);
      paramView.putExtra("entry", 1);
      startActivity(paramView);
      return;
    case 2131362889: 
      AuthorityControlFragment.a(this);
      return;
    }
    axqy.b(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
    PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */