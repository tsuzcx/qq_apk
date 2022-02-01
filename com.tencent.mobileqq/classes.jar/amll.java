import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.utils.QLog;

class amll
  extends AVVideoCtrl.EnableCameraCompleteCallback
{
  amll(amli paramamli) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVCameraCaptureModel", 0, "EnableCameraCompleteCallback.OnComplete. result = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amll
 * JD-Core Version:    0.7.0.1
 */