import NS_MINI_INTERFACE.INTERFACE.StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfac
  extends bfau
{
  private INTERFACE.StGetCodeReq a = new INTERFACE.StGetCodeReq();
  
  public bfac(String paramString)
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
      betc.a("ProtoBufRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfac
 * JD-Core Version:    0.7.0.1
 */