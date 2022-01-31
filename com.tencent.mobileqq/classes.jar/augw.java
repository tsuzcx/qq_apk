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

public class augw
  implements Manager
{
  private augu jdField_a_of_type_Augu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, augx> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public augw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(augx paramaugx)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramaugx);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "addAioContext() called with: multiAioContext = [" + paramaugx + "], id = [" + i + "]");
      }
      return i;
    }
    finally {}
  }
  
  public augx a(int paramInt)
  {
    try
    {
      augx localaugx = (augx)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "removeAioContext() called with: id = [" + paramInt + "], multiAioContext = " + localaugx);
      }
      return localaugx;
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
        augx localaugx = (augx)localIterator.next();
        if (localaugx != null) {
          localaugx.a();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public void a(augu paramaugu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "onConfUpdate : " + paramaugu);
    }
    this.jdField_a_of_type_Augu = paramaugu;
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
    if (!this.jdField_a_of_type_Augu.a())
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    Object localObject = this.jdField_a_of_type_Augu.a();
    String str = (Build.MANUFACTURER + Build.MODEL).trim();
    if ((localObject != null) && (((List)localObject).contains(str)))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    localObject = this.jdField_a_of_type_Augu.a();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (azex.b((String)localObject) <= 0))
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public augx b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "getAioContext() called with: id = [" + paramInt + "]");
    }
    try
    {
      augx localaugx = (augx)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      return localaugx;
    }
    finally {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_Augu = ((augu)aogj.a().a(478));
    if (this.jdField_a_of_type_Augu == null)
    {
      this.jdField_a_of_type_Augu = new augu();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     augw
 * JD-Core Version:    0.7.0.1
 */