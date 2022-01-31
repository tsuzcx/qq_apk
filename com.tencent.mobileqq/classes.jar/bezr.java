import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenReq;
import NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezr
  extends bfad
{
  private INTERFACE.StGetSDKOpenKeyTokenReq a = new INTERFACE.StGetSDKOpenKeyTokenReq();
  
  public bezr(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
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
    INTERFACE.StGetSDKOpenKeyTokenRsp localStGetSDKOpenKeyTokenRsp = new INTERFACE.StGetSDKOpenKeyTokenRsp();
    try
    {
      localStGetSDKOpenKeyTokenRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetSDKOpenKeyTokenRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("token", localStGetSDKOpenKeyTokenRsp.token.get());
        return paramArrayOfByte;
      }
      besl.a("GetSDKOpenKeyTokenRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      besl.a("GetSDKOpenKeyTokenRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetSDKOpenKeyToken";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezr
 * JD-Core Version:    0.7.0.1
 */