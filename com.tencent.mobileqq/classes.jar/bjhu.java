import GIFT_MALL_PROTOCOL.DouFuInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.birthdaynotice.BirthDayNoticeManager.1;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bjhu
{
  private static bjhv a = new bjhv();
  
  private static JSONObject a(DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("friendUin", paramDouFuInfo.uin);
      localJSONObject.put("background", paramDouFuInfo.background);
      localJSONObject.put("time", paramDouFuInfo.birthday);
      localJSONObject.put("blessing", paramDouFuInfo.blessing);
      localJSONObject.put("link", paramDouFuInfo.doufu_link);
      localJSONObject.put("icon", paramDouFuInfo.icon);
      return localJSONObject;
    }
    catch (Exception paramDouFuInfo)
    {
      QLog.e("BirthDayNoticeManager", 1, "error convert to json " + paramDouFuInfo);
      MonitorManager.a().a(19, 4, "convert to json error " + paramDouFuInfo, false);
    }
    return localJSONObject;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.a;
    Set localSet = paramQQAppInterface.a().a();
    long l1;
    long l3;
    if ((localSet != null) && (localSet.contains(str)) && (a(paramQQAppInterface, paramSessionInfo.a)))
    {
      l1 = paramQQAppInterface.a().b();
      l3 = System.currentTimeMillis() / 1000L;
      if (l3 - l1 >= 86400L)
      {
        QLog.i("BirthDayNoticeManager", 2, "requestBirthDayNotice ");
        paramSessionInfo = new NewIntent(BaseApplicationImpl.getApplication(), azbf.class);
        l1 = 0L;
      }
    }
    try
    {
      long l2 = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeManager", 1, "get uin error " + localException);
      }
    }
    paramSessionInfo.putExtra("selfuin", l1);
    a.a = new WeakReference(paramQQAppInterface);
    paramQQAppInterface.registObserver(a);
    paramQQAppInterface.startServlet(paramSessionInfo);
    paramQQAppInterface.a().c(l3);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (ausj.a(paramQQAppInterface, paramString, 5L, false) != null) {}
    while ((ausj.a(paramQQAppInterface, paramString, 12L, false) != null) || (ausj.a(paramQQAppInterface, paramString, false) != null)) {
      return true;
    }
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = a(paramDouFuInfo);
    long l = FeedsManager.getToken(String.valueOf(paramDouFuInfo.uin));
    ThreadManager.getSubThreadHandler().post(new BirthDayNoticeManager.1(paramDouFuInfo, paramQQAppInterface, localJSONObject, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhu
 * JD-Core Version:    0.7.0.1
 */