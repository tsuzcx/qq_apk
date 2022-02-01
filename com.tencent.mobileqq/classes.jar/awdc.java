import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class awdc
  extends ajiw
  implements ajju, ajmp
{
  private int jdField_a_of_type_Int;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  protected QQAppInterface a;
  private ContactsMiniAppEntryManager jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new awdd(this));
  private boolean jdField_a_of_type_Boolean;
  
  public awdc(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)paramActivity).app;
    }
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_leba_mini_app_refresh_time", 0).getLong("last_leba_mini_app_refresh_time", 0L);
  }
  
  public static boolean a()
  {
    arbv localarbv = arbw.a();
    return (localarbv != null) && (localarbv.f());
  }
  
  private void g()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("last_leba_mini_app_refresh_time", 0).edit().putLong("last_leba_mini_app_refresh_time", l).commit();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaViewController", 2, "initMicroAppEntryLayout.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("LebaViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendUserAppListRequest(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager = new ContactsMiniAppEntryManager(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader, 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setMiniAppScrollListener(this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager);
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.showMicroAppPanel(MainFragment.e);
  }
  
  public void a()
  {
    if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.a(0);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 800L);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaViewController", 2, "refresh falied. network unavailable");
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
      QLog.i("LebaViewController", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131378335));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131378333));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new awde(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131369986));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setTargetListView(this.jdField_a_of_type_ComTencentWidgetListView);
    if (a())
    {
      h();
      this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(false);
      this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(null);
      this.jdField_a_of_type_ComTencentWidgetListView.disableOverScrollTop(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetListView.disableOverScrollTop(false);
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  public void ag_() {}
  
  public void b()
  {
    super.b();
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onAccountChanged(paramQQAppInterface);
    }
    if ((!a()) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout, MainFragment.e);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshEnabled(false);
      if (this.jdField_a_of_type_ComTencentWidgetListView != null) {
        this.jdField_a_of_type_ComTencentWidgetListView.disableOverScrollTop(false);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onPostThemeChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdc
 * JD-Core Version:    0.7.0.1
 */