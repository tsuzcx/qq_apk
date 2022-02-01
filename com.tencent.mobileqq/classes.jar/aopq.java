import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import mqq.manager.Manager;

public class aopq
  extends Observable
  implements Manager
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, SoftReference<aops>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public aopq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private aops a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localObject1 != null)
        {
          localObject1 = (aops)((SoftReference)localObject1).get();
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new aops(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new aopr(this));
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject2));
          }
          return localObject2;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public FullMessageSearchResult a(String paramString)
  {
    return a(paramString).b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearch", 2, "stopSearch " + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (SoftReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (aops)((SoftReference)localObject2).get();
          if (localObject2 != null) {
            ((aops)localObject2).b(2);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearch", 2, "pauseSearch " + paramString);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramString = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (paramString != null)
        {
          paramString = (aops)paramString.get();
          if (paramString != null) {
            paramString.a();
          }
          return;
        }
      }
      paramString = null;
    }
  }
  
  public FullMessageSearchResult b(String paramString)
  {
    return a(paramString).c();
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopq
 * JD-Core Version:    0.7.0.1
 */