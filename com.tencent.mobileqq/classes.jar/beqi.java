import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class beqi
  extends beqe
{
  public int a;
  private long jdField_a_of_type_Long;
  private beqm jdField_a_of_type_Beqm;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public beqi(beqm parambeqm)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Beqm = parambeqm;
  }
  
  public void a(beqd parambeqd)
  {
    if (parambeqd == null) {}
    MiniAppInfo localMiniAppInfo;
    label86:
    label223:
    do
    {
      behn localbehn;
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
              betc.b("minisdk-start_RuntimeState", "onStateChange message:" + parambeqd.jdField_a_of_type_Int);
              localbehn = this.jdField_a_of_type_Beqm.getRuntime();
              localMiniAppInfo = this.jdField_a_of_type_Beqm.getMiniAppInfo();
              if (localMiniAppInfo != null)
              {
                i = localMiniAppInfo.getReportType();
                if ((localbehn == null) || (localbehn.a() == null)) {
                  break label296;
                }
                localObject = localbehn.a().a();
              }
              switch (parambeqd.jdField_a_of_type_Int)
              {
              default: 
                return;
              case 1: 
                this.jdField_a_of_type_Long = System.currentTimeMillis();
                if (localMiniAppInfo != null)
                {
                  parambeqd = localMiniAppInfo.appId;
                  if (localMiniAppInfo == null) {
                    break label308;
                  }
                }
                for (localObject = localMiniAppInfo.name;; localObject = "")
                {
                  betc.b("minisdk-start_RuntimeState", "[" + parambeqd + "][" + (String)localObject + "] 启动(MiniActivity onCreate)");
                  bezi.a(localMiniAppInfo, 24, String.valueOf(i));
                  this.jdField_a_of_type_Int = 0;
                  return;
                  i = 0;
                  break;
                  localObject = null;
                  break label86;
                  parambeqd = "";
                  break label223;
                }
              }
            } while (!this.jdField_a_of_type_Boolean);
            this.jdField_b_of_type_Boolean = true;
            return;
            this.jdField_a_of_type_Int = 1;
            localObject = new StringBuilder().append("--- report load appid:");
            if (localMiniAppInfo != null) {}
            for (parambeqd = localMiniAppInfo.appId;; parambeqd = Integer.valueOf(0))
            {
              betc.b("minisdk-start_RuntimeState", parambeqd);
              beyq.a("2load", null, null, localMiniAppInfo);
              return;
            }
            this.jdField_a_of_type_Int = 2;
          } while (this.d);
          this.d = true;
          long l1;
          long l2;
          if ((localbehn != null) && (localMiniAppInfo != null))
          {
            betc.b("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
            beyq.a("2launch", "first_frame", (String)localObject, localMiniAppInfo);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label564;
            }
            parambeqd = localMiniAppInfo.launchParam.c;
            bezi.a(localMiniAppInfo, 21, parambeqd, null, null, 0);
            l1 = System.currentTimeMillis();
            l2 = this.jdField_a_of_type_Long;
            j = this.jdField_b_of_type_Int;
            if (i != 0) {
              break label570;
            }
          }
          for (parambeqd = "0";; parambeqd = "1")
          {
            bezi.a(localMiniAppInfo, 1043, null, null, null, j, parambeqd, l1 - l2, null);
            if ((!this.c) || (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())) {
              break;
            }
            benn.a(MiniAppEnv.g().getContext(), "进入native小程序,仅debug可见", 0).a();
            return;
            parambeqd = (beqd)localObject;
            break label473;
          }
        } while (localMiniAppInfo == null);
        betc.b("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
        beyq.a("2show", "bring_to_front", (String)localObject, localMiniAppInfo);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (parambeqd = localMiniAppInfo.launchParam.c;; parambeqd = (beqd)localObject)
        {
          bezi.a(localMiniAppInfo, 1, parambeqd, null, null, 0);
          if (localbehn == null) {
            break;
          }
          betc.b("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
          beyq.a("2launch", "click_resume", (String)localObject, localMiniAppInfo);
          bezi.a(localMiniAppInfo, 21, parambeqd, null, null, 0);
          return;
        }
      } while (localMiniAppInfo == null);
      betc.b("minisdk-start_RuntimeState", "--- report launch fail appid:" + localMiniAppInfo.appId);
      beyq.a("2launch_fail", "flutter_sdk_fail", (String)localObject, localMiniAppInfo);
      return;
      beyq.a("2close", "loading_page", null, localMiniAppInfo);
      return;
      beyq.a("2close", "inner_page", (String)localObject, localMiniAppInfo);
      if ((this.jdField_a_of_type_Beqm.isLoadSucceed()) && (localbehn != null) && (localbehn.e()))
      {
        bezi.a(localMiniAppInfo, 1025, "1");
        return;
      }
      bezi.a(localMiniAppInfo, 1026, "1");
      return;
      beyq.a("2unload", null, (String)localObject, localMiniAppInfo);
      return;
      beyq.a("2hide", null, (String)localObject, localMiniAppInfo);
      bezi.a(localMiniAppInfo, 20, "" + i);
      return;
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label940;
        }
        if (this.jdField_a_of_type_Int != 0) {
          break label917;
        }
        bezl.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
      while (this.d)
      {
        beyq.a("2back_key", "inner_page", (String)localObject, localMiniAppInfo);
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          bezl.a(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
          continue;
          betc.d("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
        }
      }
      beyq.a("2back_key", "loading_page", (String)localObject, localMiniAppInfo);
      return;
      if (parambeqd.jdField_a_of_type_JavaLangObject != null) {}
      for (int i = ((Integer)parambeqd.jdField_a_of_type_JavaLangObject).intValue();; i = 0)
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
    bezl.a(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
    label564:
    label570:
    beyq.a("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
    label917:
    label940:
    return;
    betc.d("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqi
 * JD-Core Version:    0.7.0.1
 */