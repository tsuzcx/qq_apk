import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bjgu
  implements aysa
{
  bjgu(bjgt parambjgt) {}
  
  public void onResp(aysx arg1)
  {
    bjgs localbjgs = (bjgs)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localbjgs.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    bjgt.a(this.a, localbjgs);
    if ((bjgt.a(this.a).b(localbjgs)) && (bjgt.a(this.a).a(localbjgs))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (bjgt.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)bjgt.a(this.a).remove(localbjgs.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((bjgv)localWeakReference.get()).a(bool, localbjgs.jdField_a_of_type_JavaLangString);
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
  
  public void onUpdateProgeress(aysw arg1, long paramLong1, long paramLong2)
  {
    bjgs localbjgs = (bjgs)???.a();
    synchronized (bjgt.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bjgt.a(this.a).get(localbjgs.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bjgv)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localbjgs.jdField_a_of_type_JavaLangString, localbjgs.jdField_a_of_type_Int);
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
 * Qualified Name:     bjgu
 * JD-Core Version:    0.7.0.1
 */