import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.QLog;

public final class ansr
  implements Runnable
{
  public ansr(Context paramContext) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a, PeakService.class);
    localIntent.putExtra("ServiceAction", 2);
    try
    {
      this.a.startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess");
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMShortVideoUtils", 2, "onShow_otherThings, e = " + localSecurityException.getStackTrace());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansr
 * JD-Core Version:    0.7.0.1
 */