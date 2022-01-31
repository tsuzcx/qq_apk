import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class arpm
  extends afpz
  implements afqu, aftq
{
  private int jdField_a_of_type_Int;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader;
  protected QQAppInterface a;
  private ContactsMiniAppEntryManager jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new arpn(this));
  private boolean jdField_a_of_type_Boolean;
  
  public arpm(Activity paramActivity)
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
    amtb localamtb = amtc.a();
    return (localamtb != null) && (localamtb.f());
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
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendUserAppListRequest(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager = new ContactsMiniAppEntryManager(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader, 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setMiniAppScrollListener(this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager);
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.showMicroAppPanel(MainFragment.e);
  }
  
  public void a()
  {
    if (bbev.g(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader.a(0);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131376742));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.findViewById(2131376740));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new arpo(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131369090));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setTargetListView(this.jdField_a_of_type_ComTencentWidgetListView);
    if (a())
    {
      h();
      this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(false);
      this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(null);
      this.jdField_a_of_type_ComTencentWidgetListView.disableOverScrollTop(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetListView.disableOverScrollTop(false);
  }
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  public void am_() {}
  
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
    if ((!a()) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout, MainFragment.e);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshEnabled(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpm
 * JD-Core Version:    0.7.0.1
 */