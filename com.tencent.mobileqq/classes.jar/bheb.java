import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetAuthsReq;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class bheb
  extends bhdw
{
  private INTERFACE.StSetAuthsReq a = new INTERFACE.StSetAuthsReq();
  
  public bheb(COMM.StCommonExt paramStCommonExt, String paramString, INTERFACE.StUserAuthInfo paramStUserAuthInfo)
  {
    this.a.appid.set(paramString);
    if (paramStUserAuthInfo != null)
    {
      paramString = new ArrayList();
      paramString.add(paramStUserAuthInfo);
      this.a.auths.set(paramString);
    }
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
    try
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      if (localStQWebRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("retCode", localStQWebRsp.retCode);
        return paramArrayOfByte;
      }
      QMLog.d("SetAuthsRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("SetAuthsRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "SetAuths";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheb
 * JD-Core Version:    0.7.0.1
 */