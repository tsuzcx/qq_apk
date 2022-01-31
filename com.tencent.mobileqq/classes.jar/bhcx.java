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
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest.1;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import org.json.JSONObject;

public class bhcx
  extends bhdw
{
  private INTERFACE.StGetAppInfoByLinkReq a = new INTERFACE.StGetAppInfoByLinkReq();
  
  public bhcx(String paramString, int paramInt)
  {
    this.a.link.set(paramString);
    this.a.linkType.set(paramInt);
  }
  
  private void a(MiniAppInfo paramMiniAppInfo)
  {
    if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getMiniAppEnv().getContext())) {
      return;
    }
    ThreadManager.b().post(new GetAppInfoByLinkRequest.1(this, paramMiniAppInfo));
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
    INTERFACE.StGetAppInfoByLinkRsp localStGetAppInfoByLinkRsp = new INTERFACE.StGetAppInfoByLinkRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      localStGetAppInfoByLinkRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
      if ((localStGetAppInfoByLinkRsp != null) && (localStGetAppInfoByLinkRsp.appInfo != null))
      {
        paramArrayOfByte = new JSONObject();
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from(localStGetAppInfoByLinkRsp.appInfo);
        localMiniAppInfo.link = this.a.link.get();
        localMiniAppInfo.linkType = this.a.linkType.get();
        String str = localStGetAppInfoByLinkRsp.shareTicket.get();
        paramArrayOfByte.put("appInfo", localMiniAppInfo);
        paramArrayOfByte.put("shareTicket", str);
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode.get());
        paramArrayOfByte.put("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        if (localStGetAppInfoByLinkRsp.appInfo.type.get() == 3) {
          a(localMiniAppInfo);
        }
      }
      else
      {
        QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
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
    return "GetAppInfoByLink";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcx
 * JD-Core Version:    0.7.0.1
 */