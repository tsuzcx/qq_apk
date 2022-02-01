package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsTabs;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.MiniAppScrollListener;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.contacts.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryController;
import com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController;
import com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ContactsViewController
  extends BaseViewController
  implements ContactsBaseFragment.RefreshDataListener, SimpleSlidingIndicator.OnTabListener, OnRefreshListener, StudyModeChangeListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  private ContactsTabs jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs;
  private ContactsViewPager jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
  private ContactsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  private CTEntryController jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ContactsViewController.7(this);
  protected QQAppInterface a;
  private BaseContactsMiniAppEntryManager jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new ContactsViewController.1(this));
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 2;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  private boolean h = false;
  
  public ContactsViewController(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs = new ContactsTabs(localMayknowRecommendManager.b("sp_mayknow_entry_list_recommend"), StudyModeManager.a());
    int i;
    if (localMayknowRecommendManager.b())
    {
      i = 2;
      this.jdField_d_of_type_Int = i;
      if (this.jdField_d_of_type_Int != 2) {
        break label227;
      }
    }
    label227:
    for (paramActivity = new RecommendTroopEntryController(paramActivity);; paramActivity = new MayKnowPersonEntryController(paramActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController = paramActivity;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(new ContactsViewController.2(this));
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager.ContactsViewController", 2, "ContactsViewController headType is: " + this.jdField_d_of_type_Int);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private int a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a())
    {
      int m = SharedPreUtils.ai(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      int j = 0;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        j = localFriendsManager.a();
      }
      if ((paramBoolean) && (j == 0)) {
        this.h = true;
      }
      if (((paramBoolean) && (j == 0)) || (j > m))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(1);
        k = i;
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "getDefaultTabPosition ShowRecommendTab friendCount:" + j + " boundaryCount:" + m);
        }
      }
    }
    for (int k = i;; k = i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "getDefaultTabPosition. defaultPos:" + k);
      }
      return k;
      break;
    }
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "checkTabsNeedChange. causeSwitchAccount:" + paramBoolean1 + " moveToDefault:" + paramBoolean2 + " mIsResumed:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a(this.jdField_b_of_type_Int);
      if (a())
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(i);
        if ((i == -1) || (paramBoolean2)) {
          i = a(paramBoolean1);
        }
        c(i);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList.size());
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  private boolean a()
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null))
    {
      bool2 = false;
      return bool2;
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (localMayknowRecommendManager != null) {
      bool1 = localMayknowRecommendManager.b("sp_mayknow_entry_list_recommend");
    }
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a(bool1, StudyModeManager.a());; bool1 = false)
    {
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfInt);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ContactsViewController", 2, "checkAndUpdateRecommendTabShow. mCurrentTabPos:" + this.jdField_b_of_type_Int + " isShowRecommendTab:" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a() + " changed:" + bool1);
      return bool1;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt + " oldType: " + this.jdField_d_of_type_Int);
    }
    if (this.jdField_d_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.d();
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int == 2) {}
    for (Object localObject = new RecommendTroopEntryController(this.jdField_a_of_type_AndroidAppActivity);; localObject = new MayKnowPersonEntryController(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController = ((CTEntryController)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(new ContactsViewController.3(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(this.jdField_a_of_type_AndroidViewView);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.b(false);
      return;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager.onAccountChanged(paramQQAppInterface);
    }
    if ((!b()) && (this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout, FrameControllerUtil.jdField_c_of_type_Int);
    }
  }
  
  private static boolean b()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    return (localMiniAppConfBean != null) && (localMiniAppConfBean.e());
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "switchToTabPos mCurrentTabPos:" + this.jdField_b_of_type_Int + "  pos:" + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_b_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(this.jdField_b_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_b_of_type_Int, true));
  }
  
  private void d(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onPageChange. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(paramInt, this.jdField_c_of_type_Int);
    SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    if (this.jdField_b_of_type_Boolean) {
      bool = false;
    }
    localSimpleSlidingIndicator.setCurrentPosition(paramInt, bool);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void m()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "initMicroAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ContactsViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localManager != null) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).sendUserAppListRequest(localManager, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createContactsMiniAppEntryManager(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setMiniAppScrollListener((CommonRefreshLayout.MiniAppScrollListener)this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager);
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager.showMicroAppPanel(FrameControllerUtil.jdField_c_of_type_Int);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onContactTabChange. position:" + paramInt + " fromUserClick:" + paramBoolean);
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
    if (this.jdField_c_of_type_Int != paramInt) {
      this.g = true;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(paramInt, false);
    String str;
    if (paramBoolean)
    {
      str = "";
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a(paramInt))
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
      continue;
      str = "0X800A1F6";
    }
  }
  
  public void a()
  {
    if (NetworkUtil.g(BaseApplication.getContext()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
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
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)paramView.findViewById(2131378256));
    k();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)paramView.findViewById(2131365240));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager = ((ContactsViewPager)paramView.findViewById(2131365243));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter = new ContactsViewPagerAdapter(((SplashActivity)a()).getSupportFragmentManager(), ((SplashActivity)a()).app, (BaseActivity)a(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOnPageChangeListener(new ContactsViewController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setInterceptListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131378761));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131378759));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new ContactsViewController.5(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(paramView);
    if (b()) {
      n();
    }
    c(a(false));
    if (this.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setOnScrollListener(new ContactsViewController.6(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        }
        paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if ((localMayknowRecommendManager == null) || (localMayknowRecommendManager.b("sp_mayknow_entry_list_recommend") == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a())) {
        break label252;
      }
    }
    label252:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "fillData. tabsChanged:" + bool + " mIsResumed:" + this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(6);
      if (bool) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 500L);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramQQAppInterface);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(paramQQAppInterface);
        b(paramQQAppInterface);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
        }
        return;
        this.jdField_b_of_type_Boolean = true;
        c(a(true));
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ContactsViewController.8(this));
      return;
    }
    a(false, false);
  }
  
  public void af_()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.b();
    StudyModeManager.a(this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setTalkbackSwitch();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setAccessibilityMsg();
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "mContactsViewPagerAdapter.doOnResume");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem(), paramBoolean);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.b(paramBoolean);
      i = this.jdField_b_of_type_Int;
      if (!this.jdField_d_of_type_Boolean) {
        break label281;
      }
      a(this.e, this.f);
      this.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager.setDrawerFrameEvent(FrameControllerUtil.jdField_c_of_type_Int);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8, 500L);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onResume. oldPos:" + i + " mCurrentTabPos:" + this.jdField_b_of_type_Int + " isBackground_Stop:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop + " isBackground_Pause:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
      }
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      label281:
      int j = a(false);
      if ((j != this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
      {
        this.jdField_b_of_type_Boolean = true;
        c(j);
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onPause. mCurrentTabPos:" + this.jdField_b_of_type_Int + " isBackground_Stop:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop + " isBackground_Pause:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.c();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.d();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    StudyModeManager.b(this);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.e();
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(2131365252, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle());
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ContactsViewController", 2, "updateContactsTabPubAccount error! " + QLog.getStackTraceString(localThrowable));
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.findViewById(2131372193);
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY() > localView.getTop())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, localView.getTop());
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(i);
      if ((i == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(1)) || (i == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(2)) || (i == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(0))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
      }
    }
    this.h = false;
  }
  
  public void i()
  {
    boolean bool = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(bool);
    if (this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager.onPostThemeChanged();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(3), false);
    }
  }
  
  protected void k()
  {
    int k = 2131165597;
    boolean bool1;
    int m;
    boolean bool2;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
    {
      bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      m = 25;
      bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (!QQTheme.e()) {
        break label103;
      }
      k = 2131167040;
      if (!bool2) {
        break label96;
      }
      i = 2131166488;
      m = 2131167117;
      int n = 255;
      j = i;
      i = m;
      m = n;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.d(m);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(k, i, j);
      return;
      label96:
      i = 2131166487;
      break;
      label103:
      if (bool2)
      {
        k = 2131165596;
        i = 2131165595;
        j = 2131165594;
        m = 30;
      }
      else if (!bool1)
      {
        k = 2131167041;
        i = 2131167117;
        j = 2131167041;
      }
      else
      {
        i = 2131167117;
        j = 2131165597;
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null) && (ContactsBaseFragment.a == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getHeight() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getWidth() > 0))
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getLocationOnScreen(arrayOfInt);
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getResources().getDisplayMetrics();
      int i = (int)(54.0F * localDisplayMetrics.density);
      ContactsBaseFragment.a = new Rect(arrayOfInt[0], arrayOfInt[1], localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels - i);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, String.format("init sContentRect:%s, w:%s, h: %s, density: %s", new Object[] { ContactsBaseFragment.a.toString(), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels), Float.valueOf(localDisplayMetrics.density) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController
 * JD-Core Version:    0.7.0.1
 */