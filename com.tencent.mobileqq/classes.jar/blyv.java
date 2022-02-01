import NS_USER_ACTION_REPORT.UserCommReport;
import android.os.Build;
import com.tencent.common.config.AppSetting;

class blyv
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public UserCommReport a()
  {
    UserCommReport localUserCommReport = new UserCommReport();
    localUserCommReport.uin = this.jdField_a_of_type_Long;
    localUserCommReport.platform = "AND";
    localUserCommReport.client_type = "SQ";
    localUserCommReport.network_type = this.jdField_a_of_type_JavaLangString;
    localUserCommReport.qua = blru.a();
    localUserCommReport.app_version = AppSetting.f();
    localUserCommReport.os_version = bgln.e();
    localUserCommReport.mobile_type = Build.MODEL;
    return localUserCommReport;
  }
  
  public blyv a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public blyv a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyv
 * JD-Core Version:    0.7.0.1
 */