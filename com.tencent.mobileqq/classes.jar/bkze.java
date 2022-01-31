import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import dov.com.tencent.mobileqq.shortvideo.PtuTemplate.PtuTemplateManager.3;
import mqq.os.MqqHandler;

public class bkze
{
  public static String a;
  private static final String b = ajya.a(2131708736);
  
  public static boolean a()
  {
    boolean bool = false;
    if (bjaa.a().a("key_ae_res_1", 0, 4) >= 70) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    return (VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isSegmentMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) || (VideoMaterialUtil.needVoiceChange(paramVideoMaterial)) || (VideoMaterialUtil.isParticleMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isRapidNetMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGenderDetect(paramVideoMaterial)) || (VideoMaterialUtil.isEmotionDectectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isPagMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isHairSegMaterial(paramVideoMaterial)) || (VideoMaterialUtil.is3DMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial));
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, Activity paramActivity, String paramString)
  {
    if ((a(paramVideoMaterial)) && ((!axeh.a) || (!a())))
    {
      if (!bbfj.h(paramActivity)) {
        ThreadManager.getUIHandler().post(new PtuTemplateManager.3(paramActivity, paramString));
      }
      for (;;)
      {
        return true;
        bjah.b("PtuTemplateManager", "【Camera is in Prepareing wifi】prepare to download");
        b(paramString);
      }
    }
    bjah.d("PtuTemplateManager", "【Camera is in Prepareing Error】PTU_RES_DOWNLOADED: " + axeh.a);
    bjah.d("PtuTemplateManager", "【Camera is in Prepareing Error】isSpecialTemplate: " + a(paramVideoMaterial));
    return false;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, blak paramblak, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!axeh.a) && (a(paramVideoMaterial)))
    {
      if (!bbfj.h(paramActivity)) {
        bbdj.a(paramActivity, 230).setMessage(b).setPositiveButton(paramActivity.getString(2131694088), new bkzg(paramString)).setNegativeButton(paramActivity.getString(2131694084), new bkzf()).show();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtuTemplateManager", 2, "handleSpecialTempleate true");
        }
        return true;
        b(paramString);
      }
    }
    if (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial))
    {
      if (!VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) {
        break label120;
      }
      paramblak.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      a = null;
      return false;
      label120:
      paramblak.a();
    }
  }
  
  private static void b(Context paramContext, String paramString)
  {
    Bundle localBundle = axkd.a().a("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || ((!a()) && (birq.a().a(1) == 4)))
    {
      bbdj.a(paramContext, 230).setMessage(b).setPositiveButton(paramContext.getString(2131694088), new bkzi(paramString)).setNegativeButton(paramContext.getString(2131694084), new bkzh()).show();
      return;
    }
    bcql.a(paramContext, 2131689780, 1).a();
  }
  
  private static void b(String paramString)
  {
    a = paramString;
    axkd.a().a("CMD_DOWNLOAD_PTU_RES", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkze
 * JD-Core Version:    0.7.0.1
 */