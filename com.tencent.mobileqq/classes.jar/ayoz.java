import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransFileController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ayoz
  implements aysc
{
  public int a;
  public long a;
  public amvx a;
  public aypa a;
  public AppInterface a;
  public ConcurrentHashMap<String, bbmw> a;
  AtomicBoolean a;
  
  public ayoz(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aypa = new aypa(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public abstract aypb a(aywc paramaywc);
  
  public bbmw a(String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set<String> a(ConcurrentHashMap<String, bbmw> paramConcurrentHashMap)
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
      Object localObject = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject instanceof aypb))
      {
        localObject = (aypb)localObject;
        ((aypb)localObject).j();
        ((aypb)localObject).a();
        ((aypb)localObject).b();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
    }
  }
  
  public void a(aywb paramaywb)
  {
    aypb.a(paramaywb);
  }
  
  public void a(aywc paramaywc)
  {
    paramaywc = paramaywc.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramaywc))
    {
      Object localObject = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaywc);
      if ((localObject instanceof aypb))
      {
        localObject = (aypb)localObject;
        ((aypb)localObject).j();
        ((aypb)localObject).a();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaywc);
      }
    }
  }
  
  public boolean a(aywc paramaywc)
  {
    Object localObject = paramaywc.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        paramaywc = a(paramaywc);
        if ((paramaywc != null) && (paramaywc.c() == 0))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramaywc);
          paramaywc.c((String)localObject);
          if (this.jdField_a_of_type_Aypa != null)
          {
            this.jdField_a_of_type_Aypa.a(paramaywc);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + paramaywc.jdField_a_of_type_Long);
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
          localObject = (aypb)a(paramaywc.c, paramaywc.jdField_a_of_type_Long);
          if (localObject != null)
          {
            if ((paramaywc.b == 131078) && (((aypb)localObject).a != null) && (((aypb)localObject).a.jdField_a_of_type_Auna == null) && (paramaywc.jdField_a_of_type_Auna != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
              }
              ((aypb)localObject).a.jdField_a_of_type_Auna = paramaywc.jdField_a_of_type_Auna;
            }
            ((aypb)localObject).b();
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, ayoj.a(new Exception("tranfilecontroller closed")));
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
  
  public void b(aywb paramaywb)
  {
    aypb.b(paramaywb);
  }
  
  public void onResp(aysz paramaysz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(paramaysz.jdField_a_of_type_Aysy).append(" result:");
      if (paramaysz.jdField_a_of_type_Int != 0) {
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
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayoz
 * JD-Core Version:    0.7.0.1
 */