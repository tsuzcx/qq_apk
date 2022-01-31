import com.tencent.mobileqq.data.FlowMusic;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.GetSingleMusicInfoCallback;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;

public class amwk
  implements QIMMusicConfigManager.GetSingleMusicInfoCallback
{
  public amwk(RecognitionManager paramRecognitionManager, String paramString) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (FlowMusic)paramObject;
    RecognitionManager.a(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager, RecognitionManager.a(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager, paramObject, this.jdField_a_of_type_JavaLangString));
    if (RecognitionManager.a(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager).equals(RecognitionManager.a(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager).getClass())) {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwk
 * JD-Core Version:    0.7.0.1
 */