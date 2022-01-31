import NS_MINI_INTERFACE.INTERFACE.StCheckSessionReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckSessionRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezq
  extends bfau
{
  private INTERFACE.StCheckSessionReq a = new INTERFACE.StCheckSessionReq();
  
  public bezq(String paramString)
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
      betc.a("ProtoBufRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezq
 * JD-Core Version:    0.7.0.1
 */