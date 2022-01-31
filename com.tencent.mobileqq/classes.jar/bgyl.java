import NS_MINI_INTERFACE.INTERFACE.StCheckSessionReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckSessionRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgyl
  extends bgzp
{
  private INTERFACE.StCheckSessionReq a = new INTERFACE.StCheckSessionReq();
  
  public bgyl(String paramString)
  {
    this.a.appid.set(paramString);
  }
  
  protected String a()
  {
    return "mini_program_auth";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StCheckSessionRsp localStCheckSessionRsp = new INTERFACE.StCheckSessionRsp();
    try
    {
      localStCheckSessionRsp.mergeFrom(a(paramArrayOfByte));
      if (localStCheckSessionRsp != null) {
        return new JSONObject();
      }
      QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
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
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "CheckSession";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyl
 * JD-Core Version:    0.7.0.1
 */