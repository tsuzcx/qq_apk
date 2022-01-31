import NS_MINI_INTERFACE.INTERFACE.StBatchGetContactReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.GdtJsonPbUtil;
import java.util.List;
import org.json.JSONObject;

public class bhco
  extends bhdw
{
  private INTERFACE.StBatchGetContactReq a = new INTERFACE.StBatchGetContactReq();
  
  public bhco(List<String> paramList)
  {
    this.a.appids.set(paramList);
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
        paramArrayOfByte = GdtJsonPbUtil.pbToJson(localStGetRobotUinRsp);
        if ((paramArrayOfByte instanceof JSONObject)) {
          return (JSONObject)JSONObject.class.cast(paramArrayOfByte);
        }
      }
      else
      {
        QMLog.d("VerifyPluginRequest", "onResponse fail.rsp = null");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("VerifyPluginRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "BatchGetContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhco
 * JD-Core Version:    0.7.0.1
 */