import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener;

class bnlv
  implements VoiceTextRecognizer.VRErrorListener
{
  bnlv(bnlu parambnlu) {}
  
  public void onError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoVoiceRecognizer", 1, "VoiceTextRecognizer error! errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlv
 * JD-Core Version:    0.7.0.1
 */