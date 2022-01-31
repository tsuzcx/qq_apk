import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class blrh
  implements bapx
{
  blrh(blrg paramblrg) {}
  
  public void onResp(baqw parambaqw)
  {
    bmrn localbmrn = (bmrn)parambaqw.a.a();
    String str1 = localbmrn.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + parambaqw.c);
    }
    Object localObject;
    String str2;
    if (parambaqw.c == 200)
    {
      localObject = blrc.a(localbmrn);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = bdcs.c((String)localObject);
      if ((localbmrn.f == null) || (!localbmrn.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = blrg.a(this.a).c(localbmrn);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + parambaqw.c + ",isSuccess:" + bool);
      }
      parambaqw = ((ArrayList)blrg.a(this.a).get(str1)).iterator();
      while (parambaqw.hasNext())
      {
        localObject = (WeakReference)parambaqw.next();
        if (((WeakReference)localObject).get() != null) {
          ((blrf)((WeakReference)localObject).get()).a(bool, str1, localbmrn);
        }
      }
      bdcs.a((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbmrn.f + ",file md5:" + str2);
      }
    }
    blrg.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    String str = ((bmrn)???.a()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (blrg.a(this.a))
    {
      Iterator localIterator = ((ArrayList)blrg.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((blrf)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrh
 * JD-Core Version:    0.7.0.1
 */