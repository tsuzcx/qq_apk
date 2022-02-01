import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class blbt
{
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramLong + "|");
    localStringBuilder.append(Build.BRAND + "|");
    localStringBuilder.append(Build.MODEL + "|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadSuccessRateReporter", 2, "[preloadSuccessRate]: " + localStringBuilder.toString());
      }
      bcrt.a(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preloadSuccessRate", localStringBuilder.toString(), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbt
 * JD-Core Version:    0.7.0.1
 */