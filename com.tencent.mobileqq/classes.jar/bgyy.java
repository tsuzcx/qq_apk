import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgyy
  extends bgzp
{
  private INTERFACE.StGetNAppForJumpReq a = new INTERFACE.StGetNAppForJumpReq();
  
  public bgyy(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt)
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
      QMLog.d("GetAppInfoByIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyy
 * JD-Core Version:    0.7.0.1
 */