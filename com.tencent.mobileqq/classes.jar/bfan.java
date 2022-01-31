import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfan
  extends bfau
{
  private INTERFACE.StGetUserInfoExtraReq a = new INTERFACE.StGetUserInfoExtraReq();
  
  public bfan(String paramString)
  {
    this.a.appid.set(paramString);
  }
  
  protected String a()
  {
    return "mini_user_info";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetUserInfoExtraRsp localStGetUserInfoExtraRsp = new INTERFACE.StGetUserInfoExtraRsp();
    try
    {
      localStGetUserInfoExtraRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetUserInfoExtraRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("encryptedData", localStGetUserInfoExtraRsp.encryptedData.get());
        paramArrayOfByte.put("iv", localStGetUserInfoExtraRsp.iv.get());
        return paramArrayOfByte;
      }
      betc.a("GetUserInfoExtraRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("GetUserInfoExtraRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetUserInfoExtra";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfan
 * JD-Core Version:    0.7.0.1
 */