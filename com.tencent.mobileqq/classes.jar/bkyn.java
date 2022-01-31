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

public class bkyn
{
  public static String a;
  private static final String b = ajyc.a(2131708725);
  
  public static boolean a()
  {
    boolean bool = false;
    if (bizj.a().a("key_ae_res_1", 0, 4) >= 70) {
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
    if ((a(paramVideoMaterial)) && ((!axef.a) || (!a())))
    {
      if (!bbev.h(paramActivity)) {
        ThreadManager.getUIHandler().post(new PtuTemplateManager.3(paramActivity, paramString));
      }
      for (;;)
      {
        return true;
        bizq.b("PtuTemplateManager", "【Camera is in Prepareing wifi】prepare to download");
        b(paramString);
      }
    }
    bizq.d("PtuTemplateManager", "【Camera is in Prepareing Error】PTU_RES_DOWNLOADED: " + axef.a);
    bizq.d("PtuTemplateManager", "【Camera is in Prepareing Error】isSpecialTemplate: " + a(paramVideoMaterial));
    return false;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, bkzt parambkzt, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!axef.a) && (a(paramVideoMaterial)))
    {
      if (!bbev.h(paramActivity)) {
        bbcv.a(paramActivity, 230).setMessage(b).setPositiveButton(paramActivity.getString(2131694087), new bkyp(paramString)).setNegativeButton(paramActivity.getString(2131694083), new bkyo()).show();
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
      parambkzt.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      a = null;
      return false;
      label120:
      parambkzt.a();
    }
  }
  
  private static void b(Context paramContext, String paramString)
  {
    Bundle localBundle = axkb.a().a("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || ((!a()) && (biqz.a().a(1) == 4)))
    {
      bbcv.a(paramContext, 230).setMessage(b).setPositiveButton(paramContext.getString(2131694087), new bkyr(paramString)).setNegativeButton(paramContext.getString(2131694083), new bkyq()).show();
      return;
    }
    bcpw.a(paramContext, 2131689780, 1).a();
  }
  
  private static void b(String paramString)
  {
    a = paramString;
    axkb.a().a("CMD_DOWNLOAD_PTU_RES", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkyn
 * JD-Core Version:    0.7.0.1
 */