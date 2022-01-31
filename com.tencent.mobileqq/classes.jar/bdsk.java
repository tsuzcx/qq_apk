import NS_COMM.COMM.Entry;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class bdsk
{
  private static List<COMM.Entry> a(MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList = new ArrayList();
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    localArrayList.add(bdsq.a("platform", "Android"));
    localArrayList.add(bdsq.a("uin", String.valueOf(localMiniAppProxy.getAccount())));
    if (paramMiniAppInfo != null)
    {
      localArrayList.add(bdsq.a("appid", paramMiniAppInfo.appId));
      localArrayList.add(bdsq.a("appname", paramMiniAppInfo.name));
    }
    return localArrayList;
  }
  
  private static List<COMM.Entry> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      localArrayList.add(bdsq.a("pos_id", String.valueOf(paramJSONObject.optInt("pos_id"))));
      localArrayList.add(bdsq.a("opt_type", String.valueOf(paramJSONObject.optInt("opt_type"))));
      localArrayList.add(bdsq.a("activ_web", paramJSONObject.optString("activ_web")));
    }
    return localArrayList;
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder;
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
    {
      localStringBuilder = new StringBuilder().append("report mobile game ad with args: ");
      if (paramJSONObject == null) {
        break label95;
      }
    }
    label95:
    for (Object localObject = paramJSONObject.toString();; localObject = "empty")
    {
      bdnw.a("MiniProgramLpReportDC04682", (String)localObject);
      localObject = new ArrayList();
      ((List)localObject).addAll(a(paramMiniAppInfo));
      ((List)localObject).addAll(a(paramJSONObject));
      paramMiniAppInfo = bdsq.a(7, (List)localObject, null);
      bdsr.a().a(paramMiniAppInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdsk
 * JD-Core Version:    0.7.0.1
 */