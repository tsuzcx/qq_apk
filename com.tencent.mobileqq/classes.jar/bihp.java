import com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class bihp
  implements QWalletFaceTracker.OnPreviewFrameHandlerListener
{
  bihp(bihj parambihj) {}
  
  public void getFaceRecognizeResult(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getFaceRecognizeResult=" + paramFloat);
    }
    if (paramFloat >= this.a.g)
    {
      bihj.a(this.a);
      if (bihj.a(this.a)) {
        this.a.ad();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihp
 * JD-Core Version:    0.7.0.1
 */