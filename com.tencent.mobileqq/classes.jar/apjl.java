import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class apjl
{
  public static void a(String paramString)
  {
    QLog.d("TencentDocUtils", 1, "WL_DEBUG reportClickEvent actionName = " + paramString);
    azqs.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = apjk.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    if (!bool) {
      ((alpk)paramQQAppInterface.a(2)).A();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocUtils", 1, "WL_DEBUG updateTencentDocUser isUser = " + bool);
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.c();
    paramBoolean = localBaseApplication.getSharedPreferences("call_tim_config_pre" + paramQQAppInterface, 0).getBoolean("call_tim_config_switch", false);
    paramQQAppInterface = aoyv.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocUtils", 2, "WL_DEBUG showInQQSettingMe enable = " + paramBoolean + ", isUser = " + false + ", userConfigMeURL = " + paramQQAppInterface);
    }
    return (!paramBoolean) && (paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjl
 * JD-Core Version:    0.7.0.1
 */