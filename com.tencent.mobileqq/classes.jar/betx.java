import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.1;
import java.util.concurrent.TimeUnit;

public class betx
{
  private static final int jdField_a_of_type_Int = bema.a("MiniApp", "mini_game_judge_timing_request_begin_delay", 1000);
  private static long jdField_a_of_type_Long;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static final String jdField_a_of_type_JavaLangString = bema.a("MiniApp", "enable_heart_beat_scene_whitelist", "");
  private static final String b = bema.a("MiniApp", "enable_heart_beat_appid_whitelist", "");
  private static final String c = bema.a("MiniApp", "enable_heart_beat_via_whitelist", "");
  
  public static void a(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    bejn.c().postDelayed(new GameGrowthGuardianManager.1(paramContext, paramMiniAppInfo), jdField_a_of_type_Int);
  }
  
  private static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = false;
    if (paramMiniAppInfo != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (paramMiniAppInfo.launchParam == null) {
          break label260;
        }
        i = paramMiniAppInfo.launchParam.jdField_a_of_type_Int;
        if (paramMiniAppInfo != null)
        {
          str1 = paramMiniAppInfo.via;
          if ((i == 2093) || ("2016_4".equals(str1))) {
            break label267;
          }
          if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
          {
            arrayOfString = jdField_a_of_type_JavaLangString.split(",");
            if (arrayOfString != null)
            {
              int k = arrayOfString.length;
              j = 0;
              if (j < k)
              {
                if (i != Integer.parseInt(arrayOfString[j])) {
                  break label273;
                }
                return true;
              }
            }
          }
          if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null) && (!TextUtils.isEmpty(b)))
          {
            arrayOfString = b.split(",");
            if (arrayOfString != null)
            {
              j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str2 = arrayOfString[i];
                if (!paramMiniAppInfo.appId.equals(str2)) {
                  break label280;
                }
                return true;
              }
            }
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(c)) {
            break label270;
          }
          paramMiniAppInfo = c.split(",");
          bool1 = bool2;
          if (paramMiniAppInfo == null) {
            break label270;
          }
          j = paramMiniAppInfo.length;
          i = 0;
          bool1 = bool2;
          if (i >= j) {
            break label270;
          }
          String[] arrayOfString = paramMiniAppInfo[i];
          if (arrayOfString != null)
          {
            bool1 = arrayOfString.equals(str1);
            if (bool1) {
              return true;
            }
          }
          i += 1;
          continue;
        }
        String str1 = null;
      }
      catch (Exception paramMiniAppInfo)
      {
        betc.d("GameGrowthGuardianManager", "enableHeartBeatForLaunchScene", paramMiniAppInfo);
        return false;
      }
      continue;
      label260:
      int i = 9999;
      continue;
      label267:
      boolean bool1 = true;
      label270:
      return bool1;
      label273:
      j += 1;
      continue;
      label280:
      i += 1;
    }
  }
  
  public static void b(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    b(paramContext, paramMiniAppInfo, 13);
    if (jdField_a_of_type_JavaLangRunnable != null)
    {
      bejn.c().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
      jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  private static void b(Context paramContext, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if ((paramContext == null) || (paramMiniAppInfo == null)) {}
    while (!b(paramMiniAppInfo)) {
      return;
    }
    String str2 = beze.a(paramMiniAppInfo);
    String str1;
    int i;
    label44:
    int j;
    label60:
    int k;
    label69:
    ChannelProxy localChannelProxy;
    long l;
    if (paramMiniAppInfo.appId != null)
    {
      str1 = paramMiniAppInfo.appId;
      if (!paramMiniAppInfo.isEngineTypeMiniGame()) {
        break label148;
      }
      i = 1;
      if (paramMiniAppInfo.launchParam == null) {
        break label153;
      }
      j = paramMiniAppInfo.launchParam.jdField_a_of_type_Int;
      if (paramInt != 11) {
        break label159;
      }
      k = 0;
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (str2 == null) {
        break label178;
      }
      label95:
      if (paramMiniAppInfo.via == null) {
        break label185;
      }
    }
    label148:
    label153:
    label159:
    label178:
    label185:
    for (String str3 = paramMiniAppInfo.via;; str3 = "")
    {
      localChannelProxy.JudgeTiming(str1, i, j, paramInt, l, k, str2, 0, str3, new bety(paramContext, paramMiniAppInfo, paramInt));
      return;
      str1 = "";
      break;
      i = 0;
      break label44;
      j = 0;
      break label60;
      k = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - jdField_a_of_type_Long);
      break label69;
      str2 = "";
      break label95;
    }
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, INTERFACE.GuardInstruction paramGuardInstruction)
  {
    if ((paramMiniAppInfo == null) || (paramStJudgeTimingRsp == null)) {
      return;
    }
    ChannelProxy localChannelProxy;
    String str;
    int i;
    if ((paramGuardInstruction != null) && (paramGuardInstruction.type.get() == 7))
    {
      paramStJudgeTimingRsp = paramStJudgeTimingRsp.loginTraceId.get();
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      str = paramMiniAppInfo.appId;
      i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (paramGuardInstruction == null) {
        break label103;
      }
    }
    label103:
    for (paramMiniAppInfo = paramGuardInstruction.ruleName.get();; paramMiniAppInfo = "")
    {
      localChannelProxy.ReportExecute(str, i, paramStJudgeTimingRsp, paramMiniAppInfo, new betz());
      return;
      paramStJudgeTimingRsp = paramStJudgeTimingRsp.timingTraceId.get();
      break;
    }
  }
  
  private static boolean b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isEngineTypeMiniGame()) {}
      while ((!paramMiniAppInfo.isEngineTypeMiniGame()) && (a(paramMiniAppInfo))) {
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betx
 * JD-Core Version:    0.7.0.1
 */