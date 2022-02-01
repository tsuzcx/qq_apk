import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bokd
  implements INetEngine.INetEngineListener
{
  bokd(bokc parambokc) {}
  
  public void onResp(NetResp paramNetResp)
  {
    bpba localbpba = (bpba)paramNetResp.mReq.getUserData();
    String str1 = localbpba.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramNetResp.mHttpCode);
    }
    Object localObject;
    String str2;
    if (paramNetResp.mHttpCode == 200)
    {
      localObject = bojy.a(localbpba);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = FileUtils.calcMd5((String)localObject);
      if ((localbpba.f == null) || (!localbpba.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = bokc.a(this.a).c(localbpba);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramNetResp.mHttpCode + ",isSuccess:" + bool);
      }
      paramNetResp = ((ArrayList)bokc.a(this.a).get(str1)).iterator();
      while (paramNetResp.hasNext())
      {
        localObject = (WeakReference)paramNetResp.next();
        if (((WeakReference)localObject).get() != null) {
          ((bokb)((WeakReference)localObject).get()).a(bool, str1, localbpba);
        }
      }
      FileUtils.delete((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbpba.f + ",file md5:" + str2);
      }
    }
    bokc.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = ((bpba)???.getUserData()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (bokc.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bokc.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bokb)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokd
 * JD-Core Version:    0.7.0.1
 */