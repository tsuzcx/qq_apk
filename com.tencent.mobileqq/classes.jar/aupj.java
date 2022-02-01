import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class aupj
{
  public static void a(Context paramContext, INTERFACE.StApiAppInfo paramStApiAppInfo, String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramStApiAppInfo != null) && (!TextUtils.isEmpty(paramStApiAppInfo.appId.get()))) {
      if (paramBoolean)
      {
        MiniAppCmdUtil.getInstance().createUpdatableMsg(paramStApiAppInfo.appId.get(), "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, paramString, new aupk(paramContext, paramString));
        paramContext = "page_view";
        if (paramInt != 2064) {}
      }
    }
    do
    {
      paramContext = "c2close";
      for (;;)
      {
        paramStApiAppInfo = new MiniAppConfig(MiniAppInfo.from(paramStApiAppInfo));
        paramStApiAppInfo.launchParam.scene = paramInt;
        MiniProgramLpReportDC04239.reportAsync(paramStApiAppInfo, paramContext, "click", null, null);
        return;
        if (paramInt == 2062) {
          paramContext = "id_card";
        }
      }
      MiniAppLauncher.launchMiniAppById(paramContext, paramStApiAppInfo.appId.get(), null, null, null, null, paramInt);
      return;
      QLog.e("MiniGamePlayTogetherHandler", 1, new Object[] { "onPlayClick param error context:", paramContext, ", appInfo=", paramStApiAppInfo });
    } while (paramContext == null);
    paramContext = (Activity)paramContext;
    paramContext.runOnUiThread(new MiniGamePlayTogetherHandler.2(paramContext));
  }
  
  public static boolean a(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if ((paramStApiAppInfo == null) || (paramStApiAppInfo.extInfo == null) || (paramStApiAppInfo.extInfo.mapInfo == null)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramStApiAppInfo.extInfo.mapInfo.size())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStApiAppInfo.extInfo.mapInfo.get(i);
        if ((localEntry != null) && ("battle_attr".equals(localEntry.key.get()))) {
          return "1".equals(localEntry.value.get());
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupj
 * JD-Core Version:    0.7.0.1
 */