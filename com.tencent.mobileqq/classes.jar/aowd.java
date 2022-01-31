import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUVideoFrameRender;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTrackerOrigin;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.TrackingDecoderListener;

public class aowd
  implements TrackingDecoderListener
{
  public aowd(SimpleStickerTrackerOrigin paramSimpleStickerTrackerOrigin) {}
  
  public Surface a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "getSurface TrackingDecoderListener , thread id=" + Thread.currentThread().getId());
    }
    if (SimpleStickerTrackerOrigin.a(this.a) != null)
    {
      SimpleStickerTrackerOrigin.a(this.a).a(SimpleStickerTrackerOrigin.a(this.a), SimpleStickerTrackerOrigin.b(this.a));
      return SimpleStickerTrackerOrigin.a(this.a).a();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "HWDecodeListener onDecodeStart");
    }
    SimpleStickerTrackerOrigin.a(this.a, 0);
    SimpleStickerTrackerOrigin.a(this.a, System.currentTimeMillis());
    if (SimpleStickerTrackerOrigin.a(this.a) != null)
    {
      Message localMessage = SimpleStickerTrackerOrigin.a(this.a).obtainMessage(2);
      SimpleStickerTrackerOrigin.a(this.a).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "HWDecodeListener onDecodeError");
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (SimpleStickerTrackerOrigin.a(this.a) != null)
    {
      SimpleStickerTrackerOrigin.a(this.a).a(paramLong2);
      SimpleStickerTrackerOrigin.a(this.a).b(true);
      if (SimpleStickerTrackerOrigin.a(this.a) != null) {
        this.a.a(paramLong2);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "HWDecodeListener onDecodeRenderData timestampNanos = " + paramLong + ", data =" + paramArrayOfByte + ", thread id=" + Thread.currentThread().getId());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "HWDecodeListener onDecodeFinish");
    }
    if (SimpleStickerTrackerOrigin.a(this.a) != null)
    {
      Message localMessage = SimpleStickerTrackerOrigin.a(this.a).obtainMessage(4);
      SimpleStickerTrackerOrigin.a(this.a).sendMessage(localMessage);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "HWDecodeListener onDecodeCancel");
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowd
 * JD-Core Version:    0.7.0.1
 */