import NS_MINI_INTERFACE.INTERFACE.StReportShareReq;
import NS_MINI_INTERFACE.INTERFACE.StReportShareRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgzt
  extends bgzp
{
  private INTERFACE.StReportShareReq a = new INTERFACE.StReportShareReq();
  
  public bgzt(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.a.reportTime.set(paramLong);
    this.a.appid.set(paramString1);
    this.a.appType.set(paramInt1);
    this.a.shareScene.set(paramInt2);
    this.a.shareType.set(paramInt3);
    this.a.destType.set(paramInt4);
    this.a.destId.set(paramString2);
  }
  
  protected String a()
  {
    return "mini_app_usr_time";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StReportShareRsp localStReportShareRsp = new INTERFACE.StReportShareRsp();
    try
    {
      localStReportShareRsp.mergeFrom(a(paramArrayOfByte));
      if (localStReportShareRsp != null) {
        return new JSONObject();
      }
      QMLog.d("ReportShareRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ReportShareRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "ReportShare";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzt
 * JD-Core Version:    0.7.0.1
 */