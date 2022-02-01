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
import android.view.ViewGroup;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    if (localMayknowRecommendManager.b()) {
      i = 2;
    } else {
      i = 1;
    }
    this.jdField_d_of_type_Int = i;
    if (this.jdField_d_of_type_Int == 2) {
      paramActivity = new RecommendTroopEntryController(paramActivity);
    } else {
      paramActivity = new MayKnowPersonEntryController(paramActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(new ContactsViewController.2(this));
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("ContactsViewController headType is: ");
      paramActivity.append(this.jdField_d_of_type_Int);
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, paramActivity.toString());
    }
  }
  
  private int a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(1);
    int k = i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a())
    {
      int m = SharedPreUtils.af(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      int j = 0;
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null) {
        j = ((FriendsManager)localObject).a();
      }
      if ((paramBoolean) && (j == 0)) {
        this.h = true;
      }
      if (((paramBoolean) && (j == 0)) || (j > m)) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(1);
      }
      k = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultTabPosition ShowRecommendTab friendCount:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" boundaryCount:");
        ((StringBuilder)localObject).append(m);
        QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
        k = i;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDefaultTabPosition. defaultPos:");
      ((StringBuilder)localObject).append(k);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    return k;
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTabsNeedChange. causeSwitchAccount:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" moveToDefault:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" mIsResumed:");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.i("ContactsViewController", 2, localStringBuilder.toString());
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
        d(i);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)
      {
        bool2 = bool3;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
        {
          bool2 = bool3;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            bool2 = bool3;
            if (localObject != null)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null) {
                return false;
              }
              localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
              if (localObject != null)
              {
                bool1 = ((MayknowRecommendManager)localObject).b("sp_mayknow_entry_list_recommend");
                bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a(bool1, StudyModeManager.a());
              }
              if (bool1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList);
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfInt);
              }
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("checkAndUpdateRecommendTabShow. mCurrentTabPos:");
                ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
                ((StringBuilder)localObject).append(" isShowRecommendTab:");
                ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a());
                ((StringBuilder)localObject).append(" changed:");
                ((StringBuilder)localObject).append(bool1);
                QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
                bool2 = bool1;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager;
    if (localObject != null) {
      ((BaseContactsMiniAppEntryManager)localObject).onAccountChanged(paramQQAppInterface);
    }
    if (!b())
    {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager;
      if (paramQQAppInterface != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
        if (localObject != null) {
          paramQQAppInterface.shutdownMiniAppPullDownEntry((ViewGroup)localObject, FrameControllerUtil.jdField_c_of_type_Int);
        }
      }
    }
  }
  
  private static boolean b()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    return (localMiniAppConfBean != null) && (localMiniAppConfBean.e());
  }
  
  private void c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConversationRecommendTypeChange newType is: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" oldType: ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_d_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.d();
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int == 2) {
      localObject = new RecommendTroopEntryController(this.jdField_a_of_type_AndroidAppActivity);
    } else {
      localObject = new MayKnowPersonEntryController(this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController = ((CTEntryController)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(new ContactsViewController.3(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(false);
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchToTabPos mCurrentTabPos:");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("  pos:");
        localStringBuilder.append(paramInt);
        QLog.i("ContactsViewController", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_b_of_type_Int, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(this.jdField_b_of_type_Int, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_b_of_type_Int, true));
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageChange. position:");
      localStringBuilder.append(paramInt);
      QLog.d("ContactsViewController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(paramInt, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt, this.jdField_b_of_type_Boolean ^ true);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void l()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "initMicroAppEntryLayout.");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.e("ContactsViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localObject != null) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).sendUserAppListRequest((Manager)localObject, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), 20L);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onContactTabChange. position:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" fromUserClick:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
    if (this.jdField_c_of_type_Int != paramInt) {
      this.g = true;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(paramInt, false);
    if (paramBoolean)
    {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a(paramInt))
      {
      default: 
        localObject = "";
      }
      for (;;)
      {
        break;
        localObject = "0X800A1F6";
        continue;
        localObject = "0X8007F1E";
        continue;
        localObject = "0X8007F1D";
        continue;
        localObject = "0X8007F1C";
        continue;
        localObject = "0X8007F1A";
        continue;
        localObject = "0X8007F19";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject;
    if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
      if (localObject != null)
      {
        ContactsViewPager localContactsViewPager = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
        if (localContactsViewPager != null) {
          ((ContactsViewPagerAdapter)localObject).c(localContactsViewPager.getCurrentItem());
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
      }
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 1000L);
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    j();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    if (localObject != null) {
      ((ContactsViewPagerAdapter)localObject).a(bool, paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.c(bool);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager;
    if (localObject != null) {
      ((BaseContactsMiniAppEntryManager)localObject).onPostThemeChanged();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)paramView.findViewById(2131377670));
    j();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)paramView.findViewById(2131365117));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager = ((ContactsViewPager)paramView.findViewById(2131365120));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter = new ContactsViewPagerAdapter(((SplashActivity)a()).getSupportFragmentManager(), ((SplashActivity)a()).app, (BaseActivity)a(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOnPageChangeListener(new ContactsViewController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setInterceptListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131378155));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131378153));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new ContactsViewController.5(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(paramView);
    if (b()) {
      m();
    }
    d(a(false));
    if (this.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setOnScrollListener(new ContactsViewController.6(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != paramQQAppInterface)
      {
        if (localObject != null) {
          ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        }
        paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      boolean bool;
      if ((localObject != null) && (((MayknowRecommendManager)localObject).b("sp_mayknow_entry_list_recommend") != this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.a())) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fillData. tabsChanged:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" mIsResumed:");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
        QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(6);
      if (bool)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 500L);
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        d(a(true));
        this.jdField_b_of_type_Boolean = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
      if (localObject != null) {
        ((ContactsViewPagerAdapter)localObject).a(paramQQAppInterface);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
      if (localObject != null) {
        ((HeaderScrollView)localObject).scrollTo(0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(paramQQAppInterface);
      b(paramQQAppInterface);
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    if (paramQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
      if (localObject != null) {
        paramQQAppInterface.a(((HeaderScrollView)localObject).getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setTalkbackSwitch();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    if (localObject != null) {
      ((SimpleSlidingIndicator)localObject).setAccessibilityMsg();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "mContactsViewPagerAdapter.doOnResume");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem(), paramBoolean);
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.a(paramBoolean);
    int i = this.jdField_b_of_type_Int;
    if (this.jdField_d_of_type_Boolean)
    {
      a(this.e, this.f);
      this.jdField_d_of_type_Boolean = false;
    }
    else
    {
      int j = a(false);
      if ((j != this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
      {
        this.jdField_b_of_type_Boolean = true;
        d(j);
        this.jdField_b_of_type_Boolean = false;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    if (localObject != null)
    {
      HeaderScrollView localHeaderScrollView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
      if (localHeaderScrollView != null) {
        ((ContactsViewPagerAdapter)localObject).a(localHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.a());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniApiEntryBaseContactsMiniAppEntryManager;
    if (localObject != null) {
      ((BaseContactsMiniAppEntryManager)localObject).setDrawerFrameEvent(FrameControllerUtil.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(8);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8, 500L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume. oldPos:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void ad_()
  {
    HeaderScrollView localHeaderScrollView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
    if ((localHeaderScrollView != null) && (!localHeaderScrollView.a()))
    {
      localHeaderScrollView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
      localHeaderScrollView.scrollTo(0, localHeaderScrollView.a());
    }
  }
  
  public void b()
  {
    super.b();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.b();
    StudyModeManager.a(this);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c()
  {
    super.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    if (localObject != null)
    {
      ContactsViewPager localContactsViewPager = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
      if (localContactsViewPager != null) {
        ((ContactsViewPagerAdapter)localObject).d(localContactsViewPager.getCurrentItem());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause. mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.c();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void d()
  {
    super.d();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    if (localObject != null) {
      ((ContactsViewPagerAdapter)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.d();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    StudyModeManager.b(this);
  }
  
  public void e()
  {
    super.e();
    ContactsViewPagerAdapter localContactsViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
    if (localContactsViewPagerAdapter != null) {
      localContactsViewPagerAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController.e();
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(2131365129, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle());
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateContactsTabPubAccount error! ");
      localStringBuilder.append(QLog.getStackTraceString(localThrowable));
      QLog.e("ContactsViewController", 2, localStringBuilder.toString());
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
    if (localObject != null)
    {
      localObject = ((HeaderScrollView)localObject).findViewById(2131371778);
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY() > ((View)localObject).getTop())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, ((View)localObject).getTop());
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null)
    {
      ContactsViewPager localContactsViewPager = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
      if (localContactsViewPager != null)
      {
        int i = localContactsViewPager.getCurrentItem();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(i);
        if ((i == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(1)) || (i == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(2)) || (i == this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(0))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
        }
      }
    }
    this.h = false;
  }
  
  public void i()
  {
    SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    if (localSimpleSlidingIndicator != null) {
      localSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsTabs.b(3), false);
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
    {
      boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      int k = 25;
      boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      boolean bool3 = QQTheme.f();
      int j = 2131167064;
      int m = 2131167142;
      int i;
      if (bool3)
      {
        j = 2131167063;
        if (bool2) {
          i = 2131166499;
        } else {
          i = 2131166498;
        }
        k = 255;
      }
      else if (bool2)
      {
        j = 2131165573;
        m = 2131165572;
        i = 2131165571;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131167064;
      }
      else
      {
        i = 2131165574;
        j = 2131165574;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.d(k);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(j, m, i);
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null) && (ContactsBaseFragment.a == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getHeight() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getWidth() > 0))
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getLocationOnScreen(arrayOfInt);
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getResources().getDisplayMetrics();
      int i = (int)(localDisplayMetrics.density * 54.0F);
      ContactsBaseFragment.a = new Rect(arrayOfInt[0], arrayOfInt[1], localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels - i);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, String.format("init sContentRect:%s, w:%s, h: %s, density: %s", new Object[] { ContactsBaseFragment.a.toString(), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels), Float.valueOf(localDisplayMetrics.density) }));
      }
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ContactsViewController.8(this));
      return;
    }
    a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController
 * JD-Core Version:    0.7.0.1
 */