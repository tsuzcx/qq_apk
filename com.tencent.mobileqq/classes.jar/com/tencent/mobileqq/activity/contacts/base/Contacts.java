package com.tencent.mobileqq.activity.contacts.base;

import aixn;
import aizi;
import aizo;
import ajiy;
import ajjc;
import ajjd;
import ajjf;
import ajjr;
import ajlq;
import ajoi;
import akah;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anun;
import anvx;
import ayqy;
import bbbq;
import bdfk;
import bdla;
import bhdz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class Contacts
  extends anun
  implements aizo, akah, Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aixn jdField_a_of_type_Aixn = new ajjd(this);
  private ajjf jdField_a_of_type_Ajjf;
  private ajjr jdField_a_of_type_Ajjr;
  private ajlq jdField_a_of_type_Ajlq;
  private ajoi jdField_a_of_type_Ajoi;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayqy jdField_a_of_type_Ayqy = new ajjc(this);
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private RelativeLayout c;
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", fromResume = " + paramBoolean);
    }
    List localList;
    ajlq localajlq;
    if (this.jdField_a_of_type_Ajlq != null)
    {
      localList = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a();
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", realcount = " + localList.size() + ", fromResume = " + paramBoolean);
      }
      localajlq = this.jdField_a_of_type_Ajlq;
      if (paramBoolean) {
        break label174;
      }
    }
    label174:
    for (boolean bool = true;; bool = false)
    {
      localajlq.a(localList, bool, paramBoolean);
      if ((paramInt > 0) && (this.jdField_a_of_type_Ajjf != null)) {
        this.jdField_a_of_type_Ajjf.g();
      }
      if (this.jdField_a_of_type_Ajoi != null) {
        this.jdField_a_of_type_Ajoi.d();
      }
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)bhdz.a(a(), 5.0F));
    this.jdField_a_of_type_Ajjf.b();
    this.jdField_a_of_type_Ajjf.a(this.jdField_a_of_type_Int);
    m();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365001));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365106));
    d();
    l();
  }
  
  private void l()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365093);
    this.jdField_a_of_type_Ajjr = new ajjr(a(), 2, localView);
    this.c = ((RelativeLayout)localView.findViewById(2131371887));
    this.jdField_a_of_type_Ajlq = new ajlq(this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_Ajoi = new ajoi(localView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    r();
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131365105));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376890));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369245));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131689550));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).b(21).f(10).a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369278));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379099));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378030));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayqy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aixn);
    ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayqy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aixn);
    ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(this);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void r()
  {
    int k = 0;
    boolean bool = bdfk.b();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365093);
    int j;
    if (localView != null)
    {
      i = AIOUtils.dp2px(12.0F, a());
      if (this.c != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
        if (!bool) {
          break label181;
        }
        j = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      Object localObject = localView.findViewById(2131377827);
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (bool) {
          i = 0;
        }
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label186;
      }
      i = 2130844927;
      label122:
      localObject = localView.findViewById(2131365761);
      ((View)localObject).setBackgroundResource(i);
      if (!bool) {
        break label193;
      }
      j = 0;
      label145:
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131365762);
      localView.setBackgroundResource(i);
      if (!bool) {
        break label199;
      }
    }
    label181:
    label186:
    label193:
    label199:
    for (int i = k;; i = 8)
    {
      localView.setVisibility(i);
      return;
      j = i;
      break;
      i = 2130844926;
      break label122;
      j = 8;
      break label145;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131558978, null);
    this.jdField_a_of_type_Ajjf = new ajjf(a());
    this.jdField_a_of_type_Ajjf.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public String a()
  {
    return a().getString(2131693747);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        C();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.exit(false);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 1000000) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("BindMsgConstant", 2, "bind phone suc requestCode: " + paramInt1 + ", src: " + 12);
      return;
    } while (paramInt1 != 99999);
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void aa_()
  {
    super.aa_();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Ajjf == null) {
      return;
    }
    this.jdField_a_of_type_Ajjf.h();
  }
  
  public void ae_()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void af_() {}
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      n();
      this.jdField_a_of_type_Ajjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      d();
      this.jdField_a_of_type_Ajlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
      if (this.jdField_a_of_type_Ajjr != null) {
        this.jdField_a_of_type_Ajjr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    } while (this.jdField_a_of_type_Ajoi == null);
    this.jdField_a_of_type_Ajoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    d();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      r();
      ajiy.a.clear();
      return;
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850109);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167023));
    }
  }
  
  void d()
  {
    int i = 2130838912;
    if (this.jdField_a_of_type_Ajjf != null) {
      this.jdField_a_of_type_Ajjf.i();
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "setThemeDiyBgContacts mBgImageView == null");
      }
    }
    View localView;
    do
    {
      return;
      ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidWidgetImageView, 3, 2130838912, "-contacts-");
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378335);
    } while (localView == null);
    if (ThemeUtil.isDefaultTheme()) {
      i = 2130839458;
    }
    localView.setBackgroundResource(i);
  }
  
  public void e()
  {
    super.e();
    j();
    n();
    ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.jdField_a_of_type_Ajjf.b(paramBoolean);
    a(((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d(), true);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      String str = a(2131693747);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      a().setTitle(a(2131693747));
    }
    if (this.jdField_a_of_type_Ajjr != null) {
      this.jdField_a_of_type_Ajjr.a();
    }
    q();
    ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ajjf.j();
    }
    if (this.jdField_a_of_type_Ajoi != null) {
      this.jdField_a_of_type_Ajoi.c();
    }
  }
  
  public void g()
  {
    ApngImage.pauseByTag(3);
    super.g();
    this.jdField_a_of_type_Ajjf.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        e(true);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9529, 300L);
      return true;
    } while (this.jdField_a_of_type_Ajjf == null);
    this.jdField_a_of_type_Ajjf.l();
    return true;
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ajjr != null) {
      this.jdField_a_of_type_Ajjr.b();
    }
    this.jdField_a_of_type_Ajjf.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ajoi != null) {
      this.jdField_a_of_type_Ajoi.b();
    }
    o();
  }
  
  public void k()
  {
    o();
    if (this.jdField_a_of_type_Ajjf != null) {
      this.jdField_a_of_type_Ajjf.e();
    }
  }
  
  public void k_(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(a(), AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 1);
      localIntent.putExtra("EntranceId", 3);
      a(localIntent);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf(101200));
      }
      catch (Exception localException) {}
      continue;
      this.jdField_a_of_type_Ajlq.a();
      NewFriendActivity.a(a(), null, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts
 * JD-Core Version:    0.7.0.1
 */