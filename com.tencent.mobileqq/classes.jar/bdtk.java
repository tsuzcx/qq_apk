import NS_MINI_INTERFACE.INTERFACE.StGetFormIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetFormIdRsp;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONObject;

public class bdtk
  extends bdtz
{
  private INTERFACE.StGetFormIdReq a = new INTERFACE.StGetFormIdReq();
  
  public bdtk(String paramString)
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
      bdnw.a("GetFormIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("GetFormIdRequest", "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     bdtk
 * JD-Core Version:    0.7.0.1
 */