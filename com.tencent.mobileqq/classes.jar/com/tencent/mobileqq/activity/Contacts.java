package com.tencent.mobileqq.activity;

import acmp;
import acmq;
import aekt;
import ahml;
import ahmr;
import ahnt;
import aiaf;
import akhx;
import alny;
import alpo;
import altc;
import alti;
import ambt;
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
import avqr;
import axho;
import azib;
import azmj;
import bdcq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class Contacts
  extends alny
  implements aiaf, alti, Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ahml jdField_a_of_type_Ahml;
  private ahmr jdField_a_of_type_Ahmr;
  private ahnt jdField_a_of_type_Ahnt;
  private ambt jdField_a_of_type_Ambt = new acmq(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avqr jdField_a_of_type_Avqr = new acmp(this);
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
    ahml localahml;
    if (this.jdField_a_of_type_Ahml != null)
    {
      localList = ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", realcount = " + localList.size() + ", fromResume = " + paramBoolean);
      }
      localahml = this.jdField_a_of_type_Ahml;
      if (paramBoolean) {
        break label159;
      }
    }
    label159:
    for (boolean bool = true;; bool = false)
    {
      localahml.a(localList, bool, paramBoolean);
      if ((paramInt > 0) && (this.jdField_a_of_type_Ahnt != null)) {
        this.jdField_a_of_type_Ahnt.g();
      }
      return;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)bdcq.a(a(), 5.0F));
    this.jdField_a_of_type_Ahnt.b();
    this.jdField_a_of_type_Ahnt.a(this.jdField_a_of_type_Int);
    q();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364620));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364721));
    l();
    o();
  }
  
  private void o()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364708);
    this.jdField_a_of_type_Ahmr = new ahmr(a(), 2, localView);
    this.c = ((RelativeLayout)localView.findViewById(2131371043));
    this.jdField_a_of_type_Ahml = new ahml(this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.c.setOnClickListener(this);
    u();
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364720));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131375934));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368627));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131689628));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).a(21).e(10).a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368659));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377976));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376969));
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
      azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849463);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166898));
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avqr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ambt);
    ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Avqr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ambt);
    ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(this);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void u()
  {
    int k = 0;
    boolean bool = azib.b();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364708);
    int j;
    if (localView != null)
    {
      i = aekt.a(12.0F, a());
      if (this.c != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
        if (!bool) {
          break label181;
        }
        j = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      Object localObject = localView.findViewById(2131376772);
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
      i = 2130844491;
      label122:
      localObject = localView.findViewById(2131365355);
      ((View)localObject).setBackgroundResource(i);
      if (!bool) {
        break label193;
      }
      j = 0;
      label145:
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131365356);
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
      i = 2130844490;
      break label122;
      j = 8;
      break label145;
    }
  }
  
  public void K_()
  {
    s();
    if (this.jdField_a_of_type_Ahnt != null) {
      this.jdField_a_of_type_Ahnt.e();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131558874, null);
    this.jdField_a_of_type_Ahnt = new ahnt(a());
    this.jdField_a_of_type_Ahnt.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public String a()
  {
    return a().getString(2131694185);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        A();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
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
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void ao_() {}
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      r();
      this.jdField_a_of_type_Ahnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      l();
      this.jdField_a_of_type_Ahml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
    } while (this.jdField_a_of_type_Ahmr == null);
    this.jdField_a_of_type_Ahmr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void d()
  {
    super.d();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Ahnt == null) {
      return;
    }
    this.jdField_a_of_type_Ahnt.h();
  }
  
  public void e()
  {
    super.e();
    n();
    r();
    ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.jdField_a_of_type_Ahnt.b(paramBoolean);
    a(((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d(), true);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      String str = a(2131694185);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      a().setTitle(a(2131694185));
    }
    if (this.jdField_a_of_type_Ahmr != null) {
      this.jdField_a_of_type_Ahmr.a();
    }
    t();
    ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ahnt.j();
    }
  }
  
  public void g()
  {
    ApngImage.pauseByTag(3);
    super.g();
    this.jdField_a_of_type_Ahnt.c();
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
    } while (this.jdField_a_of_type_Ahnt == null);
    this.jdField_a_of_type_Ahnt.l();
    return true;
  }
  
  public void j()
  {
    l();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      u();
      akhx.a.clear();
      return;
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849463);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166898));
    }
  }
  
  public void j_(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void k()
  {
    super.k();
    if (this.jdField_a_of_type_Ahmr != null) {
      this.jdField_a_of_type_Ahmr.b();
    }
    this.jdField_a_of_type_Ahnt.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    s();
  }
  
  void l()
  {
    int i = 2130838592;
    if (this.jdField_a_of_type_Ahnt != null) {
      this.jdField_a_of_type_Ahnt.i();
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
      ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidWidgetImageView, 3, 2130838592, "-contacts-");
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377256);
    } while (localView == null);
    if (ThemeUtil.isDefaultTheme()) {
      i = 2130839216;
    }
    localView.setBackgroundResource(i);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368627: 
      paramView = new Intent(a(), AddContactsActivity.class);
      paramView.putExtra("entrence_data_report", 1);
      paramView.putExtra("EntranceId", 3);
      a(paramView);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf(101200));
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    }
    this.jdField_a_of_type_Ahml.a();
    NewFriendActivity.a(a(), null, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Contacts
 * JD-Core Version:    0.7.0.1
 */