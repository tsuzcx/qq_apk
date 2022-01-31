import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import dov.com.tencent.mobileqq.shortvideo.PtuTemplate.PtuTemplateManager.3;
import mqq.os.MqqHandler;

public class bnko
{
  public static String a;
  private static final String b = alpo.a(2131709108);
  
  public static boolean a()
  {
    boolean bool = false;
    if (blev.a().a("key_ae_res_1", 0, 4) >= 77) {
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
    if ((a(paramVideoMaterial)) && ((!ayzn.a) || (!a())))
    {
      if (!bdee.h(paramActivity)) {
        ThreadManager.getUIHandler().post(new PtuTemplateManager.3(paramActivity, paramString));
      }
      for (;;)
      {
        return true;
        blfg.b("PtuTemplateManager", "【Camera is in Prepareing wifi】prepare to download");
        b(paramString);
      }
    }
    blfg.d("PtuTemplateManager", "【Camera is in Prepareing Error】PTU_RES_DOWNLOADED: " + ayzn.a);
    blfg.d("PtuTemplateManager", "【Camera is in Prepareing Error】isSpecialTemplate: " + a(paramVideoMaterial));
    return false;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, bnlu parambnlu, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!ayzn.a) && (a(paramVideoMaterial)))
    {
      if (!bdee.h(paramActivity)) {
        bdcd.a(paramActivity, 230).setMessage(b).setPositiveButton(paramActivity.getString(2131694205), new bnkq(paramString)).setNegativeButton(paramActivity.getString(2131694201), new bnkp()).show();
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
      parambnlu.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      a = null;
      return false;
      label120:
      parambnlu.a();
    }
  }
  
  private static void b(Context paramContext, String paramString)
  {
    Bundle localBundle = azfj.a().a("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || ((!a()) && (bkwi.a().a(bkwh.c) == 4)))
    {
      bdcd.a(paramContext, 230).setMessage(b).setPositiveButton(paramContext.getString(2131694205), new bnks(paramString)).setNegativeButton(paramContext.getString(2131694201), new bnkr()).show();
      return;
    }
    QQToast.a(paramContext, 2131689781, 1).a();
  }
  
  private static void b(String paramString)
  {
    a = paramString;
    azfj.a().a("CMD_DOWNLOAD_PTU_ADDITIONAL_RES", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnko
 * JD-Core Version:    0.7.0.1
 */