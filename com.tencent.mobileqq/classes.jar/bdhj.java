import android.app.Activity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;

public final class bdhj
  implements IDetectionInterceptor
{
  public boolean ignoreAppEvent(Activity paramActivity)
  {
    QLog.d("DtSdkInitStep", 1, "848QQDT [ignoreAppEvent] activity: " + paramActivity.toString());
    return paramActivity instanceof QQLSActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhj
 * JD-Core Version:    0.7.0.1
 */