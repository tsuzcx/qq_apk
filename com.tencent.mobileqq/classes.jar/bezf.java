import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetAuthListReq;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezf
  extends bfad
{
  private INTERFACE.StGetAuthListReq a = new INTERFACE.StGetAuthListReq();
  
  public bezf(COMM.StCommonExt paramStCommonExt, String paramString)
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
      besl.a("GetAuthListsRequest", "onResponse fail." + paramArrayOfByte);
    }
    besl.a("GetAuthListsRequest", "onResponse fail.data = null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezf
 * JD-Core Version:    0.7.0.1
 */