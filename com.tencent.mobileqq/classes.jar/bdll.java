import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bdll
  extends bdlh
{
  private bdlq a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public bdll(bdlq parambdlq)
  {
    this.jdField_a_of_type_Bdlq = parambdlq;
  }
  
  public void a(bdlg parambdlg)
  {
    if (parambdlg == null) {}
    label4:
    MiniAppInfo localMiniAppInfo;
    int i;
    label61:
    Object localObject1;
    label199:
    label475:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            bdnw.b("minisdk-start_RuntimeState", "onStateChange message:" + parambdlg.a);
            localObject2 = this.jdField_a_of_type_Bdlq.getRuntime();
            localMiniAppInfo = this.jdField_a_of_type_Bdlq.getMiniAppInfo();
            if (localMiniAppInfo != null)
            {
              i = localMiniAppInfo.getReportType();
              if ((localObject2 == null) || (((bdcw)localObject2).a() == null)) {
                break label199;
              }
            }
            for (localObject1 = ((bdcw)localObject2).a().a();; localObject1 = null) {
              switch (parambdlg.a)
              {
              default: 
                return;
              case 3: 
                if (!this.jdField_a_of_type_Boolean) {
                  break label4;
                }
                this.b = true;
                return;
                i = 0;
                break label61;
              }
            }
            localObject1 = new StringBuilder().append("--- report load appid:");
            if (localMiniAppInfo != null) {}
            for (parambdlg = localMiniAppInfo.appId;; parambdlg = Integer.valueOf(0))
            {
              bdnw.b("minisdk-start_RuntimeState", parambdlg);
              bdsc.a("2load", null, null, localMiniAppInfo);
              return;
            }
          } while (this.d);
          this.d = true;
          if ((localObject2 != null) && (localMiniAppInfo != null))
          {
            localObject2 = new StringBuilder().append("--- report show firstframe appid:");
            if (localMiniAppInfo == null) {
              break label397;
            }
          }
          for (parambdlg = localMiniAppInfo.appId;; parambdlg = Integer.valueOf(0))
          {
            bdnw.b("minisdk-start_RuntimeState", parambdlg);
            bdsc.a("2launch", "first_frame", (String)localObject1, localMiniAppInfo);
            parambdlg = (bdlg)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              parambdlg = localMiniAppInfo.launchParam.c;
            }
            bdsu.a(localMiniAppInfo, 21, parambdlg, null, null, 0);
            if ((!this.c) || (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())) {
              break;
            }
            bdit.a(MiniAppEnv.g().getContext(), "进入native小程序,仅debug可见", 0).a();
            return;
          }
        } while (localMiniAppInfo == null);
        localStringBuilder = new StringBuilder().append("--- report bring_to_front appid:");
        if (localMiniAppInfo == null) {
          break;
        }
        parambdlg = localMiniAppInfo.appId;
        bdnw.b("minisdk-start_RuntimeState", parambdlg);
        bdsc.a("2show", "bring_to_front", (String)localObject1, localMiniAppInfo);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label561;
        }
        parambdlg = localMiniAppInfo.launchParam.c;
        bdsu.a(localMiniAppInfo, 1, parambdlg, null, null, 0);
      } while (localObject2 == null);
      StringBuilder localStringBuilder = new StringBuilder().append("--- report click_resume appid:");
      if (localMiniAppInfo != null) {}
      for (localObject2 = localMiniAppInfo.appId;; localObject2 = Integer.valueOf(0))
      {
        bdnw.b("minisdk-start_RuntimeState", localObject2);
        bdsc.a("2launch", "click_resume", (String)localObject1, localMiniAppInfo);
        bdsu.a(localMiniAppInfo, 21, parambdlg, null, null, 0);
        return;
        parambdlg = Integer.valueOf(0);
        break;
        parambdlg = (bdlg)localObject1;
        break label475;
      }
    } while (localMiniAppInfo == null);
    label397:
    label561:
    Object localObject2 = new StringBuilder().append("--- report launch fail appid:");
    if (localMiniAppInfo != null) {}
    for (parambdlg = localMiniAppInfo.appId;; parambdlg = Integer.valueOf(0))
    {
      bdnw.b("minisdk-start_RuntimeState", parambdlg);
      bdsc.a("2launch_fail", "flutter_sdk_fail", (String)localObject1, localMiniAppInfo);
      return;
    }
    bdsc.a("2close", "loading_page", null, localMiniAppInfo);
    return;
    bdsc.a("2close", "inner_page", (String)localObject1, localMiniAppInfo);
    if ((this.jdField_a_of_type_Bdlq.isLoadSucceed()) && (localObject2 != null) && (((bdcw)localObject2).e()))
    {
      bdsu.a(localMiniAppInfo, 1025, "1");
      return;
    }
    bdsu.a(localMiniAppInfo, 1026, "1");
    return;
    bdsc.a("2unload", null, (String)localObject1, localMiniAppInfo);
    return;
    bdsc.a("2hide", null, (String)localObject1, localMiniAppInfo);
    bdsu.a(localMiniAppInfo, 20, "" + i);
    return;
    if (this.d)
    {
      bdsc.a("2back_key", "inner_page", (String)localObject1, localMiniAppInfo);
      return;
    }
    bdsc.a("2back_key", "loading_page", (String)localObject1, localMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdll
 * JD-Core Version:    0.7.0.1
 */