import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class boqm
  implements bdvw
{
  boqm(boql paramboql) {}
  
  public void onResp(bdwt arg1)
  {
    boqk localboqk = (boqk)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localboqk.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    boql.a(this.a, localboqk);
    if ((boql.a(this.a).b(localboqk)) && (boql.a(this.a).a(localboqk))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (boql.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)boql.a(this.a).remove(localboqk.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((boqn)localWeakReference.get()).a(bool, localboqk.jdField_a_of_type_JavaLangString);
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
  
  public void onUpdateProgeress(bdws arg1, long paramLong1, long paramLong2)
  {
    boqk localboqk = (boqk)???.a();
    synchronized (boql.a(this.a))
    {
      Iterator localIterator = ((ArrayList)boql.a(this.a).get(localboqk.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((boqn)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localboqk.jdField_a_of_type_JavaLangString, localboqk.jdField_a_of_type_Int);
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
 * Qualified Name:     boqm
 * JD-Core Version:    0.7.0.1
 */