package com.tencent.mobileqq.activity;

import Override;
import aely;
import aelz;
import aema;
import aemb;
import aemc;
import aemd;
import aeme;
import aemf;
import aemg;
import aemh;
import aemi;
import aemj;
import aemk;
import ajcs;
import ajct;
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
import anri;
import anvi;
import anvk;
import anvx;
import anxj;
import aocy;
import aoep;
import aofu;
import aohe;
import aqxe;
import auzh;
import avre;
import avrj;
import awza;
import axmv;
import bbtg;
import bbvn;
import bdfk;
import bdla;
import bfya;
import bhhr;
import bhmx;
import bhpw;
import bisl;
import biso;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.os.MqqHandler;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements ajcs, View.OnClickListener, awza
{
  private int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  public TextView a;
  anvi jdField_a_of_type_Anvi = new aelz(this);
  anxj jdField_a_of_type_Anxj = new aemb(this);
  public aoep a;
  aofu jdField_a_of_type_Aofu = new aemk(this);
  private aohe jdField_a_of_type_Aohe;
  auzh jdField_a_of_type_Auzh = new aemj(this);
  avrj jdField_a_of_type_Avrj = new aema(this);
  private bbtg jdField_a_of_type_Bbtg = new aeme(this);
  private bbvn jdField_a_of_type_Bbvn;
  private bisl jdField_a_of_type_Bisl;
  protected biso a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aemc(this);
  protected BounceScrollView a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
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
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aemd(this);
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
      avre localavre = (avre)aqxe.a().a(445);
      if (localavre != null)
      {
        boolean bool = localavre.jdField_a_of_type_Boolean;
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
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363094));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363095));
    boolean bool1 = bhhr.c(this, this.app.getCurrentAccountUin());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool1);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    label310:
    Object localObject2;
    label370:
    Object localObject3;
    if (bool1)
    {
      k = 2131692960;
      ((TextView)localObject1).setText(k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_Aoep.d();
      this.jdField_c_of_type_AndroidViewView = findViewById(2131375184);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131374431);
      bdla.b(null, "dc00898", "", "", "0X800B1B1", "0X800B1B1", 0, 0, "", "", "", "");
      this.jdField_b_of_type_AndroidViewView = findViewById(2131374429);
      bdla.b(null, "dc00898", "", "", "0X800B1AF", "0X800B1AF", 0, 0, "", "", "", "");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372908));
      g();
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374447));
      localObject1 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!VipUtils.a(this.app)) {
        break label1467;
      }
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131698855));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aely(this));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374460));
      localObject2 = (ContactSyncManager)this.app.getManager(QQManagerFactory.MGR_SYNC_CONTACT);
      if (!((ContactSyncManager)localObject2).b()) {
        break label1487;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((ContactSyncManager)localObject2).a());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131377556));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131378028));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377649));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getVisibilityForNetWorkStatus(false));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377645));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getVisibilityForInputStatus(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371833));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362663));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364214));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131379485));
      localObject2 = (bfya)aqxe.a().a(696);
      if (localObject2 != null) {
        this.jdField_a_of_type_Boolean = ((bfya)localObject2).a();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label1499;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719582));
      bdla.b(null, "dc00898", "", "", "0X800B60A", "0X800B60A", 0, 0, "", "0", "0", "");
      label594:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372548));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372549));
      localObject1 = ((anvk)localObject1).c(this.app.getCurrentAccountUin());
      if (!((Card)localObject1).allowClick) {
        break label1516;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label660:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1537;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anvx.a(2131698837));
      label693:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374435));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      c();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374436));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      bdla.b(null, "dc00898", "", "", "0X800ACA5", "0X800ACA5", 0, 0, "", "0", "0", "");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374432));
      d();
      localObject2 = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      ((anri)localObject2).n();
      ((anri)localObject2).o();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374433));
      localObject3 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_a_of_type_Bbvn == null) || (!this.jdField_a_of_type_Bbvn.b())) {
        break label1553;
      }
      bool1 = true;
      label856:
      ((FormSwitchItem)localObject3).setChecked(bool1);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.getLocVisibilityForStatus());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.getLocZanAllowedForStatus());
      bool1 = this.app.getLocZanAllowedForPeople();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool1);
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
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363092));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.i = ((FormSwitchItem)super.findViewById(2131370824));
      if (bhhr.X(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.i.setVisibility(0);
        ThreadManager.post(new PermisionPrivacyActivity.2(this), 5, null, true);
        this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      localObject3 = (FormSimpleItem)findViewById(2131365362);
      if ((localObject3 == null) || (!bhmx.a().a())) {
        break label1558;
      }
      ((FormSimpleItem)localObject3).setLeftText(getResources().getString(2131691288));
      ((FormSimpleItem)localObject3).a().setMaxWidth(AIOUtils.dp2px(130.0F, getResources()));
      ((FormSimpleItem)localObject3).setOnClickListener(new aemh(this));
      PermisionPrivacyActivity.4 local4 = new PermisionPrivacyActivity.4(this, (FormSimpleItem)localObject3);
      local4.run();
      ((FormSimpleItem)localObject3).setTag("online_status_callback".hashCode(), local4);
      bhmx.a().a(local4);
      label1250:
      if (AppSetting.c)
      {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131698803));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anvx.a(2131707378));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707373));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707371));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131694252));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131690028));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707372));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131707374));
      }
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!a()) {
        break label1573;
      }
      k = 0;
      label1397:
      ((FormSwitchItem)localObject3).setVisibility(k);
      ((anri)localObject2).j();
      this.j = ((FormSwitchItem)findViewById(2131377665));
      localObject2 = this.j;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1579;
      }
    }
    label1537:
    label1553:
    label1558:
    label1573:
    label1579:
    for (bool1 = bool2;; bool1 = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool1);
      this.j.setOnCheckedChangeListener(new aemi(this));
      return;
      k = 2131692961;
      break;
      label1467:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      break label310;
      label1487:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label370;
      label1499:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719583));
      break label594;
      label1516:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label660;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anvx.a(2131698838));
      break label693;
      bool1 = false;
      break label856;
      if (localObject3 == null) {
        break label1250;
      }
      ((FormSimpleItem)localObject3).setVisibility(8);
      break label1250;
      k = 8;
      break label1397;
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
    if ((this.app != null) && (axmv.a(this.app.getCurrentUin())))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      bdla.b(this.app, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
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
    if (NetworkUtil.isNetworkAvailable(this)) {
      ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject2 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.app.getCurrentUin());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = bhpw.a().a(this.app.getCurrentUin(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, UIUtils.dip2px(this.app.getApp(), 47.0F), UIUtils.dip2px(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new aemf(this));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, UIUtils.dip2px(this.app.getApp(), 47.0F), UIUtils.dip2px(this.app.getApp(), 14.0F));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new aemg(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131694692));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bisl != null)
      {
        this.jdField_a_of_type_Bisl.dismiss();
        this.jdField_a_of_type_Bisl.cancel();
        this.jdField_a_of_type_Bisl = null;
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
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bisl.setCancelable(true);
    this.jdField_a_of_type_Bisl.a(paramString);
    this.jdField_a_of_type_Bisl.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, ajct paramajct)
  {
    paramajct.a(paramBoolean);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
    super.setContentView(2131561508);
    setTitle(2131698835);
    this.jdField_a_of_type_Biso = new biso(this);
    this.jdField_a_of_type_Bbvn = ((bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_Aohe = ((aohe)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    if (this.jdField_a_of_type_Bbvn != null) {
      this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Bbtg);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_Aoep = ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    b();
    addObserver(this.jdField_a_of_type_Anxj);
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_Avrj);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Aofu);
    addObserver(this.jdField_a_of_type_Auzh);
    this.app.getVisibilitySwitches();
    this.app.getZanSwitches();
    this.app.getVisibilityForNetWorkStatus(true);
    this.app.getVisibilityForInputStatus(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_Bbvn != null) {
      this.jdField_a_of_type_Bbvn.b(this.jdField_a_of_type_Bbtg);
    }
    removeObserver(this.jdField_a_of_type_Anxj);
    removeObserver(this.jdField_a_of_type_Anvi);
    removeObserver(this.jdField_a_of_type_Avrj);
    removeObserver(this.jdField_a_of_type_Aofu);
    removeObserver(this.jdField_a_of_type_Auzh);
    if (this.jdField_a_of_type_Biso != null)
    {
      this.jdField_a_of_type_Biso.b();
      this.jdField_a_of_type_Biso = null;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377135));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        k = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - UIUtils.getWindowScreenHeight(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130850372);
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
      bdla.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X800B1B2", "0X800B1B2", 0, 0, "", "", "", "");
      continue;
      b(this);
      bdla.b(null, "dc00898", "", "", "0X800B1B0", "0X800B1B0", 0, 0, "", "", "", "");
      continue;
      Object localObject1 = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject1).qzone_uin = this.app.getCurrentAccountUin();
      ((QZoneHelper.UserInfo)localObject1).nickname = this.app.getCurrentNickname();
      QZoneHelper.forwardToPermissionSetting(this, (QZoneHelper.UserInfo)localObject1, -1);
      bdla.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      continue;
      bdla.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
      localObject1 = axmv.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + (String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject1));
        continue;
        bdla.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
        localObject1 = new Intent(this, ShowReactiveActivity.class);
        ((Intent)localObject1).putExtra("entry", 1);
        startActivity((Intent)localObject1);
        continue;
        if (this.jdField_a_of_type_Boolean) {
          bdla.b(null, "dc00898", "", "", "0X800B60B", "0X800B60B", 0, 0, "", "0", "0", "");
        }
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        Object localObject2 = "?mode_color=ffffff";
        localObject1 = localObject2;
        if (bdfk.b())
        {
          int k = bdfk.a();
          localObject1 = localObject2;
          if (k != 0)
          {
            localObject1 = String.format("%08x", new Object[] { Integer.valueOf(k) }).substring(2);
            localObject1 = "?mode_color=" + (String)localObject1;
          }
        }
        localObject1 = "https://qun.qq.com/interactive/usersetting" + (String)localObject1;
        localObject2 = new StringBuilder().append((String)localObject1).append("&showLuckyWord=");
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          localObject1 = (String)localObject1;
          localIntent.putExtra("url", (String)localObject1 + "&_wv=3");
          startActivity(localIntent);
          break;
        }
        AuthorityControlFragment.a(this);
        continue;
        bdla.b(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
        PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
        continue;
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        startActivity((Intent)localObject1);
        bdla.b(null, "dc00898", "", "", "0X800ACA6", "0X800ACA6", 0, 0, "", "0", "0", "");
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