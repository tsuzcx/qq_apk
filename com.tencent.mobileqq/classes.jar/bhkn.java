import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bhkn
  implements axrt
{
  bhkn(bhkm parambhkm) {}
  
  public void onResp(axsq paramaxsq)
  {
    bior localbior = (bior)paramaxsq.a.a();
    String str1 = localbior.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramaxsq.c);
    }
    Object localObject;
    String str2;
    if (paramaxsq.c == 200)
    {
      localObject = bhki.a(localbior);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bace.c((String)localObject);
      if ((localbior.f == null) || (!localbior.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = bhkm.a(this.a).c(localbior);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramaxsq.c + ",isSuccess:" + bool);
      }
      paramaxsq = ((ArrayList)bhkm.a(this.a).get(str1)).iterator();
      while (paramaxsq.hasNext())
      {
        localObject = (WeakReference)paramaxsq.next();
        if (((WeakReference)localObject).get() != null) {
          ((bhkl)((WeakReference)localObject).get()).a(bool, str1, localbior);
        }
      }
      bace.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbior.f + ",file md5:" + str2);
      }
    }
    bhkm.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    String str = ((bior)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (bhkm.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bhkm.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bhkl)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhkn
 * JD-Core Version:    0.7.0.1
 */