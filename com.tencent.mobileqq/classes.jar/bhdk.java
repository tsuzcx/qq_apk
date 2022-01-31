import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenReq;
import NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhdk
  extends bhdw
{
  private INTERFACE.StGetSDKOpenKeyTokenReq a = new INTERFACE.StGetSDKOpenKeyTokenReq();
  
  public bhdk(COMM.StCommonExt paramStCommonExt)
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
      QMLog.d("GetSDKOpenKeyTokenRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetSDKOpenKeyTokenRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdk
 * JD-Core Version:    0.7.0.1
 */