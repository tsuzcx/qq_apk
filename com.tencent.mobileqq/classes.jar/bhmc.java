import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bhmc
  implements axrt
{
  bhmc(bhmb parambhmb) {}
  
  public void onResp(axsq arg1)
  {
    bhma localbhma = (bhma)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localbhma.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    bhmb.a(this.a, localbhma);
    if ((bhmb.a(this.a).b(localbhma)) && (bhmb.a(this.a).a(localbhma))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (bhmb.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)bhmb.a(this.a).remove(localbhma.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((bhmd)localWeakReference.get()).a(bool, localbhma.jdField_a_of_type_JavaLangString);
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
  
  public void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    bhma localbhma = (bhma)???.a();
    synchronized (bhmb.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bhmb.a(this.a).get(localbhma.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bhmd)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localbhma.jdField_a_of_type_JavaLangString, localbhma.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhmc
 * JD-Core Version:    0.7.0.1
 */