import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportReq;
import NS_USER_ACTION_REPORT.UserCommReport;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class bmzy
  extends QzoneExternalRequest
{
  private final JceStruct a;
  
  public bmzy(int paramInt, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    this.a = new UserActionReportReq(paramInt, paramUserCommReport, paramArrayList);
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "MobileReport.UserActionReport";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "UserActionReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzy
 * JD-Core Version:    0.7.0.1
 */