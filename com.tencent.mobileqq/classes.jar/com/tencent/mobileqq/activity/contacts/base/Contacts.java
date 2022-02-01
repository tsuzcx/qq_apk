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
import com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController;
import com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
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
  implements Handler.Callback, View.OnClickListener, INewFriendListener, CommonLoadingView.OnFirstDrawListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactsViewController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
  private SearchBarAssistant jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant = null;
  private CTNewFriendEntryController jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController;
  private TroopNotificationEntryController jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController;
  private NewFriendVerificationObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver = new Contacts.2(this);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUnreadCount|count = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", fromResume = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Tab.Contacts", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController != null)
    {
      localObject = ((INewFriendService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "")).getAllUnreadMsg();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateUnreadCount|count = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", realcount = ");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append(", fromResume = ");
        localStringBuilder.append(paramBoolean);
        QLog.d("Tab.Contacts", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController.a((List)localObject, paramBoolean ^ true, paramBoolean);
    }
    if (paramInt > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
      if (localObject != null) {
        ((ContactsViewController)localObject).g();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController;
    if (localObject != null) {
      ((TroopNotificationEntryController)localObject).d();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)DisplayUtils.a(a(), 5.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.b(this.jdField_a_of_type_Int);
    k();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView = ((CommonLoadingView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365016));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView.setOnFirstDrawListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365119));
    c(-1);
    j();
  }
  
  private void j()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365106);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant = new SearchBarAssistant((BaseActivity)a(), 2, localView);
    this.c = ((RelativeLayout)localView.findViewById(2131371778));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController = new CTNewFriendEntryController(this.c, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController = new TroopNotificationEntryController(localView, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, a());
    o();
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131365118));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376752));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369216));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131689589));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).b(21).f(10).a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378881));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377865));
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
    else
    {
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  private void l()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver);
    ((INewFriendService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "")).addListener(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver);
    ((INewFriendService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "")).removeListener(this);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("101200");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  private void o()
  {
    boolean bool = SimpleUIUtil.a();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365106);
    if (localView != null)
    {
      int i = AIOUtils.b(12.0F, a());
      Object localObject = this.c;
      int k = 0;
      int j;
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (bool) {
          j = 0;
        } else {
          j = i;
        }
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      localObject = localView.findViewById(2131377653);
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (bool) {
          i = 0;
        }
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 2130844964;
      } else {
        i = 2130844963;
      }
      localObject = localView.findViewById(2131365761);
      ((View)localObject).setBackgroundResource(i);
      if (bool) {
        j = 0;
      } else {
        j = 8;
      }
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131365762);
      localView.setBackgroundResource(i);
      if (bool) {
        i = k;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131558913, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController = new ContactsViewController(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected String a()
  {
    return a().getString(2131693874);
  }
  
  protected void a()
  {
    super.a();
    i();
    l();
    ((INewFriendService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "")).getUnreadMessageCountAsync();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000)
    {
      if (paramInt2 == 0)
      {
        B();
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).exit(false);
      }
    }
    else if (paramInt1 == 1000000)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("bind phone suc requestCode: ");
        paramIntent.append(paramInt1);
        paramIntent.append(", src: ");
        paramIntent.append(12);
        QLog.i("BindMsgConstant", 2, paramIntent.toString());
      }
    }
    else if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      ((IPhoneContactService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a(paramBoolean);
    a(((INewFriendService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount(), true);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      localObject = a(2131693874);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      a().setTitle(a(2131693874));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).a();
    }
    n();
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.i();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController;
    if (localObject != null) {
      ((TroopNotificationEntryController)localObject).c();
    }
  }
  
  public void ab_()
  {
    ApngImage.pauseByTag(3);
    super.ab_();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.c();
  }
  
  public void ac_() {}
  
  public void b() {}
  
  public void b(int paramInt)
  {
    c(paramInt);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
    o();
    BuddyListItem.a.clear();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      l();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      if ("0".equals(((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin())) {
        return;
      }
      c(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      ((INewFriendService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(INewFriendService.class, "")).getUnreadMessageCountAsync();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
      if (localObject != null) {
        ((SearchBarAssistant)localObject).a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController;
      if (localObject != null) {
        ((TroopNotificationEntryController)localObject).a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, a());
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
    if (localObject != null) {
      ((ContactsViewController)localObject).a(paramInt);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "setThemeDiyBgContacts mBgImageView == null");
      }
      return;
    }
    localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    paramInt = 2130838740;
    ThemeBackground.a((AppRuntime)localObject, localImageView, 3, 2130838740, "-contacts-");
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378155);
    if (localObject != null)
    {
      if (ThemeUtil.isDefaultTheme()) {
        paramInt = 2130839393;
      }
      ((View)localObject).setBackgroundResource(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected void d()
  {
    super.d();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopnotificationentryTroopNotificationEntryController;
    if (localObject != null) {
      ((TroopNotificationEntryController)localObject).b();
    }
    m();
  }
  
  public void e()
  {
    super.e();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ContactsViewController localContactsViewController = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
    if (localContactsViewController != null) {
      localContactsViewController.h();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void g_(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void h()
  {
    m();
    ContactsViewController localContactsViewController = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
    if (localContactsViewController != null) {
      localContactsViewController.e();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 9528)
    {
      if (i != 9529) {
        return true;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseContactsViewController;
      if (paramMessage != null)
      {
        paramMessage.k();
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCommonLoadingView.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        a(true);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9529, 300L);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i = paramView.getId();
      if (i != 2131369216)
      {
        if (i == 2131371778)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsNewfriendentryCTNewFriendEntryController.a();
          ((INewFriendApi)QRoute.api(INewFriendApi.class)).startActivity(a(), null, 2);
        }
      }
      else
      {
        Intent localIntent = new Intent(a(), AddContactsActivity.class);
        localIntent.putExtra("entrence_data_report", 1);
        localIntent.putExtra("EntranceId", 3);
        a(localIntent);
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      }
    }
    try
    {
      ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(String.valueOf(101200));
      label148:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts
 * JD-Core Version:    0.7.0.1
 */