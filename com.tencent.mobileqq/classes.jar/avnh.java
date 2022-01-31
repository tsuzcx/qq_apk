import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class avnh
  implements Manager
{
  private static int jdField_a_of_type_Int = -1;
  private static int b = -1;
  private static int c = -1;
  private static int d = -1;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private int e = 0;
  private int f;
  private int g;
  
  public avnh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private SharedPreferences a()
  {
    String str = SecurityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) + "GetQZoneFeeds";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  private void a(ArrayList<Long> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramInt >= paramArrayList.size()))
    {
      e();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "refreshAllInner(" + paramInt + ")...");
    }
    int j = c() + paramInt;
    int i = j;
    if (j >= paramArrayList.size()) {
      i = paramArrayList.size();
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), avnj.class);
    paramArrayList = new ArrayList(paramArrayList.subList(paramInt, i));
    avnk.a(localNewIntent, avnk.a(1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), paramArrayList, 0L, null));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  @TargetApi(9)
  private void b(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putLong("last_request_time", paramLong);
    localEditor.putString("last_attach_info", paramString);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private static int c()
  {
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsUinNum", 100);
    }
    return jdField_a_of_type_Int;
  }
  
  private static int d()
  {
    if (b < 0) {
      b = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsRetryNum", 2);
    }
    return b;
  }
  
  private static int e()
  {
    if (c < 0)
    {
      c = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsMinTimeCell", 900);
      c *= 1000;
    }
    return c;
  }
  
  private static int f()
  {
    if (d < 0)
    {
      d = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsMinRefreshTimeCell", 604800);
      d *= 1000;
    }
    return d;
  }
  
  public long a()
  {
    return a().getLong("last_request_time", 0L);
  }
  
  public String a()
  {
    return a().getString("last_attach_info", "");
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!GetQZoneFeeds.a) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedManager", 2, "GetQZoneFeeds 此step尚未执行，此次调用就此返回，等待自动机中GetQZoneFeeds执行此方法");
      }
    }
    while (!bbev.g(BaseApplication.getContext())) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QzoneContactsFeedManager.1(this));
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateFriend(" + this.e + ")...");
    }
    if (this.e != 0) {
      return;
    }
    this.e = 3;
    this.f = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    a(this.jdField_a_of_type_JavaUtilArrayList, this.f);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateAll(" + this.e + ")...");
    }
    if (this.e != 0) {
      return;
    }
    this.e = 2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), avnj.class);
    avnk.a(localNewIntent, avnk.a(2, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), null, paramLong, paramString));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (paramnewest_feeds_rsp == null) {}
    while ((this.e == 3) || (((this.e != 1) || (this.f != 0)) && (this.e != 2))) {
      return;
    }
    b(paramnewest_feeds_rsp.last_feed_time, paramnewest_feeds_rsp.str_attach);
  }
  
  public void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "refreshAll(" + this.e + ")...");
    }
    if (this.e != 0) {
      return;
    }
    this.e = 1;
    this.f = 0;
    this.jdField_a_of_type_JavaUtilArrayList = avnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      ajxn localajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      QLog.d("QzoneContactsFeedManager", 2, new Object[] { "allFriends.size:", Integer.valueOf(i), ",getAllFreindsCount:", Integer.valueOf(localajxn.a()) });
    }
    a(this.jdField_a_of_type_JavaUtilArrayList, this.f);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "retry(" + this.g + ")...");
    }
    this.g += 1;
    if (this.g >= d())
    {
      this.g = 0;
      if (this.e == 1) {
        b(0L, null);
      }
      d();
      return;
    }
    if ((this.e == 1) || (this.e == 3))
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.f);
      return;
    }
    if (this.e == 2)
    {
      this.e = 0;
      a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      return;
    }
    e();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "doNextRequest(" + this.f + ")...");
    }
    if ((this.e != 1) && (this.e != 3))
    {
      e();
      return;
    }
    this.f += c();
    a(this.jdField_a_of_type_JavaUtilArrayList, this.f);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "close...");
    }
    this.e = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.f = 0;
    this.g = 0;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "onDestroy...");
    }
    e();
    GetQZoneFeeds.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avnh
 * JD-Core Version:    0.7.0.1
 */