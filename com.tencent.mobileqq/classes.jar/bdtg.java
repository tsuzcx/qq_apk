import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.os.Handler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest.1;
import org.json.JSONObject;

public class bdtg
  extends bdtz
{
  private INTERFACE.StGetAppInfoByLinkReq a = new INTERFACE.StGetAppInfoByLinkReq();
  
  public bdtg(String paramString, int paramInt)
  {
    this.a.link.set(paramString);
    this.a.linkType.set(paramInt);
  }
  
  private void a(INTERFACE.StGetAppInfoByLinkRsp paramStGetAppInfoByLinkRsp)
  {
    bdew.b().post(new GetAppInfoByLinkRequest.1(this, paramStGetAppInfoByLinkRsp));
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
    Object localObject = new INTERFACE.StGetAppInfoByLinkRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      ((INTERFACE.StGetAppInfoByLinkRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if ((localObject != null) && (((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo != null))
      {
        paramArrayOfByte = new JSONObject();
        if (((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo.type.get() == 3) {
          a((INTERFACE.StGetAppInfoByLinkRsp)localObject);
        }
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo);
        localObject = ((INTERFACE.StGetAppInfoByLinkRsp)localObject).shareTicket.get();
        paramArrayOfByte.put("appInfo", localMiniAppInfo);
        paramArrayOfByte.put("shareTicket", localObject);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        return paramArrayOfByte;
      }
      bdnw.a("ProtoBufRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetAppInfoByLink";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdtg
 * JD-Core Version:    0.7.0.1
 */