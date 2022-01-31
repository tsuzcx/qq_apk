import android.os.Message;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTracker2;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.TrackingDecoderListener;

public class aonk
  implements TrackingDecoderListener
{
  public aonk(SimpleStickerTracker2 paramSimpleStickerTracker2) {}
  
  public Surface a()
  {
    return null;
  }
  
  public void a()
  {
    SimpleStickerTracker2.a(this.a, System.currentTimeMillis());
    if (SimpleStickerTracker2.a(this.a) != null)
    {
      Message localMessage = SimpleStickerTracker2.a(this.a).obtainMessage(1);
      SimpleStickerTracker2.a(this.a).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "SimpleStickerTracker2 onDecodeError errorCode =" + paramInt);
    }
    paramThrowable.printStackTrace();
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      SimpleStickerTracker2.a(this.a, paramArrayOfByte, paramLong);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SimpleStickerTracker2", 2, "onDecodeFinish ");
    }
    if (SimpleStickerTracker2.a(this.a) != null)
    {
      Message localMessage = SimpleStickerTracker2.a(this.a).obtainMessage(3);
      SimpleStickerTracker2.a(this.a).sendMessage(localMessage);
    }
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aonk
 * JD-Core Version:    0.7.0.1
 */