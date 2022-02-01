import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class bria
  implements Manager
{
  public static long a;
  brii jdField_a_of_type_Brii;
  public QQAppInterface a;
  List<bric> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  Timer jdField_a_of_type_JavaUtilTimer;
  public PriorityBlockingQueue<bric> a;
  public AtomicBoolean a;
  public AtomicInteger a;
  List<bric> b;
  public PriorityBlockingQueue<bric> b;
  public AtomicInteger b;
  List<bric> c = Collections.synchronizedList(new LinkedList());
  List<bric> d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  public bria(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Brii = new brib(this);
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
  
  public void a(bric parambric)
  {
    brhv.a(parambric, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + parambric.a.busiType);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     bria
 * JD-Core Version:    0.7.0.1
 */