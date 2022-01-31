import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.qphone.base.util.QLog;

public class avvi
  implements HWDecodeListener
{
  public avvi(FollowCaptureView paramFollowCaptureView) {}
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    FollowCaptureView.a(this.a, paramLong1);
  }
  
  public void onDecodeRepeat()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FollowCaptureView", 2, "onDecodeRepeat");
    }
    FollowCaptureView.a(this.a);
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avvi
 * JD-Core Version:    0.7.0.1
 */