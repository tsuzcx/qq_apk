import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketReq;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgzf
  extends bgzp
{
  private INTERFACE.StGetTCBTicketReq a = new INTERFACE.StGetTCBTicketReq();
  
  public bgzf(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    this.a.appid.set(paramString1);
    this.a.envId.set(paramString2);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
  }
  
  protected String a()
  {
    return "mini_app_info";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetTCBTicketRsp localStGetTCBTicketRsp = new INTERFACE.StGetTCBTicketRsp();
    try
    {
      localStGetTCBTicketRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetTCBTicketRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("ticket", localStGetTCBTicketRsp.ticket.get());
        paramArrayOfByte.put("createTime", localStGetTCBTicketRsp.createTime.get());
        paramArrayOfByte.put("period", localStGetTCBTicketRsp.period.get());
        return paramArrayOfByte;
      }
      QMLog.d("GetTcbTicketRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetTcbTicketRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetTCBTicket";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzf
 * JD-Core Version:    0.7.0.1
 */