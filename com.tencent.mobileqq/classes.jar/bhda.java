import NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeReq;
import NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.JSONConverter;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhda
  extends bhdw
{
  private MiniAppStore.StGetFirstPageByTypeReq a = new MiniAppStore.StGetFirstPageByTypeReq();
  
  public bhda(int paramInt)
  {
    this.a.uiPageType.set(paramInt);
  }
  
  protected String a()
  {
    return "store_app_client";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniAppStore.StGetFirstPageByTypeRsp localStGetFirstPageByTypeRsp = new MiniAppStore.StGetFirstPageByTypeRsp();
    try
    {
      localStGetFirstPageByTypeRsp.mergeFrom(a(paramArrayOfByte));
      if (localStGetFirstPageByTypeRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("data", JSONConverter.convert2JSONArray(localStGetFirstPageByTypeRsp.vecAppInfo.get()).toString());
        paramArrayOfByte.put("dataType", "string");
        return paramArrayOfByte;
      }
      QMLog.d("GetFirstPageByTypeRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetFirstPageByTypeRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    return this.a.toByteArray();
  }
  
  protected String b()
  {
    return "GetFirstPageByType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhda
 * JD-Core Version:    0.7.0.1
 */