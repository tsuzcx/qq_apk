import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bolf
  implements INetEngine.INetEngineListener
{
  bolf(bole parambole) {}
  
  public void onResp(NetResp arg1)
  {
    bold localbold = (bold)???.mReq.getUserData();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localbold.jdField_a_of_type_JavaLangString + " http status: " + ???.mHttpCode);
    }
    bole.a(this.a, localbold);
    if ((bole.a(this.a).b(localbold)) && (bole.a(this.a).a(localbold))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (bole.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)bole.a(this.a).remove(localbold.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((bolg)localWeakReference.get()).a(bool, localbold.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            return;
          }
        }
        i -= 1;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    bold localbold = (bold)???.getUserData();
    synchronized (bole.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bole.a(this.a).get(localbold.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bolg)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localbold.jdField_a_of_type_JavaLangString, localbold.jdField_a_of_type_Int);
        }
      }
    }
    float f = (float)paramLong1 * 100.0F / (float)paramLong2;
    localObject.b = ((int)f);
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResDownloadProgressUpdate url: " + localObject.jdField_a_of_type_JavaLangString + " progress: " + f + " curOffset: " + paramLong1 + " totalLen: " + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolf
 * JD-Core Version:    0.7.0.1
 */