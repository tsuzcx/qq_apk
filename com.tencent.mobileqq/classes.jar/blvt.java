import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class blvt
  implements baug
{
  blvt(blvs paramblvs) {}
  
  public void onResp(bavf parambavf)
  {
    bmvz localbmvz = (bmvz)parambavf.a.a();
    String str1 = localbmvz.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + parambavf.c);
    }
    Object localObject;
    String str2;
    if (parambavf.c == 200)
    {
      localObject = blvo.a(localbmvz);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bdhb.c((String)localObject);
      if ((localbmvz.f == null) || (!localbmvz.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = blvs.a(this.a).c(localbmvz);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + parambavf.c + ",isSuccess:" + bool);
      }
      parambavf = ((ArrayList)blvs.a(this.a).get(str1)).iterator();
      while (parambavf.hasNext())
      {
        localObject = (WeakReference)parambavf.next();
        if (((WeakReference)localObject).get() != null) {
          ((blvr)((WeakReference)localObject).get()).a(bool, str1, localbmvz);
        }
      }
      bdhb.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbmvz.f + ",file md5:" + str2);
      }
    }
    blvs.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(bave arg1, long paramLong1, long paramLong2)
  {
    String str = ((bmvz)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (blvs.a(this.a))
    {
      Iterator localIterator = ((ArrayList)blvs.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((blvr)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvt
 * JD-Core Version:    0.7.0.1
 */