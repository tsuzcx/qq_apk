import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberReq;
import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bduf
  extends bdtz
{
  private INTERFACE.StGetPhoneNumberReq a = new INTERFACE.StGetPhoneNumberReq();
  
  public bduf(String paramString)
  {
    this.a.appId.set(paramString);
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
    INTERFACE.StGetPhoneNumberRsp localStGetPhoneNumberRsp = new INTERFACE.StGetPhoneNumberRsp();
    try
    {
      localStGetPhoneNumberRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetPhoneNumberRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("countryCode", localStGetPhoneNumberRsp.countryCode.get());
        paramArrayOfByte.put("purePhoneNumber", localStGetPhoneNumberRsp.purePhoneNumber.get());
        paramArrayOfByte.put("iv", localStGetPhoneNumberRsp.iv.get());
        paramArrayOfByte.put("encryptedData", localStGetPhoneNumberRsp.encryptedData.get());
        paramArrayOfByte.put("cloudID", "");
        paramArrayOfByte.put("errMsg", "ok");
        return paramArrayOfByte;
      }
      bdnw.a("getPhoneNumberRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("getPhoneNumberRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetPhoneNumber";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bduf
 * JD-Core Version:    0.7.0.1
 */