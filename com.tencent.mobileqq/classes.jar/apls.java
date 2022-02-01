import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class apls
  implements aplr
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
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    int i = 0;
    if (paramColorNote.getServiceType() != 16842752) {
      return;
    }
    String str = paramColorNote.getSubType();
    paramColorNote = paramColorNote.getReserve();
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "openColorNoteMiniAppByAppInfo", 0) == 1) {
      i = 1;
    }
    if ((paramColorNote != null) && (paramColorNote.length > 0) && (i != 0))
    {
      paramColorNote = MiniAppUtils.createFromBuffer(paramColorNote);
      if ((paramColorNote != null) && (!TextUtils.isEmpty(paramColorNote.desc))) {
        try
        {
          MiniAppController.launchMiniAppByAppInfo(null, paramColorNote, 1131);
          return;
        }
        catch (Exception paramColorNote)
        {
          QLog.e("MiniAppLauncher_colorNote", 1, "MiniAppLauncher, launch exception: " + Log.getStackTraceString(paramColorNote));
          a(paramContext, str);
          return;
        }
      }
      a(paramContext, str);
      return;
    }
    a(paramContext, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apls
 * JD-Core Version:    0.7.0.1
 */