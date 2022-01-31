import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class bkjk
  implements HandRecognizer.OnPreviewFrameHandlerListener
{
  bkjk(bkjf parambkjf) {}
  
  public void getHandRecognizeResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getHandRecognizeResult=" + paramInt);
    }
    if (paramInt >= this.a.g)
    {
      bkjf.a(this.a);
      if (bkjf.a(this.a)) {
        this.a.ad();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjk
 * JD-Core Version:    0.7.0.1
 */