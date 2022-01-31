import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezp
  extends bfad
{
  private INTERFACE.StGetProfileReq a = new INTERFACE.StGetProfileReq();
  
  public bezp(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a.appid.set(paramString1);
    paramString1 = this.a.withCredentials;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1.set(i);
      if (!TextUtils.isEmpty(paramString2)) {
        this.a.lang.set(paramString2);
      }
      return;
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
    INTERFACE.StGetProfileRsp localStGetProfileRsp = new INTERFACE.StGetProfileRsp();
    try
    {
      localStGetProfileRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetProfileRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        if (localStGetProfileRsp.user != null)
        {
          paramArrayOfByte.put("nickName", localStGetProfileRsp.user.nick.get());
          paramArrayOfByte.put("avatarUrl", localStGetProfileRsp.user.avatar.get());
          paramArrayOfByte.put("gender", localStGetProfileRsp.user.gender.get());
          paramArrayOfByte.put("language", localStGetProfileRsp.user.language.get());
          if (localStGetProfileRsp.user.address != null)
          {
            paramArrayOfByte.put("province", localStGetProfileRsp.user.address.province.get());
            paramArrayOfByte.put("city", localStGetProfileRsp.user.address.city.get());
            paramArrayOfByte.put("country", localStGetProfileRsp.user.address.country.get());
          }
        }
        localJSONObject2.put("rawData", localStGetProfileRsp.rawData.get());
        localJSONObject2.put("signature", localStGetProfileRsp.signature.get());
        localJSONObject2.put("encryptedData", localStGetProfileRsp.encryptedData.get());
        localJSONObject2.put("iv", localStGetProfileRsp.iv.get());
        localJSONObject2.put("userInfo", paramArrayOfByte);
        localJSONObject1.put("data", localStGetProfileRsp.rawData.get());
        localJSONObject1.put("signature", localStGetProfileRsp.signature.get());
        localJSONObject2.put("data", localJSONObject1.toString());
        return localJSONObject2;
      }
      besl.a("GetProfileRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      besl.a("GetProfileRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetProfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezp
 * JD-Core Version:    0.7.0.1
 */