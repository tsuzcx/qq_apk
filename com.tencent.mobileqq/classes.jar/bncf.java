import com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.OnPreviewFrameHandlerListener;
import com.tencent.qphone.base.util.QLog;

class bncf
  implements QWalletFaceTracker.OnPreviewFrameHandlerListener
{
  bncf(bnbz parambnbz) {}
  
  public void getFaceRecognizeResult(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onPreviewFrame: getFaceRecognizeResult=" + paramFloat);
    }
    if (paramFloat >= this.a.g)
    {
      bnbz.a(this.a);
      if (bnbz.a(this.a)) {
        this.a.ad();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncf
 * JD-Core Version:    0.7.0.1
 */