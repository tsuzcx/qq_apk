package com.tencent.mobileqq.activity.contacts.base;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationObserver;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController;
import com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.CommonLoadingView.OnFirstDrawListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class Contacts
  extends Frame
  implements Handler.Callback, View.OnClickListener, NewFriendManager.INewFriendListener, CommonLoadingView.OnFirstDrawListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NewFriendVerificationObserver jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver = new Contacts.2(this);
  private ContactsViewController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
  private SearchBarAssistant jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant = null;
  private CTNewFriendEntryController jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController;
  private TroopNotificationEntryController jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new Contacts.1(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private RelativeLayout c;
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", fromResume = " + paramBoolean);
    }
    List localList;
    CTNewFriendEntryController localCTNewFriendEntryController;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController != null)
    {
      localList = ((NewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a();
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", realcount = " + localList.size() + ", fromResume = " + paramBoolean);
      }
      localCTNewFriendEntryController = this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController;
      if (paramBoolean) {
        break label174;
      }
    }
    label174:
    for (boolean bool = true;; bool = false)
    {
      localCTNewFriendEntryController.a(localList, bool, paramBoolean);
      if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.g();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController.d();
      }
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)DisplayUtils.a(a(), 5.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(this.jdField_a_of_type_Int);
    o();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365136));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365242));
    i();
    m();
  }
  
  private void m()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365229);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant = new SearchBarAssistant((BaseActivity)a(), 2, localView);
    this.c = ((RelativeLayout)localView.findViewById(2131372193));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController = new CTNewFriendEntryController(this.c, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController = new TroopNotificationEntryController(localView, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, a());
    t();
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131365241));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377297));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131689557));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).b(21).f(10).a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369534));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379533));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378451));
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
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver);
    ((NewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this);
  }
  
  private void q()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver);
    ((NewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(this);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  private void t()
  {
    int k = 0;
    boolean bool = SimpleUIUtil.a();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365229);
    int j;
    if (localView != null)
    {
      i = AIOUtils.a(12.0F, a());
      if (this.c != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
        if (!bool) {
          break label181;
        }
        j = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      Object localObject = localView.findViewById(2131378239);
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
      i = 2130845087;
      label122:
      localObject = localView.findViewById(2131365924);
      ((View)localObject).setBackgroundResource(i);
      if (!bool) {
        break label193;
      }
      j = 0;
      label145:
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131365925);
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
      i = 2130845086;
      break label122;
      j = 8;
      break label145;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131559019, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController = new ContactsViewController(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void a()
  {
    super.a();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.h();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        C();
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).exit(false);
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
    ((PhoneContactManagerImp)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.CONTACT_MANAGER)).a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public String a_()
  {
    return a().getString(2131693918);
  }
  
  public void ae_() {}
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.b(paramBoolean);
    a(((NewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d(), true);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      String str = a(2131693918);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
      a().setTitle(a(2131693918));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant.a();
    }
    s();
    ((RedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void d()
  {
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.e();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      p();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      if (!"0".equals(((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin())) {
        break label45;
      }
    }
    label45:
    do
    {
      return;
      i();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      ((NewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, a());
  }
  
  public boolean e_()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void f()
  {
    super.f();
    j();
    p();
    ((NewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
  }
  
  public void g()
  {
    i();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      t();
      BuddyListItem.a.clear();
      return;
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        b(true);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9529, 300L);
      return true;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.l();
    return true;
  }
  
  void i()
  {
    int i = 2130838980;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.i();
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
      ThemeBackground.applyThemeBg(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_b_of_type_AndroidWidgetImageView, 3, 2130838980, "-contacts-");
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378761);
    } while (localView == null);
    if (ThemeUtil.isDefaultTheme()) {
      i = 2130839537;
    }
    localView.setBackgroundResource(i);
  }
  
  public void k()
  {
    super.k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController.b();
    }
    q();
  }
  
  public void k_(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void n()
  {
    ApngImage.pauseByTag(3);
    super.n();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.c();
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
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((RedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf(101200));
      }
      catch (Exception localException) {}
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController.a();
      NewFriendActivity.a(a(), null, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts
 * JD-Core Version:    0.7.0.1
 */