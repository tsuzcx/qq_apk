import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhct
  extends bhdw
{
  private byte[] a;
  
  public bhct(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  protected String a()
  {
    return "mini_app_report_transfer";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new APP_REPORT_TRANSFER.StDataReportRsp();
      paramArrayOfByte.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      int i = paramArrayOfByte.ret.get();
      if (i == 0) {
        return new JSONObject();
      }
      QMLog.d("ProtoBufRequest", "onResponse fail.retCode = " + i);
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  protected String b()
  {
    return "DataReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhct
 * JD-Core Version:    0.7.0.1
 */