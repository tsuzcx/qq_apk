import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener;

class bjjj
  implements VoiceTextRecognizer.VRErrorListener
{
  bjjj(bjji parambjji) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoVoiceRecognizer", 1, "VoiceTextRecognizer error! errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjjj
 * JD-Core Version:    0.7.0.1
 */