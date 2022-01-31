import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class bheh
  implements HandRecognizer.OnPreviewFrameHandlerListener
{
  bheh(bhec parambhec) {}
  
  public void getHandRecognizeResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getHandRecognizeResult=" + paramInt);
    }
    if (paramInt >= this.a.g)
    {
      bhec.a(this.a);
      if (bhec.a(this.a)) {
        this.a.ae();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bheh
 * JD-Core Version:    0.7.0.1
 */