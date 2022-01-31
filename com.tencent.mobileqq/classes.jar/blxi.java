import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class blxi
  implements baug
{
  blxi(blxh paramblxh) {}
  
  public void onResp(bavf arg1)
  {
    blxg localblxg = (blxg)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localblxg.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    blxh.a(this.a, localblxg);
    if ((blxh.a(this.a).b(localblxg)) && (blxh.a(this.a).a(localblxg))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (blxh.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)blxh.a(this.a).remove(localblxg.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((blxj)localWeakReference.get()).a(bool, localblxg.jdField_a_of_type_JavaLangString);
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
  
  public void onUpdateProgeress(bave arg1, long paramLong1, long paramLong2)
  {
    blxg localblxg = (blxg)???.a();
    synchronized (blxh.a(this.a))
    {
      Iterator localIterator = ((ArrayList)blxh.a(this.a).get(localblxg.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((blxj)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localblxg.jdField_a_of_type_JavaLangString, localblxg.jdField_a_of_type_Int);
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
 * Qualified Name:     blxi
 * JD-Core Version:    0.7.0.1
 */