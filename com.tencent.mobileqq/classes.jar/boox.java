import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class boox
  implements bdvw
{
  boox(boow paramboow) {}
  
  public void onResp(bdwt parambdwt)
  {
    bpnf localbpnf = (bpnf)parambdwt.a.a();
    String str1 = localbpnf.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + parambdwt.c);
    }
    Object localObject;
    String str2;
    if (parambdwt.c == 200)
    {
      localObject = boos.a(localbpnf);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bgmg.c((String)localObject);
      if ((localbpnf.f == null) || (!localbpnf.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = boow.a(this.a).c(localbpnf);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + parambdwt.c + ",isSuccess:" + bool);
      }
      parambdwt = ((ArrayList)boow.a(this.a).get(str1)).iterator();
      while (parambdwt.hasNext())
      {
        localObject = (WeakReference)parambdwt.next();
        if (((WeakReference)localObject).get() != null) {
          ((boov)((WeakReference)localObject).get()).a(bool, str1, localbpnf);
        }
      }
      bgmg.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbpnf.f + ",file md5:" + str2);
      }
    }
    boow.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(bdws arg1, long paramLong1, long paramLong2)
  {
    String str = ((bpnf)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (boow.a(this.a))
    {
      Iterator localIterator = ((ArrayList)boow.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((boov)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boox
 * JD-Core Version:    0.7.0.1
 */