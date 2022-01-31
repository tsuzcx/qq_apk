import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bjff
  implements aysa
{
  bjff(bjfe parambjfe) {}
  
  public void onResp(aysx paramaysx)
  {
    bkfm localbkfm = (bkfm)paramaysx.a.a();
    String str1 = localbkfm.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramaysx.c);
    }
    Object localObject;
    String str2;
    if (paramaysx.c == 200)
    {
      localObject = bjfa.a(localbkfm);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bbdj.c((String)localObject);
      if ((localbkfm.f == null) || (!localbkfm.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = bjfe.a(this.a).c(localbkfm);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramaysx.c + ",isSuccess:" + bool);
      }
      paramaysx = ((ArrayList)bjfe.a(this.a).get(str1)).iterator();
      while (paramaysx.hasNext())
      {
        localObject = (WeakReference)paramaysx.next();
        if (((WeakReference)localObject).get() != null) {
          ((bjfd)((WeakReference)localObject).get()).a(bool, str1, localbkfm);
        }
      }
      bbdj.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbkfm.f + ",file md5:" + str2);
      }
    }
    bjfe.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(aysw arg1, long paramLong1, long paramLong2)
  {
    String str = ((bkfm)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (bjfe.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bjfe.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bjfd)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjff
 * JD-Core Version:    0.7.0.1
 */