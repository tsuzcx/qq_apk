import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfag
  extends bfad
{
  private INTERFACE.StReportExecuteReq a = new INTERFACE.StReportExecuteReq();
  
  public bfag(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.appid.set(paramString1);
    this.a.execTime.set(paramInt);
    this.a.instrTraceId.set(paramString2);
    this.a.ruleName.set(paramString3);
  }
  
  protected String a()
  {
    return "mini_app_growguard";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StReportExecuteRsp localStReportExecuteRsp = new INTERFACE.StReportExecuteRsp();
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStReportExecuteRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStReportExecuteRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("response", localStReportExecuteRsp);
        paramArrayOfByte.put("resultCode", 0);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      besl.a("ReportExecuteRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      besl.a("ReportExecuteRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "ReportExecute";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfag
 * JD-Core Version:    0.7.0.1
 */