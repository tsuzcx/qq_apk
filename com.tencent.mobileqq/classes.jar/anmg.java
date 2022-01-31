import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import java.io.File;

public final class anmg
  implements FFmpegExecuteResponseCallback
{
  public anmg(String paramString, RecognitionManager paramRecognitionManager) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onStart: invoked. info: ");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onSuccess: invoked. info: message = " + paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager != null) && (localFile.exists()))
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.a(localFile);
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.c();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("HumUtils", 2, "onFinish: audioFile not exist. audioFile = " + localFile);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onFailure: invoked. info: Failed to convert sample rate. message = " + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmg
 * JD-Core Version:    0.7.0.1
 */