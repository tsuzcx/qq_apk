import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bjfw
  implements aysc
{
  bjfw(bjfv parambjfv) {}
  
  public void onResp(aysz paramaysz)
  {
    bkgd localbkgd = (bkgd)paramaysz.a.a();
    String str1 = localbkgd.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramaysz.c);
    }
    Object localObject;
    String str2;
    if (paramaysz.c == 200)
    {
      localObject = bjfr.a(localbkgd);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bbdx.c((String)localObject);
      if ((localbkgd.f == null) || (!localbkgd.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = bjfv.a(this.a).c(localbkgd);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramaysz.c + ",isSuccess:" + bool);
      }
      paramaysz = ((ArrayList)bjfv.a(this.a).get(str1)).iterator();
      while (paramaysz.hasNext())
      {
        localObject = (WeakReference)paramaysz.next();
        if (((WeakReference)localObject).get() != null) {
          ((bjfu)((WeakReference)localObject).get()).a(bool, str1, localbkgd);
        }
      }
      bbdx.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbkgd.f + ",file md5:" + str2);
      }
    }
    bjfv.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(aysy arg1, long paramLong1, long paramLong2)
  {
    String str = ((bkgd)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (bjfv.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bjfv.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bjfu)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfw
 * JD-Core Version:    0.7.0.1
 */