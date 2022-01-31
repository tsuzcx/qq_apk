package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.ContactsConstant;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator.onTabListener;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wjq;
import wjr;
import wjs;

public class ContactsViewController
  extends BaseViewController
  implements ContactsBaseFragment.RefreshDataListener, SimpleSlidingIndicator.onTabListener, OnRefreshListener
{
  private int jdField_a_of_type_Int;
  private ContactsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter;
  private final CardController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController;
  private ContactsViewPager jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader;
  public QQAppInterface a;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  
  public ContactsViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new wjq(this));
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController = new CardController(paramActivity);
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0;
    }
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getInt("contacts_last_tab_pos_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = a();
    if ((paramBoolean) && (this.jdField_b_of_type_Int != 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(this.jdField_b_of_type_Int, false);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(paramInt, this.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putInt("contacts_last_tab_pos_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramInt).commit();
  }
  
  private void j()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onContactTabChange. position:" + paramInt + " fromUserClick:" + paramBoolean);
    }
    this.c = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem();
    if (this.c != paramInt) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setCurrentItem(paramInt, false);
    if (paramInt != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramInt;
      c(paramInt);
    }
    String str;
    if (paramBoolean)
    {
      str = "";
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      return 0;
      str = "0X8007F19";
      continue;
      str = "0X8007F1A";
      continue;
      str = "0X8007F1C";
      continue;
      str = "0X8007F1D";
      continue;
      str = "0X8007F1E";
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
    }
    paramObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramObject = paramObject.obtainMessage(4, paramInt, i);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramObject);
      return;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator = ((SimpleSlidingIndicator)paramView.findViewById(2131363813));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)paramView.findViewById(2131363811));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager = ((ContactsViewPager)paramView.findViewById(2131363814));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter = new ContactsViewPagerAdapter(((SplashActivity)a()).getSupportFragmentManager(), ((SplashActivity)a()).app, (BaseActivity)a());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOnPageChangeListener(new wjr(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setTabData(ContactsConstant.jdField_a_of_type_ArrayOfJavaLangString, ContactsConstant.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setInterceptListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(0, true));
    a(true);
    if (this.jdField_b_of_type_Int == 0)
    {
      ContactsBaseFragment localContactsBaseFragment = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(0, true);
      localContactsBaseFragment.jdField_a_of_type_Boolean = true;
      localContactsBaseFragment.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131363809));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.findViewById(2131362382));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new wjs(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(paramView);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(paramQQAppInterface);
      }
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.scrollTo(0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(paramQQAppInterface);
    }
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.b();
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setAccessibilityMsg();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager != null))
    {
      if (this.jdField_a_of_type_Boolean) {
        break label71;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem(), paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.b(paramBoolean);
      return;
      label71:
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.c();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.d();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.findViewById(2131363897);
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.getScrollY() > localView.getTop())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.scrollTo(0, localView.getTop());
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(i);
      if ((i == 0) || (i == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.scrollTo(0, 0);
      }
    }
  }
  
  public void g()
  {
    if (NetworkUtil.g(BaseApplication.getContext()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void h()
  {
    int j = 2131494212;
    boolean bool = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator != null) {
      if (!bool) {
        break label72;
      }
    }
    label72:
    for (int i = 2131494213;; i = 2131494212)
    {
      if (bool) {
        j = 2131493365;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(i, 2131493794, j);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.d(bool);
      return;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(2, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController
 * JD-Core Version:    0.7.0.1
 */