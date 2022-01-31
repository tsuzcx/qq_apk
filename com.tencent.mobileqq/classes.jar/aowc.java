import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTracker2;
import java.lang.ref.WeakReference;

public class aowc
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public aowc(SimpleStickerTracker2 paramSimpleStickerTracker21, Looper paramLooper, SimpleStickerTracker2 paramSimpleStickerTracker22)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSimpleStickerTracker22);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (SimpleStickerTracker2)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SimpleStickerTracker2", 2, "ProcesserHandler.handleMessage: Processor is null");
      }
      return;
    }
    switch (i)
    {
    default: 
      throw new RuntimeException("Unhandled msg what=" + i);
    case 1: 
      paramMessage.e();
      return;
    case 2: 
      paramMessage.g();
      return;
    }
    paramMessage.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowc
 * JD-Core Version:    0.7.0.1
 */