import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class bodm
  implements HandRecognizer.OnPreviewFrameHandlerListener
{
  bodm(bodh parambodh) {}
  
  public void getHandRecognizeResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getHandRecognizeResult=" + paramInt);
    }
    if (paramInt >= this.a.g)
    {
      bodh.a(this.a);
      if (bodh.a(this.a)) {
        this.a.ad();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodm
 * JD-Core Version:    0.7.0.1
 */