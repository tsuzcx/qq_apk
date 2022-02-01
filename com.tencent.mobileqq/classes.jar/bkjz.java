import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class bkjz
{
  public static String a = "3";
  
  public static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.buffer.has()) && (paramAppInfo.iNewFlag.get() != 0)) {
      try
      {
        paramAppInfo = new JSONObject(paramAppInfo.buffer.get()).optString("_jump_url");
        return paramAppInfo;
      }
      catch (JSONException paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (!paramAppInfo.buffer.has()) || (paramAppInfo.iNewFlag.get() == 0)) {
      return "3";
    }
    try
    {
      paramAppInfo = new JSONObject(paramAppInfo.buffer.get());
      if (paramAppInfo.has("param")) {
        return "1";
      }
      if (paramAppInfo.has("msg")) {
        return "2";
      }
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
    return "3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjz
 * JD-Core Version:    0.7.0.1
 */