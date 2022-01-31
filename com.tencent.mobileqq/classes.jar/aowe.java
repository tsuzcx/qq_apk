import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tracking.sdk.TrackerManager;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTrackerOrigin;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.TrackerCallback;
import java.util.HashMap;
import java.util.Map;

public class aowe
  extends Handler
{
  public aowe(SimpleStickerTrackerOrigin paramSimpleStickerTrackerOrigin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (byte[])paramMessage.obj;
      TrackerManager.newInstance().openTrack(paramMessage, 2, 0, this.a.jdField_a_of_type_Float, this.a.b, this.a.c, this.a.d, SimpleStickerTrackerOrigin.a(this.a), SimpleStickerTrackerOrigin.b(this.a), 1.0F);
      this.a.jdField_a_of_type_Boolean = true;
      return;
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("SimpleStickerTrackerOrigin", 2, "handle frame start");
      }
      SimpleStickerTrackerOrigin.a(this.a).clear();
      return;
    case 3: 
      if (QLog.isColorLevel()) {
        QLog.d("SimpleStickerTrackerOrigin", 2, "handle frame in  , thread id=" + Thread.currentThread().getId());
      }
      SimpleStickerTrackerOrigin.a(this.a);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = SimpleStickerTrackerOrigin.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "handle finish cos time  =" + (l1 - l2));
    }
    if (SimpleStickerTrackerOrigin.a(this.a) != null)
    {
      paramMessage = new HashMap();
      paramMessage.putAll(SimpleStickerTrackerOrigin.a(this.a));
      SimpleStickerTrackerOrigin.a(this.a).a(paramMessage);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowe
 * JD-Core Version:    0.7.0.1
 */