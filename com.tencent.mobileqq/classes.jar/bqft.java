import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;

public class bqft
{
  public static String a;
  public static boolean a;
  
  public static boolean a(VideoMaterial paramVideoMaterial, bqgu parambqgu, AudioCapture paramAudioCapture, Activity paramActivity, String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (bnpc.a(paramVideoMaterial)))
    {
      if (!bgnt.h(paramActivity)) {
        bglp.a(paramActivity, 230).setMessage(bnpy.jdField_a_of_type_JavaLangString).setPositiveButton(paramActivity.getString(2131693473), new bqfv(paramString)).setNegativeButton(paramActivity.getString(2131693469), new bqfu()).show();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtuTemplateManager", 2, "handleSpecialTempleate true");
        }
        return true;
        jdField_a_of_type_JavaLangString = paramString;
        bnpy.a();
      }
    }
    if (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial))
    {
      if (!VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial)) {
        break label123;
      }
      parambqgu.a(paramActivity, paramAudioCapture);
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = null;
      return false;
      label123:
      parambqgu.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqft
 * JD-Core Version:    0.7.0.1
 */