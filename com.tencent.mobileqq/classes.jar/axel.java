import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class axel
  implements Manager
{
  private axej jdField_a_of_type_Axej;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, axem> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public axel(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(axem paramaxem)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramaxem);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "addAioContext() called with: multiAioContext = [" + paramaxem + "], id = [" + i + "]");
      }
      return i;
    }
    finally {}
  }
  
  public axem a(int paramInt)
  {
    try
    {
      axem localaxem = (axem)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "removeAioContext() called with: id = [" + paramInt + "], multiAioContext = " + localaxem);
      }
      return localaxem;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        axem localaxem = (axem)localIterator.next();
        if (localaxem != null) {
          localaxem.a();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public void a(axej paramaxej)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "onConfUpdate : " + paramaxej);
    }
    this.jdField_a_of_type_Axej = paramaxej;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "MultiAIOEntranceConfigData isConfigInited = " + this.b);
    }
    if (this.b) {
      return this.jdField_a_of_type_Boolean;
    }
    this.b = true;
    b();
    if (!this.jdField_a_of_type_Axej.a())
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    Object localObject = this.jdField_a_of_type_Axej.a();
    String str = (Build.MANUFACTURER + Build.MODEL).trim();
    if ((localObject != null) && (((List)localObject).contains(str)))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    localObject = this.jdField_a_of_type_Axej.a();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (bdcu.b((String)localObject) <= 0))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public axem b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "getAioContext() called with: id = [" + paramInt + "]");
    }
    try
    {
      axem localaxem = (axem)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      return localaxem;
    }
    finally {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axej = ((axej)aqxe.a().a(478));
    if (this.jdField_a_of_type_Axej == null)
    {
      this.jdField_a_of_type_Axej = new axej();
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "MultiAIOEntranceConfigData =null, general new bean");
      }
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axel
 * JD-Core Version:    0.7.0.1
 */