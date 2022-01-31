import NS_MOBILE_QBOSS_PROTO.MobileQbossReportReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class bjqn
  extends QzoneExternalRequest
{
  private JceStruct a;
  
  public bjqn(ArrayList<tMobileQbossFeedBackInfo> paramArrayList)
  {
    MobileQbossReportReq localMobileQbossReportReq = new MobileQbossReportReq();
    localMobileQbossReportReq.vecMobileQbossFeedBackInfo = paramArrayList;
    this.a = localMobileQbossReportReq;
  }
  
  public static MobileQbossReportRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    MobileQbossReportRsp localMobileQbossReportRsp;
    do
    {
      return paramArrayOfByte;
      localMobileQbossReportRsp = (MobileQbossReportRsp)decode(paramArrayOfByte, "report");
      paramArrayOfByte = localMobileQbossReportRsp;
    } while (localMobileQbossReportRsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.report";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqn
 * JD-Core Version:    0.7.0.1
 */