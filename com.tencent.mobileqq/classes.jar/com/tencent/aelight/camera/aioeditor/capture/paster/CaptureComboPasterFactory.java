package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureComboMusic;
import com.tencent.aelight.camera.aioeditor.capture.text.CaptureComboText;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import java.util.List;

public class CaptureComboPasterFactory
{
  public static CaptureComboBase a(String paramString)
  {
    return new CaptureComboMusic(Integer.valueOf(paramString).intValue());
  }
  
  public static CaptureComboBase a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    FacePackage localFacePackage = ((PasterDataManager)QIMManager.a(4)).a(paramString2);
    if ((localFacePackage instanceof NormalFacePackage)) {
      return new CaptureComboNormalPaster((NormalFacePackage)localFacePackage, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localFacePackage instanceof LocationFacePackage)) {
      return new CaptureComboLocationPaster((LocationFacePackage)localFacePackage, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localFacePackage instanceof InformationFacePackage)) {
      return new CaptureComboInformationPaster((InformationFacePackage)localFacePackage, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static CaptureComboBase a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new CaptureComboText(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static CaptureComboBase b(String paramString)
  {
    return new CaptureComboPtvTemplate(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboPasterFactory
 * JD-Core Version:    0.7.0.1
 */