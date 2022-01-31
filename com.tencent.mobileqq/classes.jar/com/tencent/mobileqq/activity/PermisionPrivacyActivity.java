package com.tencent.mobileqq.activity;

import abgq;
import abgr;
import abgs;
import abgt;
import abgv;
import abgw;
import abgx;
import abgy;
import abgz;
import abha;
import abhb;
import abhc;
import aciy;
import ajfi;
import ajfo;
import ajjh;
import ajjj;
import ajjy;
import ajlg;
import ajrm;
import ajtg;
import ajuc;
import ajvm;
import alzw;
import amnw;
import amnx;
import amoa;
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
import apqw;
import aqjk;
import aqjp;
import aroi;
import asca;
import avcn;
import avev;
import awqx;
import badq;
import baig;
import bajr;
import banc;
import bapw;
import bbms;
import bbmv;
import bbmy;
import bfpr;
import bfpy;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;
import vms;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements amnw, View.OnClickListener, aroi
{
  private int jdField_a_of_type_Int = -1;
  private ajfo jdField_a_of_type_Ajfo = new abgs(this);
  ajjh jdField_a_of_type_Ajjh = new abhc(this);
  ajlg jdField_a_of_type_Ajlg = new abgr(this);
  public ajtg a;
  ajuc jdField_a_of_type_Ajuc = new abhb(this);
  private ajvm jdField_a_of_type_Ajvm;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  public TextView a;
  apqw jdField_a_of_type_Apqw = new abha(this);
  aqjp jdField_a_of_type_Aqjp = new abgq(this);
  private avcn jdField_a_of_type_Avcn = new abgv(this);
  private avev jdField_a_of_type_Avev;
  private bbms jdField_a_of_type_Bbms;
  protected bbmv a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  protected BounceScrollView a;
  public FormMultiLineSwitchItem a;
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
  public FormSwitchItem f;
  public FormSwitchItem g;
  public FormSwitchItem h;
  public FormSwitchItem i;
  public FormSwitchItem j;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abgt(this);
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
      aqjk localaqjk = (aqjk)alzw.a().a(445);
      if (localaqjk != null)
      {
        boolean bool = localaqjk.a;
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
    this.f = ((FormSwitchItem)findViewById(2131297352));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297353));
    boolean bool1 = baig.d(this, this.app.getCurrentAccountUin());
    this.f.a().setChecked(bool1);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    Object localObject2;
    Object localObject3;
    if (bool1)
    {
      k = 2131627556;
      ((TextView)localObject1).setText(k);
      this.f.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_Ajtg.d();
      this.jdField_b_of_type_AndroidViewView = findViewById(2131308096);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131307385);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131306031));
      g();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131307400));
      localObject1 = (ajjj)this.app.getManager(51);
      if (!bajr.a(this.app)) {
        break label1237;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      localObject2 = ((ajjj)localObject1).e(this.app.getCurrentAccountUin());
      if (localObject2 != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
        if (((Friends)localObject2).isHideBigClub != 0) {
          break label1232;
        }
        bool1 = true;
        label228:
        ((FormMultiLineSwitchItem)localObject3).setChecked(bool1);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      label245:
      this.g = ((FormSwitchItem)findViewById(2131307415));
      localObject2 = (amoa)this.app.getManager(41);
      if (!((amoa)localObject2).d()) {
        break label1257;
      }
      this.g.setChecked(((amoa)localObject2).c());
      this.g.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      label304:
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131310258));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131310672));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310304));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310300));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.d(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131305011));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296979));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298260));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131305671));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305672));
      localObject1 = ((ajjj)localObject1).c(this.app.getCurrentAccountUin());
      if (!((Card)localObject1).allowClick) {
        break label1269;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label498:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1290;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajjy.a(2131633656));
      label531:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131307389));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      c();
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131307386));
      d();
      localObject2 = (ajfi)this.app.a(2);
      ((ajfi)localObject2).o();
      ((ajfi)localObject2).p();
      this.h = ((FormSwitchItem)findViewById(2131307387));
      localObject3 = this.h;
      if ((this.jdField_a_of_type_Avev == null) || (!this.jdField_a_of_type_Avev.b())) {
        break label1306;
      }
      bool1 = true;
      label637:
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
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297350));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.i = ((FormSwitchItem)super.findViewById(2131304168));
      if (baig.W(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.i.setVisibility(0);
        ThreadManager.post(new PermisionPrivacyActivity.1(this), 5, null, true);
        this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      localObject3 = (FormSimpleItem)findViewById(2131299312);
      if ((localObject3 == null) || (!banc.a().a())) {
        break label1311;
      }
      ((FormSimpleItem)localObject3).setLeftText(getResources().getString(2131625755));
      ((FormSimpleItem)localObject3).a().setMaxWidth(aciy.a(130.0F, getResources()));
      ((FormSimpleItem)localObject3).setOnClickListener(new abgy(this));
      PermisionPrivacyActivity.3 local3 = new PermisionPrivacyActivity.3(this, (FormSimpleItem)localObject3);
      local3.run();
      ((FormSimpleItem)localObject3).setTag("online_status_callback".hashCode(), local3);
      banc.a().a(local3);
      label1015:
      if (AppSetting.c)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131633619));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(ajjy.a(2131642133));
        this.g.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131642128));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131642126));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131628945));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131624479));
        this.h.setContentDescription(ajjy.a(2131642127));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajjy.a(2131642129));
      }
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!a()) {
        break label1326;
      }
      k = 0;
      label1162:
      ((FormSwitchItem)localObject3).setVisibility(k);
      ((ajfi)localObject2).l();
      this.j = ((FormSwitchItem)findViewById(2131310320));
      localObject2 = this.j;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1332;
      }
    }
    label1290:
    label1306:
    label1311:
    label1326:
    label1332:
    for (bool1 = bool2;; bool1 = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool1);
      this.j.setOnCheckedChangeListener(new abgz(this));
      return;
      k = 2131627557;
      break;
      label1232:
      bool1 = false;
      break label228;
      label1237:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      break label245;
      label1257:
      this.g.setVisibility(8);
      break label304;
      label1269:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label498;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajjy.a(2131633657));
      break label531;
      bool1 = false;
      break label637;
      if (localObject3 == null) {
        break label1015;
      }
      ((FormSimpleItem)localObject3).setVisibility(8);
      break label1015;
      k = 8;
      break label1162;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new PermisionPrivacyActivity.13(this, paramBoolean));
  }
  
  private void c()
  {
    ThreadManager.excute(new PermisionPrivacyActivity.5(this), 16, null, true);
  }
  
  private void d()
  {
    if ((this.app != null) && (asca.a(this.app.c())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      awqx.b(this.app, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
      e();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    bbmy.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    if ((isFinishing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    ThreadManager.excute(new PermisionPrivacyActivity.6(this), 16, null, true);
  }
  
  private void f()
  {
    if (badq.g(this)) {
      ((ajrm)this.app.a(13)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject2 = ((ajjj)this.app.getManager(51)).b(this.app.c());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = bapw.a().a(this.app.c(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, vms.a(this.app.getApp(), 47.0F), vms.a(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new abgw(this));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, vms.a(this.app.getApp(), 47.0F), vms.a(this.app.getApp(), 14.0F));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new abgx(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131629515));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Bbms != null)
      {
        this.jdField_a_of_type_Bbms.dismiss();
        this.jdField_a_of_type_Bbms.cancel();
        this.jdField_a_of_type_Bbms = null;
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
    bbmy.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bbms.setCancelable(true);
    this.jdField_a_of_type_Bbms.a(paramString);
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, amnx paramamnx)
  {
    paramamnx.a(paramBoolean);
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
    super.setContentView(2131495505);
    setTitle(2131633654);
    this.jdField_a_of_type_Bbmv = new bbmv(this);
    this.jdField_a_of_type_Avev = ((avev)this.app.getManager(15));
    this.jdField_a_of_type_Ajvm = ((ajvm)this.app.getManager(85));
    if (this.jdField_a_of_type_Avev != null) {
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avcn);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_Ajtg = ((ajtg)this.app.a(20));
    b();
    addObserver(this.jdField_a_of_type_Ajlg);
    addObserver(this.jdField_a_of_type_Ajjh);
    addObserver(this.jdField_a_of_type_Aqjp);
    addObserver(this.jdField_a_of_type_Ajfo);
    addObserver(this.jdField_a_of_type_Ajuc);
    addObserver(this.jdField_a_of_type_Apqw);
    this.app.s();
    this.app.t();
    this.app.c(true);
    this.app.d(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    if (this.jdField_a_of_type_Ajfo != null) {
      removeObserver(this.jdField_a_of_type_Ajfo);
    }
    if (this.jdField_a_of_type_Avev != null) {
      this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avcn);
    }
    removeObserver(this.jdField_a_of_type_Ajlg);
    removeObserver(this.jdField_a_of_type_Ajjh);
    removeObserver(this.jdField_a_of_type_Aqjp);
    removeObserver(this.jdField_a_of_type_Ajuc);
    removeObserver(this.jdField_a_of_type_Apqw);
    if (this.jdField_a_of_type_Bbmv != null)
    {
      this.jdField_a_of_type_Bbmv.b();
      this.jdField_a_of_type_Bbmv = null;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131309894));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        k = this.f.getTop() - vms.d(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, k);
      this.f.setBackgroundResource(2130849001);
      ThreadManager.getUIHandler().postDelayed(new PermisionPrivacyActivity.14(this), 1000L);
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
    case 2131307385: 
    case 2131308096: 
    case 2131307386: 
      do
      {
        return;
        a(this);
        awqx.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
        return;
        paramView = bfpy.a();
        paramView.a = this.app.getCurrentAccountUin();
        paramView.b = this.app.getCurrentNickname();
        bfpr.b(this, paramView, -1);
        awqx.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
        return;
        awqx.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
        paramView = asca.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", paramView));
      return;
    case 2131298260: 
      awqx.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
      paramView = new Intent(this, ShowReactiveActivity.class);
      paramView.putExtra("entry", 1);
      startActivity(paramView);
      return;
    case 2131297350: 
      AuthorityControlFragment.a(this);
      return;
    }
    awqx.b(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
    PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */