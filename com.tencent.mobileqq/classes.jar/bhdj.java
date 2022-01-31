import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhdj
  extends bhdw
{
  private INTERFACE.StGetRobotUinReq a = new INTERFACE.StGetRobotUinReq();
  
  public bhdj(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
    this.a.appid.set(paramString);
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
    INTERFACE.StGetRobotUinRsp localStGetRobotUinRsp = new INTERFACE.StGetRobotUinRsp();
    try
    {
      localStGetRobotUinRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetRobotUinRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("robotUin", localStGetRobotUinRsp.uin.get());
        return paramArrayOfByte;
      }
      QMLog.d("GetRobotUinRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetRobotUinRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetRobotUin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdj
 * JD-Core Version:    0.7.0.1
 */