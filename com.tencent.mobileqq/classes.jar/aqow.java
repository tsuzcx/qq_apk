import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;

public class aqow
  implements aqov
{
  private void a(Context paramContext, String paramString)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = 1131;
    MiniAppController.startAppByAppid(paramContext, paramString, "", "", localLaunchParam, null);
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher_colorNote", 2, "startMiniAppByAppId, appId: " + paramString);
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt;
    localLaunchParam.entryPath = paramString3;
    localLaunchParam.standardize();
    MiniAppController.startAppByAppid(paramContext, paramString1, "", paramString2, localLaunchParam, null);
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher_colorNote", 2, "startMiniApp, appId: " + paramString1 + ", entryPath: " + paramString3 + ", versionType: " + paramString2 + ", colorSignScene: " + paramInt);
    }
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject1 = null;
    if (paramColorNote.getServiceType() != 16842752) {
      return;
    }
    int i;
    if (paramColorNote.getSubTitle().contains("最近浏览"))
    {
      i = 1132;
      MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "click", null);
    }
    String str;
    for (;;)
    {
      str = paramColorNote.getSubType();
      if (!str.contains(".")) {
        break;
      }
      Object localObject2 = str.split("\\.");
      str = localObject2[0];
      localObject2 = localObject2[1];
      byte[] arrayOfByte = paramColorNote.getReserve();
      paramColorNote = localObject1;
      if (arrayOfByte != null)
      {
        paramColorNote = localObject1;
        if (arrayOfByte.length > 0) {
          paramColorNote = new String(arrayOfByte);
        }
      }
      a(paramContext, str, (String)localObject2, paramColorNote, i);
      return;
      i = 1131;
      MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "click", null);
    }
    a(paramContext, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqow
 * JD-Core Version:    0.7.0.1
 */