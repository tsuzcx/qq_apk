import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class bigx
  implements HandRecognizer.OnPreviewFrameHandlerListener
{
  bigx(bigs parambigs) {}
  
  public void getHandRecognizeResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getHandRecognizeResult=" + paramInt);
    }
    if (paramInt >= this.a.g)
    {
      bigs.a(this.a);
      if (bigs.a(this.a)) {
        this.a.ad();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigx
 * JD-Core Version:    0.7.0.1
 */