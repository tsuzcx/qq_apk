import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aqan
  implements Handler.Callback
{
  private static aqan jdField_a_of_type_Aqan;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  
  public static aqan a()
  {
    if (jdField_a_of_type_Aqan == null) {}
    try
    {
      if (jdField_a_of_type_Aqan == null) {
        jdField_a_of_type_Aqan = new aqan();
      }
      return jdField_a_of_type_Aqan;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onCreate");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onPageShow");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2000L);
      return;
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 1, "onDestroy");
    }
    if ((paramBoolean2) && (paramBoolean1)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onPagePause");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        QLog.d("QFlutter.Reporter", 1, "init memory");
        this.jdField_a_of_type_JavaUtilMap = bbct.a(BaseApplicationImpl.getContext());
        return false;
      } while (this.jdField_a_of_type_JavaUtilMap == null);
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        aqao.a(bool, true, this.jdField_a_of_type_JavaUtilMap);
        if (bool) {
          break;
        }
        this.jdField_a_of_type_JavaUtilMap = null;
        return false;
      }
    } while (this.jdField_a_of_type_JavaUtilMap == null);
    aqao.a(true, false, this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_JavaUtilMap = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqan
 * JD-Core Version:    0.7.0.1
 */