import NS_MINI_INTERFACE.INTERFACE.StGetFormIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetFormIdRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bezi
  extends bfad
{
  private INTERFACE.StGetFormIdReq a = new INTERFACE.StGetFormIdReq();
  
  public bezi(String paramString)
  {
    this.a.appid.set(paramString);
  }
  
  protected String a()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetFormIdRsp localStGetFormIdRsp = new INTERFACE.StGetFormIdRsp();
    try
    {
      localStGetFormIdRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetFormIdRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("formId", localStGetFormIdRsp.formId.get());
        return paramArrayOfByte;
      }
      besl.a("GetFormIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      besl.a("GetFormIdRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetFormId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezi
 * JD-Core Version:    0.7.0.1
 */