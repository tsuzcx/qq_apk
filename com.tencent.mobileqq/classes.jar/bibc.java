import NS_MOBILE_COMM_CONF.MobileCommConf;
import NS_MOBILE_COMM_CONF.NewMobileGlobalConf;
import NS_MOBILE_COMM_CONF.NewMobileUserConf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bibc
{
  private static bibc jdField_a_of_type_Bibc;
  private long jdField_a_of_type_Long = -1L;
  
  public static bibc a()
  {
    if (jdField_a_of_type_Bibc == null) {}
    try
    {
      if (jdField_a_of_type_Bibc == null) {
        jdField_a_of_type_Bibc = new bibc();
      }
      return jdField_a_of_type_Bibc;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_report", 0).edit();
      localEditor.putLong("lastReportTime", paramLong);
      localEditor.apply();
    }
  }
  
  public void a(MobileCommConf paramMobileCommConf)
  {
    if ((paramMobileCommConf == null) || (paramMobileCommConf.new_mobile_global_conf == null) || (paramMobileCommConf.new_mobile_user_conf == null)) {}
    long l;
    do
    {
      do
      {
        return;
        l = paramMobileCommConf.new_mobile_global_conf.version;
      } while (paramMobileCommConf.new_mobile_user_conf.version < l);
      l = System.currentTimeMillis() / 1000L;
    } while (((this.jdField_a_of_type_Long >= paramMobileCommConf.new_mobile_user_conf.uBeginTime) && (this.jdField_a_of_type_Long <= paramMobileCommConf.new_mobile_user_conf.uEndTime)) || (l < paramMobileCommConf.new_mobile_user_conf.uBeginTime) || (l > paramMobileCommConf.new_mobile_user_conf.uEndTime));
    this.jdField_a_of_type_Long = l;
    a(this.jdField_a_of_type_Long);
    paramMobileCommConf = new NewIntent(BaseApplicationImpl.getApplication(), bibe.class);
    try
    {
      l = Long.parseLong(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
      paramMobileCommConf.putExtra("selfuin", l);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMobileCommConf);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("YYBInstallPackageManager", 1, "get uin error " + localException);
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibc
 * JD-Core Version:    0.7.0.1
 */