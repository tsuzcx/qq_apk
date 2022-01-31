import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgzk
  extends bgzp
{
  private INTERFACE.StGetUserSettingReq a = new INTERFACE.StGetUserSettingReq();
  
  public bgzk(String paramString1, String paramString2, String paramString3)
  {
    this.a.appid.set(paramString1);
    this.a.openid.set(paramString2);
    this.a.settingItem.set(paramString3);
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
    INTERFACE.StGetUserSettingRsp localStGetUserSettingRsp = new INTERFACE.StGetUserSettingRsp();
    try
    {
      localStGetUserSettingRsp.mergeFrom(a(paramArrayOfByte));
      if ((localStGetUserSettingRsp != null) && (localStGetUserSettingRsp.setting != null))
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("settingItem", localStGetUserSettingRsp.setting.settingItem.get());
        paramArrayOfByte.put("desc", localStGetUserSettingRsp.setting.desc.get());
        paramArrayOfByte.put("authState", localStGetUserSettingRsp.setting.authState.get());
        return paramArrayOfByte;
      }
      QMLog.d("VerifyPluginRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("VerifyPluginRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetUserSetting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzk
 * JD-Core Version:    0.7.0.1
 */