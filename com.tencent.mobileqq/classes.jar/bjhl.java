import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class bjhl
  implements aysc
{
  bjhl(bjhk parambjhk) {}
  
  public void onResp(aysz arg1)
  {
    bjhj localbjhj = (bjhj)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localbjhj.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    bjhk.a(this.a, localbjhj);
    if ((bjhk.a(this.a).b(localbjhj)) && (bjhk.a(this.a).a(localbjhj))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (bjhk.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)bjhk.a(this.a).remove(localbjhj.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((bjhm)localWeakReference.get()).a(bool, localbjhj.jdField_a_of_type_JavaLangString);
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
  
  public void onUpdateProgeress(aysy arg1, long paramLong1, long paramLong2)
  {
    bjhj localbjhj = (bjhj)???.a();
    synchronized (bjhk.a(this.a))
    {
      Iterator localIterator = ((ArrayList)bjhk.a(this.a).get(localbjhj.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((bjhm)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localbjhj.jdField_a_of_type_JavaLangString, localbjhj.jdField_a_of_type_Int);
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
 * Qualified Name:     bjhl
 * JD-Core Version:    0.7.0.1
 */