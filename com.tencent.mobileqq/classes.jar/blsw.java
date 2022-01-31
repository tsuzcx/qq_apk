import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class blsw
  implements bapx
{
  blsw(blsv paramblsv) {}
  
  public void onResp(baqw arg1)
  {
    blsu localblsu = (blsu)???.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + localblsu.jdField_a_of_type_JavaLangString + " http status: " + ???.c);
    }
    blsv.a(this.a, localblsu);
    if ((blsv.a(this.a).b(localblsu)) && (blsv.a(this.a).a(localblsu))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (blsv.a(this.a))
        {
          ArrayList localArrayList = (ArrayList)blsv.a(this.a).remove(localblsu.jdField_a_of_type_JavaLangString);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((blsx)localWeakReference.get()).a(bool, localblsu.jdField_a_of_type_JavaLangString);
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
  
  public void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    blsu localblsu = (blsu)???.a();
    synchronized (blsv.a(this.a))
    {
      Iterator localIterator = ((ArrayList)blsv.a(this.a).get(localblsu.jdField_a_of_type_JavaLangString)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((blsx)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), localblsu.jdField_a_of_type_JavaLangString, localblsu.jdField_a_of_type_Int);
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
 * Qualified Name:     blsw
 * JD-Core Version:    0.7.0.1
 */