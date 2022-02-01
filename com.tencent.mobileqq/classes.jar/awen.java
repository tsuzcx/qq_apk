import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.limitchat.LimitChatDamon.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class awen
{
  private static volatile awen jdField_a_of_type_Awen;
  private long jdField_a_of_type_Long = -1L;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ConcurrentHashMap<String, Bundle> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static awen a()
  {
    if (jdField_a_of_type_Awen == null) {}
    try
    {
      if (jdField_a_of_type_Awen == null) {
        jdField_a_of_type_Awen = new awen();
      }
      return jdField_a_of_type_Awen;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm invoke, uin:" + paramString);
    }
    try
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm last request do not finish");
        }
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_JavaLangRunnable = new LimitChatDamon.1(this, paramString, paramQQAppInterface);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awen
 * JD-Core Version:    0.7.0.1
 */