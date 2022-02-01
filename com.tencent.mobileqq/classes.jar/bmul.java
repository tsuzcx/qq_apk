import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bmul
  implements INetEngine.INetEngineListener
{
  bmul(bmuk parambmuk) {}
  
  public void onResp(NetResp paramNetResp)
  {
    bnli localbnli = (bnli)paramNetResp.mReq.getUserData();
    String str1 = localbnli.e;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramNetResp.mHttpCode);
    }
    Object localObject;
    String str2;
    if (paramNetResp.mHttpCode == 200)
    {
      localObject = bmug.a(localbnli);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = FileUtils.calcMd5((String)localObject);
      if ((localbnli.f == null) || (!localbnli.f.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = bmuk.a(this.a).c(localbnli);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramNetResp.mHttpCode + ",isSuccess:" + bool);
      }
      paramNetResp = ((ArrayList)bmuk.a(this.a).get(str1)).iterator();
      while (paramNetResp.hasNext())
      {
        localObject = (WeakReference)paramNetResp.next();
        if (((WeakReference)localObject).get() != null) {
          ((bmuj)((WeakReference)localObject).get()).a(bool, str1, localbnli);
        }
      }
      FileUtils.delete((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localbnli.f + ",file md5:" + str2);
      }
    }
    bmuk.a(this.a).remove(str1);
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = ((bnli)???.getUserData()).e;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (bmuk.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bmuk.a(this.a).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bmuj)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmul
 * JD-Core Version:    0.7.0.1
 */