import NS_MOBILE_FEEDS.mobile_online_report_item;
import NS_MOBILE_FEEDS.mobile_online_report_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class bjqz
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public bjqz(long paramLong, ArrayList<mobile_online_report_item> paramArrayList)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    mobile_online_report_req localmobile_online_report_req = new mobile_online_report_req();
    localmobile_online_report_req.appid = 8001;
    localmobile_online_report_req.type_id = 0;
    localmobile_online_report_req.uin = paramLong;
    localmobile_online_report_req.vecOnlineItem = paramArrayList;
    this.a = localmobile_online_report_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.reportOnlineTime";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "reportOnlineTime";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqz
 * JD-Core Version:    0.7.0.1
 */