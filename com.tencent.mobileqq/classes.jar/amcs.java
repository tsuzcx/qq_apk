import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;

public class amcs
  implements almm
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = azmz.a(3);
    }
    for (;;)
    {
      try
      {
        QLog.e("QQInitHandler_WalLog", 1, new Object[] { "onDpcPullFinished, isEnable: ", Boolean.valueOf(paramBoolean) });
        if (paramBoolean) {
          continue;
        }
        bdcs.d(alxk.a);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQInitHandler", 1, "onDpcPullFinished, get switch error", localThrowable);
        continue;
      }
      DeviceProfileManager.b(this);
      return;
      bdcs.a(alxk.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcs
 * JD-Core Version:    0.7.0.1
 */