import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class amdn
  extends MqqHandler
{
  public amdn(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("ThreadManager", 1, "global SubHandler cannot excute removeCallbacksAndMessages");
      return;
    }
    super.removeCallbacksAndMessages(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdn
 * JD-Core Version:    0.7.0.1
 */