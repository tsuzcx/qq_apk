import NS_COMM.COMM.Entry;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class bgxt
{
  private static List<COMM.Entry> a(MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(bgxz.a("platform", "Android"));
    localArrayList.add(bgxz.a("uin", String.valueOf(bgte.a().a())));
    if (paramMiniAppInfo != null)
    {
      localArrayList.add(bgxz.a("appid", paramMiniAppInfo.appId));
      localArrayList.add(bgxz.a("appname", paramMiniAppInfo.name));
    }
    return localArrayList;
  }
  
  private static List<COMM.Entry> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      localArrayList.add(bgxz.a("pos_id", String.valueOf(paramJSONObject.optInt("pos_id"))));
      localArrayList.add(bgxz.a("opt_type", String.valueOf(paramJSONObject.optInt("opt_type"))));
      localArrayList.add(bgxz.a("activ_web", paramJSONObject.optString("activ_web")));
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
      QMLog.d("MiniProgramLpReportDC04682", (String)localObject);
      localObject = new ArrayList();
      ((List)localObject).addAll(a(paramMiniAppInfo));
      ((List)localObject).addAll(a(paramJSONObject));
      if (!QUAUtil.isQQApp()) {
        ((List)localObject).addAll(bgxz.a());
      }
      paramMiniAppInfo = bgxz.a(7, (List)localObject, null);
      bgya.a().a(paramMiniAppInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxt
 * JD-Core Version:    0.7.0.1
 */