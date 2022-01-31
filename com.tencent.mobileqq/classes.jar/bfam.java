import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bfam
  extends bfau
{
  private INTERFACE.StGetUserHealthDataReq a = new INTERFACE.StGetUserHealthDataReq();
  
  public bfam(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.a.appid.set(paramString);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
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
    INTERFACE.StGetUserHealthDataRsp localStGetUserHealthDataRsp = new INTERFACE.StGetUserHealthDataRsp();
    try
    {
      localStGetUserHealthDataRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetUserHealthDataRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("encryptedData", localStGetUserHealthDataRsp.encryptedData.get());
        paramArrayOfByte.put("iv", localStGetUserHealthDataRsp.iv.get());
        return paramArrayOfByte;
      }
      betc.a("GetUserHealthDataRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("GetUserHealthDataRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetUserHealthData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfam
 * JD-Core Version:    0.7.0.1
 */