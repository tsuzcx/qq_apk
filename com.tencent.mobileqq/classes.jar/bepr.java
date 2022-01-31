import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bepr
  extends bepn
{
  public int a;
  private long jdField_a_of_type_Long;
  private bepv jdField_a_of_type_Bepv;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public bepr(bepv parambepv)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bepv = parambepv;
  }
  
  public void a(bepm parambepm)
  {
    if (parambepm == null) {}
    MiniAppInfo localMiniAppInfo;
    label86:
    label223:
    do
    {
      begw localbegw;
      Object localObject;
      int j;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              besl.b("minisdk-start_RuntimeState", "onStateChange message:" + parambepm.jdField_a_of_type_Int);
              localbegw = this.jdField_a_of_type_Bepv.getRuntime();
              localMiniAppInfo = this.jdField_a_of_type_Bepv.getMiniAppInfo();
              if (localMiniAppInfo != null)
              {
                i = localMiniAppInfo.getReportType();
                if ((localbegw == null) || (localbegw.a() == null)) {
                  break label296;
                }
                localObject = localbegw.a().a();
              }
              switch (parambepm.jdField_a_of_type_Int)
              {
              default: 
                return;
              case 1: 
                this.jdField_a_of_type_Long = System.currentTimeMillis();
                if (localMiniAppInfo != null)
                {
                  parambepm = localMiniAppInfo.appId;
                  if (localMiniAppInfo == null) {
                    break label308;
                  }
                }
                for (localObject = localMiniAppInfo.name;; localObject = "")
                {
                  besl.b("minisdk-start_RuntimeState", "[" + parambepm + "][" + (String)localObject + "] 启动(MiniActivity onCreate)");
                  beyr.a(localMiniAppInfo, 24, String.valueOf(i));
                  this.jdField_a_of_type_Int = 0;
                  return;
                  i = 0;
                  break;
                  localObject = null;
                  break label86;
                  parambepm = "";
                  break label223;
                }
              }
            } while (!this.jdField_a_of_type_Boolean);
            this.jdField_b_of_type_Boolean = true;
            return;
            this.jdField_a_of_type_Int = 1;
            localObject = new StringBuilder().append("--- report load appid:");
            if (localMiniAppInfo != null) {}
            for (parambepm = localMiniAppInfo.appId;; parambepm = Integer.valueOf(0))
            {
              besl.b("minisdk-start_RuntimeState", parambepm);
              bexz.a("2load", null, null, localMiniAppInfo);
              return;
            }
            this.jdField_a_of_type_Int = 2;
          } while (this.d);
          this.d = true;
          long l1;
          long l2;
          if ((localbegw != null) && (localMiniAppInfo != null))
          {
            besl.b("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
            bexz.a("2launch", "first_frame", (String)localObject, localMiniAppInfo);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label564;
            }
            parambepm = localMiniAppInfo.launchParam.c;
            beyr.a(localMiniAppInfo, 21, parambepm, null, null, 0);
            l1 = System.currentTimeMillis();
            l2 = this.jdField_a_of_type_Long;
            j = this.jdField_b_of_type_Int;
            if (i != 0) {
              break label570;
            }
          }
          for (parambepm = "0";; parambepm = "1")
          {
            beyr.a(localMiniAppInfo, 1043, null, null, null, j, parambepm, l1 - l2, null);
            if ((!this.c) || (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())) {
              break;
            }
            bemw.a(MiniAppEnv.g().getContext(), "进入native小程序,仅debug可见", 0).a();
            return;
            parambepm = (bepm)localObject;
            break label473;
          }
        } while (localMiniAppInfo == null);
        besl.b("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
        bexz.a("2show", "bring_to_front", (String)localObject, localMiniAppInfo);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (parambepm = localMiniAppInfo.launchParam.c;; parambepm = (bepm)localObject)
        {
          beyr.a(localMiniAppInfo, 1, parambepm, null, null, 0);
          if (localbegw == null) {
            break;
          }
          besl.b("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
          bexz.a("2launch", "click_resume", (String)localObject, localMiniAppInfo);
          beyr.a(localMiniAppInfo, 21, parambepm, null, null, 0);
          return;
        }
      } while (localMiniAppInfo == null);
      besl.b("minisdk-start_RuntimeState", "--- report launch fail appid:" + localMiniAppInfo.appId);
      bexz.a("2launch_fail", "flutter_sdk_fail", (String)localObject, localMiniAppInfo);
      return;
      bexz.a("2close", "loading_page", null, localMiniAppInfo);
      return;
      bexz.a("2close", "inner_page", (String)localObject, localMiniAppInfo);
      if ((this.jdField_a_of_type_Bepv.isLoadSucceed()) && (localbegw != null) && (localbegw.e()))
      {
        beyr.a(localMiniAppInfo, 1025, "1");
        return;
      }
      beyr.a(localMiniAppInfo, 1026, "1");
      return;
      bexz.a("2unload", null, (String)localObject, localMiniAppInfo);
      return;
      bexz.a("2hide", null, (String)localObject, localMiniAppInfo);
      beyr.a(localMiniAppInfo, 20, "" + i);
      return;
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label940;
        }
        if (this.jdField_a_of_type_Int != 0) {
          break label917;
        }
        beyu.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
      while (this.d)
      {
        bexz.a("2back_key", "inner_page", (String)localObject, localMiniAppInfo);
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          beyu.a(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
          continue;
          besl.d("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
        }
      }
      bexz.a("2back_key", "loading_page", (String)localObject, localMiniAppInfo);
      return;
      if (parambepm.jdField_a_of_type_JavaLangObject != null) {}
      for (int i = ((Integer)parambepm.jdField_a_of_type_JavaLangObject).intValue();; i = 0)
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
    label296:
    label308:
    label473:
    beyu.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
    label564:
    label570:
    bexz.a("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
    label917:
    label940:
    return;
    besl.d("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepr
 * JD-Core Version:    0.7.0.1
 */