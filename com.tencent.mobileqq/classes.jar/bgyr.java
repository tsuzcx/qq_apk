import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetAuthListReq;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgyr
  extends bgzp
{
  private INTERFACE.StGetAuthListReq a = new INTERFACE.StGetAuthListReq();
  
  public bgyr(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.a.appid.set(paramString);
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
    if (paramArrayOfByte != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("authList", a(paramArrayOfByte));
      return localJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetAuthListsRequest", "onResponse fail." + paramArrayOfByte);
    }
    QMLog.d("GetAuthListsRequest", "onResponse fail.data = null");
    return null;
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetAuthList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyr
 * JD-Core Version:    0.7.0.1
 */