import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.os.Handler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest.1;
import org.json.JSONObject;

public class bezu
  extends bfau
{
  private INTERFACE.StGetAppInfoByIdReq a = new INTERFACE.StGetAppInfoByIdReq();
  
  public bezu(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.a.appid.set(paramString1);
    this.a.needVersionInfo.set(paramInt1);
    this.a.checkDevRight.set(paramInt2);
    this.a.firstPath.set(paramString2);
    this.a.envVersion.set(paramString3);
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo)
  {
    bejn.b().post(new GetAppInfoByIdRequest.1(this, paramMiniAppInfo));
  }
  
  protected String a()
  {
    return "mini_app_info";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGetAppInfoByIdRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if (localStGetAppInfoByIdRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from(localStGetAppInfoByIdRsp.appInfo);
        localMiniAppInfo.firstPath = this.a.firstPath.get();
        paramArrayOfByte.put("mini_app_info_data", localMiniAppInfo);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        if (localStGetAppInfoByIdRsp.appInfo.type.get() == 3) {
          a(localMiniAppInfo);
        }
      }
      else
      {
        betc.a("GetAppInfoByIdRequest", "onResponse fail.rsp = null");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    return paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetAppInfoById";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezu
 * JD-Core Version:    0.7.0.1
 */