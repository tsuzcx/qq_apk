import android.support.annotation.Nullable;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;

public class aybv
{
  private String a = "Notification";
  
  public static String a(adhi paramadhi)
  {
    if (paramadhi == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isContrast: ").append(paramadhi.c()).append("\nisExperiment: ").append(paramadhi.b()).append("\nlayerName: ").append(paramadhi.a);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public adhi a()
  {
    Object localObject = null;
    try
    {
      adhi localadhi = ABTestController.a().a(this.a);
      localObject = localadhi;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ForegroundNotifyAbTest", 1, "experimentInfo: failed. ", localThrowable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForegroundNotifyAbTest", 2, new Object[] { "experimentInfo: invoked. ", " experimentInfo: ", a(localObject) });
    }
    return localObject;
  }
  
  public void a()
  {
    adhi localadhi = a();
    if ((localadhi != null) && (localadhi.b())) {
      localadhi.a(this.a + "_Experiment");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForegroundNotifyAbTest", 2, new Object[] { "reportExperiment: invoked. ", " experimentInfo: ", a(localadhi) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybv
 * JD-Core Version:    0.7.0.1
 */