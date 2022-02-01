import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransFileController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class bern
  implements beuq
{
  public int a;
  public long a;
  public arix a;
  public bero a;
  public AppInterface a;
  public ConcurrentHashMap<String, bhvc> a;
  AtomicBoolean a;
  
  public bern()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  }
  
  public bern(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bero = new bero(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public abstract berp a(beyg parambeyg);
  
  public bhvc a(String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set<String> a(ConcurrentHashMap<String, bhvc> paramConcurrentHashMap)
  {
    HashSet localHashSet = new HashSet();
    if (paramConcurrentHashMap != null) {}
    for (paramConcurrentHashMap = paramConcurrentHashMap.keySet(); paramConcurrentHashMap != null; paramConcurrentHashMap = null)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.iterator();
      while (paramConcurrentHashMap.hasNext()) {
        localHashSet.add((String)paramConcurrentHashMap.next());
      }
    }
    return localHashSet;
  }
  
  public void a()
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject instanceof berp))
      {
        localObject = (berp)localObject;
        ((berp)localObject).k();
        ((berp)localObject).a();
        ((berp)localObject).b();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
    }
  }
  
  public void a(beyf parambeyf)
  {
    berp.a(parambeyf);
  }
  
  public void a(beyg parambeyg)
  {
    parambeyg = parambeyg.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(parambeyg))
    {
      Object localObject = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambeyg);
      if ((localObject instanceof berp))
      {
        localObject = (berp)localObject;
        ((berp)localObject).k();
        ((berp)localObject).a();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambeyg);
      }
    }
  }
  
  public boolean a(beyg parambeyg)
  {
    Object localObject = parambeyg.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        parambeyg = a(parambeyg);
        if ((parambeyg != null) && (parambeyg.c() == 0))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, parambeyg);
          parambeyg.c((String)localObject);
          if (this.jdField_a_of_type_Bero != null)
          {
            this.jdField_a_of_type_Bero.a(parambeyg);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + parambeyg.jdField_a_of_type_Long);
        }
        long l = System.currentTimeMillis();
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = l;
        }
        if (l - this.jdField_a_of_type_Long > 2000L) {
          this.jdField_a_of_type_Long = l;
        }
        for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int += 1)
        {
          if (this.jdField_a_of_type_Int > 500) {
            QLog.e("Q.richmedia.TransFileController", 1, "bad bad 日志频繁打印" + QLog.getStackTraceString(new Throwable()));
          }
          localObject = (berp)a(parambeyg.c, parambeyg.jdField_a_of_type_Long);
          if (localObject != null)
          {
            if ((parambeyg.b == 131078) && (((berp)localObject).a != null) && (((berp)localObject).a.jdField_a_of_type_Azpp == null) && (parambeyg.jdField_a_of_type_Azpp != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
              }
              ((berp)localObject).a.jdField_a_of_type_Azpp = parambeyg.jdField_a_of_type_Azpp;
            }
            ((berp)localObject).b();
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, bera.a(new Exception("tranfilecontroller closed")));
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public void b(beyf parambeyf)
  {
    berp.b(parambeyf);
  }
  
  public void onResp(bevm parambevm)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(parambevm.jdField_a_of_type_Bevl).append(" result:");
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("Q.richmedia.TransFileController", 2, bool);
      return;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bern
 * JD-Core Version:    0.7.0.1
 */