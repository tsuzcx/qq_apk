import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;

public class bguj
  extends bgug
{
  public int a;
  private long jdField_a_of_type_Long;
  private bgun jdField_a_of_type_Bgun;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public bguj(bgun parambgun)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bgun = parambgun;
  }
  
  public void a(bguf parambguf)
  {
    if (parambguf == null) {}
    label4:
    MiniAppInfo localMiniAppInfo;
    label61:
    label223:
    do
    {
      bgls localbgls;
      Object localObject;
      int j;
      do
      {
        do
        {
          do
          {
            return;
            QMLog.i("minisdk-start_RuntimeState", "onStateChange message:" + parambguf.jdField_a_of_type_Int);
            localbgls = this.jdField_a_of_type_Bgun.getRuntime();
            localMiniAppInfo = this.jdField_a_of_type_Bgun.getMiniAppInfo();
            if (localMiniAppInfo != null)
            {
              i = localMiniAppInfo.getReportType();
              if ((localbgls == null) || (localbgls.a() == null)) {
                break label223;
              }
            }
            for (localObject = bgml.a(localbgls).a();; localObject = null) {
              switch (parambguf.jdField_a_of_type_Int)
              {
              default: 
                return;
              case 3: 
                if (!this.jdField_a_of_type_Boolean) {
                  break label4;
                }
                this.jdField_b_of_type_Boolean = true;
                return;
                i = 0;
                break label61;
              }
            }
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            if (localMiniAppInfo != null)
            {
              parambguf = localMiniAppInfo.appId;
              if (localMiniAppInfo == null) {
                break label321;
              }
            }
            for (localObject = localMiniAppInfo.name;; localObject = "")
            {
              QMLog.i("minisdk-start_RuntimeState", "[" + parambguf + "][" + (String)localObject + "] 启动(MiniActivity onCreate)");
              bhck.a(localMiniAppInfo, 24, String.valueOf(i));
              this.jdField_a_of_type_Int = 0;
              return;
              parambguf = "";
              break;
            }
            this.jdField_a_of_type_Int = 1;
            localObject = new StringBuilder().append("--- report load appid:");
            if (localMiniAppInfo != null) {}
            for (parambguf = localMiniAppInfo.appId;; parambguf = Integer.valueOf(0))
            {
              QMLog.i("minisdk-start_RuntimeState", parambguf);
              bhbs.a("2load", null, null, localMiniAppInfo);
              return;
            }
            this.jdField_a_of_type_Int = 2;
          } while (this.d);
          this.d = true;
          long l1;
          long l2;
          if ((localbgls != null) && (localMiniAppInfo != null))
          {
            QMLog.i("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
            bhbs.a("2launch", "first_frame", (String)localObject, localMiniAppInfo);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label578;
            }
            parambguf = localMiniAppInfo.launchParam.entryPath;
            bhck.a(localMiniAppInfo, 21, parambguf, null, null, 0);
            l1 = System.currentTimeMillis();
            l2 = this.jdField_a_of_type_Long;
            j = this.jdField_b_of_type_Int;
            if (i != 0) {
              break label584;
            }
          }
          for (parambguf = "0";; parambguf = "1")
          {
            bhck.a(localMiniAppInfo, 1043, null, null, null, j, parambguf, l1 - l2, null);
            parambguf = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            if ((this.c) && (parambguf.isDebugVersion())) {
              bgrm.a(AppLoaderFactory.g().getMiniAppEnv().getContext(), "进入native小程序,仅debug可见", 0).a();
            }
            parambguf.notifyMiniAppInfo(1, localMiniAppInfo);
            return;
            parambguf = (bguf)localObject;
            break;
          }
        } while (localMiniAppInfo == null);
        QMLog.i("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
        bhbs.a("2show", "bring_to_front", (String)localObject, localMiniAppInfo);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (parambguf = localMiniAppInfo.launchParam.entryPath;; parambguf = (bguf)localObject)
        {
          bhck.a(localMiniAppInfo, 1, parambguf, null, null, 0);
          if (localbgls == null) {
            break;
          }
          QMLog.i("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
          bhbs.a("2launch", "click_resume", (String)localObject, localMiniAppInfo);
          bhck.a(localMiniAppInfo, 21, parambguf, null, null, 0);
          return;
        }
      } while (localMiniAppInfo == null);
      QMLog.i("minisdk-start_RuntimeState", "--- report launch fail appid:" + localMiniAppInfo.appId);
      bhbs.a("2launch_fail", "flutter_sdk_fail", (String)localObject, localMiniAppInfo);
      return;
      bhbs.a("2close", "loading_page", null, localMiniAppInfo);
      return;
      bhbs.a("2close", "inner_page", (String)localObject, localMiniAppInfo);
      if ((this.jdField_a_of_type_Bgun.isLoadSucceed()) && (localbgls != null) && (localbgls.b()))
      {
        bhck.a(localMiniAppInfo, 1025, "1");
        return;
      }
      bhck.a(localMiniAppInfo, 1026, "1");
      return;
      bhbs.a("2unload", null, (String)localObject, localMiniAppInfo);
      return;
      bhbs.a("2hide", null, (String)localObject, localMiniAppInfo);
      bhck.a(localMiniAppInfo, 20, "" + i);
      return;
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label955;
        }
        if (this.jdField_a_of_type_Int != 0) {
          break label931;
        }
        bhcn.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
      while (this.d)
      {
        bhbs.a("2back_key", "inner_page", (String)localObject, localMiniAppInfo);
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          bhcn.a(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
          continue;
          QMLog.e("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
        }
      }
      bhbs.a("2back_key", "loading_page", (String)localObject, localMiniAppInfo);
      return;
      if (parambguf.jdField_a_of_type_JavaLangObject != null) {}
      for (int i = ((Integer)parambguf.jdField_a_of_type_JavaLangObject).intValue();; i = 0)
      {
        j = i;
        if (i >= 0) {
          j = 0;
        }
        this.jdField_b_of_type_Int = j;
        return;
      }
      if (localMiniAppInfo == null) {
        break;
      }
    } while ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1));
    label321:
    label578:
    label584:
    bhcn.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
    label931:
    label955:
    bhbs.a("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
    return;
    QMLog.e("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguj
 * JD-Core Version:    0.7.0.1
 */