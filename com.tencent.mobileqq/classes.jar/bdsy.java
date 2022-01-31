import NS_MINI_INTERFACE.INTERFACE.StBatchGetContactReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import org.json.JSONObject;

public class bdsy
  extends bdtz
{
  private INTERFACE.StBatchGetContactReq a = new INTERFACE.StBatchGetContactReq();
  
  public bdsy(List<String> paramList)
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
        paramArrayOfByte = bdyp.a(localStGetRobotUinRsp);
        if ((paramArrayOfByte instanceof JSONObject)) {
          return (JSONObject)JSONObject.class.cast(paramArrayOfByte);
        }
      }
      else
      {
        bdnw.a("VerifyPluginRequest", "onResponse fail.rsp = null");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("VerifyPluginRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsy
 * JD-Core Version:    0.7.0.1
 */