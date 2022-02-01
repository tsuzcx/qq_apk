import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bpqs
  implements beuq
{
  bpqs(bpqr parambpqr) {}
  
  public void onResp(bevm parambevm)
  {
    bqpa localbqpa = (bqpa)parambevm.a.a();
    String str1 = localbqpa.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + parambevm.c);
    }
    Object localObject;
    String str2;
    if (parambevm.c == 200)
    {
      localObject = bpqn.a(localbqpa);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bhmi.c((String)localObject);
      if ((localbqpa.f == null) || (!localbqpa.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = bpqr.a(this.a).c(localbqpa);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + parambevm.c + ",isSuccess:" + bool);
      }
      parambevm = ((ArrayList)bpqr.a(this.a).get(str1)).iterator();
      while (parambevm.hasNext())
      {
        localObject = (WeakReference)parambevm.next();
        if (((WeakReference)localObject).get() != null) {
          ((bpqq)((WeakReference)localObject).get()).a(bool, str1, localbqpa);
        }
      }
      bhmi.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbqpa.f + ",file md5:" + str2);
      }
    }
    bpqr.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(bevl arg1, long paramLong1, long paramLong2)
  {
    String str = ((bqpa)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (bpqr.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bpqr.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bpqq)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqs
 * JD-Core Version:    0.7.0.1
 */