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

public class axlc
  implements Manager
{
  private axla jdField_a_of_type_Axla;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, axld> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public axlc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(axld paramaxld)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramaxld);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "addAioContext() called with: multiAioContext = [" + paramaxld + "], id = [" + i + "]");
      }
      return i;
    }
    finally {}
  }
  
  public axld a(int paramInt)
  {
    try
    {
      axld localaxld = (axld)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "removeAioContext() called with: id = [" + paramInt + "], multiAioContext = " + localaxld);
      }
      return localaxld;
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
        axld localaxld = (axld)localIterator.next();
        if (localaxld != null) {
          localaxld.a();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public void a(axla paramaxla)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "onConfUpdate : " + paramaxla);
    }
    this.jdField_a_of_type_Axla = paramaxla;
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
    if (!this.jdField_a_of_type_Axla.a())
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    Object localObject = this.jdField_a_of_type_Axla.a();
    String str = (Build.MANUFACTURER + Build.MODEL).trim();
    if ((localObject != null) && (((List)localObject).contains(str)))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    localObject = this.jdField_a_of_type_Axla.a();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (bdcx.b((String)localObject) <= 0))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public axld b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "getAioContext() called with: id = [" + paramInt + "]");
    }
    try
    {
      axld localaxld = (axld)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      return localaxld;
    }
    finally {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axla = ((axla)aran.a().a(478));
    if (this.jdField_a_of_type_Axla == null)
    {
      this.jdField_a_of_type_Axla = new axla();
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
 * Qualified Name:     axlc
 * JD-Core Version:    0.7.0.1
 */