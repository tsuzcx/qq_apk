package com.tencent.mobileqq.activity.contacts.base;

import agej;
import ajif;
import ajka;
import ajkg;
import ajsm;
import ajsq;
import ajsr;
import ajst;
import ajtf;
import ajve;
import akgv;
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
import anxr;
import anzj;
import ayxl;
import bbav;
import bdgb;
import bdll;
import bhmg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  extends anxr
  implements ajkg, akgv, Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ajif jdField_a_of_type_Ajif = new ajsr(this);
  private ajst jdField_a_of_type_Ajst;
  private ajtf jdField_a_of_type_Ajtf;
  private ajve jdField_a_of_type_Ajve;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayxl jdField_a_of_type_Ayxl = new ajsq(this);
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
    ajve localajve;
    if (this.jdField_a_of_type_Ajve != null)
    {
      localList = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", realcount = " + localList.size() + ", fromResume = " + paramBoolean);
      }
      localajve = this.jdField_a_of_type_Ajve;
      if (paramBoolean) {
        break label159;
      }
    }
    label159:
    for (boolean bool = true;; bool = false)
    {
      localajve.a(localList, bool, paramBoolean);
      if ((paramInt > 0) && (this.jdField_a_of_type_Ajst != null)) {
        this.jdField_a_of_type_Ajst.g();
      }
      return;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)bhmg.a(a(), 5.0F));
    this.jdField_a_of_type_Ajst.b();
    this.jdField_a_of_type_Ajst.a(this.jdField_a_of_type_Int);
    n();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364886));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364995));
    k();
    m();
  }
  
  private void m()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364982);
    this.jdField_a_of_type_Ajtf = new ajtf(a(), 2, localView);
    this.c = ((RelativeLayout)localView.findViewById(2131371731));
    this.jdField_a_of_type_Ajve = new ajve(this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.c.setOnClickListener(this);
    s();
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364994));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376869));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369056));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131689551));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).a(21).e(10).a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369088));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379037));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377980));
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
      bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850099);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajif);
    ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this);
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajif);
    ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(this);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void s()
  {
    int k = 0;
    boolean bool = bdgb.b();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364982);
    int j;
    if (localView != null)
    {
      i = agej.a(12.0F, a());
      if (this.c != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
        if (!bool) {
          break label181;
        }
        j = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      Object localObject = localView.findViewById(2131377786);
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
      i = 2130844972;
      label122:
      localObject = localView.findViewById(2131365634);
      ((View)localObject).setBackgroundResource(i);
      if (!bool) {
        break label193;
      }
      j = 0;
      label145:
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131365635);
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
      i = 2130844971;
      break label122;
      j = 8;
      break label145;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131558943, null);
    this.jdField_a_of_type_Ajst = new ajst(a());
    this.jdField_a_of_type_Ajst.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public String a()
  {
    return a().getString(2131693468);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        z();
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
  
  public void am_()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void an_() {}
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      p();
      this.jdField_a_of_type_Ajst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      k();
      this.jdField_a_of_type_Ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
    } while (this.jdField_a_of_type_Ajtf == null);
    this.jdField_a_of_type_Ajtf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    q();
    if (this.jdField_a_of_type_Ajst != null) {
      this.jdField_a_of_type_Ajst.e();
    }
  }
  
  public void d()
  {
    super.d();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Ajst == null) {
      return;
    }
    this.jdField_a_of_type_Ajst.h();
  }
  
  public void e()
  {
    super.e();
    l();
    p();
    ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.jdField_a_of_type_Ajst.b(paramBoolean);
    a(((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d(), true);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      String str = a(2131693468);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      a().setTitle(a(2131693468));
    }
    if (this.jdField_a_of_type_Ajtf != null) {
      this.jdField_a_of_type_Ajtf.a();
    }
    r();
    ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ajst.j();
    }
  }
  
  public void g()
  {
    ApngImage.pauseByTag(3);
    super.g();
    this.jdField_a_of_type_Ajst.c();
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
    } while (this.jdField_a_of_type_Ajst == null);
    this.jdField_a_of_type_Ajst.l();
    return true;
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Ajtf != null) {
      this.jdField_a_of_type_Ajtf.b();
    }
    this.jdField_a_of_type_Ajst.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    q();
  }
  
  public void j()
  {
    k();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      s();
      ajsm.a.clear();
      return;
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850099);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166987));
    }
  }
  
  public void j_(int paramInt)
  {
    a(paramInt, false);
  }
  
  void k()
  {
    int i = 2130838779;
    if (this.jdField_a_of_type_Ajst != null) {
      this.jdField_a_of_type_Ajst.i();
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
      ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidWidgetImageView, 3, 2130838779, "-contacts-");
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378278);
    } while (localView == null);
    if (ThemeUtil.isDefaultTheme()) {
      i = 2130839402;
    }
    localView.setBackgroundResource(i);
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf(101200));
      }
      catch (Exception localException) {}
      continue;
      this.jdField_a_of_type_Ajve.a();
      NewFriendActivity.a(a(), null, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts
 * JD-Core Version:    0.7.0.1
 */