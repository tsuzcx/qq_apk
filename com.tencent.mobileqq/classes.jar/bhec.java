import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhec
  extends bhdw
{
  private INTERFACE.StSetUserAvatarReq a = new INTERFACE.StSetUserAvatarReq();
  
  public bhec(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.a.appid.set(paramString1);
    this.a.uin.set(paramString2);
    this.a.set_type.set(paramInt);
    this.a.item_id.set(paramString3);
    this.a.busi_info.set(paramString4);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
  }
  
  protected String a()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StSetUserAvatarRsp localStSetUserAvatarRsp = new INTERFACE.StSetUserAvatarRsp();
    try
    {
      localStSetUserAvatarRsp.mergeFrom(a(paramArrayOfByte));
      if (localStSetUserAvatarRsp != null) {
        return new JSONObject();
      }
      QMLog.d("SetAvatarRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("SetAvatarRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "SetUserAvatar";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhec
 * JD-Core Version:    0.7.0.1
 */