import NS_MINI_INTERFACE.INTERFACE.StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgyx
  extends bgzp
{
  private INTERFACE.StGetCodeReq a = new INTERFACE.StGetCodeReq();
  
  public bgyx(String paramString)
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
    INTERFACE.StGetCodeRsp localStGetCodeRsp = new INTERFACE.StGetCodeRsp();
    try
    {
      localStGetCodeRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetCodeRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("code", localStGetCodeRsp.code.get());
        return paramArrayOfByte;
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
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetCode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyx
 * JD-Core Version:    0.7.0.1
 */