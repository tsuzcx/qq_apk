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

public class bdtf
  extends bdtz
{
  private INTERFACE.StGetAppInfoByIdReq a = new INTERFACE.StGetAppInfoByIdReq();
  
  public bdtf(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
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
  
  private void a(INTERFACE.StGetAppInfoByIdRsp paramStGetAppInfoByIdRsp)
  {
    bdew.b().post(new GetAppInfoByIdRequest.1(this, paramStGetAppInfoByIdRsp));
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
        if (localStGetAppInfoByIdRsp.appInfo.type.get() == 3) {
          a(localStGetAppInfoByIdRsp);
        }
        paramArrayOfByte.put("mini_app_info_data", MiniAppInfo.from(localStGetAppInfoByIdRsp.appInfo));
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      bdnw.a("GetAppInfoByIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
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
 * Qualified Name:     bdtf
 * JD-Core Version:    0.7.0.1
 */