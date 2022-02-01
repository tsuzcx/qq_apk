import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.OnF2FConfigListener.1;
import com.tencent.qphone.base.util.QLog;

public class aqwx
  implements aqwi
{
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqwh paramaqwh)
  {
    if ((paramaqwh != null) && ("qqsettingme_f2f_guide_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnF2FConfigListener", 2, "handleConfigForTag qqsettingme_f2f content = " + paramaqwh.a);
      }
      ThreadManager.post(new OnF2FConfigListener.1(this, paramaqwh, paramQQAppInterface), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwx
 * JD-Core Version:    0.7.0.1
 */