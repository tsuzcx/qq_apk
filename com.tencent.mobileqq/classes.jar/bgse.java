import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.1;
import java.util.concurrent.TimeUnit;

public class bgse
{
  private static final int jdField_a_of_type_Int = bglq.a("qqminiapp", "mini_game_judge_timing_request_begin_delay", 1000);
  private static long jdField_a_of_type_Long;
  private static COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private static bgtb jdField_a_of_type_Bgtb;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static final String jdField_a_of_type_JavaLangString = bglq.a("qqminiapp", "enable_heart_beat_scene_whitelist", "");
  private static boolean jdField_a_of_type_Boolean;
  private static final String b = bglq.a("qqminiapp", "enable_heart_beat_appid_whitelist", "");
  private static final String c = bglq.a("qqminiapp", "enable_heart_beat_via_whitelist", "");
  
  public static void a()
  {
    jdField_a_of_type_Bgtb = null;
  }
  
  public static void a(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    jdField_a_of_type_Boolean = true;
    ThreadManager.c().postDelayed(new GameGrowthGuardianManager.1(paramMiniAppInfo, paramContext), jdField_a_of_type_Int);
  }
  
  public static void a(bgtb parambgtb)
  {
    jdField_a_of_type_Bgtb = parambgtb;
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
        i = paramMiniAppInfo.launchParam.scene;
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
        QMLog.e("GameGrowthGuardianManager", "enableHeartBeatForLaunchScene", paramMiniAppInfo);
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
    jdField_a_of_type_Boolean = false;
    b(paramContext, paramMiniAppInfo, 13);
    if (jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.c().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
      jdField_a_of_type_JavaLangRunnable = null;
    }
    if (jdField_a_of_type_Bgtb != null) {
      jdField_a_of_type_Bgtb.a();
    }
  }
  
  private static void b(Context paramContext, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if ((paramContext == null) || (paramMiniAppInfo == null)) {}
    do
    {
      return;
      if ((!jdField_a_of_type_Boolean) && ((paramInt == 11) || (paramInt == 12)))
      {
        QMLog.e("GameGrowthGuardianManager", "not in foreground, not allowed to send begin or heartbeat protocol");
        return;
      }
    } while (!b(paramMiniAppInfo));
    String str2 = bgxz.a(paramMiniAppInfo);
    String str1;
    int i;
    label70:
    int j;
    label86:
    int k;
    label95:
    ChannelProxy localChannelProxy;
    long l;
    if (paramMiniAppInfo.appId != null)
    {
      str1 = paramMiniAppInfo.appId;
      if (!paramMiniAppInfo.isEngineTypeMiniGame()) {
        break label181;
      }
      i = 1;
      if (paramMiniAppInfo.launchParam == null) {
        break label186;
      }
      j = paramMiniAppInfo.launchParam.scene;
      if (paramInt != 11) {
        break label192;
      }
      k = 0;
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (str2 == null) {
        break label211;
      }
      label121:
      if (paramMiniAppInfo.via == null) {
        break label218;
      }
    }
    label181:
    label186:
    label192:
    label211:
    label218:
    for (String str3 = paramMiniAppInfo.via;; str3 = "")
    {
      localChannelProxy.JudgeTiming(str1, i, j, paramInt, l, k, str2, 0, str3, paramMiniAppInfo.gameAdsTotalTime, jdField_a_of_type_NS_COMMCOMM$StCommonExt, new bgsf(paramContext, paramMiniAppInfo, paramInt));
      return;
      str1 = "";
      break;
      i = 0;
      break label70;
      j = 0;
      break label86;
      k = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - jdField_a_of_type_Long);
      break label95;
      str2 = "";
      break label121;
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
      localChannelProxy.ReportExecute(str, i, paramStJudgeTimingRsp, paramMiniAppInfo, new bgsg());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgse
 * JD-Core Version:    0.7.0.1
 */