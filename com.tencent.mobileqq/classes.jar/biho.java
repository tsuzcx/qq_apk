import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class biho
  implements HandRecognizer.OnPreviewFrameHandlerListener
{
  biho(bihj parambihj) {}
  
  public void getHandRecognizeResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getHandRecognizeResult=" + paramInt);
    }
    if (paramInt >= this.a.g)
    {
      bihj.a(this.a);
      if (bihj.a(this.a)) {
        this.a.ad();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biho
 * JD-Core Version:    0.7.0.1
 */