import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;

public class brhe
{
  public static String a;
  public static boolean a;
  
  public static boolean a(VideoMaterial paramVideoMaterial, brig parambrig, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (boqr.a(paramVideoMaterial)))
    {
      if (!bhnv.h(paramActivity)) {
        bhlq.a(paramActivity, 230).setMessage(bork.jdField_a_of_type_JavaLangString).setPositiveButton(paramActivity.getString(2131693485), new brhg(paramString)).setNegativeButton(paramActivity.getString(2131693481), new brhf()).show();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtuTemplateManager", 2, "handleSpecialTempleate true");
        }
        return true;
        jdField_a_of_type_JavaLangString = paramString;
        bork.a();
      }
    }
    if (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial))
    {
      if (!VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) {
        break label123;
      }
      parambrig.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = null;
      return false;
      label123:
      parambrig.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhe
 * JD-Core Version:    0.7.0.1
 */