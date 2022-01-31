import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;

public class bgqc
  extends bgpz
{
  public int a;
  private long jdField_a_of_type_Long;
  private bgqg jdField_a_of_type_Bgqg;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public bgqc(bgqg parambgqg)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bgqg = parambgqg;
  }
  
  public void a(bgpy parambgpy)
  {
    if (parambgpy == null) {}
    label4:
    MiniAppInfo localMiniAppInfo;
    label61:
    label223:
    do
    {
      bghl localbghl;
      Object localObject;
      int j;
      do
      {
        do
        {
          do
          {
            return;
            QMLog.i("minisdk-start_RuntimeState", "onStateChange message:" + parambgpy.jdField_a_of_type_Int);
            localbghl = this.jdField_a_of_type_Bgqg.getRuntime();
            localMiniAppInfo = this.jdField_a_of_type_Bgqg.getMiniAppInfo();
            if (localMiniAppInfo != null)
            {
              i = localMiniAppInfo.getReportType();
              if ((localbghl == null) || (localbghl.a() == null)) {
                break label223;
              }
            }
            for (localObject = bgie.a(localbghl).a();; localObject = null) {
              switch (parambgpy.jdField_a_of_type_Int)
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
              parambgpy = localMiniAppInfo.appId;
              if (localMiniAppInfo == null) {
                break label321;
              }
            }
            for (localObject = localMiniAppInfo.name;; localObject = "")
            {
              QMLog.i("minisdk-start_RuntimeState", "[" + parambgpy + "][" + (String)localObject + "] 启动(MiniActivity onCreate)");
              bgyd.a(localMiniAppInfo, 24, String.valueOf(i));
              this.jdField_a_of_type_Int = 0;
              return;
              parambgpy = "";
              break;
            }
            this.jdField_a_of_type_Int = 1;
            localObject = new StringBuilder().append("--- report load appid:");
            if (localMiniAppInfo != null) {}
            for (parambgpy = localMiniAppInfo.appId;; parambgpy = Integer.valueOf(0))
            {
              QMLog.i("minisdk-start_RuntimeState", parambgpy);
              bgxl.a("2load", null, null, localMiniAppInfo);
              return;
            }
            this.jdField_a_of_type_Int = 2;
          } while (this.d);
          this.d = true;
          long l1;
          long l2;
          if ((localbghl != null) && (localMiniAppInfo != null))
          {
            QMLog.i("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
            bgxl.a("2launch", "first_frame", (String)localObject, localMiniAppInfo);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label578;
            }
            parambgpy = localMiniAppInfo.launchParam.entryPath;
            bgyd.a(localMiniAppInfo, 21, parambgpy, null, null, 0);
            l1 = System.currentTimeMillis();
            l2 = this.jdField_a_of_type_Long;
            j = this.jdField_b_of_type_Int;
            if (i != 0) {
              break label584;
            }
          }
          for (parambgpy = "0";; parambgpy = "1")
          {
            bgyd.a(localMiniAppInfo, 1043, null, null, null, j, parambgpy, l1 - l2, null);
            parambgpy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            if ((this.c) && (parambgpy.isDebugVersion())) {
              bgnf.a(AppLoaderFactory.g().getMiniAppEnv().getContext(), "进入native小程序,仅debug可见", 0).a();
            }
            parambgpy.notifyMiniAppInfo(1, localMiniAppInfo);
            return;
            parambgpy = (bgpy)localObject;
            break;
          }
        } while (localMiniAppInfo == null);
        QMLog.i("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
        bgxl.a("2show", "bring_to_front", (String)localObject, localMiniAppInfo);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (parambgpy = localMiniAppInfo.launchParam.entryPath;; parambgpy = (bgpy)localObject)
        {
          bgyd.a(localMiniAppInfo, 1, parambgpy, null, null, 0);
          if (localbghl == null) {
            break;
          }
          QMLog.i("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
          bgxl.a("2launch", "click_resume", (String)localObject, localMiniAppInfo);
          bgyd.a(localMiniAppInfo, 21, parambgpy, null, null, 0);
          return;
        }
      } while (localMiniAppInfo == null);
      QMLog.i("minisdk-start_RuntimeState", "--- report launch fail appid:" + localMiniAppInfo.appId);
      bgxl.a("2launch_fail", "flutter_sdk_fail", (String)localObject, localMiniAppInfo);
      return;
      bgxl.a("2close", "loading_page", null, localMiniAppInfo);
      return;
      bgxl.a("2close", "inner_page", (String)localObject, localMiniAppInfo);
      if ((this.jdField_a_of_type_Bgqg.isLoadSucceed()) && (localbghl != null) && (localbghl.b()))
      {
        bgyd.a(localMiniAppInfo, 1025, "1");
        return;
      }
      bgyd.a(localMiniAppInfo, 1026, "1");
      return;
      bgxl.a("2unload", null, (String)localObject, localMiniAppInfo);
      return;
      bgxl.a("2hide", null, (String)localObject, localMiniAppInfo);
      bgyd.a(localMiniAppInfo, 20, "" + i);
      return;
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label955;
        }
        if (this.jdField_a_of_type_Int != 0) {
          break label931;
        }
        bgyg.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
      while (this.d)
      {
        bgxl.a("2back_key", "inner_page", (String)localObject, localMiniAppInfo);
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          bgyg.a(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
          continue;
          QMLog.e("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
        }
      }
      bgxl.a("2back_key", "loading_page", (String)localObject, localMiniAppInfo);
      return;
      if (parambgpy.jdField_a_of_type_JavaLangObject != null) {}
      for (int i = ((Integer)parambgpy.jdField_a_of_type_JavaLangObject).intValue();; i = 0)
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
    bgyg.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
    label931:
    label955:
    bgxl.a("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
    return;
    QMLog.e("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqc
 * JD-Core Version:    0.7.0.1
 */