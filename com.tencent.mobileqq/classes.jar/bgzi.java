import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgzi
  extends bgzp
{
  private INTERFACE.StGetUserInfoExtraReq a = new INTERFACE.StGetUserInfoExtraReq();
  
  public bgzi(String paramString)
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
      QMLog.d("GetUserInfoExtraRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetUserInfoExtraRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzi
 * JD-Core Version:    0.7.0.1
 */