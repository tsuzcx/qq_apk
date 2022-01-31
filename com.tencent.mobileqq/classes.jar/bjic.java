import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;

public class bjic
{
  public static String a;
  private static final String b = ajjy.a(2131642940);
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    return (VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isSegmentMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) || (VideoMaterialUtil.needVoiceChange(paramVideoMaterial)) || (VideoMaterialUtil.isParticleMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isRapidNetMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isGenderDetect(paramVideoMaterial)) || (VideoMaterialUtil.isEmotionDectectMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isPagMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isHairSegMaterial(paramVideoMaterial)) || (VideoMaterialUtil.is3DMaterial(paramVideoMaterial)) || (VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial));
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, Activity paramActivity, String paramString)
  {
    if ((!awex.a) && (a(paramVideoMaterial)))
    {
      if (!badq.h(paramActivity)) {
        babr.a(paramActivity, 230).setMessage(b).setPositiveButton(paramActivity.getString(2131628445), new bjig(paramString)).setNegativeButton(paramActivity.getString(2131628441), new bjif()).show();
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
    return false;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial, bjji parambjji, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!awex.a) && (a(paramVideoMaterial)))
    {
      if (!badq.h(paramActivity)) {
        babr.a(paramActivity, 230).setMessage(b).setPositiveButton(paramActivity.getString(2131628445), new bjie(paramString)).setNegativeButton(paramActivity.getString(2131628441), new bjid()).show();
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
      parambjji.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      a = null;
      return false;
      label120:
      parambjji.a();
    }
  }
  
  private static void b(String paramString)
  {
    a = paramString;
    paramString = awkv.a().a("CMD_DOWNLOAD_PTU_RES", new Bundle());
    if ((paramString != null) && (paramString.getBoolean("VALUE_MSG_DOWNLOAD_PTU_RES", false))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtuTemplateManager", 2, new Object[] { "VideoPlayIPCClient, CMD_DOWNLOAD_PTU_RES return ", Boolean.valueOf(bool) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjic
 * JD-Core Version:    0.7.0.1
 */