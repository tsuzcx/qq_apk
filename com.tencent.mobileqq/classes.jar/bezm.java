import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezm
  extends bfad
{
  private INTERFACE.StGetNAppForJumpReq a = new INTERFACE.StGetNAppForJumpReq();
  
  public bezm(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.a.android_pkg_name.set(paramString3);
    this.a.mini_appid.set(paramString1);
    this.a.native_appid.set(paramString2);
    this.a.scene.set(paramInt);
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
    INTERFACE.StGetNAppForJumpRsp localStGetNAppForJumpRsp = new INTERFACE.StGetNAppForJumpRsp();
    try
    {
      localStGetNAppForJumpRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetNAppForJumpRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("packageName", localStGetNAppForJumpRsp.android_pkg.get());
        paramArrayOfByte.put("nativeAppId", localStGetNAppForJumpRsp.native_appid.get());
        paramArrayOfByte.put("downloadUrl", localStGetNAppForJumpRsp.android_donwload_url.get());
        paramArrayOfByte.put("appName", localStGetNAppForJumpRsp.appName.get());
        paramArrayOfByte.put("onlyOpen", localStGetNAppForJumpRsp.onlyOpen.get());
        return paramArrayOfByte;
      }
      besl.a("GetAppInfoByIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      besl.a("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetNAppForJump";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezm
 * JD-Core Version:    0.7.0.1
 */