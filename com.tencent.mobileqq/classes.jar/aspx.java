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

public class aspx
  implements Manager
{
  private aspv jdField_a_of_type_Aspv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, aspy> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aspx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(aspy paramaspy)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramaspy);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "addAioContext() called with: multiAioContext = [" + paramaspy + "], id = [" + i + "]");
      }
      return i;
    }
    finally {}
  }
  
  public aspy a(int paramInt)
  {
    try
    {
      aspy localaspy = (aspy)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "removeAioContext() called with: id = [" + paramInt + "], multiAioContext = " + localaspy);
      }
      return localaspy;
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
        aspy localaspy = (aspy)localIterator.next();
        if (localaspy != null) {
          localaspy.a();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public void a(aspv paramaspv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "onConfUpdate : " + paramaspv);
    }
    this.jdField_a_of_type_Aspv = paramaspv;
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
    if (!this.jdField_a_of_type_Aspv.a())
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    Object localObject = this.jdField_a_of_type_Aspv.a();
    String str = (Build.MANUFACTURER + Build.MODEL).trim();
    if ((localObject != null) && (((List)localObject).contains(str)))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    localObject = this.jdField_a_of_type_Aspv.a();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (axjr.b((String)localObject) <= 0))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public aspy b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "getAioContext() called with: id = [" + paramInt + "]");
    }
    try
    {
      aspy localaspy = (aspy)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      return localaspy;
    }
    finally {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aspv = ((aspv)ampl.a().a(478));
    if (this.jdField_a_of_type_Aspv == null)
    {
      this.jdField_a_of_type_Aspv = new aspv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aspx
 * JD-Core Version:    0.7.0.1
 */