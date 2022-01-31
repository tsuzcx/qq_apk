import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.OnF2FConfigListener.1;
import com.tencent.qphone.base.util.QLog;

public class ampe
  implements amos
{
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, amor paramamor)
  {
    if ((paramamor != null) && ("qqsettingme_f2f_guide_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnF2FConfigListener", 2, "handleConfigForTag qqsettingme_f2f content = " + paramamor.a);
      }
      ThreadManager.post(new OnF2FConfigListener.1(this, paramamor, paramQQAppInterface), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ampe
 * JD-Core Version:    0.7.0.1
 */