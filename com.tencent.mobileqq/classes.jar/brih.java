import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener;

class brih
  implements VoiceTextRecognizer.VRErrorListener
{
  brih(brig parambrig) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoVoiceRecognizer", 1, "VoiceTextRecognizer error! errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brih
 * JD-Core Version:    0.7.0.1
 */