import NS_MINI_INTERFACE.INTERFACE.StGetFormIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetFormIdRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bhdb
  extends bhdw
{
  private INTERFACE.StGetFormIdReq a = new INTERFACE.StGetFormIdReq();
  
  public bhdb(String paramString)
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
      QMLog.d("GetFormIdRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetFormIdRequest", "onResponse fail." + paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdb
 * JD-Core Version:    0.7.0.1
 */