import NS_COMM.COMM.Entry;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class beyy
{
  private static List<COMM.Entry> a(MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(beze.a("platform", "Android"));
    localArrayList.add(beze.a("uin", String.valueOf(beut.a().a())));
    if (paramMiniAppInfo != null)
    {
      localArrayList.add(beze.a("appid", paramMiniAppInfo.appId));
      localArrayList.add(beze.a("appname", paramMiniAppInfo.name));
    }
    return localArrayList;
  }
  
  private static List<COMM.Entry> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      localArrayList.add(beze.a("pos_id", String.valueOf(paramJSONObject.optInt("pos_id"))));
      localArrayList.add(beze.a("opt_type", String.valueOf(paramJSONObject.optInt("opt_type"))));
      localArrayList.add(beze.a("activ_web", paramJSONObject.optString("activ_web")));
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
        break label111;
      }
    }
    label111:
    for (Object localObject = paramJSONObject.toString();; localObject = "empty")
    {
      betc.a("MiniProgramLpReportDC04682", (String)localObject);
      localObject = new ArrayList();
      ((List)localObject).addAll(a(paramMiniAppInfo));
      ((List)localObject).addAll(a(paramJSONObject));
      if (!bfhk.a()) {
        ((List)localObject).addAll(beze.a());
      }
      paramMiniAppInfo = beze.a(7, (List)localObject, null);
      bezf.a().a(paramMiniAppInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyy
 * JD-Core Version:    0.7.0.1
 */