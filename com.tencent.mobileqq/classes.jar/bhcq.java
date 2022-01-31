import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhcq
  extends bhdw
{
  private INTERFACE.StCheckNavigateRightReq a = new INTERFACE.StCheckNavigateRightReq();
  
  public bhcq(String paramString1, String paramString2)
  {
    this.a.appId.set(paramString1);
    this.a.targetAppId.set(paramString2);
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
    INTERFACE.StCheckNavigateRightRsp localStCheckNavigateRightRsp = new INTERFACE.StCheckNavigateRightRsp();
    try
    {
      localStCheckNavigateRightRsp.mergeFrom(a(paramArrayOfByte));
      if (localStCheckNavigateRightRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        int i = localStCheckNavigateRightRsp.actionCode.get();
        paramArrayOfByte.put("action_code", i);
        paramArrayOfByte.put("skip_local_check", localStCheckNavigateRightRsp.skipLocalCheck.get());
        if (i == 0) {
          paramArrayOfByte.put("reason", localStCheckNavigateRightRsp.wording.get());
        } else {
          paramArrayOfByte.put("wording", localStCheckNavigateRightRsp.wording.get());
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetNewBaseLibRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("GetNewBaseLibRequest", "onResponse fail.rsp = null");
    return null;
    return paramArrayOfByte;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "CheckNavigateRight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcq
 * JD-Core Version:    0.7.0.1
 */