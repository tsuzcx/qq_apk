import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransFileController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class bamu
  implements bapx
{
  public int a;
  public long a;
  public aonc a;
  public bamv a;
  public AppInterface a;
  public ConcurrentHashMap<String, bdlq> a;
  AtomicBoolean a;
  
  public bamu(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bamv = new bamv(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public abstract bamw a(baub parambaub);
  
  public bdlq a(String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set<String> a(ConcurrentHashMap<String, bdlq> paramConcurrentHashMap)
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
      Object localObject = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject instanceof bamw))
      {
        localObject = (bamw)localObject;
        ((bamw)localObject).j();
        ((bamw)localObject).a();
        ((bamw)localObject).b();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
    }
  }
  
  public void a(baua parambaua)
  {
    bamw.a(parambaua);
  }
  
  public void a(baub parambaub)
  {
    parambaub = parambaub.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(parambaub))
    {
      Object localObject = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambaub);
      if ((localObject instanceof bamw))
      {
        localObject = (bamw)localObject;
        ((bamw)localObject).j();
        ((bamw)localObject).a();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambaub);
      }
    }
  }
  
  public boolean a(baub parambaub)
  {
    Object localObject = parambaub.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        parambaub = a(parambaub);
        if ((parambaub != null) && (parambaub.c() == 0))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, parambaub);
          parambaub.c((String)localObject);
          if (this.jdField_a_of_type_Bamv != null)
          {
            this.jdField_a_of_type_Bamv.a(parambaub);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + parambaub.jdField_a_of_type_Long);
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
          localObject = (bamw)a(parambaub.c, parambaub.jdField_a_of_type_Long);
          if (localObject != null)
          {
            if ((parambaub.b == 131078) && (((bamw)localObject).a != null) && (((bamw)localObject).a.jdField_a_of_type_Aweh == null) && (parambaub.jdField_a_of_type_Aweh != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
              }
              ((bamw)localObject).a.jdField_a_of_type_Aweh = parambaub.jdField_a_of_type_Aweh;
            }
            ((bamw)localObject).b();
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, bamf.a(new Exception("tranfilecontroller closed")));
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
  
  public void b(baua parambaua)
  {
    bamw.b(parambaua);
  }
  
  public void onResp(baqw parambaqw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(parambaqw.jdField_a_of_type_Baqv).append(" result:");
      if (parambaqw.jdField_a_of_type_Int != 0) {
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
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bamu
 * JD-Core Version:    0.7.0.1
 */