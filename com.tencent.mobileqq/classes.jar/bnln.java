import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class bnln
  implements Manager
{
  public static long a;
  public QQAppInterface a;
  Timer a;
  public PriorityBlockingQueue<bnlo> a;
  public AtomicBoolean a;
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      QLog.d("ShortVideoPreDownloader", 2, paramString1 + "(): " + str);
    }
  }
  
  public void a(bnlo parambnlo)
  {
    bnli.a(parambnlo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + parambnlo.a.busiType);
    }
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnln
 * JD-Core Version:    0.7.0.1
 */