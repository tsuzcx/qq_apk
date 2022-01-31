import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransFileController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ayox
  implements aysa
{
  public int a;
  public long a;
  public amvy a;
  public ayoy a;
  public AppInterface a;
  public ConcurrentHashMap<String, bbmi> a;
  AtomicBoolean a;
  
  public ayox(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ayoy = new ayoy(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public abstract ayoz a(aywa paramaywa);
  
  public bbmi a(String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set<String> a(ConcurrentHashMap<String, bbmi> paramConcurrentHashMap)
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
      Object localObject = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject instanceof ayoz))
      {
        localObject = (ayoz)localObject;
        ((ayoz)localObject).j();
        ((ayoz)localObject).a();
        ((ayoz)localObject).b();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
    }
  }
  
  public void a(ayvz paramayvz)
  {
    ayoz.a(paramayvz);
  }
  
  public void a(aywa paramaywa)
  {
    paramaywa = paramaywa.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramaywa))
    {
      Object localObject = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaywa);
      if ((localObject instanceof ayoz))
      {
        localObject = (ayoz)localObject;
        ((ayoz)localObject).j();
        ((ayoz)localObject).a();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaywa);
      }
    }
  }
  
  public boolean a(aywa paramaywa)
  {
    Object localObject = paramaywa.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        paramaywa = a(paramaywa);
        if ((paramaywa != null) && (paramaywa.c() == 0))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramaywa);
          paramaywa.c((String)localObject);
          if (this.jdField_a_of_type_Ayoy != null)
          {
            this.jdField_a_of_type_Ayoy.a(paramaywa);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + paramaywa.jdField_a_of_type_Long);
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
          localObject = (ayoz)a(paramaywa.c, paramaywa.jdField_a_of_type_Long);
          if (localObject != null)
          {
            if ((paramaywa.b == 131078) && (((ayoz)localObject).a != null) && (((ayoz)localObject).a.jdField_a_of_type_Aumy == null) && (paramaywa.jdField_a_of_type_Aumy != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
              }
              ((ayoz)localObject).a.jdField_a_of_type_Aumy = paramaywa.jdField_a_of_type_Aumy;
            }
            ((ayoz)localObject).b();
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, ayoh.a(new Exception("tranfilecontroller closed")));
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
  
  public void b(ayvz paramayvz)
  {
    ayoz.b(paramayvz);
  }
  
  public void onResp(aysx paramaysx)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(paramaysx.jdField_a_of_type_Aysw).append(" result:");
      if (paramaysx.jdField_a_of_type_Int != 0) {
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
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayox
 * JD-Core Version:    0.7.0.1
 */